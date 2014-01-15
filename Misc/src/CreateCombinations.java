import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class CreateCombinations {

	public static void createCombinations(String word, int noOfElements, ArrayList<String> combinations) {
		if(noOfElements == 0) {
			combinations.add("");
			return;
		}
		//System.out.println(combinations.size());
		createCombinations(word,noOfElements -1,combinations);
		//System.err.println(combinations.size());
		int sizeOfCombinations = combinations.size();
		for(int i=0;i<sizeOfCombinations; i++) {
			String Val = combinations.get(i);
			if(word.toCharArray()[noOfElements - 1] == '0') {
				if(!combinations.contains(Val+'0'))
					combinations.add(Val+'0');
			} else if(word.toCharArray()[noOfElements - 1] == '1') {
				if(!combinations.contains(Val+'1'))
					combinations.add(Val+'1');
			} else if(word.toCharArray()[noOfElements - 1] == '?') {
				if(!combinations.contains(Val+'1'))
					combinations.add(Val+'1');
				if(!combinations.contains(Val+'0'))
					combinations.add(Val+'0');
			}
		}
		
	}
	
	public static void printSet(ArrayList<String> set) {
		if(set == null)
			return;
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<String> comb = new ArrayList<String>();
		createCombinations("0?", 2 , comb);
		printSet(comb);
	}
}
