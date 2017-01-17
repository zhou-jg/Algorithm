package basic.number;

/**
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, 
it is represented by a single zero character '0'; otherwise, the first character 
in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"
*/
public class ToHex {
  public String toHex(int num) {
        StringBuilder sb = new StringBuilder(8);
        int tmp = num;
        for (int i=0; i<8; i++){
            int v = tmp & 0xf;
            if (v < 10){
                sb.insert(0, v);
            }else{
                char c = (char) ('a'+ v - 10);
                sb.insert(0, c);
            }
            tmp >>= 4;
        }
        while (sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0){
            return "0";
        }else{
            return sb.toString();
        }
    }
}
