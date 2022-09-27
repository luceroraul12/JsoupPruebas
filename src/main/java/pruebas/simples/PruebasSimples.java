package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PruebasSimples {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://listadepreciosmelar.com.ar/").get();








    }

}
