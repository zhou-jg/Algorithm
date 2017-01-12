package dp;

import java.util.Objects;

/**
 * Created by zhou-jg on 2017/1/12.
 */
public class MaxSumForSubList {

    /**
     *
     * @param nums 既包含正数，也有负数
     * @return
     */
    public static int compute(int[] nums){
        Objects.requireNonNull(nums);
        if (nums.length == 0){
            throw new IllegalArgumentException("数组不能为空！");
        }
        int max = 0;
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            if (sum > max){
                max = sum;
            }else if (sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}
