import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
	public static void main (String [] args) {
		List<String> l1 = new ArrayList<>(Arrays.asList("one", "two", "three"));
		List<String> l2 = new ArrayList<>(Arrays.asList("one", "two", "five", "six"));
		List<String> l3 = new ArrayList<>(Arrays.asList("two", "five"));
		List<String> res = solution (l1, l2, l3);
		for (String s : res) System.out.print(s + " ");
		System.out.println();
		
		l1 = new ArrayList<>(Arrays.asList("aaa", "bbbb", "bbbbb","bbbb"));
		l2 = new ArrayList<>(Arrays.asList("bb", "aa", "cccc"));
		l3 = new ArrayList<>(Arrays.asList("bb", "aa"));
		res = solution (l1, l2, l3);
		for (String s : res) System.out.print(s + " ");
		
	}
	
	private static List<String> solution (List<String> origin, List<String> add, List<String> remove) {
		
		//exclude strings that are supposed to be removed
		Set<String> set = new HashSet<>(remove);
		
		//add strings in the original list
		List<String> res = new ArrayList<>();
		for (String s: origin) {
			if (set.add(s)) res.add(s);
		}
		
		for (String s: add) {
			//add the string only when it is not in the remove list and has not been added yet
			if (set.add(s)) res.add(s);
		}
		
		//sort: fisrt by character count, then by reverse alphabetical
		Collections.sort (res, new Comparator<String> () {
			public int compare (String s1, String s2) {
				if (s1.length() != s2.length()) return s2.length() - s1.length();
				else {
					for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
						char c1 = s1.charAt(i), c2 = s2.charAt(i);
						if (c1 != c2) return c2 - c1;
					}
					return 0;
				}
			}
		});
		return res;
	}
}
