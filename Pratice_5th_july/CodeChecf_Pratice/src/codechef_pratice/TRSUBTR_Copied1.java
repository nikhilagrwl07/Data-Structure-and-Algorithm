

package codechef_pratice;

import codechef_pratice.TRSUBTR_Copied1.LinkNode;
import codechef_pratice.TRSUBTR_Copied1.Node;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TRSUBTR_Copied1 {

	public class LinkNode {
		char val;
		LinkNode next;
		LinkNode last;
		public LinkNode(char v) {
			val = v;
		}
	}

	public class Node {
		Node leftChild;
		Node rightChild;
		LinkNode ln;
		int index;
		public Node(int a) {
			index = a;
		}
	}

	static TRSUBTR_Copied1 main;

	static String originalString;

	static int[] table;

	public static void main(String [] args ) {
		long startTime = System.currentTimeMillis();
		main = new TRSUBTR_Copied1();
		try{
			String str;
			int yes = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedOutputStream bos = new BufferedOutputStream(System.out);
			String eol = System.getProperty("line.separator");
			byte [] eolb = eol.getBytes();
			str  = br.readLine();
			int n = Integer.parseInt(str);
			int [] leftEdges = new int[n];
			int [] rightEdges = new int[n];
			int [] parent = new int[n];
			int [] ages = new int[n];
			for(int i = 0 ; i < n ; i++) {
				str  = br.readLine();
				ages[i] = Integer.parseInt(str);
				leftEdges[i] = -1;
				rightEdges[i] = -1;
				parent[i] = -1;
			}

			for(int i = 1 ; i < n ; i++) {
				str  = br.readLine();
				StringTokenizer st = new StringTokenizer(str," ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				char c = st.nextToken().charAt(0);
				if(c=='M') {
					leftEdges[a] = b;
					parent[b] = a;
				} else {
					rightEdges[a] = b;
					parent[b] =a;
				}
			}
			originalString = createString(n,leftEdges,rightEdges,parent,ages);
			str  = br.readLine();
			int q = Integer.parseInt(str);
			for(int p = 0 ; p < q ; p++) {
				str  = br.readLine();
				int m = Integer.parseInt(str);
				int [] qleftEdges = new int[m];
				int [] qrightEdges = new int[m];
				int [] qparent = new int[m];
				int [] qages = new int[m];
				for(int i = 0 ; i < m ; i++) {
					str  = br.readLine();
					qages[i] = Integer.parseInt(str);
					qleftEdges[i] = -1;
					qrightEdges[i] = -1;
					qparent[i] = -1;
				}
				for(int i = 1 ; i < m ; i++) {
					str  = br.readLine();
					StringTokenizer st = new StringTokenizer(str," ");
					int a = Integer.parseInt(st.nextToken()) - 1;
					int b = Integer.parseInt(st.nextToken()) - 1;
					char c = st.nextToken().charAt(0);
					if(c=='M') {
						qleftEdges[a] = b;
						qparent[b] = a;
					} else {
						qrightEdges[a] = b;
						qparent[b] = a;
					}
				}
				String queryString = createString(m,qleftEdges,qrightEdges,qparent,qages);
				preprocess(queryString);
				boolean ans = find(queryString);
				if(ans) {
					bos.write("YES".getBytes());
					yes++;
				} else {
					bos.write("NO".getBytes());
				}
				bos.write(eolb);
			}
			bos.flush();
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		//System.err.println("time = " + (endTime-startTime));
	}

	public static String createString(int numNodes , int [] left , int [] right ,int [] parent,int [] ages) {
		StringBuilder ans = new StringBuilder("");
		int root = 0;
		for(int i = 0 ; i < numNodes ;i++) {
			if(parent[i]==-1) {
				root = i;
				break;
			}
		}
		ArrayList<ArrayList<Node>> heightHash = new ArrayList<ArrayList<Node>>();
		Node rootNode = main.new Node(root);
		ArrayList<Node> expand = new ArrayList<Node>();
		expand.add(rootNode);
		while(expand.size()>0) {
			heightHash.add(expand);
			ArrayList<Node> newExpand = new ArrayList<Node>();
			for(int i = 0 ; i < expand.size() ; i++) {
				Node currentNode = expand.get(i);
				int val = currentNode.index;
				int lc = left[val];
				if(lc!=-1) {
					Node newNode = main.new Node(lc);
					currentNode.leftChild = newNode;
					newExpand.add(newNode);
				}
				int rc = right[val];
				if(rc!=-1) {
					Node newNode = main.new Node(rc);
					currentNode.rightChild = newNode;
					newExpand.add(newNode);
				}
			}
			expand = newExpand;
		}
		for(int i = heightHash.size()-1 ; i>=0 ; i--) {
			ArrayList<Node> list = heightHash.get(i);
			for(int j = 0 ; j < list.size() ; j++) {
				Node current = list.get(j);
				char c1 = 'z';
				char c2 = 'z';
				LinkNode cln = main.new LinkNode((char)ages[current.index]);
				cln.last = cln;
				LinkNode ln1 = main.new LinkNode(c1);
				ln1.last = ln1;
				LinkNode ln2 = main.new LinkNode(c2);
				ln2.last = ln2;
				if(current.leftChild!=null) {
					ln1 = current.leftChild.ln;
				}
				if(current.rightChild!=null) {
					ln2 = current.rightChild.ln;
				}
				ln1.last.next = ln2;
				ln2.last.next = cln;
				current.ln = ln1;
				current.ln.last = cln;
			}
		}
		LinkNode link = rootNode.ln;
		while(link!=null) {
			ans.append( link.val);
			link = link.next;
		}
		return ans.toString();
	}

	public static void preprocess(String os) {
		int pos = 2;
		int cnd = 0;
		table = new int[os.length()];
		table[0] = -1;
		table[1] = 0;
		while(pos<os.length()) {
			if(os.charAt(cnd)==os.charAt(pos-1)) {
				cnd++;
				table[pos] = cnd;
				pos++;
			} else if (cnd>0) {
				cnd = table[cnd];
			} else {
				table[pos] = 0;
				pos++;
			}
		}
	}

	public static boolean find (String query) {
		int m = 0;
		int i = 0;
		while(m+i<originalString.length()) {
			if(query.charAt(i)==originalString.charAt(m+i)) {
				if(i==query.length()-1) {
					return true;
				}
				i++;
			} else {
				m = m + i - table[i];
				if(table[i]>-1) {
					i = table[i];
				} else {
					i = 0;
				}
			}
		}
		return false;
	}
}

