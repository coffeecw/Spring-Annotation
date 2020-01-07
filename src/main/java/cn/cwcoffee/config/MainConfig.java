package cn.cwcoffee.config;

import cn.cwcoffee.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cw
 * @Date 2020/01/07 11:04
 */
//配置类==配置文件，告诉Spring这是一个配置类
@Configuration
public class MainConfig {
    /**
     * 给容器注册一个bean;类型为返回值的类型，id是默认用方法名作为id
     * @Bean("person01") 可以自定义bean的id
     */
    @Bean("person01")
    public Person person(){
        return new Person("lisi","18");
    }
}
