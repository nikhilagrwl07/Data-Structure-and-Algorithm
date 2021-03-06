package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Integer.MIN_VALUE;

public class BinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node temp2 = new Node(2);
        Node temp4 = new Node(4);
        Node temp6 = new Node(6);
        Node temp7 = new Node(7);

        Node temp3 = new Node(3);
        Node temp5 = new Node(5);
        Node temp8 = new Node(8);
        Node temp9 = new Node(9);

        //-------------------------------
        Node temp11 = new Node(11);
        Node temp12 = new Node(12);
        Node temp13 = new Node(13);
        Node temp14 = new Node(14);
        Node temp15 = new Node(15);
        //-------------------------------

        OperationOnBinaryTre obj = new OperationOnBinaryTre();

        obj.insert(root, 2);
        obj.insert(root, 3);
        obj.insert(root, 4);
        obj.insert(root, 5);
        obj.insert(root, 6);
        obj.insert(root, 7);
        obj.insertAtposition(root, temp7, 8);
        obj.insertAtposition(root, temp5, 10);
        obj.insertAtposition(root, temp6, 20);

        obj.insertAtposition(root, temp8, 9);
        obj.insertAtposition(root, temp8, 10);
//         obj.insertAtposition(root,temp5, 12);

//       System.out.println("Recursive Inorder traversal...");
//      obj.rInOrder(root);

//      System.out.println("\nIterative Inorder traversal...");

//       obj.IinOrder(root);

//       System.out.println();
//       System.out.println("Recursive Preorder traversal...");
//       obj.rPreOrder(root);
//       System.out.println();
//
//      System.out.println();
//       System.out.println("Iterative Preorder traversal...");
//       obj.IpreOrder(root);
//       System.out.println();

//       System.out.println();
//       System.out.println("Iterative PostOrder traversal using 2 stacks...");
//       obj.IpostOrder2stacks(root);
//       System.out.println();
//
//       System.out.println();
//       System.out.println("Copied iterative PostOrder traversal...");
//       obj.IpostOrder1stack(root);
//       System.out.println();
//
//       System.out.println("Iterative PostOrder traversal using 1 stack...");
//       obj.IpostOrder1stack(root);
//       System.out.println("\n Iterative PostOrder traversal using 1 stack copied from tushar...");
//       obj.postOrderItrOneStack(root);

//         System.out.println("Iterative Level Order traversal using 1 queue...");
//         obj.levelOrderQueue(root);
//         System.out.println();

//        System.out.println("Left view of binary tree using level order ...");
//       obj.leftViewUsingLevelOrder(root);
//       System.out.println();
//
//     System.out.println("Right view of binary tree using level order ...");
//       obj.rightViewUsingLevelOrder(root);
//       System.out.println();
//
//       System.out.println("Right view of binary tree using level order 2 ...");
//       obj.rightViewUsingLevelOrder2(root);
//       System.out.println();

//       System.out.println("Boundry order traversal ::: ");
//       obj.boundryOrderTraversal(root);
//       System.out.println();

//       System.out.println();
//       System.out.println("Iterative Level Order traversal using 2 stack...");
//       obj.levelOrder2Stacks(root);
//       System.out.println();


//       System.out.println();
//       System.out.println("Iterative Level Order traversal using 1 stack and 1 queue...");
//       obj.ReverselevelOrderStackQueue(root);
//       System.out.println();

//       System.out.println();
//       System.out.println("Maximum element of Binary Tree="+obj.findMax(root));
//       System.out.println();
//
//       System.out.println();
//       System.out.println("Maximum element of Binary Tree (second way)="+obj.findMaxSecondWay(root));
//       System.out.println();

//       System.out.println("height of Tree iteratively");
//       obj.iterativeHeight(root);
//       System.out.println();

//       System.out.println("printing tree using computed height");
//       obj.levelOrderUsingHeight(obj.computeHeight(root),root);
//       System.out.println();

//         System.out.println("Finding element 6 in Binary Tree="+obj.findelement(6,root));
//         System.out.println();
//
//        obj.deepestNode(root);
//        System.out.println();

//       obj.numberofleafs(root);
//        System.out.println();
//
//        obj.numberoffullUsingQueue(root);
//        System.out.println();
//
//       obj.numberofhalfUsingQueue(root);
//        System.out.println();

//        System.out.println("\nDiameter in different Recursion = "+obj.diameterInDifferentRecursion(root));
//        System.out.println("\nDiameter in same Recursion = "+obj.diameterInSameRecursion(root));

//        System.out.println("\nAll paths from root-->leafs");
//        obj.pathsroot2leaves(root);
        obj.pathsroot2leavesWithAncestorGreaterAndChildSmaller(root);

//        System.out.println("\nDelete all Nodes which does not lie in path sum>=k .. ");
//        obj.shouldPrunePath(root, 23);
//        System.out.println("Iterative Level Order traversal after pruning");
//        obj.levelOrderQueue(root);
//        System.out.println();

//        System.out.println("\nDelete all Nodes which does not lie in path sum>=k .. ");
//        obj.shouldPrunePathSelfWithSumLessThanGivenSum(root, 23);
//        System.out.println("Iterative Level Order traversal after pruning");
//        obj.levelOrderQueue(root);
//        System.out.println();

//          System.out.println("\nDelete all Nodes which does not lie in path length>=k .. ");
//          obj.shouldPrunePathWithLengthShorterThanK(root, 1,3);
//          System.out.println("Iterative Level Order traversal after pruning");
//          obj.levelOrderQueue(root);
//          System.out.println();
//
//        System.out.println("Iterative version --- ");
//        obj.IterativeRoot2Leaf(root);
//

//         int sum=12;
//        System.out.println("Sum="+sum+" Exsitence="+obj.givenSumExistence(root,sum));
//
//        System.out.println("Total sum of tree="+obj.totalsum(root));

        int inorder[] = {8, 4, 2, 5, 1, 6, 7, 3};
        int preorder[] = {1, 2, 4, 8, 5, 7, 6, 3};


        int postorder[] = {8, 4, 5, 2, 6, 3, 7, 1};
        // constructing the binary tree with given inorder & preorder traversal
//       Node newNode=obj.constructBinaryTreeFromGivenInOrderAndPreOrderTraversal(inorder,preorder,0,inorder.length-1);
//       System.out.println("In order traversal of constructed tree");
//       obj.IpostOrder1stack(newNode);
//
//
//       obj.postIndex=postorder.length-1;
//       Node newNode2=obj.constructBinaryTreeFromGivenInOrderAndPostOrderTraversal(inorder,postorder,0,inorder.length-1);
//
//       System.out.println("Pre Order traversal of constructed tree");
//       obj.rPreOrder(newNode2);

//       System.out.println("Post order traversal without constructing tree: ");
//       obj.printPostOrderTraversal(inorder, 0 , preorder, 0, inorder.length-1);

//       Node node = new Node(10);
//       obj.printAncestorIterative(root,node);
//       System.out.println("Recursive version: ");
//       obj.printAncestorRecursive(root,node);
//       System.out.println();
//       obj.printAncestorNodesOfGivenNode(root,node, 0);

//         obj.LCAUsingPathFromRootToThatNode(root, temp4,temp12);
//         obj.isCousinNotsibling(root, temp7, temp6);

//        System.out.println("Bottom Up approach LCA of "+temp4.value +" and "+ temp7.value);
//        obj.LCAbottomUp(root, temp2.value,temp4.value);
//        System.out.println();
//        obj.LCA_Inorder_Postorder(root,temp4,temp7);
//        System.out.println();
//        obj.LCA_Inorder_Preorder(root,temp8,temp2);
//
//        obj.verticalSum(root);

//         Please Note : Skipping it for now as it is quite hard problem and not very important question. Will revisit this later
//         int n=10;
//         Node preOrdersuccessor=obj.preOrderSuccessor(root,n);
//         if(preOrdersuccessor!=null)
//           System.out.println("Preorder Successor of "+n+" = "+preOrdersuccessor.value);
//         else
//              System.out.println("Preorder Successor of "+n+" = null");

//         Please Note : Skipping it for now as it is quite hard problem and not very important question. Will revisit this later
//         Node Insuccessor=obj.InOrderSuccessor(root,n);
//         if(Insuccessor!=null)
//           System.out.println("Inorder Successor of "+n+" = "+Insuccessor.value);
//         else
//           System.out.println("InorderSuccessor of "+n+" = null");
//
//         Please Note : Skipping it for now as it is quite hard problem and not very important question. Will revisit this later
//       Node Postsuccessor=obj.postOrderSuccessor(root,n);
//     if(Postsuccessor!=null)
//       System.out.println("postorder Successor of "+n+" = "+Postsuccessor.value);
//     else
//          System.out.println("postorder Successor of "+n+" = null");


//        System.out.println();
//        System.out.println("Inorder Morris traversal W/O using stack or recursion...");
//        obj.MorrisTraversal(root);
//        System.out.println();
//        System.out.println("Preorder Morris traversal..");
//        obj.morrisTraversalPreorder_updated(root);
//        System.out.println();

        obj.find2Nodes(root, 15);

     /*  obj.sumTree(root);
       System.out.println("Inorder traversal of sum tree is: ");
      System.out.println("Root value="+root.value);
       obj.rInOrder2(root);*/

    }
}


class OperationOnBinaryTre {
    static boolean isn1Present = false, isn2Present = false;
    Queue<Node> queue = new LinkedList();
    int inOrder[] = new int[13];
    int postOrder[] = new int[13];
    int preOrder[] = new int[13];
    int indexInorder = 0, indexPostorder = 0, indexPretorder = 0;
    Node root;
    int max = -10;
    int len = 0;
    int overallmax;
    int tp = 0;
    //http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree-from-inorder-and-preorder-traversals/
    int preindex = 0;
    int postIndex = 0;
    int[] path = new int[100];

    // Insert Operation
    public void insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);

        } else {
            queue.add(root);

            while (!queue.isEmpty()) {
                Node t = queue.remove();

                if (t.left == null) {
                    t.left = new Node(x);
                    queue.clear();
                    return;
                } else {
                    queue.add(t.left);
                }

                if (t.right == null) {
                    t.right = new Node(x);
                    queue.clear();
                    return;
                } else {
                    queue.add(t.right);
                }
            }
        }
    }

    public void insertAtposition(Node root, Node position, int x) {
        if (position == null || root == null)
            return;
        else {
            if (root.value == position.value) {
                if (root.left == null)
                    root.left = new Node(x);

                else if (root.right == null)
                    root.right = new Node(x);
            } else {
                Queue<Node> qwe = new LinkedList<Node>();
                qwe.add(root);
                Node t;
                while (!qwe.isEmpty()) {
                    t = (Node) qwe.remove();

                    if (t.value == position.value) {
                        if (t.left == null) {
                            t.left = new Node(x);
                            break;
                        } else if (t.right == null) {
                            t.right = new Node(x);
                            break;
                        }

                        break;
                    }
                    if (t.left != null)
                        qwe.add(t.left);
                    if (t.right != null)
                        qwe.add(t.right);
                }
            }
        }
    }

    //Recursive Inorder Traversal
    public void rInOrder(Node r) {
        if (r == null)
            return;
        else {
            rInOrder(r.left);
            System.out.print(r.value + "  ");
            inOrder[indexInorder++] = r.value;
            rInOrder(r.right);
        }
    }

    // Iterative Inorder traversal
    public void IinOrder(Node rt) {
        Stack s = new Stack();

        while (rt != null) {
            s.push(rt);
            rt = rt.left;
        }
        Node t2;

        while (!s.isEmpty()) {
            Node t = (Node) s.pop();
            System.out.print(t.value + "  ");
            t2 = t.right;

            while (t2 != null) {
                s.push(t2);
                t2 = t2.left;
            }
        }
    }

    public void rPreOrder(Node r) {
        if (r != null) {
            System.out.print(r.value + "  ");
//            preOrder[indexPretorder++] = r.value;
            rPreOrder(r.left);
            rPreOrder(r.right);
        }
    }

    public void IpreOrder(Node rt) {
        Stack s = new Stack();
        Node temp;

        s.push(rt);

        while (!s.isEmpty()) {
            temp = (Node) s.pop();
            System.out.print(temp.value + "  ");

            if (temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);

        }
    }

    public void IpostOrder2stacks(Node rt) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        Node temp;

        s1.push(rt);

        while (!s1.isEmpty()) {
            temp = (Node) s1.pop();

            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);

            if (temp.right != null)
                s1.push(temp.right);

        }

        while (!s2.isEmpty()) {
            Node x = (Node) s2.pop();
            System.out.print(x.value + "  ");
            postOrder[indexPostorder++] = x.value;

        }

    }

    // Source of information: http://www.geeksforgeeks.org/iterative-postorder-traversal/
    public void iterativePostOrder(Node root) {
        Stack st1 = new Stack();
        Stack st2 = new Stack();
        st1.push(root);
        Node current = root;
        boolean visitedLeaf = false;
        while (!st1.isEmpty()) {
            Node t1 = (Node) st1.peek();
            Node t2 = st2.isEmpty() ? null : (Node) st2.peek();

            if (t1 != null && t2 != null && t1.value == t2.value && t1.right != null) {
                System.out.print("  " + t1.value);
                st1.pop();
                st2.pop();
                current = st1.isEmpty() ? null : (Node) st1.peek();
            } else {

                if (current.left != null && !visitedLeaf) {
                    current = current.left;
                    st1.push(current);
                    //  System.out.println("Pushing current in left = "+ current.data);
                } else if (current.right != null) {
                    st2.push(current);
                    current = current.right;
                    st1.push(current);
                    //    System.out.println("Pushing Node in right = " + current.data);
                    visitedLeaf = false;
                } else {
                    System.out.print(" " + current.value);
                    st1.pop();
                    current = (Node) st1.peek();
                    visitedLeaf = true;
                }
            }
        }
        System.out.println();
    }

    public void IpostOrder1stack(Node rt) {

        if (rt == null)
            return;

        Stack s1 = new Stack();

        // s1.push(rt);

        do {

            // Part 1 :: Going to left most node
            while (rt != null) {
                if (rt.right != null)
                    s1.push(rt.right);

                s1.push(rt);

                rt = rt.left;
            }


            rt = (Node) s1.pop();
            Node top = null;

            if (!s1.isEmpty())
                top = (Node) s1.peek();


            if (rt.right != null && rt.right == top) {
                Node t1 = (Node) s1.pop();
                s1.push(rt);
                rt = t1;
            } else {
                System.out.print(rt.value + "  ");
                rt = null;
            }

        } while (!s1.isEmpty());
    }

    // Copied from Tushar's Youtube channel. Seems simpler than above solution
// which has do-while loop. Link for solution - https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java#L98
    public void postOrderItrOneStack(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.value + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.value + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public void levelOrderQueue(Node root) {
        if (root == null)
            return;


        Queue<Node> q = new LinkedList<Node>();

        q.add(root);


        while (!q.isEmpty()) {

            Node tt = (Node) q.remove();


            System.out.print(tt.value + "  ");

            if (tt.left != null)
                q.add(tt.left);

            if (tt.right != null)
                q.add(tt.right);

        }

    }

    public void leftViewUsingLevelOrder(Node root) {
        if (root == null)
            return;

        Node nullNode = null;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        System.out.println(root.value + " ");
        q.add(nullNode);

        while (!q.isEmpty()) {
            Node current = q.remove();

            if (current == null) {
                if (q.peek() == null) {
                    break;
                } else {
                    System.out.println(q.peek().value + " ");
                    q.add(nullNode);
                }
            } else {
                if (current.left != null)
                    q.add(current.left);

                if (current.right != null)
                    q.add(current.right);
            }
        }
    }


//public void zigZagOrder(Node root)
//{
//  if(root==null)
//      return;
//
//  Stack s1=new Stack();
//  Queue<Node> s2 = new LinkedList<Node>();
//
////  Stack s2=new Stack();
//
//  s1.add(root);
//
//  while(!s1.isEmpty())
//  {
//      while(!s1.isEmpty())
//      {
//          Node tt=(Node) s1.pop();
//
//          if(tt.left!=null)
//              s2.add(tt.left);
//
//          if(tt.right!=null)
//              s2.add(tt.right);
//
//        System.out.print(tt.value+"  ");
//      }
//
//      while(!s2.isEmpty())
//          s1.push(s2.remove());
//
//   }
//}

    public void boundryOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");

        if (root.left == null && root.right == null) {
            return;
        }

        printLeftTraversal(root.left);

        printbottomView(root.left);
        printbottomView(root.right);

        printRightTraversal(root.right);

    }

    // printing left traversal in top down approach
    public void printLeftTraversal(Node root) {
        if (root != null) {

            if (root.left != null) {
                System.out.print(root.value + " ");
            }
            printLeftTraversal(root.left);
            printLeftTraversal(root.right);
        }
    }

    public void printbottomView(Node root) {
        if (root == null)
            return;

        printbottomView(root.left);

        if (root.left == null && root.right == null) {
            System.out.print(root.value + " ");
        }
        printbottomView(root.right);
    }

    // printing right traversal in bottom up approach
    public void printRightTraversal(Node root) {
        if (root != null) {
            if (root.right != null) {
                System.out.print(root.value + " ");
            }
            printRightTraversal(root.right);
            printRightTraversal(root.left);
        }

    }

    public void rightViewUsingLevelOrder2(Node root) {

        if (root == null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        Node nullNode = null;

        q.add(root);
        q.add(nullNode);

        while (!q.isEmpty()) {
            Node t = q.remove();
            if (t == null) {
                if (q.peek() == null)
                    break;
                else
                    q.add(nullNode);
            } else {
                if (q.peek() == null) {
                    System.out.println(t.value);
                }
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);

            }
        }

    }

    public void rightViewUsingLevelOrder(Node root) {
        if (root == null)
            return;


        Node nullNode = null;
        Node previousNode = root;

        Queue<Node> q = new LinkedList<Node>();

        q.add(root);
        q.add(nullNode);

        while (!q.isEmpty()) {
            Node tt = q.remove();

            if (tt == null) {
                System.out.println(previousNode.value);

                if (q.peek() == null) {
                    break;
                }

                q.add(nullNode);
            } else {

                previousNode = tt;
                if (tt.left != null)
                    q.add(tt.left);

                if (tt.right != null)
                    q.add(tt.right);

            }
        }

    }

    public void levelOrder2Stacks(Node root) {
        if (root == null)
            return;

        Stack s1 = new Stack();
        Stack s2 = new Stack();

        s1.add(root);

        while (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                Node tt = (Node) s1.pop();

                if (tt.left != null)
                    s2.push(tt.left);

                if (tt.right != null)
                    s2.push(tt.right);

                System.out.print(tt.value + "  ");
            }

            while (!s2.isEmpty())
                s1.push(s2.pop());

        }
    }

    public void reverselevelOrderStackQueue(Node root) {
        if (root == null)
            return;

        Stack s = new Stack();

        Queue<Node> q = new LinkedList<Node>();

        q.add(root);

        while (!q.isEmpty()) {
            Node tt = (Node) q.remove();
            s.push(tt);

            if (tt.left != null) {
                q.add(tt.left);
            }

            if (tt.right != null) {
                q.add(tt.right);
            }
        }

        while (!s.isEmpty()) {
            Node t = (Node) s.pop();
            System.out.print(t.value + "  ");
        }
    }

    //finding maximum element using recursion
    public int findMax(Node root) {
        if (root == null)
            return -1;

        if (max < root.value)
            max = root.value;

        if (root.left != null) {
            max = findMax(root.left);
        }

        if (root.right != null) {
            max = findMax(root.right);
        }

        return max;
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

    public int findMaxSecondWay(Node root) {
        if (root == null)
            return MIN_VALUE;

        if (root.left == null && root.right == null)
            return root.value;

        int leftMax = findMaxSecondWay(root.left);
        int rightMax = findMaxSecondWay(root.right);

        return Math.max(root.value, Math.max(leftMax, rightMax));
    }

    public void iterativeHeight(Node root) {
        int height = 0;
        Node nullNode = null;
        if (root == null)
            System.out.println("Height=" + height);

        Queue<Node> s = new LinkedList<Node>();
        s.add(root);
        s.add(nullNode);

        while (!s.isEmpty()) {
            Node tt = (Node) s.remove();

            if (tt == null) {
                height++;
                s.add(tt);

                Node justNext = s.peek();

                if (justNext == null)
                    break;
            } else {
                if (tt.left != null)
                    s.add(tt.left);

                if (tt.right != null)
                    s.add(tt.right);
            }


        }
        System.out.println("Iterative height=" + height);
    }

    public int computeHeight(Node root) {
        int lheight = 0, rheight = 0;

        if (root == null)
            return 0;

        lheight = computeHeight(root.left);
        rheight = computeHeight(root.right);
        return Math.max(rheight, lheight) + 1;
    }

    public void levelOrderUsingHeight(int ht, Node root) {
        int i;
        for (i = 1; i <= ht; i++) {
            printgivenlevel(i, root);
        }
    }

    public void printgivenlevel(int level, Node root) {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.value + "  ");
        else if (level > 1) {
            if (root.left != null)
                printgivenlevel(level - 1, root.left);

            if (root.right != null)
                printgivenlevel(level - 1, root.right);
        }
    }

    public boolean findelement(int e, Node root) {
        boolean result = false;
        if (root == null)
            return result;

        if (root.value == e)
            result = true;

        if (root.left != null)
            result = findelement(e, root.left);

        if (!result && root.right != null)
            result = findelement(e, root.right);

        return result;
    }

    public void deepestNode(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        Node t = null;
        q.add(root);
        while (!q.isEmpty()) {
            t = (Node) q.remove();

            if (t.left != null)
                q.add(t.left);

            if (t.right != null)
                q.add(t.right);
        }
        System.out.println("Deepest Node in Binary Tree=" + t.value);
    }

    public void numberofleafs(Node root) {
        Node temp;
        Queue<Node> q = new LinkedList<Node>();
        int count = 0;
        if (root == null)
            return;

        q.add(root);
        while (!q.isEmpty()) {
            temp = q.remove();
            if (temp.left == null && temp.right == null)
                count++;

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }

        System.out.println("Number of leaf Nodes=" + count);
    }

    public void numberoffullUsingQueue(Node root) {
        Node temp;
        Queue<Node> q = new LinkedList<Node>();
        int count = 0;
        if (root == null)
            return;

        q.add(root);
        while (!q.isEmpty()) {
            temp = q.remove();
            if (temp.left != null && temp.right != null) {
                count++;
            }

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }

        System.out.println("Number of full Nodes=" + count);
    }

    public void numberofhalfUsingQueue(Node root) {
        Node temp;
        Queue<Node> q = new LinkedList<Node>();
        int count = 0;
        if (root == null)
            return;

        q.add(root);
        while (!q.isEmpty()) {
            temp = q.remove();
            if (temp.left != null && temp.right == null) {
                count++;
            }
            if (temp.left == null && temp.right != null) {
                count++;
            }

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }

        System.out.println("Number of Haf Nodes=" + count);
    }

    // Diameter of a binary means - number of nodes (not edges) on longest path
    public int diameterInDifferentRecursion(Node root) {
        if (root == null)
            return 0;

        int l = height(root.left);
        int r = height(root.right);

        int ldiameter = diameterInDifferentRecursion(root.left);
        int rdiameter = diameterInDifferentRecursion(root.right);
        return Math.max(l + r + 1, Math.max(ldiameter, rdiameter));
    }

    public int diameterInSameRecursion(Node root) {
        MaxLengthSoFar ob = new MaxLengthSoFar();

        getDiameterInSameRecursionUtil(root, ob);
        return ob.getMaxLength();
    }

    private int getDiameterInSameRecursionUtil(Node root, MaxLengthSoFar dataTracker) {
        if (root == null)
            return 0;

        int hieghtLch = getDiameterInSameRecursionUtil(root.left, dataTracker);
        int heightRch = getDiameterInSameRecursionUtil(root.right, dataTracker);


        if ((hieghtLch + heightRch + 1) > dataTracker.getMaxLength()) {
            dataTracker.setMaxLength(hieghtLch + heightRch + 1);
            dataTracker.setNode(root);
        }
        return (hieghtLch > heightRch ? hieghtLch : heightRch) + 1;
    }

    public int height(Node t) {
        if (t == null)
            return 0;

        int lheight = height(t.left);
        int rheight = height(t.right);

        return 1 + Math.max(lheight, rheight);
    }

    public void morrisTraversalPreorder_updated(Node node) {
        while (node != null) {
            // If left child is null, print the current node data. Move to
            // right child.
            if (node.left == null) {
                System.out.print(node.value + " ");
                node = node.right;
            } else {

                // Find inorder predecessor
                Node current = node.left;
                while (current.right != null && current.right != node) {
                    current = current.right;
                }

                // If the right child of inorder predecessor already points to
                // this node
                if (current.right == node) {
                    current.right = null;
                    node = node.right;
                }

                // If right child doesn't point to this node, then print this
                // node and make right child point to this node
                else {
                    System.out.print(node.value + " ");
                    current.right = node;
                    node = node.left;
                }
            }
        }
    }

    public void MorrisTraversal(Node root) {
        Node current, prev;

        if (root == null)
            return;

        current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.value + "  ");
                current = current.right;
            } else {
                // find the inorder predecessor of current Node
                prev = current.left;
                while (prev.right != null && prev.right != current)
                    prev = prev.right;

                // Make current as right child of its inorder predecessor
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                }
         /* Revert the changes made in if part to restore the original
        tree i.e., fix the right child of predecssor */
                else {
                    prev.right = null;
                    // System.out.print(" - "+current.value+" - ");
                    System.out.print(current.value + "  ");
                    current = current.right;
                }
            }
        }
    }

    public void pathsroot2leaves(Node root) {
        int path[] = new int[256];
        paths(root, path, 0);

    }

    public void paths(Node root, int path[], int pathlen) {
        if (root == null) return;

        path[pathlen++] = root.value;

        if (root.left == null && root.right == null)
            printpaths(pathlen, path);
        else {
            paths(root.left, path, pathlen);
            paths(root.right, path, pathlen);
        }

    }

    public void printpaths(int l, int pathways[]) {
        int i;
        String s = null;
        for (i = 0; i < l; i++) {
            if (i == 0) {
                s = String.valueOf(pathways[i]);
            } else {
                s = s + " --> " + pathways[i];
            }
        }

        System.out.println("path from root to leaf  :: \n " + s);
        System.out.println();
    }

    public void pathsroot2leavesWithGivenSum(Node root) {
        int path[] = new int[256];
        paths(root, path, 0);

    }

    public void patpathsroot2leavesWithGivenSumhs(Node root, int path[], int pathlen) {
        if (root == null) return;

        path[pathlen++] = root.value;

        if (root.left == null && root.right == null)
            printpathsWithSum(pathlen, path);
        else {
            patpathsroot2leavesWithGivenSumhs(root.left, path, pathlen);
            patpathsroot2leavesWithGivenSumhs(root.right, path, pathlen);
        }

    }

    public void printpathsWithSum(int l, int pathways[]) {
        int i;
        String s = null;
        int sum = 0;

        for (i = 0; i < l; i++) {
            if (i == 0) {
                s = String.valueOf(pathways[i]);
                sum = pathways[i];
            } else {
                s = s + " --> " + pathways[i];
                sum += pathways[i];
            }
        }
        if (sum == 24) {
            System.out.println("path from root to leaf with sum = 24 :: \n " + s);
        }

        System.out.println();
    }

    //http://stackoverflow.com/questions/11045399/print-every-leaf-path-of-a-tree-without-recursive
    public void IterativeRoot2Leaf(Node root) {
        if (root == null) {
            return;
        }

        Queue<Object> q = new LinkedList();

        q.add(root);
        q.add(root.value + " ");

        while (!q.isEmpty()) {

            Node head = (Node) q.remove();
            String headPath = (String) q.remove();

            if (head.left == null && head.right == null) {
                System.out.println(headPath);
                continue;
            }

            if (head.left != null) {
                String leftStr = headPath + " -> " + head.left.value;
                q.add(head.left);
                q.add(leftStr);
            }

            if (head.right != null) {
                String rightStr = headPath + " -> " + head.right.value;
                q.add(head.right);
                q.add(rightStr);
            }
        }
    }

    public void pathsroot2leavesWithAncestorGreaterAndChildSmaller(Node root) {
        int path[] = new int[256];
        pathsWithAncestorGreaterAndChildSmaller(root, path, 0);
        System.out.println("overallmax :: " + overallmax);

    }

    public void pathsWithAncestorGreaterAndChildSmaller(Node root, int path[], int pathlen) {
        if (root == null)
            return;

        path[pathlen++] = root.value;

        if (root.left == null && root.right == null)
            printpathsWithAncestorGreaterAndChildSmaller(pathlen - 1, path);
        else {
            pathsWithAncestorGreaterAndChildSmaller(root.left, path, pathlen);
            pathsWithAncestorGreaterAndChildSmaller(root.right, path, pathlen);
        }

    }

    public void printpathsWithAncestorGreaterAndChildSmaller(int l, int pathways[]) {
        for (int i = 0; i <= l; i++) {
            System.out.print(pathways[i] + "   ");
        }

//    String s = null;
//    int sum =0;

        int leftMax[] = new int[l + 1];
        int rightMin[] = new int[l + 1];

        leftMax[0] = pathways[0];
        for (int i = 1; i <= l; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], pathways[i]); // Math.max(pathways[i], pathways[i-1]));
        }

        rightMin[l] = pathways[l];
        for (int i = l - 1; i >= 0; i--) {
            rightMin[i] = Math.min(pathways[i], rightMin[i + 1]);
        }

        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i <= l; i++) {
//       System.out.println(leftMax[i] + " :: " + rightMin[i]);
            if (leftMax[i] - rightMin[i] > max1) {
                max1 = leftMax[i] - rightMin[i];
            }
        }
        System.out.println("max 1 :: " + max1);
        if (overallmax < max1) {
            overallmax = max1;
        }

    }

    // recursive version
    public boolean givenSumExistence(Node root, int sum) {
        if (root == null)
            return sum == 0;

        int newsum = sum - root.value;

        return givenSumExistence(root.left, newsum) || givenSumExistence(root.right, newsum);
    }

    public int totalsum(Node root) {
        if (root == null) return 0;

        return (root.value + totalsum(root.left) + totalsum(root.right));

    }

    public boolean shouldPrunePath(Node root, int remainingSum) {

        if (root == null) {
            return false;
        }

        remainingSum = remainingSum - root.value;
        boolean left = shouldPrunePath(root.left, remainingSum);
        boolean right = shouldPrunePath(root.right, remainingSum);

        if (root.left == null && root.right == null) {
            if (remainingSum > 0) {
                return true;
            } else {
                return false;
            }
        }

        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        return (left && right);
    }

    public boolean shouldPrunePathSelfWithSumLessThanGivenSum(Node root, int remainingSum) {

        if (root == null) {
            return true;
        }

        remainingSum = remainingSum - root.value;
        boolean left = shouldPrunePathSelfWithSumLessThanGivenSum(root.left, remainingSum);
        boolean right = shouldPrunePathSelfWithSumLessThanGivenSum(root.right, remainingSum);

        if (remainingSum > 0) {
            if (left)
                root.left = null;
            if (right)
                root.right = null;
        } else {
            return false;
        }
        return (left && right);
    }

    public boolean shouldPrunePathWithLengthShorterThanK(Node root, int level, int pathLen) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (pathLen - level > 0) {
                return true;
            } else
                return false;
        }

        boolean left = shouldPrunePathWithLengthShorterThanK(root.left, level + 1, pathLen);
        boolean right = shouldPrunePathWithLengthShorterThanK(root.right, level + 1, pathLen);

        if (pathLen - level > 0) {
            if (left) {
                root.left = null;
            }
            if (right) {
                root.right = null;
            }
        }

        return (left && right);
    }

    public void printPostOrderTraversal(int in[], int inIndex, int pre[], int preIndex, int n) {
        if (n == 0)
            return;

        int r = search(in, 0, in.length - 1, pre[tp++]);

        System.out.println("r = " + r);
        if (r != 0) {
            printPostOrderTraversal(in, inIndex, pre, preIndex + 1, r);
        }

        if (r != n - 1) {
            printPostOrderTraversal(in, inIndex + r + 1, pre, preIndex + r + 1, n - r - 1);
        }
        System.out.print(pre[tp - 1]);
    }

    //Please note that we are using this approach as it is not in sync with questions of constructing tree from given preorder and inorder traversal
    // construct binary tree
//    public Node constructBinaryTreeFromGivenInOrderAndPostOrderTraversal(int inOrder[], int postOrder[], int inStrt, int inEnd, int postIndex) {
//
//        if (inStrt > inEnd)
//            return null;
//
//        Node newNode = new Node(postOrder[postIndex]);
//
//        if (inStrt == inEnd)
//            return newNode;
//
//
//        int indexOfSearchElement = search(inOrder, inStrt, inEnd, newNode.value);
//
//        // (inEnd-inIndex+1) is length of inOrder array which needs to be subtracted
//        newNode.left = constructBinaryTreeFromGivenInOrderAndPostOrderTraversal
//                (inOrder, postOrder, inStrt, indexOfSearchElement - 1, postIndex - (inEnd - indexOfSearchElement + 1));
//
//
//        newNode.right = constructBinaryTreeFromGivenInOrderAndPostOrderTraversal
//                (inOrder, postOrder, indexOfSearchElement + 1, inEnd, postIndex - 1);
//
//        return newNode;
//    }

    public Node constructBinaryTreeFromGivenInOrderAndPreOrderTraversal(int in[], int pre[], int instrt, int inend) {

        if (instrt > inend) {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex
        and increment preIndex */
        Node tnode = new Node(pre[preindex++]);

        // If this node i.e., tnode has no children then return this node
        if (instrt == inend) {
            return tnode;
        }

        // else find the tnode in inorder traversal
        int inIndex = search(in, instrt, inend, tnode.value);

        tnode.left = constructBinaryTreeFromGivenInOrderAndPreOrderTraversal(in, pre, instrt, inIndex - 1);

        tnode.right = constructBinaryTreeFromGivenInOrderAndPreOrderTraversal(in, pre, inIndex + 1, inend);

        return tnode;
    }

    public Node constructBinaryTreeFromGivenInOrderAndPostOrderTraversal(int inOrder[], int postOrder[], int inStrt, int inEnd) {

        if (inStrt > inEnd)
            return null;

        Node newNode = new Node(postOrder[postIndex--]);

        if (inStrt == inEnd)
            return newNode;


        int indexOfSearchElement = search(inOrder, inStrt, inEnd, newNode.value);


        newNode.right = constructBinaryTreeFromGivenInOrderAndPostOrderTraversal
                (inOrder, postOrder, indexOfSearchElement + 1, inEnd);

        // (inEnd-inIndex+1) is length of inOrder array which needs to be subtracted
        newNode.left = constructBinaryTreeFromGivenInOrderAndPostOrderTraversal
                (inOrder, postOrder, inStrt, indexOfSearchElement - 1);

        return newNode;
    }

    public int search(int a[], int startIndex, int endIndex, int value) {
        int i, index = -1;
        for (i = startIndex; i <= endIndex; i++) {
            if (a[i] == value)
                index = i;
        }
        return index;
    }

    public void printAncestorIterative(Node root, Node a) {
        System.out.println();

        int flag = 0;
        if (root == null) {
            return;
        }

        System.out.println("Iterative version:");

        Queue<Object> q = new LinkedList<>();
        q.add(root);
        q.add(root.value + " ");

        while (!q.isEmpty()) {

            Node head = (Node) q.remove();
            String headPath = (String) q.remove();

            if (head.value == a.value) {
                System.out.println("Ancestors of Node= " + a.value + " " + headPath);
                flag = 1;
                break;
            }

            if (head.left != null && head.left.value == a.value) {
                System.out.println("Ancestors of Node= " + a.value + " " + headPath);
                flag = 1;
                break;
            }

            if (head.right != null && head.right.value == a.value) {
                System.out.println("Ancestors of Node = " + a.value + " " + headPath);
                flag = 1;
                break;
            }

            if (head.left != null) {
                String leftStr = headPath + " -> " + head.left.value;
                q.add(head.left);
                q.add(leftStr);
            }

            if (head.right != null) {
                String rightStr = headPath + " -> " + head.right.value;
                q.add(head.right);
                q.add(rightStr);
            }
        }

        if (flag == 0)
            System.out.println("Ancestors of Node iterative = " + a.value + " is NOT present.");

    }

    public boolean printAncestorRecursive(Node root, Node a) {
        if (root == null)
            return false;

        if (root.left != null) {
            if (printAncestorRecursive(root.left, a) || root.left.value == a.value) {
                System.out.print(root.value + "  ");
                return true;
            }
        }
        if (root.right != null) {
            if (printAncestorRecursive(root.right, a) || root.right.value == a.value) {
                System.out.print(root.value + "  ");
                return true;
            }

        }
        return false;
    }

    public void printAncestorNodesOfGivenNode(Node root, Node node, int len) {
        if (node == null || root == null)
            return;

        path[len] = root.value;

        if (root.value == node.value) {
            printPath(path, len);
            return;
        }

        printAncestorNodesOfGivenNode(root.left, node, len + 1);
        printAncestorNodesOfGivenNode(root.right, node, len + 1);
    }

    private void printPath(int[] path, int len) {
        for (int i = 0; i <= len; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public void isCousinNotsibling(Node root, Node n1, Node n2) {
        int LCA = isCousinNotsiblingUtil(root, n1, n2);
//    System.out.println("LCA == " + LCA);
        if (LCA == -1) {
            System.out.println("nodes not found");
            return;
        }

        Queue<Node> q = new LinkedList();
        q.add(root);
        q.add(null);

        Node t = null;

        while (!q.isEmpty()) {
            t = q.remove();
            if (t == null) {
                q.add(null);
                continue;
            }

            if (t != null && t.value == LCA) {
                break;
            }
            q.add(t.left);
            q.add(t.right);

        }

        if (t != null && t.left != null && t.right != null) {
            if ((t.left.value == n1.value && t.right.value == n2.value)
                    || (t.right.value == n1.value && t.left.value == n2.value)) {
                System.out.println("n1 and n2 are siblings NOT cousins");
            } else {
                System.out.println("n1 and n2 are cousins  NOT siblings   ");
            }

        }

    }

//int counter=0;

    public int isCousinNotsiblingUtil(Node root, Node n1, Node n2) {

        if (root == null || n1 == null || n2 == null) {
            System.out.println("Invalid input params");
            return -1;
        }


        int[] p1 = new int[10];

        int[] p2 = new int[10];

        Node temp1 = root, temp2 = root;

        int t1 = pathFromRootToThatNode(temp1, p1, n1, 0);
        int t2 = pathFromRootToThatNode(temp2, p2, n2, 0);


        if (t1 == -1 || t2 == -1) {
            System.out.println("LCA does not exist for given combination !!");
            return -1;
        }

        if (t1 == 0) {
            System.out.println("LCA == " + p1[t1]);
            return -1;
        }
        if (t2 == 0) {
            System.out.println("LCA == " + p2[t2]);
            return -1;
        }

        return LCA_value(p1, p2, t1, t2);

    }

    public void LCAUsingPathFromRootToThatNode(Node root, Node n1, Node n2) {

        if (root == null || n1 == null || n2 == null) {
            System.out.println("Invalid input params");
            return;
        }


        int[] p1 = new int[10];

        int[] p2 = new int[10];

        Node temp1 = root, temp2 = root;

        int t1 = pathFromRootToThatNode(temp1, p1, n1, 0);
        int t2 = pathFromRootToThatNode(temp2, p2, n2, 0);

        if (t1 == -1 || t2 == -1) {
            System.out.println("LCA does not exist for given combination !!");
            return;
        }

        if (t1 == 0) {
            System.out.println("LCA = " + p1[t1]);
            return;
        }
        if (t2 == 0) {
            System.out.println("LCA = " + p2[t2]);
            return;
        }

        int value = LCA_value(p1, p2, t1, t2);
        if (value == -1) {
            System.out.println("LCA does not exist");
        } else {
            System.out.println("LCA = " + value);
        }

    }

    public int LCA_value(int[] n1, int[] n2, int t1, int t2) {

        for (int i = Math.min(t1, t2); i >= 0; i--) {

            if (n1[i] == n2[i]) {
                return n1[i];
            }
        }
//
        return -1;
    }

    public int pathFromRootToThatNode(Node root, int[] p, Node n, int length) {

        if (root == null || n == null) {
            return -1;
        }

        p[length] = root.value;

        if (root.value == n.value)
            return length;

        int l1 = pathFromRootToThatNode(root.left, p, n, length + 1);

        if (l1 != -1) {
            return l1;
        }

        int l2 = pathFromRootToThatNode(root.right, p, n, length + 1);

        if (l2 != -1) {
            return l2;
        }
        return -1;

    }

    public void LCAbottomUp(Node root, int n1, int n2) {
        Node t = LCAbottomUpUtil(root, n1, n2);

        if (t == null) {
            System.out.println(" LCA is null");
            return;
        }
        System.out.println("LCA :: " + t.value);
    }

    // This function returns pointer of LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    private Node LCAbottomUpUtil(Node node, int n1, int n2) {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.value == n1 && node.value == n2) {
            isn1Present = true;
            isn2Present = true;
            return node;
        }

        if (node.value == n1) {
            isn1Present = true;
            return node;
        }

        if (node.value == n2) {
            isn2Present = true;
            return node;
        }


        // Look for keys in left and right subtrees
        Node left_lca = LCAbottomUpUtil(node.left, n1, n2);
        Node right_lca = LCAbottomUpUtil(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    // Source: https://www.youtube.com/watch?v=LFjCr2yDJdc
    public void LCA_Inorder_Postorder(Node root, Node p, Node q) {
        int i, t = 0, largest = -1, tindex = 0, ans = 0;

        Node temp1 = root, temp2 = root;
        rInOrder(temp1);
        IpostOrder2stacks(temp2);
        int subset[] = new int[indexInorder];
        int pIndex = this.search(this.inOrder, 0, this.indexInorder - 1, p.value);
        int qIndex = this.search(this.inOrder, 0, this.indexInorder - 1, q.value);


        if (pIndex < qIndex) {
            for (i = pIndex; i <= qIndex; i++) {
                subset[t++] = this.inOrder[i];
            }
        } else {
            for (i = qIndex; i <= pIndex; i++) {
                subset[t++] = this.inOrder[i];
            }
        }


        for (i = 0; i < t; i++) {
            tindex = this.search(this.postOrder, 0, this.indexInorder - 1, subset[i]);
            if (tindex > largest) {
                largest = tindex;
                ans = this.postOrder[largest];
            }

        }

        System.out.println("Inorder+postorder LCA of " + p.value + "  and " + q.value + " = " + ans);


    }


    // Source: https://www.youtube.com/watch?v=LFjCr2yDJdc
    public void LCA_Inorder_Preorder(Node root, Node p, Node q) {
        int i, t = 0, smallest = this.indexInorder, tindex = 0, ans = 0;

        int subset[] = new int[indexInorder];
        int pIndex = this.search(this.inOrder, 0, this.indexInorder - 1, p.value);
        int qIndex = this.search(this.inOrder, 0, this.indexInorder - 1, q.value);

        if (pIndex < qIndex) {
            for (i = pIndex; i <= qIndex; i++) {
                subset[t++] = this.inOrder[i];
            }
        } else {
            for (i = qIndex; i <= pIndex; i++) {
//                subset[t++]=this.inOrder[i];
            }
        }

        for (i = 0; i < t; i++) {
            tindex = this.search(this.preOrder, 0, this.indexInorder - 1, subset[i]);

            if (tindex != -1 && tindex < smallest) {

                smallest = tindex;
                ans = this.preOrder[smallest];
            }

        }

        System.out.println("Inorder+preOrder LCA of " + p.value + "  and " + q.value + " = " + ans);


    }

    //http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
    //Time Complexity: O(n)
    public void verticalSum(Node root) {
        // base case
        if (root == null) return;

        // Create an empty hashMap hm
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Call verticalSumUtils to store vertical sum of every node
        verticalSumUtil(root, 0, hm);

        // prints the values stored by verticalSumUtil
        System.out.println("Sum of vertical of the given tree..");
        System.out.println(hm.entrySet());
    }

    // traverse the binary tree in any order(postOrder, preOrder, inOrder) form
    // and build hashmap which contains the vertical sum of each vertical
    public void verticalSumUtil(Node root, int hd, HashMap<Integer, Integer> hm) {
        // base case
        if (root == null) return;

        // store value in hm for left subtree
        verticalSumUtil(root.left, hd - 1, hm);

        // update the vertical sum for hd of this node
        int prevSum = (hm.get(hd) == null) ? 0 : hm.get(hd);
        hm.put(hd, prevSum + root.value);

        // store the values in hm for right subutree
        verticalSumUtil(root.right, hd + 1, hm);


    }

    // finding preOrder successor in a binary Tree
    public Node preOrderSuccessor(Node root, int key) {

        return preOrderSuccessorUtil(root, key, null, null, null);
    }


    public Node preOrderSuccessorUtil(Node root, int key, Node direct_parent, Node parent, Node parent_rightsib) {
        // Case 1
        if (root == null)
            return null;

        // Case 2
        if (root.value == key) {

            // Case 2.1
            if (root.left != null)
                return root.left;

                // Case 2.2
            else if (root.right != null)
                return root.right;


                // Case 2.3
            else if (direct_parent != null && direct_parent.left == root && direct_parent.right != null) {
                return direct_parent.right;
            }

            // Case 2.4
            else if (parent != null && parent_rightsib != null)
                return parent_rightsib;

                // Case 2.5
            else
                return null;
        }
        // Case 3
        else {
            // Case 3.1
            Node left = preOrderSuccessorUtil(root.left, key, root, root, root.right);
            if (left != null)
                return left;

            // Case 3.2
            return preOrderSuccessorUtil(root.right, key, root, parent, parent_rightsib);

        }
    }


    // finding preOrder successor in a binary Tree
    public Node InOrderSuccessor(Node root, int key) {

        return InOrderSuccessorUtil(root, key, null);
    }


    public Node InOrderSuccessorUtil(Node root, int key, Node parent) {
        // Case 1
        if (root == null) return null;

        // Case 2
        if (root.value == key) {

            // Case 2.1
            if (root.right != null)
                return findleftMostNode(root.right);
                // Case 2.2
            else
                return parent;
        }
        // Case 3
        else {
            // Case 3.1
            Node left = InOrderSuccessorUtil(root.left, key, root);
            if (left != null)
                return left;

            // Case 3.2
            return InOrderSuccessorUtil(root.right, key, parent);

        }
    }


    public Node leftmostLEAFnotNODE(Node root) {
        while (root.left != null || root.right != null) {
            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    //Source: http://algorithmsgeek.blogspot.in/2013/06/algo4-postorder-successor-in-binary-tree.html
    // finding postOrder successor in a binary Tree
    public Node postOrderSuccessor(Node root, int key) {

        return postOrderSuccessorUtil(root, key, null, null, root);
    }


    public Node postOrderSuccessorUtil(Node root, int key, Node direct_parent, Node parent, Node treeroot) {
        // Case 1
        if (root == null) return null;

        // Case 2
        if (root.value == key) {

            // Case 2.1
            if (root == treeroot)
                return null;

                // Case 2.2
            else if (direct_parent != null && direct_parent.right == root)
                return direct_parent;

                // Case 2.3
                // Case 2.3.1
            else if (direct_parent != null && direct_parent.left == root && direct_parent.right != null)
                return leftmostLEAFnotNODE(direct_parent.right);

                // Case 2.3.2
            else if (direct_parent != null && direct_parent.left == root && direct_parent.right == null)
                return direct_parent;

                // Case 2.3.3
            else
                return null;
        } else {
            // Case 3.1
            Node left = postOrderSuccessorUtil(root.left, key, root, root, treeroot);
            if (left != null)
                return left;

            // Case 3.2
            return postOrderSuccessorUtil(root.right, key, root, parent, treeroot);

        }
    }

    public Node findleftMostNode(Node node) {
        while (node.left != null)
            node = node.left;

        return node;
    }


    // Below method will work only in case of Binary Search Tree and not in Binary Tree
    // find number of pairs (a,b) such that a.data+b.data=k
    //in an unbalanced Binary Tree NOT in BST
    public void find2Nodes(Node root, int k) {
        if (root == null) return;

        Stack s1 = new Stack();
        Stack s2 = new Stack();


        Node a = root, b = root;

        s1.push(a);
        s2.push(b);

        while (a.left != null) {
            s1.push(a.left);
            a = a.left;
        }

        while (b.right != null) {
            s2.push(b.right);
            b = b.right;
        }

        System.out.println("Poosible pairs for value= " + k + " as follows:");

        while (!s1.isEmpty() && !s2.isEmpty()) {
              /*
              if(a.value+b.value==k)
              {
                  System.out.println(a.value+" , "+b.value);

              }*/

            if (a.value + b.value <= k) {

                if (a.value + b.value == k) {
                    System.out.println(a.value + " , " + b.value);

                }

                if (a.right != null) {
                    a = a.right;
                    while (a.left != null) {
                        s1.push(a.left);
                        a = a.left;

                    }
                } else
                    a = (Node) s1.pop();
            } else //a.value+b.value>k
            {
                if (b.left != null) {
                    b = b.left;
                    while (b.right != null) {
                        s2.push(b.right);
                        b = b.right;

                    }
                } else
                    b = (Node) s2.pop();
            }
        }
    }


    public int sumTree(Node r) {
        // base cases
        if (r == null)
            return 0;

        r.value += sumTree(r.left) + sumTree(r.right);


        if (r.left == null && r.right == null) {
            int old_val = r.value;
            r.value = 0;
            return old_val;

        }

        return r.value;
    }

    public void rInOrder2(Node root) {
        if (root == null)
            return;

        rInOrder2(root.left);
        System.out.println(root.value);
        rInOrder2(root.right);
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int v) {
        this.value = v;
    }

    public void setleft(Node l) {
        this.left = l;
    }

    public void setright(Node r) {
        this.right = r;
    }

    public Node getleft(Node t) {
        return t.left;
    }

    public Node getright(Node t) {
        return t.right;
    }

}

class MaxLengthSoFar {

    Node node;
    int maxLength;

    public MaxLengthSoFar() {

    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLen) {
        maxLength = maxLen;
    }

    public void setNode(Node pNode) {
        node = pNode;
    }
}