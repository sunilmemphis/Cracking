import java.util.HashMap;


public class OddAndEven {

	public static int[] splitOddAndEven(int[] array) {
		int even = 0;
		int odd  = array.length - 1;
		
		while(even != odd - 1 ) {
			
			if(array[even] % 2 == 0) {
				even++;
			} else {
				int temp = array[odd];
				array[odd] = array[even];
				array[even] = temp;
				odd--;
				
			}
			
			
			
		}
		
		return array;
	}
	
	
	public static int sumOfNumbers(int[] array) {
		int maxsum = -1;
		int noOfElementsInSeq = 0;
		int sumOfSeq = 0;
		int prevVal = -1;
		int index = -1;
		for(int i : array) {
			index++;
			if(i > prevVal) {
				noOfElementsInSeq++;
			} else {
				noOfElementsInSeq = 0;
				sumOfSeq = 0;
			}
			
			sumOfSeq += i;
			
			if(noOfElementsInSeq == 3) {
				if(maxsum < sumOfSeq)
					maxsum = sumOfSeq;
				
				sumOfSeq = sumOfSeq - array[index - 2];
				noOfElementsInSeq--;
			}
			
			prevVal = i;
			
			
		}
		
		return maxsum;
		
	}
	
	public static int findIndex(int n) {
		int index = 0;
		
		for(int i=0;i<4;i++) {
			index += (n % Math.pow(10,i+1)) * i;
			if(n < Math.pow(10,i+1)) {
				return index--;
			}

		}
		
		return index;


	}


	public static int redoIndex(int n) {
		int index=0;
		int noOfElements = 1;
		for(int i=0;i<n;i++) {
			if(i==Math.pow(10,noOfElements))
				noOfElements++;
			index+= noOfElements;
		}

		return index -1;

	}
	
	
	public static int divideWithoutDivide(int a,int b) {
		int sign = -1;
		if(a*b >0)
			sign = 1;
		int noOfTimes = 0;
		while(noOfTimes*b<=a) {
			noOfTimes = noOfTimes + sign*1;
		}
		return noOfTimes- sign *1;
		
		
	}
	
	public static String removeRedunsantCharacters(String word) {
		char[] wordArr = word.toCharArray();
		int index=0;
		HashMap<Character,Boolean> lettersUsed = new HashMap<Character,Boolean>();
		for(int j=0;j<wordArr.length;j++) {
			if(!lettersUsed.containsKey(new Character(wordArr[j]))) {
				wordArr[index++] = wordArr[j];
				lettersUsed.put(new Character(wordArr[j]), new Boolean(true));
			}
		}
		
		return new String(wordArr).substring(0,index);
		
	}
	
	public static void printArray(int[] array) {
		for(int i: array) {
			System.out.print(i + " , ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int array[] = {2,6,8,10, 4, 5, 19,11,13};
		//printArray(splitOddAndEven(array));
		//System.out.println(sumOfNumbers(array));
		
	//	System.out.println(divideWithoutDivide(-12, -2));
		
		System.out.println(removeRedunsantCharacters("this is the end"));
	}
	
	
}
