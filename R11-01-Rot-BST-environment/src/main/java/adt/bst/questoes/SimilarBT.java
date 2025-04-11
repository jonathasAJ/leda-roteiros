package adt.bst.questoes;

import adt.bt.BTNode;
import junit.runner.BaseTestRunner;

public class SimilarBT extends BTNode<Integer>{
    
    public boolean isSimilar(BTNode<Integer> node1,  BTNode<Integer> node2) {

        boolean result = false;

         if (node1 != null && node2 != null) {

            if (node1.isEmpty() && !node2.isEmpty() || !node1.isEmpty() && node2.isEmpty()) {
                result = false;
            } else {
                result = isSimilar(node1.getLeft(), node2.getLeft()) && isSimilar(node1.getRight(), node2.getRight());
            }
        } else {
            if (node1 == null && node2 == null) {
                result = true;
            }
        }
        return result;
    }
}
