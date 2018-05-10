package com.dtu.firstreal.service.dto.request;

import java.io.Serializable;

public class AdvisoryDto implements Serializable {

    private String age;
    private Boolean sex;

    public AdvisoryDto() {
    }

    public AdvisoryDto(String age, Boolean sex) {
        this.age = age;
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
