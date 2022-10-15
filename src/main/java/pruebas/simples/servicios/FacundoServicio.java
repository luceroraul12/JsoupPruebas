package pruebas.simples.servicios;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class FacundoServicio {

    public void mostrarHTML() throws IOException {
        File file = new File("src/main/resources/facundo.pdf");

        Document doc = Jsoup.parse(file);

        System.out.println(doc);


    }


}
