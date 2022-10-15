package pruebas.simples.servicios;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import pruebas.simples.entidad.IndiasEntidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class IndiasServicio {

    public void mostrarExcel() throws IOException {
        File file = new File("src/main/resources/Indias.xls");
        FileInputStream fs = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(fs);
        Sheet sheet = workbook.getSheetAt(0);
        Collection<IndiasEntidad> productos = new ArrayList<>();

        sheet.forEach( row -> {
            if (row.getRowNum() > 3){
                if (row.getCell(1) != null) {
                    if (row.getCell(1).toString() != ""){
                        productos.add(
                                mapearRow(row)
                        );
                    }
                }
            }
        });
        productos.forEach(System.out::println);
    }

    private IndiasEntidad mapearRow(Row row){
        return IndiasEntidad.builder()
                .rubro(row.getCell(1).toString())
                .codigo((int) row.getCell(2).getNumericCellValue())
                .descripcion(row.getCell(3).toString())
                .precio(row.getCell(4).getNumericCellValue())
                .build();
    }
}
