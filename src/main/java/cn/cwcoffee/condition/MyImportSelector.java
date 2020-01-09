package cn.cwcoffee.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author cw
 * @Date 2020/1/9 23:03
 * 自定义逻辑返回需要导入的组件全类名
 * 需要在组件注册的类上@Import里面标注
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值，就是导入到容器中的组件全类名
     * @param annotationMetadata 当前标注@Import注解类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //方法不能返回null
        return new String[]{"cn.cwcoffee.bean.Yellow"};
    }
}
