/** An SLList is a list of the integers, which hides the terrible truth of the nakedness within*/
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null); // it doesn't matter what item equals to, sentinel only works as pointing to the next node
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
        size += 1;
    }

    public int getLast() {
        IntNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }

        return p.item;
    }

    public static void main(String[] args) {
        /* Create a list of one integer, namely 10 */

        // Compared to InList: InList L = new InList(15, null);
        SLList L= new SLList(10);
        L.addFirst(5);
        L.addFirst(15);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
        System.out.println(L.size);
    }
}