

package codechef_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

public class Copied2 {
	
	static TreeSet<Integer> []hashesByAge = new TreeSet[101];

	public static class Node{
		int hash;
		int age;
		Node left=null;
		Node right=null;

		public Node(int age) {
			super();
			this.age = age;
		}

		public void updateHash(){
			int leftHashCode = left==null ? 0 : left.hash;
			int rightHashCode = right==null ? 0 : right.hash;
			hash = (leftHashCode*31+rightHashCode)*31+age;
		}

	}

	public static boolean hashMatchSubtree(Node root, Node toFind){
		TreeSet<Integer> hashes = hashesByAge[toFind.age];

		return hashes.contains(toFind.hash);
	}

	/**
	 * 5 - N chefs (nodes in tree1)
1  - age chef 1
2  - age chef 2
1
2
1  - age chef 5
1 2 M - 2 reports to 1 in the morning (i.e. 2 is a left child of 1)
1 3 E - 3 right child of 1
2 4 E - 4 right child of 2
3 5 M - 5 left child of 3
2 - queries (subtrees to match against)
2 - 2 chefs ( 2 nodes in the new query) (first query)
1 - age of chef 1
2
1 2 M -
2 - second query - 2 chefs
1
1
1 2 M
	 * @param reader
	 */
	public static void processTrees(BufferedReader reader) throws IOException{
		Node root = buildTree(reader, true);

		//System.out.println("Root tree built successfully");
		int Q= Integer.parseInt(reader.readLine());

		for (int i=0; i<Q; i++){
			Node subtree = buildTree(reader, false);
			boolean result = hashMatchSubtree(root, subtree);
			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");
			//System.out.println("Query Tree "+i+" built successfully");
		}

	}

	public static Node buildTree(BufferedReader reader, boolean main) throws IOException {
		int N = Integer.parseInt(reader.readLine());
		Node []nodes = new Node[N];

		for (int i=0; i<N; i++){
			int age = Byte.parseByte(reader.readLine());
			nodes[i] = new Node(age);
		}

		buildNodeInfo(reader, nodes, main);
		Node parentNode = nodes[0];
		parentNode.updateHash();//update the parent hash
		if (main){
			if (hashesByAge[parentNode.age]==null){
				hashesByAge[parentNode.age] = new TreeSet<Integer>();
			}
			hashesByAge[parentNode.age].add(parentNode.hash);
		}
		return parentNode;
	}

	private static void buildNodeInfo(BufferedReader reader, Node []nodes, boolean main) throws IOException {

		Stack<String[]> lines = buildLineStack(reader);

		while (!lines.isEmpty()){
			String []tokens = lines.pop();

			int P = Integer.parseInt(tokens[0]);
			int C = Integer.parseInt(tokens[1]);

			Node parent = nodes[P-1];
			Node child = nodes[C-1];

			child.updateHash();
			if (main){
				if (hashesByAge[nodes[C-1].age]==null){
					hashesByAge[nodes[C-1].age] = new TreeSet<Integer>();
				}
				hashesByAge[nodes[C-1].age].add(child.hash);
			}

			if (tokens[2].equals("M")){
				parent.left = child;
			}
			else{
				parent.right = child;
			}
		}
	}

	private static Stack<String[]> buildLineStack(BufferedReader reader) throws IOException {
		Stack<String[]> lines = new Stack<String[]>();
		while (true){
			reader.mark(20);
			String line = reader.readLine();
			if (line==null){
				break;
			}

			String []tokens = line.split(" ");
			if (tokens.length!=3){
				reader.reset();
				break;
			}

			lines.push(tokens);
		}
		return lines;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
			processTrees(bufReader);
			bufReader.close();

		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}


	/*private static boolean findNodeWithHash(Node root, int hashCode) {
		if (root==null){
			return false;
		}

		if (root.hash==hashCode){
			return true;
		}

		if (findNodeWithHash(root.left, hashCode)==true){
			return true;
		}

		return findNodeWithHash(root.right, hashCode);
	}

	public static boolean buildHashesBottomUpPartially(Node node, int toFind){
		if (node.left!=null){
			if (buildHashesBottomUpPartially(node.left, toFind)==true){
				return true;
			}
		}

		if (node.right!=null){
			if (buildHashesBottomUpPartially(node.right, toFind)==true){
				return true;
			}
		}

		node.updateHash();
		if (node.hash == toFind){
			return true;
		}

		return false;
	}

	public static void buildHashesBottomUp(Node node){
		if (node.left!=null){
			buildHashesBottomUp(node.left);
		}

		if (node.right!=null){
			buildHashesBottomUp(node.right);
		}

		node.updateHash();
	}

	public static boolean matchSubtreeRecursively(Node root, Node toFind){
		if (root == null){
			return false;
		}

		boolean res = matchTree(root, toFind);
		if (res == true){
			return res;
		}

		boolean leftResult = matchSubtreeRecursively(root.left, toFind);
		if (leftResult == true){
			return leftResult;
		}

		boolean rightResult = matchSubtreeRecursively(root.right, toFind);
		return rightResult;
	}

	private static boolean matchTree(Node root, Node toFind) {
		if (toFind==null && root==null){
			return true;
		}
		else if (toFind==null || root==null){
			return false;
		}

		if (root.age!=toFind.age){
			return false;
		}

		boolean res = matchTree(root.left, toFind.left);
		if (res==false){
			return false;
		}

		res = matchTree(root.right, toFind.right);
		return res;
	}*/

}