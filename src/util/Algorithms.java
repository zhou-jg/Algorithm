package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 
 * @author Jingang Zhou
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface Algorithms {
	Algorithm[] value();
}
