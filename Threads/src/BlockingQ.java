import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class BlockingQ {
	final int SIZE = 10;
	Semaphore available = new Semaphore(SIZE);
	Semaphore used 		= new Semaphore(0);
	Queue BQ = new LinkedList();
	
	
	public int get() {
		try {
			used.acquire();
			return (int)BQ.remove();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			available.release();
		}
	}
	
	public boolean add(int item) {
		try {
			available.acquire();
			BQ.add(item);
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			used.release();
		}
	}
	
	public static void main(String[] args) {
		BlockingQ BQ = new BlockingQ();
		
	}
	
}
