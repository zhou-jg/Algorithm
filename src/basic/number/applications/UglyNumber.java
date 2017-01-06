package basic.number.applications;

public class UglyNumber {

	/**
	 * 来源：https://leetcode.com/problems/ugly-number/
	 * Ugly numbers are positive numbers whose prime factors 
	 * only include 2, 3, 5. For example, 6, 8 are ugly while 
	 * 14 is not ugly since it includes another prime factor 7.
	 *
	 * Note that 1 is typically treated as an ugly number.
	 * @param num
	 * @return
	 */
	public boolean isUgly(int num){
		if (num<=0){
			return false;
		}else if (num==1){
			return true;
		}else{	
			/*
			 * 依次用最小的质因子去除num。
			 */
			line: while (num > 0){
				int r = (int)Math.sqrt(num);
				for (int i=2; i<=r; i++){
					if (num % i == 0){
						if (i > 5){
							return false;
						}else{
							num /= i;
							continue line;
						}
					}
				}
				if (num > 5){
					return false;
				}else{
					return true;
				}
			}
			return true;
		}
	}
}
