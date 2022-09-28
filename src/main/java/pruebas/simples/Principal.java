package pruebas.simples;

import pruebas.simples.servicios.SudamerikServicio;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {

        //voy a probar con Sudamerik
        SudamerikServicio sudamerikServicio = new SudamerikServicio();
        sudamerikServicio.getProductosRecolectados().forEach(System.out::println);



    }
}
