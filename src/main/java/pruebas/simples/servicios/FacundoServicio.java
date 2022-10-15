package pruebas.simples.servicios;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.fit.pdfdom.PDFDomTree;
import org.fit.pdfdom.PDFToHTML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FacundoServicio {

    public void mostrarContenido() throws IOException {
        File file = new File("src/main/resources/facundo.pdf");
//        PDDocument doc = PDDocument.load(file);
//        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//        stripper.setSortByPosition(true);
//        PDFTextStripper tStripper = new PDFTextStripper();
//        String pdfFileInText = tStripper.getText(doc);
//        System.out.println(pdfFileInText);
//        Document doc = Jsoup.parse(file,);
//        System.out.println(doc);
        Document doc = Jsoup.parse(new FileInputStream(file),"UTF-8","");

        System.out.println(doc);



    }


}
