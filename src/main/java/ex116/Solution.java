package ex116;
//递归实现
public class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        connectCore(root.left,root.right);
        return root;
    }
    public void connectCore(Node leftNode,Node rightNode){
        if(leftNode==null||rightNode==null){
            return;
        }
        leftNode.next=rightNode;
        connectCore(leftNode.left,leftNode.right);
        connectCore(rightNode.left,rightNode.right);
        connectCore(leftNode.right,rightNode.left);
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        solution.connect(node1);
        System.out.println(node2.next.val);
        System.out.println(node4.next.val);
        System.out.println(node5.next.val);
        System.out.println(node6.next.val);
    }
}
