package ex117;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/26 1:27
 * @Version 1.0
 */
public class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node head = queue.poll();
            if(head.left != null) queue.offer(head.left);
            if(head.right != null) queue.offer(head.right);
            for (int i = 1; i < size; i++) {
                head.next = queue.poll();
                head = head.next;
                if(head.left != null) queue.offer(head.left);
                if(head.right != null) queue.offer(head.right);
            }
            head = null;
        }
        return root;
    }
}
