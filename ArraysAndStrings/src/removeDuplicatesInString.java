import java.util.HashMap;


public class removeDuplicatesInString {
	
	public static char[] removeDuplicates(char[] word) {
		int noOfDuplicates = 0;
		for(int i=0;i<word.length - 1;i++) {
			//check if it exists?
			//if yes leave it alone
			//if no , overwrite on it
			boolean found = false;
			for(int searchI = 0; searchI <i; searchI++ ) {
				if(word[searchI] == word[i]) 
					found = true;
			}
			
			if(found) {
				for(int k=i;k < word.length - 2;k++) {
					word[k] = word [k+1];
				}
			} else 
				noOfDuplicates++;
		}
		word[noOfDuplicates] = word[word.length - 1];
		System.out.println(noOfDuplicates);
		return word;
	}

	
	public static void test(String word) {
		System.out.println("The deduplicated form of  "+word+ " is "+ (new String (removeDuplicates(word.toCharArray()))));
	}
	
	public static void main(String args[]) {
		test("aa.");
		test(".");
		test("this is a test.");
		test("qwertyuiopasdf.");
		test("hello hello.");
		
	}
}
