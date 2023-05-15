package org.precioFinalProducto.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class DatosEntrada implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @JsonProperty("fechaAplicacion")
    private LocalDateTime fechaAplicacion;

    @NotBlank(message = "El ID del producto es obligatorio")
    @JsonProperty("idProducto")
    private String idProducto;

    @NotBlank(message = "El ID de la cadena es obligatorio")
    @JsonProperty("idCadena")
    private String idCadena;
}
