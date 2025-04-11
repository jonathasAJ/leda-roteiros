package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
	
		if (array == null || leftIndex >= rightIndex) {

		} else {
			int maior = pegaMaior(array);
			int menor = pegaMenor(array);

			int tamanhoOcorrencias = pegaTamanho(array, maior, menor);
			int[] ocorrencias = new int[tamanhoOcorrencias];

			for (int i = 0; i < array.length; i++) {
				ocorrencias[array[i]-menor]++;
			}

			int l = 0;
			for (int k = 0; k < ocorrencias.length; k++) {

				while (ocorrencias[k] > 0) {
					array[l] = k + menor;
					ocorrencias[k]--;
					l++;
				}
			}
		}
	}

	private int pegaTamanho(Integer[] array, int maior, int menor) {
		int tamanho = maior - menor + 1;
		return tamanho;
	}

	private int pegaMenor(Integer[] array) {
		int menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}

	private int pegaMaior(Integer[] array) {
		int maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}
}
