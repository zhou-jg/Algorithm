package basic.number;

/**
 * Source: <a href="https://leetcode.com/problems/integer-to-english-words/">
 *     https://leetcode.com/problems/integer-to-english-words/</a>
 *
 * <p>Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than <code>pow(2,31)</code> - 1.
 *
 * <p>For example,<br>
 *     123 -> "One Hundred Twenty Three"<br>
 *     12345 -> "Twelve Thousand Three Hundred Forty Five"<br>
 *     1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"<br>
 * <p><b>Hint:</b>
 * <li>Did you see a pattern in dividing the number into chunk of words?
 * For example, 123 and 123000.
 * <li>Group the number by thousands (3 digits). You can write a helper
 * function that takes a number less than 1000 and convert just that chunk to words.
 * <li>There are many edge cases. What are some good test cases? Does your code
 * work with input such as 0? Or 1000010? (middle chunk is zero and should not be
 * printed out)
 *
 * Created by zhou-jg on 2017/2/17.
 */
public class NumToEnglishWords {
    int[] bits = new int[]{1000000000, 1000000, 1000, 100, 10, 1};
    String[] str1 = new String[]{"Billion", "Million", "Thousand", "Hundred"};
    String[] str2 = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] str3 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] str4 = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < bits.length){
            if (num >= bits[i]){
                int tmp = num / bits[i];
                num %= bits[i];
                buildString(sb, tmp, str1, i, num);
                if (tmp == 1 && i==4 || num == 0){
                    break;
                }
            }
            i++;
        }

        return sb.toString().trim();
    }

    private void buildString(StringBuilder sb, int val, String[] strs, int index, int num){
        if (index == 3){
            if (val <= 10){
                sb.append(str3[val-1]);
            }else if (val < 20){
                sb.append(str4[val-1]);
            }else{
                sb.append(numberToWords(val));
            }
            sb.append(" ");
            sb.append(strs[index]);
        }else if (index == 4){
            if (val >= 2){
                sb.append(str2[val-2]);
            }else{
                if (num == 0){
                    sb.append("Ten");
                }else{
                    sb.append(str4[num-1]);
                }
            }
        }else if (index == 5){
            sb.append(str3[val-1]);
        }else {
            sb.append(numberToWords(val));
            sb.append(" ");
            sb.append(strs[index]);
        }

        sb.append(" ");
    }
}
