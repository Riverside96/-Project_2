package algorithms;

public class BucketSort {
 
public static void sortStackWithHashMap(MyHashMap<Integer, Integer> map, MyStack stack){

  int popped;
  while(!stack.isEmpty()){
        popped = stack.pop();
        if(map.containsKey(popped)){
          map.put(popped, map.get(popped)+1);
        }
      }

  for(Integer key : map.keySet()){
     while (map.get(key)>0){
        stack.push(key);
        map.put(key, map.get(key)-1);
      }
    }
  }
}



