package adt.bst.questoes;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class orderStatistics {
    
    public Integer order(BST<Integer> tree, int k) {

        int result = -1;
        if (tree != null && k > 0 && k <= tree.size()) {
            result = order(((BSTNode<Integer>) tree.getRoot()), k);
        }

        return result;
    }

    private Integer order(BSTNode<Integer> node, int k) {
        
        int result = -1;
        if (node != null) {

            if (size(((BSTNode<Integer>) node.getLeft())) + 1 == k) {
                result = node.getData();
            } else {
                if (size(((BSTNode<Integer>) node.getLeft())) + 1 > k) {
                    result = order(((BSTNode<Integer>) node.getLeft()), k);
                } else {
                    result = order(((BSTNode<Integer>) node.getRight()), k - (size(((BSTNode<Integer>) node.getLeft())) + 1));
                }
            }
        }
        return result;
    }

    public int size(BSTNode<Integer> node) {
        int result = 0;
        if (!node.isEmpty()) {
            result = 1 + size(((BSTNode<Integer>) node.getLeft())) + size(((BSTNode<Integer>) node.getRight()));
        }
        return result;
    }
}
