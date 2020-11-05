package assignment_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class ListJunitTest {
    List list1;

    @Before
    public void createList1() {
        ListNode node = new ListNode(11);
        list1 = new List(node);
        // System.out.println(list1);
    }

    @Test
    public void test1() {
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        list1.addNode(node2);
        list1.addNode(0, node3);
        ListNode node4 = new ListNode(7);
        list1.addNode(3, node4);
        // System.out.println(list1);
        assertEquals("[9, 11, 8, 7]", list1.toString());
        list1.reverse();
        assertEquals("[7, 8, 11, 9]", list1.toString());
        list1.sort();
        assertEquals("[7, 8, 9, 11]", list1.toString());
        ListNode node5 = new ListNode(10);

        list1.addNodeSorted(node5);
        assertEquals("[7, 8, 9, 10, 11]", list1.toString());
//        System.out.println(list1);

        list1.deleteNode(node5);
        assertEquals("[7, 8, 9, 11]", list1.toString());
        System.out.println(list1);

        list1.deleteNode(0);
        System.out.println(list1);

        list1.deleteNode(2);
        assertEquals("[8, 9]", list1.toString());
        System.out.println(list1);

        ListNode node6 = new ListNode(8);
        list1.addNode(node6);
        list1.deleteDuplicates();
        assertEquals("[8, 9]", list1.toString());
        System.out.println(list1);

        ListNode node7 = new ListNode(9);
        list1.addNode(node7);
        list1.deleteSortedDuplicates();
        assertEquals("[8, 9]", list1.toString());
        System.out.println(list1);
        System.out.println(list1.size());

        ListNode node11 = new ListNode(1);
        List list2 = new List(node11);
        ListNode node12 = new ListNode(9);
        list2.addNode(node12);
        list1.mergeSortedList(list2);
        System.out.println("mergeSortedList:" + list1);
        assertEquals("[1, 8, 9, 9]", list1.toString());
        System.out.println(list1);

        ListNode node21 = new ListNode(10);
        List list3 = new List(node21);
        ListNode node22 = new ListNode(9);
        list3.addNode(node22);
        list1.mergeList(list3);
        // System.out.println("mergeList:"+list1);
        assertEquals("[1, 8, 9, 9, 10, 9]", list1.toString());
    }

    @Test
    public void test2() {
        ListNode node = new ListNode(11);
        list1 = new List(node);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        list1.addNode(node2);
        list1.addNode(node3);
        // System.out.println(list1);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(8);
        list1.addNode(1, node4);
        System.out.println("before sorting:" + list1.size() + ":" + list1);
        list1.sort();
        System.out.println("after sorting:" + list1);
        // list1.reverse();System.out.println("reverse:"+list1);
        list1.addNodeSorted(node5);
        System.out.println("addNodeSorted:" + list1);
        ListNode node6 = new ListNode(9);
        list1.deleteNode(node6);
        System.out.println("delete:" + list1);
        list1.deleteNode(-1);
        System.out.println("delete:" + list1);
        list1.deleteDuplicates();
        System.out.println("deleteDuplicates:" + list1);
        list1.deleteSortedDuplicates();
        System.out.println("deleteDuplicates:" + list1);
        ListNode node11 = new ListNode(1);
        List list2 = new List(node11);
        ListNode node12 = new ListNode(9);
        list2.addNode(node12);
        list1.mergeSortedList(list2);
        System.out.println("mergeSortedList:" + list1);
        ListNode node21 = new ListNode(10);
        List list3 = new List(node21);
        ListNode node22 = new ListNode(9);
        list3.addNode(node22);
        list1.mergeList(list3);
        System.out.println("mergeList:" + list1.size() + ":" + list1);
        list1.sort();
        System.out.println("after sorting:" + list1);
    }
}
