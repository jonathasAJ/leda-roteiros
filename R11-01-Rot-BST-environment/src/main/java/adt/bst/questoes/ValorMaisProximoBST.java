package adt.bst.questoes;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class ValorMaisProximoBST extends BSTImpl<Integer> {

    public Integer pegaValorProximo(Integer[] array, double numero) {

        Integer result = null;

        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                insert(array[i]);
            }
            result = pegaValorProximo(numero, getRoot(), null);
        }

        return result;
    }
    

    private Integer pegaValorProximo(double numero, BSTNode<Integer> node, Integer possivel) {

        Integer result = possivel;

        if (!node.isEmpty()) {
            
            if (node.getData() == numero) {
                result = node.getData();
            } else {
                if (node.getData() < numero && (possivel == null || Math.abs(node.getData() - numero) < Math.abs(possivel - numero))) {
                    result = pegaValorProximo(numero, ((BSTNode<Integer>)node.getRight()), node.getData());
                }
    
                if (node.getData() > numero && (possivel == null || Math.abs(node.getData() - numero) < Math.abs(possivel - numero))) {
                    result = pegaValorProximo(numero, ((BSTNode<Integer>) node.getLeft()), node.getData());
                }
            }
        }

        return result;
    
    }
}
