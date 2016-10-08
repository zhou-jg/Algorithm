package basic.bit.application;

public class BitFormatForReal {

	/**
	 * 输出给定实数的二进制表示，如果不能用32位表示，则输出"ERROR".
	 * @param num 0<num<1
	 * @return
	 */
	public static String get(double num){
		if (num >= 1 || num <= 0){
			return "ERROR";
		}
		int count = 0;
		StringBuilder sb = new StringBuilder(".");

		while (count <= 32){
			num *= 2;
			if (num == 0){
				return sb.toString();
			}else if (num >= 1){
				sb.append("1");
				num -= 1;
			}else if (num < 1){
				sb.append("0");
			}
			count++;
		}
		return "ERROR";
	}
}
