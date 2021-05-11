package sword2offer.p7;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd) return null;
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int inLoc = indexMap.get(val);
        int len = inLoc - inStart;
        root.left = buildTreeCore(preorder, preStart + 1, preStart + len, inorder, inStart, inLoc - 1);
        root.right = buildTreeCore(preorder, preStart + len + 1, preEnd, inorder, inLoc + 1, inEnd);
        return root;
    }
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode=solution.buildTree(preorder,inorder);
        System.out.println(treeNode.toString());
    }
}
