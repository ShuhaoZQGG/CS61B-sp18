public class InList {
    public int first;
    public InList rest;

    public InList(int f, InList r) {
        first = f;
        rest = r;
    }

    // My Recursive Implementation
    public int getSize(InList L) {
        if (L.rest == null) {
            return 1;
        }

        return 1 + getSize(L.rest);
    }

    // Professor's Recursive Implementation
    public int size() {
        if (rest == null) {
            return 1;
        }

        return 1 + this.rest.size();
    }

    // My Iterative Implementation
    public int iterGetSize(InList L) {
        int size = 1;
        while (L.rest != null) {
            size += 1;
            L = L.rest;
        }

        return size;
    }

    // Professor's Iterative Implementation
    public int iterativeSize() {
        InList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.rest;
        }

        return size;
    }

    // get ith number (first) in the InList, too small return the 0th item, too large return the nth item

    // My Implementation
    public int get(int i) {
        InList L = this;
        while(i > 0) {
            L = L.rest;
            i -= 1;
        }

        return L.first;
    }

    // Professor's Implementation
    public int recGet(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public void addAdjacent(InList L) {
        if (L.rest == null) {
            return;
        }

        while (L.rest != null) {
            if (L.first == L.rest.first) {
                L.first *= 2;
                L.rest = L.rest.rest;
            } else {
                L = L.rest;
            }
        }
    }

    public void display(InList L) {
        while (L.rest != null) {
            System.out.print(L.first);
            System.out.print(", ");
            L.first = L.rest.first;
            L.rest = L.rest.rest;
        }
        System.out.println(L.first);
    }

    public static void main(String[] args) {
//        InList L = new InList(15, null);
//        L = new InList(10, L);
//        L = new InList(5, L);
//
//        System.out.println("My Recursive Answer " + L.getSize(L));
//        System.out.println("Professors Recursive Answer " + L.size());
//        System.out.println("My Iterative Answer " + L.iterGetSize(L));
//        System.out.println("Professors Iterative Answer " + L.iterativeSize());
//        System.out.println("My Get Answer " + L.get(1));
//        System.out.println("Professor Recursive Get Answer " + L.recGet(1));

        System.out.println("hello world");

        InList M = new InList(3, null);
        M = new InList(2, M);
        M = new InList(1, M);
        M = new InList(1, M);
        M.addAdjacent(M);
        System.out.println("hello world");
        System.out.println("M size " + M.size());
        System.out.println("M recGet " + M.recGet(1));
        M.display(M);
    }
}