package pruebas.simples;

import pruebas.simples.servicios.*;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {

//        //voy a probar con Sudamerik
//        SudamerikServicio sudamerikServicio = new SudamerikServicio();
//        sudamerikServicio.getProductosRecolectados().forEach(System.out::println);

//        //voy a probar con La granja
//        LaGranjaDelCentroServicio granjaServicio = new LaGranjaDelCentroServicio();
//        granjaServicio.getProductosRecolectados().forEach(System.out::println);

//            //voy a probar Melar nuevamente
//        MelarServicio melarServicio = new MelarServicio();
//        melarServicio.getProductos().forEach(System.out::println);
//
//        //voy a probar Melar con Selenium;
//        MelarSeleniumServicio melarSeleniumServicio = new MelarSeleniumServicio();
//        melarSeleniumServicio.getProductosRecolectados().forEach(System.out::println);

//
//        DonGasparServicio donGasparServicio = new DonGasparServicio();
//        donGasparServicio.mostrarHTML();


//        FacundoServicio facundoServicio = new FacundoServicio();
//        facundoServicio.mostrarContenido();



        IndiasServicio indiasServicio = new IndiasServicio();
        indiasServicio.mostrarExcel();
    }
}
