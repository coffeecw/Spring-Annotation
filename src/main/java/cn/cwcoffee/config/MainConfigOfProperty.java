package cn.cwcoffee.config;

import cn.cwcoffee.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author cw
 * @Date 2020/1/12 15:11
 * 使用@PropertySource读取外部配置文件的k/v保存到运行的环境变量中；加载完外部的配置文件以后使用${}取出配置文件的值
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfProperty {

    @Bean
    public Person person(){
        return new Person();
    }

}
