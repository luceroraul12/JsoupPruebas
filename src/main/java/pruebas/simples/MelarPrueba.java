package pruebas.simples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MelarPrueba {

    public static void main(String[] args) throws IOException {



        Document doc = Jsoup.connect("https://listadepreciosmelar.com.ar/").get();

        System.out.printf("title: %s\n", doc.title());

        Elements repositoies = doc.select("tbody");

        System.out.println(repositoies);

        for (Element repo : repositoies){
            String repoTitle = repo.getElementsByClass("odd").text();


            System.out.println(repoTitle);
        }



    }


}
