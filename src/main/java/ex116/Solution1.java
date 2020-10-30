package ex116;

import java.util.LinkedList;
//基于队列的层序遍历
public class Solution1 {
    public Node connect(Node root){
        if(root==null){
            return null;
        }
        LinkedList<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            int stackLen=queue.size();
            for(int i=0;i<stackLen;i++){
                Node curNode=queue.poll();
                if(i<stackLen-1){
                    curNode.next=queue.peek();
                }
                if(curNode.left!=null){
                    queue.add(curNode.left);
                }
                if(curNode.right!=null){
                    queue.add(curNode.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
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
        solution1.connect(node1);
        System.out.println(node2.next.val);
        System.out.println(node4.next.val);
        System.out.println(node5.next.val);
        System.out.println(node6.next.val);
    }
}
