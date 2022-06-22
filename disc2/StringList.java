public class StringList {
	public String first;
	public StringList rest;
	
	public StringList(String f, StringList r) {
		first = f;
		rest = r;
	}
	
	// My Recursive Implementation
	public int getSize(StringList L) {
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
	public int iterGetSize(StringList L) {
		int size = 1;
		while (L.rest != null) {
			size += 1;
			L = L.rest;
		}
		
		return size;
	}
	
	// Professor's Iterative Implementation
	public int iterativeSize() {
		StringList p = this;
		int size = 0;
		while (p != null) {
			size += 1;
			p = p.rest;
		}
		
		return size;
	}
	
	// get ith number (first) in the InList, too small return the 0th item, too large return the nth item
	
	// My Implementation
	public String get(int i) {
		StringList L = this;
		while(i > 0) {
			L = L.rest;
			i -= 1;
		}
		
		return L.first;
	}
	
	// Professor's Implementation
	public String recGet(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}
	
	public void display(StringList L) {
		while (L.rest != null) {
			System.out.print(L.first);
			System.out.print(", ");
			L.first = L.rest.first;
			L.rest = L.rest.rest;
		}
		System.out.println(L.first);
	}
	
	public static void main(String[] args) {
		StringList L = new StringList("eat", null);
		L = new StringList("shouldn't", L);
		L = new StringList("you", L);
		L = new StringList("sometimes", L);
		StringList M = L.rest;
		StringList R = new StringList("many", null);
		R = new StringList("potatoes", R);
		R.rest.rest = R;
		M.rest.rest.rest = R.rest;
		L.rest.rest = L.rest.rest.rest;
		L = M.rest;
	}
}
