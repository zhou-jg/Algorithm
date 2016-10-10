package util;

/**
 * 一个一般化的二元组
 * @author Jingang Zhou
 *
 * @param <T> 左半部分的类型
 * @param <R> 有半部分的类型
 */
public class GPair<T, R> {

	protected final T left;
	protected final R right;

	public GPair(T left, R right) {
		super();
		this.left = left;
		this.right = right;
	}

	public T getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("left: ");
		sb.append(left == null? "null" : left.toString());
		sb.append("; right: ");
		sb.append(right == null? "null" : right.toString());
		return sb.toString();
	}
}