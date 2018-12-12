package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Application {
	
	private static Stack<Node> stack = new Stack<>(); 
	static ArrayList<Node> nodeComparison = new ArrayList<>();
	public static Set<Node> StateExists;
	public static int JugAcapacity;
	public static int JugBcapacity;
	public static int JugCcapacity;
	public static int jugA = 0;
	public static int jugB = 0;
	public static int jugC = 0;
	public static int count = 0;
	
	public static void UserInput() {
		Scanner UserInput = new Scanner(System.in);
		System.out.println("Please Input the Capacity for Jug A: ");
		JugAcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity fot Jug B: ");
		JugBcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity for Jug C: ");
		JugCcapacity = UserInput.nextInt();
	
	}
	
	public static void main(String args[]) {
		 
		UserInput();
		//System.out.println(JugAcapacity);
		//System.out.println(JugBcapacity);
		//System.out.println(JugCcapacity);
		
		Node node = new Node();
		//stack.push(node);
		waterJug(node);
		DisplayToUser();

		
		

		}
	static void waterJug(Node node) {
		stack.push(node);
		//node.visited=true;
		nodeComparison.clear();
		while(stack.size() > 0) {
			node = stack.pop();
			if(!WaterJug(node)) {
				nodeComparison.add(node);
				stack.push(fillUpA(node));
				stack.push(fillUpB(node));
				stack.push(fillUpC(node));
				stack.push(EmptyA(node));
				stack.push(EmptyB(node));
				stack.push(EmptyC(node));
				stack.push(aTObTransfer(node));
				stack.push(aTOcTransfer(node));
				stack.push(bTOaTransfer(node));
				stack.push(bTOcTransfer(node));
				stack.push(cTOaTransfer(node));
				stack.push(cTObTransfer(node));
				int count = nodeComparison.size();
				
			}
			
		}
		System.out.print(count);
	}
	
	public static void DisplayToUser() {
		for (int i=0;i< nodeComparison.size();i++) {
			Node count = nodeComparison.get(i);
			System.out.println(count.a + "," + count.b + "," + count.c);
			System.out.print(nodeComparison.size());
		}
	}
	private static Boolean WaterJug(Node node) {
        for (int i = 0; i<nodeComparison.size(); i++){
            if (nodeComparison.get(i).a == node.a && nodeComparison.get(i).b == node.b && nodeComparison.get(i).c == node.c){	
                return true;
            }
        } return false;
	}
	
	
	private static Node fillUpA(Node n){
        Node edited = new Node();
        edited.a = JugAcapacity;
        edited.b = n.b;
        edited.c = n.c;
        return edited;
    }
    private static Node fillUpB(Node n){
        Node edited = new Node();
        edited.a = n.a;
        edited.b = JugBcapacity;
        edited.c = n.c;
        return edited;
    }
    private static Node fillUpC(Node n){
        Node edited = new Node();
        edited.a = n.a;
        edited.b = n.b;
        edited.c = JugCcapacity;
        return edited;
    }
    private static Node EmptyA(Node n){
        Node edited = new Node();
        edited.a = 0;
        edited.b = n.b;
        edited.c = n.c;
        return edited;
    }
    private static Node EmptyB(Node n){
        Node edited = new Node();
        edited.a = n.a;
        edited.b = 0;
        edited.c = n.c;
        return edited;
    }
    private static Node EmptyC(Node n){
        Node edited = new Node();
        edited.a = n.a;
        edited.b = n.b;
        edited.c = 0;
        return edited;
    }
    private static Node aTObTransfer(Node n){
        Node edited = new Node();
        edited.b = n.b;
        edited.b += n.a;
        edited.c = n.c;
        checkFull(edited);
        edited.a = n.a - (edited.b - n.b);
        return edited;
    }
    private static Node aTOcTransfer(Node n){
        Node edited = new Node();
        edited.c = n.c;
        edited.c += n.a;
        edited.b = n.b;
        checkFull(edited);
        edited.a = n.a - (edited.c - n.c);
        return edited;
    }
    private static Node bTOaTransfer(Node n){
        Node edited = new Node();
        edited.a = n.a;
        edited.a += n.b;
        edited.c = n.c;
        checkFull(edited);
        edited.b = n.b - (edited.a - n.a);
        return edited;
    }
    private static Node bTOcTransfer(Node n){
        Node edited = new Node();
        edited.c = n.c;
        edited.c += n.b;
        edited.a = n.a;
        checkFull(edited);
        edited.b = n.b - (edited.c - n.c);
        return edited;
    }
    private static Node cTOaTransfer(Node n){
        Node edited = new Node();
        edited.b = n.b;
        edited.b += n.c;
        edited.a = n.a;
        checkFull(edited);
        edited.c = n.c - (edited.b - n.b);
        return edited;
    }
    private static Node cTObTransfer(Node n){
        Node edited = new Node();
        edited.a = n.a;
        edited.a += n.c;
        edited.b = n.b;
        checkFull(edited);
        edited.c = n.c - (edited.a - n.a);
        return edited;
    }
    //methods to move to the next node, where each one creates a new node "edited" with different value of A,B, or C and return it

    private static void checkFull(Node n){
        if (n.a > JugAcapacity){
            n.a = JugAcapacity;
        }
        if (n.b > JugBcapacity){
            n.b = JugBcapacity;
        }
        if (n.c > JugCcapacity){
            n.c = JugCcapacity;
        }
    }
	
}