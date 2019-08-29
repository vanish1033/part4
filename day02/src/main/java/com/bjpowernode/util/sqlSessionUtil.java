package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:whr 2019/8/27
 */
public class sqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String path = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = MyThreadLocal.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            MyThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
        MyThreadLocal.remove();
    }
}
