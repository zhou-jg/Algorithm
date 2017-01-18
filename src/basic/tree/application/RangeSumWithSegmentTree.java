package basic.tree.application;

/**
 * Source: https://leetcode.com/problems/range-sum-query-mutable/<br>
 * 
 * Given an integer array <i>nums</i>, find the sum of the elements between 
 * indices <i>i</i> and <i>j</i> (<i>i</i> ≤ <i>j</i>), inclusive.

 * The <i>update(i, val)</i> function modifies <i>nums</i> by 
 * updating the element at index <i>i</i> to <i>val</i>.<br>
 * <b>Example:</b><br>
 * Given nums = [1, 3, 5]
 *<br>
 * sumRange(0, 2) -> 9<br>
 * update(1, 2)<br>
 * sumRange(0, 2) -> 8<br>
 * <b>Note</b>:
 * <li>The array is only modifiable by the update function.
 * <li>You may assume the number of calls to update and <i>sumRange</i> 
 * function is distributed evenly.
 * 
 * @author Jingang Zhou
 *
 */
public class RangeSumWithSegmentTree {
	private SegmentTreeNode root;
	public RangeSumWithSegmentTree(int nums[]){
		root = SegmentTreeNode.buildTree(nums, 0, nums.length-1);
	}
	
	public void update(int i, int val){
		update(root, i, val);
  }
   
    void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end){
           root.sum = val;
        }else{
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid){
                 update(root.left, i, val);
            }else{
                 update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
	
	public int sumRange(int i, int j){
		return sumRange(root, i, j);
	}
	
	int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        }else{
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid){
                return sumRange(root.left, start, end);
            }else if (start >= mid+1){
                return sumRange(root.right, start, end);
            }else{    
                return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
            }
        }
    }
	
	/**
	 * Reference: http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
	 */
	static class SegmentTreeNode{
		int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
        
        static SegmentTreeNode buildTree(int[] nums, int start, int end){
        	if (start > end) {
                return null;
            }else{
                SegmentTreeNode ret = new SegmentTreeNode(start, end);
                if (start == end) {
                    ret.sum = nums[start];
                }else{
                    int mid = start  + (end - start) / 2;             
                    ret.left = buildTree(nums, start, mid);
                    ret.right = buildTree(nums, mid + 1, end);
                    ret.sum = ret.left.sum + ret.right.sum;
                }         
                return ret;
            }
        }
	}
}
