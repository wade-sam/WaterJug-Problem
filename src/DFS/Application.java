package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Application {
	
	public static Stack<Node> stack = new Stack<>(); 
	//public static ArrayList nodeComparison = new ArrayList();
	public static Set<Node> StateExists;
	public static int JugAcapacity;
	public static int JugBcapacity;
	public static int JugCcapacity;
	public static int jugA = 0;
	public static int jugB = 0;
	public static int jugC = 0;
	public static int count = 0;
	
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
		
		
			Node root = new Node();
			root.a = 0;
			root.b = 0;
			root.c = 0;
			stack.push(root);
			System.out.print(stack);
				StateExists = new HashSet<>();
				StateExists.add(root);
				//nodeComparison.add(root)
				Stack<Integer>CurrentLevelTracker = new Stack<>();
				CurrentLevelTracker.push(0);
				int NoNodes = 0;
				boolean test = true;
				
				
				while(!stack.isEmpty()) {
					NoNodes++;
					int temp = 0;
					Node node = stack.pop();
					int currentLevel = CurrentLevelTracker.pop();
				
			//System.out.print(count);
		  }
	
			}
	
	private void logic (Node node) {
		System.out.print(node.a +" " + node.b +" " + node.c + " ");
		List<Node> neighbours=node.getNeighbours();
		node.visited=true;
		for (int i=0; i < neighbours.size(); i++) {
			Node n=neighbours.get(i);
			if(n!=null && n.visited) {
				logic(n);
			}
		}
	}
	
	
	private static Node fillUpA(Node aN) {
		Node tempNode = new Node(aN.a,aN.b,aN.c);
		aN.a = JugAcapacity;
		tempNode.b = aN.a;
		tempNode.c = aN.b;
		return tempNode;
	}
	private static Node fillB(Node bN) {
		Node tempNode = new Node(bN.a, bN.b,bN.c);
		tempNode.a = bN.a;
		tempNode.b = JugBcapacity;
		tempNode.c = bN.c;
		return tempNode;
	}
	private static Node fillC(Node cN) {
		Node tempNode = new Node();
		tempNode.a = cN.a;
		tempNode.b = cN.b;
		tempNode.c = JugCcapacity;
		return tempNode;
	}
	private static Node EmptyA(Node aE) {
		Node tempNode = new Node();
		tempNode.a = 0;
		tempNode.b = aE.b;
		tempNode.c = aE.c;
		return tempNode;
	}
	private static Node EmptyB(Node bE){
		Node tempNode = new Node();
		tempNode.a = bE.a;
		tempNode.b = 0;
		tempNode.c = bE.c;
		return tempNode;
	}
	private static Node EmptyC(Node cE) {
		Node tempNode = new Node();
		tempNode.a = cE.a;
		tempNode.b = cE.b;
		tempNode.c = 0;
		return tempNode;
	}
	
	private static Node aTObTransfer(Node Ab) {
		Node t = new Node();
		t.a = Ab.a;
		t.b = Ab.b;
		t.c = Ab.c;
		if((t.a + t.b) > JugBcapacity) {
			t.a = (t.a + t.b) - JugBcapacity;
			Math.abs(t.a);
			
		}else if ((t.a + t.b) <= JugBcapacity){
			t.b = t.a + t.b;
			t.a = 0;
		}
		return t;
	}
	
	private static Node aTOcTransfer(Node Ac) {
		Node t = new Node();
		t.a = Ac.a;
		t.b = Ac.b;
		t.c = Ac.c;
		
		if((t.a + t.c)>JugCcapacity) {
			t.a  = (t.a + t.c) - JugCcapacity;
			Math.abs(t.a);
		}else if((t.a + t.c)<=JugCcapacity) {
			t.c = t.a + t.c;
			t.a = 0;
		}
		return t;
	}
	private static Node bTOaTransfer(Node Ba) {
		Node t = new Node();
		t.a = Ba.a;
		t.b = Ba.b;
		t.c = Ba.c;
		if((t.b + t.a)>JugAcapacity) {
			t.b  = (t.b + t.a) - JugAcapacity;
			Math.abs(t.b);
		}else if((t.b + t.a)<=JugAcapacity) {
			t.a = t.b + t.a;
			t.b = 0;
		}
		return t;
	}
	private static Node bTOcTransfer(Node Bc) {
		Node t = new Node();
		t.a = Bc.a;
		t.b = Bc.b;
		t.c = Bc.c;
		if((t.b + t.c)>JugCcapacity) {
			t.b  = (t.b + t.c) - JugCcapacity;
			Math.abs(t.b);
		}else if((t.b + t.c)<=JugAcapacity) {
			t.c = t.b + t.c;
			t.b = 0;
		}
		return t;
	}
	private static Node cTOaTransfer(Node Ca) {
		Node t = new Node();
		t.a = Ca.a;
		t.b = Ca.b;
		t.c = Ca.c;
		if((t.c + t.a)>JugAcapacity) {
			t.c  = (t.c + t.a) - JugAcapacity;
			Math.abs(t.c);
		}else if((t.c + t.a)<=JugAcapacity) {
			t.a = t.c + t.a;
			t.c = 0;
		}
		return t;
	}
	private static Node cTObTransfer(Node Cb) {
		Node t = new Node();
		t.a = Cb.a;
		t.b = Cb.b;
		t.c = Cb.c;
		if((t.c + t.b)>JugBcapacity) {
			t.c  = (t.c + t.b) - JugBcapacity;
			Math.abs(t.c);
		}else if((t.c + t.b)<=JugBcapacity) {
			t.b = t.c + t.b;
			t.c = 0;
		}
		return t;
	}
	
	public static boolean alreadyExists(Node node) {
		if(!StateExists.contains(node)) {
			stack.push(node);
			StateExists.add(node);
			count++;
			System.out.print(" returnTRUE" + jugA + jugB + jugC + count);
			
			return true;
		}
			return false;
			
		}

	
}