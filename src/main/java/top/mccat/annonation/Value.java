package top.mccat.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Distance
 * @date 2023/2/27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
    //yaml对应键
    String value() default "";
    //注入对象类型
    Class<Object> classType() default Object.class;
    String defaultValue() default "";
}
