package com.jxau.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @ClassName HibernateUtils
 * @Description 解决每次执行都会创建一个Session的问题，保证从始至终只有一个Session,保证线程安全
 * @Author xie
 * @Date 2019/8/16 20:05
 * @Version 1.0
 */
public class HibernateUtils {
    private static SessionFactory factory;
    static{
        try {
            Configuration configure = new Configuration().configure();
            factory = configure.buildSessionFactory();
        }catch (ExceptionInInitializerError e){
            throw new RuntimeException("初始化失败，检查配置文件是否出错");
        }
    }

    public static Session openSession(){
        return factory.openSession();
    }


    /**
     * @Author xie
     * @Description //从当前线程上获取session,只有在配置文件中配置了Session和线程绑定，才能使用此方法，否则返回值为null
     * @Date  2019/8/18 21:19
     * @Param []
     * @return org.hibernate.Session
     **/
    public static Session getCurrentSession(){
        return factory.getCurrentSession();
    }

    /**
     * @Author xie
     * @Description //关闭session
     * @Date  2019/8/29 20:09
     * @Param [session]
     * @return void
     **/
    public static void close(Session session){
        if (session != null){
            if (session.isOpen()){
                session.close();
            }
        }
    }
}
