

package BinaryTreeToSumBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author nikhil.agrawal
 */
public class BinaryTreeToSumBinaryTree {

    public static void main(String[] args) {
        Node root=new Node(10);
       Node temp2=new Node(-2);
       Node temp4=new Node(8);
        Node temp6=new Node(7);
           Node temp7=new Node(5);
      
                  Node temp3=new Node(6);  
         Node temp5=new Node(-4);
         Node templast = new Node(3);
         
         root.left=temp2;
         root.right=temp3;
         temp2.left=temp4;
         temp2.right=temp5;
         temp3.left=temp6;
         temp3.right=temp7;
         temp4.left=templast;
//         rInOrder(root);
         iLevelOrder(root);
//         convertBinaryTreeToSumTree(root);
//         System.out.println("==============");
//         iLevelOrder(root);
           //Node temp8=new Node(8);     
//         Node temp9=new Node(9); 
//        SpiralLevelOrderTraversal(root);
         multiplicationOfSumOfEachLevel(root);
         
         
    }
    
    
    public static void convertBinaryTreeToSumTree(Node root)
    {
        if(root==null || (root.left==null && root.right==null)) return;
        
        
        Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            
            Node r = q.remove();
            
//            System.out.println("r= " + r.value + " left = " + root.left.value + " right = " + root.right.value);
            int sum =0;
            if(r.left!=null)
            {
                sum = sum + r.left.value;
                q.add(r.left);
            }
            if(r.right!=null)
            {
                sum = sum + r.right.value;
                q.add(r.right);
            }
            
            if(r.left==null && r.right==null)
            {
                sum=0;
            }
//            System.out.println("r= " + r.value + " value = " + sum);
            r.value=sum;
            
        }
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            
            Node r = q.remove();
            
//            System.out.println("r= " + r.value + " left = " + root.left.value + " right = " + root.right.value);
            int sum =r.value;
            if(r.left!=null)
            {
                sum = sum + r.left.value;
                q.add(r.left);
            }
            if(r.right!=null)
            {
                sum = sum + r.right.value;
                q.add(r.right);
            }
            
//            if(r.left==null && r.right==null)
//            {
//                sum=0;
//            }
//            System.out.println("r= " + r.value + " value = " + sum);
            r.value=sum;
            
        }
        
        
        
    }
    
    
    public static void rInOrder(Node r)
    {
        if(r!=null)
        {
            rInOrder(r.left);
            System.out.println(r.value);
            rInOrder(r.right);
        }
    }
    
    
    public static void iLevelOrder(Node root)
    {
        
        Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            
            Node r = q.remove();
            
            if(r.left!=null)
            {
//                sum = sum + root.left.value;
                q.add(r.left);
            }
            if(r.right!=null)
            {
//                sum = sum + root.right.value;
                q.add(r.right);
            }
            
            System.out.print(" " + r.value);
        }
        System.out.println("");
        
    }
    
    
    public static void SpiralLevelOrderTraversal(Node r)
    {
        
        if(r==null) return;
        
        if(r.left==null && r.right==null)
        {
            System.out.print(r.value + " ");
            return;
        }
        
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        
        s1.push(r);
        
        while(true)
        {
            
            while(!s1.isEmpty())
            {
                Node t= s1.pop();
                System.out.print(t.value  + " ");
                
                if(t.right!=null) s2.push(t.right);
                if(t.left!=null) s2.push(t.left);
                
            }
            
            while(!s2.isEmpty())
            {
                Node t= s2.pop();
                System.out.print(t.value  + " ");
                
                if(t.left!=null) s1.push(t.left);
                if(t.right!=null) s1.push(t.right);
            }
            
            if(s1.isEmpty() && s2.isEmpty()) break;
        }
        
                
    }
    
    
    static void multiplicationOfSumOfEachLevel(Node r)
    {
        if(r==null) return ;
        if(r.left==null && r.right==null) {
             System.out.println("multiplicationOfSumOfEachLevel :: " + r.value);
            return;
        }
        
        
        int ans =1;
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(r);
        q.add(null);
        int sum =0;
        
        while(!q.isEmpty())
        {
            Node t = q.remove();
           
            if(t==null)
            {
                    if(q.isEmpty())
                    {
                         if(sum!=0)
                         {
                            ans *=sum;
                         }
                        break;
                    }
                    
                   q.add(null);
                   System.out.println("ans :: " + ans + " sum :: " + sum);
                   if(sum!=0)
                    {
                       
                     ans *=sum;
                     sum=0;
                    }
//                   sum=0;  
                
            }
            else
            {
//                System.out.println("t.data = " + t.value);
                if(t.left==null && t.right==null)
                {
                    
                    sum +=t.value;
                    System.out.println("sum = " + sum);
                }
                if(t.left!=null)
                {
                    q.add(t.left);
                }
                if(t.right!=null)
                {
                    q.add(t.right);
                }
            }
            
        }
        
        System.out.println("multiplicationOfSumOfEachLevel :: " + ans);
        
    }

}

class Node
{
    int value;
    Node left;
    Node right;
    public Node(int v)
    {
        this.value=v;
    }
    public void setleft(Node l)
    {
        this.left=l;
    }
    
    public void setright(Node r)
    {
        this.right=r;
    }
    
    public Node getleft(Node t)
    {
        return t.left;
    }
    
    public Node getright(Node t)
    {
        return t.right;
    }
    
}
