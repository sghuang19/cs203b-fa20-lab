package lab;


public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        deleteDuplicates(n1);
        System.out.println(n1.val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head.next == null || head == null){
            return head;
        }

        ListNode p = head;
        int val = p.val;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            }
        }

        deleteDuplicates(head.next);

        return head;
    }

    // public ListNode sortList(ListNode head) {

    // }
}
