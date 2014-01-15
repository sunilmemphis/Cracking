import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;


public class NodeIterator implements Iterable<Integer>{
	ArrayList<Integer> buffer;
	
	int size;
	public NodeIterator(int size) {
		this.size = size;
		buffer = new ArrayList<Integer>();
	}
	
	public Iterator<Integer> iterator() {
		return new myNodeIterator(this);
	}
	
	class myNodeIterator implements Iterator<Integer> {
		BitSet hasNext = new BitSet();
		int index = 0;
		NodeIterator ni;
		
		public myNodeIterator(NodeIterator ni) {
			this.ni = ni;
		}
		public boolean hasNext() {
			if(index >= ni.buffer.size())
				return false;
			
			return true;
		}
		
		public Integer next(){
			if(index >= ni.buffer.size())
				return null;
			else {
				hasNext.set(index);
				return ni.buffer.get(index++);
			}
		}

		@Override
		public void remove() {
			
			if(index < 0 && !hasNext.get(index - 1)) {
				throw new IllegalStateException();
			}
			
			ni.buffer.remove(index -1);
			
		}
		
		
		
	};
	
	public static void main(String[] args) {
		NodeIterator ni = new NodeIterator(4);
		ni.buffer.add(1);
		ni.buffer.add(2);
		ni.buffer.add(3);
		ni.buffer.add(4);
		
		Iterator<Integer> newIterator =ni.iterator();
		
		while(newIterator.hasNext()) {
			System.out.print(newIterator.next() + " ");
		}
		
		newIterator.remove();
		newIterator =ni.iterator();
		
		while(newIterator.hasNext()) {
			System.out.print(newIterator.next() + " ");
		}
		
	}
}
