package cn.cwcoffee.config;

import cn.cwcoffee.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author cw
 * @Date 2020/1/8 22:25
 */
@Configuration
public class MainConfig2 {
    /**
     * 默认是单例的
     * prototype 多实例的:ioc容器启动并不会去调用方法创建对象放在容器中
     *                   每次获取的时候才会调用方法创建对象
     * singleton 单实例的(默认值):ioc容器启动会调用方法创建对象放到ioc容器中
     *                           以后每次获取就是直接从容器(map.get())中拿
     * request 同一次请求创建一个实例
     * session 同一个session创建一个实例
     * @return
     */
    @Scope("prototype")
    @Bean("person02")
    public Person person(){
        return new Person("张三",36);
    }
}
