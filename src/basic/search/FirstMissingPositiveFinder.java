package basic.search;

/**
 * Source: <a href="https://leetcode.com/problems/first-missing-positive/?tab=Description">
 *     https://leetcode.com/problems/first-missing-positive/</a>
 *
 * <p>Given an unsorted integer array, find the first missing positive integer.
 *
 * <p>For example,<br>
 * Given <code>[1,2,0]</code> return <code>3</code>,<br>
 * and <code>[3,4,-1,1]</code> return <code>2</code>.
 *
 * <p>Your algorithm should run in O(n) time and uses constant space.
 *
 * <p>Created by zhou-jg on 2017/2/21.
 */
public class FirstMissingPositiveFinder {
    /**
     * Steps:<br>
     * 1. Arrange elements so that all positive elements are in the left part
     * of the array.<br>
     * 2. For the k positive elements, according to the Pigeon hole theory,
     * we know the first missing positive must be in [1, k+1]. So, we mark
     * the positive elements (make them negative) when they are in the range
     * of [1, k+1] with the index.<br>
     * 3. Then we check the first positive number of the array, its index
     * plus 1 is the number we are looking for.<br>
     *
     * <p><b>Attention:</b></p> the array is modified (which is allowed).
     * @param nums
     * @return first missing positive.
     */
    public int firstMissingPositive(int[] nums) {
        int j = partition(nums);
        if (j==0 && nums[0] <= 0){
            return 1;
        }
        for (int i=0;i<=j; i++){
            if (Math.abs(nums[i]) <= j+1){
                if (nums[Math.abs(nums[i])-1] > 0){
                    nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
                }
            }
        }

        for (int i=0; i<=j; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }
        return j+2;
    }

    /**
     * Move elements that are positive to the left part of the array, and
     * return the index of the last positive element in the array.
     * @param nums
     * @return index of the last positive element of the reordered array.
     */
    private int partition(int[] nums){
        int j=nums.length-1;
        //Pay attention to the termination criteria of i (i.e., i <= j).
        for (int i=0; i<=j; i++){
            if (nums[i] <= 0){
                while (nums[j] <=0 && j > i){
                    j--;
                }
                if (j==i){
                    j--;
                    break;
                }else{
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    j--;
                }
            }
        }

        return j;
    }
}
