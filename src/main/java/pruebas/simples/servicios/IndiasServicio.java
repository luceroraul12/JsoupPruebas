package pruebas.simples.servicios;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class IndiasServicio {
    public void mostrarHTML() throws IOException {
        File file = new File("src/main/resources/dongaspar.html");

        Document doc = Jsoup.parse(file);

        Elements productos = doc.select(".producto_fila");
        productos.forEach( p -> {
            String precio = p.select(".precio-box").text();

            String nombreProducto = p.select(".dfloat-left").text();

            System.out.println(precio.replace("$","")+"\t\t"+nombreProducto);




        });


    }
}
