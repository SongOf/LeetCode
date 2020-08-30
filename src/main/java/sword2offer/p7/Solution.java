package sword2offer.p7;

import java.util.Arrays;
//Arrays.copyOfRange()
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int nodesLength=preorder.length;
        if(nodesLength==0){
            return null;
        }
        int rootValue=preorder[0];
        int rootIndex=0;
        for(int i=0;i<nodesLength;i++){
            if(inorder[i]==rootValue){
                rootIndex=i;
                i=nodesLength;
            }
        }
        TreeNode rootTreeNode=new TreeNode(rootValue);
        rootTreeNode.left=buildTree(Arrays.copyOfRange(preorder,1,1+rootIndex),Arrays.copyOfRange(inorder,0,rootIndex));
        rootTreeNode.right=buildTree(Arrays.copyOfRange(preorder,1+rootIndex,nodesLength),Arrays.copyOfRange(inorder,1+rootIndex,nodesLength));
        return rootTreeNode;
    }
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode=solution.buildTree(preorder,inorder);
        System.out.println(treeNode.toString());
    }
}
