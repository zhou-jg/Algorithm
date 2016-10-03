package datastructure;

import java.util.ArrayList;

public class List<T> {
	private T data;
	private List<T> next; 
	public List(T data){
		this.data = data;
	}
	public List<T> getNext(){
		return next;
	}
	public void setNext(List<T> next){
		this.next = next;
	}
	
	public T getData(){
		return data;
	}
	public void setData(T data){
		this.data = data;
	}
	
	@Override
	/**
	 * 尚不支持处理含有环的情况
	 */
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		if (obj instanceof List){
			List<T> p1 = this;
			List<?> p2 = (List<?>) obj;
			while (p1 != null && p2 != null){
				if (!p1.getData().equals(p2.getData())){
					return false;
				}else{
					p1 = p1.getNext();
					p2 = p2.getNext();
				}
			}
			if (p1 == p2){
				return true;
			}
		}
		return false;
	}
	
	public T[] toArray(T[] a){
		ArrayList<T> ret = new ArrayList<T>();
		List<T> node = this;
		while (node != null){
			ret.add(node.getData());
			node = node.getNext();
		}
		return ret.toArray(a);
	}
}
