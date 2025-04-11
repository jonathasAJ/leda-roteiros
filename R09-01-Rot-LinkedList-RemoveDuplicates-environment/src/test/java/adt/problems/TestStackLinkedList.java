package adt.problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import problems.StackLinkedList;

public class TestStackLinkedList {
    
    StackLinkedList stack;
    StackLinkedList stack1;

    @Before
    public void setUp() {
        stack = new StackLinkedList(3);
        stack1 = new StackLinkedList(4);
        stack.push(3);
        stack.push(2);

    }


    @Test
    public void isEmptyTest() {
        assertTrue(stack1.isEmpty());
    }

    @Test
    public void getTopoTest() {
        assertEquals(2, stack.getTopo());
    }

    @Test
    public void popTest() {
        assertEquals(2, stack.pop());
    }
    
}
