package ex5543;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int slength=s.length();
        int maxLength=-1;
        int curMaxLength;
        boolean isFind;
        for (int i = 0; i < slength-1; i++) {
            int j;
            isFind=false;
            for(j=slength-1;j>i;j--){
                if(s.charAt(i)==s.charAt(j)){
                    isFind=true;
                    break;
                }
            }
            if(isFind==true){
                curMaxLength=j-i-1;
                if(maxLength<curMaxLength){
                    maxLength=curMaxLength;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("abaaaaa"));
    }
}
