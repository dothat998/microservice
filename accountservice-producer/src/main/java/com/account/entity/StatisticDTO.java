package com.account.entity;

import java.util.Date;

/*
* @author: ThatND
* @since: 21/2/2023 4:24 PM
* @description:  Thống kê
* @update:
*
* */

public class StatisticDTO {
    private String message;
    private Date createdDate;

    public StatisticDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public StatisticDTO(String message, Date createdDate) {
        this.message = message;
        this.createdDate = createdDate;
    }

    public StatisticDTO(String message) {
        this.message = message;
    }
}
