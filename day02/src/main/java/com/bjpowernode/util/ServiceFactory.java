package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author:whr 2019/8/27
 */
public class ServiceFactory {

    public static Object getProxyInstance(Class aClass) throws Exception {
        Object o = aClass.newInstance();

        //<editor-fold desc="动态代理方法">
        Object proxy = Proxy.newProxyInstance(aClass.getClassLoader(),
                aClass.getInterfaces(),
                (proxy1, method, args) -> {
                    Object invoke = null;
                    SqlSession sqlSession = null;
                    try {
                        sqlSession = sqlSessionUtil.getSqlSession();
                        invoke = method.invoke(o, args);
                        sqlSession.commit();
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        sqlSession.rollback();
                        e.printStackTrace();
                    } finally {
                        sqlSessionUtil.closeSession(sqlSession);
                    }
                    return invoke;
                });
        //</editor-fold>

        return proxy;
    }
}
