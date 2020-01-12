package cn.cwcoffee.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author cw
 * @Date 2020/1/12 14:19
 */
@Component
public class Dog {
    public Dog(){
        System.out.println("dog...constructor...");
    }

    /**
     * 对象创建并赋值之后调用
     */
    @PostConstruct
    public void init(){
        System.out.println("dog...init...");
    }

    /**
     * 容器移除对象前调用
     */
    @PreDestroy
    public void destroy(){
        System.out.println("dog...destroy...");
    }
}
