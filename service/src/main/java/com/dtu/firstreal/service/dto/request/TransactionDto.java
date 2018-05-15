package com.dtu.firstreal.service.dto.request;

import java.util.Date;

public class TransactionDto {
    private String customerId;
    private String projectDetailId;
    private Date dateCreate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(String projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
