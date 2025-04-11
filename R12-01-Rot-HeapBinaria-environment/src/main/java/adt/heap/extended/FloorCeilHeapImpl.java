package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		Integer result = null;

		for (int i = 0; i < array.length; i++) {
			insert(array[i]);
		}
		
		result = floor(numero, result);

		return result;
		
	}

	private Integer floor(double numero, Integer floor) {

		Integer result = floor;
		Integer root = extractRootElement();

		if (root != null) {

			if (numero >= root && (floor == null || root >= floor )) {
				result = floor(numero, root);
			} else {
				result = floor(numero, result);
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		
		Integer result = null;

		for (int i = 0; i < array.length; i++) {
			insert(array[i]);
		}
		result = ceil(numero, result);

		return result;


	}

	private Integer ceil(double numero, Integer ceil) {

		Integer result = ceil;
		Integer root = extractRootElement();

		if (root != null) {
			if (numero <= root && (ceil == null || ceil > root)) {
				result = ceil(numero, root);
			} else {
				result = ceil(numero, result);
			}
		}
		return result;
	}
}
