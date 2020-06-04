package DS;

//Reverse a queue

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Queue {
    ;

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.peek() + "\n ");
            queue.remove();
        }
    }
}

