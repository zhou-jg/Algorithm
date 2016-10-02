package basic.queue.application;

import java.util.LinkedList;

/**
 * 实现一个队列，可以收容猫和狗。收养人可以指定收养猫、狗或任意，但需要遵循“最老”原则。
 * 思路：用一个年龄计数器来纪录每只动物的次序。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class DogAndCatQueue {
	private LinkedList<Dog> dogs = new LinkedList<>();
	private LinkedList<Cat> cats = new LinkedList<>();
	//年龄计数器
	private int order = 0;
	
	public void enqueue(Animal animal){		
		if (animal instanceof Dog){
			dogs.offerLast((Dog)animal);
		}else{
			cats.offerLast((Cat)animal);
		}		
		order++;
		animal.setOrder(order);
	}
	
	public Animal dequeueAny(){
		Dog dog = dogs.peekFirst();
		if (dog == null){
			return cats.pollFirst();
		}else{
			Cat cat = cats.peekFirst();
			if (cat == null){
				return dogs.pollFirst();
			}else{
				if (dog.getOrder() > cat.getOrder()){
					return cats.pollFirst();
				}else{
					return dogs.pollFirst();
				}
			}
		}
	}
	
	public Dog dequeueDog(){
		return dogs.pollFirst();
	}
	
	public Cat dequeueCat(){
		return cats.pollFirst();
	}
	
	public static abstract class Animal{
		protected String name;
		protected int order;
		protected Animal(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		
		private void setOrder(int order){
			this.order = order;
		}
		
		public int getOrder(){
			return order;
		}
	}
	
	public static class Cat extends Animal{
		public Cat(String name){
			super(name);
		}
	}
	
	public static class Dog extends Animal{
		public Dog(String name){
			super(name);
		}
	}
}



