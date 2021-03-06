package com.jxau.service.impl;

import com.jxau.dao.AccountDao;
import com.jxau.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 曾经的XML配置
 * <bean id="accountService" class="com.jxau.service.impl.AccountServiceImpl"
 *     scope=""  init-method=""  destroy-method="">
 *    <property name=""  value=""/ref="" ></property>
 *
 * </bean>
 *
 * 用于创建对象的注解
 *          他们的作用就和在XML配置文件中编写一个<bean><bean/>标签实现的功能是一样的
 *          @Component:用于把当前类对象存入spring核心容器中
 *                      属性：value用于指定bean的id。当不写时，它的默认值是当前类名，且首字母改小写。
 *          @Controller：一般用于表现层
 *          @Service：一般用于业务层
 *          @Repository：一般用于持久层
 *          以上三个注解他们的作用和属性与@Component是一致的，他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 * 用于注入数据的注解
 *          他们的作用就和在XML文件中的bean标签中写一个<property></property>标签的作用是一样的
 *          @Autowired:自动按照类型注入。只有容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *                      如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *                      如果ioc容器中有多个类型匹配时：会通过查找容器中的key有没有相匹配的，没有则报错
 *          出现位置：可以是变量上，也可以是方法上
 *          细节：在使用注解注入时，set方法就不是必须的了
 *          @Qualifier:在按照类型注入的基础上再按照名称注入，它在给类成员注入时不能单独使用，但在给方法参数注入时可以
 *                  属性：value:用于指定注入bean的id
 *          @Resource：直接按照bean的id注入，可以独立使用
 *                  属性：name:用于指定bean的id
 *
 *           以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *           另外，集合类型的注入只能通过配置文件(xml)来实现
 *
 *          @Value:用于注入基本类型和String类型的数据
 *                  属性：value:用于指定数据的值，它可以使用spring 中的SpEl(也就是spring中的el表达式)
 *                          SpEl的写法：${表达式}
 * 用于改变作用范围的注解
 *          他们的作用就和在XML文件中的bean标签中使用scope属性实现的功能是一样的
 *          @Scope:用于指定bean的作用范围
 *                  属性：value:指定范围的取值，常用取值：singleton,prototype
 * 和生命周期相关的注解
 *          他们的作用就和在XML文件中的bean标签中使用init-method=""和destroy-method=""的作用是一样的
 *          @PreDestroy:用于指定销毁方法
 *          @PostConstruct:用于指定初始化方法
 */
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao ad;
    public void saveAccount() {
        ad.saveAccount();
    }
}
