package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * 标识各个算法
 * @author Jingang Zhou
 *
 */
@Repeatable(Algorithms.class)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Algorithm {
	String value() default "N/A";
}
