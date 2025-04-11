package problems;

import adt.linkedList.SingleLinkedListNode;

public class KEsimoSingleLinkedListInvertida {
    
    public SingleLinkedListNode<Integer> kEsimoInvertido(SingleLinkedListNode<Integer> node, int k) {

        int count = 0;

        SingleLinkedListNode<Integer> auxNode = node;

        while(!auxNode.isNIL()) {
            count++;
            auxNode = auxNode.getNext();
        }

        int position = count - k;

        SingleLinkedListNode<Integer> resultNode = node;

        while(position > 0) {
            resultNode = resultNode.getNext();
            position--;
        }

        return resultNode;
    }

    public SingleLinkedListNode<Integer> kEsimoInvertidoNoCount(SingleLinkedListNode<Integer> node, int k) {

        int pulo = k;

        SingleLinkedListNode<Integer> auxNode = node;

        while(pulo > 0) {
            auxNode = auxNode.getNext();
            pulo--;
        }

        SingleLinkedListNode<Integer> resultNode = node;

        while(!auxNode.isNIL()) {
            resultNode = resultNode.getNext();
            auxNode = auxNode.getNext();
        }

        return resultNode;
    }
}
