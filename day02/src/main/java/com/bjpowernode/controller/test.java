package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import org.junit.Test;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

import java.util.List;

/**
 * @author:whr 2019/8/27
 */
public class test {
    @Test // 查询所有
    public void selectAllTest() throws Exception {
        StudentService proxyInstance = (StudentService) ServiceFactory.getProxyInstance(StudentServiceImpl.class);
        List<Student> students = proxyInstance.selectAll();
        students.forEach(System.out::println);
    }

    @Test // 通过id查询一个
    public void selectById() throws Exception {
        StudentService proxyInstance = (StudentService) ServiceFactory.getProxyInstance(StudentServiceImpl.class);
        Student a0003 = proxyInstance.selectById("A0003");
        System.out.println(a0003);
    }

    @Test // 插入一个
    public void insertStudent() throws Exception {
        StudentService proxyInstance = (StudentService) ServiceFactory.getProxyInstance(StudentServiceImpl.class);
        int flag = proxyInstance.insertStudent(new Student("A0009", "胡苑", 18));
        System.out.println(flag);
    }
}
