package com.bjpowernode.domain;

import lombok.Data;

/**
 * @author:whr 2019/8/28
 */
@Data
public class Student {
    private String id;
    private String name;
    private Integer age;
    private String classId;

    public Student(String id, String name, Integer age, String classId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classId = classId;
    }

    public Student() {
    }
}
