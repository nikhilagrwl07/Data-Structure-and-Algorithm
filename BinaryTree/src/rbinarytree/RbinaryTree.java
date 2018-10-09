
package rbinarytree;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RbinaryTree {

    public static void main(String[] args) throws IOException
    {
       Node root=new Node(1);
       Node temp2=new Node(2);
       Node temp4=new Node(4);
        Node temp6=new Node(6);
           Node temp7=new Node(7);
      
                  Node temp3=new Node(3);  
         Node temp5=new Node(5);
           Node temp8=new Node(8);     
         Node temp9=new Node(9); 
         
         //-------------------------------
        Node temp11=new Node(11); 
        Node temp12=new Node(12); 
        Node temp13=new Node(13); 
        Node temp14=new Node(14); 
         //-------------------------------
           
        operationBT obj=new operationBT();
       
       obj.insert(root,2); 
       obj.insert(root,3); 
       obj.insert(root,4); 
       obj.insert(root,5);
      obj.insert(root,6);
       obj.insert(root,7);
//      obj.insert(root,8);
      //  obj.insertAtposition(root,temp2, 8);
            
//        obj.insertAtposition(root,temp4, 5);
//         obj.insertAtposition(root,temp2, 6);
//         obj.insertAtposition(root,temp6, 7);
//         obj.insertAtposition(root,temp7, 8);
         
        // obj.insertAtposition(root,temp5, 9);
          //  obj.insertAtposition(root,temp9, 10);
            //------------------------------
           // obj.insertAtposition(root,temp3, 6);
          //  obj.insertAtposition(root,temp3, 7);

//            obj.insertAtposition(root,temp11, 12);
//            obj.insertAtposition(root,temp12, 13);
//            obj.insertAtposition(root,temp13, 14);
            //------------------------------
         
    //  obj.insert(root,9);  
     //  obj.insert(root,10); 
     //  obj.insert(root,11); 
      // obj.insert(root,12); 
      // obj.insert(root,13); 
      // obj.insert(root,14);
      // obj.insert(root,15); 
       //obj.insert(temp,100); 

      System.out.println("Recursive Inorder traversal...");
      obj.rInOrder(root);

       obj.mirrorImageInPlace(root);
        System.out.println("Recursive Inorder traversal...");
        obj.rInOrder(root);
       
//              System.out.println("height = "+ obj.height(root));
//System.out.println("\nDiameter in different Recursion = "+obj.diameter_different_recursion(root));


//System.out.println("\nDiameter in same Recursion = "+obj.diameter_same_recursion(root));

      // System.out.println("\nIterative Inorder traversal...");
         
       //obj.IinOrder(root);
    
//       System.out.println();
//       System.out.println("Recursive Preorder traversal...");
//       obj.rPreOrder(root);
//       System.out.println();
       
      /*System.out.println();
       System.out.println("Iterative Preorder traversal...");
       obj.IpreOrder(root);
       System.out.println();*/
      
//       System.out.println();
//       System.out.println("Iterative PostOrder traversal using 2 stacks...");
//       obj.IpostOrder2stacks(root);
//       System.out.println();
//
//       System.out.println();
//       System.out.println("Copied iterative PostOrder traversal...");
//       obj.iterativePostOrder(root);
//       System.out.println();
//
//       System.out.println();
//       System.out.println("Iterative PostOrder traversal using 1 stack...");
//
//        obj.IpostOrder1stack(root);
      // System.out.println(); 
       
      // System.out.println();
      
 //    System.out.println("Iterative Level Order traversal using 1 queue...");
 //     obj.levelOrderQueue(root);
//       System.out.println();
       
//       System.out.println();
//       System.out.println("Iterative Level Order traversal using 2 stack...");
//       obj.levelOrder2Stacks(root);
//       System.out.println();
//
//        System.out.println();
//       System.out.println("Iterative Level Order traversal using 2 stack...");
//       obj.ReverselevelOrder2Stacks(root);
//       System.out.println();
//
//        System.out.println();
//       System.out.println("Iterative Level Order traversal using 1 stack and 1 queue...");
//       obj.ReverselevelOrderStackQueue(root);
//       System.out.println();
    
     //   System.out.println();
     //  System.out.println("Spiral Level Order traversal using 1 stack and 1 queue...");
     //  obj.levelOrderSpiral1Queue1Stack(root);
     //  System.out.println();
     
//        System.out.println();
//       System.out.println("Maximum element of Binary Tree="+obj.findMax(root));
//        System.out.println();
//
//       System.out.println("Recursive Height of Binary Tree="+obj.computeHeight(root));
//        System.out.println();
     //  obj.iterativeHeight(root);
       // System.out.println();
        
//       System.out.println("Level Order traversal using height of Tree");
//       obj.levelOrderUsingHeight(obj.computeHeight(root),root);
//        System.out.println();
//
//         System.out.println("Finding element 6 in Binary Tree="+obj.findelement(6,root));
//          System.out.println();
//
//        obj.deepestNode(root);
//        System.out.println();
//       obj.numberofleafs(root);
//        System.out.println();
        
//       obj.numberoffull(root);
//        System.out.println();
//        
//       obj.numberofhalf(root);
//        System.out.println();
        
       //System.out.println("Diameter="+obj.diameter(root,0));
       
  //    System.out.println("Diameter version v2 = "+obj.diameter_v2(root));
   
//       System.out.println();
//       System.out.println("Inorder Morris traversal W/O using stack or recursion...");
//       obj.MorrisTraversal(root);
//       System.out.println();
//       
//        System.out.println();
//       System.out.println("Inorder Morris traversal Try 1..");
//       obj.MorrisTry1(root);
//       System.out.println();
//       
//       System.out.println();
//       System.out.println("Preorder Morris traversal..");
//       obj.MorrisPreorder(root);
//       System.out.println(); 

//       System.out.println("\nAll paths from root-->leafs");
//        obj.pathsroot2leaves(root);
//        
//        obj.IterativeRoot2Leaf(root);
        
        
//         int sum=12;
//        System.out.println("Sum="+sum+" Exsitence="+obj.givenSumExistence(root,sum));
//        
//        System.out.println("Total sum of tree="+obj.totalsum(root));
        
       
       int inorder[]={4,  5,  2,  6,  7,  8,  1,  3 };
       int preorder[]={1,  2,  4,  5,  6,  7,  8,  3 };
       
       int postorder[]={5,  4, 8  ,7,  6,  2, 3,  1};
       // constructing the binary tree with given inorder & preorder traversal
//       Node newNode=obj.buildTree(inorder,preorder,0,inorder.length-1);
//       System.out.println("Post Order traversal of constructed tree");
//       obj.iterativePostOrder(newNode); 
       
       
//       Node newNode2=obj.buildTree_Inorder_Postorder(inorder,postorder,0,inorder.length-1);
//       System.out.println("Pre Order traversal of constructed tree");
//       obj.rPreOrder(newNode2); 
       
       
     //  System.out.println("Post order traversal without constructing tree: ");
     //  obj.printPostOrderTraversal(inorder, 0 , preorder, 0, inorder.length-1);
   //  Node node=new Node(8);
     //  obj.printAncestorIterative(root,node);
        
     //  System.out.println("Recursive version: ");
     //  boolean temp=obj.printAncestorRecursive(root,node);
      
//            System.out.println();
//        System.out.println("Top down approach LCA of "+temp5.value +" and "+ temp3.value+"  = "+obj.LCAtopdown(root,temp5,temp3).value);
//             System.out.println();
//     System.out.println("Bottom Up approach LCA of "+temp5.value +" and "+ temp3.value+"  = "+obj.LCAbottomUp(root,temp5,temp3).value);
//     System.out.println();
//    obj.LCA_Inorder_Postorder(root,temp8,temp2);  
//         System.out.println();
//     obj.LCA_Inorder_Preorder(root,temp8,temp2);  
//     
//     obj.VerticalSum(root);
     
//     int n=4;
//     Node Presuccessor=obj.preOrderSuccessor(root,n);
//     if(Presuccessor!=null)
//       System.out.println("\nPreorder Successor of "+n+" = "+Presuccessor.value);
//     else
//          System.out.println("\nPreorder Successor of "+n+" = null");

//     Node Insuccessor=obj.InOrderSuccessor(root,n);
//     if(Insuccessor!=null)
//       System.out.println("Inorder Successor of "+n+" = "+Insuccessor.value);
//     else
//          System.out.println("InorderSuccessor of "+n+" = null");


//       Node Postsuccessor=obj.postOrderSuccessor(root,n);
//     if(Postsuccessor!=null)
//       System.out.println("postorder Successor of "+n+" = "+Postsuccessor.value);
//     else
//          System.out.println("postorder Successor of "+n+" = null");
     
     
     //   obj.find2Nodes(root, 8);
       
     /*  obj.sumTree(root);
       System.out.println("Inorder traversal of sum tree is: ");
      System.out.println("Root value="+root.value);
       obj.rInOrder2(root);*/
         
       }
}


class operationBT
{
    Queue<Node> queue=new LinkedList();
    int inOrder[]=new int[10];
    int postOrder[]=new int[10];
    int preOrder[]=new int[10];
    int indexInorder=0,indexPostorder=0,indexPretorder=0;
    
    Node root;
    int max=-10;
    // Insert Operation
       public void insert(Node root,int x)
       {
           if(root==null)
           {
               root=new Node(x);
              
           }
              
           else
           {
               queue.add(root);           
               
               while(!queue.isEmpty())
               {
                   Node t=queue.remove();
                   
                   if(t.left==null)
                   {
                       t.left=new Node(x);
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
                       queue.clear();
                   }
                   else
                   {
                       queue.add(t.right);
                   }
               }
           }
       }
       
       public void insertAtposition(Node root,Node position,int x)
       {
           if(position==null || root==null)
               return;
           else
           {
               if(root.value==position.value)
               {                   
                    if(root.right==null)
                       root.right=new Node(x);
                    
                  else if(root.left==null)
                       root.left=new Node(x);                   
                   
               }
               else
               {
                   Queue<Node> qwe = new LinkedList();
                  
                   qwe.add(root);
                   Node t;
                   while(!qwe.isEmpty())
                   {
                       t=(Node) qwe.remove();
                       
                       if(t.value==position.value)
                       {
                           if(t.right==null)
                               t.right=new Node(x);
                          
                           if(t.right==null && t.left==null)
                               t.left=new Node(x);
                           
                           break;
                       }
                       if(t.left!=null)
                        qwe.add(t.left);
                       if(t.right!=null)
                           qwe.add(t.right);
                   }
               }
           }
       }
    //Recursive Inorder Traversal
    public void rInOrder(Node r)
    {
        if(r==null)
             return;
        else
        {
            rInOrder(r.left);
          
        System.out.print(r.value+"  ");
//        inOrder[indexInorder++]=r.value;
           rInOrder(r.right);
        
        
        }
    }
    
      // Iterative Inorder traversal
public void IinOrder(Node rt)
{  
  Stack s=new Stack();
   
  while(rt!=null) 
   {
     s.push(rt);
     rt=rt.left;
   }
  Node t2;
  
  while(!s.isEmpty())
  {
      Node t= (Node)s.pop();
      System.out.print(t.value+"  ");
      t2=t.right;
       
      while(t2!=null)
      {
          s.push(t2);
          t2=t2.left;
      }
  }
}
  
public void rPreOrder(Node r)
{
    if(r!=null)
    {
        System.out.print(r.value+"  ");
//        preOrder[indexPretorder++]=r.value;
        rPreOrder(r.left);
        rPreOrder(r.right);
    }
    else
        return;
    
}

public void IpreOrder(Node rt)
{  
  Stack s=new Stack();
   Node temp;
   
  s.push(rt);
  
  while(!s.isEmpty())
  {
      temp=(Node) s.pop();
      System.out.print(temp.value+"  ");
      
      if(temp.right!=null)
          s.push(temp.right);
      if(temp.left!=null)
          s.push(temp.left);
      
   }
}
  
public void IpostOrder2stacks(Node rt)
{  
  Stack s1=new Stack();
  Stack s2=new Stack();
   
 Node temp;
   
  s1.push(rt);
  
  while(!s1.isEmpty())
  {
      temp=(Node) s1.pop();

      s2.push(temp);
      if(temp.left!=null)
          s1.push(temp.left);
      
      if(temp.right!=null)
          s1.push(temp.right);
      
   }
     
  while(!s2.isEmpty())
  {
      Node x=(Node) s2.pop();
       System.out.print(x.value+"  ");
//      postOrder[indexPostorder++]=x.value;
       
  }
     
}

// Source of informatio: http://www.geeksforgeeks.org/iterative-postorder-traversal/
public void iterativePostOrder(Node root)
    {  
        Stack st1 = new Stack();
        Stack st2 = new Stack();
        st1.push(root);
        Node current = root;
        boolean visitedLeaf = false;
        while(!st1.isEmpty())
        {
            Node t1 =(Node) st1.peek();
            Node t2 =st2.isEmpty() ? null: (Node) st2.peek();
     
            if(t1 != null && t2 != null && t1.value == t2.value &&  t1.right != null)
            {
                System.out.print("  " +t1.value);
                st1.pop();
                st2.pop();
                current = st1.isEmpty() ? null:(Node) st1.peek();
            }
            else
            {
     
                if(current.left != null && !visitedLeaf)
                {
                    current = current.left;
                    st1.push(current);
                  //  System.out.println("Pushing current in left = "+ current.data);
                }
                else if(current.right != null)
                {
                    st2.push(current);
                    current = current.right;
                    st1.push(current);
                //    System.out.println("Pushing Node in right = " + current.data);
                    visitedLeaf = false;
                }
                else
                {
                    System.out.print(" " + current.value);
                    st1.pop();
                    current =(Node) st1.peek();
                    visitedLeaf = true;
                }
            }   
         }
        System.out.println();
    }   


public void IpostOrder1stack(Node rt)
{  
    
  if(rt==null)  
      return;
  
  Stack s1=new Stack();     
 
 // s1.push(rt);
  
do
{
    while(rt!=null)
    {
        if(rt.right!=null)
            s1.push(rt.right);
        
        s1.push(rt);
        
        rt=rt.left;
    }
    
        
    rt=(Node) s1.pop();
    
    Node top=null;
    
    if(!s1.isEmpty())
        top=(Node) s1.peek();
    
    
    if(rt.right!=null && rt.right==top)
    {
        Node t1=(Node) s1.pop();
        s1.push(rt);
        rt=rt.right;
    }
    else
    {
        System.out.print(rt.value+"  ");
        rt=null;
    }
    
}while(!s1.isEmpty());
  
     
}



public void levelOrderQueue(Node root)
{
    if(root==null)
        return;
    
      
    Queue<Node> q=new LinkedList();
   
    q.add(root);
   
  
   while(!q.isEmpty())
    { 
        
        Node tt=(Node) q.remove();   
       
        
        System.out.print(tt.value+"  ");
        
        if(tt.left!=null)
            q.add(tt.left);
        
        if(tt.right!=null)
            q.add(tt.right);    
        
    }

}

public void levelOrder2Stacks(Node root)
{
  if(root==null)    
      return;
  
  Stack s1=new Stack();
  Stack s2=new Stack();
  
  s1.add(root);
       
  while(!s1.isEmpty())
  {
      while(!s1.isEmpty())
      {
          Node tt=(Node) s1.pop();
          
          if(tt.left!=null)
              s2.push(tt.left);
          
          if(tt.right!=null)
              s2.push(tt.right);
          
        System.out.print(tt.value+"  ");
      }
      
      while(!s2.isEmpty())
          s1.push(s2.pop());
      
   }
}


public void ReverselevelOrder2Stacks(Node root)
{
    if(root==null)
        return;
    Stack s=new Stack();
    Stack s2=new Stack();
    
    s.add(root);
    s2.add(root);
    
   while(!s.isEmpty())
    {
          Node tt=(Node) s.pop();
      
         if(tt.left!=null)
        {
            s.push(tt.left);
            
            if(tt.right!=null)
              s2.push(tt.right);
        }
          
        
        if(tt.right!=null)
        {
            s.push(tt.right);
               
            if(tt.left!=null)
              s2.push(tt.left);
        }  
        
    }
   
   while(!s2.isEmpty())
   {
       Node t=(Node) s2.pop();
       System.out.print(t.value+"  ");
   }
}

public void ReverselevelOrderStackQueue(Node root)
{
    if(root==null)
        return;
    Stack s=new Stack();
    Queue<Node> q=new LinkedList();
        q.add(root);
    
   while(!q.isEmpty())
    {
          Node tt=(Node) q.remove();
          s.push(tt);
        if(tt.right!=null)
        {
            q.add(tt.right);
        }          
          
         if(tt.left!=null)
        {
           q.add(tt.left);
        }          
    }

   while(!s.isEmpty())
   {
       Node t=(Node) s.pop();
       System.out.print(t.value+"  ");
   }
}

//finding maximum element using recursion
public int findMax(Node root)
{
    if(root==null)
        return -1;
    
    if(max<root.value)
        max=root.value;
    
    if(root.left!=null)
    {
        max=findMax(root.left);
    }
    
    if(root.right!=null)
    {
        max=findMax(root.right);
    }
    
    return max;
}

public void iterativeHeight(Node root)
{
    int height=0;
    Node t=new Node(-1);
    if(root==null)
        System.out.println("Height="+height);
    
    Queue<Node> s=new LinkedList();
    s.add(root);
    s.add(t);
    
    while(!s.isEmpty())
    {
        Node tt=(Node) s.remove();
        
        if(tt.value==-1)
        {
            height++;
            s.add(tt);
            
            Node justNext=(Node) s.peek();
            
            if(justNext.value==-1)
                break;
        }
        else
        {
            if(tt.left!=null)
                s.add(tt.left);
            
            if(tt.right!=null)
                s.add(tt.right);
        }
        
        
    }
    System.out.println("Iterative height="+height);
}
public int computeHeight(Node root)
{
    int lheight=0,rheight=0,height =0;
    if(root==null)
        return 0;

    if(root.left!=null)
    {
        lheight=computeHeight(root.left);
    }
    
    if(root.right!=null)
    {
        rheight=computeHeight(root.right);
    }
    
    if(lheight>rheight)
    {
        height=lheight;
    }
    else
        height=rheight;
    
    return height+1;
}

public void levelOrderUsingHeight(int ht,Node root)
{
    int i;
    for(i=1;i<=ht;i++)
    {
      //  System.out.println("Root value"+root.value);
        printgivenlevel(i,root);
    }
}
public void printgivenlevel(int level,Node root)
{
    if(root==null)
        return;
    
    if(level==1)
        System.out.print(root.value+"  ");
    else if(level>1)
    {
        if(root.left!=null)
            printgivenlevel(level-1,root.left);
        
        if(root.right!=null)
            printgivenlevel(level-1,root.right);
    }
}

public boolean findelement(int e,Node root)
{
    boolean result=false;
    if(root==null)
        return result;
    
    if(root.value==e)
       result=true;
    
    if(root.left!=null)
        result=findelement(e,root.left);
    
    if(!result && root.right!=null)
        result=findelement(e,root.right);
    
    return result;
}

public void deepestNode(Node root)
{
    if(root==null)
        return;
    
    Queue<Node> q=new LinkedList();
    Node t=null;
    q.add(root);
    while(!q.isEmpty())
    {
        t=(Node) q.remove();
        
        if(t.left!=null)
            q.add(t.left);
        
        if(t.right!=null)
            q.add(t.right);
    }    
    System.out.println("Deepest Node in Binary Tree="+t.value);
}
/*
public void numberofleafs_(Node root)
{
      int max=-1;
        int value=0;
    if(root==null)
    {
        System.out.println("Number of leaf nodes=0");
        return;
    }
    else
    {
        Node temp=null;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(temp);
      
        while(!q.isEmpty())
        {
            Node t=q.remove();
            
            if(t!=null)
            {
                value=0;
                while(t!=null)
                {
                    value++;                    
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
                
                    t=q.remove();
                }
                
                q.add(temp);
                if(value>max)
                    max=value;                
            }
            else if(t==null)
            {
                continue;
            }
            
        }
        System.out.println("Number of leaf Nodes="+max);
    }
}*/

public void numberofleafs(Node root)
{
    Node temp;
    Queue<Node> q=new LinkedList();
    int count=0;
    if(root==null)
        return;

    q.add(root);
        while(!q.isEmpty())    
        {
            temp=q.remove();
            if(temp.left==null && temp.right==null)
                count++;


                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);

        }

        System.out.println("Number of leaf Nodes="+count);
}

public void numberoffull(Node root)
{
Node temp;
Queue<Node> q=new LinkedList();
int count=0;
if(root==null)
    return;

q.add(root);
    while(!q.isEmpty())    
    {
        temp=q.remove();
        if(temp.left!=null && temp.right!=null)
        {
            count++;
        }
                
            if(temp.left!=null)
                   q.add(temp.left);
            if(temp.right!=null)
                   q.add(temp.right);
        
    }
    
    System.out.println("Number of full Nodes="+count);
}

public void numberofhalf(Node root)
{
Node temp;
Queue<Node> q=new LinkedList();
int count=0;
if(root==null)
    return;

q.add(root);
    while(!q.isEmpty())    
    {
        temp=q.remove();
        if(temp.left!=null && temp.right==null)
        {
            count++;
        }
         if(temp.left==null && temp.right!=null)
         {
             count++;
         }
        
            if(temp.left!=null)
                   q.add(temp.left);
            if(temp.right!=null)
                   q.add(temp.right);
        
    }
    
    System.out.println("Number of Haf Nodes="+count);
}


// findinf diameter on my own 
public int diameter_different_recursion(Node root)
{
    if(root==null)
        return 0;
    
    int l=height(root.left);
    int r=height(root.right);
    
    int ldiameter=diameter_different_recursion(root.left);
    int rdiameter=diameter_different_recursion(root.right);
    
    
    
    return Math.max(l+r+1, Math.max(ldiameter,rdiameter));
   // System.out.println("Diameter = "+(1+l+r));
}

public int diameter_same_recursion(Node root)
{
    MaxLengthSoFar ob=new MaxLengthSoFar();
    getDiameter(root,ob);

    return ob.getMaxLength();
}

private int getDiameter(Node root,MaxLengthSoFar dataTracker)
{ 
    if(root==null)
        return 0;
    
    int hieghtLch=getDiameter(root.left,dataTracker); 
    int heightRch=getDiameter(root.right,dataTracker);


        if((hieghtLch+heightRch+1)>dataTracker.getMaxLength())
        {
            dataTracker.setMaxLength(hieghtLch+heightRch+1); 
            dataTracker.setNode(root); 
        } 
        return (hieghtLch>heightRch?hieghtLch:heightRch)+1;
}

public int height(Node t)
{
    if(t==null)
        return 0;
    
    int lheight=height(t.left);
    int rheight=height(t.right);
    
    return 1+Math.max(lheight,rheight);
}

public void MorrisTraversal(Node root)
{
    Node current,prev;
    
    if(root==null)
        return;
    
    current=root;
    
    while(current!=null)
    {
        if(current.left==null)
        {
            System.out.print(current.value+"  ");  
            current=current.right;
        }
        else
        {
            // find the inorder predecessor of current Node
            prev=current.left;
            while(prev.right!=null && prev.right!=current)
                prev=prev.right;
            
            // Make current as right child of its inorder predecessor 
            if(prev.right==null)
            {
                prev.right=current;
                current=current.left;
            }
         /* Revert the changes made in if part to restore the original
        tree i.e., fix the right child of predecssor */
            else
            {
                prev.right=null;
               // System.out.print(" - "+current.value+" - ");
                System.out.print(current.value+"  ");
                current=current.right;
            }
        }
    }
}

public void MorrisPreorder(Node root)
{
    if(root==null)  return;
    
     while (root!=null)
    {
        // If left child is null, print the current node data. Move to
        // right child.
        if (root.left == null)
        {
            System.out.print(root.value+"  ");
            root = root.right;
        }
        else
        {
            // Find inorder predecessor
            Node current = root.left;
            while (current.right!=null && current.right != root)
                current = current.right;
 
            // If the right child of inorder predecessor already points to
            // this node
            if (current.right == root)
            {
                current.right = null;
                root = root.right;
            }
 
            // If right child doesn't point to this node, then print this
            // node and make right child point to this node
            else
            {
                System.out.print(root.value+"  ");
                current.right = root;
                root = root.left;
            }
        }
    }
}

int len=0;

// print all paths from root to leaf nodes
//Node tp=new Node(root.value);


public void pathsroot2leaves(Node root)
{
    int path[]=new int[256];
    paths(root,path,0);
           
}
public void paths(Node root,int path[],int pathlen)
{
      if(root==null)  return;
      
      path[pathlen++]=root.value;
    
      if(root.left==null && root.right==null)
          printpaths(pathlen,path);
      else
      {
          paths(root.left,path,pathlen);
          paths(root.right,path,pathlen);
      }
    
}

public void printpaths(int l,int pathways[])
{
    int i;
    for(i=0;i<l;i++)
        System.out.print(pathways[i]+"  ");
    
     System.out.println();
}

//http://stackoverflow.com/questions/11045399/print-every-leaf-path-of-a-tree-without-recursive
public static void IterativeRoot2Leaf(Node root) 
{
    if (root == null) 
    {
        return;
    }

    Queue<Object> q = new LinkedList();
    
    q.add(root);
    q.add(root.value + " ");

    while(!q.isEmpty()){

        Node head = (Node) q.remove();
        String headPath = (String) q.remove();

        if(head.left==null && head.right==null){
            System.out.println(headPath);
            continue;
        }

        if(head.left!=null){
            String leftStr =  headPath + " -> " + head.left.value;
            q.add(head.left);
            q.add(leftStr);
        }

        if(head.right!=null){
            String rightStr =  headPath + " -> " + head.right.value;
            q.add(head.right);
            q.add(rightStr);
        }
    }


}

// recursive version
public boolean givenSumExistence(Node root, int sum)
{
    if(root==null) 
        return sum==0;
    
    int newsum=sum-root.value;
    
    return givenSumExistence(root.left,newsum) || givenSumExistence(root.right,newsum);
}


public int totalsum(Node root)
{
    if(root==null) return 0;
    
    return (root.value+totalsum(root.left)+totalsum(root.right));
        
    
}

int tp=0;
 
public void printPostOrderTraversal(int in[],int inIndex,int pre[],int preIndex,int n) 
{
    if(n==0)
        return;
    
    int r=search(in,0,in.length-1,pre[tp++]);
    
    System.out.println("r = "+r);
    if(r!=0)
    {
        printPostOrderTraversal(in,inIndex,pre,preIndex+1,r);
    }
    
     if(r!=n-1)
    {
        printPostOrderTraversal(in,inIndex+r+1,pre,preIndex+r+1,n-r-1);
    }
     System.out.print(pre[tp-1]);
}
 
 //http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree-from-inorder-and-preorder-traversals/
 int preindex=0;
public Node buildTree(int in[],int pre[],int instrt,int inend)
{    
    
    if(instrt>inend)
        return null;
    
    /* Pick current node from Preorder traversal using preIndex
    and increment preIndex */
    Node tnode=new Node(pre[preindex++]);
    
    // If this node i.e., tnode has no children then return this node
    if(instrt==inend)
        return tnode;
    
    // else find the tnode in inorder traversal
    int inIndex=search(in,instrt,inend,tnode.value);
    
    //using inIndex of inorder traversal construct left and right subtree
   tnode.left=buildTree(in,pre,instrt,inIndex-1);
   tnode.right=buildTree(in,pre,inIndex+1,inend);
   
   return tnode;
}

int postIndex;
public Node buildTree_Inorder_Postorder(int in[],int post[],int instrt,int inend)
{
    postIndex=in.length-1;
   // System.out.println("Postorder length= "+postIndex);
   Node result=buildTree_Inorder_PostorderUtil(in,post,instrt,inend);
   
   return result;
}



public Node buildTree_Inorder_PostorderUtil(int in[],int post[],int instrt,int inend)
{    
    
    if(instrt>inend)
        return null;
    
    if(postIndex<=0)
        return null;
    
    /* Pick current node from Preorder traversal using preIndex
    and increment preIndex */
   // System.out.println("PostOrder= "+postIndex);
    
    Node tnode=new Node(post[postIndex]);
    postIndex--;
    
    // If this node i.e., tnode has no children then return this node
    if(instrt==inend)
        return tnode;
    
    // else find the tnode in inorder traversal
    int inIndex=search(in,instrt,inend,tnode.value);
    
    //using inIndex of inorder traversal construct left and right subtree
   tnode.left=buildTree_Inorder_PostorderUtil(in,post,instrt,inIndex-1);
   tnode.right=buildTree_Inorder_PostorderUtil(in,post,inIndex+1,inend);
   
   return tnode;
}
public int search(int a[],int s,int e,int v)
{
    int i,index=-1;
    for(i=s;i<=e;i++)
    {
        if(a[i]==v)
            index= i;
    }
    return index;
}

public void printAncestorIterative(Node root,Node a) 
{
      System.out.println();
      
    int flag=0;
    if (root == null) 
    {
        return;
    }
    
     System.out.println("Iterative version:");

    Queue<Object> q = new LinkedList<Object>();
    q.add(root);
    q.add(root.value + " ");

    while(!q.isEmpty()){

        Node head = (Node) q.remove();
        String headPath = (String) q.remove();

        if(head.value==a.value){
            System.out.println("Ancestors of Node= "+a.value+" "+headPath);
            flag=1;
            break;
        }
        
        if( head.left!=null && head.left.value==a.value)
        {
            System.out.println("Ancestors of Node= "+a.value+" "+headPath);
            flag=1;
            break;
        }
         
         if( head.right!=null && head.right.value==a.value)
        {
            System.out.println("Ancestors of Node = "+a.value+" "+headPath);
            flag=1;
            break;
        }
            
        if(head.left!=null ){            
            String leftStr =  headPath + " -> " + head.left.value;
            q.add(head.left);
            q.add(leftStr);
        }

        if(head.right!=null){               
            String rightStr =  headPath + " -> " + head.right.value;
            q.add(head.right);
            q.add(rightStr);
        }
    }
    
    if(flag==0)
     System.out.println("Ancestors of Node iterative = "+a.value+" is NOT present.");

}

public boolean printAncestorRecursive(Node root, Node a)
{
    if(root==null) return false;
     
    if(root.left!=null)
    {
        if(root.left.value==a.value || printAncestorRecursive(root.left,a))
        {
            System.out.print(root.value+"  ");
            return true;
        }
    }
     if(root.right!=null)
    {
        if(root.right.value==a.value || printAncestorRecursive(root.right,a))
        {
            System.out.print(root.value+"  ");
              return true;
        }
      
    }
        return false;
}


// NOT clear to me at all. 
//Source: http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
public Node LCAtopdown(Node root,Node p,Node q)
{    
    if(root==null || p==null || q==null)
    {
        return null;
    }
    
    if(root.value==p.value||root.value==q.value)
        return root;
    
    int totalMatches=countMatchesPQ(root.left,p,q);
       
    if (totalMatches == 1)
    return root;
  else if (totalMatches == 2)
    return LCAtopdown(root.left, p, q);
  else /* totalMatches == 0 */
    return LCAtopdown(root.right, p, q);
}

// Return #nodes that matches P or Q in the subtree.
public int countMatchesPQ(Node root, Node p, Node q)
{
  if (root==null) 
      return 0;
  
  int matches = countMatchesPQ(root.left, p, q) + countMatchesPQ(root.right, p, q);
  if (root.value == p.value || root.value == q.value)
    return 1 + matches;
  else
    return matches;
}

//  Not clear to me at all.
    public Node LCAbottomUp(Node root,Node p, Node q)
    {
        if(root==null|| p==null || q==null) 
            return null;
       
        if(root.value==p.value||root.value==q.value) 
            return root;
        
        Node l=LCAbottomUp(root.left,p,q);
        Node r=LCAbottomUp(root.right,p,q);
        
        // if p and q are on both sides
        if(l!=null && r!=null) 
            return root;
        
        // either one of p,q is on one side OR p,q is not in L&R subtrees
        return l!=null?l:r;
        
    }

    // Source: https://www.youtube.com/watch?v=LFjCr2yDJdc
    public void LCA_Inorder_Postorder(Node root, Node p,Node q)
    {
        int i,t=0,largest=-1,tindex=0,ans=0;
    
        int subset[]=new int[indexInorder];
        int pIndex=this.search(this.inOrder, 0, this.indexInorder-1, p.value);
        int qIndex=this.search(this.inOrder, 0, this.indexInorder-1, q.value);
        
        if(pIndex<qIndex)
        {
            for(i=pIndex;i<=qIndex;i++)
            {
                subset[t++]=this.inOrder[i];
            }
        }
        else
        {
             for(i=qIndex;i<=pIndex;i++)
            {
//                subset[t++]=this.inOrder[i];
            }
        }
        
        for(i=0;i<t;i++)
        {
          tindex=this.search(this.postOrder, 0, this.indexInorder-1, subset[i]);
          if(tindex>largest)
          {
              largest=tindex;
              ans=this.postOrder[largest];
          }
          
        }
       
        System.out.println("Inorder+postorder LCA of "+p.value+"  and "+q.value+" = "+ans);

        
    }
    
    
    // Source: https://www.youtube.com/watch?v=LFjCr2yDJdc
     public void LCA_Inorder_Preorder(Node root, Node p,Node q)
    {
        int i,t=0,smallest=this.indexInorder,tindex=0,ans=0;
    
        int subset[]=new int[indexInorder];
        int pIndex=this.search(this.inOrder, 0, this.indexInorder-1, p.value);
        int qIndex=this.search(this.inOrder, 0, this.indexInorder-1, q.value);
        
        if(pIndex<qIndex)
        {
            for(i=pIndex;i<=qIndex;i++)
            {
                subset[t++]=this.inOrder[i];
            }
        }
        else
        {
             for(i=qIndex;i<=pIndex;i++)
            {
//                subset[t++]=this.inOrder[i];             
            }
        }
        
        for(i=0;i<t;i++)
        {
          tindex=this.search(this.preOrder, 0, this.indexInorder-1, subset[i]);
              
          if(tindex!=-1 && tindex<smallest)
          {
              
              smallest=tindex;
              ans=this.preOrder[smallest];
          }
          
        }
       
        System.out.println("Inorder+preOrder LCA of "+p.value+"  and "+q.value+" = "+ans);

        
    }
 
 //http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
     //Time Complexity: O(n)
   public void VerticalSum(Node root)  
   {
       // base case
       if(root==null) return;
       
       // Create an empty hashMap hm
       HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
       
       // Call verticalSumUtils to store vertical sum of every node
       verticalSumUtil(root,0,hm);
       
       // prints the values stored by verticalSumUtil
       if(hm!=null)
       {
           System.out.println("Sum of vertical of the given tree..");
           System.out.println(hm.entrySet());
           
       }
   }
     
  // traverse the binary tree in postorder form and build hashmap hm 
   // which contains the vertical sum of each vertical
   public void verticalSumUtil(Node root, int hd, HashMap<Integer,Integer>hm)
   {
       // base case
       if(root==null) return;       
       
       // store value in hm for left subtree
       verticalSumUtil(root.left,hd-1,hm);
       
       // store the values in hm for right subutree
        verticalSumUtil(root.right,hd+1,hm);
        
       
       // update the vertical sum for hd of this node
       int prevSum=(hm.get(hd)==null)?0:hm.get(hd);
       hm.put(hd, prevSum+root.value);
   }
     
   
 // finding preOrder successor in a binary Tree
   public Node preOrderSuccessor(Node root, int key)
   {
       return preOrderSuccessorUtil(root,key,null,null,null);
   }
   
   
   public Node preOrderSuccessorUtil(Node root,int key, Node direct_parent,Node parent,Node parent_rightsib)
   {
       // Case 1 
       if(root==null) return null;
       
       // Case 2
       if(root.value==key)
       {
           
           // Case 2.1
           if(root.left!=null) 
               return root.left;
           
           // Case 2.2
           else if(root.right!=null) 
               return root.right;
           
           
           // Case 2.3
           else if(direct_parent!=null && direct_parent.left==root && direct_parent.right!=null)
               return direct_parent.right;
           
           // Case 2.4
           else if(parent!=null && parent_rightsib!=null)
               return parent_rightsib;
           
           // Case 2.5
           else
               return null;
       }
       // Case 3
       else
       {
           // Case 3.1
           Node left=preOrderSuccessorUtil(root.left,key,root,root,root.right);
           if(left!=null)
               return left;
           
           // Case 3.2
           return preOrderSuccessorUtil(root.right,key,root,parent,parent_rightsib);
           
       }
   }
   
   
   
   // finding preOrder successor in a binary Tree
   public Node InOrderSuccessor(Node root, int key)
   {
      
       return InOrderSuccessorUtil(root,key,null);
   }
   
   
   public Node InOrderSuccessorUtil(Node root,int key, Node parent)
   {
       // Case 1 
       if(root==null) return null;
       
       // Case 2
       if(root.value==key)
       {
           
           // Case 2.1
           if(root.right!=null) 
               return findleftMostNode(root.right);     
           // Case 2.2
           else
               return parent;
       }
       // Case 3
       else
       {
           // Case 3.1
           Node left=InOrderSuccessorUtil(root.left,key,root);
           if(left!=null)
               return left;
           
           // Case 3.2
           return InOrderSuccessorUtil(root.right,key,parent);
           
       }
   }
   
   
   public Node leftmostLEAFnotNODE(Node root)
   {
       while(root.left!=null || root.right!=null)
       {
           if(root.left!=null) 
               root=root.left;
           else
               root=root.right;
       }
       return root;
   }
   
   //Source: http://algorithmsgeek.blogspot.in/2013/06/algo4-postorder-successor-in-binary-tree.html
    // finding postOrder successor in a binary Tree
   public Node postOrderSuccessor(Node root, int key)
   {
      
       return postOrderSuccessorUtil(root,key,null,null,root);
   }
   
   
   public Node postOrderSuccessorUtil(Node root,int key,Node direct_parent,Node parent,Node treeroot)
   {
       // Case 1 
       if(root==null) return null;
       
       // Case 2
       if(root.value==key)
       {
           
           // Case 2.1
           if(root==treeroot) 
               return null;
           
           // Case 2.2
          else if(direct_parent!= null && direct_parent.right==root)
                    return direct_parent;
           
           // Case 2.3
           // Case 2.3.1
            else if(direct_parent != null && direct_parent.left==root && direct_parent.right!=null)
	            return leftmostLEAFnotNODE(direct_parent.right);
      
        // Case 2.3.2
           else if(direct_parent != null && direct_parent.left==root && direct_parent.right==null)
	            return direct_parent;
           
         // Case 2.3.3
           else 
               return null;
       }
       else
       {
           // Case 3.1
           Node left=postOrderSuccessorUtil(root.left,key,root,root,treeroot);
           if(left!=null)
               return left;
           
           // Case 3.2
           return postOrderSuccessorUtil(root.right,key,root,parent,treeroot);
           
       }
   }
   
   public Node findleftMostNode(Node node)
   {
       while(node.left!=null)
           node = node.left;
       
       return node;
   }
   
   
     // find number of pairs (a,b) such that a.data+b.data=k
     //in an unbalanced Binary Tree NOT in BST
     public void find2Nodes(Node root,int k)
     {
         if(root==null) return;
         
         Stack s1=new Stack();
            Stack s2=new Stack();
         
        
         Node a=root,b=root;
         
         s1.push(a);
         s2.push(b);
         
         while(a.left!=null)
         {
             s1.push(a.left);
             a=a.left;
         }
         
          while(b.right!=null)
         {
             s2.push(b.right);
             b=b.right;
         }
         
         System.out.println("Poosible pairs for value= "+k+" as follows:");
          
          while(!s1.isEmpty() && !s2.isEmpty())
          {
              /*
              if(a.value+b.value==k) 
              {
                  System.out.println(a.value+" , "+b.value);
                  
              }*/
                            
               if(a.value+b.value<=k)
              {
              
             if(a.value+b.value==k) 
              {
                  System.out.println(a.value+" , "+b.value);
                  
              }
                  
                  if(a.right!=null)
                  {
                      a=a.right;
                      while(a.left!=null)
                      {
                          s1.push(a.left);
                          a=a.left;
                          
                      }
                  }
                  else
                      a=(Node) s1.pop();
              }
              
              else //a.value+b.value>k
              {
                   if(b.left!=null)
                  {
                      b=b.left;
                      while(b.right!=null)
                      {
                          s2.push(b.right);
                          b=b.right;
                          
                      }
                  }
                  else
                      b=(Node) s2.pop();
              }
          }
     }
     
     public int sumTree(Node r)
     {
         // base cases
         if(r==null)
             return 0;   
         
         r.value += sumTree(r.left)+sumTree(r.right);
         
       
         if(r.left==null && r.right==null)
         {
             int old_val=r.value;
                r.value=0;
             return old_val;   
           
         } 
         
         return r.value;
     }
     
     public void rInOrder2(Node root)
     {
         if(root==null)
             return;
         
         rInOrder2(root.left);
         System.out.println(root.value);
         rInOrder2(root.right);
     }

     public Node mirrorImageInPlace(Node root){
        if(root==null) return  null;

        if(root.left==null && root.right==null)
            return root;

        Node temp = root.left;
        root.left=root.right;
        root.right=temp;

        mirrorImageInPlace(root.left);
        mirrorImageInPlace(root.right);
        return root;
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

class MaxLengthSoFar
{

       Node node;
       int maxLength;

               public MaxLengthSoFar()
               {

               }

       public int getMaxLength(){
           return maxLength;
       }

       public void setMaxLength(int maxLen){
           maxLength=maxLen;
       }
       public void setNode(Node pNode){
           node=pNode;
       }
   }