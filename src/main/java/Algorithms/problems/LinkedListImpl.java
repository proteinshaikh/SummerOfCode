package Algorithms.problems;

import java.util.ArrayList;
import java.util.List;

public class LinkedListImpl {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);

        Node node1 = new Node(4);
        node1.next = new Node(5);
        node1.next.next = new Node(6);

        System.out.println(addLinkedList(node, node1));

    }

    private static Node addLinkedList(Node node, Node node1) {
        int sum = 0;
        Node res=null;
        Node temp = new Node(0);
        Node first = null;
        Node second = null;
        while (node != null && node1 != null) {
            sum = node.data + node.data;
            //temp.data = sum;
            //temp.next = temp;

            temp=new Node(sum);
            res=temp;
            node = node.next;
            node1 = node1.next;
            //temp=temp.next;
            List longlist=new ArrayList<>();
            List test=longlist;

        }

        return res;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }
}
