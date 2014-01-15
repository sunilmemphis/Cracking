import java.util.ArrayList;
import java.util.Collections;


public class LongestSequence {
	public class Pair implements Comparable<Pair> {
		public int a;
		public int b;

		@Override
		public int compareTo(Pair second) {
			
			return b - second.a;
		}

		
	};
	
	public static int findLongest(ArrayList<Pair> pairs) {
		int currLength = 0;
		
		
		Collections.sort(pairs);
		
		
		for(int index=1;index<pairs.size();index++) {
			if(pairs.get(index - 1).b > pairs.get(index).a)
				currLength++;
			
		}
		
		return currLength;
		
		
	}
}
