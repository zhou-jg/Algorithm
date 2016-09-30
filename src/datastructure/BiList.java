package datastructure;


public class BiList<T> extends List<T> implements IBiList<T>{
	private BiList<T> pre, next;	
	
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

	public BiList(T data, BiList<T> pre, BiList<T> next){
		super(data);
		
		this.pre = pre;
		this.next = next;
	}	
	
}
