/**
*题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
*分析：这道题是2006 年google 的一道笔试题。
*/
public class FirstUniqueCharFinder {
  public char find(String str){
    Objects.requireNonNull(str);
    StringBuilder sb = new StringBuilder(str);
    int j = 1;
    while (j < sb.length()){
      for (int i = 0; i < j; i++){
        if (sb.charAt(i) == sb.charAt(j)){
          sb.deleteCharAt(j);
          sb.deleteCharAt(i);
          j--;
          break;
        }
      }
      j++;
    }
    return sb.charAt(0);
  }
}
