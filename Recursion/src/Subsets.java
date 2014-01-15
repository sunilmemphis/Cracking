import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Subsets {
	public static ArrayList<Set<Integer>> generateSets(int currentElement, int[] values) {
		ArrayList<Set<Integer>> setOfSets = new ArrayList<Set<Integer>>();
		System.out.println("CR"+currentElement);
		if(currentElement == 0) {
			Set<Integer> newSet = new HashSet<Integer>();
			newSet.add(values[0]);
			setOfSets.add(newSet);
			Set<Integer> EmptySet = new HashSet<Integer>();
			
			setOfSets.add(EmptySet);
			return setOfSets;
		} else {
			setOfSets = generateSets(currentElement -1, values);
			int size = setOfSets.size();
			
			for(int i=0;i<size;i++) {
				
				Set<Integer> newSet = new HashSet<Integer>(setOfSets.get(i));
				newSet.add(values[currentElement]);
				setOfSets.add(newSet);
			}
			return setOfSets;
		}
	}
	
	
	public static ArrayList<Set<Integer>>  generateSetsNumber(int[] values) {
		ArrayList<Set<Integer>> setOfSets = new ArrayList<Set<Integer>>();
		
		for(int i=0;i<Math.pow(2, values.length);i++) {
			int val = i;
			Set<Integer> newSet = new HashSet<Integer>();
			int elementPostion=0;
			while(val > 0) {
				if((val & 1) == 1)
					newSet.add(values[elementPostion]);
				
				elementPostion++;
				val = val>>1;
			}
			
			setOfSets.add(newSet);
		}
		
		
		
		return setOfSets;
		
	}
	
	public static void printSets(ArrayList<Set<Integer>> setOfSets) {
		for(int i=0;i<setOfSets.size();i++) {
			System.out.print("{ ");
			Iterator<Integer> iter = setOfSets.get(i).iterator();
			while(iter.hasNext()) {
				System.out.print(iter.next()+" , ");
			}
			System.out.println(" } ");
		}
	}
	
	public static ArrayList<String> permutateString(String remainderString) {
		ArrayList<String> permutationOfStrings = new ArrayList<String>();
		
		if(remainderString.length() == 1) {
			permutationOfStrings.add(remainderString);
			return permutationOfStrings;
		} else {
			char firstElement = remainderString.charAt(0);
			
			ArrayList<String> permutationRemainingString = permutateString(remainderString.substring(1));
			
			for(String remainingString : permutationRemainingString) {
				for(int i=0;i<remainingString.length();i++) {
					String newString = remainingString.substring(0, i) + firstElement + remainingString.substring(i);
					permutationOfStrings.add(newString);
				}
				permutationOfStrings.add(remainingString + firstElement);
			
			}
			
			return permutationOfStrings;
			
		}
		
		
	}
	
	public static void printPermutations(ArrayList<String> permutations) {
		
		for(String combination: permutations) {
			System.out.println(combination);
		}
		
	}
	
	public static void permParan(int l, int r, int n, String stringTillNow) {
		if(l==n && r==n) 
			System.out.println(stringTillNow);
			
		if(l>r) {
			permParan(l,r+1,n,stringTillNow+")");
		}
		
		if(l<n) 
			permParan(l+1,r,n,stringTillNow+"(");
		
		
	}
	
	public static int numberOfCombinations = 0;
	
	public static void noOfCoins(int currentSum, int currencyToBeUsed, int n) {
		int currency[] = {25,10,5,1};
		
		if(currencyToBeUsed < 4 && currentSum <= n) {
		
			if(currentSum == n) {
				numberOfCombinations++;
			} else {
				int noOfCoins= (int) (n - currentSum) / currency[currencyToBeUsed];
				for(int i=0;i<=noOfCoins;i++) {
					noOfCoins(currentSum + i * currency[currencyToBeUsed], currencyToBeUsed + 1,n);
				}
				
			}
		
		
		}
		
	}

	
	
	public static void main(String[] args) {
		ArrayList<Set<Integer>> setOfSets = new ArrayList<Set<Integer>>();
		int value[] = {1,2,3};
		//setOfSets = generateSets(value.length -1, value);
		//setOfSets = generateSetsNumber(value);
		//printSets(setOfSets);
		
		//printPermutations(permutateString("abc"));
		
		//permParan(0,0,3,"");
		
		noOfCoins(0, 0, 100);
		System.out.println(numberOfCombinations);
	}

	
}
