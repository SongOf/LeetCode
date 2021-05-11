package ex538;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/9 9:58
 * @Version 1.0
 */
public class Solution {
    private int curSum;
    public TreeNode convertBST(TreeNode root) {
        return convertBSTCore(root);
    }
    public TreeNode convertBSTCore(TreeNode root) {
        if(root == null) return null;
        TreeNode newRoot = new TreeNode();
        newRoot.right = convertBSTCore(root.right);
        curSum += root.val;
        newRoot.val = curSum;
        newRoot.left = convertBSTCore(root.left);
        return newRoot;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node1;
        root.right = node6;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;
        root = solution.convertBST(root);
        System.out.println(root);
    }
}
