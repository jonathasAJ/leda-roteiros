package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;


	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) head;
	}


	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
		newHead.setData(element);
		newHead.setNext(head);
		newHead.setPrevious(new DoubleLinkedListNode<>());
		((DoubleLinkedListNode<T>) head).setPrevious(newHead);
		if (head.isNIL()) {
			setLast(newHead);
		}
		((DoubleLinkedListNode<T>) newHead.getNext()).setPrevious(newHead);
		newHead.getPrevious().setNext(newHead);
		setHead(newHead);

	}

	@Override
	public void removeFirst() {
		if (head.isNIL()) {

		} else {
			setHead(head.getNext());
			if (head.isNIL()) {
				setLast((DoubleLinkedListNode<T>) head);
			} else {
				((DoubleLinkedListNode<T>) head).setPrevious(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) head).getPrevious().setNext(head);
			}
		}
	}

	@Override
	public void removeLast() {
		if (last.isNIL()) {

		} else {
			setLast(last.getPrevious());
			if (last.isNIL()) {
				setHead(last);
			} else {
				last.setNext(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) last.getNext()).setPrevious(last);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (head.getData().equals(element)) {
			removeFirst();
		} else {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
			while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				auxHead = ((DoubleLinkedListNode<T>) auxHead.getNext());
			}
			if (!auxHead.isNIL()) {
				auxHead.getPrevious().setNext(auxHead.getNext());
				((DoubleLinkedListNode<T>) auxHead.getNext()).setPrevious(auxHead.getPrevious());
			}
		}
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
		newLast.setData(element);
		newLast.setNext(new DoubleLinkedListNode<>());
		newLast.setPrevious(last);
		((DoubleLinkedListNode<T>) newLast.getNext()).setPrevious(newLast);
		last.setNext(newLast);
		if (last.isNIL()) {
			setHead(newLast);
		}
		setLast(newLast);
	}

	@Override
	public T search(T element) {
		T result = null;
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
		DoubleLinkedListNode<T> auxLast = last;

		while (!auxHead.equals(auxLast) && !auxHead.next.equals(auxLast) && 
				!auxHead.getData().equals(element) && !auxLast.getData().equals(element)) {

			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
		}
		if (auxHead.getData().equals(element)) {
			result = auxHead.getData();
		}
		if (auxLast.getData().equals(element)) {
			result = auxLast.getData();
		}
		return result;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
