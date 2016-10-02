package basic.queue.application;

/**
 * 汉诺塔问题
 * @author Jingang Zhou
 *
 */
public class HanoiTower {

	/**
	 * 将n个盘子从柱A移动到柱C
	 * @param n 
	 * @param A
	 * @param B
	 * @param C
	 */
	public static void resolve(int n, char A, char B, char C){
		if (n == 1){
			System.out.println(A + " -> " + C);
		}else{
			resolve(n-1, A, C, B);
			System.out.println(A + " -> " + C);
			resolve(n-1, B, A, C);
		}
	}
	
	public static void main(String[] args){
		resolve(4, 'A', 'B', 'C');
	}
}
