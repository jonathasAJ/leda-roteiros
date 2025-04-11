package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array == null || leftIndex >= rightIndex) {

		} else {
			int maior = pegaMaior(array);
			int[] ocorrencias = new int[maior+1];

			
			for (int i = 0; i < array.length; i++) {
				ocorrencias[array[i]]++;
			}

			int l = 0;
			for (int k = 0; k < ocorrencias.length; k++) {

				while (ocorrencias[k] > 0) {
					array[l] = k;
					ocorrencias[k]--;
					l++;
				}
			}
		}
	}

	private int pegaMaior(Integer[] array) {
		int maior = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
		}
		return maior;
	}
}
