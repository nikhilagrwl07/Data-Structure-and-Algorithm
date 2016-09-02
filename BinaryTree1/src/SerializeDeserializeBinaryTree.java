
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikhil.agrawal
 */
public class SerializeDeserializeBinaryTree {
    
    public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
                TreeNode node2 = new TreeNode(2);
                TreeNode node3 = new TreeNode(3);
                TreeNode node4 = new TreeNode(4);
                TreeNode node5 = new TreeNode(5);
                node1.left=node2;
                node1.right=node3;
                node2.right=node4;
                node3.left=node5;
                System.out.println("Before serilization Inorder");
                rInorder(node1);
		
		//Here I store all the elements in a Array list where each null child is stored as #.
                
                serialize(node1);
//                System.out.println("serilizedTree = "+ list.toString());
                
		deserialize();
                System.out.println("\nAfter serilization Inorder");
                rInorder(node1);
		

	}


	static ArrayList<String> list = new ArrayList<String>();
        
	static int ind = 0;
	
	// Encodes a tree to a single list.
	public static void serialize(TreeNode root) {

		if(root == null){
			list.add("#");
			return;
		}

		list.add(root.val+"");
		serialize(root.left);
		serialize(root.right);

		return;

	}

	// Decodes your encoded list to tree.
	public static TreeNode deserialize() {


		if(ind >= list.size() || list.get(ind).equals("#")){
			ind++;
			return null;
		}
//		System.out.println("list data :: " + list.get(ind));
		TreeNode root = new TreeNode(Integer.parseInt(list.get(ind)));
		ind++;
		root.left = deserialize();
		root.right = deserialize();

		return root;
	}
        
        public static void rInorder(TreeNode r)
        {
            if(r==null) return;
            
            rInorder(r.left);
            System.out.print(r.val + "  ");
            rInorder(r.right);
        }

}

class TreeNode
{
    int val;
    TreeNode left , right;

    public TreeNode(int val) {
        this.val = val;
    }

    


}
