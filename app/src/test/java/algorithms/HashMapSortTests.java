package algorithms;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HashMapSortTests {

    @Test
    public void testSortStackWithHashMap() {
        // Test case 1: Sort an already sorted stack
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        MyHashSet<Integer> validSizes = App.getValidPlateSizes(1, 2, 3);
        MyHashMap<Integer,Integer> map = new MyHashMap<>();
         for(Integer plateSize : validSizes){
         map.put(plateSize, 0);
        }

        BucketSort.sortStackWithHashMap(map, stack1);
        assertEquals("[1, 2, 3]", stack1.toString());

        // Test case 2: Sort a stack with duplicate elements
        MyStack stack2 = new MyStack();
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);
        stack2.push(2);

        MyHashMap<Integer,Integer> map2 = new MyHashMap<>();
        for(Integer plateSize : validSizes){
         map2.put(plateSize, 0);
        }
        
        BucketSort.sortStackWithHashMap(map2, stack2);
        assertEquals("[1, 2, 2, 3]", stack2.toString());


        // Test case 3: Sort an empty stack
        MyStack stack3 = new MyStack();
        MyHashMap<Integer,Integer> map3 = new MyHashMap<>();
        for(Integer plateSize : validSizes){
         map3.put(plateSize, 0);
        }
        BucketSort.sortStackWithHashMap(map3, stack3);
        assertEquals("[]", stack3.toString());
    }
}
