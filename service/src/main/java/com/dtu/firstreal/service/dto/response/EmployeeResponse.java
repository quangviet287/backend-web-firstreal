package com.dtu.firstreal.service.dto.response;

public class EmployeeResponse {
    private String employeeId;

    public EmployeeResponse(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
