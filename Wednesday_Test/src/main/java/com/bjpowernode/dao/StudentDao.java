package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * @author:whr 2019/8/28
 */
public interface StudentDao {

    // 增
    int insertStu(Student student);

    // 删
    int deleteById(String id);

    // 查
    Student selectById(String id);

    // 改
    int updateStu(Student student);

    // 查所有
    List<Map> selectAll();

    // 使用like模糊查询名字  返回List<String>
    List<String> selectLikeName1(String name);

    // 使用like模糊查询名字  返回List<Student>
    List<Student> selectLikeName2(String name);

    // 用Map传值查人
    List<Student> selectStu(Map<String, Object> map);

    // 查询所有学生(返回值为Map)
    List<Map<String, Object>> selectAll2();

    // 查询所有学生(sql语句的 返回值 用 resultMap 处理一下)
    List<Student> selectAll3();
}
