/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikhil.agrawal
 */
public class UnivaluedSubTree {
    
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(2);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(3);
        TreeNode r7 = new TreeNode(3);
        
        root.left=r2;
        root.right=r3;
        
        r2.left=r4;
        r2.right=r5;
        r3.left=r6;
        r3.right=r7;
        
        
        countingUnivaluedTree(root);
        
    }
    
    
    static int count =0;
    
    static void countingUnivaluedTree(TreeNode root)
    {
        
        countingUnivaluedTreeUtil(root);
        
        System.out.println("Number of univalued trees :: " + count);
    }
    
    
    static boolean countingUnivaluedTreeUtil(TreeNode r )
    {
        
        if(r==null) return true;
        
        boolean lB = countingUnivaluedTreeUtil(r.left);
        boolean rB = countingUnivaluedTreeUtil(r.right);
        
        if(lB && rB && (r.left==null || r.val==r.left.val) && (r.right==null || r.val==r.right.val))
        {
            count++;
            return true;
        }
        
        return false;
        
    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { val = x; }
}
