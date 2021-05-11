package sword2offer.p68_2;
//树的解法
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        List<TreeNode> path1 = new ArrayList<>();
        findPath(root, p, path1);
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, q, path2);
        int pos = 0;
        TreeNode tar = null;
        while (pos < path1.size() && pos < path2.size()) {
            if(path1.get(pos).val != path2.get(pos).val) break;
            tar = path1.get(pos);
            pos ++;
        }
        return tar;
    }
    public boolean findPath(TreeNode root, TreeNode tar, List<TreeNode> path) {
        if(root == null) return false;

        path.add(root);
        if(root.val == tar.val || findPath(root.left, tar, path) || findPath(root.right, tar, path)) {
            return true;
        }
        else {
            path.remove(path.size() - 1);
            return false;
        }
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(6);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(0);
        TreeNode node7=new TreeNode(8);
        TreeNode node8=new TreeNode(7);
        TreeNode node9=new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=null;
        node4.right=null;
        node5.left=node8;
        node5.right=node9;
        node3.left=node6;
        node3.right=node7;
        node6.left=null;
        node6.right=null;
        node7.left=null;
        node7.right=null;
        node8.left=null;
        node8.right=null;
        node9.left=null;
        node9.right=null;
        System.out.println(solution.lowestCommonAncestor(node1,node2,node9).val);
    }
}
