package com.jxau.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jxau.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonTest {


    //java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //转换
        /*
            转换方法：
            writeValue(参数1，obj):
                参数1：
                    File:将obj对象转为json字符串,并保存到指定的文件中
                    Writer:将obj对象转为json字符串,,并将json数据填充到字符输出流中
                    OutputStream:将obj对象转为json字符串,,并将json数据填充到字节输出流中
            writeValueAsString(obj):将对象转为json字符串

         */
        String json = mapper.writeValueAsString(p);
        System.out.println(json);//{"name":"张三","age":23,"gender":"男"}

        //将数据写到d://a.txt中
        //mapper.writeValue(new File("d://a.txt"),p);
    }

    @Test
    public void test2() throws IOException {
        //创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);

        System.out.println(json);//{"name":"张三","age":23,"gender":"男","birthday":1557658155419}
                            //{"name":"张三","age":23,"gender":"男","birthday":"2019-05-12"}

    }


    @Test
    public void test3() throws IOException {
        //创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        //创建List对象
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);

        //转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);

        System.out.println(json);//[{"name":"张三","age":23,"gender":"男","birthday":"2019-05-12"},{"name":"张三","age":23,"gender":"男","birthday":"2019-05-12"},{"name":"张三","age":23,"gender":"男","birthday":"2019-05-12"}]

    }

    @Test
    public void test4() throws IOException {
        //创建map对象
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");

        //转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);//{"gender":"男","name":"张三","age":23}
    }

    /**
     * 演示JSON字符串转为Java对象
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        //初始化JSON字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();

        //转换成java对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);//Person{name='张三', age=23, gender='男', birthday=null}
    }
}
