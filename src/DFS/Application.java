package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
public class Application {
	
	public static Stack<Node> stack = new Stack<>(); 
	public  static Set<Node> loggedNodesExisting;
	public static int JugAcapacity;
	public static int JugBcapacity;
	public static int JugCcapacity;
	
	public static void main(String args[]) {
		Scanner UserInput = new Scanner(System.in);
		System.out.println("Please Input the Capacity for Jug A: ");
		JugAcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity fot Jug B: ");
		JugBcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity for Jug C: ");
		JugCcapacity = UserInput.nextInt(); 
		
		System.out.println(JugAcapacity);
		System.out.println(JugBcapacity);
		System.out.println(JugCcapacity);
		
			int treeLevel = 0;
			Node root = new Node(0,0,0);
			stack.push(root);
			System.out.print(stack);
				
		
	}
}
