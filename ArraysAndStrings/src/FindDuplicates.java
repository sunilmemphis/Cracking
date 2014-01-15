import java.util.HashMap;


public class FindDuplicates {

	// O(n)
	public static boolean containsDuplicates(String word) {
		HashMap<Character,Boolean> letters = new HashMap<Character,Boolean>();
		if(word == null) 
			return false;
		for(Character c: word.toCharArray()) {
			if(letters.containsKey(c))
				return true;
			letters.put(c, true);
		}
		return false;
	}
	
	// O(n2)
	public static boolean containsDuplicatesWithoutAdditionDS(String word) {
		if(word ==null) 
			return false;
		char[] letters = word.toCharArray();
		
		for(int currentCharacterIndex=0; currentCharacterIndex< letters.length; currentCharacterIndex++) {
			for(int remainingIndex = currentCharacterIndex+1; remainingIndex < letters.length; remainingIndex++) {
				if(letters[currentCharacterIndex] == letters[remainingIndex]) 
					return true;
			}
			
		}
		return false;
		
	}
	
	public static void test(String word) {
		if(containsDuplicatesWithoutAdditionDS(word))
			System.out.println(word + "  contains duplicates ");
		else 
			System.out.println(word + " doesnt contain duplicates ");
	}
	
	public static void main(String args[]) {
		test("aa");
		test("");
		test("this is a test");
		test("qwertyuiopasdf");
	}
}
