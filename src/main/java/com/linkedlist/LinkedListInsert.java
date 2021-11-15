package com.linkedlist;

public class LinkedListInsert {
   Node head;
   public static void main(String[] args) {

      LinkedListInsert linkedListInsert = new LinkedListInsert();
      linkedListInsert.add(10);
      linkedListInsert.add(20);
      linkedListInsert.add(30);
      linkedListInsert.add(40);

      Node updatedList = linkedListInsert.addFirst(1);

      printLinkedList(updatedList);
   }

   public Node addFirst(int data) {
      Node rootNode = new Node(data);
      rootNode.next = head;
      return rootNode;
   }

   public static void printLinkedList(Node node) {
      while(node != null) {
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