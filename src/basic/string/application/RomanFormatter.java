package basic.string.application;

import util.Algorithm;

/**
 * A Roman numeral represents an integer using letters. 
 * Examples are XVII to represent 17, MCMLIII for 1953, 
 * and MMMCCCIII for 3303. By contrast, ordinary numbers 
 * such as 17 or 1953 are called Arabic numerals. The 
 * following table shows the Arabic equivalent of all 
 * the single-letter Roman numerals:

 *    M    1000            X   10
 *    D     500            V    5
 *    C     100            I    1
 *    L      50
 * When letters are strung together, the values of the 
 * letters are just added up, with the following exception. 
 * When a letter of smaller value is followed by a letter 
 * of larger value, the smaller value is subtracted from 
 * the larger value. For example, IV represents 5 - 1, or 4. 
 * And MCMXCV is interpreted as M + CM + XC + V, or 
 * 1000 + (1000 - 100) + (100 - 10) + 5, which is 1995. 
 * In standard Roman numerals, <b>no more than three consecutive 
 * copies of the same letter are used</b>. Following these rules, 
 * every number between 1 and 3999 can be represented as a 
 * Roman numeral made up of the following one- and two-letter combinations:

 *    M    1000            X   10
 *    CM    900            IX   9
 *    D     500            V    5
 *    CD    400            IV   4
 *    C     100            I    1
 *    XC     90
 *    L      50
 *    XL     40
 *
 * @author Jingang Zhou
 */
public class RomanFormatter {
	private static final char DUMY = '#';
	
	enum Romans{
		I(1, 1), IV(4, 2), V(5, 1), IX(9, 2), X(10, 1), XL(40, 2), L(50, 1),
		XC(90, 2), C(100, 1), CD(400, 2), D(500, 1), CM(900, 2), M(1000, 1);
		
		int value, length;
		Romans(int value, int length){
			this.value = value;
			this.length = length;
		}
	}
	
	/**
	 * 根据给定自然数，给出Roman数字表示
	 * @param number 给定自然数
	 * @return Roman数字表示
	 */
	@Algorithm
	public static String toRoman(int number){
		if (number <= 0){
			throw new NumberFormatException("输入必须是自然数");
		}
		
		StringBuilder sb = new StringBuilder();
		
		final Romans[] values = Romans.values();
		for (int i=values.length-1; i>=0; i--){
			int repeat = 0;//连续字符的出现次数
			while(number>=values[i].value){
				if (repeat == 3 && values[i].length == 1){
					sb.append(values[i-1]);//不应该越界
					number -= values[i-1].value;
					repeat = 1;
				}else {
					sb.append(values[i]);
					number -= values[i].value;
					repeat++;
				}
			}
		}

		return sb.toString();
	}
	
	/**
	 * 根据给定的Roman数字形式，计算相应的阿拉伯数字
	 * @param roman 给定的Roman数字形式
	 * @return 等值的阿拉伯数字
	 */
	@Algorithm
	public static int toInt(String roman){
		if (roman == null) throw new NullPointerException("roman cannot be null!");
		String str = roman.trim();
		if (str.isEmpty()) return 0;
		
		StringBuilder sb = new StringBuilder(str);
		
		return decode(sb, DUMY, 0);
	}
	
	private static int decode(StringBuilder sb, char pre, int count){
		if (sb.length() > 0){
			char c0 = sb.charAt(0);
			if (c0 == pre){
				count++;
				if (count > 3){
					throw new NumberFormatException("连续字符不能超过3次");
				}
			}else{
				pre = c0;
				count = 1;
			}
			
			if (sb.length() > 1){
				char c1 = sb.charAt(1);
				if (value(c1) > value(c0)){
					return value(c1) - value(c0) + decode(removeFirstTwoChars(sb), c1, 1);
				}else{
					return value(c0) + decode(removeFirstChar(sb), c0, count);
				}
			}else{
				return value(c0);
			}
		}else{
			return 0;
		}
	}
	
	private static int value(char c){
		switch(c){
		case 'I' : return 1;
		case 'V' : return 5;
		case 'X' : return 10;
		case 'L' : return 50;
		case 'C' : return 100;
		case 'D' : return 500;
		case 'M' : return 1000;		
		}
		throw new IllegalArgumentException(String.valueOf(c) + " is not recognized!");
	}
	
	private static StringBuilder removeFirstChar(StringBuilder sb){
		return sb.deleteCharAt(0);
	}
	
	private static StringBuilder removeFirstTwoChars(StringBuilder sb){
		return sb.delete(0, 2);
	}
}
