//public class ArrayDeque<T> {
//    private static final int maxSize = 8;
//    private int size;
//    private T[] arr;
//    private int front;
//    private int rear;
//
//    public ArrayDeque() {
//        arr = (T[]) new Object[maxSize];
//        front = -1;
//        rear = 0;
//        size = 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    private boolean isFull() {
//        return size >= maxSize;
//    }
//
//    private void resizeUp() {
//        T[] resizedArray = (T[]) new Object[arr.length * 2];
//        // copy array into new array
//        int sizeOfFirstCopy = arr.length - front;
//        System.arraycopy(arr, front, resizedArray, 0, sizeOfFirstCopy);
//        System.arraycopy(arr, 0, resizedArray, sizeOfFirstCopy, size - sizeOfFirstCopy);
//        arr = resizedArray;
//        front = 0;
//        rear = size - 1;
//    }
//
//    private void resizeDown() {
//        T[] resizedArray = (T[]) new Object[arr.length / 2];
////        int sizeOfFirstCopy = myArrayDeque.length - firstIndex;
//        if (rear < front) {
//            int sizeOfFirstCopy = arr.length - front;
//            System.arraycopy(arr, front, resizedArray, 0, sizeOfFirstCopy);
//            System.arraycopy(arr, 0, resizedArray, sizeOfFirstCopy,
//                    size - sizeOfFirstCopy);
//
//        } else {
//            System.arraycopy(arr, front, resizedArray, 0, size);
//        }
//        arr = resizedArray;
//        front = 0;
//        rear = size - 1;
//    }
//    public void addFirst(T item) {
//        if (isFull()) {
//            resizeUp();
//        }
//        if (front == -1) {
//            front = 0;
//            rear = 0;
//        }
//
//        else if (front == 0) {
//            if (size <= maxSize) {
//                front = maxSize - 1;
//            } else {
//                front = size - 1;
//            }
//        }
//
//        else {
//            front --;
//        }
//
//        arr[front] = item;
//        size ++;
//    }
//
//    public void addLast(T item) {
//        if (isFull()) {
//            resizeUp();
//        }
//
//        if (front == -1) {
//            front = 0;
//            rear = 0;
//        }
//
//        else if (rear == size - 1) {
//            rear = 0;
//        }
//
//        else {
//            rear ++;
//        }
//
//        arr[rear] = item;
//        size ++;
//    }
//
//    public void printDeque() {
//        for (int i = front; i < maxSize; i ++) {
//            if (arr[i] != null) {
//                System.out.print(arr[i] + " ");
//            }
//        }
//
//        for (int j = 0; j <= rear; j++) {
//            if (arr[j] != null) {
//                System.out.print(arr[j] + " ");
//            }
//        }
//
//        System.out.println("\n");
//    }
//
//    public static void main(String[] args) {
//        ArrayDeque deque = new ArrayDeque<String>();
//        deque.addFirst("wtf");
//        deque.addFirst("world");
//        deque.addFirst("hello");
//        deque.addFirst("first");
//        deque.addLast("!");
//        deque.addLast("?");
//        deque.addLast("last");
//        deque.addLast("...");
//        deque.addFirst("FINAL");
//        deque.addLast("??????????????????");
//        deque.addFirst("FIIIIR");
//        System.out.println(deque.size);
//
//        deque.printDeque();
//    }
//}
/*
   Code refer to https://github.com/seriouszyx/CS61BCN
 */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0 ? true : false);
    }

    public int minusOne(int index) {
        return Math.floorMod(index-1, items.length);
    }


    public int plusOne(int index) {
        return Math.floorMod(index+1, items.length);
    }

    public int plusOne(int index, int length) {
        return Math.floorMod(index+1, length);
    }

    /**
     *  invariants:
     *      设计resize()方法，将在增加ArrayDeaue实例内存的方法中调用
     *      内部判断内存满则调用expand()增加内存
     *        如果内存过小则调用reduce()减小内存
     **/

    private void resize() {
        if (size == items.length) {
            expand();
        }
        if (size < items.length / 4 && items.length > 8) {
            reduce();
        }
    }

    private void expand() {
        resizeHelper(items.length * 2);
    }

    private void reduce() {
        resizeHelper(items.length / 2);
    }

    private void resizeHelper(int capacity) {
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i=begin; i != end; i = plusOne(i, temp.length)) {
            items[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = temp[end];
        nextLast = plusOne(nextLast);
    }

    /**
     *  invariants:
     *      通过minusOne()方法确定nextFirst，(nextFirst-1)%items.length
     *      即nextFirst的下一个位置
     *      eg. (0 - 1) % 8 = 7
     *
     * */
    public void addFirst(T item) {
        resize();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public T getFirst() {
        return items[plusOne(nextFirst)];
    }

    public T removeFirst() {
        resize();
        T res = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return res;
    }

    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T getLast() {
        return items[minusOne(nextLast)];
    }

    public T removeLast() {
        resize();
        T res = getLast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size--;
        return res;
    }

    public void printDeque() {
        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
            System.out.print(items[index]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = Math.floorMod(plusOne(nextFirst) + index, items.length);
        return items[index];
    }

//    public static void main(String[] args) {
//        ArrayDeque deque = new ArrayDeque<String>();
//        deque.addFirst("wtf");
//        deque.addFirst("world");
//        deque.addFirst("hello");
//        deque.addFirst("first");
//        deque.addLast("!");
//        deque.addLast("?");
//        deque.addLast("last");
//        deque.addLast("...");
//        deque.addFirst("FINAL");
//        deque.addLast("??????????????????");
//        deque.addFirst("FIIIIR");
//        System.out.println(deque.size);
//
//        deque.printDeque();
//    }
}