package com.dtu.firstreal.service.dto.response;

import com.dtu.firstreal.service.dto.request.ImageDto;

public class ProjectDetailDtoResponse {
    private String projectId;
    private String projectName;
    private ImageDto image;
    private String price;
    private String direction;
    private String employeeId;
    private String projectDetailId;
    private String projectDetailName;
    private String location;
    private Boolean state;
    private int size;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(String projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    public String getProjectDetailName() {
        return projectDetailName;
    }

    public void setProjectDetailName(String projectDetailName) {
        this.projectDetailName = projectDetailName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean sate) {
        this.state = sate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
