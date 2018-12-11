package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Application {
	
	public static Stack<Node> stack = new Stack<>(); 
	public static ArrayList  nodeComparison = new ArrayList();
	public static Set<Node> StateExists;
	public static int JugAcapacity;
	public static int JugBcapacity;
	public static int JugCcapacity;
	public static int jugA = 0;
	public static int jugB = 0;
	public static int jugC = 0;
	public static int count = 0;
	public static Stack<Integer>CurrentLevelTracker = new Stack<>();
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
				//nodeComparison.add(root)

				CurrentLevelTracker.push(0);
				int NoNodes = 0;
				boolean test = true;
				
				
				while(!stack.isEmpty()) {
					NoNodes++;
					int temp = 0;
					Node node = stack.pop();
					//int currentLevel = CurrentLevelTracker.pop();
			if (jugA == 0 || jugB == 0 || jugC == 0) {
				if (jugA == 0) {
					jugA = JugAcapacity + jugA;
					Node nextNode = new Node(jugA,jugB,jugC);
					
					if(alreadyExists(nextNode)) {
						CurrentLevelTracker.push(currentLevel + 1);
						System.out.print(" return1");
					}
					
				}
				if (jugB == 0) {		 
					 jugB = JugBcapacity + jugB;
					Node nextNode = new Node(jugA,JugBcapacity,jugC);
					if(alreadyExists(nextNode)) {
						CurrentLevelTracker.push(currentLevel + 1);
						System.out.print(" return2");
					}
					
				}
				 if (jugC == 0) {
					 jugC = JugCcapacity + jugC;
					Node nextNode = new Node(jugA,jugB,JugCcapacity);
					if(alreadyExists(nextNode)) {
						CurrentLevelTracker.push(currentLevel + 1);
						System.out.print(" return3");
					}
			}
			}else if (jugA == JugAcapacity || jugB == JugBcapacity || jugC == JugCcapacity) {
				
				if (jugA == JugAcapacity) {
				Node nextNode = new Node(0,jugB,jugC);
				jugA = 0;
					if (alreadyExists(nextNode)) {
						CurrentLevelTracker.push(currentLevel + 1);
						System.out.print(" return4");
					}
				}
			
			 if (jugB == JugBcapacity) {
				 Node nextNode = new Node(jugA,0,jugC);
				jugB=0;
				if (alreadyExists(nextNode)) {
					CurrentLevelTracker.push(currentLevel + 1);
					System.out.print(" return5");
				}
				
			}
			 
			 if (jugC == JugCcapacity) {
				 Node nextNode = new Node(jugA, jugB, 0);
				 jugC = 0;
				 if (alreadyExists(nextNode)) {
					 CurrentLevelTracker.push(currentLevel + 1);
					 System.out.print("return 6");
				 }
			 }
				
				
			}else if (jugA != 0 && jugB != JugBcapacity || jugA != 0 && jugC != JugCcapacity || jugB != 0 && jugA != JugAcapacity || jugB != 0 && jugC != JugCcapacity || jugC != 0 && jugA != JugAcapacity || jugC != 0 && jugB != JugBcapacity) {
				if (jugA != 0 && jugB != JugBcapacity) {
					 System.out.print(" REACHED 7 ");
						int outcome[] = pourJugs(jugA, jugB, JugBcapacity);
						jugA = outcome[0];
						jugB = outcome[1];
						Node nextNode = new Node (jugA, jugB, jugC);
						if (alreadyExists(nextNode)) {
						CurrentLevelTracker.push(currentLevel + 1);
						System.out.print(" return7");
					}
					
					}
					 if (jugA != 0 && jugC != JugCcapacity) {
						 System.out.print(" REACHED 8 ");
						int outcome[] = pourJugs(jugA, jugC, JugCcapacity);
						 jugA = outcome[0];
						 jugC = outcome[1];
						Node nextNode = new Node (jugA, jugB, jugC);
						if (alreadyExists(nextNode)) {
							CurrentLevelTracker.push(currentLevel + 1);
							System.out.print(" return8");
						}
					
					}
					 if (jugB != 0 && jugA != JugAcapacity) {
						 System.out.print(" REACHED 9 ");
						int outcome[] = pourJugs(jugB, jugA, JugAcapacity);
						 jugB = outcome[0];
						 jugA = outcome[1];
						Node nextNode = new Node (jugA, jugB, jugC);
						if (alreadyExists(nextNode)) {
							CurrentLevelTracker.push(currentLevel + 1);
							System.out.print(" return9");
						}
						
					}
					 if (jugB != 0 && jugC != JugCcapacity) {
						 System.out.print(" REACHED 10 ");
						int outcome[] = pourJugs(jugB, jugC, JugCcapacity);
						 jugB = outcome[0];
						 jugC = outcome[1];
						Node nextNode = new Node (jugA, jugB, jugC);
						if (alreadyExists(nextNode)) {
							CurrentLevelTracker.push(currentLevel + 1);
							System.out.print(" return10");
						}
					
					}
					 if (jugC != 0 && jugA != JugAcapacity) {
						 System.out.print(" REACHED 11 ");
						int outcome[] = pourJugs(jugC, jugA, JugAcapacity);
						jugC = outcome[0];
						jugA = outcome[1];
						System.out.print(jugC);
						Node nextNode = new Node (jugA, jugB, jugC);
						if (alreadyExists(nextNode)) {
							CurrentLevelTracker.push(currentLevel + 1);
							System.out.print(" return11");
						}
					
					}
					 if (jugC != 0 && jugB != JugBcapacity) {
						 System.out.print(" REACHED 12 ");
						int outcome[] = pourJugs(jugC, jugB, JugBcapacity);
						jugC = outcome[0];
						jugB = outcome[1];
						Node nextNode = new Node (jugA, jugB, jugC);
						if (alreadyExists(nextNode)) {
							CurrentLevelTracker.push(currentLevel + 1);
							System.out.print(" return12");
						}
					
			//System.out.print(count);
		  }
			} 
				
				
				
 
				
				
				
				
			}
						
						
					

					
						
						
						
						 
						 

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
	public static void SendToAlreadyExists(Node node) {
		if (alreadyExists(node)) {
			CurrentLevelTracker.push(currentLevel + 1);
		}
		
	}

	public static boolean alreadyExists(Node node) {
		if(!StateExists.contains(node)) {
			stack.push(node);
			StateExists.add(node);
			System.out.print(" returnTRUE" + jugA + jugB + jugC);
			count++;
			return true;
		}
			return false;
			
		}
	/*
	public static boolean checkIfExists(Node nodeC) {
		StringBuilder temp = new StringBuilder();
		temp.append(jugA);
		temp.append(jugB);
		temp.append(jugC);
		
		
		//System.out.print(temp);
		if(!nodeComparison.contains(nodeC)) {
			stack.push(nodeC);
			nodeComparison.add(nodeC);
			//System.out.println(nodeComparison);
			System.out.print("returnTRUE" + jugA + jugB + jugC);
			return false;
		}
		System.out.print("returnFALSE");
		return true;
	}
	*/
	public static int[] pourJugs(int x, int y, int z) {
		System.out.print("reached");
		int changes[] = new int[3];
		if((x + y) > z) {
			x = (x + y) - z;
			y = z;
			Math.abs(x);
			changes[0] = x;
			changes[1] = y;
			changes[2] = z;
		}else if ((x + y) <= z){
			y = x + y;
			x = 0;
			changes[0] = x;
			changes[1] = y;
			changes[2] = z;
		}
		return changes;
	}
	
}