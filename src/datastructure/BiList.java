package datastructure;


public class BiList<T> implements IBiList<T>{
	private BiList<T> pre, next;
	private T data;
	
	public BiList<T> getPre() {
		return pre;
	}

	public void setPre(BiList<T> pre) {
		this.pre = pre;
	}

	public BiList<T> getNext() {
		return next;
	}

	public void setNext(BiList<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BiList(T data, BiList<T> pre, BiList<T> next){
		this.data = data;
		this.pre = pre;
		this.next = next;
	}	
	
}
