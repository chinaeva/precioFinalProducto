package org.precioFinalProducto.data.repository;


import org.precioFinalProducto.data.entity.PricesEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Integer> {
}
