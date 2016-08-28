
package FindingSumOfSmallerElementsOnLeft;

public class FindingSumOfSmallerElementsOnLeft {

    public static void main(String[] args) {
     int[] Arr = { 2, 3, 8, 6, 1 ,10};

            //Sum of prev small numbers in arr
            BST ob = new BST();
            for (int i = 0; i < Arr.length; i++)
            {
                System.out.println(ob.AddNodeAndReturnSumOfPrevSmallNumInArr(Arr[i]));
            }
            
            ob.inOrder();
    
}
}


class BST
    {
        class TreeNode
        {
            public int data;
            public TreeNode left;
            public TreeNode right;
            public int Sum; //for SumOfPrevSmallNumInArr

            public TreeNode(int val)
            {
                this.data = val;
                this.left = null;
                this.right = null;
                this.Sum = 0;
            }

            public TreeNode(int val, int index)
            {
                this.data = val;
                this.left = null;
                this.right = null;
                this.Sum = 0;
            }

            public TreeNode()
            {
                this.data = 0;
                this.left = null;
                this.right = null;
                this.Sum = 0;
            }
        }

        TreeNode Root;
        public BST()
        {
            Root = null;
        }

        public int AddNodeAndReturnSumOfPrevSmallNumInArr(int val)
        {
            TreeNode Node = new TreeNode(val);
            if (Root == null)
            {
                Root = Node;
                return 0;
            }

            TreeNode cur = Root;
            TreeNode Prev = null;
            int Sum = 0;

            while (cur != null)
            {
                Prev = cur;
                //If moving towards right add the current node's value and its 
                //sum value to the sum being calculated to return.
                if (val >= cur.data)
                {
                    Sum += cur.data + cur.Sum;
                    cur = cur.right;
                }
                //If moving towards left add the value to current node's sum.
                else
                {
                    cur.Sum += val;
                    cur = cur.left;
                }
            }
            if (val >= Prev.data)
                Prev.right = Node;
            else 
                Prev.left = Node;
            
            return Sum;
        }
        
         public void inOrder(){
             inOrder(Root);
         }
        
        public void inOrder(TreeNode t){
            if(t==null) return;
            
            inOrder(t.left);
            System.out.print(t.data + " ");
            inOrder(t.right);
        }
}
