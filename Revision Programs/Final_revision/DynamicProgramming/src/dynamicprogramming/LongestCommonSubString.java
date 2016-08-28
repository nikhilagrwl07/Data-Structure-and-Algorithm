/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author nikhil.agrawal
 */
public class LongestCommonSubString {
    private static int totalcases;
    private static StringTokenizer st;
    
      public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }

    public static String next()
    {
        return st.nextToken();
    }

    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    
     public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            nextLine(br);

           totalcases =nextInt();
//            int a[] = new int[totalcases];
            int i;
            Node[] listOfNodes = new Node[totalcases];
            
            
            for(i=0;i<totalcases;i++)
            {
                nextLine(br);
                
                listOfNodes[i] = new Node(nextInt());

            }
            
            for(i=0;i<totalcases-1;i++)
            {
               nextLine(br);
               
               int x = nextInt();
               int y = nextInt();
               
               if(listOfNodes[x].getleft()==null)
               {
                   listOfNodes[x].setleft(listOfNodes[y]);
               }
               else
               {
                   listOfNodes[x].setright(listOfNodes[y]);
               }
               
            }
            
            
            

          int count = countUnivalSubtrees(listOfNodes[0]);
          System.out.println("count = " + count);
          System.out.println("i = " + i);
            BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(System.out));
             bos.write(count + "\n");
              bos.flush();

        } catch (IOException ex) {
        }
        
    }
     
     
      public static int countUnivalSubtrees(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int[] result = new int[]{0};
        helper(root, result);
        return result[0];
    }

    static int i = 0;
    private static boolean helper(Node root, int[] result) {
i++;
        if (root.right == null && root.left == null) {
            result[0]++;
            return true;
        } else if (root.right != null && root.left == null) {
            if (helper(root.right, result) && root.val == root.right.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        } else if (root.right == null) {
            if (helper(root.left, result) && root.val == root.left.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        } else {
            boolean l = helper(root.right, result);
            boolean r = helper(root.left, result);
            if (l && r && root.val == root.left.val && root.val == root.right.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        }

    }

//     
//public static int levelOrderQueue(Node root)
//{
//    if(root==null)
//        return 0;
//    
//      
//    Queue<Node> q=new LinkedList<Node>();
//   
//    q.add(root);
//   
//    int ans =0;
//    
//  
//   while(!q.isEmpty())
//    { 
//        
//        Node tt=(Node) q.remove();   
//       
//        Node temp=tt;
//        if(uniValuedUtil(temp))
//        {
//            ans++;
//        }
//        
//        if(tt.left!=null)
//            q.add(tt.left);
//        
//        if(tt.right!=null)
//            q.add(tt.right);    
//        
//    }
//    
//    return ans;
//
//}
//     static boolean uniValuedUtil(Node root)
//     {
//         if(root==null ) return true;
//         if(root.left==null && root.right==null) return true;
//         if(root.left!=null && root.value!=root.left.value)
//         {
//             return false;
//         }
//         
//         if(root.right!=null && root.value!=root.right.value)
//         {
//             return false;
//         }
//         return uniValuedUtil(root.left) && uniValuedUtil(root.right);
//     }
}



class Node
{
    int val;
    Node left;
    Node right;
    public Node(int v)
    {
        this.val=v;
    }

    
    public void setleft(Node l)
    {
        this.left=l;
    }
    
    public void setright(Node r)
    {
        this.right=r;
    }
    
    public Node getleft()
    {
        return left;
    }
    
    public Node getright()
    {
        return right;
    }
    
}


     
    