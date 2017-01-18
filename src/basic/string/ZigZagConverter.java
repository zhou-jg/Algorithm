package basic.string;

/**
Source: https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class ZigZagConverter{
  public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }else{
            StringBuilder[] sb = new StringBuilder[numRows];
            int len = s.length() / numRows ;
            len = len > 0 ? len : 1;
            for (int i=0; i<sb.length; i++){
                sb[i] = new StringBuilder(len);
            }
            int row=0, direction = 1;
            for (char c : s.toCharArray()){
                sb[row].append(c);
                if (direction == 1){
                    row++;
                    if (row==numRows){
                        row = numRows - 2;
                        direction = 0;
                    }
                }else{
                    row--;
                    if (row==-1){
                        row=1;
                        direction =1;
                    }
                }
            }
            
            StringBuilder ret = new StringBuilder(s.length());
            for (StringBuilder b : sb){
                ret.append(b.toString());
            }
            
            return ret.toString();
        }
    }
 }
