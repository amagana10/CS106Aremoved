import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {

	public static void main(String[] args) {
		// HashSet doesn't retain order
		// Set<String> set1 = new HashSet<String>();
		// TreeSet sorts in natural order
		// Set<String> set1 = new TreeSet<String>();
		// LinkedHashSet remember the order you added item in
		Set<String> set1 = new LinkedHashSet<String>();

		if (set1.isEmpty()) {
			System.out.println("set is empty at start");
		}
		set1.add("dog");
		set1.add("cow");
		set1.add("cat");
		set1.add("sheep");
		set1.add("lion");
		// adding duplicate item does nothing
		set1.add("cow");

		if (set1.isEmpty()) {
			System.out.println("set is empty after adding no!");
		}

		System.out.println(set1);

		////// iterations////
		for (String element : set1) {
			System.out.println(element);
		}

		/////// does set contains a given item //////
		if (set1.contains("mamal")) {
			System.out.println("contains mamal");
		}
		if (set1.contains("cat")) {
			System.out.println("contains cat");
		}

		//set2 contains some common elements with set1 and some new
		
		Set<String> set2 = new LinkedHashSet<String>();

		set2.add("dog");
		set2.add("cow");
		set2.add("Monkey");
		set2.add("giraff");
		set2.add("ant");
		
		Set<String> intersection = new HashSet<String>(set1);

		intersection.retainAll(set2);
		System.out.println(intersection);
		
         //////  Difference////
		
		Set<String> difference= new HashSet<String>(set1);
		
		difference.removeAll(set2);
		System.out.println(difference);
		
	}
    
	
}
