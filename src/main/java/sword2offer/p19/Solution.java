package sword2offer.p19;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null){
            return false;
        }
        return doMatch(s,0,s.length(),p,0,p.length());
    }
    public boolean doMatch(String s, int sloc,int slen,String p, int ploc,int plen){
        if(sloc>=slen&&ploc>=plen){
            return true;
        }
        if(sloc<slen&&ploc>=plen){
            return false;
        }
        if(ploc+1<plen&&p.charAt(ploc+1)=='*'){
            if(sloc<slen&&(s.charAt(sloc)==p.charAt(ploc)||p.charAt(ploc)=='.')){
                return doMatch(s,sloc+1,slen,p,ploc+2,plen)||doMatch(s,sloc+1,slen,p,ploc,plen)||doMatch(s,sloc,slen,p,ploc+2,plen);
            }else{
                return doMatch(s,sloc,slen,p,ploc+2,plen);
            }
        }
        if(sloc<slen&&(s.charAt(sloc)==p.charAt(ploc)||p.charAt(ploc)=='.')){
            return doMatch(s,sloc+1,slen,p,ploc+1,plen);
        }
        return false;
    }
    public static void main(String[] args){
        String s="ab";
        String p=".*c";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s,p));
    }
}
