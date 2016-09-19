package util;

public class NumberUtil {
	/**
	 * 
	 * @param a
	 * @return 1 if a >= 0; 0 if a < 0;
	 */
	public static int sign(int a){
		return flip((a>>31)&0x1);
	}
	
	/**
	 * Map 1 to 0 or 0 to 1.
	 * @param bit
	 * @return
	 */
	public static int flip(int bit){
		return 1^bit;
	}
}
