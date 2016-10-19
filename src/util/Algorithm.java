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
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface Algorithm {
	//用于分类分组
	String value() default "N/A";
	//用于进一步描述
	String text() default "N/A";
}
