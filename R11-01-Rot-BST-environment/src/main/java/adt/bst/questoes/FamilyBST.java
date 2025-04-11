package adt.bst.questoes;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FamilyBST extends BSTImpl<Integer>{
    

    public boolean primosPrimeiroGrau(Integer elem1, Integer elem2) {

        boolean result = false;

        if (!isEmpty() && elem1 != null && elem2 != null) {
            BSTNode<Integer> node1 = search(elem1);
            BSTNode<Integer> node2  = search(elem2);

            if (node1 != getRoot() && node2 != getRoot() && !node1.isEmpty() && !node2.isEmpty()) {
                result = pegaGrau(node1, node2);
            }
        }
        return result;
    }

    public boolean primosSegundoGrau(Integer elem1, Integer elem2) {
        
        boolean result = false;

        if (!isEmpty() && elem1 != null && elem2 != null) {
            BSTNode<Integer> node1 = ((BSTNode<Integer>) search(elem1).getParent());
            BSTNode<Integer> node2  = ((BSTNode<Integer>) search(elem2).getParent());

            if (node1 != null && node2 !=  null && node1 != getRoot() && node2 != getRoot() && !node1.isEmpty() && !node2.isEmpty()) {
                result = primosPrimeiroGrau(node1.getData(), node2.getData());
            }
        }
        return result;
    }

    private boolean pegaGrau(BSTNode<Integer> node1, BSTNode<Integer> node2) {
        BSTNode<Integer> nodePai1 = ((BSTNode<Integer>) node1.getParent());
        BSTNode<Integer> nodePai2 = ((BSTNode<Integer>) node2.getParent());

        boolean result = false;

        if (nodePai1 != getRoot() && nodePai2 != getRoot() && nodePai1.getData() != nodePai2.getData()) {

            if (nodePai1.getParent().equals(nodePai2.getParent())) {
                result = true;
            }
        }

        return result;
    }

}