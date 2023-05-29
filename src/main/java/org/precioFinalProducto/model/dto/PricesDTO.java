package org.precioFinalProducto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricesDTO {

    private String idProducto;
    private String idCadena;
    private String tarifa;
    private LocalDateTime fechaAplicacion;
    private String precioFinal;

}
