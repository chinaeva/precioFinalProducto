package org.precioFinalProducto.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
public class PricesEntity {

    @Id
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String curr;
}
