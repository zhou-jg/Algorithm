package basic.graph.application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Source: https://leetcode.com/problems/course-schedule/
 * 
 * <p>There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * <p>Some courses may have prerequisites, for example to take course 0 you 
 * have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * <p>Given the total number of courses and a list of prerequisite <b>pairs</b>, 
 * is it possible for you to finish all courses?
 * 
 * <p>For example:<br>
 * 2, [[1,0]]<br>
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So it is possible.
 * 
 * <p>2, [[1,0],[0,1]]<br>
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0, and to take course 0 you should also have finished 
 * course 1. So it is impossible.
 * 
 * @author Jingang Zhou
 *
 */
public class CourseCheduler {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            return true;
        }
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
        Set<Integer> courses = new HashSet<>(numCourses);
        for (int i=0; i<numCourses; i++){
            courses.add(i);
        }
        while (courses.size() > 0){
            Iterator<Integer> cs = courses.iterator(); 
            Set<Integer> newCourses = new HashSet<>();
            while (cs.hasNext()){
                int c = cs.next();
                if (!degs.containsKey(c)){
                    if (opps.containsKey(c)){
                        for (int o : opps.get(c)){
                            degs.get(o).remove(c);
                            if (degs.get(o).size() == 0){
                                degs.remove(o);
                                newCourses.add(o);
                            }
                        }
                    }
                    cs.remove();
                }
            }
            if (newCourses.size() == 0){
                break;
            }
        }
        
        return courses.size() == 0;
	}
}
