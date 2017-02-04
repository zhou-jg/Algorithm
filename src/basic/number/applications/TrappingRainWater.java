package basic.number.applications;

/**
 * Source: https://leetcode.com/problems/trapping-rain-water/?tab=Description
 *
 * <p></p>Given n non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it is able to trap
 * after raining.
 *
 * <p>For example,<br>
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.<br>
 *
 * Created by zhou-jg on 2017/2/4.
 */
public class TrappingRainWater {
    //参考：https://discuss.leetcode.com/topic/3016/share-my-short-solution
    public int trap(int[] height) {
        public int trap(int[] height) {
            int left = 0, right = height.length-1;
            int leftMax = 0, rightMax = 0;
            int sum = 0;
            while (left < right){
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);
                if (leftMax < rightMax){
                    sum += leftMax - height[left];
                    left++;
                }else{
                    sum += rightMax - height[right];
                    right--;
                }
            }
            return sum;
        }
    }
}
