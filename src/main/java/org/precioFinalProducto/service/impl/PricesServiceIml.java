package org.precioFinalProducto.service.impl;

import org.precioFinalProducto.data.repository.PricesRepository;
import org.precioFinalProducto.model.dto.PricesDTO;
import org.precioFinalProducto.model.utils.MapperUtils;
import org.precioFinalProducto.service.PricesService;
import org.springframework.stereotype.Service;

@Service
public class PricesServiceIml implements PricesService {

    private final PricesRepository pricesRepository;

    public PricesServiceIml(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public PricesDTO calcularPrecio(PricesDTO pricesDTO) {

       PricesDTO response = MapperUtils.INSTANCE.pricesEntityToPricesDTO(pricesRepository.findByIdProductoIdCadenaFechaAplicacion(Integer.valueOf(pricesDTO.getIdCadena()), pricesDTO.getIdProducto(), String.valueOf(pricesDTO.getFechaAplicacion())));

       response.setFechaAplicacion(pricesDTO.getFechaAplicacion());

        return response;
    }
}
