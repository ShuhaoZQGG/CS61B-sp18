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

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }
    public int getFirst() {
        return first.item;
    }
    public static void main(String[] args) {
        /* Create a list of one integer, namely 10 */

        // Compared to InList: InList L = new InList(15, null);
        SLList L= new SLList(10);
        System.out.println(L.getFirst());
    }
}