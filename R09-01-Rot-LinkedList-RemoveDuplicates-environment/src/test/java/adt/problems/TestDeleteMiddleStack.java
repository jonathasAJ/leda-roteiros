package adt.problems;

import org.junit.Before;
import org.junit.Test;

import problems.DeleteMiddleStack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

public class TestDeleteMiddleStack {
    
    @Before
    public void setUp() {
        DeleteMiddleStack d = new DeleteMiddleStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

    }

    @SuppressWarnings("deprecation")
    @Test
    public void testeDelete(DeleteMiddleStack d, Stack<Integer> stack) {
        d.delete(stack);
        assertEquals(new Integer[] {1, 2, 4, 5}, stack.toArray());
    }
}
