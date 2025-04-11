package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer result = null;

		if (array != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				insert(array[i]);
			}
			result = floor(getRoot(), numero, result);
		}

		return result;
	}

	private Integer floor(BSTNode<Integer> node, double numero, Integer floor) {
		Integer result = floor;

		if (!node.isEmpty()) {
			if (node.getData() == numero) {
				result = node.getData();
			}
	
			if (node.getData() > numero) {
				result = floor(((BSTNode<Integer>) node.getLeft()), numero, result);
			} else {
				result = floor(((BSTNode<Integer>) node.getRight()), numero, node.getData());
			}
		}

		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer result = null;

		if (array != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				insert(array[i]);
			}
			result = ceil(getRoot(), numero, result);
		}
		return result;
	}

	private Integer ceil(BSTNode<Integer> node, double numero, Integer ceil) {
		Integer result = ceil;

		if (!node.isEmpty()) {
			if (node.getData() == numero) {
				result = node.getData();
			}

			if (node.getData() < numero) {
				result = ceil(((BSTNode<Integer>) node.getRight()), numero, result);
			} else {
				result = ceil(((BSTNode<Integer>) node.getLeft()), numero, node.getData());
			}
		}
		return result;
	}
}
