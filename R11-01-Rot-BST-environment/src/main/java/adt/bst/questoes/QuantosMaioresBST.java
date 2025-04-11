package adt.bst.questoes;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class QuantosMaioresBST extends BSTImpl<Integer> {

    public Integer pegaMaiores(Integer[] array, double numero) {

        Integer result = null;

        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                insert(array[i]);
            }

            result = pegaMaiores(numero, getRoot(), 0);
        }
        return result;
    }


    private Integer pegaMaiores(double numero, BSTNode<Integer> node, Integer atual) {

        Integer result = atual;

        if (!node.isEmpty()) {
            if (node.getData() == numero) {
                result = atual + size(((BSTNode<Integer>) node.getRight()));
            }
    
            if (node.getData() > numero) {
                result = pegaMaiores(numero, ((BSTNode<Integer>) node.getLeft()), result + 1 + size((BSTNode<Integer>) node.getRight()));
            } else {
                result = pegaMaiores(numero, ((BSTNode<Integer>) node.getRight()), atual);
            }
        }

        return result;

    }
    
    private int size(BSTNode<Integer> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<Integer>) node.getLeft())
					+ size((BSTNode<Integer>) node.getRight());
		}
		return result;
	}
}
