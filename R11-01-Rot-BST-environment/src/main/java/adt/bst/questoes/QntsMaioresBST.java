package adt.bst.questoes;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class QntsMaioresBST extends BSTImpl<Integer>{
    
    public int pegaMaiores(Integer[] array, double numero) {

        int result = 0;

        if (array != null) {

            for (int i = 0; i < array.length; i++) {
                insert(array[i]);
            }

            result = pegaMaiores(((BSTNode<Integer>) getRoot()), numero, 0);
        }

        return result;
    }

    private int pegaMaiores(BSTNode<Integer> node, double numero, int atual) {

        int result = atual;

        if (!node.isEmpty()) {

            if (node.getData() == numero) {
                result = atual + size(((BSTNode<Integer>) node.getRight()));
            }
            if (node.getData() > numero) {
                result = pegaMaiores(((BSTNode<Integer>) node.getLeft()), numero, 1 + size((BSTNode<Integer>) node.getRight()));
            } else {
                result = pegaMaiores(((BSTNode<Integer>) node.getRight()), numero, atual);
            }
        }
        return result;

    }

    private int size(BSTNode<Integer> node) {
        int result = 0;
        if (!node.isEmpty()) {
            result = 1 + size(((BSTNode<Integer>) node.getLeft())) + size(((BSTNode<Integer>) node.getRight()));
        }
        return result;
    }
}
