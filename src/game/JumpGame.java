package game;

/**
 * Source: https://leetcode.com/problems/jump-game/
 *
 * Given an array of non-negative integers, you are initially
 * positioned at the first index of the array.

 * Each element in the array represents your maximum jump
 * length at that position.  Determine if you are able to
 * reach the last index.

 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * Created by zhou-jg on 2017/1/20.
 */
public class JumpGame {
    /**
     * 定义一个信号兵，根据每个数组元素的值不断向右端扩展可以到达
     * 的最右边界，如果该最右边界能够到达最末元素，则返回真。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        //信号兵变量
        int pos = 0;
        for (int i=0; i<nums.length; i++){
            /*
             * 如果当前元素值为0，则需判断是否信号兵的索引在当前元素的右边，
             * 如果在右边，则可以越过当前元素，继续推进，否则当前元素为目前
             * 可达的最右元素，如果它就是末尾元素，则完成，否则末尾元素不可达。
             */
            if (nums[i] == 0){
                if (pos > i){
                    continue;
                }else if (i == nums.length-1){
                    return true;
                }else{
                    return false;
                }
            }
            /*
             * 根据当前元素值，判断信号兵可以向右推进的步数。如果信号兵的索引
             * 超过末尾元素索引，则完成。
             */
            int right = Math.min(pos+nums[i], i+nums[i]);
            if (right > pos){
                pos = right;
                if (right >= nums.length-1){
                    return true;
                }
            }
        }

        return false;
    }
}
