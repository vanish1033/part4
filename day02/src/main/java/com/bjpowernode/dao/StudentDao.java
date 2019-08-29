package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author:whr 2019/8/27
 */
public interface StudentDao {
    Student selectOne(String id);

    List<Student> selectAll();

    int insertOne(Student student);

    int deleteOne(String id);

    int updateOne(Student student);

}
