package cn.cwcoffee;

import cn.cwcoffee.bean.Person;
import cn.cwcoffee.config.MainConfigOfProperty;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Author cw
 * @Date 2020/1/12 11:52
 */
public class IOCTest_Property {

    @Test
    public void test01(){
        //创建ioc容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProperty.class);
        System.out.println("容器创建完成");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //获取当前环境
        Environment environment = context.getEnvironment();
        //从配置文件person.properties中取出值
        String property = environment.getProperty("person.nickname");
        System.out.println(property);

        Person person = (Person) context.getBean("person");
        System.out.println("==============");
        System.out.println(person);
    }
}
