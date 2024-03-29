package com.product.stock.controller;


import com.product.stock.dto.ProductStockDTO;
import com.product.stock.entity.ProductStock;
import com.product.stock.repository.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductStockController {

    @Autowired
    Environment environment;

    @Autowired
    ProductStockRepository repository;

    @GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
    public ProductStockDTO checkProductStock(@PathVariable String productName,
                                             @PathVariable String productAvailability)
    {

        ProductStock productStock=repository.findByProductNameAndProductAvailability(productName,productAvailability);

        ProductStockDTO productStockBean=new ProductStockDTO(
                productStock.getId(),
                productStock.getProductName(),
                productStock.getProductPrice(),
                productStock.getProductAvailability(),
                productStock.getDiscountOffer(),
                Integer.parseInt(environment.getProperty("local.server.port"))
        );

        return productStockBean;
    }


}