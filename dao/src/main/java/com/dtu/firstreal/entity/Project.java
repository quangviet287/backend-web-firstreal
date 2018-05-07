package com.dtu.firstreal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "project_name")
    private String projectName;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_address")
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "description")
    private String description;

    @Column(name = "image_profile_url")
    private String imageProfileUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_type_id")
    private ProjectType projectType;

    public Project() {
    }

    public Project(String projectName, Address address, String description, String imageProfileUrl, ProjectType idProjectType) {
        this.projectName = projectName;
        this.address = address;
        this.description = description;
        this.imageProfileUrl = imageProfileUrl;
        this.projectType = idProjectType;
    }

    public String getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageProfileUrl() {
        return imageProfileUrl;
    }

    public void setImageProfileUrl(String imageProfileUrl) {
        this.imageProfileUrl = imageProfileUrl;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}
