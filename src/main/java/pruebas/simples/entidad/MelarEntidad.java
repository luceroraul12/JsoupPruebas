package pruebas.simples.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MelarEntidad {
    private String producto;
    //son precios que no tienen en cuenta el iva
    private Double precioFraccionado;
    private Double precioGranel;

}
