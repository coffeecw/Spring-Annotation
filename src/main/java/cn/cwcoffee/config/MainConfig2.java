package cn.cwcoffee.config;

import cn.cwcoffee.bean.Blue;
import cn.cwcoffee.bean.ColorFactoryBean;
import cn.cwcoffee.bean.Person;
import cn.cwcoffee.bean.Red;
import cn.cwcoffee.condition.LinuxCondition;
import cn.cwcoffee.condition.MyBeanDefinitionRegistry;
import cn.cwcoffee.condition.MyImportSelector;
import cn.cwcoffee.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Author cw
 * @Date 2020/1/8 22:25
 */
//类中组件同一设置:满足当前条件，这个类中配置的所有的bean注册才能生效(@Conditional注解放在类上)
/*@Conditional({LinuxCondition.class})*/
@Configuration
@Import({Blue.class, Red.class, MyImportSelector.class, MyBeanDefinitionRegistry.class})
//@Import导入组件，id默认是组件的全类名

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
    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person02(){
        return new Person("Bill Getes",65);
    }

    @Conditional({LinuxCondition.class})
    @Bean("Linus")
    public Person person03(){
        return new Person("Linus",48);
    }

    /**
     * 给容器中注册组件方式总结:
     * 1)、包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)[局限于自己写的类]
     * 2)、@Bean[导入的第三方包里面的组件]
     * 3)、@Import[快速给容器中导入一个组件]
     *      1)、@Import(要导入到容器的组件):容器中就会自动注册这个组件，id默认是全类名
     *      2)、ImportSelector：返回需要导入的组件的全类名数组
     *      3)、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     *      4)、使用Spring提供的FactoryBean(工厂Bean)
     *         1、默认获取到的是工厂bean调用的getObject创建的对象
     *         2、要获取工厂bean本身，我们需要给id前面加&
     *              &colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
