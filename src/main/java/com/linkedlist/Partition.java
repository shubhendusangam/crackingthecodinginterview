package com.linkedlist;

/**
 * Created by Shubhendu on 21-11-2021.
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list the values of x only need  to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * 
 * EXAMPLE
 * Input: 10 -> 60 -> 50 -> 45 -> 20 -> 70 -> 25 -> 35 [partition = 45]
 * Output: 10 -> 20 -> 25 -> 35 ->  60 -> 50 -> 45 -> 70
 */
public class Partition {
  public static void main(String[] args) {
        LinkedListInsert linkedListInsert = new LinkedListInsert();
        linkedListInsert.add(10);
        linkedListInsert.add(60);
        linkedListInsert.add(50);
        linkedListInsert.add(45);
        linkedListInsert.add(20);
        linkedListInsert.add(70);
        linkedListInsert.add(25);
        linkedListInsert.add(35);

        Node headNode = partitionLinkedList(linkedListInsert.head, 45);

        LinkedListInsert.printLinkedList(headNode);
    }

    private static Node partitionLinkedList(Node headNode, int pivot) {

        // pointers to keep track of start and end points of lists
        Node lessStart = null;
        Node lessEnd = null;
        Node moreStart = null;
        Node moreEnd = null;

        while (headNode != null) {

            Node tempNode = headNode.next;
            headNode.next = null;

            if (headNode.data < pivot) {
                if (lessStart == null) {
                    lessStart = headNode;
                    lessEnd = lessStart;
                } else {
                    lessEnd.next = headNode;
                    lessEnd = headNode;
                }
            } else {
                if (moreStart == null) {
                    moreStart = headNode;
                    moreEnd = moreStart;
                } else {
                    moreEnd.next = headNode;
                    moreEnd = headNode;
                }
            }

            // iterating linkedlist
            headNode = tempNode;
        }

        if (lessStart == null) {
            return moreStart;
        }

        // merge less list and more list
        lessEnd.next = moreStart;

        return lessStart;
    }
}
