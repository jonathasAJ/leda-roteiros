package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.extended.FloorCeilBSTImpl;
import adt.bt.BTNode;

public class StudentBSTTest {

	private BSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();
	private BSTImpl<Integer> tree1;
	private BSTImpl<Integer> tree2;
	private BSTImpl<Integer> tree3;

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	private void fillTree1() {
		Integer[] array = {7, 4, 9, 2, 5, 8, 10};
		for (int i : array) {
			tree1.insert(i);
		}
	}

	private void fillTree2() {
		Integer[] array = {15, 10, 17, 7, 13, 16, 20};
		for (int i : array) {
			tree2.insert(i);
		}
	}

	private void fillTree3() {
		Integer[] array = {15, 10, 17, 7, 13, 16, 20};
		for (int i : array) {
			tree3.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
		tree1 = new BSTImpl<>();
		tree2 = new BSTImpl<>();
		tree3 = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}

	@Test
	public void testIsSimilar() {

		SimpleBSTManipulationImpl<Integer> s = new SimpleBSTManipulationImpl<>();

		fillTree1();
		fillTree2();
		fillTree3();

		assertTrue(s.isSimilar(tree1, tree2));
	}

	@Test
	public void testEquals() {
		SimpleBSTManipulationImpl<Integer> s = new SimpleBSTManipulationImpl<>();

		fillTree1();
		fillTree2();
		fillTree3();

		assertTrue(s.equals(tree2, tree3));
		assertFalse(s.equals(tree1, tree2));

	}

	@Test
	public void testOrderStatistics() {
		SimpleBSTManipulationImpl<Integer> s = new SimpleBSTManipulationImpl<>();

		fillTree1();

		assertEquals(new Integer(2), s.orderStatistic(tree1, 1));
		assertEquals(new Integer(10), s.orderStatistic(tree1, 7));
		assertEquals(null, s.orderStatistic(tree1, 8));
	}

	@Test
	public void testFloor() {
		FloorCeilBSTImpl f = new FloorCeilBSTImpl();

		Integer[] array = {7, 4, 9, 2, 5, 8, 10};
		Integer[] array1 = {};

		assertEquals(new Integer(5), f.floor(array, 6));
		assertEquals(null, f.floor(array1, 7));
	}

	@Test
	public void testCeil() {
		FloorCeilBSTImpl c = new FloorCeilBSTImpl();

		Integer[] array = {7, 4, 9, 2, 5, 8, 10};
		Integer[] array1 = {};

		assertEquals(new Integer(7), c.ceil(array, 6));
		assertEquals(null, c.floor(array1, 7));
	}
}
