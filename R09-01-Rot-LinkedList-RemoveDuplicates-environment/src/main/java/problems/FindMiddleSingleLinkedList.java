package problems;

import adt.linkedList.SingleLinkedListNode;

public class FindMiddleSingleLinkedList {

    public SingleLinkedListNode<Integer> findMiddle(SingleLinkedListNode<Integer> node) {

        SingleLinkedListNode<Integer> auxNode = node;

        int count = 0;

        while(!auxNode.isNIL()) {
            auxNode = auxNode.getNext();
            count++;
        }

        SingleLinkedListNode<Integer> resultNode = node;

        int mid = count/2;

        while(mid > 0) {
            resultNode = resultNode.getNext();
            mid--;
        }

        return resultNode;
    }

    public SingleLinkedListNode<Integer> findMiddleNoCount(SingleLinkedListNode<Integer> node) {
        SingleLinkedListNode<Integer> slow = node;
        SingleLinkedListNode<Integer> fast = node;

        while(!fast.isNIL() && !fast.getNext().isNIL()) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
}
