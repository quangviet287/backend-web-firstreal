package com.dtu.firstreal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class ProjectDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private Project idProject;

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
    private boolean state;

    @Column(name = "image_project_detail_url")
    private String imageProjectDetailUrl;


    private String idEmployee;

    public ProjectDetail() {
    }

    public ProjectDetail(Project idProject, String projectDetailName, String location, String direction,
                         int size, String price, boolean state, String imageProjectDetailUrl, String idEmployee) {
        this.idProject = idProject;
        this.projectDetailName = projectDetailName;
        this.location = location;
        this.direction = direction;
        this.size = size;
        this.price = price;
        this.state = state;
        this.imageProjectDetailUrl = imageProjectDetailUrl;
        this.idEmployee = idEmployee;
    }

    public String getId() {
        return id;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
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

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
}
