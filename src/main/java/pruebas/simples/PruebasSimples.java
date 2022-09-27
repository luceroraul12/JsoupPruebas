package pruebas.simples;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PruebasSimples {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.codetriage.com/?language=Java").get();

        System.out.printf("title: %s\n", doc.title());

        Elements repositoies = doc.getElementsByClass("repo-item");

        for (Element repo : repositoies){
            String repoTitle = repo.getElementsByClass("repo-item-title").text();
            String repoIssues = repo.getElementsByClass("repo-item-issues").text();
            String repoDescription = repo.getElementsByClass("repo-item-description").text();
            String repoGitHubName = repo.getElementsByClass("repo-item-full-name").text();

            String repoGitHubLink = "https://gitjub.com/"+ repoGitHubName.replaceAll("[()]","");

            System.out.println(repoTitle + " - " + repoIssues);
            System.out.println(repoDescription);
            System.out.println(repoGitHubLink);
            System.out.println();
        }















    }

}
