package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pruebas.simples.entidad.MelarEntidad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MelarPrueba {

    public static void main(String[] args) throws IOException {


        List<List<String>> arregloProductos = new ArrayList<>();
        List<MelarEntidad> arreglosConvertidos = new ArrayList<>();
        List<String> producto = new ArrayList<>();

        System.setProperty("webdriver.edge.driver","C:\\selenium\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://listadepreciosmelar.com.ar");

        Document doc = Jsoup.parse(driver.getPageSource());
        driver.close();

        System.out.printf("title: %s\n", doc.title());

//        Obtengo tablas
        Elements tablas = doc.getElementsByTag("table");
//        Obtengo renglones de tablas que no contengan la clase group que es la categoria de los productos y no un producto en sí
        Elements renglonesDeProductos = tablas.select("table > tbody > tr:not(.group)");

        List<String> renglon = new ArrayList<>();



        renglonesDeProductos.forEach(p -> {
            System.out.println();
            Elements partes = p.getElementsByTag("td");
            renglon.clear();
            partes.forEach(td -> {
                renglon.add(td.text());
            });
            double precioFraccionado;
            double precioGranel;

            try{
                precioFraccionado = Double.parseDouble(renglon.get(6)
                        .replaceAll("\\.","")
                        .replaceAll(",","."));
            } catch (Exception e){
                precioFraccionado = 0.0;
            }

            try{
                precioGranel = Double.parseDouble(renglon.get(7)
                        .replaceAll("\\.","")
                        .replaceAll(",","."));
            } catch (Exception e){
                precioGranel = 0.0;
            }

            arreglosConvertidos.add(MelarEntidad.builder()
                    .codigo(renglon.get(0))
                    .producto(renglon.get(1))
                    .fraccion(renglon.get(2))
                    .granel(renglon.get(3))
                    .origen(renglon.get(4))
                    .medida(renglon.get(5))
                    .precioFraccionado(precioFraccionado)
                    .precioGranel(precioGranel)
                    .build());
        });

        arreglosConvertidos.forEach(System.out::println);

    }



    private static MelarEntidad convertirStringToMelar(List<String> producto){
        int tamaño = producto.size();
        double precioFraccionado = 0.0;
        double precioGranel = 0.0;
        String nombre = producto.get(2);
        try {
            precioFraccionado = Double.parseDouble(producto.get(tamaño-2));
        } catch (Exception e) {
            precioFraccionado = 0.0;
        }
        try {
            precioGranel = Double.parseDouble(producto.get(tamaño-1));
        } catch (Exception e){
            precioGranel = 0.0;
        }



        return MelarEntidad
                .builder()
                .producto(nombre)
                .precioFraccionado(precioFraccionado)
                .precioGranel(precioGranel)
                .build();
    }


}
