package org.precioFinalProducto.data.repository;


import org.precioFinalProducto.data.entity.PricesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Integer> {

    @Query(value = "SELECT * " +
            "FROM PRICES " +
            "WHERE BRAND_ID = ?1 " +
            "  AND PRODUCT_ID = ?2" +
            "  AND ?3 BETWEEN START_DATE AND END_DATE", nativeQuery = true)
    PricesEntity findByIdProductoIdCadenaFechaAplicacion(Integer brandId, String productId, String date);
}
