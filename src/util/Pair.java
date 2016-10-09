package util;

/**
 * A general object to describe a pair of something
 * @author Jingang Zhou
 *
 * @param <T> something's type
 */
public class Pair<T> extends GPair<T, T> {
	public Pair(T left, T right){
		super(left, right);
	}
}
