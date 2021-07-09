package Datastructures;

public class IntNode {

    public int data;
    public IntNode node;

    public IntNode(int data, IntNode node) {
        this.data = data;
        this.node = node;
    }

    public String toString() {
        return data + "";
    }

    public static void main(String[] args) {
        IntNode node = new IntNode(25, null);
        System.out.println(node);
    }
}
