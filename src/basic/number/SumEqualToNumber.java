
/**
* 题目：输入一个已经按升序排序过的数组和一个数字，
* 在数组中查找两个数，使得它们的和正好是输入的那个数字。
* 要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
* 例如输入数组1、2、4、7、11、15 和数字15。由于4+11=15，因此输出4 和11。
*/
public class SumEqualToNumber {
  public static int[] find(int[] nums, int dest){
    if (nums == null || nums.length < 2){
      return null;
    }else{
      int i = 0, j = nums.length - 1;
      int sum = nums[i] + nums[j];
      while (i < j && sum != dest){
        if (sum < dest){
          i++;
        else{
          j--;
        }
        sum = nums[i] + nums[j];
      }
      if (sum == dest){
        return int[]{nums[i], nums[j]};
      }else{
        return null;
      }
    }
  }
}
      
