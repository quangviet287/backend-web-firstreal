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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    private Address idAddress;

    @Column(name = "description")
    private String description;

    @Column(name = "image_profile_url")
    private String imageProfileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project_type")
    private ProjectType idProjectType;

    public Project() {
    }

    public Project(String projectName, Address idAddress, String description, String imageProfileUrl, ProjectType idProjectType) {
        this.projectName = projectName;
        this.idAddress = idAddress;
        this.description = description;
        this.imageProfileUrl = imageProfileUrl;
        this.idProjectType = idProjectType;
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

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
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

    public ProjectType getIdProjectType() {
        return idProjectType;
    }

    public void setIdProjectType(ProjectType idProjectType) {
        this.idProjectType = idProjectType;
    }
}
