package cn.cwcoffee.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author cw
 * @Date 2020/1/9 22:18
 * 判断是否是Windows系统
 * 实现Condition接口
 * 重写matches方法
 */
public class WindowsCondition implements Condition {
    /**
     * @param conditionContext 判断条件能使用的上下文环境
     * @param annotatedTypeMetadata 标注@Conditional注解的注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //是否是Linux系统
        //1、能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3、获取当前环境的信息
        Environment environment = conditionContext.getEnvironment();
        //4、获取Bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        //可以判断容器中bean的注册情况，也可以给容器中注册bean
        boolean person02 = registry.containsBeanDefinition("person02");
        String property = environment.getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
