package adt.bst.questoes;

import java.util.Arrays;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BSTBalanceada extends BSTImpl<Integer> {

    public BSTNode<Integer> preencheBalanceado(Integer[] array) {

        BSTNode<Integer> result = null;

        if (array != null) {
            result = preencheBalanceado(0, array.length-1, array);
        }

        return result;
    }

    private BSTNode<Integer> preencheBalanceado(int leftIndex, int rightIndex, Integer[] array) {

        BSTNode<Integer> node = new BSTNode<>();

        if (leftIndex > rightIndex ) {

        } else {
            int meio = (leftIndex + rightIndex) / 2;
            
            node.setData(array[meio]);
            node.setLeft(preencheBalanceado(leftIndex, meio-1, array));
            node.setRight(preencheBalanceado(meio+1, rightIndex, array));

        }

        return node;

    }


    public void preencheBalanceadoImpl(Integer[] array) {

        if (array != null) {
            preencheBalanceadoImpl(0, array.length-1, array);
        }

    }

    private void preencheBalanceadoImpl(int leftIndex, int rightIndex, Integer[] array) {


        if (leftIndex > rightIndex ) {

        } else {
            int meio = (leftIndex + rightIndex) / 2;   
   
            insert(array[meio]);
            preencheBalanceadoImpl(leftIndex, meio-1, array);
            preencheBalanceadoImpl(meio+1, rightIndex, array);

        }

    }
    
}
