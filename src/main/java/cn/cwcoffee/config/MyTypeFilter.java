package cn.cwcoffee.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author cw
 * @Date 2020/1/8 22:02
 * 自定义过滤组件的规则  FilterType.CUSTOM
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader  读取到当前扫描类的信息
     * @param metadataReaderFactory 可以获取到其他类的任何信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源(类的路径)
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        //类名包含er则扫描
        if(className.contains("er")){
            return true;
        }
        System.out.println("-->"+className);
        return false;
    }
}
