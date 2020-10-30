package ex5526;

public class Solution {
    public int maximumRequests(int n, int[][] requests) {
        if(n==0||requests==null||requests.length==0){
            return 0;
        }
        int canCompete=0;
        int total=0;
        int curNodeIn=0;
        int curNodeOut=0;
        int len=requests.length;
        for (int i=0;i<n;i++){
            curNodeIn=0;
            curNodeOut=0;
            for(int j=0;j<len;j++){
                if(requests[j][0]==i){
                    curNodeOut++;
                }
            }
            for(int j=0;j<len;j++){
                if(requests[j][1]==i){
                    curNodeIn++;
                }
            }
            canCompete=curNodeIn>curNodeOut?curNodeOut:curNodeIn;
            total=total+canCompete;
        }
        return total;
    }
    public static void main(String[] args){
        int[][] requests={{0,1},{1,0},{0,1},{1,2},{2,0},{3,4},{0,0}};
        Solution solution = new Solution();
        System.out.println(solution.maximumRequests(5,requests));
    }
}
