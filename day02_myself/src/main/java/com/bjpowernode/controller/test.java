package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import org.junit.Test;
import com.bjpowernode.service.StuService;
import com.bjpowernode.service.impl.StuServiceimpl;
import com.bjpowernode.util.ProxyFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:whr 2019/8/27
 */
public class test {
    @Test // insertStu
    public void insertStu() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        int flag = proxyInstance.insertStu(new Student("A0011", "黄志敏", 17));
        System.out.println(flag);
    }

    @Test
    public void daleteById() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        int flag = proxyInstance.deleteById("A0011");
        System.out.println(flag);
    }

    @Test
    public void selectAll() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        List<Student> students = proxyInstance.selectAll();
        System.out.println("----------------------------------------------------");
        students.forEach(System.out::println);
    }

    @Test // 模糊查询封装为List<String>
    public void selectLikeName1() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        List<String> nameList = proxyInstance.selectLikeName1("王");
        System.out.println("----------------------------------------------------");
        nameList.forEach(System.out::println);
    }

    @Test // 模糊查询封装为List<Student>
    public void selectLikeName2() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        List<Student> stuList = proxyInstance.selectLikeName2("王");
        System.out.println("----------------------------------------------------");
        stuList.forEach(System.out::println);
    }

    @Test // 用Map封装查询参数
    public void selectStu() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "李二狗");
        map.put("age", 23);
        List<Student> students = proxyInstance.selectStu(map);
        students.forEach(System.out::println);
    }

    @Test // 查询所有学生(返回值为Map)
    public void selectAll2() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        List<Map<String, Object>> maps = proxyInstance.selectAll2();
        System.out.println("----------------------------------");
//        maps.forEach((map) -> {
//            Set<Map.Entry<String, Object>> entries = map.entrySet();
//            entries.forEach((entry) -> {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            });
//            System.out.println("----------------------------------");
//        });
        maps.forEach(System.out::println);

    }

    @Test // 查询所有学生(sql语句的 返回值 用 resultMap 处理一下)
    public void selectAll3() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StuServiceimpl.class);
        List<Student> students = proxyInstance.selectAll3();
        students.forEach(System.out::println);
    }

}
