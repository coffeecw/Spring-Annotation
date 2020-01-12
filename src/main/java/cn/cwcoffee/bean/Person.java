package cn.cwcoffee.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author cw
 * @Date 2020/01/07 10:09
 */
public class Person {

    /**
     * 使用@Value赋值
     * 1、基本数值
     * 2、可以写SpEL #{}
     * 3、可以写${} 取出配置文件的值(在运行环境变量里面的值)
     */
    @Value("张三")
    private String name;

    @Value("#{20-1}")
    private Integer age;

    @Value("${person.nickname}")
    private String nickName;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
