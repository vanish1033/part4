package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author:whr 2019/8/27
 */
public class ProxyFactory {

    public static Object getProxyInstance(Class aClass) {

        Object o = null;
        try {
            o = aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Object finalO = o;
        Object proxyInstance = Proxy.newProxyInstance(aClass.getClassLoader(),
                aClass.getInterfaces(),
                (proxy, method, args) -> {
                    Object invoke = null;
                    SqlSession sqlSession = null;
                    try {
                        sqlSession = SqlSessionUtil.getSqlSession();
                        invoke = method.invoke(finalO, args);
                        sqlSession.commit();
                    } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                        sqlSession.rollback();
                        e.printStackTrace();
                    } finally {
                        SqlSessionUtil.closeSqlSession(sqlSession);
                    }
                    return invoke;

                });
        return proxyInstance;

    }

}
