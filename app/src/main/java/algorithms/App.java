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

public static MyHashSet<Integer> getValidPlateSizes(){
    MyHashSet<Integer> validSizes = new MyHashSet<>();
    validSizes.add(1);
    validSizes.add(3);
    validSizes.add(5);
    return validSizes;
  }



   public static void main(String[] args) {
   MyStack stack = new MyStack();
   MyHashSet<Integer> validSizes = getValidPlateSizes();


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
   




    } 




}


