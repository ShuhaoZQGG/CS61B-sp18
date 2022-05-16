public class Alist<T> { // make it generic type
    T[] items;
    int size;

    public Alist() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize((size * 2));
        }
        items[size] = x;
        size += 1;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    // remove the last item and return it
    public T removeLast() {
        T x = getLast();
        //items[size - 1] = 0; // correct but not necessary
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    public void resize(int capacity) {
        T [] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
}
