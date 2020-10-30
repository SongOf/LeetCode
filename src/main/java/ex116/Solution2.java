package ex116;
//使用已建立的next指针 性能最好
public class Solution2 {
    public Node connect(Node root){
        if(root==null){
            return null;
        }
        Node mostLeft=root;//左侧向下的指针
        while (mostLeft.left!=null){
            Node head=mostLeft;//每层从左到右的指针
            while (head!=null){
                head.left.next=head.right;
                if(head.next!=null){
                    head.right.next=head.next.left;
                }
                head=head.next;
            }
            mostLeft=mostLeft.left;
        }
        return root;
    }
    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
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
        solution2.connect(node1);
        System.out.println(node2.next.val);
        System.out.println(node4.next.val);
        System.out.println(node5.next.val);
        System.out.println(node6.next.val);
    }
}