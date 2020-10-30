package sword2offer.p35;

public class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node list1=head;
        Node list2=new Node(-1);
        Node nextNode=null;
        while (list1!=null){
            nextNode=list1.next;
            list1.next=new Node(list1.val);
            list1.next.next=nextNode;
            list1=nextNode;
        }
        list1=head;
        while (list1!=null){
            if(list1.random!=null){
                list1.next.random=list1.random.next;
            }
            list1=list1.next.next;
        }
        list1=new Node(-1);;
        Node list1Head=list1;
        Node list2Head=list2;
        Node curNode=head;
        int pos=1;
        while (curNode!=null){
            if(pos%2==1){
                list1.next=curNode;
                list1=list1.next;
            }else {
                list2.next=curNode;
                list2=list2.next;
            }
            curNode=curNode.next;
            pos++;
        }
        list1.next=null;
        list2.next=null;
//        while (list1Head!=null){
//            System.out.println(list1Head.val);
//            list1Head=list1Head.next;
//        }
//        while (list2Head!=null){
//            System.out.println(list2Head.val);
//            list2Head=list2Head.next;
//        }
        return list2Head.next;
    }
    public static void main(String[] args){
        Node head=null;
        head=new Node(1);
        Node node2=new Node(2);
        node2.next=null;
        node2.random=node2;
        head.random=node2;
        head.next=node2;
        Solution solution = new Solution();
        System.out.println(solution.copyRandomList(head));
    }
}
