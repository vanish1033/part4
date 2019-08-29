package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author:whr 2019/8/27
 */
public interface StudentService {
    // 查全部学生
    List<Student> selectAll();

    // 查单个学生
    Student selectById(String id);

    // 新增加一个学生
    int insertStudent(Student student);

}
