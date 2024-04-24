package ru.businessTechnology;


public class ListNode<T> {
    T val;
    ListNode<T> next;
    ListNode<T> head;
    ListNode<T> previous;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public ListNode<T> addFirst(T value) {
        ListNode<T> listNode = new ListNode<>(value);
        if (head == null) {
            head = listNode;
        } else {
            listNode.next = head;
            head.previous = listNode;
            head = listNode;
        }

        return listNode;
    }

    public ListNode<T> insertAt(int index, T value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        ListNode<T> newNode = new ListNode<>(value);

        if (index == 0) {
            return addFirst(value);
        }

        ListNode<T> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        newNode.next = current.next;
        current.next = newNode;
        newNode.previous = current;

        if (newNode.next != null) {
            newNode.next.previous = newNode;
        }

        return newNode;
    }
}
