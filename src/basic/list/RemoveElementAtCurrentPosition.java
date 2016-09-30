package basic.list;

import datastructure.List;

/**
 * 删除当前链表中的某个节点，并且只能访问该节点，即不知道头节点。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class RemoveElementAtCurrentPosition {
	
	/**
	 * 删除node所在的节点
	 * @param node
	 * @return 所删除的节点元素值
	 */
	public static <T> T deleteNode (List<T> node){
		if (node != null){
			T ret = node.getData();			
			if (node.getNext() == null){
				/* 注意：对于删除的节点是原链表中的最后一个节点的情况，只把引用置空是不够的，
				 * 需要把前一个节点的后续引用置空。*/
				node = null;
			}else{
				List<T> tmp = node;
				//哨兵
				List<T> next2 = node.getNext().getNext();
				while (next2 != null){
					tmp.setData(tmp.getNext().getData());
					tmp = tmp.getNext();
					next2 = next2.getNext();
				}
				tmp.setData(tmp.getNext().getData());
				tmp.setNext(null);				
			}
			
			return ret;
		}else{
			return null;
		}		
	}
}
