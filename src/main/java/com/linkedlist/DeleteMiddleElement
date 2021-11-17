package com.linkedlist;

/**
 * Created by shubhendu on 17/11/21.
 *
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
 * given only access to that node.
 */
public class DeleteMiddleElement {

    public static void main(String[] args) {
        LinkedListInsert linkedListInsert = new LinkedListInsert();
        linkedListInsert.add(10);
        linkedListInsert.add(20);
        linkedListInsert.add(30);
        linkedListInsert.add(40);
        linkedListInsert.add(50);

        Node head = linkedListInsert.head.next.next;

        boolean isDeleted = deleteMiddleElement(head);
        linkedListInsert.printLinkedList(head);
        System.out.println(isDeleted);
    }

    private static boolean deleteMiddleElement(Node head) {

        if (head == null  || head.next == null) {
            return false;
        }

        Node tempNode = head.next;
        head.data = tempNode.data;
        head.next = tempNode.next;

        return true;

    }

}
