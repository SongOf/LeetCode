package sword2offer.p36;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/5/10 11:06
 * @Version 1.0
 */
public class Solution {
    private Node head;
    private Node lastNode;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        treeToDoublyListCore(root);
        head.left = lastNode;
        lastNode.right = head;
        return head;
    }
    public void treeToDoublyListCore(Node root) {
        if(root == null) return;

        treeToDoublyListCore(root.left);

        if(lastNode == null) {
            head = root;
        }
        else {
            lastNode.right = root;
            root.left = lastNode;
        }
        lastNode = root;

        treeToDoublyListCore(root.right);
    }
    public static void main(String[] args){
        Node node1=new Node(4);
        Node head=node1;
        Node node2=new Node(2);
        Node node3=new Node(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=null;
        node3.right=null;
        Node node4=new Node(1);
        Node node5=new Node(3);
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;
        node2.left=node4;
        node2.right=node5;
        Solution solution = new Solution();
        System.out.println(solution.treeToDoublyList(head));
    }
}
