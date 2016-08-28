
package revisionbst;


// This is a revsion of binary tree 

import java.util.*;



// sample class for node structure of binary tree

class Node
{
    int data;
    Node left;
    Node right;
    
    public Node()
    {
        left=null;
        right=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

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
}

    	// This wrapper is simulating pointer.
// int is primitive type and Integer is immutable so neither of them can
// be used for call by referrence. You can create int[] {0} but it will
// confuse people.
class intWrapper 
{
    int val;

    intWrapper(int val)
    {
    this.val = val;	
    }
}


class Wrapper
{
    Node node;
}

class NodePair
{
    Node head;
    Node tail;
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


class BinarySearchTree
{
    
    Node root=null;
   
    public Node formRoot(int x) 
    {
        root=new Node();
        root.data=x;
        root.left=null;
        root.right=null;
        return root;
        
    }
    
   public void insertInBST(Node r,int x)
    {
        if(x<r.data)
        {
           if(r.left==null)
           {               
               r.left=new Node();
               r.left.data=x;
               
           }
           else
           {
               insertInBST(r.left, x);
           }
        }
        else if(x>=r.data)
        {   
            if(r.right==null)
           {               
               r.right=new Node();
               r.right.data=x;
               
           }
           else
           {
               insertInBST(r.right, x);
           }
        }
    }
           
   int count_size=sizeOfTree(root);
   
   int[] preOrder=null; //new int[sizeOfTree(root)];
    int[] inOrder=null; //new int[count_size];
     int[] postOrder=null; //new int[sizeOfTree(root)];
     
     public void declareArray(int s)
     {
         inOrder=new int[s];
         preOrder=new int[s];
         postOrder=new int[s];
     }
    public void rInOrder()
    {
        System.out.println("Recursive Inorder traversal:");
        rInOrder(root);
    }
    
    int inOrderCounter=0;
    public void rInOrder(Node r)
    {
        if(r==null) return;
             
            rInOrder(r.left);   
        System.out.print(r.data+"  ");
//        inOrder[inOrderCounter++]=r.data;
        rInOrder(r.right);   
        
    }
   
    public void printArray()
    {
         System.out.println("InOrder traversal from stored array:");
        printArrayUtil(inOrder);
    }
    
    public void printArrayUtil(int a[])
    {
        System.out.println(Arrays.toString(a));
    }
    
    public void isStrictTree()
    {
         if(isStrictTree(root))
             System.out.println("\nTree is Strict binary tree");
         else
             System.out.println("\nTree is NOT Strict binary tree");
    }
    
    public boolean isStrictTree(Node r)
    {
        if(r==null) 
            return true;
        
        if((r.left!=null && r.right!=null) || (r.left==null && r.right==null))
            return isStrictTree(r.left) && isStrictTree(r.right);        
        else
            return false;
    }
    
    public void getHeight()
    {
        System.out.println("\nRecusrive Height = "+ getHeight(root));
        
        System.out.println("Iterative Height = "+ getHeightIterative(root));
    }
    
    // calculating height of a node
    public int getHeight(Node p)
    {
        if(p==null)
            return 0;
        
        return 1+Math.max(getHeight(p.left), getHeight(p.right));
        
    }
    
    public int getHeightIterative(Node r)
    {
        int count=0;
        
        Node temp=new Node();
        temp.data=-1;
        
        if(r==null)
            return 0;
            
        Queue<Node> q=new LinkedList();
        
        q.add(r);
        q.add(temp);
        
        while(!q.isEmpty())
        {            
            while(!q.isEmpty())
            {
                Node p=q.remove();
                                 
                if(p.data==-1)
                {
                    count++;
                    break;
                }
                else
                {
                    if(p.left!=null)
                     q.add(p.left);
                    
                    if(p.right!=null)
                    q.add(p.right);
                }
            }
           
            if(!q.isEmpty())
            {
               // q.remove();
                q.add(temp);
            }
                
            
        }
        
        return count;        
    }
    
    // Postorder traversal 
    
    public void rPostOrder()
    {
        System.out.println("\nRecursive PostOrder traversal:");
        rPostOrder(root);
    }
    
    public void rPostOrder(Node r)   // LRV
    {
        if(r==null)
            return;
        
        rPreOrder(r.left);
         rPreOrder(r.right);
        System.out.print(r.data+"  ");        
       
    }
    
    // Preorder traversal 
    
    public void rPreOrder()
    {
        System.out.println("\nRecursive Preorder traversal :");
        rPreOrder(root);
    }
    
    public void rPreOrder(Node r)   // VLR
    {
        if(r==null)
            return;
       System.out.print(r.data+"  "); 
        rPreOrder(r.left);
        rPreOrder(r.right);
    }
    
    
    public void IPreOrder()
    {
        System.out.println("\nIterative Preorder traversal :");
        IPreOrder(root);
    }
    
     public void IPreOrder(Node r)
    {
       Stack<Node> s=new Stack();
       
       int preOrderIndex=0;
       
       s.push(r);
       
       while(!s.isEmpty())
       {
           Node p=s.pop();
           
           System.out.print(p.data+"  ");
           preOrder[preOrderIndex++]=p.data;  
           
            if(p.right!=null)
                s.push(p.right);
            
              if(p.left!=null)
                s.push(p.left);
         
       }
    }
    
     public void IinOrder()
    {
        System.out.println("\nIterative Inorder traversal :");
        IinOrder(root);
    }
     
    public void IinOrder(Node r)
    {
       Stack<Node> s=new Stack();
       
       int inOrderIndex=0;
       while(r!=null)
       {
           s.push(r);
           r=r.left;
       }
      
       while(!s.isEmpty())
       {
           Node p=s.pop();
           
           // System.out.println(" inOrderIndex = "+inOrderIndex);
           inOrder[inOrderIndex++]=p.data;
           
           
          System.out.print(p.data+"  ");
           
           Node t=p.right;
           
           if(t!=null)
               s.push(t);
           
           if(t!=null && t.left!=null)
               s.push(t.left);
       }
       
       System.out.println();
       
    }
    
       public void IPostOrder()
    {
        System.out.println("\nIterative Postorder traversal Using 2 stacks:");
        IPostOderUsing2Stack(root);
        
        System.out.println("\nIterative Postorder traversal Using 1 stack:");
        IPostOderUsing1Stack(root);
        
    }
    
    public void IPostOderUsing2Stack(Node r)
    {
        Stack<Node> children=new Stack();
       Stack<Node> ReversePostOrder=new Stack();
       // String val="";
        int px=0;
        
        children.push(r);
        
        while(!children.isEmpty())
        {
            Node t=children.pop();
          //  val=t.data+" "+val;
            
            ReversePostOrder.push(t);
            
            if(t.left!=null)
                children.push(t.left);
            if(t.right!=null)
                children.push(t.right);
            
        }
        
             // System.out.println(val);
        while(!ReversePostOrder.isEmpty())
        {
            //System.out.println("Check");
            int xp=ReversePostOrder.pop().data;
//            postOrder[px++]=xp;
            System.out.print(xp+"  ");
        }
        
    }
    
     public void IPostOderUsing1StackUsingString(Node r)
    {
        Stack<Node> children=new Stack();
       // Stack<Node> ReversePostOrder=new Stack();
        String val="";
        int px=0;
        
        children.push(r);
        
        while(!children.isEmpty())
        {
            Node t=children.pop();
            val=t.data+" "+val;
            
            //ReversePostOrder.push(t);
            
            if(t.left!=null)
                children.push(t.left);
            if(t.right!=null)
                children.push(t.right);
            
        }
        
              System.out.println(val);
//        while(!ReversePostOrder.isEmpty())
//        {
//            //System.out.println("Check");
//            int xp=ReversePostOrder.pop().data;
////            postOrder[px++]=xp;
//            System.out.print(xp+"  ");
//        }
        
    }
       
public void IPostOderUsing1Stack(Node rt)
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
        System.out.print(rt.data+"  ");
        rt=null;
    }
    
}while(!s1.isEmpty());
  
     
}
    
    public void LevelOrder()
    {
        System.out.println("\nLevel Order traversal using 1 queue:");
        LevelOrderUsingQueue(root);
    }

     Queue<Node> tempArrayForQueue = new LinkedList();
    public void LevelOrderUsingQueue(Node r)
    {
        if(r==null)
            return;
        
       
        Queue<Node> q=new LinkedList();
        
        q.add(r);
        tempArrayForQueue.add(r);
        while(!q.isEmpty())
        {
            Node p=q.remove();
            
            System.out.print(p.data+"  ");
            
             if(p.left!=null)
             {
                 q.add(p.left);
                  tempArrayForQueue.add(p.left);
             }
             
            if(p.right!=null)
            {
                q.add(p.right);
                 tempArrayForQueue.add(p.right);
            }
           
            
        }
    }
    
    public void LevelOrderUsing2Stack(Node r)
    {
        if(r==null)
            return;
        
        Stack<Node> s1=new Stack();
        Stack<Node> s2=new Stack();
        
        s1.push(r);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                Node t=s1.pop();
                System.out.print(t.data+"  ");
                
                if(t.right!=null)
                    s2.push(t.right);
                
                if(t.left!=null)
                    s2.push(t.left);                
            }
            
            while(!s2.isEmpty())
            {
                Node t=s2.pop();
                System.out.print(t.data+"  ");
                
                if(t.right!=null)
                    s1.push(t.right);
                
                if(t.left!=null)
                    s1.push(t.left);                
            }
            
        }
        
    }
    
    public void MaximumElement()
    {
        // performing preorder traversal
        System.out.print("\nMaximum element = "+findMaxUtil(root).data);
        
    }
    
    public Node findMaxUtil(Node r)
    {
        if(r==null)
            return null;
        
       while(r.right!=null)
       {
           r=r.right;
       }
        
        return r;
    }
    
    public void searchElement(int s)
    {
        if(searchElementUtil(root,s))
         System.out.println("\n"+s+ " found");
        else
         System.out.println("\n"+s+ " NOT found");
    }
       
    public boolean searchElementUtil(Node r,int s)
    {
        if(r==null)
            return false;
        
        if(r.data==s)    
            return true;
        
        if(s<r.data)
            return searchElementUtil(r.left, s);
        else if(s>r.data)
            return searchElementUtil(r.right, s);
        
        return false;       
        
    }
    
    public void sizeOfTree()
    {
        System.out.println("\nSize of Binary Tree= "+sizeOfTree(root));
    }
    public int sizeOfTree(Node t)
    {
        if(t!=null)
        {
            return 1+sizeOfTree(t.left)+sizeOfTree(t.right);
        }
        else
            return 0;
    }
    
    public void SpiralOrderTraversal()
    {
       System.out.println("\nSpiral Order traversal(Iterative):");
       Spiral2Stack(root);  
       
       System.out.println("\nSpiral Order traversal(Recursive):");
       SpiralOrder_recursive(root);
    }
  
public void Spiral2Stack(Node root)
{
    Stack s=new Stack();
    Stack q=new Stack();

    if(root!=null)
        s.push(root);
    else
        return;
    
    while(!s.isEmpty() || !q.isEmpty())
    {
        while(!q.isEmpty())
        {
            Node x=(Node) q.pop();
            System.out.print(x.data+"  ");

            if(x.left!=null)
                s.add(x.left);

            if(x.right!=null)
                s.add(x.right);
        }

        while(!s.isEmpty())
        {
            Node x=(Node) s.pop();
            System.out.print(x.data+"  ");

            
            if(x.right!=null)
                q.add(x.right);

            if(x.left!=null)
                q.add(x.left);
        }
    }
}
    
    public void SpiralOrder_recursive(Node r)
    {
        if(r==null)
            return;
        
        int ht=getHeight(r);
        
        int reverse=1;
        for(int i=0;i<=ht;i++)
        {
            printGivenLevel(r,i,reverse);
            
            reverse=(reverse+1)%2;
            
        }
    }
    public void printGivenLevel(Node r,int ht,int reverse)
    {
        if(r==null)
            return;
        
        if(ht==0)
        {
            System.out.print(r.data+"  ");
            return;
        }
        
        if(reverse==1)
        {
            printGivenLevel(r.right,ht-1,reverse);
            printGivenLevel(r.left,ht-1,reverse);
        }
        else if(reverse==0)
        {
            printGivenLevel(r.left,ht-1,reverse);
            printGivenLevel(r.right,ht-1,reverse);
        }
        
    }
    
    public void ReverseLevelOrder()
    {
        System.out.println("\nReverse level Order traversal(Iterative):");
        ReverseLevelOrder(root);
        
        System.out.println("\nReverse level Order traversal(Recursive):");
        ReverseLevelOrder_recursive(root);
    }
     
    
    // Recusrive version
    // New learning
     public void ReverseLevelOrder_recursive(Node r)
    {
        if(r==null)
            return;
        
        int ht=getHeight(r);

        for(int i=ht;i>=0;i--)
        {
            printGivenLevel(r,i);
        }
    }

    public void printGivenLevel(Node r,int ht)
    {
        if(r==null)
            return;
        
        if(ht==0)
        {
            System.out.print(r.data+"  ");
            return;
        }
    
            printGivenLevel(r.left,ht-1);
            printGivenLevel(r.right,ht-1);
        
    }
    
    public void ReverseLevelOrder(Node t)
    {
        Queue<Node> q=new LinkedList();
        Stack<Node> s=new Stack();
        
        if(t!=null)
            q.add(t);
        
        while(!q.isEmpty())
        {
            Node x=q.remove();
            s.push(x);
            
            if(x.right!=null)
                q.add(x.right);
            
            if(x.left!=null)
                q.add(x.left);
            
        }
        
        while(!s.isEmpty())
        {
            System.out.print(s.pop().data+"  ");
        }
    }
    
    public void diameter()
    {
        System.out.println("\nDiameter in different Recursion = "+diameter_different_recursion(root));
        
        System.out.println("\nDiameter in same Recursion = "+diameter_same_recursion(root)); 

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
    System.out.println("\nDeepest Node in Binary Tree="+t.data);
} 
   
// finding diameter on my own 
public int diameter_different_recursion(Node root)
{
    if(root==null)
        return 0;
    
    int l=getHeight(root.left); 
    int r=getHeight(root.right);
 
    
    int ldiameter=diameter_different_recursion(root.left);
    int rdiameter=diameter_different_recursion(root.right);   
     
    
    return Math.max(l+r+1, Math.max(ldiameter,rdiameter));
   
}

 int datatracker=-1;
public int diameter_same_recursion(Node root)
{
   // MaxLengthSoFar ob=new MaxLengthSoFar();
    getDiameter(root);
   
    return datatracker; //ob.getMaxLength();    
}

private int getDiameter(Node root)
{ 
    if(root==null)
        return 0;
    
    int hieghtLch=getDiameter(root.left); 
    int heightRch=getDiameter(root.right);


        if((hieghtLch+heightRch+1)>datatracker)
        {
            datatracker=hieghtLch+heightRch+1;
            //dataTracker.setMaxLength(hieghtLch+heightRch+1); 
           // dataTracker.setNode(root); 
        } 
        return (hieghtLch>heightRch?hieghtLch:heightRch)+1;
}

    
    public void printPathRootToLeaf()
    {
        System.out.println("\nAll paths from root to leaf (Recursive): \n");
        
        int maxHeight=getHeight(root);
        int path[]=new int[maxHeight];
                
        printPathRootToLeafUtil(root,path,0);
        
        
        System.out.println("\nAll paths from root to leaf (Iterative): \n");
        IterativeRoot2Leaf(root);
    }
    
 public static void IterativeRoot2Leaf(Node root) 
{
    if (root == null) 
    {
        return;
    }

    Queue<Object> q = new LinkedList();
    q.add(root);
    q.add(root.data + " ");

    while(!q.isEmpty()){

        Node head = (Node) q.remove();
        String headPath = (String) q.remove();

        if(head.left==null && head.right==null){
            System.out.println(headPath);
            continue;
        }

        if(head.left!=null){
            String leftStr =  headPath + "  " + head.left.data;
           //  System.out.println(leftStr);
            q.add(head.left);
            q.add(leftStr);
        }

        if(head.right!=null){
            String rightStr =  headPath + "  " + head.right.data;
             // System.out.println(rightStr);
            q.add(head.right);
            q.add(rightStr);
        }
    }


}
    
    public void printPathRootToLeafIterative(Node r)
    {
        if(r==null)
            return;       
        int i=0;
        
        Queue<Node> q=new LinkedList();  // for performing level order traversal
        
        String[] s=new String[256]; // for holding the strings
        
        s[i]=Integer.toString(r.data);
        q.add(r);
        i++;
        
        // performing level order traversal
        while(!q.isEmpty())
        {
            Node t= q.remove();
            
            
            
            
        }
        
        
    }
    
    public void printPathRootToLeafUtil(Node r,int path[],int h)
    {
        if(r==null)
            return;
        
         path[h]=r.data;
         
        if(r.left==null && r.right==null)
        {           
            printPaths(path,h);
        }
        
        else if(r.left!=null && r.right==null)
        {
           // printPaths(path, h);
            printPathRootToLeafUtil(r.left, path, h+1);
        }
        else if(r.left==null && r.right!=null)
        {
           // printPaths(path, h);
            printPathRootToLeafUtil(r.right, path, h+1);
        }
        else if(r.left!=null && r.right!=null)
        {
            printPathRootToLeafUtil(r.left, path, h+1);
            printPathRootToLeafUtil(r.right, path, h+1);
        }
    }
    
    
   //--------------------------------------------
// Source: https://github.com/monkeylyf/interviewjam/blob/master/tree/Remove_All_Nodes_Do_Not_Lie_In_Any_Path_With_Sum_More_Than_K.java
    public static void prune(Node root, int k)
    {
        intWrapper sum = new intWrapper(0);
        pruneUtil(root, k, sum);
    }

    public static Node pruneUtil(Node root, int k, intWrapper sum) 
    {
    if (root == null) 
    {
        return null;
    }

    // Post-order traversal.
    intWrapper left = new intWrapper(sum.val + root.data);
    intWrapper right = new intWrapper(sum.val + root.data);

    root.left = pruneUtil(root.left, k, left);
    root.right = pruneUtil(root.right, k, right);

    // After the recursion finished, left reprensents the max path value
    // from the root of this root to curNode.left to every leaf.

    // Max path value passing this node.
    sum.val = Math.max(left.val, right.val);

        if (sum.val < k) 
        {
        root = null; // Eliminated.
        }
    return root;

}
    
    
    //--------------------------------------------
    
  /*  
    public Node deletePathslessSum(Node root,int k)
    {
        int sum=0;
        return deletePathslessSumUtil(root,k,sum);
    }
    
    // the main function to truncate the tree
    public Node deletePathslessSumUtil(Node root,int k,int sum)
    {
        // base case
        if(root==null)
            return null;
        
        
    // Initialize left and right sums as sum from root to
    // this node (including this node)
      int lsum=sum+root.data;
      int rsum=lsum;
        
      // Recursively prune left and right subtrees
      root.left=deletePathslessSumUtil(root.left,k,lsum);
      root.right=deletePathslessSumUtil(root.right,k,rsum);
      
      // get the maximum of left and right sums
      sum=Math.max(lsum, rsum);
      
      // If maximum is smaller than k, then this node
    // must be deleted
      if(sum<k)
      {
          root.data=-1;
      }
      return root;
    }
    
    public void rInOrderModifed(Node r)
    {
        if(r==null) return;
        
        if(r.data!=-1)   
        {
            rInOrder(r.left);
            System.out.print(r.data+"  ");
            rInOrder(r.right);   
        }
        //inOrder[inOrderCounter++]=r.data;
        
        
    }
    */
    public void mirrorOfBinaryTree()
    {    
        
     // mirrorInSameBinaryTree(root);
        
       //   System.out.println("\nLevel order traversal of Tree");
       //   LevelOrderUsingQueue(root);
          
          Node mirrorRoot= mirrorInDifferentBinaryTree(root);
          
         System.out.println("\nLevel order traversal of Mirror Image");
          LevelOrderUsingQueue(mirrorRoot);
    }
    
     public void mirrorInSameBinaryTree(Node r)
     {
         if(r==null)
             return;
         
         mirrorInSameBinaryTree(r.right);
         mirrorInSameBinaryTree(r.left);   
         
         Node temp=r.getRight();
         
         r.setRight(r.getLeft());
         r.setLeft(temp);     
     }
    
     
      public Node mirrorInDifferentBinaryTree(Node r)
     {
         if(r==null)
             return r;
         
         Node temp=new Node();          
         temp.data=r.data;
          
          temp.right=mirrorInDifferentBinaryTree(r.left);
         temp.left=mirrorInDifferentBinaryTree(r.right);
         
         return temp;
         
     }
     
   
    
    public void printAncestorsOfNode()
    {     
        int maxHeight=getHeight(root);
        int path[]=new int[maxHeight];
        int Value=17;        
        System.out.println("\nAncestors of Node = "+ Value+" (Recursive):");
        printAncestorsOfNode(root,path,0,Value);

    }
    
    public void printAncestorsOfNode(Node r,int path[],int h,int Value)
    {
        if(r==null)
            return;
        
         path[h]=r.data;
         
         if(path[h]==Value)
         {
             printPaths(path, h-1);
             return;
         }
         
        if(r.left==null && r.right==null)
        {           
            return ; //printPaths(path,h);
        }
        
        else if(r.left!=null && r.right==null)
        {
          //  printPaths(path, h);
            printAncestorsOfNode(r.left, path, h+1,Value);
        }
        else if(r.left==null && r.right!=null)
        {
           // printPaths(path, h);
            printAncestorsOfNode(r.right, path, h+1,Value);
        }
        else if(r.left!=null && r.right!=null)
        {
            printAncestorsOfNode(r.left, path, h+1,Value);
             printAncestorsOfNode(r.right, path, h+1,Value);
        }
    }
    
       
    public void find_LCA()
    {
        Node p1=new Node(); 
        p1.data=4;
        Node p2=new Node(); 
        p2.data=7;
    System.out.println("\n(BottonUp)LCA of "+p1.data +" and " +p2.data+ " = "+ LCAbottomUp(root, p1,p2).data);
        
   System.out.println("\n(Inorder + Postorder)LCA of "+p1.data +" and " +p2.data+ " = "+ findLCA_Inorder_PostOrder(root, p1, p2));
    }
    
      public Node LCAbottomUp(Node root,Node p, Node q)
    {
        if(root==null|| p==null || q==null) 
            return null;
       
        if(root.data==p.data||root.data==q.data) 
            return root;
        
        Node l=LCAbottomUp(root.left,p,q);
        Node r=LCAbottomUp(root.right,p,q);
        
        // if p is one side and q are on other sides
        if(l!=null && r!=null) 
            return root;
        
        // either one of p,q is on one side OR p,q is not in L&R subtrees
        return l!=null?l:r;
        
    }
      
     public int findLCA_Inorder_PostOrder(Node root,Node p,Node q)
     {
         if(root==null || p==null || q==null)
             return -1;
       
          
         IinOrder(root);
         IPostOderUsing2Stack(root);
         
         int pIndex=search(inOrder,0,inOrder.length,p.data);
         int qIndex=search(inOrder,0,inOrder.length,q.data);
         
         int minVal=Integer.MIN_VALUE;
         
         if(pIndex<qIndex) // q is greater than p
         {
             for(int i=pIndex;i<=qIndex;i++)
             {
                 int f=search(postOrder, 0, postOrder.length, inOrder[i]);
                 if(f>minVal)
                 {
                     minVal=f;
                 }
             }
             
         }
         else
         {
              for(int i=qIndex;i<=pIndex;i++)
             {
                 int f=search(postOrder, 0, postOrder.length, inOrder[i]);
                 if(f>minVal)
                 {
                     minVal=f;
                 }
             }
             
         }
         
         return postOrder[minVal];
     }
      
     public void verticalSum()
     {
         System.out.println("\nVertical Sum: ");
         
         verticalSumWrapper(root);
     }

     
     public void verticalSumWrapper(Node r)
     {
         // base case
         if(r==null)
             return;
         
         // Create an empty HashMap hM
         HashMap<Integer,Integer> hm=new HashMap();
         
         // calls the vertical sum to store values of vertical sum 
         verticalSumUtil(r,0,hm);
         
         //prints the values stored by verticalutil
         if(hm!=null)
         {
             System.out.println(hm.entrySet());
         }
     }
     // finding the vertical sum
     public void verticalSumUtil(Node r,int hD,HashMap<Integer,Integer> hm)
     {
        
         if(r==null)
             return;
         
         // store vertical sum of left subtree
         verticalSumUtil(r.left, hD-1, hm);
         
         // update vertical sum for hD for this node
         int prevSum=(hm.get(hD)==null)?0:hm.get(hD);
         hm.put(hD, prevSum+r.data);
         
         // store vertical sum of right subtree
         verticalSumUtil(r.right, hD+1, hm);
         
     }
   
    
     
     
    public void printPaths(int[] p,int ht)
    {
        for(int i=0;i<=ht;i++)
            System.out.print(p[i]+"  ");
        
        System.out.println();
    }

    
    public void constructBT()
    {        
//        int inOrderT[]={2 , 3 , 4 , 6 , 7 , 9 , 13 , 15 , 16 , 17  ,18  ,20 };
//        int[] preOrderT={15 , 6  ,3  ,2 , 4 , 7 , 13 , 9 , 16 , 18 , 17 , 20 };
//Node rootConstructed=constructBT_Preorder_Inorder(inOrderT,preOrderT,0,inOrder.length-1);
//        
//       System.out.println("\nLevel Order traversal of constructed Tree:");
//         LevelOrderUsingQueue(rootConstructed);
         
          int preOrder2[]={1,2,4,5,3,6};
         int postOrder2[]={4,5,2,6,3,1};
         
         Node FullBT_Preorder_Postorder = construct_FullBT_Preorder_Postorder(preOrder2,postOrder2,0,preOrder2.length-1);
          
       System.out.println("\nLevel Order traversal of constructed Full BT Tree:");
        LevelOrderUsingQueue(FullBT_Preorder_Postorder);
//
//        System.out.println("\nInOrder traversal of constructed Complete BT Tree:");
//        rInOrder(FullBT_Preorder_Postorder);
        
    }
    
    int preIndex_Preorder_Inorder_BT=0;
  
    public Node constructBT_Preorder_Inorder(int[] in,int[] pre,int s,int e)
    {        
        if(s>e || s==in.length)
            return null;
        
        Node t=new Node();
                        
        t.data=pre[preIndex_Preorder_Inorder_BT++];

        
        if(s==e)
            return t;
        
       // System.out.println("s = "+s+" e = "+e);
        // search this data in Inorder array
        int InIndex=search(in,s,e,t.data);
        
        t.left=constructBT_Preorder_Inorder(in, pre, s, InIndex-1);
        t.right=constructBT_Preorder_Inorder(in, pre, InIndex+1, e);
        
        return t;
    }
  
    int preIndex_Preorder_Postorder_CBT=0;
    
    
public Node construct_FullBT_Preorder_Postorder(int[] pre,int[] post,int s,int e)
{        
    if(s>e || s==post.length || preIndex_Preorder_Postorder_CBT==post.length)
        return null;

    Node t=new Node();

    t.data=pre[preIndex_Preorder_Postorder_CBT];

    preIndex_Preorder_Postorder_CBT++;
    if(s==e)
        return t;

    // search this data in Inorder array
    int postIndex=search(post,s,e,t.data);

  //  System.out.println("PostIndex= "+postIndex);
    t.left=construct_FullBT_Preorder_Postorder(pre, post,s, postIndex);
    t.right=construct_FullBT_Preorder_Postorder(pre, post, postIndex+1, e);

    return t;
}
  
    public int search(int a[],int s,int e,int d)
    {
        for(int i=s;i<=e;i++)
        {
            if(a[i]==d)
            {
                return i;
            }
        }
        
        return -1;
    }

    public Node getPredecessor(int key)
    {
        return InOrderpredecessor(root,key,null,null);

    }
    
    public void printPredecessor(int key)
    {
        Node pred=InOrderpredecessor(root,key,null,null);
       
        if(pred==null)
            System.out.println("\nPredecessor of "+key+" = NULL");
        else
            System.out.println("\nPredecessor of "+key+" = "+pred.data);
        
        
        
    }
    
    public void printSuccessor(int key)
    {
        System.out.print("\nMethod 1: ");
          System.out.print("\nSuccessor of "+key+" = ");
          
          Node p=inOrderSuccesorIterative(key);
          
          if(p==null)
              System.out.println(" null");
          else
              System.out.println(p.data);
        
          System.out.print("\nMethod 2: ");
           System.out.print("\nSuccessor of "+key+" = ");
          Node p_mine=inOrderSuccesorIterative2(key);
          
          if(p_mine==null)
              System.out.println(" null");
          else
              System.out.println(p_mine.data);
    }
    
    
    public Node inOrderSuccesorIterative2(int key)
    {
        
        // finding the key in the tree
        Node t=root;
        Stack<Node> s=new Stack();
        
        while(t!=null)
        {
            if(t.data==key)
                break;
            
            else if(t.data<key)
            {
                s.push(t);
                
                if(t.right!=null)
                    t=t.right;
                else
                    t=null;
            }
            else
            {
                s.push(t);

                if(t.left!=null)
                    t=t.left;
                else
                    t=null;
            }
        }
        
        if(t==null) return null;
        
        // Now the stack contains the all previous parents
        if(t.right!=null)
        {
            t=t.right;
            
            while(t.left!=null)
            {
               t=t.left;
            }
            return t;
        }
        
        else // go upwards for parents
        {
            Node p=s.pop();
            
            if(p.left!=null && p.left.data==t.data)
            {
                return p;
            }
            else  // t is p's right child --> find first grandparent with parent as left child
            {
              //  Node pa,gp;
                while(!s.isEmpty())
                {
                    Node gp=s.pop();

                    if(gp.left.data==p.data)
                    {
                        return gp;
                    }
                    p=gp;
                    
                }                   
                    return null;
            }
        }
    }

   
     public int countNodes()
     {
         int i=0;
         Node t=root;
         
         while(t!=null)
         {
             t=t.right;
             i++;
         }
         return i;
     }
    

    public void printCDLL(Node h)
    {
        Node t=h;
        
        do
        {
             System.out.print(h.data+"  ");
             h=h.right;
        }while(h!=t);
    }
    
   public void printDLL(Node h)
    {
        while(h!=null)
        {
             System.out.print(h.data+"  ");
             h=h.right;
        }
    }  

    // required to find predeccessor Node of key
    public Node InOrderpredecessor(Node r,int key,Node parent,Node grandParent)
    {
       if(r==null)
            return null;
       
       if(key<r.data)
       {
           return InOrderpredecessor(r.left, key, r, parent);
       }
       else if(key>r.data)
       {
           return InOrderpredecessor(r.right, key, r, parent);
       }
       
       else
       {
           // Case 1: when r has left subtree --> get maximum of left subtree 
           // Coming Down
           if(r.left!=null)
           {
               Node lChild=r.left;
               
               while(lChild.right!=null)
               {
                   lChild=lChild.right;
               }
               return lChild;
           }
           // Case 2: when r does NOT have left child--> return grandparent;
           else  
           {
               if(parent.left.data==key)
               {
                   if(parent.data==grandParent.right.data)
                        return grandParent;
                   
// This condition will happen only when r is the left most Node of the tree .                    
//  In this case root parent and grandparent are in same alingment                  
                   else
                       return null; 
               }
               else
               {
                   return parent;
               }
           }
       }
        
    }

   public Node inOrderSuccesorIterative(int key)
   {
        Stack< Node> s = new Stack();
        Node temp = root;

        while(true)
        {
                while(temp!=null)
                {
                        s.push(temp);
                        temp = temp.left;
                }
                if(s.isEmpty())
                {
                        break;
                }
                temp = s.pop();
                if(temp.data==key)
                {
                        if(temp.right==null)
                        {
                                if(!s.isEmpty())
                                {
                                    return s.peek();
                                //System.out.print(s.peek().data+"    ");
                                }
                                else
                                {
                                    return null;
                                        //System.out.print("Does not Exist    ");
                                }
                        }
                        else
                        {
                                Node temp2 = temp.right;
                                Node prev = temp2;
                                while(temp2!=null){
                                        prev = temp2;
                                        temp2 = temp2.left;
                                }
                                return prev;
                                //System.out.print(prev.data+"    ");
                        }

                }
                temp = temp.right;
        }
        return null;
}
   
public void InorderMorris()
{
    System.out.println("\nMorris Inorder traversal-");
    InorderMorrisUtil(root);
}
   
public void InorderMorrisUtil(Node root)
{
    Node current,prev;
    
    if(root==null)
        return;
    
    current=root;
    
    while(current!=null)
    {
        if(current.left==null)
        {
            System.out.print(current.data+"  ");  
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
                System.out.print(current.data+"  ");
                current=current.right;
            }
        }
    }
}
   
 
public void PreorderMorris()
{
     System.out.println("\nMorris Preorder traversal-");
    MorrisPreorderUtil(root);
}

public void MorrisPreorderUtil(Node root)
{
    if(root==null)  return;
    
     while (root!=null)
    {
        // If left child is null, print the current node data. Move to
        // right child.
        if (root.left == null)
        {
            System.out.print(root.data+"  ");
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
                System.out.print(root.data+"  ");
                current.right = root;
                root = root.left;
            }
        }
    }
}

public void isBST(Node r)
{
    if(isBSTUtil_min_max(r,Integer.MIN_VALUE,Integer.MAX_VALUE))
    {
        System.out.println("\nBT is BST");
    }
    else
    {
        System.out.println("\nBT is NOT BST");
    }
}
   
// Action : Cheated try 1.
// Result: Success
// Future: ----
   public boolean isBSTUtil_min_max(Node r,int min,int max)  
   {
       if(r==null) 
           return true;
       
       if(r.data<min) return false;
       
       if(r.data>max) return false;
       
       return isBSTUtil_min_max(r.left, min, r.data) && isBSTUtil_min_max(r.right, r.data,max);
   }
   
   
// Action : My own try 2.
// Result: Failed
// Future: Will try again
    public boolean isBSTUtil(Node r,Node parent,Node grandParent)
    {
        
        if(r==null)
            return true;
        
        // when root is r
       if(parent==null && grandParent==null)
       {
           return (isBSTUtil(r.left,r,r) && isBSTUtil(r.right,r,r));
       }
        
    if(parent.data==grandParent.data)
    {
        return isBSTUtil(r.left,r,parent) && isBSTUtil(r.right,r,parent);
    }
            
      // left subtree
       if(r.left!=null && r.right==null)
       {
        
           if(r.left.data<r.data && r.left.data<grandParent.data)
           {
               
                if(parent.data==grandParent.left.data)
                 return isBSTUtil(r.left,r,parent);
               
               else if((parent.data==grandParent.right.data))
                   return isBSTUtil(r.left,r,grandParent);
           }
           else
               return false;
       }
       // right subtree
      else if(r.left==null &&r.right!=null)
       {
           if(r.right.data>r.data && r.right.data>grandParent.data)
           {                 
                  if(parent.data==grandParent.left.data)
                 return isBSTUtil(r.right,r,grandParent);
               
               else if((parent.data==grandParent.right.data))
                   return isBSTUtil(r.left,r,parent);
           }
           else
               return false;
       }
       
       else if(r.left==null &&r.right==null)
            return true;
       
       else // when both left and right subtree are not null
       {
            if(r.left.data<r.data && r.left.data<grandParent.data && r.right.data>r.data && r.right.data>grandParent.data)
            {
             if(parent.data==grandParent.left.data)    
                    return isBSTUtil(r.left,r,parent) && isBSTUtil(r.right,r,grandParent);
            else if((parent.data==grandParent.right.data))      
                    return isBSTUtil(r.left,r,grandParent) && isBSTUtil(r.left,r,parent);
            }
            else
                return false;
       }
       
       return true;
    }
    
    
// Action : My own try 1.
// Result: Failed
// Future: NOT try again    
    public boolean isBSTUtil(Node r)
    {
        if(r==null) 
            return true;
        
       if(r.left!=null)
       {
           return (r.left.data<r.data)?true:false;
       }
       
       if(r.right!=null)
       {
           return (r.right.data>r.data)?true:false;
       }
       
       return (isBSTUtil(r.left) && isBSTUtil(r.right));
    }

    
    public void kthSmallestNode_kthLargestNode_()
    {
        Node sm=root;
        Node la=root;
        
        kthSmallestNodeUtil(sm);
        
        kthLargestNodeUtil(la);
    
    }
    
        int k=3,count=0;
        
    public void kthSmallestNodeUtil(Node r)
    {
        if(r==null)
        {
            return;
        }

        
         kthSmallestNodeUtil(r.left);
         
         count++;         
        
        if(count==k)
            System.out.println("\n"+k+"th smallest Node = "+r.data);
        
           kthSmallestNodeUtil(r.right);
            
        
    }
    
    int countLargest=0;
     public void kthLargestNodeUtil(Node r)
    {
        if(r==null)
        {
            return;
        }

        kthLargestNodeUtil(r.right);
        
         countLargest++;         
        
        if(countLargest==k)
            System.out.println("\n"+k+"th largest Node = "+r.data);
        
         kthLargestNodeUtil(r.left);
            
    }
     
     public void printRange()
     {
         int k1=6,k2=17;
         System.out.print("\nElements between "+ k1 +" - "+k2+ " = ");
         Node ro=root;
         printRangeUtil(ro,k1,k2);
     }
     
     public void printRangeUtil(Node r,int k1,int k2)
    {
        if(r==null)
        {
            return;
        }

        if(k1==r.data && r.data==k2)
             System.out.print(r.data+"  ");
        
        
        if(k1<r.data && r.data<k2)
        {
             System.out.print(r.data+"  ");
              printRangeUtil(r.left,k1,k2);
              printRangeUtil(r.right,k1,k2);
        }
        else if(k1<r.data && r.data>k2)
        {
              printRangeUtil(r.left,k1,k2);
        }
        else
        {
              printRangeUtil(r.right,k1,k2);
        }
            
    }
     
//     public void printtupleForSum(int sum)
//     {
//         
//         Node temp = root;
//         HashMap h = new HashMap<Integer,Integer>();
//         System.out.println("");
//        while(!tempArrayForQueue.isEmpty())
//        {
//            int l = tempArrayForQueue.remove().data;
//            
//            int r = sum-l;
//            
//            if(searchElementUtil(temp,r) && l!=h.get(r) )
//            {
//                System.out.println("sum :: " + sum + " l = " + l  +" r = " + r);
//                h.put(l, r);
//            }
//        }
//         
//         
//         
//     }
    
}



public class RevisionBST {

    public static void main(String[] args) {
       BinarySearchTree ob=new BinarySearchTree();
        
       Node root=ob.formRoot(15);
       
       ob.insertInBST(root,16);
       ob.insertInBST(root,18);
       ob.insertInBST(root,17);
       ob.insertInBST(root,20);
       ob.insertInBST(root,6);
       ob.insertInBST(root,7);
       ob.insertInBST(root,3);
       ob.insertInBST(root,13);
       ob.insertInBST(root,9);
       ob.insertInBST(root,2);
       ob.insertInBST(root,4);
       
       ob.LevelOrderUsingQueue(root);
//       ob.printtupleForSum(11);
       
       //ob.insertInBST(root,8);
     //  root.left.right.right.right=new Node();
      // root.left.right.right.right.data=25;
//       Node root=ob.formRoot(4);
//      
//        ob.insertInBST(root,2);
//        ob.insertInBST(root,1);
//        ob.insertInBST(root,3);
//        ob.insertInBST(root,6);
//        
//        ob.insertInBST(root,7);
//        ob.insertInBST(root,5);
//      ob.declareArray(ob.sizeOfTree(root));
      
      // System.out.println("Size = "+ob.inOrder.length);
        
//       ob.IinOrder();
         
    //  ob.rInOrder();
      // ob.printArray();
      // ob.isStrictTree();
     // ob.getHeight();
        
    
     //  ob.IPreOrder();
    
  //      ob.rPostOrder();
     //  ob.IPostOrder();
    //   ob.LevelOrder();
      //ob.MaximumElement();
//         ob.searchElement(7);
        //  ob.sizeOfTree();
//     ob.SpiralOrderTraversal();
      // ob.ReverseLevelOrder();
  //    ob.diameter();
     //   ob.deepestNode(root);
//        ob.printPathRootToLeaf();
      
//---------------------------------------------------------      
      //System.out.println(root.data);  
        System.out.println("");
       int k=29;
       ob.prune(root, k);
       ob.LevelOrder();
//       ob.LevelOrderUsing2Stack(root);
     //   root=ob.deletePathslessSum(root, k);
        
       //ob.rInOrderModifed(root);
       
       
  ///------------------------------------------------     
        
      // ob.mirrorOfBinaryTree();
        
         //  ob.constructBT();
      // ob.printAncestorsOfNode();
     // ob.find_LCA();
         //  ob.verticalSum();
     
   //  ob.printSuccessor(20);
//     ob.InorderMorris();
//      ob.rPreOrder();
//     ob.PreorderMorris();
//      //ob.isBST(root);
       
     // ob.printPredecessor(20);
    //  System.out.println("Check ----");
     // ob.kthSmallestNode_kthLargestNode_();
     //ob.printRange();
    }
}
