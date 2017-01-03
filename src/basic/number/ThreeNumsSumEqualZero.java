package basic.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 来源：https://leetcode.com/problems/3sum/
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 *
 *	For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 *	A solution set is:
 *	[
 *    [-1, 0, 1],
 *    [-1, -1, 2]
 *	]
 * @author Jingang Zhou
 *
 */
public class ThreeNumsSumEqualZero {

	/**
	 * 思路：先对数组进行排序，并分为负数区、零区（可能没有）、整数区，如果都是负数或都是整数则无解。
	 * 因为要想和为0，要么这三个数都为0，要么有正有负，而且形式比为如下三种情况之一：
	 * <i>一个大负数带两个小整数</i>
	 * <i>一个大整数带两个小负数</i>
	 * <i>一对互为相反数带一个0</i>
	 * 这样，在算法设计时可以将有效三元组的搜索空间缩小。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3){
            return ret;
        }
        
        int[] tmp = sort(nums);
        //记录负数区的右端结束索引                
        int negativeLine = findNegativeLine(tmp);
        //记录正数区的左端开始索引
        int positiveLine;
        if (negativeLine == tmp.length){
        	return ret;
        }else if (negativeLine == -1){
        	if (tmp[0] == 0 && tmp[1] == 0 && tmp[2] == 0){
        		addList(ret, 0, 0, 0);       		
        	}
        	return ret;
        }else{
        	positiveLine = findPositiveLine(tmp, negativeLine+1);
        	if (positiveLine == tmp.length){
        		return ret;
        	}
        }
        
        for (int i=0; i<=negativeLine; i++){
        	if (i>0 && tmp[i] == tmp[i-1]) {
        		continue;
        	}
            for (int j=tmp.length-1; j>=positiveLine; j--){
            	if (j<tmp.length-1 && tmp[j] == tmp[j+1]){
            		continue;
            	}
            	if (tmp[i]+tmp[j] < 0){
            		if (tmp[i] + tmp[j] + tmp[positiveLine] > 0 || tmp[i] + tmp[j] + tmp[tmp.length-1] < 0){
            			continue;
            		}
            		for (int k=positiveLine; k<j; k++){       			
            			if (tmp[i]+tmp[j]+tmp[k] == 0){
            				addList(ret, tmp[i], tmp[j], tmp[k]); 
                    		break;
            			}
            		}
            	}else if (tmp[i]+tmp[j]>0){
            		if (tmp[i]+tmp[j]+tmp[0] >0 || tmp[i]+tmp[j]+tmp[negativeLine] <0){
            			continue;
            		}
            		for (int k=i+1; k<=negativeLine; k++){
            			if (tmp[i]+tmp[j]+tmp[k] == 0){
            				addList(ret, tmp[i], tmp[j], tmp[k]);
                    		break;
            			}
            		}
            	}else{
            		for (int k=negativeLine+1; k<positiveLine; k++){
            			if (tmp[k] == 0){
            				addList(ret, tmp[i], tmp[j], 0);
                    		break;
            			}
            		}
            	}

            }
        }
        if (positiveLine - negativeLine > 3){
        	addList(ret, 0, 0, 0);
        }
        
        return ret;
    }
	
	private void addList(List<List<Integer>> result, int a, int b, int c){
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		list.add(c);
		result.add(list); 
	}
	
	private int[] sort(int[] nums){
        int[] ret = new int[nums.length];
        for (int i=0; i<ret.length; i++){
            ret[i] = nums[i];
        }
        Arrays.sort(ret);
        return ret;
    }
	
	
	private int findNegativeLine(int[] nums){
		for (int i=0; i<nums.length; i++){
			if (nums[i] >= 0){
				return i-1;
			}
		}
		return nums.length;
	}
	
	private int findPositiveLine(int[] nums, int start){
		for (int i=start; i<nums.length; i++){
			if (nums[i] > 0){
				return i;
			}
		}
		return nums.length;
	}
}
