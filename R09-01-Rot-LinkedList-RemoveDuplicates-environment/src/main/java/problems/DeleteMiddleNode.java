package problems;

import adt.linkedList.SingleLinkedListNode;

public class DeleteMiddleNode {
    

    public void delete(SingleLinkedListNode<Integer> node) {

        SingleLinkedListNode<Integer> slow = node;
        SingleLinkedListNode<Integer> fast = node;

        while(!fast.isNIL() && !fast.getNext().isNIL()) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        System.out.println(slow.getData());

        slow.setData(slow.getNext().getData());
        slow.setNext(slow.getNext().getNext());
    }

    public void print(SingleLinkedListNode<Integer> node) {
        SingleLinkedListNode<Integer> auxNode = node;
        while (!auxNode.isNIL()) {
            System.out.println(" " + auxNode.getData());
            auxNode = auxNode.getNext();
        }
    }
}
