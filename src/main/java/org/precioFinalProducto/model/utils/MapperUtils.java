package org.precioFinalProducto.model.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.precioFinalProducto.api.domain.DatosEntrada;
import org.precioFinalProducto.api.domain.DatosSalida;
import org.precioFinalProducto.data.entity.PricesEntity;
import org.precioFinalProducto.model.dto.PricesDTO;

@Mapper(componentModel = "spring")
public interface MapperUtils {


    MapperUtils INSTANCE = Mappers.getMapper(MapperUtils.class);

    @Mapping(target = "idProducto", source = "idProducto")
    @Mapping(target = "idCadena", source = "idCadena")
    @Mapping(target = "tarifa", source = "tarifa")
    @Mapping(target = "fechaAplicacion", source = "fechaAplicacion", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @Mapping(target = "precioFinal", source = "precioFinal")
    DatosSalida pricesDTOToDatosSalida(PricesDTO pricesDTO);

    @Mapping(source = "idProducto", target = "idProducto")
    @Mapping(source = "idCadena", target = "idCadena")
    @Mapping(source = "fechaAplicacion", target = "fechaAplicacion", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Mapping(target = "tarifa", ignore = true)
    @Mapping(target = "precioFinal", ignore = true)
    PricesDTO datosEntradaToPricessDTO(DatosEntrada datosEntrada);

    @Mapping(source = "productId", target = "idProduct")
    @Mapping(source = "brandId", target = "idCadena")
    @Mapping(source = "price", target = "tarifa")
    @Mapping(source = "price", target = "finalPriceString")
    PricesDTO pricesEntityToPricesDTO(PricesEntity pricesEntity);

    @Named("finalPriceString")
    default String finalPriceString(Double price, String curr){
        StringBuilder finalPrice = new StringBuilder();
        finalPrice.append(price);
        finalPrice.append(curr);
        return finalPrice.toString();
    }

    @Mapping(source = "productId", target = "idProduct")
    @Mapping(source = "brandId", target = "idCadena")
    @Mapping(source = "price", target = "tarifa")
    @Mapping(source = "price", target = "finalPriceString")
    PricesEntity pricesDTOToPricesEntity(PricesDTO expectedResponse);
}
