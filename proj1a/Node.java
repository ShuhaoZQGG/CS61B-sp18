public class Node<T> {
    public T item;
    public Node next;
    public Node prev;
    public Node(T i, Node n, Node p) {
        item = i;
        next = n;
        prev = p;
    }
}
