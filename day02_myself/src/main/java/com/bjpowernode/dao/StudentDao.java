package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * @author:whr 2019/8/27
 */
public interface StudentDao {

    // 增加一个学生
    int insertStu(Student student);

    // 删除一个学生
    int daleteById(String id);

    //通过id查询一个学生
    Student selectById(String id);

    //更新一个学生
    int updateStu(Student student);

    //查询所有学生
    List<Student> selectAll();

    // 使用like模糊查询名字
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
