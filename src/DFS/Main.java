package DFS;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
public class Main {
	
	//initialise the stack of type Node
	private static Stack<Node> stack = new Stack<>(); 
	//holds the output of the stack when called.
	static ArrayList<Node> nodeComparison = new ArrayList<>();
	//initialising the set to check whether states have been found
	public static Set<Node> StateExists;
	
	//defining the maximum capacity of the jugs 
	public static int JugAcapacity;
	public static int JugBcapacity;
	public static int JugCcapacity;
	public static int whichFullJug;//if it equals 1 then it updates jugA, equals 2 then updates jugB and if equals c then updates jugC
	public static int whichEmptyJug;//if it equals 1 then it updates jugA, equals 2 then updates jugB and if equals c then updates jugC
	public static int WhichSwitchJug;//the result will be between 1 and 6 and will correspond to the switch which occurs in the WhichSwitchJug function
	

	public static void main(String args[]) {
		 
		@SuppressWarnings("resource")
		Scanner UserInput = new Scanner(System.in);
		System.out.println("Please Input the Capacity for Jug A: ");//getting input from the user and storing it in Jug*Capacity variables
		//validating the user input
		while (!UserInput.hasNextInt()) {
			UserInput.next();
		}; 
		JugAcapacity = UserInput.nextInt();
		System.out.println("Please Input the capacity fot Jug B: ");
		while (!UserInput.hasNextInt()) {
			UserInput.next();
		}; 
		JugBcapacity = UserInput.nextInt(); 
		System.out.println("Please Input the capacity for Jug C: ");
		while (!UserInput.hasNextInt()) {
			UserInput.next();
		}; 
		JugCcapacity = UserInput.nextInt();
		//adding root node. 
		Node node = new Node();
		node.a = 0;
		node.b = 0;
		node.c = 0;
		waterJug(node);
		}
	static void waterJug(Node node) {
		stack.push(node);//adding node to the stack
		StateExists = new HashSet<>();
		
		while(stack.size() !=0) {//while the size of stack is above 0
			node = stack.pop();//removes the nodes that have already been searched
			if(check(node)!=true) {
				StateExists.add(node);
				//fillingJugs and calling the fillJugs function
					if (node.a!=JugAcapacity) {
						whichFullJug = 1;
						fillJugs(node);
					}
					if (node.b!=JugBcapacity) {
						whichFullJug = 2;
						fillJugs(node);
					}
					if (node.c!=JugCcapacity) {
						whichFullJug = 3;
						fillJugs(node);
					}
					//checking to see if any jugs are empty and calling the whichEmptyJug function 
					if (node.a != 0) {
						whichEmptyJug = 1;
						emptyJugs(node);
					}
					if (node.b != 0) {
						whichEmptyJug = 2;
						emptyJugs(node);
					}
					if (node.c != 0) {
						whichEmptyJug = 3;
						emptyJugs(node);
					}
					//checking to see which jugs can be switched and calling the whichSwitchJug function 
					if (node.a != 0 && node.b != JugBcapacity) {
						WhichSwitchJug = 1;
						switchJugs(node);
					}
					if(node.a != 0 && node.c != JugCcapacity) {
						WhichSwitchJug = 2;
						switchJugs(node);
					}
					if(node.b != 0 && node.a != JugAcapacity) {
						WhichSwitchJug = 3;
						switchJugs(node);
					}
					if(node.b != 0 && node.c != JugCcapacity) {
						WhichSwitchJug = 4;
						switchJugs(node);
					}
					if(node.c != 0 && node.a != JugAcapacity) {
						WhichSwitchJug = 5;
						switchJugs(node);
					}
					if(node.c != 0 && node.b != JugBcapacity) {
						WhichSwitchJug = 6;
						switchJugs(node);
					}
					
			}
			
		}//storing the node states into the arraylist
		for(Node Exists:StateExists) {
			 nodeComparison.add(Exists) ;
		}
		
		System.out.print("Number of States: "+ StateExists.size() + nodeComparison );
	}
	//iterative DFS approach. returns a boolean. checking whether any new found states are already in theStateExists set
	private static Boolean check(Node node) {
            if (StateExists.contains(node)){	
                return true;
            }
         return false;
	}
    //this function uses the WhichJug variable to see which jug needs to be filled and then runs and checks the nodes before updating to the stack
    private static Node fillJugs(Node n) {
    	Node edited = new Node();
    	if (whichFullJug ==1) {
    		edited.a = JugAcapacity;
            edited.b = n.b;
            edited.c = n.c;
            stack.push(edited);
    	}
    	else if(whichFullJug ==2) {
            edited.a = n.a;
            edited.b = JugBcapacity;
            edited.c = n.c;
            stack.push(edited);
          
    	}
    	else if (whichFullJug == 3) {
            edited.a = n.a;
            edited.b = n.b;
            edited.c = JugCcapacity;
            stack.push(edited);
            
    	}
    	return edited;
    }
  //this function uses the WhichEmptyJug variable to see which jug needs to be emptied and then runs and checks the nodes before updating to the stack
    public static Node emptyJugs(Node n) {
    	Node edited = new Node();
    	if (whichEmptyJug == 1) {
            edited.a = 0;
            edited.b = n.b;
            edited.c = n.c;
            stack.push(edited);
    	}
    	else if (whichEmptyJug == 2) {
            edited.a = n.a;
            edited.b = 0;
            edited.c = n.c;
            stack.push(edited);
    	}
    	else if (whichEmptyJug == 3) {
            edited.a = n.a;
            edited.b = n.b;
            edited.c = 0;
            stack.push(edited);
    	}
    	return edited;
    	
    }
  //this function uses the WhichSwitchJug variable to see which jugs can be switched and then runs and checks the nodes before updating to the stack
    public static Node switchJugs (Node find) {
    	Node t = new Node();
    	if (WhichSwitchJug == 1) {
            t.b = find.b;
            t.b += find.a;
            t.c = find.c;
            isTheNodeFull(t);//calls checkFull method
            t.a = find.a - (t.b - find.b);
            stack.push(t);
    	}
    	else if (WhichSwitchJug == 2) {
            t.c = find.c;
            t.c += find.a;
            t.b = find.b;
            isTheNodeFull(t);
            t.a = find.a - (t.c - find.c);
            stack.push(t);
    	}
    	else if (WhichSwitchJug == 3) {
            t.a = find.a;
            t.a += find.b;
            t.c = find.c;
            isTheNodeFull(t);
            t.b = find.b - (t.a - find.a);
            stack.push(t);
    	}
    	else if (WhichSwitchJug == 4) {
            t.c = find.c;
            t.c += find.b;
            t.a = find.a;
            isTheNodeFull(t);
            t.b = find.b - (t.c - find.c);
            stack.push(t);
    	}
    	else if (WhichSwitchJug == 5) {
            t.a = find.a;
            t.a += find.c;
            t.b = find.b;
            isTheNodeFull(t);
            t.c = find.c - (t.a - find.a);
            stack.push(t);
    	}
    	else if (WhichSwitchJug == 6) {
            t.b = find.b;
            t.b += find.c;
            t.a = find.a;
            isTheNodeFull(t);
            t.c = find.c - (t.b - find.b);
            stack.push(t);
    	}
    	return t;
    }
    
    private static void isTheNodeFull(Node check){
        if (check.a > JugAcapacity){//if a is larger than the capacity of A then a equals the capacity of A
        	check.a = JugAcapacity;
        }
        if (check.b > JugBcapacity){
            check.b = JugBcapacity;
        }
        if (check.c > JugCcapacity){
            check.c = JugCcapacity;
        }
    }

}