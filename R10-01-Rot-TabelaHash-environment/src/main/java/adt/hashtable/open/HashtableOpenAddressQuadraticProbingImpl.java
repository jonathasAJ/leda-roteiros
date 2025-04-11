package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element) == null) {
			int prob = 0;

			while(prob <= size()) {
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

			while(prob <= size()) {
				int index = getHash(element, prob);

				if (this.table[index] != null) {
					if (this.table[index].equals(element)) {
						this.table[index] = deletedElement;
						this.elements--;
						break;
				}
			}
			prob++;
			}
		} 
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			int prob = 0;

			while(prob <= size()) {
				int index = getHash(element, prob);

				if (this.table[index] != null) {

					if (this.table[index].equals(element)) {
						result = element;
						break;
					} else {
						prob++;
					}
				} else {
					break;
				}
			}
		}
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		if (element != null) {
			int prob = 0;

			while(prob <= size()) {
				int index = getHash(element, prob);

				if(this.table[index] != null) {

					if(!(this.table[index].equals(element))) {
						
					} else {
						result = index;
					}
				} else {
					break;
				}
				prob++;
			}
		}
		return result;
	}

	private int getHash(T element, int prob) {
		return ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, prob);
	}
}
