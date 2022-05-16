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

    public SLList(int[] x) {
        // initialize with an array
        size = 0;
        sentinel = new IntNode(0, null);
        for (int i = 0; i < x.length; i++) {
            // get the item from array inversely
            sentinel.next = new IntNode(x[x.length-i-1], null);
            size += 1;
        }
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

    public void deleteFirst() {
        IntNode p = sentinel;
        if(p.next != null && p.next.next != null) {
            p.next = p.next.next;
            size -= 1;
        }


        p.next.item = 0;
        size = 0;
    }

    // Other People's Implementation:
    /*
         public int deleteFirst() {
             //sentinel.next or sentinel.next.next
                could be null when size == 0 //
            if (sentinel.next == null) {
                return -1;
            }

            IntNode deleteNode = sentinel.next;

            if (sentinel.next.next == null) {
                sentinel.next = new IntNode(-1, null);
                return deleteNode.item;
            }
            sentinel.next = sentinel.next.next;
            return deleteNode.item;
        }
     */
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
        L.deleteFirst();
        L.deleteFirst();
        L.deleteFirst();
        L.deleteFirst();
        L.deleteFirst();
        L.deleteFirst();

        System.out.println(L.getFirst());
        System.out.println(L.size);
        System.out.println(L.getLast());

        int[] arr = new int[]{1,2,3};
        SLList L_arr = new SLList(arr);
        System.out.println(L_arr.getFirst());
    }
}