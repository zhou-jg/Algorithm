package basic.recursion;

/**
 * Source: https://leetcode.com/problems/word-search/
 *
 * <p>Given a 2D board and a word, find if the word exists in the grid.
 *
 * <p>The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * <p>For example,<br>
 * Given <b>board</b> =
 * <code>[
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]</code>
 * <b>word</b> = "ABCCED", -> returns true,<br>
 * <b>word</b> = "SEE", -> returns true,<br>
 * <b>word</b> = "ABCB", -> returns false.

 * <p></p>Created by zhou-jg on 2017/2/3.
 */
public class WordSearchInBoard {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return true;
        }
        char[] cs = word.toCharArray();
        boolean[][] visited = new boolean[board.length][];
        for (int i=0; i<visited.length; i++){
            visited[i] = new boolean[board[i].length];
        }
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == cs[0]){
                    visited[i][j] = true;
                    if (helper (board, i, j, visited, cs, 1)){
                        return true;
                    }else{
                        visited[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int row, int col, boolean[][] visited, char[] word, int pos){
        if (pos == word.length){
            return true; //所查找的字符串就有一个字符/长度为1的情况
        }
        if (pos == word.length-1){
            if (row != 0 && !visited[row-1][col] && board[row-1][col] == word[pos] ||
                    col != board[0].length-1 && !visited[row][col+1] && board[row][col+1] == word[pos] ||
                    row != board.length-1 && !visited[row+1][col] && board[row+1][col] == word[pos] ||
                    col != 0 && !visited[row][col-1] && board[row][col-1] == word[pos]){
                return true;
            }else{
                return false;
            }
        }
        if (row != 0 && !visited[row-1][col] && board[row-1][col] == word[pos]){
            visited[row-1][col] = true;
            if (helper(board, row-1, col, visited, word, pos+1)){
                return true;
            }
            visited[row-1][col] = false;
        }
        if (col != board[0].length-1 && !visited[row][col+1] && board[row][col+1] == word[pos]){
            visited[row][col+1] = true;
            if (helper(board, row, col+1, visited, word, pos+1)){
                return true;
            }
            visited[row][col+1] = false;
        }
        if (row != board.length-1 && !visited[row+1][col] && board[row+1][col] == word[pos]){
            visited[row+1][col] = true;
            if (helper(board, row+1, col, visited, word, pos+1)){
                return true;
            }
            visited[row+1][col] = false;
        }
        if (col != 0 && !visited[row][col-1] && board[row][col-1] == word[pos]){
            visited[row][col-1] = true;
            if (helper(board, row, col-1, visited, word, pos+1)){
                return true;
            }
            visited[row][col-1] = false;
        }
        return false;
    }
}
