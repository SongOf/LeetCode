package sword2offer.p54;

public class Solution {
    private int indexK;
    public int kthLargest(TreeNode root, int k) {
        if(root==null||k==0){
            return -1;
        }
        indexK=k;
        return kthLargestCore(root).val;
    }
    public TreeNode kthLargestCore(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode tarNode=null;
        if(root.right!=null){
            tarNode=kthLargestCore(root.right);
        }
        if(tarNode==null){
            if(indexK==1){
                tarNode=root;
            }
            indexK=indexK-1;
        }
        if(tarNode==null&&root.left!=null){
            tarNode=kthLargestCore(root.left);
        }
        return tarNode;
    }
    public static void main(String[] args){
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(1);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(2);
        n1.left=n2;
        n1.right=n3;
        n2.left=null;
        n2.right=n4;
        n3.left=null;
        n3.right=null;
        n4.left=null;
        n4.right=null;
        Solution solution=new Solution();
        System.out.println(solution.kthLargest(n1,2));
    }
}
