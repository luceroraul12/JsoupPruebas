package pruebas.simples.servicios;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import pruebas.simples.entidad.FacundoEntidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class FacundoServicio {


    public void mostrarExcel() throws IOException {
        File file = new File("src/main/resources/facundo.xls");
        FileInputStream fs = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(fs);
        Collection<FacundoEntidad> productos = new ArrayList<>();

        workbook.forEach(sheet -> {
            productos.addAll(
                    obtenerProductosProSheet(sheet)
            );
        });




        productos.forEach(System.out::println);



    }

    private Collection<FacundoEntidad> obtenerProductosProSheet(Sheet sheet){
        Collection<FacundoEntidad> productosPorSheet = new ArrayList<>();
        sheet.forEach(r -> {
            r.forEach(c -> expandirValorDeCeldasFusionadas(sheet, c));
            try {
                productosPorSheet.add(
                        FacundoEntidad.builder()
                                .categoria(r.getCell(0).toString())
                                .subcategoria(r.getCell(1).toString())
                                .cantidad(r.getCell(2).toString())
                                .precioMayor(Double.valueOf(r.getCell(3).toString()))
                                .precioMenor(Double.valueOf(r.getCell(4).toString()))
                                .build()
                );
            } catch (Exception e) {

            }
        });
        return productosPorSheet;
    }

    private void expandirValorDeCeldasFusionadas(Sheet sheet, Cell celda) {
        sheet.getMergedRegions().forEach(
                rango -> {
                    Cell celdaUnica = sheet.getRow(rango.getFirstRow()).getCell(rango.getFirstColumn());
                    if (rango.isInRange(celda)){
                        try {
                            celda.setCellValue(celdaUnica.getStringCellValue());
                        } catch (Exception e) {
                            celda.setCellValue(celdaUnica.getNumericCellValue());
                        }
                    }
                }
        );
    }

}
