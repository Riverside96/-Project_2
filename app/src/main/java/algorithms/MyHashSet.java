package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;








public class MyHashSet<E> implements Iterable<E>{

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int capacity;
    private int size;
    private List<E>[] bucket;

    public MyHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashSet(int capacity) {
        this.capacity = capacity;
        this.bucket = new ArrayList[capacity];
    }

    public boolean add(E element) {
        int index = hash(element);
        if (bucket[index] == null) {
            bucket[index] = new ArrayList<>();
        }

        if(!bucket[index].contains(element)){
            size++;
        }

        boolean added = bucket[index].add(element);
        
        if (size > capacity * LOAD_FACTOR) {
            resize();
        }

        return added;
    }

    public boolean remove(E element) {
        int index = hash(element);
        if (bucket[index] == null) {
            return false;
        }
        boolean removed = bucket[index].remove(element);
        if (removed) {
            size--;
        }
        return removed;
    }

    public boolean contains(E element) {
        int index = hash(element);
        if (bucket[index] == null) {
            return false;
        }
        return bucket[index].contains(element);
    }

    public int size() {
        return size;
    }

    private int hash(E element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode) % capacity;
    }
    
    private void resize() {
        capacity = capacity * 2;
        List<E>[] oldBucket = bucket;
        bucket = new ArrayList[capacity];
        size = 0;
        for (List<E> list : oldBucket) {
            if (list != null) {
                for (E e : list) {
                    add(e);
                }
            }
        }
    }



   @Override
    public Iterator<E> iterator() {
        return new HashSetIterator();
    }

    private class HashSetIterator implements Iterator<E> {
        private int currentBucket = 0;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentBucket < capacity) {
                List<E> list = bucket[currentBucket];
                if (list != null && currentIndex < list.size()) {
                    return true;
                }
                currentBucket++;
                currentIndex = 0;
            }
            return false;
        }

        @Override
        public E next() {
            while (currentBucket < capacity) {
                List<E> list = bucket[currentBucket];
                if (list != null && currentIndex < list.size()) {
                    return list.get(currentIndex++);
                }
                currentBucket++;
                currentIndex = 0;
            }
            return null;
        }
    }
}
