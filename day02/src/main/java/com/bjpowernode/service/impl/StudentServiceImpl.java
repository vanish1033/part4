package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.sqlSessionUtil;

import java.util.List;

/**
 * @author:whr 2019/8/27
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = sqlSessionUtil.getSqlSession().getMapper(StudentDao.class);

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public Student selectById(String id) {
        return studentDao.selectOne(id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertOne(student);
    }
}
