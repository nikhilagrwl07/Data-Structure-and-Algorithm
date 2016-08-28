

package practice_island_DFS;


// Java program to count islands in boolean 2D matrix
 
public class Islands
{
    //No of rows and columns
//    static final int ROW = 5, COL = 5;
 
    // A function to check if a given cell (row, col) can
    // be included in DFS
//    boolean isSafe(int M[][], int row, int col,
//                   boolean visited[][])
//    {
//        // row number is in range, column number is in range
//        // and value is 1 and not yet visited
//        return (row >= 0) && (row < ROW) &&
//               (col >= 0) && (col < COL) &&
//               (M[row][col]==1 && !visited[row][col]);
//    }
 
    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(String[] M, int row, int col, boolean visited[][])
    {
        
        visited[row][col] = true;
        visited[col][row] = true;
        
        for(int k = 0;k<M.length;k++)
        {
            char[] c = M[row].toCharArray();
            
            if(c[k]== '1' && !visited[row][k])
            {
                visited[row][k]=true;
                visited[k][row]=true;
            }
        }
        
    }
 
    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    int countIslands(String[] zombies)
    {
        
        int ROW =zombies.length;
        int COL= ROW;
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];
         
        
        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
        {
            for (int j = 0; j < COL; ++j)
            { 
                char[] s = zombies[i].toCharArray();
                
                if(i==j)
                {
                   visited[i][j]=true; 
                }
                else if (s[j]=='1' && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island coun
                    DFS(zombies, i, j, visited);
                    ++count;
                }
            }
        }
        
        if(count==0)
        {
            return ROW;
        }
        
        return count;
        
    }
 
    // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
//        int M[][]=  new int[][] {
////                                {1,1,0,0},
////                                {1,1,1,0}, 
////                                {0,1,1,0},
////                                {0,0,0,1}
//            
//            
//                                {1,0,0,0,0},
//                                {0,1,0,0,0}, 
//                                {0,0,1,0,0},
//                                {0,0,0,1,0},
//                                {0,0,0,0,1}
//                               };
        String[] s = {"1100",
                      "1110",
                    "0110",
                    "0001"};
        Islands I = new Islands();
        System.out.println("Number of islands is: "+ I.countIslands(s));
    }
} //Contributed by Aakash Hasija