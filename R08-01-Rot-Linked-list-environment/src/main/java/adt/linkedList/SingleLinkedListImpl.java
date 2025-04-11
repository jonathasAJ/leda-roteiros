package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = getHead();
		while (!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = getHead();
		while (!auxHead.isNIL() && !auxHead.data.equals(element)) {
			auxHead = auxHead.next;
		}
		return auxHead.data;
		
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = getHead();
		if (this.head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>();
			newHead.data = element;
			newHead.next = this.head;
			setHead(newHead);
		} else {
			while (!auxHead.isNIL()) {
				auxHead = auxHead.next;
			}
			auxHead.data = element;
			auxHead.next = new SingleLinkedListNode<>();
		}
	}

	@Override
	public void remove(T element) {
		if (this.head.data == element) {
			this.head = this.head.next;
		} else {
			SingleLinkedListNode<T> auxHead = getHead();
			while (!auxHead.isNIL() && !auxHead.data.equals(element)) {
				auxHead = auxHead.next;
			}
			if (!auxHead.isNIL()) {
				auxHead.data = auxHead.next.data;
				auxHead.next = auxHead.next.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		SingleLinkedListNode<T> auxHead = getHead();
		int i = 0;
		while (!auxHead.isNIL()) {
			result[i] = auxHead.data;
			auxHead = auxHead.next;
			i++;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
