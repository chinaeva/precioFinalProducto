package org.precioFinalProducto.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.precioFinalProducto.api.domain.DatosEntrada;
import org.precioFinalProducto.model.dto.PricesDTO;
import org.precioFinalProducto.model.utils.MapperUtils;
import org.precioFinalProducto.service.PricesService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
class CalculoPrecioControllerTest {


    @MockBean
    private PricesService pricesService;

    @ParameterizedTest
    @MethodSource("datosEntradaProvider")
    void calcularPrecioFinalTest(DatosEntrada datosEntrada, PricesDTO expectedPriceDTO) throws Exception {
        // Mock de PricesService
        PricesDTO pricesDTO = MapperUtils.INSTANCE.datosEntradaToPricessDTO(datosEntrada);
        when(pricesService.calcularPrecio(pricesDTO)).thenReturn(expectedPriceDTO);


        RestAssuredMockMvc.given()
                .body(datosEntrada)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .log()
                .all()
                .when()
                .put("/precioFinal")
                .then()
                .log()
                .all().statusCode(HttpStatus.OK.value());


    }

    private static Stream<Arguments> datosEntradaProvider() {
        return Stream.of(
                Arguments.of(new DatosEntrada(LocalDateTime.of(2023, 5, 14, 10, 0), "35455", "1"),
                        new PricesDTO("35455", "1", "35,50", LocalDateTime.of(2023, 5, 14, 10, 0), "35,50EUR")),

                Arguments.of(new DatosEntrada(LocalDateTime.of(2023, 5, 14, 16, 0), "35455", "1"),
                        new PricesDTO("35455", "1", "35,50", LocalDateTime.of(2023, 5, 14, 16, 0), "35,50EUR")),

                Arguments.of(new DatosEntrada(LocalDateTime.of(2023, 5, 14, 21, 0), "35455", "1"),
                        new PricesDTO("35455", "1", "35,50", LocalDateTime.of(2023, 5, 14, 21, 0), "35,50EUR")),

                Arguments.of(new DatosEntrada(LocalDateTime.of(2023, 5, 15, 10, 0), "35455", "1"),
                        new PricesDTO("35455", "1", "35,50", LocalDateTime.of(2023, 5, 15, 10, 0), "35,50EUR")),

                Arguments.of(new DatosEntrada(LocalDateTime.of(2023, 5, 16, 21, 0), "35455", "1"),
                        new PricesDTO("35455", "1", "35,50", LocalDateTime.of(2023, 5, 16, 21, 0), "35,50EUR"))
        );
    }
}
