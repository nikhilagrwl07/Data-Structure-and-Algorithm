
package operationonbinarytree;

import java.util.Queue;
import java.util.Stack;      
import java.util.LinkedList;

public class OperationOnBinaryTree {

    public static void main(String[] args) {
    binarytree obj=new binarytree();
       obj.run();
       
    }
    public static class binarytree
    {
        int i=1,j=1,ht=0,l=0,r=0;
        Node root;
        
       public class Node
       {
         int data;
        Node right;
        Node left;            
        
        public Node(int x)   
        {
            this.data=x;
        }
           
         
       }
       public void run()
       {
           rootnode(10);
           insert(root,5);
           insert(root,4);
           insert(root,60);
           insert(root,1);
           insert(root,11);
           insert(root,13);
          // insert(root,-1);
           
           
         //  System.out.println("Iterative Inorder traversal----------");
           //iLevelOrder2(root);
           
           //System.out.println("Finding the maximum----------"+ findmax(root));
          // findmax_iterative(root);
           
           //Finding the size of binary tree
          // System.out.println("Size of Binary Tree(Recursive Approach)----------"+size(root));
          //  System.out.println("Size of Binary Tree(Iterative Approach)----------");
           // size_iterative(root);
           //root=null;
           // deletebinaryTree(root);
            
          // System.out.println("Iterative Inorder traversal----------");
           //iLevelOrder2(root);
           System.out.println("Height of the tree----------"+heightTree(root));
         //  System.out.println("Height of the tree----------"+heightTreeIterative(root));
       }
       
       public void rootnode(int x)
       {
            root=new Node(x);
         
       }
       
       public void insert(Node root,int x)
       {
        
             if(root.left==null)
             {
                root.left=new Node(x);
             }
                      
            else if(root.right==null)
            {               
                 root.right=new Node(x);
            }
             else
            {
                insert(root.left,x);
            }
       }
       
       public int findmax(Node root)
       {
           int l=0,r=0,max;
                   
           if(root.left!=null)
            l=findmax(root.left);
           
           if(root.right!=null)
            r=findmax(root.right);
           
           if(l>r)
               max=l;
           else
               max=r;
           
           if(root.data>max)
               max=root.data;
           
           return max;
           
       }
       
       public void findmax_iterative(Node root)
       {
            Stack s=new Stack();
            int max=0;
           
           while(true)
           {
               while(root!=null)
               {
                 //  System.out.println(root.data);
                   s.push(root);
                   
                   root=root.left;
                   
               }
              // System.out.println(root.data);               
               if(s.isEmpty())
               {
                  System.out.println("Itertaively maximum is : "+max);  
                   break;
               }
               
                root=(Node) s.pop();
                
                if(max<root.data)
                {
                    max=root.data;
                }
          
               root=root.right;
               
           }
          
       }
       
       public void rInOrder(Node root)
       {
           if(root!=null)
           {
               rInOrder(root.left);
               System.out.println(root.data);
               rInOrder(root.right);
           }
       }
       
      
       public void iInOrderStack(Node root)
       {
           Stack s=new Stack();
           
           while(true)
           {
               while(root!=null)
               {
                 //  System.out.println(root.data);
                   s.push(root);
                   
                   root=root.left;
                   
               }
              // System.out.println(root.data);               
               if(s.isEmpty())
                   break;
               
                root=(Node) s.pop();
              System.out.println(root.data);
               root=root.right;
               
           }
       }
       
       public void rpreOrder(Node root)
       {
           
           if(root!=null)
           {
                System.out.println(root.data);
             //   System.out.println("------->"+i); 
               // i++;
               rpreOrder(root.left);
               
               //System.out.println("<-------"+j); 
                //j++;
               rpreOrder(root.right);
           }
           else
               return ;
       }
       
       public void ipreOrder(Node root)
       {
           Stack s=new Stack();
           
           while(true)
           {
               while(root!=null)
               {
                   System.out.println(root.data);
                   s.push(root.right);
                   
                   root=root.left;
               }
               
               if(s.isEmpty())
                   break;
               
                root=(Node) s.pop();
            //  System.out.println(root.data);
       //         root=root.right;
               
           }
       }
       
       public void rpostOrder(Node root)
       {
           if(root!=null)
           {
               
               rpostOrder(root.left);
               rpostOrder(root.right);
                System.out.println(root.data);
           }
       }
       
       public void ipostOrder(Node root)
       {
           Stack s=new Stack();
           
           while(true)
           {
               while(root!=null)
               {
                 //  System.out.println(root.data);
                   s.push(root);
                   
                   root=root.left;
                   
               }
              // System.out.println(root.data);               
               if(s.isEmpty())
                   break;
               
                root=(Node) s.pop();
                 
           //   System.out.println(root.data);                
              if(root.right==null)
              {
                  System.out.println(root.data);
                  
                //  root=root.right;
              }   // This is for left most node
              
              else
              {   
              //System.out.println(root.data);
              root=root.right;
              System.out.println(root.data);
              }
               
              
           }
       }
       
       public int computeHeight(Node root)
       {
           if(root==null)
               return 0;
           else
           {
               int l=computeHeight(root.left);
               int r=computeHeight(root.right);
               if(l>r)
                   return l+1;
               else
                   return r+1;
           }
       }
       public void iLevelOrder(Node root,int ht)  // without using any explicit any data structure(Queue)
       {
           int i;
           for(i=1;i<=ht;i++)
               printGivenLevel(root,i);
       }
       //  level order traversal using queue
    
       public void printGivenLevel(Node root,int level)
       {
           if(root==null)
               return;
           if(level==1)
               System.out.println(root.data);
           else if(level>1)
           {
               printGivenLevel( root.left,level-1);
               printGivenLevel( root.right,level-1);
           }
       }
       public void iLevelOrder2(Node root)    // using 2 stack=1 queue as explicit data structure
       {
         
           Stack st1=new Stack();
           Stack st2=new Stack();
           
           if(root==null)
               return ;
           
           st1.push(root);
           
           while(true)
           {           
           while(!st1.isEmpty())
           {
               Node t=(Node) st1.pop();
               
               if(t.left!=null)
                 st2.push(t.left);
               
                if(t.right!=null)
                 st2.push(t.right);
                
               System.out.println(t.data);
              // System.out.println("Nikhil");
           }
           
           //Copy the content of st2 into st1
           while(!st2.isEmpty())
           {
               st1.push(st2.pop());
              // System.out.println("Nikhil");
           }
           
           if(st1.isEmpty())                          
               break;
           }
       
       }
       
       public int size(Node root)
       {
           if(root==null)
           return 0;
           
           return(size(root.left)+1+size(root.right));
       }
       
       public void size_iterative(Node root)
       {
           int size=0;
           Queue<Integer> q = new LinkedList<Integer>();
           q.add(root.data);
           
          
          
           while(!q.isEmpty())
           {
               q.remove();
               size++;
               
           }
           root=root.left;
           q.add(root.data);   
           
       }
       
       public void deletebinaryTree(Node root)
       {
           if(root==null)
               return;
           
                         
           if(root.left!=null)
               deletebinaryTree(root.left);
           
           if(root.right!=null)
               deletebinaryTree(root.right);
           
         root=null;
         
        // System.out.println("Value="+root.data);
         // Delete the children first and then delete the parent
       }
       
       public int heightTree(Node root)
       {
           if(root==null)
               return 0;
           
         //  if(root.left!=null)
           {               
               l=heightTree(root.left)+1;
           }
              
          // if(root.right!=null)
           {               
               r=heightTree(root.right)+1;
           }
           if(l>r)
               return l;
           else
               return r;
       }
       
       public int heightTreeIterative(Node root)
       {
           if(root==null)
               return 0;
           
           Stack s1=new Stack();
           Stack s2=new Stack();
           int ht=1;
           s1.push(root.data);
           
           while(true)
           {
               while(!s1.isEmpty())
               {
                  s2.push(s1.pop());
                  
               }
               ht++;
               if(root==null)
               {
                   return ht;
                  
               }
               
               root=(Node) s2.pop();
               s1.push(root.left);
               s1.push(root.right);
           }
           
       }
    }
}
