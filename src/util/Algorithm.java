package util;

/**
 * 标识各个算法体
 * @author Jingang Zhou
 *
 */
public @interface Algorithm {
	String kind() default "N/A";
}
