package pruebas.simples.servicios;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ScrapperTablaAbstract<Entidad> {

    private String clasesTabla;
    private String clasesNombreProducto;
    private String clasesPrecio;
    private String urlBuscador;
    private Integer contador;
    private Integer contadorPaginasVacias;
    private List<Entidad> productosRecolectados;



    private void recolectarProductos() throws IOException {
        reiniciar();
        while (this.contadorPaginasVacias <= 2){
            Document document = Jsoup.connect(generarSiguienteUrl()).get();
            Elements productos = document.getElementsByClass(clasesTabla);
            if (productos.size() == 0){
                contadorPaginasVacias++;
            }
            contador++;
            trabajarProductos(productos);


        }

    }

    protected abstract void trabajarProductos(Elements productos);


    private void reiniciar(){
        this.contador = 0;
        this.contadorPaginasVacias = 0;
        this.productosRecolectados = new ArrayList<>();
    }

    protected void agregarProducto(Entidad producto){
        this.productosRecolectados.add(producto);
    }

    public String generarSiguienteUrl(){
        return this.urlBuscador + this.contador;
    }


    public List<Entidad> getProductosRecolectados() throws IOException {
        recolectarProductos();
        return this.productosRecolectados;
    }

    public void setClasesTabla(String clasesTabla) {
        this.clasesTabla = clasesTabla;
    }

    public void setClasesNombreProducto(String clasesNombreProducto) {
        this.clasesNombreProducto = clasesNombreProducto;
    }

    public void setClasesPrecio(String clasesPrecio) {
        this.clasesPrecio = clasesPrecio;
    }

    public void setUrlBuscador(String urlBuscador) {
        this.urlBuscador = urlBuscador;
    }

    public String getClasesTabla() {
        return this.clasesTabla;
    }

    public String getClasesNombreProducto() {
        return this.clasesNombreProducto;
    }

    public String getClasesPrecio() {
        return this.clasesPrecio;
    }
}
