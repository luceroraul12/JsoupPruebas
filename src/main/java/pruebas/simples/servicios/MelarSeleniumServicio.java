package pruebas.simples.servicios;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pruebas.simples.entidad.MelarEntidad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MelarSeleniumServicio extends ScrapperTablaAbstract {

    public MelarSeleniumServicio() {
        setUrlBuscador("https://listadepreciosmelar.com.ar");
    }

    @Override
    protected Document generarDocument() throws IOException {
        System.setProperty("webdriver.edge.driver","C:\\selenium\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get(getUrlBuscador());
        String template = driver.getPageSource();
        driver.close();

        return Jsoup.parse(template);
    }

    @Override
    protected Elements generarElementosProductos(Document doc) {
        return doc.getElementsByTag("table")
                .select("table > tbody > tr:not(.group)");
    }

    @Override
    protected void trabajarProductos(Elements productos) {

        List<String> renglon = new ArrayList<>();


        productos.forEach(p -> {
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



            agregarProducto(MelarEntidad.builder()
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

        setContadorPaginasVacias(10);

    }
}
