package sword2offer.p62;
import java.util.LinkedList;

public class Solution {
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> circleList=new LinkedList<>();
        for(int i=0;i<n;i++){
            circleList.add(i);
        }
        int curNode=0;
        int pos=1;
        while (circleList.size()>1){
            if(pos>=m){
                circleList.remove(curNode);
                pos=1;
            }else {
                pos++;
                curNode=(curNode+1)%circleList.size();
            }
        }
        return circleList.getFirst();
    }
}
