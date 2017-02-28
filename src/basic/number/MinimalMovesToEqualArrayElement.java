package basic.number;

import java.util.Arrays;

/**
 * Source: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/?tab=Description
 *
 * Given a non-empty integer array of size n, find the minimum number of
 * moves required to make all array elements equal, where a move is
 * incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output: 3
 * Explanation: Only three moves are needed (remember each move increments
 * two elements): [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * Created by zhou-jg on 2017/2/9.
 */
public class MinimalMovesToEqualArrayElement {
    /**
     * This approach is based on the idea that adding 1 to all the elements
     * except one is equivalent to decrementing 1 from a single element,
     * since we are interested in the relative levels of the elements which
     * need to be equalized. Thus, the problem is simplified to find the
     * number of decrement operations required to equalize all the elements
     * of the given array. For finding this, it is obvious that we'll reduce
     * all the elements of the array to the minimum element. But, in order
     * to find the solution, we need not actually decrement the elements. We
     * can find the number of moves required as moves=sum(nums)-min(nums)*n,
     * where n is the length of the array.
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int moves = 0, min = nums[0];
        for (int i=1; i<nums.length; i++){
            moves += nums[i];
            if (nums[i] < min){
                min = nums[i];
            }
        }
        moves -= min * (nums.length-1);

        return moves;
    }
}
