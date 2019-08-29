package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StuService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * @author:whr 2019/8/28
 */
public class StudentServiceimpl implements StuService {

    private StudentDao studentDao = null;

    {
        studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
    }

    @Override
    public int insertStu(Student student) {
        return studentDao.insertStu(student);
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public Student selectById(String id) {
        return studentDao.selectById(id);
    }

    @Override
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }

    @Override
    public List<Map> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public List<String> selectLikeName1(String name) {
        return null;
    }

    @Override
    public List<Student> selectLikeName2(String name) {
        return null;
    }

    @Override
    public List<Student> selectStu(Map<String, Object> map) {
        return studentDao.selectStu(map);
    }

    @Override
    public List<Map<String, Object>> selectAll2() {
        return studentDao.selectAll2();
    }

    @Override
    public List<Student> selectAll3() {
        return studentDao.selectAll3();
    }
}
