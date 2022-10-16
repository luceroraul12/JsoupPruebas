package pruebas.simples.servicios;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PruebaServicio {
    private String valorFusionado;

    public void mostrarExcel() throws IOException {
        File file = new File("src/main/resources/Prueba.xls");
        FileInputStream fs = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(fs);
        Sheet sheet = workbook.getSheetAt(0);



        sheet.forEach( row -> {
            row.forEach(cell -> {
                expandirValorDeCeldasFusionadas(sheet, cell);
                aplicarFormula(cell);


                System.out.print(cell+"\t");
            });
            System.out.println();
        });
    }

    private void expandirValorDeCeldasFusionadas(Sheet sheet, Cell celda) {
        sheet.getMergedRegions().forEach(
                rango -> {
                    Cell celdaUnica = sheet.getRow(rango.getFirstRow()).getCell(rango.getFirstColumn());
                    if (rango.isInRange(celda)){
                        celda.setCellValue(celdaUnica.getStringCellValue());
                    }
                }
        );
    }

    private void aplicarFormula(Cell celda) {
        try {
            celda.removeFormula();
        } catch (IllegalStateException e) {
        }
    }

}
