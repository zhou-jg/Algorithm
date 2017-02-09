package basic.number.applications;

import java.util.Arrays;

/**
 * Source: https://leetcode.com/problems/heaters/
 *
 * <p>Winter is coming! Your first job during the contest is to design a
 * standard heater with fixed warm radius to warm all the houses.
 *
 * <p>Now, you are given positions of houses and heaters on a horizontal line,
 * find out minimum radius of heaters so that all houses could be covered by
 * those heaters.
 *
 * <p>So, your input will be the positions of houses and heaters seperately,
 * and your expected output will be the minimum radius standard of heaters.
 *
 * <p><b>Note:</b><br>
 * <li>Numbers of houses and heaters you are given are non-negative and will
 * not exceed 25000.</li>
 * <li>Positions of houses and heaters you are given are non-negative and will
 * not exceed 10^9.</li>
 * <li>As long as a house is in the heaters' warm radius range, it can be warmed.</li>
 * <li>All the heaters follow your radius standard and the warm radius will the same.</li>
 *
 * <p><b>Example 1:</b><br>
 * Input: [1,2,3],[2] Output: 1<br>
 * Explanation: The only heater was placed in the position 2, and if we use
 * the radius 1 standard, then all the houses can be warmed.
 *
 * <p><b>Example 2:</b><br>
 * Input: [1,2,3,4],[1,4] Output: 1<br>
 * Explanation: The two heater was placed in the position 1 and 4. We need
 * to use radius 1 standard, then all the houses can be warmed.
 *
 * <p>Created by zhou-jg on 2017/2/9.
 */
public class HeatersForRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0;
        int r = 0;
        while (i < houses.length && j < heaters.length){
            if (houses[i] <= heaters[j]){
                if (j > 0){
                    int lr = Math.min(heaters[j] - houses[i], houses[i] - heaters[j-1]);
                    r = Math.max(r, lr);
                }else{
                    r = Math.max(r, heaters[j] - houses[i]);
                }
            }else {
                while (j < heaters.length && heaters[j] < houses[i]){
                    j++;
                }
                if (j == heaters.length){
                    return Math.max(houses[houses.length-1] - heaters[j-1], r);
                }else{
                    int lr = Math.min(houses[i] - heaters[j-1], heaters[j]- houses[i]);
                    r = Math.max(r, lr);
                }
            }
            i++;
        }

        return r;
    }
}
