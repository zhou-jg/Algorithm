package basic.number.applications;

/**
 * Source: <a href="https://leetcode.com/problems/teemo-attacking/?tab=Description">
 *     https://leetcode.com/problems/teemo-attacking/</a>
 *
 * <p>In LLP world, there is a hero called Teemo and his attacking can
 * make his enemy Ashe be in poisoned condition. Now, given the Teemo's
 * attacking <b>ascending</b> time series towards Ashe and the poisoning
 * time duration per Teemo's attacking, you need to output the total time
 * that Ashe is in poisoned condition.
 *
 * <p>You may assume that Teemo attacks at the very beginning of a specific
 * time point, and makes Ashe be in poisoned condition immediately.
 *
 * <p><b>Example 1:</b>
 * <p><code><b>Input:</b> [1,4], 2<br>
 * <b>Output:</b> 4<br>
 * <b>Explanation:</b> At time point 1, Teemo starts attacking Ashe and makes
 * Ashe be poisoned immediately.<br>
 * This poisoned status will last 2 seconds until the end of time point 2.<br>
 * And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in
 * poisoned status for another 2 seconds.<br>
 * So you finally need to output 4.</code>
 *
 * <p><b>Example 2:</b>
 * <p><code><b>Input:</b> [1,2], 2<br>
 * <b>Output:</b> 3<br>
 * <b>Explanation:</b> At time point 1, Teemo starts attacking Ashe and makes
 * Ashe be poisoned.<br>
 * This poisoned status will last 2 seconds until the end of time point 2.<br>
 * However, at the beginning of time point 2, Teemo attacks Ashe again who is
 * already in poisoned status.<br>
 * Since the poisoned status won't add up together, though the second poisoning
 * attack will still work at time point 2, it will stop at the end of time point 3.<br>
 * So you finally need to output 3.</code>
 *
 * <p><b>Note:</b><br>
 * <li>You may assume the length of given time series array won't exceed 10000.
 * <li>You may assume the numbers in the Teemo's attacking time series and his
 * poisoning time duration per attacking are non-negative integers, which won't
 * exceed 10,000,000.
 *
 * <p>Created by zhou-jg on 2017/2/21.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i=1; i<timeSeries.length; i++){
            //Adds duration if the gap between two time points larger than the duration
            if (timeSeries[i] - timeSeries[i-1] >= duration){
                sum += duration;
            }else {
                //Adds time gap if the gap between two time points less than the duration.
                //We don't need to consider the extra time since a new attack will start a
                //new duration and we don't consider added up effect.
                sum += timeSeries[i] - timeSeries[i-1];
            }
        }
        sum += duration;

        return sum;
    }
}
