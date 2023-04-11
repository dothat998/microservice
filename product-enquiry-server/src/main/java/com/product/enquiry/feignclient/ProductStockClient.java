package com.product.enquiry.feignclient;

import com.product.enquiry.dto.ProductEnquiryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="product-stock-service", url="localhost:8800")
@FeignClient(name="product-stock-service")
//config in application ribbon
public interface ProductStockClient {
    @GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
    public ProductEnquiryDTO checkProductStock(@PathVariable("productName") String productName,
                                               @PathVariable("productAvailability") String productAvailability);

}
