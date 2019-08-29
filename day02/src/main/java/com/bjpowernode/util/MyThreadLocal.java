package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

/**
 * @author:whr 2019/8/27
 */
public class MyThreadLocal {
    private static ThreadLocal<SqlSession> myThreadLocal = new ThreadLocal<>();

    public static void set(SqlSession sqlSession) {
        myThreadLocal.set(sqlSession);
    }

    public static SqlSession get() {
        return myThreadLocal.get();
    }

    public static void remove() {
        myThreadLocal.remove();
    }
}
