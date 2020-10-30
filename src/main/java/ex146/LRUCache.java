package ex146;

import java.util.LinkedHashMap;

public class LRUCache {
    private LinkedHashMap<Integer,Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        cache=new LinkedHashMap();
        this.capacity=capacity;
    }
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()>=capacity){
            int firstKey=cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key,value);
    }
    public void makeRecently(int key) {
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
