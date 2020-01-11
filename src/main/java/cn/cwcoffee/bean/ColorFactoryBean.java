package cn.cwcoffee.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author cw
 * @Date 2020/1/11 22:42
 * 创建Spring定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("colorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * true 这个bean是单实例，在容器中保存一份
     * false 多实例，每次获取都会创建一个新的bean
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
