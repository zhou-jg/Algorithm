package basic.number.applications;

import java.util.Objects;

import util.Algorithm;

/**
 * 在物流行业中，快递公司要在城区（小区）布置一系列的储物柜用来存放快递包裹。为方便用户，需要这些储物柜的位置
 * 尽量靠近小区。
 * @author Jingang Zhou
 *
 */
public class LockerDistance {
	/**
	 * 例如，假设某个城区以街区为单位，长有 3 个街区，宽有 5 个街区，储物柜的位置在第一个街区块内，那么每个街区块
	 * 到离自己最近的距离分别为（距离以水平距离和垂直距离的和为准）：
	 * 0	1	2
	 * 1	2	3
	 * 2	3	4
	 * 3	4	5
	 * 4	4	6
	 * @param cityLength 城市长度，以街区（block）为单位， 大于 0
	 * @param cityWidth 城市宽度，以街区为单位，大于0
	 * @param xPos	储物柜所在街区的x坐标 （起始为1，方向向右）
	 * @param yPos	储物柜所在街区的y坐标（起始为1，方向向下）
	 * @return 每个街区距离最近的储物柜位置
	 */
	@Algorithm(value = "application")
	public static int[][] distance(int cityLength, int cityWidth, int[] xPos, int[] yPos){
		Objects.requireNonNull(xPos);
		Objects.requireNonNull(yPos);
		//需要xPos和yPos的长度相等，略去各种合法性验证
		
		int[][] result = new int[cityLength][cityWidth];
		for (int i=0; i<cityLength; i++){
			for (int j=0; j<cityWidth; j++){
				int minDistance = cityLength + cityWidth - 2;				
				for (int k=0; k<xPos.length; k++){
					int distance = Math.abs(xPos[k] - i - 1) + Math.abs(yPos[k] - j - 1);
					if (distance < minDistance){
						minDistance = distance;
					}
				}
				result[i][j] = minDistance;
			}
		}
		return result;
	}
}
