package basic;

import util.Algorithm;

public class AngleOfTimer {
	/**
	 * 
	 * @param hour 时针：1~12
	 * @param minute 分针：0~59
	 * @return 时针和分针的夹角度数
	 */
	@Algorithm
	public static float computeAngle (int hour, int minute){
		if (hour > 12 || hour < 1 || minute > 59 || minute < 0){
			throw new IllegalArgumentException("参数范围错误");
		}
		//记录时针和分针分别所指的角度，以12:00为0度，顺时针计算
		float angleHour, angleMin;

		int hourAdjust = hour == 12 ? 0 : hour;
		angleHour = hourAdjust * 30 +  (float) minute * 30 / 60;
		angleMin = minute * 6; // minute / 60 * 360
		
		return Math.abs(angleMin - angleHour);
	}
}
