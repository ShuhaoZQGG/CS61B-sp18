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
                front.next = newNode;
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
        while(node.next != null && node.next.item != null) {
            System.out.print(node.next.item + " ");
            node = node.next;
        }
        System.out.println("\n");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public T removeFirst() {
        T removed = (T) front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        size -= 1;
        return removed;
    }

    public T removeLast() {
        T removed = (T) rear.prev.item;
        rear.prev = rear.prev.prev;
        rear.prev.next = rear;
        size -= 1;
        return removed;
    }

    public T get(int index) {
        Node Front = front;
        if (index > size) {
            return null;
        }

        while (index > 0) {
            index -= 1;
            Front = Front.next;
        }

        return (T) Front.item;
    }

    public T getRecursiveHelper(int index, Node node) {
        if (index > size) {
            return null;
        }

        if (index == 0) {
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
//        deque.addFirst("hello");
//        deque.addLast("what");
//        deque.addLast("a");
//        deque.addLast("beautiful");
//        deque.addLast("World");
//        deque.addLast("!");
//        deque.addFirst("yo");
//        deque.addFirst("said");
//        deque.addFirst("i");
//        deque.addFirst("and");
//        deque.addFirst("you");
//        deque.removeFirst();
//        deque.removeLast();
//        deque.removeLast();
//        deque.printDeque();
//        System.out.println(deque.size());
//        System.out.println(deque.get(3));
//        System.out.println(deque.getRecursive(3));
//    }
}