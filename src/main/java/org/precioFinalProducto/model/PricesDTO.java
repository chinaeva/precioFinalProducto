package org.precioFinalProducto.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PricesDTO {

    private String idProducto;
    private String idCadena;
    private String tarifa;
    private LocalDate fechaAplicacion;
    private String precioFinal;

}
