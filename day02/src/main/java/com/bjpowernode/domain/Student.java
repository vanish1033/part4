package com.bjpowernode.domain;

import lombok.Data;

/**
 * @author:whr 2019/8/27
 */
@Data
public class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}
