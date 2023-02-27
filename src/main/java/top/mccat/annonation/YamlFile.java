package top.mccat.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Distance
 * @date 2023/2/27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface YamlFile {
    //文件路径
    String value() default "";
    //yaml文件最层参数
    String section() default "";
}
