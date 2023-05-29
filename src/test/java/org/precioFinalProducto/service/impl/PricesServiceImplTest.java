package org.precioFinalProducto.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.precioFinalProducto.data.repository.PricesRepository;
import org.precioFinalProducto.model.dto.PricesDTO;
import org.precioFinalProducto.model.utils.MapperUtils;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PricesServiceImplTest {

    @Mock
    private PricesRepository pricesRepository;

    private PricesServiceImpl pricesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pricesService = new PricesServiceImpl(pricesRepository);
    }

    @Test
    public void testCalcularPrecio() {
        // Datos de prueba
        PricesDTO inputPricesDTO = new PricesDTO();
        inputPricesDTO.setIdCadena("1");
        inputPricesDTO.setIdProducto("123");
        inputPricesDTO.setFechaAplicacion(LocalDateTime.of(2023, 5, 29, 0, 0));

        PricesDTO expectedResponse = new PricesDTO();
        expectedResponse.setFechaAplicacion(LocalDateTime.of(2023, 5, 29, 0, 0));

        // Configuración del mock
        when(pricesRepository.findByIdProductoIdCadenaFechaAplicacion(1, "123", "2023-05-29"))
                .thenReturn(MapperUtils.INSTANCE.pricesDTOToPricesEntity(expectedResponse));

        // Ejecutar el método a probar
        PricesDTO actualResponse = pricesService.calcularPrecio(inputPricesDTO);

        // Verificar el resultado
        assertEquals(expectedResponse, actualResponse);
    }
}
