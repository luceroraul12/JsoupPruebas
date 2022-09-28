package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pruebas.simples.entidad.MelarEntidad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MelarPrueba {

    public static void main(String[] args) throws IOException {


        List<List<String>> arregloProductos = new ArrayList<>();
        List<MelarEntidad> arreglosConvertidos = new ArrayList<>();
        List<String> producto = new ArrayList<>();

        Document doc = Jsoup.connect("https://listadepreciosmelar.com.ar").get();

        System.out.printf("title: %s\n", doc.title());

        Elements soloScripts = doc.getElementsByTag("script");

        for (Element script: soloScripts){
            //obtengo el script que contiene la data
            if (script.toString().contains("var data =")){

                //divido por los finales de linea con ;
                String[] divididoPorPuntoComa = script.toString().split(";");

                Arrays.stream(divididoPorPuntoComa).toList().forEach( linea -> {
                    //identifico linea que tiene la variable data
                    if (linea.contains("var data")){
                        //obtengo arreglo en forma de string
                        System.out.println(linea);
                        Pattern p = Pattern.compile("\\[(.*?)\\]");
                        Matcher m = p.matcher(linea);
                        //trabajando una objeto
                        while (m.find()){
                            producto.clear();
                            System.out.println(m.group(1));
                            Pattern patLinea = Pattern.compile("\\\"(.+?)\\\"|(\\d+\\.?\\d+)");
                            Matcher matLinea = patLinea.matcher(m.group(1));
                            //busco los elementos del objeto

                            while (matLinea.find()){
                                //solo tomo los valores no nulos, debido a que hay muchisimos nulos, no tengo idea del por que
                                String resultado = "";

                                if (matLinea.group(1) != null){
                                    System.out.println(matLinea.group(1));
                                    resultado = matLinea.group(1);
                                } else {
                                    System.out.println(matLinea.group(2));
                                    resultado = matLinea.group(2);
                                }
                                ;
                                producto.add(resultado.replaceAll("\\ +$",""));

                            }
                            arregloProductos.add(producto.stream().toList());
                        }

                    }
                });


                arregloProductos.forEach(p -> {
                    arreglosConvertidos.add(convertirStringToMelar(p));
                });

                arreglosConvertidos.forEach(System.out::println);

            }
        }

    }


    private static MelarEntidad convertirStringToMelar(List<String> producto){
        int tamaño = producto.size();
        MelarEntidad pConvertido = new MelarEntidad();
        pConvertido.setProducto(producto.get(2));
        try {
            pConvertido.setPrecioFraccionado(Double.valueOf(producto.get(tamaño-2)));
        } catch (Exception e) {
            pConvertido.setPrecioFraccionado(0.0);
        }
        try {
            pConvertido.setPrecioGranel(Double.valueOf(producto.get(tamaño-1)));
        } catch (Exception e){
            pConvertido.setPrecioGranel(0.0);
        }

        return pConvertido;
    }


}
