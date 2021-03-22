package com.chen;

import java.io.Serializable;

public class Student implements Serializable {
    private  Teacher teacher ;
    private String sName;
    private String sex;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "teacher=" + teacher +
                ", sName='" + sName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
