package sword2offer.p41;

import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName MedianFinder
 * @Description
 * @Date 2021/5/21 10:58
 * @Version 1.0
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.size() == 0 || maxHeap.peek() > num) {
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return minHeap.peek();
    }
}
