package mybatisTest;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:whr 2019/8/26
 */
public class test {

    private static SqlSessionFactory build;

    static {
        String path = "mybatis-config.xml";
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        build = new SqlSessionFactoryBuilder().build(stream);
    }

    @Test // 增 测试
    public void insertTest() {
        SqlSession sqlSession = build.openSession();
        sqlSession.insert("test1.insertOne", new Student("A0008", "炮灰明", 34));
        sqlSession.commit();
    }

    @Test // 删 测试
    public void deleteTest() {
        SqlSession sqlSession = build.openSession();
        sqlSession.delete("test1.deleteOne", "A0008");
        sqlSession.commit();
    }

    @Test // 查单条数据 测试
    public void selectTest1() {
        SqlSession sqlSession = build.openSession();
        Object a0003 = sqlSession.selectOne("test1.selectOne", "A0003");
        System.out.println(a0003);
    }

    @Test // 查所有数据 测试
    public void selectTest2() {
        SqlSession sqlSession = build.openSession();
        List<Object> objects = sqlSession.selectList("test1.selectAll");
        objects.forEach(System.out::println);
    }

    @Test // 修改单条数据 测试
    public void updateTest() {
        SqlSession sqlSession = build.openSession();
        sqlSession.update("test1.updateOne", new Student("A0002", "张彭", 25));
        sqlSession.commit();
    }


}





































