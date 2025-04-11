package adt.linkedList;


public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return getData() == null;
	}

	@Override
	public int size() {
		int size = 0;
		if (isEmpty()) {
		
		} else {
			size = 1 + next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T result;
		if (isEmpty()) {
			result = null; 
		} else {
			if (getData() == element) {
				result = element;
			} else {
				result = next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			setData(element);
			next = new RecursiveSingleLinkedListImpl<>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) {

		} else {
			if (getData() == element) {
				setData(next.getData());
				setNext(next.next);
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		if (getData() == null) {

		} else {
			int i = 0;
			result[i] = getData();
			next.toArrayAux(result, i+1);
		}
		return result;
	}

	private void toArrayAux(T[] array, int count) {
		if (getData() == null) {

		} else {
			int i = count;;
			array[i] = getData();
			next.toArrayAux(array, i+1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
