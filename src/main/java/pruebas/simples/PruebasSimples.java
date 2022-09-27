package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PruebasSimples {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://listadepreciosmelar.com.ar/").get();
        Elements cuerpo = doc.getElementsByTag("script");
        cuerpo.forEach(
                script -> {
                    String resultado = script.data();
                    if (resultado.contains("data")){
                        System.out.println("incluye data");
                        for (String linea: resultado.split(";")
                             ) {
                            if (linea.contains("var data =")){
                                System.out.println(linea);
                            }
                        }
                    }
                }
        );







    }

}
