
package Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.lang.Math.*;

public class Tree {

    public static void main(String[] args) {
       BinaryTreeOperation obj = new BinaryTreeOperation();
       Node root=new Node(1);
       obj.insert(root,2);
       obj.insert(root,3);
       obj.insert(root,4);
       obj.insert(root,5);
       obj.insert(root,6);
       obj.insert(root,7);
       obj.insert(root,8);
    //   obj.insert(root,9);
     //  obj.insert(root,10);
       System.out.println("Recursive inorder traversal ::: ");
       obj.rInOrder(root);
       
       obj.printSprialFormat(root);

//       System.out.println("\nIterative inorder traversal ::: ");
//       obj.itrInOrder(root);
//       System.out.println("\nRecursive Preorder traversal ::: ");
//       obj.rPreOrder(root);
//       System.out.println("\nIterative Preorder traversal ::: ");
//       obj.itrPreOrder(root);
//       System.out.println("\nRecursive Postorder traversal ::: ");
//       obj.rPostOrder(root);
//       System.out.println("\nIterative Postorder using 1 stack::: ");
//       obj.itrPostOrder1stack(root);
//       System.out.println("\nIterative Postorder using 2 stack::: ");
//       obj.IpostOrder2stacks(root);

      //  System.out.println("\nHeight :: "+obj.height(root));
      //  System.out.println("\ndiameter :: "+obj.diameter(root));
       // obj.diameterInSameRecursion(root);
//       System.out.println("\nLevel Order traversal using 1 queue");
//       obj.levelOrderUsing1Queue(root);
// System.out.println("\nLevel Order traversal using 2 stack");
//       obj.levelOrderUsing2Stack(root);
            //System.out.println("\nMax element in BT :: "+  obj.maxElementInBT(root));

      // System.out.println("\nLevel Order traversal using height :: ");
          //  obj.levelOrderUsingHeight(obj.height(root), root);
       //obj.inOrderSuccessor(root,7);
 // TODO ::  PreOrder Successor
    }
}

class BinaryTreeOperation
{
    Node root;
     Queue<Node> queue=new LinkedList();
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
                       return;
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


     // in order successor in BT
     public void inOrderSuccessor(Node root, int key){

        Node inOrderSuccessor = inOrderSuccessorUtil(root, key, null);
        if(inOrderSuccessor==null)
            System.out.println("\nInOrder Successor  of :: "+key + "  is :: null");
        else
            System.out.println("\nInOrder Successor  of :: "+key + "  is :: "+ inOrderSuccessor.value);
     }

     public Node inOrderSuccessorUtil(Node root, int key , Node parent){

         // Case 1
         if(root==null)
            return null;

         // Case 2:
        else if(root.value==key){
            // Case 2.1
            if(root.right!=null)
                return findLeftMostNode(root.right);
            else // Case 2.2
                return parent;
        }
         // case 3:
        else
        {
            Node left = inOrderSuccessorUtil(root.left, key, root);
            if(left!=null) return left;

            return inOrderSuccessorUtil(root.right, key, parent);
        }

     }



     public int maxElementInBT(Node root){
         if(root==null) return Integer.MIN_VALUE;

         return Math.max(Math.max(maxElementInBT(root.left), maxElementInBT(root.right)),root.value);
     }

     public int height(Node root){
         if(root==null) return 0;

         return 1+ Math.max(height(root.left), height(root.right));

     }


     public void printSprialFormat(Node root){
         if(root==null) return ;

         Stack<Node> s1 = new Stack<Node>();
         Stack<Node> s2 = new Stack<Node>();

         System.out.println("\n Spiral Order Traversal :: ");
         // push the first level in s1
         s1.push(root);

         // keep printing while any of the stack is not empty
         while(!s1.isEmpty() || !s2.isEmpty()){
             // print the nodes of current Nodes from s1 and put next level in s2
             while(!s1.isEmpty()){
                 Node top = s1.pop();
                 System.out.print(top.value+ " ");
                 if(top.left!=null)
                     s2.push(top.left);
                 if(top.right!=null)
                     s2.push(top.right);

             }
             while(!s2.isEmpty()){
                 Node top = s2.pop();
                System.out.print(top.value+ " ");
                    if(top.right!=null)
                     s1.push(top.right);
                 if(top.left!=null)
                     s1.push(top.left);
             }
         }
     }

     public int diameter(Node root){
         if(root==null) return 0;
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);



         return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight+rightHeight+1);
     }

     public void diameterInSameRecursion(Node root){
         if(root==null)
             return ;

         MaxLengthForFar ob = new MaxLengthForFar();
         diameter_same_recursion_util(root, ob);

         System.out.println("diameter in same recursion ::"+ ob.getDiameter());

     }

     public int diameter_same_recursion_util(Node root, MaxLengthForFar ob){
         if(root==null)
             return 0;

         int leftDiameter = diameter_same_recursion_util(root.left, ob);
         int rightDiameter = diameter_same_recursion_util(root.right, ob);

         if(leftDiameter+rightDiameter+1 > ob.getDiameter())
         {
             ob.setDiameter(leftDiameter+rightDiameter+1);
             ob.setRoot(root);
         }
         return (leftDiameter>rightDiameter?leftDiameter:rightDiameter)+1;
     }



     public void levelOrderUsingHeight(int height , Node root)
     {
         for(int i=1;i<=height;i++)
         {
            printNodesAtGivenHeight(i, root);
         }
     }

     public void printNodesAtGivenHeight(int height, Node root){
         if(height==1) System.out.print(root.value+ " ");
         else
         {
             if(root.left!=null)
                printNodesAtGivenHeight(height-1,root.left);
             if(root.right!=null)
                printNodesAtGivenHeight(height-1,root.right);

         }


     }

     public void levelOrderUsing1Queue(Node root){
         if(root==null) return;

         Queue<Node> q= new LinkedList<Node>();
         q.add(root);

         while(!q.isEmpty()){

             Node front = q.remove();
             System.out.print(front.value+ " ");

             if(front.left!=null)
                 q.add(front.left);
             if(front.right!=null)
                 q.add(front.right);

         }

     }

     public void levelOrderUsing2Stack(Node root){
         Stack<Node> s1 = new Stack<Node>();
         Stack<Node> s2 = new Stack<Node>();

         s1.add(root);
         while(!s1.isEmpty()){

             while(!s1.isEmpty()){

                 root = s1.pop();
                 System.out.print(root.value+ " ");

                  if(root.left!=null)
                     s2.push(root.left);

                 if(root.right!=null)
                     s2.push(root.right);
             }
             while(!s2.isEmpty()){
                s1.push(s2.pop());
             }
         }
    }

     public void rInOrder(Node root)
     {
         if(root ==null)
             return;
         rInOrder(root.left);
         System.out.print(root.value+ " ");
         rInOrder(root.right);
     }


     public void itrInOrder(Node root){
         if(root==null) return;
         Stack<Node> s = new Stack<Node>();

         while(root!=null){
             s.push(root);
             root=root.left;
         }

         while(!s.isEmpty()){
             Node top = s.pop();
             System.out.print(top.value+" ");
             Node right = top.right;

             while(right!=null){
                 s.push(right);
                 right = right.left;

             }

         }

     }

     public void rPreOrder(Node root)
     {
         if(root ==null)
             return;

         System.out.print(root.value+ " ");
         rPreOrder(root.left);
         rPreOrder(root.right);
     }

    public void itrPreOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<Node>();
        s.push(root);

        while (!s.isEmpty()) {
            Node top = s.pop();
            System.out.print(top.value + " ");

            if (top.right != null) {
                s.push(top.right);
            }

            if (top.left != null) {
                s.push(top.left);
            }
        }
    }

    public void rPostOrder(Node root){
        if(root==null) return;

        rPostOrder(root.left);
        rPostOrder(root.right);
        System.out.print(root.value+ " ");

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
       System.out.print(x.value+" ");
//      postOrder[indexPostorder++]=x.value;

  }

}


    // Post order traversal using only 1 stack

    public void itrPostOrder1stack(Node root){
      if(root ==null)   return;

      Stack<Node> s = new Stack<Node>();
      s.push(root);

      do
      {
          // Step 1 : push right and then root to stack & make root as root.left
        while(root!=null){
            if(root.right!=null){
                s.push(root.right);
            }
            s.push(root);
            root=root.left;
        }

        // Step 2 :
        root = s.pop();
      //  Node rRight = s.peek();

        if(root!=null && !s.isEmpty() && root.right==s.peek()){
            Node rRight = s.pop();
            s.push(root);
            root=root.right;
        }
        else
        {
            System.out.print(root.value + " ");
            root=null;
        }

      }while(!s.isEmpty());

    }

    public Node findLeftMostNode(Node root) {
        Node temp = null;
        while (root != null) {
            temp = root;
            root = root.left;

        }
        return temp;

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

class MaxLengthForFar{
    int diameter;
    Node root;

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


}


