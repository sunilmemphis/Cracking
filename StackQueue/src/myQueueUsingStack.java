import java.util.Stack;


public class myQueueUsingStack {
	private static int sizeOfStack = 10;
	private static Stack<Integer> primary = new Stack<Integer>();
	private static Stack<Integer> secondary  = new Stack<Integer>();
	
	public static Integer pop() {
		if(primary.size() == 0) {
			return null;
		} else {
			while(!primary.isEmpty())
				secondary.push(primary.pop());
			Integer element =  secondary.pop();
			
			while(!secondary.isEmpty())
				primary.push(secondary.pop());
			
			return element;
			
		}
	}
	
	public static boolean push(Integer element) {
		if(primary.size() == sizeOfStack)
			return false;
		else {
			primary.push(element);
			return true;
		}
	}
	
	public static void printStack() {
		for(int elementNo = 0; elementNo < primary.size();elementNo++)
			System.err.print(primary.elementAt(elementNo) + " ");
		System.out.println("\n");
		System.out.flush();
	}
	
	public static void main(String[] args) {
		System.out.println(myQueueUsingStack.push(1));
		myQueueUsingStack.printStack();
		System.out.println(myQueueUsingStack.push(2));
		myQueueUsingStack.printStack();
		System.out.println(myQueueUsingStack.push(3));
		myQueueUsingStack.printStack();
		System.out.println(myQueueUsingStack.pop());
		myQueueUsingStack.printStack();
		System.out.println(myQueueUsingStack.pop());
		myQueueUsingStack.printStack();
		System.out.println(myQueueUsingStack.pop());
		myQueueUsingStack.printStack();
		
	}
}
