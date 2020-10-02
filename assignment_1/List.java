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

    /**
     * 0-unsorted, 1-ascending, -1-descending
     * 
     * @return
     */
    public int sorted() {
        return sorted;
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

    /**
     * sort the list ascending. Any sorting algorithm is OK. attribute sorted should
     * be changed to 1
     */
    public void sort() {
    }

    /**
     * reverse the order of nodes of list attribute sorted should be changed if the
     * list is sorted before
     */
    public void reverse() {
    }

    /**
     * add node to tail of list
     * 
     * @param node
     */
    public void addNode(ListNode node) {
    }

    /**
     * add node to sorted list and keep list still sorted node should add to the
     * position according to the value
     * 
     * @param node
     */
    public void addNodeSorted(ListNode node) {
    }

    /**
     * add node to position of index, which is from 0
     * 
     * @param index
     * @param node
     */
    public void addNode(int index, ListNode node) {
    }

    /**
     * delete node, return true if success, false if fail
     * 
     * @param node
     * @return
     */
    public boolean deleteNode(ListNode node) {
    }

    /**
     * delete node at position index(from 0), return true if success, false if fail
     * 
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
    }

    /**
     * delete duplicated node from unsorted list
     */
    public void deleteDuplicates() {
    }

    /**
     * delete duplicated node from sorted list
     */
    public void deleteSortedDuplicates() {
    }

    /**
     * merge head of listToMerge to tail of original list
     * 
     * @param listToMerge
     */
    public void mergeList(List listToMerge) {
    }

    /**
     * merge to sorted lists and keep new list still sorted
     * 
     * @param listToMerge
     */
    public void mergeSortedList(List listToMerge) {
    }

}
