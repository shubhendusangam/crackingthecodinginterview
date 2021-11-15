package com.linkedlist;

import java.util.HashSet;

/**
 * Created by shubhendu on 5/11/21.
 */
public class RemoveDuplicates {
    static Node head;

    public static void main(String[] args) {

        RemoveDuplicates linkedListInsert = new RemoveDuplicates();
        linkedListInsert.add(10);
        linkedListInsert.add(20);
        linkedListInsert.add(30);
        linkedListInsert.add(40);
        linkedListInsert.add(10);
        linkedListInsert.add(20);
        linkedListInsert.add(30);
        linkedListInsert.add(40);

        removeDuplicateFromList(head);
    }

    private static void removeDuplicateFromList(Node head) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        Node previousNode = null;
        Node currentNode = head;

        while (currentNode != null) {
            if (integerHashSet.contains(currentNode.data)) {
                previousNode.next = currentNode.next;
            } else {
                integerHashSet.add(currentNode.data);
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        printLinkedList(head);
    }

    public static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
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