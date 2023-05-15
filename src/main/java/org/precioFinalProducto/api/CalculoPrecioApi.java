package org.precioFinalProducto.api;


import org.precioFinalProducto.api.domain.DatosEntrada;
import org.precioFinalProducto.api.domain.DatosSalida;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface CalculoPrecioApi {

    @PutMapping(value = {"/precioFinal"}, produces = {"aplication/json"}, consumes = {"aplication/json"})
    ResponseEntity<DatosSalida> calcularPrecioFinal(@RequestBody DatosEntrada datosEntrada);
}


