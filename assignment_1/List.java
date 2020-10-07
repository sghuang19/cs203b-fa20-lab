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
        this.headListNode = node;
        size = 1;
        sorted = 0;
    }

    public int size() {
        return size;
    }

    /**
     * @return 0-unsorted, 1-ascending, -1-descending
     */
    public int sorted() {
        ListNode key = this.headListNode;
        int sorted_init = 1;
        while (key.next != null && key.val == key.next.val) {
            key = key.next;
        }
        if (key.val > key.next.val) {
            sorted_init = -1;
        } else
            sorted_init = 1;

        int sorted_temp = 0;
        while (key.next != null) {
            if (key.val > key.next.val) {
                sorted_temp = -1;
            }
            if (key.val < key.next.val) {
                sorted_temp = 1;
            }
            if (sorted_temp != sorted_init) {
                this.sorted = 0;
                return this.sorted;
            }
            key = key.next;
        }

        return this.sorted;
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
    // TODO
    public void sort() {
    }

    /**
     * reverse the order of nodes of list attribute sorted should be changed if the
     * list is sorted before
     */
    public void reverse() {
        if (this.headListNode.next == null) {
            this.sorted = -this.sorted;
            return;
        }

        if (this.headListNode.next.next == null) {
            this.headListNode.next.next = this.headListNode;
            this.headListNode.next = null;
            this.sorted = -this.sorted;
            return;
        }

        ListNode key1 = this.headListNode;
        ListNode key2 = this.headListNode.next;
        ListNode key3 = this.headListNode.next.next;
        this.headListNode.next = null;
        while (key3.next != null) {
            key2.next = key1;
            key1 = key2;
            key2 = key3;
            key3 = key3.next;
        }
        key2.next = key1;
        key3.next = key2;

        this.sorted = -this.sorted;
    }

    /**
     * add node to tail of list
     * 
     * @param node
     */
    public void addNode(ListNode node) {
        ListNode key = this.headListNode;
        while (key.next != null) {
            key = key.next;
        }
        key.next = node;
    }

    /**
     * add node to sorted list and keep list still sorted node should add to the
     * position according to the value
     * 
     * @param node
     */
    public void addNodeSorted(ListNode node) {
        // in case the node needs to be append before the headListNode
        // also judge whether the List is sorted or not
        if (this.sorted == 1) {
            if (node.val <= this.headListNode.val) {
                node.next = this.headListNode;
                return;
            }
        }

        // for there's only one node in the List
        if (this.headListNode == null) {
            this.headListNode.next = node;
            if (this.headListNode.val <= node.val) {
                this.sorted = 1;
            } else
                this.sorted = -1;
        }

        ListNode key = this.headListNode;
        boolean right_pos = key.val <= node.val && node.val <= key.next.val
                || key.val >= node.val && node.val >= key.next.val;
        while (key.next.next != null) {
            if (right_pos) {
                key.next = node;
                node.next = key.next;
                return;
            } else
                key = key.next;
        }

        // all the positions are not correct, append the new node to the final
        key.next.next = node;
    }

    /**
     * add node to position of index, which is from 0
     * 
     * @param index
     * @param node
     */
    // TODO
    public void addNode(int index, ListNode node) {
        ListNode key = this.headListNode;
        try {
            for (int i = 0; i < index - 1; i++) {
                key = key.next;
            }
            node.next = key.next.next;
            key.

        } catch (NullPointerException e) {
        }
    }

    /**
     * delete node
     * 
     * @param node
     * @return return true if success, false if fail
     */
    public boolean deleteNode(ListNode node) {
        // if the headListNode is to be deleted
        if (this.headListNode == node) {
            this.headListNode = null;
            return true;
        }

        ListNode key = this.headListNode;
        while (key.next != null) {
            if (key.next == node) {
                key.next = key.next.next;
                return true;
            }
        }

        return false;
    }

    /**
     * delete node at position index(from 0), return true if success, false if fail
     * 
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
        // for the first node is to be deleted
        if (index == 0) {
            this.headListNode = null;
            return true;
        }

        ListNode key = this.headListNode;
        try {
            for (int i = 0; i < index - 1; i++) {
                key = key.next;
            }
            key.next = key.next.next;
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

    /**
     * delete duplicated node from unsorted list
     */
    // TODO
    public void deleteDuplicates() {
        ListNode key_s = this.headListNode;
        ListNode key_d = this.headListNode.next;
        try {
            while (key_d.next != null) {
                if (key_d.val == key_s.val) {

                }
            }
        } catch (NullPointerException e) {
        }

    }

    /**
     * delete duplicated node from sorted list
     */
    // TODO
    public void deleteSortedDuplicates() {
    }

    /**
     * merge head of listToMerge to tail of original list
     * 
     * @param listToMerge
     */
    public void mergeList(List listToMerge) {
        ListNode key = this.headListNode;
        while (key.next != null) {
            key = key.next;
        }
        key.next = listToMerge.headListNode;
    }

    /**
     * merge two sorted lists and keep new list still sorted
     * 
     * @param listToMerge
     */
    public void mergeSortedList(List listToMerge) {
        mergeList(listToMerge);
        this.sort();
    }

}
