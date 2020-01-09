package cn.cwcoffee.condition;

import cn.cwcoffee.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author cw
 * @Date 2020/1/9 23:18
 */
public class MyBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param annotationMetadata 当前类的注解信息
     * @param beanDefinitionRegistry beanDefinition注册类
     *       把所有需要添加到容器中的bean:调用
     *                 beanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("cn.cwcoffee.bean.Blue");
        boolean definition1 = beanDefinitionRegistry.containsBeanDefinition("cn.cwcoffee.bean.Red");
        if(definition && definition1){
            //指定Bean的定义信息(Bean的类型等)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean,指定Bean名
            beanDefinitionRegistry.registerBeanDefinition("rainbow",beanDefinition);
        }
    }
}
