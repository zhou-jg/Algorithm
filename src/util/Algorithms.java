package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 
 * @author Jingang Zhou
 *
 */
@Target(ElementType.METHOD)
public @interface Algorithms {
	Algorithm[] value();
}
