package sorting.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			
		} else {
			sort(array, leftIndex, (leftIndex + rightIndex)/2);
			sort(array, (leftIndex + rightIndex)/2 + 1, rightIndex);
			mescla(array, leftIndex, (leftIndex + rightIndex)/2, rightIndex);
			
		}
	}

	private void mescla(T[]array,int leftIndex, int centerIndex, int rightIndex) {
		List <T> leftList = divideLista(array, leftIndex, centerIndex);
		List <T> rightList = divideLista(array, centerIndex + 1, rightIndex);

//		List <T> result = new ArrayList<>();
		int l = 0;
		int r = 0;
		int atual = leftIndex;

		while (l < leftList.size() && r < rightList.size()) {
			if (leftList.get(l).compareTo(rightList.get(r)) < 0) {
				array[atual] = leftList.get(l);
				atual++;
				l++;
			} else {
				array[atual] = rightList.get(r);
				atual++;
				r++;
			}
		}


		if (leftList.size() > l) {
			for (int i = l; i < leftList.size(); i++) {
				array[atual] = leftList.get(i);
				atual++;
			}
		}

		if (rightList.size() > r) {
			for (int i = r; i < rightList.size(); i++) {
				array[atual] = rightList.get(i);
				atual++;
			}
		}
	}

	private List<T> divideLista(T[]array, int leftIndex, int rightIndex) {

		List <T> lista = new ArrayList<>();

		for (int i = leftIndex; i <= rightIndex; i++) {
			lista.add(array[i]);
		}

		return lista;
	}
}
