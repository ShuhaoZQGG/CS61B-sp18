public class LinkedListDeque<T> {
    private Node front;
    private Node rear;
    private int size;

    public LinkedListDeque() {
        front = new Node(null, null, null);
        rear = new Node(null, null, null);
        front.next = rear;
        rear.prev = front;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, null, null);
        if (item == null) {
            return;
        } else {
            if (front.next.equals(rear)) {
                front.next = newNode;
                newNode.next = rear;
                rear.prev = newNode;
                newNode.prev = front;
            } else {
                Node currFront = front.next;
                front.next = newNode;
                newNode.next = currFront;
                currFront.prev = newNode;
            }
            size += 1;
        }

    }

    public void addLast(T item) {
        Node newNode = new Node(item, null, null);
        if (item == null) {
            return;
        } else {
            if (rear.prev.equals(front)) {
                rear.prev = newNode;
                newNode.next = rear;
                front.next = newNode;
                newNode.prev = front;
            } else {
                Node currRear = rear.prev;
                rear.prev = newNode;
                newNode.prev = currRear;
                currRear.next = newNode;
            }
            size += 1;
        }
    }

    public void printDeque() {
        Node node = front;
        while (node.next != null && node.next.item != null) {
            System.out.print(node.next.item + " ");
            node = node.next;
        }
        System.out.println("\n");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removed = (T) front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        size -= 1;
        return removed;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removed = (T) rear.prev.item;
        rear.prev = rear.prev.prev;
        rear.prev.next = rear;
        size -= 1;
        return removed;
    }

    public T get(int index) {
        Node node = front;
        if (index > size) {
            return null;
        }

        while (index >= 0) {
            index -= 1;
            node = node.next;
        }

        return (T) node.item;
    }

    private T getRecursiveHelper(int index, Node node) {
        if (index > size) {
            return null;
        }

        if (index == -1) {
            return (T) node.item;
        }

        node = node.next;

        return (T) getRecursiveHelper(index - 1, node);
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, front);
    }

//    public static void main(String[] args) {
//        LinkedListDeque deque = new LinkedListDeque<String>();
//        deque.isEmpty();
//        deque.addFirst(0);
//        deque.removeLast();
//        deque.addLast(2);
//        deque.addFirst(3);
//        System.out.println(deque.size());
//        System.out.println(deque.get(1));
//        System.out.println(deque.getRecursive(1));
//    }
}
