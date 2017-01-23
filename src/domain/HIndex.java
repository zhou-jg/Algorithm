package domain;

import java.util.Arrays;

/**
 * Source: https://leetcode.com/problems/h-index/
 * 
 * <p>Given an array of citations (each citation is a non-negative integer) 
 * of a researcher, write a function to compute the researcher's h-index.
 * 
 * <p>According to the definition of h-index on Wikipedia: "A scientist has 
 * index <i>h</i> if <i>h</i> of his/her <i>N</i> papers have <b>at least</b> 
 * <i>h</i> citations each, and the other <i>N − h</i> papers have <b>no more 
 * than</b> <i>h</i> citations each."
 * 
 * <p>For example, given citations = [3, 0, 6, 1, 5], which means the researcher 
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations 
 * respectively. Since the researcher has 3 papers with <b>at least</b> 3 
 * citations each and the remaining two with <b>no more than</b> 3 citations 
 * each, his h-index is 3.
 *
 * <p><b>Note</b>: If there are several possible values for h, the maximum one 
 * is taken as the h-index.
 * 
 * @author Jingang Zhou
 */
public class HIndex {
	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0){
            return 0;
        }
        Arrays.sort(citations);
        int ret = 0;
        for (int i=citations.length-1; i>=0; i--){
            if (citations[i] <= ret){
                break;
            }else
                ret++;
        }
        return ret;
    }
}
