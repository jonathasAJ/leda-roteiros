package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array == null) {
			return null;
		} else {
			int leftIndex = 0;
			int rightIndex = array.length-1;
			ordena(array, leftIndex, rightIndex);
			return floor(array, x, leftIndex, rightIndex);
		}
	}

	private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex) {
			return null;
		} else {

			int indexMeio = (leftIndex + rightIndex) / 2;
			if (array[indexMeio].compareTo(x) == 0) {
				return array[indexMeio];
			}
			Integer possivelFloor = null;
			if (array[indexMeio].compareTo(x) < 0) {
				possivelFloor = floor(array, x, indexMeio+1, rightIndex);
				if (possivelFloor == null) {
					return array[indexMeio];
				} else {
					return possivelFloor;
				}
			}

			if (array[indexMeio].compareTo(x) > 0) {
				possivelFloor = floor(array, x, leftIndex, indexMeio-1);
			}

			return possivelFloor;
		}
	}

	private void ordena(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {

		} else {
			int indexPivot = partition(array, leftIndex, rightIndex);
			ordena(array, leftIndex, indexPivot-1);
			ordena(array, indexPivot+1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int indexMeio = (leftIndex + rightIndex) / 2;
		ordenaEsquerdaMeioDireira(array, leftIndex, rightIndex);
		Util.swap(array, indexMeio, rightIndex-1);
		Integer pivot = array[rightIndex-1];

		int i = leftIndex;

		for (int j = i; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				Util.swap(array, i, j);
				i++;
			}
		}

		Util.swap(array, i, rightIndex-1);
		return i;

		}

		private void ordenaEsquerdaMeioDireira(Integer[] array, int leftIndex, int rightIndex) {
		int centerIndex = (leftIndex + rightIndex) / 2;

		if (array[leftIndex].compareTo(array[centerIndex]) > 0) {
			Util.swap(array, leftIndex, centerIndex);
		}

		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}

		if (array[centerIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, centerIndex, rightIndex);
	
		}
	}
}