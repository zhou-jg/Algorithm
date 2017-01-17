package basic.string;

/**
Source: https://leetcode.com/problems/valid-anagram/

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
public class ValidAnagramChecker{
  public boolean isAnagram(String s, String t) {
        if (s==null && t== null){
			return true;
		}else if (s != null && t != null){
			if (s.length() != t.length()){
				return false;
			}else{
				StringBuilder sbs = new StringBuilder(s);
				StringBuilder sbt = new StringBuilder(t);
				outer: while (sbs.length() > 0){
					char c = sbs.charAt(0);
					for (int i=0; i<sbt.length(); i++){
						if (sbt.charAt(i) == c){
							sbt.deleteCharAt(i);
							sbs.deleteCharAt(0);
							continue outer;
						}
					}
					return false;
				}
				return true;
			}
		}else {
			return false;
		}
  }
}
