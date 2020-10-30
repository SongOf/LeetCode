package ex5524;

public class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if(customers==null||customers.length==0){
            return 0;
        }
        int maxProfit=Integer.MIN_VALUE;
        int maxStep;
        int curCustomers=0;
        int curProfit=0;
        int curBoard=0;
        int curStep=0;
        curCustomers=customers[0];
        curBoard=curCustomers>=4?4:curCustomers;
        curCustomers=curCustomers-curBoard;
        curProfit=curBoard*boardingCost-runningCost;
        maxProfit=curProfit;
        curStep++;
        maxStep=curStep;
        for(int i=1;i<customers.length;i++){
            curCustomers=curCustomers+customers[i];
            curBoard=curCustomers>=4?4:curCustomers;
            curCustomers=curCustomers-curBoard;
            curStep++;
            curProfit=curProfit+curBoard*boardingCost-runningCost;
            if(maxProfit<curProfit){
                maxProfit=curProfit;
                maxStep=curStep;
            }
        }
        while (curCustomers>0){
            curBoard=curCustomers>=4?4:curCustomers;
            curCustomers=curCustomers-curBoard;
            curStep++;
            curProfit=curProfit+curBoard*boardingCost-runningCost;
            if(maxProfit<curProfit){
                maxProfit=curProfit;
                maxStep=curStep;
            }
        }
        if(maxProfit<0){
            return -1;
        }
        return maxStep;
    }
    public static void main(String[] args){
        int[] customers={10,10,6,4,7};
        Solution solution = new Solution();
        System.out.println(solution.minOperationsMaxProfit(customers,3,8));
    }
}
