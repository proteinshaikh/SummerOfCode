package Leetcode;

class MyHashSet {

    ListNode[] nodes;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.nodes = new ListNode[10000];
    }

    public void add(int key) {
        int index = getIndex(key);
        ListNode pre = findPre(key, index);
        if (pre.next == null) {
            pre.next = new ListNode(key);
        } else {
            pre.next.key = key;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        ListNode pre = findPre(key, index);
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        ListNode pre = findPre(key, index);
        if (pre.next != null) {
            return true;
        }
        return false;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findPre(int key, int index) {
        if (nodes[index] == null) {
            nodes[index] = new ListNode(-1);
        }
        ListNode pre = nodes[index];
        while (pre.next != null && pre.next.key != key) {
            pre = pre.next;
        }
        return pre;
    }
}

class ListNode {
    int key;
    ListNode next;

    public ListNode(int key) {
        this.key = key;
        this.next = null;
    }
}
