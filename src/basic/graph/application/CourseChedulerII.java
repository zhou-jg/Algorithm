package basic.graph.application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Source: https://leetcode.com/problems/course-schedule-ii/
 * 
 * <p>There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * <p>Some courses may have prerequisites, for example to take course 0 you 
 * have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * <p>Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * 
 * <p>There may be multiple correct orders, you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.
 * 
 * <p>For example:<br>
 * 2, [[1,0]]<br>
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So the correct course order is [0,1]<br>
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]<br>
 * There are a total of 4 courses to take. To take course 3 you should have 
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after 
 * you finished course 0. So one correct course order is [0,1,2,3]. Another 
 * correct ordering is[0,2,1,3].
 * 
 * @author Jingang Zhou
 */
public class CourseChedulerII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (prerequisites == null){
            prerequisites = new int[0][];
        }
        int[] res = new int[numCourses];
        //课程依赖度
        Map<Integer, Set<Integer>> degs = new HashMap<>();
        //反向依赖度，便于检索
        Map<Integer, Set<Integer>> opps = new HashMap<>();
        for (int[] pre : prerequisites){
            Set<Integer> set = degs.get(pre[0]);
            if (set == null){
                set = new HashSet<>();
                degs.put(pre[0], set);
            }
            set.add(pre[1]);
            set = opps.get(pre[1]);
            if (set == null){
                set = new HashSet<>();
                opps.put(pre[1], set);
            }
            set.add(pre[0]);
        }
        //依赖消减
        int index = 0;
        Set<Integer> courses = new HashSet<>(numCourses);
        for (int i=0; i<numCourses; i++){
            if (!degs.containsKey(i)){
                courses.add(i);
                res[index] = i;
                index++;
            }
        }
        numCourses -= courses.size();
        while (numCourses > 0){
            Iterator<Integer> cs = courses.iterator(); 
            Set<Integer> newCourses = new HashSet<>();
            while (cs.hasNext()){
                int c = cs.next();
                if (opps.containsKey(c)){
                    for (int o : opps.get(c)){
                        degs.get(o).remove(c);
                        if (degs.get(o).size() == 0){
                            degs.remove(o);
                            res[index] = o;
                            index++;
                            newCourses.add(o);
                        }
                    }
                }
            }
            if (newCourses.size() == 0){
                break;
            }else{
                courses = newCourses;
                numCourses -= courses.size();
            }
        }
        
        if (numCourses == 0){
        	return res;
        }else{
        	return new int[0];
        }
    }
}
