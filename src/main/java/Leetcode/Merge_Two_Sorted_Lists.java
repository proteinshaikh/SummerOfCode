package Leetcode;


public class Merge_Two_Sorted_Lists {

    // Structure of node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists msl = new Merge_Two_Sorted_Lists();
        Node head1 = null;

        head1 = create(head1, 1);
        head1 = create(head1, 3);
        head1 = create(head1, 5);

        Node head2 = null;

        head2 = create(head2, 2);
        head2 = create(head2, 4);
        head2 = create(head2, 6);
        display(msl.SortedMerge(head1, head2));

    }

    // Function to insert node in a linked list
    static Node create(Node head, int x) {
        Node temp, ptrm = head;
        temp = new Node();
        temp.data = x;
        temp.next = null;
        if (head == null)
            head = temp;
        else {
            while (ptrm.next != null) {
                ptrm = ptrm.next;
            }
            ptrm.next = temp;
        }
        return head;
    }



    // This function prints contents of linked
    // list starting from the given node
    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public Node SortedMerge(Node A, Node B) {

        if (A == null) return B;
        if (B == null) return A;

        if (A.data < B.data) {
            A.next = SortedMerge(A.next, B);
            return A;
        } else {
            B.next = SortedMerge(A, B.next);
            return B;
        }

    }
}