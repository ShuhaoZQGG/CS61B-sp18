public class IntList {
	public int first;
	public IntList rest;
	
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}
	
	// My Recursive Implementation
	public int getSize(IntList L) {
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
	public int iterGetSize(IntList L) {
		int size = 1;
		while (L.rest != null) {
			size += 1;
			L = L.rest;
		}
		
		return size;
	}
	
	// Professor's Iterative Implementation
	public int iterativeSize() {
		IntList p = this;
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
		IntList L = this;
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
	
	public void addAdjacent(IntList L) {
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
	
	public void display(IntList L) {
		IntList Node = new IntList(-1, null);
		Node.rest = L;
		while (Node.rest != null) {
			System.out.print(Node.first);
			System.out.print(", ");
			Node.first = Node.rest.first;
			Node.rest = Node.rest.rest;
		}
		System.out.println(Node.first);
	}
	
	public static IntList square(IntList L) {
		if (L == null) {
			return null;
		}
		int squaredFirst = (int) Math.pow(L.first, 2);
		
		IntList res = new IntList(squaredFirst, square(L.rest));
		
		return res;
	}
	
	public static IntList squareIter(IntList L) {
		if (L == null) {
			return  null;
		}
		IntList Node = new IntList(-1, L);
		int squaredFirst = (int) Math.pow(Node.rest.first, 2);
		IntList res = new IntList(squaredFirst, null);
		IntList ptr = res;
		Node.rest = Node.rest.rest;
		while (Node.rest != null) {
			int squaredRestFirst = (int) Math.pow(Node.rest.first, 2);
			ptr.rest = new IntList(squaredRestFirst, Node.rest.rest);
			Node = Node.rest;
			ptr = ptr.rest;
		}
		return res;
	}
	
	public static void main(String[] args) {
		IntList M = new IntList(3, null);
		M = new IntList(2, M);
		M = new IntList(1, M);
		M = new IntList(1, M);
		M.display(M);
		IntList squaredM = square(M);
		squaredM.display(squaredM);
		IntList squaredMIter = squareIter(M);
		squaredMIter.display(squaredMIter);
		
	}
}