package sword2offer.p26;
//先找到第一个相等的节点 再递归判断余下的节点
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result=false;
        if(A!=null&&B!=null){
            if(A.val==B.val){
                result=isSubStructureCore(A, B);
            }
            if(!result){
                result=isSubStructure(A.left,B);
            }
            if(!result){
                result=isSubStructure(A.right,B);
            }
        }
        return result;
    }
    public boolean isSubStructureCore(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return isSubStructureCore(A.left,B.left)&&isSubStructureCore(A.right,B.right);
    }
    public static void main(String[] args){
        TreeNode A;
        TreeNode B;
        A=new TreeNode(3);
        A.left=new TreeNode(4);
        A.right=new TreeNode(5);
        A.right.left=A.right.right=null;
        A.left.left=new TreeNode(1);
        A.left.left.right=A.left.left.left=null;
        A.left.right=new TreeNode(2);
        A.left.right.left=A.left.right.right=null;

        B=new TreeNode(4);
        B.left=new TreeNode(1);
        B.left.left=B.left.right=null;
        B.right=null;
        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(A,B));
    }
}
