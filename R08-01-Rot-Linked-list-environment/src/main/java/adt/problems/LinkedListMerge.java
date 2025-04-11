package adt.problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMerge {
    
    public SingleLinkedListNode<Integer> merge(SingleLinkedListNode<Integer> node1, SingleLinkedListNode<Integer> node2) {

        SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>();

        SingleLinkedListNode<Integer> auxNode = head;

        while(!node1.isNIL() && !node2.isNIL()) {
            if (node1.getData() < node2.getData()) {
                auxNode.setData(node1.getData());
                node1 = node1.getNext();
            } else {
                auxNode.setData(node2.getData());
                node2 = node2.getNext();
            }
            auxNode.setNext(new SingleLinkedListNode<>());
            auxNode = auxNode.getNext();
        }

        while(!node1.isNIL()) {
            auxNode.setData(node1.getData());
            auxNode.setNext(new SingleLinkedListNode<>());
            auxNode = auxNode.getNext();
            node1 = node1.getNext();
        }

        while(!node2.isNIL()) {
            auxNode.setData(node2.getData());
            auxNode.setNext(new SingleLinkedListNode<>());
            auxNode = auxNode.getNext();
            node2 = node2.getNext();
        }

        return head;
    }

    public static void main(String[] args) {
        
        LinkedListMerge l = new LinkedListMerge();

        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<Integer>(1, 
                                                new SingleLinkedListNode<>(3, 
                                                new SingleLinkedListNode<>(6, 
                                                new SingleLinkedListNode<>(7, new SingleLinkedListNode<>()))));

        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<Integer>(2, 
                                                new SingleLinkedListNode<>(5, 
                                                new SingleLinkedListNode<>(9, 
                                                new SingleLinkedListNode<>(10, new SingleLinkedListNode<>()))));

        SingleLinkedListNode<Integer> head = l.merge(node1, node2);

        while (!head.isNIL()) {
            System.out.println(head);
            head = head.getNext();
        }
    }
}
