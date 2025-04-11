package adt.bst.questoes;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BSTSumLeaves extends BSTImpl<Integer>{

    public int sumLeaves(BST<Integer> bst) {

        int result = 0;
        if (bst != null && !bst.isEmpty()) {
            result = sumLeaves(((BSTNode<Integer>) bst.getRoot()));
        }

        return result;
    }

    private int sumLeaves(BSTNode<Integer> node) {

        int result = 0;

        if (node != null) {
            
            if (node.isLeaf()) {
                result = node.getData();
            } else {
                result = sumLeaves(((BSTNode<Integer>) node.getLeft())) + sumLeaves(((BSTNode<Integer>) node.getRight()));
            }
        }
        return result;
    }
}
