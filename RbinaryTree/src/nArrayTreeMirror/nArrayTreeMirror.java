package nArrayTreeMirror;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class nArrayTreeMirror {

   public static int count=0;
    public static void main(String[] args) {

        Node root=new Node(10);
//        root.children.add(new Node(2));
//        root.children.add(new Node(34));
//        root.children.add(new Node(56));
//        root.children.add(new Node(100));
//        root.children.get(2).children.add(new Node(1));
//        root.children.get(2).children.add(new Node(11));
//        root.children.get(3).children.add(new Node(7));
//        root.children.get(3).children.add(new Node(8));
//        root.children.get(3).children.add(new Node(9));
//        System.out.println("level order traveral");
//        printNodeLevelWise(root);
//        mirrorTree(root);
//        System.out.println("");
//        printNodeLevelWise(root);
//        System.out.println("");

         root.children.add(new Node(2));
        root.children.add(new Node(34));
        root.children.add(new Node(34));
        root.children.add(new Node(2));
        root.children.get(3).children.add(new Node(1));
        root.children.get(3).children.add(new Node(9));
        root.children.get(3).children.add(new Node(9));
        root.children.get(3).children.add(new Node(1));
        System.out.println(symmetric(root));
    }

    public static void printNodeLevelWise(Node root)
    {
        if(root==null)
            return;

        Queue<Node> q=new LinkedList<Node>();

        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            while(n>0)
            {
                Node t=q.remove();
                System.out.print(t.x + " ");
                for(Node d : t.children)
                {
                    q.add(d);
                }
                n--;
            }
            System.out.println();
        }


    }

    public static void mirrorTree(Node root)
    {
        if(root==null)
            return;
        
        for(Node d : root.children)
        {
            mirrorTree(d);
        }

        int i=0,j=root.children.size()-1;
        
        while(i<j)
        {
            Node t=root.children.get(i);
            root.children.set(i, root.children.get(j));
            root.children.set(j, t);
            i++;
            j--;
        }

       
    }




    public boolean checkSymmetry(Node root1, Node root2)
	    {
	        if (root1 == null && root2 == null)
	        {
	            return true;
	        }
	        else if (root1 == null || root2 == null)
	        {
	            return false;
	        }
	        else if (root1.x == root2.x)
	        {
	            int i = 0, j = root2.children.size() - 1;
	            while ((i < root1.children.size()) && (j >= 0))
	            {
	                if (!checkSymmetry(root1.children.get(i), root2.children.get(j)))
	                {
	                    break;
	                }
	                i++; j--;
	            }

	            if ((i < root1.children.size()) || (j >= 0))
	            {
	                return false;
	            }
	            else
	            {
	                return true;
	            }
	        }
	        return false;
	    }

    

    public static boolean symmetric(Node root)
    {
         if(root==null)
            return true;

        int n=root.children.size();
//        if(n<2)
//            return false;
        int i =0;

        

       for(int k=0;k<root.children.size();k++)
       {
           
           symmetric(root.children.get(k));
           
       }

        while(i<n)
        {
           // System.out.println("frst data  " + root.children.get(i).x);
           // System.out.println("secnd data " + root.children.get(n-1).x);
            if(root.children.get(i).x==root.children.get(n-1).x)
            {
                i++;
                n--;
            }
            else
            {
                count=1;
                break;
            }
        }
        
        if(count==0)
            return true;
        else
            return false;

        

    }



}
class Node
{
    int x;
    ArrayList<Node> children;

    public Node(int val)
    {
        this.x = val;
        children=new ArrayList<Node>();
    }





}


