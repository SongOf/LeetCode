package ex94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/12 21:50
 * @Version 1.0
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        return inOrderList;
    }
    public void inOrder(TreeNode root, List<Integer> inOrderList) {
        if(root == null) return;
        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }
}
