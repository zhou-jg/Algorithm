package basic.search.application;

/**
 * 根据反馈的大小来判断给定范围内的数到底哪个。
 * Created by zhou-jg on 2017/2/17.
 */
public class GuessNumber {
    //要判定的数
    private int num;
    GuessNumber(int num){
        this.num = num;
    }

    /**
     * 根据范围和反馈来判断数字
     * @param n 数字的范围
     * @return 
     */
    public int guessNumber(int n) {
        return guess(1, n);
    }

    private int guess(int start, int end){
        if (start == end){
            return start;
        }else{
            int mid = start + (end-start)/2;
            int r = guess(mid);
            if (r == 0){
                return mid;
            }else if (r > 0){
                return guess(start, mid-1);
            }else{
                return guess(mid+1, end);
            }
        }
    }

    /**
     * 给出猜测结果
     * @param num 猜测的数
     * @return 0：猜对了；1：比实际的数大；-1：比实际的数小
     */
    private int guess(int num){
        if (num > this.num){
            return 1;
        }else if (num < this.num){
            return -1;
        }else {
            return 0;
        }
    }
}
