package sword2offer.p34;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> path=new ArrayList<Integer>();
        int curSum=0;
        pathSumCore(root,sum,path,curSum);
        return res;
    }
    public void pathSumCore(TreeNode root, int sum,List<Integer> path,int curSum){
        curSum=curSum+root.val;
        path.add(root.val);
        if(sum==curSum&&root.left==null&&root.right==null){
            res.add(new ArrayList<Integer>(path));
        }
        if(root.left!=null){
            pathSumCore(root.left,sum,path,curSum);
        }
        if(root.right!=null){
            pathSumCore(root.right,sum,path,curSum);
        }
        path.remove(path.size()-1);
    }
}
