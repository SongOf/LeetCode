package ex148;

/**
 * @author SongOf
 * @ClassName ListNode
 * @Description
 * @Date 2021/3/13 17:37
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
