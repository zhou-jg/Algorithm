package basic.sorting.applications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.Algorithm;

public class CourseRecommendation {
	
	/**
	 * 依据某人的朋友所参加的课程来向某个推荐他还没用参加的课程。
	 * 这里的朋友指的是直接（1度）和2度朋友（朋友的朋友）。
	 * 简单起见，朋友和课程都以字符串表示。所推荐的课程以朋友参与的多少降序排列。
	 * @param user 给定需要推荐课程的用户
	 * @return 受欢迎度降序排列的课程列表
	 */
	@Algorithm(value = "application")
	public static List<String> getCourseToRecommend(String user){
		//获取所有的朋友
		List<String> directFriends = getDirectFriends(user);
		Set<String> allFriends = new HashSet<>(directFriends);
		for (String friend : directFriends){
			allFriends.addAll(getDirectFriends(friend));
		}
		allFriends.remove(user);
		
		//构建所有需要考虑的课程及其欢迎度
		Map<String, Integer> course2Number = new HashMap<>();
		Set<String> alreadyAttendedCourses = new HashSet<>(getAttendedCourses(user));
		for (String friend : allFriends){
			List<String> courses = getAttendedCourses(friend);
			for (String course : courses){
				if (alreadyAttendedCourses.contains(course)){
					continue;
				}else if (course2Number.containsKey(course)){
					course2Number.put(course, course2Number.get(course)+1);
				}else{
					course2Number.put(course, 1);
				}
			}
		}
		
		//排序
		List<CourseNumber> courses = new ArrayList<>(course2Number.size());
		for (String course : course2Number.keySet()){
			courses.add(new CourseNumber(course, course2Number.get(course)));
		}
		Collections.sort(courses, new Comparator<CourseNumber>() {
			public int compare(CourseNumber c1, CourseNumber c2) {
				return c2.getNumber() - c1.getNumber();
			};
		});
		
		//构造结果
		List<String> result = new ArrayList<>(courses.size());
		for (CourseNumber c : courses){
			result.add(c.getCourse());
		}
		
		return result;
	}
	
	//helper class for sorting
	static class CourseNumber{
		private final String course;
		private final int number;
		CourseNumber(String course, int number){
			this.course = course;
			this.number = number;
		}
		
		public String getCourse(){
			return course;
		}
		
		public int getNumber(){
			return number;
		}
	}
	
	/*
	 * 获得某个直接的（1度）朋友
	 * mock方法
	 */
	static List<String> getDirectFriends(String user){
		return Collections.emptyList();
	}
	/*
	 * 获得某个注册的课程
	 * mock方法
	 */	
	static List<String> getAttendedCourses(String user){
		return Collections.emptyList();
	}
}
