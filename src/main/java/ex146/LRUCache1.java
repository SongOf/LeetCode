package ex146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName LRUCache1
 * @Description
 * @Date 2021/4/11 17:13
 * @Version 1.0
 */
public class LRUCache1 {
    public static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            tail.prev.next = x;
            x.prev = tail.prev;
            x.next = tail;
            tail.prev = x;
            size ++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size --;
            x.prev = null;
            x.next = null;
        }

        public Node removeFirst() {
            if(head.next == tail) {
                return null;
            }
            Node removed = head.next;
            remove(removed);
            return removed;
        }

        public int size() {
            return size;
        }
    }

    private DoubleList doubleList;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache1(int capacity) {
        this.doubleList = new DoubleList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node cur = map.getOrDefault(key, null);
        if(cur == null) return -1;
        doubleList.remove(cur);
        doubleList.addLast(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        Node tar = map.getOrDefault(key, null);
        if(tar != null) {
            doubleList.remove(tar);
            tar.value = value;
            doubleList.addLast(tar);
            return;
        }
        if(doubleList.size() >= capacity) {
            Node removed = doubleList.removeFirst();
            map.remove(removed.key);
        }
        Node newNode = new Node(key, value);
        doubleList.addLast(newNode);
        map.put(key, newNode);
    }

    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(1);
        lruCache1.put(2, 1);
        System.out.println(lruCache1.get(2));
        lruCache1.put(3, 2);
        System.out.println(lruCache1.get(2));
        System.out.println(lruCache1.get(3));
    }
}
