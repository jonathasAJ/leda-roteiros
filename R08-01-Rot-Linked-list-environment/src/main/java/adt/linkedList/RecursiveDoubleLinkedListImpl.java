package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;
		
	public RecursiveDoubleLinkedListImpl() {
		
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			this.previous = new RecursiveDoubleLinkedListImpl<>();
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<>());
			setPrevious(new RecursiveDoubleLinkedListImpl<>());
			getPrevious().setNext(this);
		} else {
			RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<>();
			auxNode.setData(getData());
			auxNode.setNext(getNext());
			setData(element);
			setNext(auxNode);
			auxNode.setPrevious(this);
			((RecursiveDoubleLinkedListImpl<T>) auxNode.getNext()).setPrevious(auxNode);
		}
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {

		} else {
			if (getPrevious().isEmpty() && getNext().isEmpty()) {
				setData(null);
				setPrevious(null);
				setNext(null);
			} else {
				setData(getNext().getData());
				setNext(getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {

		} else {
			if (getNext().isEmpty()) {
				setData(null);
				setNext(null);
			} else {
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {

			if (getData().equals(element)) {

				if (getPrevious().isEmpty() && getNext().isEmpty()) {
					removeFirst();
				} else {
					setData(getNext().getData());
					setNext(getNext().getNext());
					if (getNext() != null) {
						((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
					}
				}
			} else {
				getNext().remove(element);
		}

		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
				if (getPrevious() == null) {
					setPrevious(new RecursiveDoubleLinkedListImpl<>());
					getPrevious().setNext(this);
				}
			} else {
				getNext().insert(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
}
