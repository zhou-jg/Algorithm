package basic;

/**
Source: https://leetcode.com/problems/battleships-in-a-board/

Given an 2D board, count how many different battleships are in it. 
The battleships are represented with 'X's, empty slots are represented with '.'s. 
You may assume the following rules:
<br>
<li>You receive a valid board, made of only battleships or empty slots.<br>
<li>Battleships can only be placed horizontally or vertically. In other words, 
they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), 
where N can be of any size.<br>
<li>At least one horizontal or vertical cell separates between two 
battleships - there are no adjacent battleships.<br>
<b>Example:</b>
X..X<br>
...X<br>
...X<br>
In the above board there are 2 battleships.<br>
<b>Invalid Example:</b><br>
...X<br>
XXXX<br>
...X<br>
This is an invalid board that you will not receive - as battleships will always
have a cell separating between them.
*/
public class BattleshipInBoardCounter{
  public int countBattleships(char[][] board) {
        int count = 0;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == 'X'){
                    if (i==0){
                        if (j==0){
                            count++;
                        }else if (board[i][j-1] != 'X'){
                            count++;
                        }
                    }else{
                        if (j==0){
                            if (board[i-1][j] !='X'){
                                count++;
                            }
                        }else if (board[i-1][j] != 'X' && board[i][j-1] != 'X'){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
