package basic.number;

/**
 * Created by zhou-jg on 2017/1/16.
 */
public class DigitOneCounter {
    public int count(int n){
        int count = 0;
        int factor = 1;
        int lowerNum = 0;
        int currNum = 0;
        int higherNum = 0;

        while (n/factor != 0){
            lowerNum = n - n / factor * factor;
            currNum = n / factor % 10;
            higherNum = n / (factor * 10);

            switch (currNum){
                case 0: count+=higherNum * factor; break;
                case 1: count+=higherNum * factor + lowerNum + 1; break;
                default: count += (higherNum + 1) * factor; break;
            }
            factor *= 10;
        }

        return count;
    }

    /**
     * 参考：https://discuss.leetcode.com/topic/18972/ac-short-java-solution
     * @param n
     * @return
     */
    public int count2(int n){
        int count = 0;

        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }

        return count;
    }
}
