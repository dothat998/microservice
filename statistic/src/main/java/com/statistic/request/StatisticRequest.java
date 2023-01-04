package com.statistic.request;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class StatisticRequest {
    private Long id;

    private String message;

    private Date createDate;
}
