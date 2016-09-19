package util;

/**
 * A general object to describe a pair of something
 * @author Jingang Zhou
 *
 * @param <T> something's type
 */
public class Pair<T> {
	public final T left, right;
	public Pair(T left, T right){
		this.left = left;
		this.right = right;
	}
	
	public T getLeft(){
		return left;
	}
	
	public T getRight(){
		return right;
	}
}
