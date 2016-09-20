package basic.tree;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import util.BiTreeListAdaptor;
import util.NumberUtil;
import datastructure.IBiList;

public class BiTree2BiListTransformerTest {	
	private BiTreeListAdaptor<Integer> tree;
	private int[] ascending, descending; 
	
	//必须是二叉排序树
	@Before
	public void initData(){
		tree = new BiTreeListAdaptor<Integer>(6, 
				new BiTreeListAdaptor<Integer>(4, 
						new BiTreeListAdaptor<Integer>(3, null, null), 
						new BiTreeListAdaptor<Integer>(5, null, null)), 
				new BiTreeListAdaptor<Integer>(8, 
						new BiTreeListAdaptor<Integer>(7, null, null), 
						new BiTreeListAdaptor<Integer>(9, null, null)));
		ascending = new int[]{3, 4, 5, 6, 7, 8, 9};
		descending = new int[]{9, 8, 7, 6, 5, 4, 3};
	}

	@Test
	public void test() {
		IBiList<Integer> list = new BiTree2BiListTransformer<Integer>().transform(tree);
		assertArrayEquals(ascending, NumberUtil.fromObjects(list.toList(true).toArray(new Integer[ascending.length])));
		assertArrayEquals(descending, NumberUtil.fromObjects(list.toList(false).toArray(new Integer[descending.length])));		
	}

}
