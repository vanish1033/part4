package com.bjpowernode.domain;

import lombok.Data;

/**
 * @author:whr 2019/8/26
 */
@Data
public class Student {
    private String id;
    private String name;
    private Integer age;

    public Student(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
