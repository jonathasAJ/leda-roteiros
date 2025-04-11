package problems;

import adt.linkedList.SingleLinkedListNode;
import java.util.Stack;

public class ReversedLinkedList {
    

    public SingleLinkedListNode<Integer> reverse(SingleLinkedListNode<Integer> node) {

        SingleLinkedListNode<Integer> currNode = node;
        SingleLinkedListNode<Integer> prevNode = new SingleLinkedListNode<>();
        SingleLinkedListNode<Integer> nextNode;
    
        while (!currNode.isNIL()) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    public SingleLinkedListNode<Integer> recursiveReverse(SingleLinkedListNode<Integer> node) {
        SingleLinkedListNode<Integer> result;

        if (!(node.isNIL() || node.getNext().isNIL())) {
            
            result = recursiveReverse(node.getNext());

            node.getNext().setNext(node);

            node.setNext(new SingleLinkedListNode<>());

        } else {
            result = node;
        }
        return result;

    }
}
