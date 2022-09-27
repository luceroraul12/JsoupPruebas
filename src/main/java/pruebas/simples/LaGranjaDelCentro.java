package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class LaGranjaDelCentro {

    public static void main(String[] args) throws IOException {

        int contador = 0;
        String url = "https://lagranjadelcentro.com.ar/productos.php?pagina=";

        contador++;
        String siguienteUrl = adaptarUrl(url, contador);

        while (true){
            Document doc = Jsoup.connect(siguienteUrl).get();

            Elements productos = doc.getElementsByClass("box-content-1");

            productos.forEach( producto -> {
                String nombre = producto.getElementsByClass("h3-content-1").text();
                String precio = producto.getElementsByClass("p-precio-content-1").text();


                System.out.println(nombre + " - " + precio);
            });

            contador++;
            siguienteUrl = adaptarUrl(url, contador);
        }


//        while(true){
//
//
//            Document doc = Jsoup.connect(siguienteUrl).get();
//
//            System.out.printf("title: %s\n", doc.title());
//
//            Elements productos = doc.getElementsByClass("productos-container");
//
//            productos.forEach( producto -> {
//                String nombre = producto.getElementsByClass("nombre").text();
//                String precio = producto.getElementsByClass("precio").text();
//                System.out.println(nombre + " - " + precio);
//            });
//
//            contador++;
//            siguienteUrl = adaptarUrl(url, contador);
//
//
//        }







    }

    private static String adaptarUrl(String url, int contador){
        String nuevaUrl = url + contador;
        return nuevaUrl;
    }

}
