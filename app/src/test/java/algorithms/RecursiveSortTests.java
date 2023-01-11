package algorithms;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursiveSortTests {
    @Test
    public void testSortStack() {
        // Test case 1: Sort an already sorted stack
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        RecursiveQuickSort.sortStack(stack1);
        assertEquals("[3, 2, 1]", stack1.toString());

        // Test case 2: Sort a reverse sorted stack
        MyStack stack2 = new MyStack();
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);
        RecursiveQuickSort.sortStack(stack2);
        assertEquals("[3, 2, 1]", stack2.toString());

        // Test case 3: Sort a randomly ordered stack
        MyStack stack3 = new MyStack();
        stack3.push(3);
        stack3.push(1);
        stack3.push(2);
        RecursiveQuickSort.sortStack(stack3);
        assertEquals("[3, 2, 1]", stack3.toString());
    }
}
