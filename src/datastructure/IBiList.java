package datastructure;

import java.util.ArrayList;
import java.util.List;

public interface IBiList<T> {
	T getData();
	IBiList<T> getPre();
	IBiList<T> getNext();

	default List<T> toList(boolean flag) {
		List<T> list = new ArrayList<>();
		if (flag){
			IBiList<T> head = head();
			list.add(head.getData());
			while((head = head.getNext()) != null){
				list.add(head.getData());
			}
		}else{
			IBiList<T> tail = tail();
			list.add(tail.getData());
			while((tail = tail.getPre()) != null){
				list.add(tail.getData());
			}
		}
		return list;
	}

	default IBiList<T> head() {
		IBiList<T> previous = getPre();
		if (previous == null){
			return this;
		}else{			
			while (previous.getPre() != null){
				previous = previous.getPre();		
			}			
			return previous;
		}		
	}

	default IBiList<T> tail() {
		IBiList<T> next = getNext();
		if (next == null){
			return this;
		}else{
			while (next.getNext() != null){
				next = next.getNext();
			}
			return next;
		}
	}
}
