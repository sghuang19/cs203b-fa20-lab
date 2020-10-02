package assignment_1;

public class List {
    public ListNode headListNode;
    private int size;
    private int sorted;

    public List() {
        headListNode = null;
        size = 0;
        sorted = 0;
    }

    public List(ListNode node) {
        headListNode = node;
        size = 1;
        sorted = 0;
    }

    public int size() {
        return size;
    }

    public int sorted() {
        return sorted;
        // 0-unsorted, 1-ascending, -1-descending
    }

    @Override
    public String toString() {
        String str = "[";
        // str += val;
        ListNode pListNode = headListNode;
        while (pListNode.next != null) {
            str += pListNode.val + ", ";
            pListNode = pListNode.next;
        }
        str += pListNode.val + "]";
        return str;
    }

    public void sort() {
        // sort the list ascending. Any sorting algorithm is OK.
        // attribute sorted should be changed to 1
    }

    public void reverse() {
        // reverse the order of nodes of list
        // attribute sorted should be changed if the list is sorted before
    }

    public void addNode(ListNode node) {
        // add node to tail of list
    }

    public void addNodeSorted(ListNode node) {
        // add node to sorted list and keep list still sorted
        // node should add to the position according to the value
    }

    public void addNode(int index, ListNode node) {
        // add node to position of index, which is from 0
    }

    public boolean deleteNode(ListNode node) {
        // delete node, return true if success, false if fail
    }

    public boolean deleteNode(int index) {
        // delete node at position index(from 0), return true if success, false if fail
    }

    public void deleteDuplicates() {
        // delete duplicated node from unsorted list
    }

    public void deleteSortedDuplicates() {
        // delete duplicated node from sorted list
    }

    public void mergeList(List listToMerge) {
        // merge head of listToMerge to tail of original list
    }

    public void mergeSortedList(List listToMerge) {
        // merge to sorted lists and keep new list still sorted
    }

}
