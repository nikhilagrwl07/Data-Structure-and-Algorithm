
public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int mat[][]={{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
                

//int m=mat.length;
// int 
// System.out.println(m);
  int t=13;      
System.out.println("Element = "+t+"  "+ quadpart(mat,mat.length,mat.length,t,0,0,4,4,0,0));
//System.out.println(//"Row Number = "+ );

	}
	 public static boolean quadpart(int mat[][], int rowLength, int colLength, int target, int l, int u, int r, int d, int targetRow, int targetCol)
	    {
	        // base cases and violations
	        if(l>r || u>d) return false;
	        
	        if(target<mat[l][u] || target>mat[r][d]) return false;
	        
	        int row=l+(r-l)/2;
	        int col=u+(d-u)/2;
	        
	        if(mat[row][col]==target) 
	            {
	        	 targetRow = row;
	        	    targetCol = col;
	        	return true;
	            }
	        else if(l==r && u==d)
	            return false;
	        
	        if(mat[row][col]>target)
	        {
	            return quadpart(mat, rowLength, colLength, target, col+1, u, r, row, targetRow, targetCol) || 
	           quadpart(mat, rowLength, colLength, target, l, row+1, col, d, targetRow, targetCol) ||
	           quadpart(mat, rowLength, colLength, target, l, u, col, row, targetRow, targetCol);
	        }
	        else
	        {
	            return quadpart(mat, rowLength, colLength, target, col+1, u, r, row, targetRow, targetCol) || 
	           quadpart(mat, rowLength, colLength, target, l, row+1, col, d, targetRow, targetCol) ||
	           quadpart(mat, rowLength, colLength, target, col+1, row+1, r, d, targetRow, targetCol);
	        }
	        // returning the cases for quad Partition
	        
	    }

//	 public static boolean quadpart2(int mat[][], int rowLength, int colLength, int target, int l, int u, int r, int d, int targetRow, int targetCol)
	 {
		 
	 }
}
