package adt.problems;

import java.util.Arrays;
import java.util.LinkedList;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SpecialLinkedListImpl extends SingleLinkedListImpl<Integer>{

    public void swap(Integer elem1, Integer elem2) {

        SingleLinkedListNode<Integer> auxNode1 = null;
        SingleLinkedListNode<Integer> auxNode2 = null;

        if (elem1 != null && elem2 != null) {
            SingleLinkedListNode<Integer> searchNode = getHead();

            while(!searchNode.isNIL()) {
                if (elem1 == searchNode.getData()) {
                    auxNode1 = searchNode;
                } else {
                    if (elem2 == searchNode.getData()) {
                        auxNode2 = searchNode;
                
                    }
                }
                searchNode = searchNode.getNext();
            }
        }

        if (auxNode1 != null && auxNode2 != null) {
            Integer aux = auxNode1.getData();
            auxNode1.setData(auxNode2.getData());
            auxNode2.setData(aux);
        }
    }

    public Integer elementFromTheEnd(int k) {
        Integer result = null;

        if(!getHead().isNIL()) {
            
            SingleLinkedListNode<Integer> slow = getHead();
            SingleLinkedListNode<Integer> fast = getHead();
    
            while(k > 0) {
                fast  = fast.getNext();
                k--;
            }
    
            while(!fast.isNIL()) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
            result = slow.getData();
        }
        return result;
        
    }

    public static void main(String[] args) {
        
        SpecialLinkedListImpl sl = new SpecialLinkedListImpl();

        sl.insert(1);
        sl.insert(2);
        sl.insert(3);
        sl.insert(4);
        sl.insert(5);

        sl.swap(2, 4);
        
        //System.out.println(sl.elementFromTheEnd(6));

        System.out.println(Arrays.toString(sl.toArray()));
    }
    
}
