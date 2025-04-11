package problems;

import adt.linkedList.SingleLinkedListNode;

public class ReversedLinkedListRev {
    

    public SingleLinkedListNode<Integer> reverse(SingleLinkedListNode<Integer> node) {

        SingleLinkedListNode<Integer> newHead;

        if (!(node.isNIL() || node.getNext().isNIL())) {

            newHead = reverse(node.getNext());

            node.getNext().setNext(node);

            node.setNext(new SingleLinkedListNode<>());

        } else {
            newHead = node;
        }

        return newHead;
        
    }

    public SingleLinkedListNode<Integer> interativeReverse(SingleLinkedListNode<Integer> node) {

        SingleLinkedListNode<Integer> prevNode = new SingleLinkedListNode<>();
        SingleLinkedListNode<Integer> currNode = node;
        SingleLinkedListNode<Integer> nextNode;

        while(!currNode.isNIL()) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

}
