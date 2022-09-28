package pruebas.simples;

import pruebas.simples.servicios.LaGranjaDelCentroServicio;
import pruebas.simples.servicios.SudamerikServicio;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {

//        //voy a probar con Sudamerik
//        SudamerikServicio sudamerikServicio = new SudamerikServicio();
//        sudamerikServicio.getProductosRecolectados().forEach(System.out::println);

        //voy a probar con La granja
        LaGranjaDelCentroServicio granjaServicio = new LaGranjaDelCentroServicio();
        granjaServicio.getProductosRecolectados().forEach(System.out::println);


    }
}
