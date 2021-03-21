package com.chen;

import java.io.Serializable;

public class Teacher {
    private String tName;
    private Integer tAge;

    public Teacher(){}

    public Teacher(String tName, Integer tAge) {
        this.tName = tName;
        this.tAge = tAge;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tName='" + tName + '\'' +
                ", tAge=" + tAge +
                '}';
    }
}
