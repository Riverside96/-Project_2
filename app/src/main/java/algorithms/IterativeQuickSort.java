package algorithms;
public class IterativeQuickSort {
    public static MyStack sortStack(MyStack stack, MyHashSet<Integer> validPlateSizes) {
        MyStack sortedStack = new MyStack();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if(validPlateSizes.contains(temp)){
            while (!sortedStack.isEmpty() && sortedStack.peek() < temp) {
              stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
      }
                   }
        return sortedStack;
    }
}



