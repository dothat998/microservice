package com.sib.co.dto;


import com.sib.co.base.BaseObj;

import java.util.Map;

public class BaseDto extends BaseObj {

    private Integer currentPage;
    private Integer pageSize;
    private String sortName;
    private String sortType;
    private String sqlQuery;
    private Map<String, Object> parameters;
    private Integer totalRow;
    private Integer indexRow;

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(Integer indexRow) {
        this.indexRow = indexRow;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public BaseDto() {
    }

    public BaseDto(Integer currentPage, Integer pageSize, String sortName, String sortType, String sqlQuery, Map<String, Object> parameters) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.sortName = sortName;
        this.sortType = sortType;
        this.sqlQuery = sqlQuery;
        this.parameters = parameters;
    }
}
