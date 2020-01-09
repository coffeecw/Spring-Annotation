package cn.cwcoffee.config;

import cn.cwcoffee.bean.Person;
import cn.cwcoffee.condition.LinuxCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Author cw
 * @Date 2020/1/8 22:25
 */
//类中组件同一设置:满足当前条件，这个类中配置的所有的bean注册才能生效(@Conditional注解放在类上)

@Conditional({LinuxCondition.class})
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
//    @Scope("prototype")
    /**
     * 懒加载  针对单例模式
     *      单实例Bean:默认在容器启动的时候创建对象
     *      懒加载:容器启动不创建对象，第一次使用(获取)Bean创建对象,并初始化
     */
    @Lazy
    @Bean("person02")
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("张三",36);
    }
    /**
     * @Conditional 按照一定条件进行判断，满足条件给容器中注册bean
     * 可以放在方法上，也可以放在类上
     * 需求:
     * 如果系统为Windows 则将Bill注册到容器
     * 如果系统为Linux 则将Linus注册到容器
     */
    /*@Conditional({WindowsCondition.class})*/
    @Bean("Bill")
    public Person person02(){
        return new Person("Bill Getes",65);
    }

    /*@Conditional({LinuxCondition.class})*/
    @Bean("Linus")
    public Person person03(){
        return new Person("Linus",48);
    }
}
