package basic.recursion.application;

import java.util.ArrayList;
import java.util.List;

import util.Algorithm;

/**
 * 来源：https://leetcode.com/problems/binary-watch/
 * @author Jingang Zhou
 *
 */
public class BinaryWatch {

	@Algorithm("递归")
	public List<String> readBinaryWatch(int num) {
        List<String> ret =  new ArrayList<String>();
        if (num < 0 || num > 8){
            return ret;
        }
        if (num == 0){
            ret.add("0:00");
            return ret;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        internalProcessing(ret, num, list, 0);

        return ret;
    }
    
	/**
	 * 
	 * @param list
	 * @param num
	 * @param time
	 * @param k 用来标识下次选项开始的索引，不用每次都从0开始，提高效率
	 */
    private void internalProcessing(List<String> list, int num, List<Integer> time, int k){
        if (num == 0){
            list.add(checkTime(time));
        }else{
            for (int i=k; i<10; i++){
                time.add(i);
                if (checkTime(time)== null){
                    time.remove(time.size()-1);
                    continue;
                }else{
                    internalProcessing(list, num-1, time, i+1);
                    time.remove(time.size()-1);
                }
            }
        }
    }
    
    private String checkTime(List<Integer> time){
        int hour = 0, minute = 0;
        for (int i : time){
            if (i<4){
                hour += getHour(i);
                if (hour > 11){
                    return null;
                }
            }else{
                minute += getMinute(i-4);
                if (minute > 59){
                    return null;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder(5);
        sb.append(hour);
        sb.append(":");
        sb.append(minute>=10? "" :"0" );
        sb.append(minute);
        return sb.toString();
    }
    
    private int getHour(int i){
        switch(i){
            case 0 : return 8;
            case 1 : return 4;
            case 2 : return 2;
            case 3 : return 1;
            default : return 0;
        }
    }
    
    private int getMinute(int i){
        switch(i){
            case 0 : return 32;
            case 1 : return 16;
            case 2 : return 8;
            case 3 : return 4;
            case 4 : return 2;
            case 5 : return 1;
            default : return 0;
        }
    }
    
	public static void main(String[] args) {
		System.out.println(new BinaryWatch().readBinaryWatch(1));
	}
}
