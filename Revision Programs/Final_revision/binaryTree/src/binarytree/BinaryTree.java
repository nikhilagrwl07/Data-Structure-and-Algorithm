
package binarytree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
       binarytree obj=new binarytree();
       obj.run();
       
    }
    public static class binarytree
    {
        int i=1,j=1,ht=1,n=0,d=0;
        int max=-1;
        Node root,l,r,deepest;
        
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
          // rootnode(10);
           insert(root,1);
           insert(root,2);
           insert(root,3);
           insert(root,4);
           insert(root,5);
           insert(root,6);
           insert(root,7);
          //  insert(root,33);
                      
           //Recursive version
            System.out.println("Recursive Inorder traversal----------");
             rInOrder(root);
           
            // System.out.println(" Iterative Inorder traversal----------");
              //   iInOrder(root);
         
         // System.out.println(" Recursive Preorder traversal----------");
          // rpreOrder(root);
           
          // System.out.println(" Iterative Preorder traversal----------");
          // ipreOrder(root);
          
               
         // System.out.println("Iterative levelorder traversal----------"); 
          //iLevelOrder2(root,);
           
         
        // System.out.println("Recursive postorder traversal----------");
          //rpostOrder(root);
            
           
     //   System.out.println(" Iterative Levelorder traversal W/O using DS----------");
       //    int ht=computeHeight(root);
        //  iLevelOrder(root,ht);
           
           
           int startlen=0,sum=14;
           
           int inOrder[]={4,2,5,1,6,3,7};
           int preOrder[]={1,2,4,5,3,6,7};
           int inStrt=0;
           int inEnd=inOrder.length-1;
           
        //   System.out.println("Recursive Inorder traversal----------");
      //        rInOrder(buildBT(inOrder,preOrder,inStrt,inEnd));
           
           Node node=new Node(7);
        
           
          // boolean v=printAncestors(root,node);
              
       //  paths(root, startlen);
         // System.out.println();
          
         // System.out.println(hasSum(root,sum));
      
           System.out.println("Diameter (in same recursion) ="+Diameter(root,d));
           
           
        // numberOfLeaf(root);
        //  numberOfFull(root);
        //  numberOfHalf(root);
        
          
       //   iComputeHeight(root);
      //System.out.println(" Iterative Reverse Levelorder traversal-");
        // iLevelOrderReverse(root);
         // System.out.println("Size of BT="+rSizeBT(root));
               
         // iSizeBT(root);
        //   printMaximum();
           
   //       System.out.println(" Iterative Levelorder traversal using 2 Stack----------");
     //      iLevelOrder2(root);
         //  * 
           //*/
           
         //  System.out.println("Maximum Element ="+findMaxElement(root));
           
          /*    int p=searchElement(root,6);
              if(p==1)
                  System.out.println("Element found");
              else
                  System.out.println("Element NOT found");
                  * 
                  */
       }
       
       
   /*    public void rootnode(int x)
       {
            root=new Node(x);
            root.left=null;
            root.right=null;
         
       }
       * 
       */
       
        public void insert(Node p,int x)
        {
            Queue<Node> queue = new LinkedList<Node>();
            
            if(p == null)
            {
                root=new Node(x);
                root.left=null;
                root.right=null;
                return ;
            }
            
           queue.add(root);
            
           
           while(!queue.isEmpty())
           {
               Node t=queue.remove();
               
               if(t.left==null)
               {
                   t.left=new Node(x);
                   
                //  t.left.left=null;
                 //  t.left.right=null;
                   queue.clear();
                   return;
               }
               else
               {
                   queue.add(t.left);
               }
               
               if(t.right==null)
               {
                     t.right=new Node(x);
                   
                 // t.right.left=null;
                  // t.right.right=null;
                   queue.clear();
                   return;
               }
               else
               {
                   queue.add(t.right);
               }
               
               
           }
            
            
        }
       
     /*  This code is for BST  
      * 
      * public void insert(Node root,int x)
       {
         // System.out.print("      Root Node="+root.data);
           
           
      if(x<=root.data)    
      {
          if (root.left != null && root.right == null) 
        {
         insert(root.left, x);
        
        } 
      
         else {
              
            root.left = new Node(x);
        
            }
      }
      
      else if(x>root.data)
      {
      if (root.right != null ) 
      {
          insert(root.right, x); 
        
        
      }
      
      else {
                root.right = new Node(x);
      }
    
           
      }             
       }
       */
       public void rInOrder(Node root)
       {
           if(root!=null)
           {
               rInOrder(root.left);
               
               System.out.print(root.data+" ");
               
               if(max<root.data)
                   max=root.data;
               
               rInOrder(root.right);
           }
           else
               return ;
           
       }
       
       public void iInOrder(Node root)
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
                
                if(root.data>max)
                    max=root.data;
                
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
             
           return(1+Math.max(computeHeight(root.left),computeHeight(root.right)));
           
     }
       
       public void iComputeHeight(Node root)
       {
           Queue<Node> q=new LinkedList<Node>();
           
           Node nullNode=null;
           
           int ht=0;
           if(root==null)
               System.out.println("Height="+ht);
           
           q.add(root);
           q.add(nullNode);
           
           while(!q.isEmpty())
           {
               Node t=q.remove();
               
               if(t!=null)
               {
                   if(t.left!=null)
                       q.add(t.left);
                   
                   if(t.right!=null)
                       q.add(t.right);
             
               }
               
               else    // t is NULL
               {
                   if(!q.isEmpty())
                      q.add(nullNode);
                  
                   ht++;
                   
               }
             
           }
           
           System.out.println("Iterative Height="+ht);
       }
       public void iLevelOrder(Node root,int ht)  // without using any explicit any data structure(Queue)
       {
           int i;
           for(i=1;i<=ht;i++)
               printGivenLevel(root,i);
       }

       public void printMaximum()
       {
           System.out.println("Maximum element ="+max);
       }
    
       public void printGivenLevel(Node root,int level)
       { 
           if(root==null)
               return;
           if(level==1)
           {
               if(max<root.data)
                   max=root.data;
               
               System.out.println(root.data);
               
           }
           else if(level>1)
           {
               printGivenLevel( root.left,level-1);
               printGivenLevel( root.right,level-1);
           }
       }
       public void iLevelOrder2(Node root)    // using 2 stack as explicit data structure
       {
         
           Stack st1=new Stack();
           Stack st2=new Stack();
           
           if(root==null)
               return ;
           
           st1.push(root);
           
           while(!st1.isEmpty())
           {           
           while(!st1.isEmpty())
           {
               Node temp=(Node) st1.pop();
               
               if(temp.left!=null)
                 st2.push(temp.left);
               
                if(temp.right!=null)
                 st2.push(temp.right);
                
               System.out.println(temp.data);
              // System.out.println("Nikhil");
           }
           
           //Copy the content of st2 into st1
           while(!st2.isEmpty())
           {
               st1.push(st2.pop());
              // System.out.println("Nikhil");
           }
           
           }
       
       }
       
       public int findMaxElement(Node root)
       {
           int maxVal=-1;
           
           if(root!=null)
           {
           int l=findMaxElement(root.left);
           int r=findMaxElement(root.right);
           
           if(l>r)
               max=l;
           else
               max=r;
           
             if(max>root.data)
                   return max;
             else
            {
                   max=root.data;
                   return max;
            }
           }           
        return -1;   
       }
       
       public int searchElement(Node root, int x)
       {
           int l=-1,r=-1;
           
           if(root!=null)
           {             
               
               if(root.data==x)
                   return 1;
                             
                l=searchElement(root.left, x);
               
               if(l==1)
                   return 1;
               else
                 r=searchElement(root.right,x);
               
               if(r==1)  
                   return 1;
               else
                    return 0;
           }
           else
               return 0;
           
       }
       
       // recursive Version
       public int rSizeBT(Node n)
       {
           if(n==null)  return 0;
           
           return (1+rSizeBT(n.left)+rSizeBT(n.right));
       }
       
       public void iSizeBT(Node n)
       {
           Queue<Node> queue=new LinkedList<Node>();
           int size=0;
           if(n==null)
               System.out.println("Size of BT= "+size);
           
           queue.add(n);
           size++;
           
           while(!queue.isEmpty())
           {
               Node t=queue.remove();
               if(t.left !=null)
               {
                   queue.add(t.left);
                   size++;
               }
               
               if(t.right!=null)
               {
                   queue.add(t.right);
                           size++;
               }
           }
           queue.clear();
                   System.out.println("Size of BT= "+size);
       }
       
      public void iLevelOrderReverse(Node n)
       {
           Stack<Node> s=new Stack<Node>();
           Stack<Node> s2=new Stack<Node>();
           if(n==null)
               System.out.println("Size of BT= 0");
           
           s.push(n);           //       add(n);
           
           
           while(!s.isEmpty())
           {
               Node t=s.pop();
               s2.push(t);
              
               if(t.left !=null)
               {
                   s.push(t.left);
                  
               }
               
                if(t.right!=null)
               {
                   s.push(t.right);
                           
               }
               
           }
        while(!s2.isEmpty())
            System.out.print(s2.pop().data+"  ");
       }
    
      public void depestNode(Node root)
      {
        
          Queue<Node> q=new LinkedList<Node>();
          if(root!=null)
              q.add(root);
          
          while(!q.isEmpty())
          {
                root=q.remove();
              
                if(root.left!=null)
                    q.add(root.left);
                
                if(root.right!=null)
                    q.add(root.right);
                
                
          }
          
          System.out.println("Last Node ="+root.data);
      }
      
      int path[]=new int[20];
     // int pathLen=0;
      
      public void paths(Node root, int pathLen)
      {
          if(root==null)
              return ;
          
          path[pathLen]=root.data;
          pathLen++;
          
          if(root.left==null && root.right==null)
              printpath(pathLen);
          
          paths(root.left,pathLen);
          paths(root.right,pathLen);
          
      }
      
      public void printpath(int len)
      {
          for(int i=0;i<len;i++)
          {
              System.out.print(path[i]+"   ");
          }
          
          System.out.println();
      }
              
       public boolean hasSum(Node root,int s)
       {
           if(root==null)
               return (s==0);
           
           s=s-root.data;
           
           return(hasSum(root.left,s) || hasSum(root.right,s));
       }
        
    static int preIndex=0;   
    
   public Node buildBT(int inOrder[],int preOrder[],int inStrt,int inEnd)
   {
         Node newNode=new Node(preOrder[preIndex]);
          
         if(inStrt>inEnd)  
             return null;
         
         
         if(newNode==null)
         {
             System.out.println("Memory Problem");
             return null;
         }
         
        
        preIndex++;
        if(inStrt==inEnd) return newNode;
        
        int i,inIndex=0;
        
        for(i=0;i<inOrder.length;i++)
        {
            if(inOrder[i]==newNode.data)
               inIndex=i;
                
        }
        
        newNode.left=buildBT(inOrder,preOrder,inStrt,inIndex-1);
        newNode.right=buildBT(inOrder,preOrder,inIndex+1,inEnd);
        
        return newNode;
   }
       
       
  public boolean printAncestors(Node root, Node node) 
  {
     // System.out.println(root.data);
      
      if(root==null) return false;

      if(root.left!=null && root.right!=null)
      {
         if(root.left.data==node.data || root.right.data==node.data || printAncestors(root.left,node) || printAncestors(root.right,node))
         { 
              System.out.println(root.data);
      
                 return true;
        }
      }
      
     else if(root.left!=null && root.right ==null)
      {
         if(root.left.data==node.data || printAncestors(root.left,node) || printAncestors(root.right,node))
         { 
              System.out.println(root.data);
      
                 return true;
        }
      }
      
      else if(root.left==null && root.right !=null)
      {
         if(root.right.data==node.data || printAncestors(root.left,node) || printAncestors(root.right,node))
         { 
              System.out.println(root.data);
      
                 return true;
        }
      }
      
      return false;
      
  }
  
 /*      
  public Node LCA(Node root,Node n1,Node n2)
  {
      Node left,right;
      if(root==null)
          return root;
      
      if(root.data==n1.data || root.data==n2.data)
          return root;
      
      left=LCA(root.left,n1,n2);
      right=LCA(root.right,n1,n2);
      
      if(left.data!=null && right.data!=null)
          return root;
      else
          return(left?left:right);
      
  }
       
  */
  
  public int Diameter(Node root, int h)
      {
          int lheight=0,rheight=0;
          
            int ldiameter=0,rdiameter=0;
            
          if(root==null)
          {
              h=0;
              return 0;
          }
          
          ldiameter=Diameter(root.left,lheight);
          rdiameter=Diameter(root.right,rheight);
          
        h=Math.max(lheight,rheight)+1;
         
       
          if(ldiameter>rdiameter)
            return Math.max(lheight + rheight + 1,ldiameter);  
          else
              return Math.max(lheight + rheight + 1,rdiameter);
     
          
      }
      
   
      public int Diameter2(Node root)
      {
            int lt,rt;
          if(root==null)
              return 0;
          
          lt=Diameter2(root.left);
          rt=Diameter2(root.right);
          
          int leftHeight = computeHeight(root.left);
            int rightHeight = computeHeight(root.right);
       
          
          return Math.max(leftHeight + rightHeight + 1,Math.max(lt, rt));  
     
          
      }
    
    
      public void numberOfLeaf(Node root)
      {
       Queue<Node> q=new LinkedList<Node>();
       
       if(root==null)
       {
           System.out.println(n);
            return;
       }
       
       q.add(root);
       
       while(!q.isEmpty())
       {
           root=q.remove();
           if(root.left!=null && root.right==null)
           {
               ++n;
               q.add(root.left);
           }
           
           else if(root.left==null && root.right !=null)
           {
               ++n;
               q.add(root.right);
           }
           
           else if(root.left==null && root.right ==null)
           {
               ++n;
           }
           else
           {
               q.add(root.left);
                q.add(root.right);
           }
       }
       
        System.out.println("Total number of leaf nodes="+n);
       
      }
    
   public void numberOfFull(Node root)
   {
       Queue<Node> q=new LinkedList<Node>();
       
       if(root==null)
       {
           System.out.println(n);
            return;
       }
       
       q.add(root);
       
       while(!q.isEmpty())
       {
           root=q.remove();
           if(root.left!=null && root.right==null)
           {
               q.add(root.left);
           }
           
           else if(root.left==null && root.right !=null)
           {
             
               q.add(root.right);
           }
           
           else if(root.left==null && root.right ==null)
           {
               
           }
           else
           {
               q.add(root.left);
                q.add(root.right);
                  ++n;
           }
       }
       
        System.out.println("Total number of Full nodes="+n);
       
   }
   
   
    public void numberOfHalf(Node root)
   {
       Queue<Node> q=new LinkedList<Node>();
       
       if(root==null)
       {
           System.out.println(n);
            return;
       }
       
       q.add(root);
       
       while(!q.isEmpty())
       {
           root=q.remove();
           if(root.left!=null && root.right==null)
           {
                ++n;
               q.add(root.left);
           }
           
           else if(root.left==null && root.right !=null)
           {
              ++n;
               q.add(root.right);
           }
           
           else if(root.left==null && root.right ==null)
           {
               
           }
           else
           {
               q.add(root.left);
                q.add(root.right);
                 
           }
       }
       
        System.out.println("Total number of Half nodes="+n);
       
    }
   
   
    }
}
