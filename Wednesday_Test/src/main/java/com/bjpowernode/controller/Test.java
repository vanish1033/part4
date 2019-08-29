package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StuService;
import com.bjpowernode.service.impl.StudentServiceimpl;
import com.bjpowernode.util.ProxyFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:whr 2019/8/28
 */
public class Test {

    @org.junit.Test
    public void insertStu() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        int flag = proxyInstance.insertStu(new Student("A0013", "黄志敏", 20, "C0003"));
        System.out.println(flag);
    }

    @org.junit.Test
    public void updateStu() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        int flag = proxyInstance.updateStu(new Student("A0011", "杨正", 20, "C0002"));
        System.out.println(flag);
    }

    @org.junit.Test
    public void selectAll() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        List<Map> maps = proxyInstance.selectAll();
        System.out.println("---------------------------------------------");
//        maps.forEach(System.out::println);
        for (Map map : maps) {
            Set set = map.keySet();
            for (Object key : set) {
                System.out.println(key + ":" + map.get(key));
            }
            System.out.println("---------------------");
        }
    }

    @org.junit.Test
    public void selectAll3() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        List<Student> students = proxyInstance.selectAll3();
        System.out.println("---------------------------------------------");
        students.forEach(System.out::println);
    }

    @org.junit.Test
    public void selectById() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        Student a0011 = proxyInstance.selectById("A0011");
        System.out.println(a0011);
    }

    @org.junit.Test // 用map传参
    public void selectStu() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        HashMap map = new HashMap();
        map.put("name", "赵杰");
        map.put("age", 19);
        List slist = proxyInstance.selectStu(map);
        slist.forEach(System.out::println);
    }

    @org.junit.Test
    public void selectAll2() {
        StuService proxyInstance = (StuService) ProxyFactory.getProxyInstance(StudentServiceimpl.class);
        List<Map<String, Object>> maps = proxyInstance.selectAll2();
        maps.forEach(System.out::println);
    }

/*    @org.junit.Test
    public void test1() {
        W:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + "  " + j);
                if (j == 4 && i == 4) {
                    break W;
                }
            }
        }
    }

    @org.junit.Test
    public void test2() {
        String str = "1";
        for (; ; ) {
            str += "1";
        }
    }*/

}
