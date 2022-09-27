package pruebas.simples.entidad;

public class MelarEntidad {
    private String producto;
    //son precios que no tienen en cuenta el iva
    private Double precioFraccionado;
    private Double precioGranel;

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecioFraccionado() {
        return this.precioFraccionado;
    }

    public void setPrecioFraccionado(Double precioFraccionado) {
        this.precioFraccionado = precioFraccionado;
    }

    public Double getPrecioGranel() {
        return this.precioGranel;
    }

    public void setPrecioGranel(Double precioGranel) {
        this.precioGranel = precioGranel;
    }

    @Override
    public String toString() {
        return "MelarEntidad{" +
                "\nproducto='" + producto + '\'' +
                ", \nprecioFraccionado=" + precioFraccionado +
                ", \nprecioGranel=" + precioGranel +
                '}';
    }
}
