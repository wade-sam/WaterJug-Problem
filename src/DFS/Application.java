package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;
public class Application {
	
	public static Stack<Node> stack = new Stack<>(); 
	public  static Set<Node> StateExists;
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
				StateExists = new HashSet<>();
				StateExists.add(root);
				Stack<Integer>CurrentLevelTracker = new Stack<>();
				CurrentLevelTracker.push(0);
				int NoNodes = 0;
				
				while(!stack.isEmpty()) {
					NoNodes++;
					int temp = 0;
					Node node = stack.pop();
					int currentLevel = CurrentLevelTracker.pop();
					
					if (node.A == JugAcapacity && node.B == 0 && JugAcapacity > Gu) {
						if (node.C == 0) {
							Node nextNode = new Node(JugAcapacity-JugBcapacity, JugBcapacity,0);
						}
						else {
							Node nextNode = new Node(JugAcapacity-JugBcapacity, JugBcapacity,node.C);
						}
						
						
					} else if (node.A == JugAcapacity && node.C == 0) {
						if (node.B == 0) {
							Node nextNode = new Node (JugAcapacity-JugCcapacity, 0, JugCcapacity);
						}
						else {
							Node nextNode = new Node (JugAcapacity-JugCcapacity, node.B, JugCcapacity);
						}
						
						
					}
				}

	}
	
}