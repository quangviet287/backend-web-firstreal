package com.dtu.firstreal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private Employee idEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer idCustomer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project_detail")
    private ProjectDetail idProjectDetail;

    @Column(name = "date_create")
    private Date dateCreate;

    public Bill() {
    }

    public Bill(Employee idEmployee, Customer idCustomer, ProjectDetail idProjectDetail, Date dateCreate) {
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idProjectDetail = idProjectDetail;
        this.dateCreate = dateCreate;
    }

    public String getId() {
        return id;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public ProjectDetail getIdProjectDetail() {
        return idProjectDetail;
    }

    public void setIdProjectDetail(ProjectDetail idProjectDetail) {
        this.idProjectDetail = idProjectDetail;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
