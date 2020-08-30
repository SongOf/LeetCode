package sword2offer.p43;

public class Solution {
    public int countDigitOne(int n) {
        if(n>=0 && n<=9){
            return n==0?0:1;
        }
        int lengthOfN=this.countLengthOfN(n);
        int exp=this.powBase10(lengthOfN-1);
        int firstNum=n/exp;
        int numsFirstDigit=0;
        if(firstNum==1){
            numsFirstDigit=n-exp+1;
        }else if(firstNum>1){
            numsFirstDigit=exp;
        }
        int numsOtherDigit=(lengthOfN-1)*firstNum*(exp/10);
        return numsFirstDigit+numsOtherDigit+this.countDigitOne(n%exp);
    }
    public int countLengthOfN(int n){
        int length=0;
        while (n!=0){
            length++;
            n=n/10;
        }
        return length;
    }
    public int powBase10(int len){
        int res=1;
        while (len>0){
            res=res*10;
            len--;
        }
        return res;
    }
    public static void main(String[] args){
        int n =12;
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(n));
    }
}
