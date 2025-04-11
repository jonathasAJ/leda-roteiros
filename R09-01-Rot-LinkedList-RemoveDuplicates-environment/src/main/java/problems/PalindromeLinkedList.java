package problems;

import adt.linkedList.SingleLinkedListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(SingleLinkedListNode<Integer> head) {
        
        SingleLinkedListNode<Integer> auxHead = head;
        SingleLinkedListNode<Integer> headInverso = inverteLinkedList(head);

        while (!auxHead.isNIL()) {
            if (!(auxHead.getData().compareTo(headInverso.getData()) == 0)) {
                return false;
            }
            auxHead = auxHead.getNext();
            headInverso = headInverso.getNext();
        }
        return true;
    }

    public SingleLinkedListNode<Integer> inverteLinkedList(SingleLinkedListNode<Integer> node) {

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
