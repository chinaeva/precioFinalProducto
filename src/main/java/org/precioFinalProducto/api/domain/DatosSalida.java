package org.precioFinalProducto.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DatosSalida implements Serializable {

    @JsonProperty("idProducto")
    private String idProducto;

    @JsonProperty("idCadena")
    private String idCadena;

    @JsonProperty("tarifa")
    private String tarifa;

    @JsonProperty("fechaAplicacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date fechaAplicacion;

    @JsonProperty("precioFinal")
    private String precioFinal;

}
