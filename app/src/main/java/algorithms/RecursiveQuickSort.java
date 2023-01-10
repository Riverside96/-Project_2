package algorithms;

public class RecursiveQuickSort {
    public static void sortStack(MyStack stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        // Sort the remaining stack
        sortStack(stack);
        // Insert the removed element back into the sorted stack
        insertSorted(stack, temp);
    }

    private static void insertSorted(MyStack stack, int element) {
        if (stack.isEmpty() || element < stack.peek()) {
            // If the stack is empty or the element is larger than the top
            // element, just push the element onto the stack
            stack.push(element);
            return;
        }
        // Remove the top element from the stack
        int temp = stack.pop();
        // Insert the element back into the sorted stack
        insertSorted(stack, element);
        // Push the removed element back onto the stack
        stack.push(temp);
    }
}
