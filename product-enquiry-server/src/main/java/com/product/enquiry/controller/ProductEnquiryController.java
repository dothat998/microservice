package com.product.enquiry.controller;

import com.product.enquiry.dto.ProductEnquiryDTO;
import com.product.enquiry.feignclient.ProductStockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-enquiry")
public class ProductEnquiryController {

    @Autowired
    ProductStockClient client;


    @GetMapping("/name/{name}/availability/{availability}/unit/{unit}")
    public ProductEnquiryDTO getEnquiryOfProduct(@PathVariable String name,
                                                 @PathVariable String availability,
                                                 @PathVariable int unit) {


        ProductEnquiryDTO productEnquiryBean = client.checkProductStock(name, availability);

        double totalPrice = productEnquiryBean.getProductPrice().doubleValue() * unit;
        double discounts = productEnquiryBean.getDiscountOffer();
        double discountPrice = totalPrice - totalPrice * discounts / 100;


        return new ProductEnquiryDTO(
                productEnquiryBean.getId(),
                name,
                productEnquiryBean.getProductPrice(),
                availability,
                productEnquiryBean.getDiscountOffer(),
                unit,
                discountPrice,
                productEnquiryBean.getPort()

        );

    }

    @GetMapping
    public String abc(){
        return "abc";
    }
}