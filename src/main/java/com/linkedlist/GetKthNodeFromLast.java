package com.linkedlist;

/**
 * Created by shubhendu on 16/11/21.
 */
public class GetKthNodeFromLast {

    static Node head;

    public static void main(String[] args) {

        GetKthNodeFromLast linkedListInsert = new GetKthNodeFromLast();
        linkedListInsert.add(10);
        linkedListInsert.add(20);
        linkedListInsert.add(30);
        linkedListInsert.add(40);
        linkedListInsert.add(10);
        linkedListInsert.add(20);
        linkedListInsert.add(30);
        linkedListInsert.add(40);

        final int kthElement = 5;

        getKthNodeFromLastIterativeApproach(head, kthElement);

        getKthNodeFromLastTwoPointerApproach(head, kthElement);

    }

    // approach 2 two pointer approach O(n) - single pass
    private static void getKthNodeFromLastTwoPointerApproach(Node head, int kthElement) {
        Node p1Node = head;
        Node p2Node = head;


        for (int i = 0; i < kthElement; i++) {
            if (p2Node == null) {
                System.out.println("adjust kth element");
                break;
            }
            p2Node = p2Node.next;
        }

        // Move them at the same pace . When p2 hits the end , p1 will be at the right place .(same as n - k + 1 logic)
        while (p2Node != null) {
            p1Node = p1Node.next;
            p2Node = p2Node.next;
        }

        System.out.println(p1Node.data);

    }

    // approach 1 by iterating 2 times - O(n) 2 times iterate the linked list
    private static void getKthNodeFromLastIterativeApproach(Node head, int kthElement) {
        int counter = 0;
        Node tempNode = head;

        // getting the size of linked list
        while (head != null) {
            head = head.next;
            counter++;
        }

        if (counter >= kthElement) {
            for (int i = 1; i < (counter - kthElement + 1); i++) {
                tempNode = tempNode.next;
            }
            System.out.println(tempNode.data);
        } else {
            System.out.println("kth element is greater than linked list size");
        }

    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

}
