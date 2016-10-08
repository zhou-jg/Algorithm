package basic.number;

import util.Algorithm;
import static util.NumberUtil.*;

/**
 * 
 * @author Jingang Zhou
 *
 */
public class NumberAlgorithm {
	
	
	
	/**
	 * Without IF-ELSE or other comparison operations.
	 * @param a
	 * @param b
	 * @return Math.max(a, b)
	 */
	@Algorithm
	public static int max(int a, int b){
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(a-b);
		
		//use sign of a if a and b have different signs
		int use_sa = sa ^ sb;
		int use_sc = flip(use_sa);
		
		int k = use_sa * sa + use_sc * sc;
		int q = flip(k);
		
		return a * k + b * q;
	}
	
}
