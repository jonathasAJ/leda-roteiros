package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		// lista1 = new DoubleLinkedListImpl<>();
		// lista2 = new DoubleLinkedListImpl<>();
		// lista3 = new DoubleLinkedListImpl<>();

		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] {4, 3, 2, 1}, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {1}, lista1.toArray());
		
	}

	@Test
	public void testRemoveFirstUmElemento() {
		((DoubleLinkedList<Integer>) lista3).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {3, 2}, lista1.toArray());
	}

	@Test
	public void testRemoveLastUmElemento() {
		((DoubleLinkedList<Integer>) lista3).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testInsertFirstUmElemento() {
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] {4}, lista2.toArray());
	}

	@Test
	public void testInsert() {
		((DoubleLinkedList<Integer>) lista2).insert(1);
		((DoubleLinkedList<Integer>) lista2).insert(3);
		Assert.assertArrayEquals(new Integer[] {1, 3}, lista2.toArray());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}
}