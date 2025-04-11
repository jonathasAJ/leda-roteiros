package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element) == null) {
			int prob = 0;

			while(prob <= this.table.length) {
				int index = getHash(element, prob);

				if (this.table[index] == null || this.table[index].equals(deletedElement)) {
					this.table[index] = element;
					this.elements++;
					break;
				} else {
					prob++;
					this.COLLISIONS++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int prob = 0;

			while (prob <= this.size()) {
				int index = getHash(element, prob);

				if (this.table[index] != null) {

					if (this.table[index].equals(element)) {
						this.table[index] = deletedElement;
						this.elements--;
						break;
					} else {
						prob++;
					}
				} else {
					break;
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			int prob = 0;

			while(prob <= this.table.length || result.equals(element)) {
				int index = getHash(element, prob);

				if (this.table[index] != null) {
					
					if (!(this.table[index].equals(element))) {

					} else {
						result = element;
					}
				} else {
					break;
				}
				prob++;
			}
		}
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;

		if(element != null) {
			int prob = 0;
			while (prob <= size()) {
				int index = getHash(element, prob);

				if (this.table[index].equals(element)) {
					result = index;
					break;
				} else {
					prob++;
				}
			}
		}
		return result;
	}

	private int getHash(T element, int prob) {
		return ((HashFunctionLinearProbing<T>) hashFunction).hash(element, prob);
	}
}
