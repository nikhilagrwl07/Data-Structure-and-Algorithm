
package avltree;

class Node
{
    int key;
    Node prev=null;
    Node next=null;
    int height=0;   // new node is initially added at the leaf
    
    public Node()
    {
        
    }
     
    public void newNode(int k)
    {
        this.key=k;
        height=1;
    }

}
class operations
{
    // Getting height attribute of the node
   public int height(Node N)
    {
        if (N == null)
            return 0;
        return N.height;
    }
   
   // get the balance factor of Node N
   public int getBalance(Node N)   
   {
       if(N==null)
           return 0;
       return height(N.prev)-height(N.next);
   }
   
   // A utility function to right rotate subtree rooted with y
   public Node rightRotate(Node y)   
   {
       Node x=y.prev;
       Node T2=x.next;
       
       // perform rotation
       x.next=y;
       y.prev=T2;
       
       // Update heights
       y.height=Math.max(height(y.prev), height(y.next))+1;
       x.height=Math.max(height(x.prev), height(x.next))+1;
       
       // return new root;
       return x;
   }
   
   
     // A utility function to left rotate subtree rooted with x
   public Node leftRotate(Node x)   
   {
       Node y=x.next;
       Node T2=y.prev;
       
       // perform rotation
      y.prev=x;
      x.next=T2;
       
       // Update heights
       
       x.height=Math.max(height(x.prev), height(x.next))+1;
       y.height=Math.max(height(y.prev), height(y.next))+1;
       
       // return new root;
       return y;
   }  
   
    
    public Node insert(Node node,int key)
    {
        //1. Perform normal BST rotation
        if(node==null)
        {
            Node t=new Node();
            t.newNode(key);
             return t;
            //node.newNode(key);
        }
        if(key<node.key)
        {
            node.prev=insert(node.prev,key);
        }
        else
        {
             node.next=insert(node.next,key);
        }
        
        //2. Update the height of this ancestor node
        node.height=Math.max(height(node.prev),height(node.next))+1;
        
        // 3. Get the balance factor of this ancestor node to check whether this node bacame unbalanced
        int balance=getBalance(node);
        
        // If this node becomes unbalanced, then there are 4 cases
        
        //Case 1: Left Left Case
        if(balance>1 && key<node.prev.key)
            return rightRotate(node);
        
       //Case 2: Right right Case
        if (balance < -1 && key > node.next.key)
          return leftRotate(node);
        
          //Case 3: Left Right Case
        if (balance > 1 && key > node.prev.key)
        {        
         node.prev =  leftRotate(node.prev);
         return rightRotate(node);
        }
        
            // Right Left Case
        if (balance < -1 && key < node.next.key)
        {
            node.next= rightRotate(node.next);
            return leftRotate(node);
        }

    // return the (unchanged ) node pointer
    return node;
    }
    
    public void preOrder(Node t)
    {
        if(t==null) return;
        System.out.print(t.key+"  ");
        preOrder(t.prev);
        preOrder(t.next);
        
    }
    
}

public class AVLTree {

    public static void main(String[] args) {
        /* The constructed AVL Tree would be
            30
           /  \
         20   40
        /  \     \
       10  25    50
  */       
        operations op=new operations();
        Node root=null;
        root = op.insert(root, 10);
        root = op.insert(root, 20);
        root = op.insert(root, 30);
        root = op.insert(root, 40);
        root = op.insert(root, 50);
        root = op.insert(root, 25);
        
        System.out.println("Preorder Traversal of constructed AVL tree is: ");
        op.preOrder(root);
    }
}
