package ex5710;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/21 10:39
 * @Version 1.0
 */
public class Solution {
    public static class Order {
        private int price;
        private int amount;
        public Order() {}
        public Order(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Order> buyQueue = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.price - o1.price;
            }
        });
        PriorityQueue<Order> sellQueue = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.price - o2.price;
            }
        });
        int res = 0;
        for (int i = 0; i < orders.length; i++) {
            if(orders[i][2] == 0) {
                buyQueue.offer(new Order(orders[i][0], orders[i][1]));
            }
            else {
                sellQueue.offer(new Order(orders[i][0], orders[i][1]));
            }
            while (!sellQueue.isEmpty() && !buyQueue.isEmpty() && sellQueue.peek().price <= buyQueue.peek().price) {
                Order sellOrder = sellQueue.poll();
                Order buyOrder = buyQueue.poll();
                if(sellOrder.amount > buyOrder.amount) {
                    sellQueue.offer(new Order(sellOrder.price, sellOrder.amount - buyOrder.amount));
                }
                else if(sellOrder.amount < buyOrder.amount){
                    buyQueue.offer(new Order(buyOrder.price, buyOrder.amount - sellOrder.amount));
                }
            }
        }
        int m = (int) (Math.pow(10, 9) + 7);
        while (!buyQueue.isEmpty()) {
            res = (res + buyQueue.poll().amount % m) % m;
        }
        while (!sellQueue.isEmpty()) {
            res = (res + sellQueue.poll().amount % m) % m;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] orders = {
                {10,5,0},
                {15,2,1},
                {25,1,1},
                {30,4,0}
        };
        System.out.println(solution.getNumberOfBacklogOrders(orders));
    }
}
