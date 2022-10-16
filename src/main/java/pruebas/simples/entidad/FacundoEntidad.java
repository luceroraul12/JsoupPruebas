package pruebas.simples.entidad;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacundoEntidad {
    private String categoria;
    private String subcategoria;
    private String cantidad;
    private Double precioMenor;
    private Double precioMayor;
}
