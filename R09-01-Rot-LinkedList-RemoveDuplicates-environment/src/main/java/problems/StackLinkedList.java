package problems;
import adt.linkedList.SingleLinkedListNode;

public class StackLinkedList {

    protected int maxSize;
    protected SingleLinkedListNode<Integer> topo;
    protected int size;
    
    public StackLinkedList(int max) {

        this.maxSize = max;
        this.topo = new SingleLinkedListNode<>();
        this.size = 0;
    }


    public void push(Integer elem) {
        if (!isFull()) {
            if (isEmpty()) {
                topo.setData(elem);
                topo.setNext(new SingleLinkedListNode<>());
            } else {
                SingleLinkedListNode<Integer> aux = new SingleLinkedListNode<>();
                aux.setData(topo.getData());
                aux.setNext(topo.getNext());
                topo.setData(elem);
                topo.setNext(aux);
            }
            this.size++;
        }
    }

    public int pop() {
        Integer result = null;
        if(!isEmpty()) {
            result = topo.getData();
            this.topo = topo.getNext();
            size--;
        }
        return result;
    }


    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }

    public int size() {
        return this.size;
    }

    public int getTopo() {
        return topo.getData();
    }
}
