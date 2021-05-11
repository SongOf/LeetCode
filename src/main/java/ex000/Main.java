package ex000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Main
 * @Description
 * @Date 2021/4/25 14:37
 * @Version 1.0
 */
public class Main {
    private List<Integer> p1;
    private List<Integer> p2;
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        System.out.println(main.commonParent(root, 4, 5));
    }
    public int commonParent(TreeNode root, int val1, int val2) {
        if(root == null) return -1;

        List<Integer> path1 = new ArrayList<>();
        findPath(root, val1, path1);
        p2 = p1;
        List<Integer> path2 = new ArrayList<>();
        findPath(root, val2, path2);
        int tar = -1;
        int index = 0;
        while (index < p1.size() && index < p2.size()) {
            if(p1.get(index) != p2.get(index)) break;
            tar = p1.get(index);
            index++;
        }
        return tar;
    }
    public void findPath(TreeNode root, int tar, List<Integer> path) {
        if(root == null) return;
        path.add(root.val);
        if(root.val == tar) {
            p1 = new ArrayList<>(path);
            return;
        }

        findPath(root.left, tar, path);
        findPath(root.right, tar, path);
        path.remove(path.size() - 1);

    }
}
