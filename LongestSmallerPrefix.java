import java.util.ArrayList;
import java.util.List;

// Jessica Kwok
// jlk187 - can use recursion, no loops
public class LongestSmallerPrefix {

	// transform two input strings into list<Character>
	public List<Character> stringToList(String s, List<Character> result) {
		if (s.length() == 0) 
			return result;
		result.add(s.charAt(0));
		String ss = s.substring(1);
		return stringToList(ss, result);
	}
	
	// invoke generic method that will return longest smaller prefix
	public <T> List<T> longestSmallerPrefix(List<T> a, List<T> b, List<T> result) {
		if (a.size() == 0 || b.size() == 0)
			return result;
		Character a1 = (Character) a.get(0);
		Character b1 = (Character) b.get(0);
		if (a1.compareTo(b1) > 0)
			return result;
		if (a1.compareTo(b1) <= 0)
			result.add(a.get(0));
		List<T> aSub = a.subList(1, a.size());
		List<T> bSub = b.subList(1, b.size());
		return longestSmallerPrefix(aSub, bSub, result);
	}
	
	public static <T> void main(String[] args) {
		LongestSmallerPrefix lsp = new LongestSmallerPrefix();
		List<Character> result = new ArrayList<Character>();
		List<Character> a = new ArrayList<Character>();
		List<Character> b = new ArrayList<Character>();
		String s1 = new String();
		String s2 = new String();
		
		// "hello", "hello" -> [h,e,l,l,o]
		s1 = "hello";
		s2 = "hello";
		lsp.stringToList(s1, a);
		lsp.stringToList(s2, b);
		lsp.longestSmallerPrefix(a, b, result);
		System.out.println(result);
		
		// "", "hello" -> []
		result.clear();
		a.clear();
		b.clear();
		s1 = "";
		lsp.stringToList(s1, a);
		lsp.stringToList(s2, b);
		lsp.longestSmallerPrefix(a, b, result);
		System.out.println(result);
		
		// "hello", "" -> []
		result.clear();
		a.clear();
		b.clear();
		s1 = "hello";
		s2 = "";
		lsp.stringToList(s1, a);
		lsp.stringToList(s2, b);
		lsp.longestSmallerPrefix(a, b, result);
		System.out.println(result);
		
		// "abd", "abc" -> [a,b]
		result.clear();
		a.clear();
		b.clear();
		s1 = "abd";
		s2 = "abc";
		lsp.stringToList(s1, a);
		lsp.stringToList(s2, b);
		lsp.longestSmallerPrefix(a, b, result);
		System.out.println(result);
		
		// "bac", "abc" -> []
		result.clear();
		a.clear();
		b.clear();
		s1 = "bac";
		s2 = "abc";
		lsp.stringToList(s1, a);
		lsp.stringToList(s2, b);
		lsp.longestSmallerPrefix(a, b, result);
		System.out.println(result);
		
		// "acbd", "abcd" -> [a]
		result.clear();
		a.clear();
		b.clear();
		s1 = "acbd";
		s2 = "abcd";
		lsp.stringToList(s1, a);
		lsp.stringToList(s2, b);
		lsp.longestSmallerPrefix(a, b, result);
		System.out.println(result);
	}
	
}
