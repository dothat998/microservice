package com.product.stock.repository;

import com.product.stock.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock,Long> {

    //productAvailability - san pham co san
    ProductStock findByProductNameAndProductAvailability(String productName, String productAvailability);
}
