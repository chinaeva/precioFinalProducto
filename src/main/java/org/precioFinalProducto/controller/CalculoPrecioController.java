package org.precioFinalProducto.controller;

import org.precioFinalProducto.api.CalculoPrecioApi;
import org.precioFinalProducto.api.domain.DatosEntrada;
import org.precioFinalProducto.api.domain.DatosSalida;
import org.precioFinalProducto.model.utils.MapperUtils;
import org.precioFinalProducto.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculoPrecioController implements CalculoPrecioApi {

    @Autowired
    PricesService pricesService;

    @Override
    public ResponseEntity<DatosSalida> calcularPrecioFinal(DatosEntrada datosEntrada) {

        DatosSalida datosSalida = MapperUtils.INSTANCE.pricesDTOToDatosSalida(pricesService.calcularPrecio(MapperUtils.INSTANCE.datosEntradaToPricessDTO(datosEntrada)));

        return ResponseEntity.ok(datosSalida);
    }
}
