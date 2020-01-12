package cn.cwcoffee;

import cn.cwcoffee.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author cw
 * @Date 2020/1/12 11:52
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //创建ioc容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        //多例 获取的时候才会创建对象
//        context.getBean("car");
        //关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }
}
