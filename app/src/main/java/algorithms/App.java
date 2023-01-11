package algorithms;
public class App {

public static int getRandomNumber(int min, int max) {
  if (min > max) {throw new IllegalArgumentException("Minimum value must be less than or equal to maximum value.");}
  return (int) ((Math.random() * (max - min)) + min);
}

public static MyStack getPlateStack(){
    MyStack stack = new MyStack();
    for(int i = 0; i<10; i++){
      stack.push(getRandomNumber(1, 5));
    }
    return stack;
  }

public static MyHashSet<Integer> getValidPlateSizes(int a, int b, int c){
    MyHashSet<Integer> validSizes = new MyHashSet<>();
    validSizes.add(a);
    validSizes.add(b);
    validSizes.add(c);
    return validSizes;
  }



   public static void main(String[] args) {
   MyStack stack = new MyStack();
   MyHashSet<Integer> validSizes = getValidPlateSizes(2, 3, 5);


   stack = getPlateStack();
   System.out.println("Unsorted Stack: " + stack);
   MyStack sortedStack = IterativeQuickSort.sortStack(stack, validSizes);
   System.out.println("Stack after iterative quick sort: " + sortedStack + "\n");
   
   stack = getPlateStack();
   System.out.println("Unsorted Stack: " + stack);
   RecursiveQuickSort.sortStack(stack);
   System.out.println("Stack after recursive quick sort: " + stack + "\n");

   stack = getPlateStack();
   MyHashMap<Integer, Integer> map = new MyHashMap<>(); 
   for(Integer plateSize : validSizes){
     map.put(plateSize, 0);
    }


   System.out.println("Unsorted Stack" + stack);
   BucketSort.sortStackWithHashMap(map, stack);
   System.out.println("Stack After HashMap Bucket Sort" + stack);
   



  MyStack stack2 = new MyStack();
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);
        RecursiveQuickSort.sortStack(stack2);
        System.out.println(stack2.toString());





  }
}


