package sword2offer.p59_2;

import java.util.LinkedList;

public class MaxQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> maxValueQueue;
    public MaxQueue() {
        queue=new LinkedList<>();
        maxValueQueue=new LinkedList<>();
    }

    public int max_value() {
        if(!maxValueQueue.isEmpty()){
            return maxValueQueue.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        while (!maxValueQueue.isEmpty()&&value>maxValueQueue.getLast()){
            maxValueQueue.removeLast();
        }
        maxValueQueue.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if(!queue.isEmpty()){
            if(queue.getFirst().equals(maxValueQueue.getFirst())){
                maxValueQueue.removeFirst();
            }
            return queue.removeFirst();
        }
        return -1;
    }
    public static void main(String[] args){
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
