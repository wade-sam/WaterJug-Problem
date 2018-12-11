package DFS;

public class Node {
	//jug names
	int A, B, C;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + A;
		result = prime * result + B;
		result = prime * result + C;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (A != other.A)
			return false;
		if (B != other.B)
			return false;
		if (C != other.C)
			return false;
		return true;
	}

	public Node(int A, int B, int C) {
		//storing them in the node 
		this.A = A;
		this.B = B;
		this.C = C;
	}
}
