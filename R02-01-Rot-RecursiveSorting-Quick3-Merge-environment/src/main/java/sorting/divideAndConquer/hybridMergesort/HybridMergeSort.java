package sorting.divideAndConquer.hybridMergesort;

import java.util.ArrayList;
import java.util.List;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if (leftIndex >= rightIndex) {

		} else {
			if (array.length <= HybridMergeSort.SIZE_LIMIT)  {
				insertionSort(array, leftIndex, rightIndex);
			} else {
				sort(array, leftIndex, (leftIndex + rightIndex) / 2);
				sort(array, (leftIndex + rightIndex)/2 + 1, rightIndex);
				mescla(array, leftIndex, (leftIndex + rightIndex)/2, rightIndex);
			}
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS++;


		for (int i = leftIndex; i < rightIndex+1; i++) {
			T obj = array[i];
			int j = i-1;
			while (j >= leftIndex && array[j].compareTo(obj) > 0) {
				Util.swap(array, j, j+1);
				j--;
			}
			obj = array[j+1];
			
		}
	}

	private void mescla(T[] array, int leftIndex, int centerIndex, int rightIndex) {
		MERGESORT_APPLICATIONS++;

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
