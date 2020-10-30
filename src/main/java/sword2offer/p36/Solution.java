package sword2offer.p36;

public class Solution {
    private Node lastNode=null;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        treeToDoublyListCore(root);
        Node curNode=lastNode;
        while (curNode!=null&&curNode.left!=null){
            curNode=curNode.left;
        }
        curNode.left=lastNode;
        lastNode.right=curNode;
//        for(Node i=curNode;i!=null;i=i.right){
//            System.out.println(i.val);
//        }
        return curNode;
    }
    public void treeToDoublyListCore(Node root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            treeToDoublyListCore(root.left);
        }
        if(lastNode!=null){
            lastNode.right=root;
            root.left=lastNode;
        }
        lastNode=root;
        if(root.right!=null){
            treeToDoublyListCore(root.right);
        }
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
