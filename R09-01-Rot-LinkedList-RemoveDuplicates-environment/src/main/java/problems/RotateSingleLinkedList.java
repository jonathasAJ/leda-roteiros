package problems;

import adt.linkedList.SingleLinkedListNode;

public class RotateSingleLinkedList {
    
    public SingleLinkedListNode<Integer> rotate(SingleLinkedListNode<Integer> node, int k) {
    
        SingleLinkedListNode<Integer> auxNode = node;
        SingleLinkedListNode<Integer> headNode = node;
        
        while(k > 0) {
            
            while(!auxNode.getNext().isNIL()) {
                auxNode = auxNode.getNext();
            }

            auxNode.setNext(headNode);
            headNode = headNode.getNext();
            auxNode.getNext().setNext(new SingleLinkedListNode<>());
            k--;

        }

        return headNode;
    }
}
