package ex5545;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public class Player{
        Integer age;
        Integer score;
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int length=scores.length;
        List<Player> list=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Player tmp=new Player();
            tmp.score=scores[i];
            tmp.age=ages[i];
            list.add(tmp);
        }
        Collections.sort(list,(Player p1,Player p2)->{
            if(p1.age.equals(p2.age)){
                return p1.score-p2.score;
            }else {
                return p1.age-p2.age;
            }
        });
        int[] dp=new int[length];
        for (int i = 0; i < length; ++i) {
            dp[i] = list.get(i).score;
            for (int j = 0; j < i; ++j) {
                if (list.get(j).score <= list.get(i).score)
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).score);
            }
        }
        int ans = -1;
        for (int i = 0; i < length; ++i){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] scores={1,2,3,5};
        int[] ages={8,9,10,1};
        System.out.println(solution.bestTeamScore(scores,ages));
    }
}
