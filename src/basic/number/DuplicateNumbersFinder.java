package basic.number;

/**
Source: https://leetcode.com/problems/find-all-duplicates-in-an-array/

<p>Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear 
twice and others appear once. Find all the elements that appear twice in this array.

<p>Could you do it without extra space and in O(n) runtime?

<b>Example:<b>
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
public class DuplicateNumbersFinder {
  /**
  一次遍历，如果某数字出现，就将该数字的对应的索引处的数字进行标注（负数化），
  如果后续某个数字发现其对应的索引出的数字已经是负数，那么说明该数字之前出现过。
  <b>注意：</b>这里修改了输入对象，可以在返回值之前将数组元素复原（取绝对值）。
  */
  public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[Math.abs(nums[i])-1] < 0){
                ret.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }        
        return ret;
    }
}
