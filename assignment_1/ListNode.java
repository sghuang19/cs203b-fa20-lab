package assignment_1;

public class ListNode {
    int val;
    ListNode next;

    // ListNode prev;
    public ListNode(int x) {
        val = x;
        next = null;
        // prev = null;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
