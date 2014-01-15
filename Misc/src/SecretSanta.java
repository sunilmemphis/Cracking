
public class SecretSanta {

	public static void secretShuffle(int[] users) {
		int[] usersCopy = users.clone();
		int i=0;
		while( i < users.length) {
			int randomGiverIndex = (int)(Math.random() * (users.length - i -1)) + i;
			int randomTakerIndex = (int)(Math.random() * (users.length - i -1)) + i;
			if(users[randomGiverIndex] == usersCopy[randomTakerIndex]  && (randomGiverIndex != users.length -1)) {
				//i--;
				continue;
			}
			
			int temp = users[i];
			users[i] = users[randomGiverIndex];
			users[randomGiverIndex] = temp;
			
			temp = usersCopy[i];
			usersCopy[i] = usersCopy[randomTakerIndex];
			usersCopy[randomTakerIndex] = temp;
			
			System.out.println(users[i]+ " -> "+usersCopy[i]);
			i++;
		}
	}
	
	public static void main(String[] args) {
		int[] users = {1,2,3,4,5 } ;
		secretShuffle(users);
	}
	
}
