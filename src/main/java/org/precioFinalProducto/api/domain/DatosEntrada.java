package org.precioFinalProducto.api.domain;

import lombok.Data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DatosEntrada implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @JsonProperty("fechaAplicacion")
    private String fechaAplicacion;

    @NotBlank(message = "El ID del producto es obligatorio")
    @JsonProperty("idProducto")
    private String idProducto;

    @NotBlank(message = "El ID de la cadena es obligatorio")
    @JsonProperty("idCadena")
    private String idCadena;
}
