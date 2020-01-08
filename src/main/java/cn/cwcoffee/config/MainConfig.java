package cn.cwcoffee.config;

import cn.cwcoffee.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Author cw
 * @Date 2020/01/07 11:04
 */
//配置类==配置文件，告诉Spring这是一个配置类
@Configuration
@ComponentScan(value = "cn.cwcoffee",excludeFilters = {
        //根据注解排除组件
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Service.class}),*/
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        })
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[] 指定扫描的时候按照什么规则排除哪些组件
//includeFilters = Filter[] 指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE_TYPE 按照给定的类型
//FilterType.ASPECTJ 使用ASPECTJ表达式
//FilterType.REGEX 使用正则表达式
//FilterType.CUSTOM 使用自定义规则

public class MainConfig {
    /**
     * 给容器注册一个bean;类型为返回值的类型，id是默认用方法名作为id
     * @Bean("person01") 可以自定义bean的id
     */
    @Bean("person01")
    public Person person(){
        return new Person("lisi",18);
    }
}
