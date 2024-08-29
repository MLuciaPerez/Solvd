package Model;

public class CustomLinkedList<T> {
    private Node<T> first;
    private int size;


    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++; // Increment the size
    }


    public boolean remove(T data) {
        if (first == null) return false;

        // Special case if the data is at the head
        if (first.data.equals(data)) {
            first = first.next;
            size--;
            return true;
        }

        Node<T> current = first;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false; // Element not found
    }


    public int getSize() {

        return size;
    }

    // Method to check if the LinkedList is empty
    public boolean isEmpty() {

        return size == 0;
    }

    // Method to display elements of the LinkedList
    public void display() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}