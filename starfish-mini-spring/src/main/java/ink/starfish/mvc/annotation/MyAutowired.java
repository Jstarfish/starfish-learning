package ink.starfish.mvc.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: starfish
 * @create: 2020-11-11 16:16
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
    String value() default "";
}
