package com.dtu.firstreal.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class ProjectDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "project_detail_name")
    private String projectDetailName;

    @Column(name = "location")
    private String location;

    @Column(name = "direction")
    private String direction;

    @Column(name = "size")
    private int size;

    @Column(name = "price")
    private String price;

    @Column(name = "state")
    @Nullable
    private boolean state;

    @Column(name = "image_project_detail_url")
    private String imageProjectDetailUrl;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public ProjectDetail() {
    }

    public ProjectDetail(Project project, String projectDetailName, String location, String direction,
                         int size, String price, boolean state, String imageProjectDetailUrl, Employee employee) {
        this.project = project;
        this.projectDetailName = projectDetailName;
        this.location = location;
        this.direction = direction;
        this.size = size;
        this.price = price;
        this.state = state;
        this.imageProjectDetailUrl = imageProjectDetailUrl;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getImageProjectDetailUrl() {
        return imageProjectDetailUrl;
    }

    public void setImageProjectDetailUrl(String imageProjectDetailUrl) {
        this.imageProjectDetailUrl = imageProjectDetailUrl;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
