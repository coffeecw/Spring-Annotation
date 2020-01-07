package cn.cwcoffee;

import cn.cwcoffee.bean.Person;
import cn.cwcoffee.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author cw
 * @Date 2020/01/07 10:59
 */
public class MainTest {
    public static void main(String[] args) {
        //加载xml的方式获取bean
     /*   ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/
        //注解配置类的方式获取bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
        //根据类的类型获取bean的name
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
