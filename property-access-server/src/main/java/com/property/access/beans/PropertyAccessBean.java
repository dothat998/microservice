package com.property.access.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
* @author: ThatND
* @since: 7/4/2023 4:08 PM
* @description:  Quyen truy cap access - tự động load và nạp các giá trị vào các biến sau khi Spring khởi động
* @update:
*
* */
@Component
// Chỉ lấy các config có tiền tố là "property-file"
@ConfigurationProperties(prefix="property-file")
//annotation này đánh dấu class bên dưới nó là properties, các thuộc tính sẽ được tự động nạp vào khi Spring khởi tạo.
public class PropertyAccessBean {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}