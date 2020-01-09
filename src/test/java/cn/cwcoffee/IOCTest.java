package cn.cwcoffee;

import cn.cwcoffee.bean.Person;
import cn.cwcoffee.config.MainConfig;
import cn.cwcoffee.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @Author cw
 * @Date 2020/01/07 19:03
 */
public class IOCTest {

    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }

    @Test
    public void test02(){
        //创建ioc容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        //获取bean定义的名字
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
        System.out.println("ioc容器创建完成");
        Object person02 = context.getBean("person02");
        Object person03 = context.getBean("person02");
        System.out.println(person02==person03);
    }

    @Test
    public void test03(){
        //创建ioc容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
        Map<String, Person> personMap = context.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

}
