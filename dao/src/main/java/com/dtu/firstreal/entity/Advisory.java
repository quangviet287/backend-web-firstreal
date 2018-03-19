package com.dtu.firstreal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Advisory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "age")
    private String age;

    @Column(name = "sex")
    private boolean sex;

    public Advisory() {
    }

    public Advisory(String age, boolean sex) {
        this.age = age;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
