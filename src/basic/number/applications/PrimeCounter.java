package basic.number.applications;

import java.util.ArrayList;
import java.util.List;

public class PrimeCounter {
	/**
	 * count the number of primes that is less than n.
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
        List<Integer> list = new ArrayList<Integer>();
        line: for (int i=2; i < n; i++){
        	for (int j=0; j < list.size(); j++){
        		int p = list.get(j);
        		if (i % p == 0){
        			continue line;
        		}else if (i < p * p){
        			break;
        		}
        	}
        	list.add(i);
        }
        return list.size();
    }
}
