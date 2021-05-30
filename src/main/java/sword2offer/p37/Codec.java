package sword2offer.p37;

import java.util.Arrays;
import java.util.LinkedList;

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
        TreeNode root = null;
        String firstNode = nodes.getFirst();
        nodes.removeFirst();
        if(firstNode.equals("null")) return root;
        root = new TreeNode(Integer.parseInt(firstNode));
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
        System.out.println(codec.serialize(root));
    }
}
