package ex105;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/13 14:26
 * @Version 1.0
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }
    public TreeNode buildTreeCore(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        TreeNode head = null;
        if(preorderStart <= preorderEnd) {
            head = new TreeNode(preorder[preorderStart]);
        }
        else {
            return head;
        }
        int index = inorderStart;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if(head.val == inorder[i]) index = i;
        }
        int leftLen = index - inorderStart;
        head.left = buildTreeCore(preorder, preorderStart + 1, preorderStart + leftLen, inorder, inorderStart, index -1);
        head.right = buildTreeCore(preorder, preorderStart + leftLen + 1, preorderEnd, inorder, index + 1, inorderEnd);
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = solution.buildTree(preorder, inorder);
        solution.inOrder(root);
    }
    public void inOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        inOrder(root.left);
        inOrder(root.right);
    }
}
