package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

public class PruebasSimples {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://listadepreciosmelar.com.ar/").get();
        //busco los tag de script
        Elements cuerpo = doc.getElementsByTag("script");
        //recorro cada uno
        cuerpo.forEach(
                script -> {
                    //los almaceno en una variable
                    String resultado = script.data();
                    //como ya ojié el html, la informacion de la tabla se almacena en una variable la linea que puede contener "data"
                    if (resultado.contains("data")){
                        System.out.println("incluye data");
                        //solo quiero leer la linea de var data = []; por lo tanto solo leeré hasta el ";" de final de linea
                        for (String linea: resultado.split(";")
                             ) {
                            //obtengo solo esa linea que tiene la data
                            if (linea.contains("var data =")){
                                //sabiendo que la linea es var data = [arreglo], solo quiero obtener la informacion despues del igual, asi que uso split y divido en funcion de ese simbolo
                                String resultadoCasiArreglo = linea.split("=")[1];
                                resultadoCasiArreglo.
                            }
                        }
                    }
                }
        );







    }

}
