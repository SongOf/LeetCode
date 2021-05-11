package ex297;

import ex23.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Codec
 * @Description
 * @Date 2021/3/14 14:08
 * @Version 1.0
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeCore(root, sb);
        return sb.toString();
    }
    public void serializeCore(TreeNode root, StringBuffer sb) {
        if(root == null) {
            sb.append("null" + ",");
            return;
        }
        sb.append(root.val + ",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeCore(nodes);
    }
    public TreeNode deserializeCore(LinkedList<String> nodes) {
        String node = nodes.getFirst();
        nodes.removeFirst();
        if(node.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(node));
        root.left = deserializeCore(nodes);
        root.right = deserializeCore(nodes);
        return root;
    }
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        String res = codec.serialize(root);
        root = codec.deserialize(res);
        System.out.println(codec.serialize(root));
    }
}
