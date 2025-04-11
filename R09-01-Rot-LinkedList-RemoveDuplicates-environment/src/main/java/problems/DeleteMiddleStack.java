package problems;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class DeleteMiddleStack {
    
    public void delete(Stack<Integer> stack) {

        Stack<Integer> auxStack = new Stack<>();

        int count = stack.size()/2 -1;

        while(count > 0) {
            auxStack.add(stack.pop());
            count--;
        }

        stack.pop();

        while(!auxStack.isEmpty()) {
            stack.add(auxStack.pop());
        }
    }
}
