package basic.number;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
Source: https://leetcode.com/problems/merge-intervals/

<p>Given a collection of intervals, merge all overlapping intervals.
<p>For example,<br>
Given [1,3],[2,6],[8,10],[15,18],<br>
return [1,6],[8,10],[15,18].<br>
*/
public class IntervalMerger{
  public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
  
  public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null){
            return Collections.emptyList();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Interval val : intervals){
            if (map.containsKey(val.start)){
                int old = map.get(val.start);
                if (val.end > old){
                    map.put(val.start, val.end);
                }
            }else{
                map.put(val.start, val.end);
            }
        }
        List<Integer> starts = new ArrayList<>(map.keySet());
        Collections.sort(starts);
        int i=0, j=1;
        while (j<starts.size()){
            int s1 = starts.get(i);
            int s2 = starts.get(j);
            int e1 = map.get(s1);
            if (s2 <= e1){
                int e2 = map.get(s2);
                if (e2 > e1){
                    map.put(s1, e2);
                }
                map.remove(s2);
                starts.remove(j);
            }else{
                i=j;
                j++;
            }
        }
        List<Interval> ret = new ArrayList<>(map.size());
        for (int s : map.keySet()){
            ret.add(new Interval(s, map.get(s)));
        }
        
        return ret;
    }
}
