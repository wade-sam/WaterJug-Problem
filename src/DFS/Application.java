package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;
public class Application {
	
	public static Stack<Node> stack = new Stack<>(); 
	public static Set<Node> StateExists;
	public static int JugAcapacity;
	public static int JugBcapacity;
	public static int JugCcapacity;
	
	public static void main(String args[]) {
		Scanner UserInput = new Scanner(System.in);
		System.out.println("Please Input the Capacity for Jug A: ");
		int JugAcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity fot Jug B: ");
		int JugBcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity for Jug C: ");
		int JugCcapacity = UserInput.nextInt(); 
		
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
				boolean test = true;
				while(!stack.isEmpty()) {
					NoNodes++;
					int temp = 0;
					Node node = stack.pop();
					int currentLevel = CurrentLevelTracker.pop();
						if (node.A == 0) {
							Node nextNode = new Node(JugAcapacity,node.B, node.C);
							if(alreadyExists(nextNode)) {
								CurrentLevelTracker.push(currentLevel + 1);
								System.out.print(" return1");
							}
							
						}
						 if (node.B == 0) {
							Node nextNode5 = new Node(node.A,JugBcapacity, node.C);
							if(alreadyExists(nextNode5)) {
								CurrentLevelTracker.push(currentLevel + 1);
								System.out.print(" return2");
							}
							
						}
						 if (node.C == 0) {
							Node nextNode1 = new Node(node.A,node.B, JugCcapacity);
							if(alreadyExists(nextNode1)) {
								CurrentLevelTracker.push(currentLevel + 1);
								System.out.print(" return3");
							}
					}
					
						if (node.A == JugAcapacity) {
							Node nextNode2 = new Node(0,node.B, node.C);
								if (alreadyExists(nextNode2)) {
									CurrentLevelTracker.push(currentLevel + 1);
									System.out.print(" return4");
								}
							}
						if (node.B == JugBcapacity) {
							Node nextNode3 = new Node(node.A, 0,node.C);
							if (alreadyExists(nextNode3)) {
								CurrentLevelTracker.push(currentLevel + 1);
								System.out.print(" return5");
							}
						}
						if (node.C == JugCcapacity) {
							Node nextNode4 = new Node(node.A, node.B, 0);
							if (alreadyExists(nextNode4)) {
								CurrentLevelTracker.push(currentLevel + 1);
								System.out.print(" return6");
							}
						}
					
					  
					 if (node.A != 0 && node.B != JugBcapacity) {
						int outcome[] = pourJugs(node.A, node.B, JugBcapacity);
						
						
						node.A = outcome[0];
					}
					 //System.out.print(currentLevel);
					 //test = false;
					 
					}
					/*
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
					*/
	}

	
	public static boolean alreadyExists(Node node) {
		if(!StateExists.contains(node)) {
			stack.push(node);
			StateExists.add(node);
			System.out.print(" returnTRUE" + node.A + node.B + node.C);
			return true;
		}else {
			System.out.print(" returnFALSE");
			return false;
			
		}
	}
	public static int[] pourJugs(int x, int y, int z) {
		int changes[] = new int[3];
		if((x + y) > z) {
			x = (x + y) - z;
			y = z;
			Math.abs(x);
			changes[0] = x;
			changes[1] = y;
			changes[2] = z;
		}else if ((x + y) <= z){
			x = 0;
			y = x + y;
			changes[0] = x;
			changes[1] = y;
			changes[2] = z;
		}
		return changes;
	}
	
}