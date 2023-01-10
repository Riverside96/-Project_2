package algorithms;
public class MyStack {
    private int[] stack;
    private int size;
    private int capacity;

    public MyStack() {
        this(16);
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        size = 0;
    }

    public void push(int element) {
        if (size == capacity) {
            resize();
        }
        stack[size++] = element;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        int top = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return top;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        capacity = capacity * 2;
        int[] newStack = new int[capacity];
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}


