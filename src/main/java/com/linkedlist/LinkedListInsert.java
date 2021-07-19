package com.linkedlist;

public class LinkedListInsert {
   public static void main(String[] args) {

      Node rootNode = null;
      rootNode = insertElement(20, rootNode);
      rootNode = insertElement(30, rootNode);
      rootNode = insertElement(40, rootNode);
      rootNode = insertElement(15, rootNode);
      rootNode = insertElement(6, rootNode);

      rootNode = addFirst(1, rootNode);

      printLinkedList(rootNode);
   }

   public static Node insertElement(int dt , Node rootNode) {
      if (rootNode == null) {
         rootNode = new Node(dt);
      } else {
         rootNode.next = insertElement(dt, rootNode.next);
      }
      return rootNode;
   }

   public static Node addFirst(int data, Node node) {
      Node rootNode = new Node(data);
      rootNode.next = node;
      return rootNode;
   }

   public static void printLinkedList(Node node) {
      while(node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
   }

}

class Node {
   int data;
   Node next;

   public Node(int data) {
      this.data = data;
      this.next = null;
   }
}