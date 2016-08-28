
package codechef_pratice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SelfTried {

    public static void main(String[] args) throws IOException {
        String str;
        int yes = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        String eol = System.getProperty("line.separator");
        byte [] eolb = eol.getBytes();
        str  = br.readLine();
        int n = Integer.parseInt(str);
        int [] ages = new int[n];
        for(int i = 0 ; i < n ; i++) {
            str  = br.readLine();
            ages[i] = Integer.parseInt(str);
         }
        BinaryTree orig = new BinaryTree();
        	for(int i = 1 ; i < n ; i++) {
				str  = br.readLine();
				StringTokenizer st = new StringTokenizer(str," ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
                                    
				char c = st.nextToken().charAt(0);
//				if(c=='M') {
//					leftEdges[a] = b;
//					parent[b] = a;
//				} else {
//					rightEdges[a] = b;
//					parent[b] =a;
//				}
			}
    }

}

class BinaryTree{

    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // TODO:: 
//    public void insert(int x , int y, char c){
//
//        if(root==null)
//            root = new Node();
//
//        if(search(root, x))
//    }

    public Node search(Node r, int x){

       if(r==null)
           return null;
       
       if(r.value==x)
           return r;

       if(search(r.left, x)!=null)
           return r.left;
       else if(search(r.right, x)!=null){
           return r.right;
       }

       return null;
    }
    

}

class Node{
    int value;
    Node left;
    Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}