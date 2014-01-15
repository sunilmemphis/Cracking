import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelPrinting {

	public class TreeNode
	{
		String name;
		public List<TreeNode> children;
		TreeNode(String name) {
			this.name = name;
			children = new LinkedList<TreeNode>();
		}
		public List<TreeNode> getChildren() {
			return children;
		}
	};
	
	
	void printLevels(TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 0;
		int count = 1;
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode curr = queue.remove();
			if(--count == 0) {
				//System.out.print("\nLevel "+level+" : ");
				level++;
				
			}
			
			System.out.print(curr.name+" ");
			for(TreeNode child : curr.children) {
				queue.add(child);
				
			}
			
			if(count == 0) {
				count=queue.size();
				System.out.println();
			}
			
			
		}
		
	}
	
	public void test() {
		TreeNode n1 = new TreeNode("a2");
		TreeNode n2 = new TreeNode("b2");
		List<TreeNode> children_a1 = new LinkedList<TreeNode>();
		children_a1.add(n1);
		children_a1.add(n2);
		
		TreeNode n3 = new TreeNode("c2");
		List<TreeNode> children_b1 = new LinkedList<TreeNode>();
		children_b1.add(n3);
		TreeNode n4 = new TreeNode("a1");
		n4.children = children_a1;
		TreeNode n5 = new TreeNode("b1");
		n5.children = children_b1;
		TreeNode n6 = new TreeNode("a0");
		List<TreeNode> children_a0 = new LinkedList<TreeNode>();
		children_a0.add(n4);
		children_a0.add(n5);
		n6.children = children_a0;
		
		printLevels(n6);
		
	}
	
	public static void main(String[] args) {
	
		LevelPrinting lp = new LevelPrinting();
		lp.test();
		
	}
	
	
	
	
}
