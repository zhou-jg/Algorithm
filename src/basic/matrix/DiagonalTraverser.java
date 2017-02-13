package basic.matrix;

/**
 * Source: https://leetcode.com/problems/diagonal-traverse/
 *
 * <p></p>Given a matrix of M x N elements (M rows, N columns), return
 * all elements of the matrix in diagonal order as shown in the below
 * @see <a href="https://leetcode.com/static/images/problemset/diagonal_traverse.png">image.</a>
 *
 * <p><b>Example:</b><br>
 * Input:<br>
 * <pre>[
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]</pre>
    Output:  [1,2,4,7,5,3,6,8,9]}<br>
 *
 * Created by zhou-jg on 2017/2/13.
 */
public class DiagonalTraverser {
    public int[] traverse(int[][] matrix) {
        if (matrix == null){
            return null;
        }
        if (matrix.length == 0){
            return new int[0];
        }

        //direction标识移动的方向，右上为1，左下为0
        int row = 0, col = 0, direction = 1, index = 0;
        int[] ret = new int[matrix.length * matrix[0].length];
        while (index < ret.length){
            ret[index] = matrix[row][col];
            index++;

            if (direction == 1){
                row--; col++;
                //下面的两个条件判断有前后之分
                if (col == matrix[0].length){
                    col--;
                    row+=2;
                    direction = 0;
                }
                if (row < 0){
                    row++;
                    direction = 0;
                }
            }else {
                row++; col--;
                if (row == matrix.length){
                    row--;
                    col+=2;
                    direction = 1;
                }
                if (col < 0){
                    col++;
                    direction = 1;
                }
            }
        }

        return ret;
    }
}
