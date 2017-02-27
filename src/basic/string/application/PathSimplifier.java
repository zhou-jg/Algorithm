package basic.string.application;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://leetcode.com/problems/simplify-path/?tab=Description
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 *  In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/'
 * together, such as "/home//foo/".
 *  In this case, you should ignore redundant slashes and return "/home/foo".
 *  
 * Created by zhou-jg on 2017/2/27.
 */
public class PathSimplifier {
    public String simplifyPath(String path) {
        if (path == null || path.trim().length() == 0){
            return path;
        }
        String[] parts = path.trim().split("/");
        List<String> list = new ArrayList<>(parts.length);
        for (String str : parts){
            if (str.length() > 0 && !str.equals(".")){
                list.add(str);
            }
        }
        for (int i=0; i<list.size(); i++){
            if (list.get(i).equals("..")){
                list.remove(i);
                if (i>0) {
                    list.remove(i - 1);
                    i--;
                }
                i--;
            }
        }

        if (list.size() == 0){
            return "/";
        }else {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append("/");
                sb.append(str);
            }

            return sb.toString();
        }
    }
}
