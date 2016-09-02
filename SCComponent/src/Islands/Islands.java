
package Islands;

public class Islands {

    static int ROW , COLUMN ;

    public static void main(String[] args) {
        int M[][] = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};
        ROW=M.length;
        COLUMN= M[0].length;
        
        System.out.println("Number of islands = "  + countIslands(M));
        
    }
    
    public static int countIslands(int m[][]){
        
        boolean visited[][] = new boolean[ROW][COLUMN];
        
        int count =0;
        
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COLUMN;j++){
                if(m[i][j]==1 && !visited[i][j]){
                    
                    DFS(m,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void DFS(int m[][], int row, int col, boolean visited[][]){
        
        int rowNeigh[] = {-1,-1,-1,0,0,1,1,1};
        int colNeigh[] = {-1,0,1,-1,1,-1,0,1};
        
        visited[row][col]= true;
        
        for(int k=0;k<8 ;k++)
        {
            if(isSafe(m,row+rowNeigh[k],col+colNeigh[k],visited))
            {
                DFS(m, row+rowNeigh[k], col+colNeigh[k], visited);
            }
        }
    }
    
    public static boolean isSafe(int[][] m,int row, int col,boolean[][] visited){
        
        return row>=0 && row<ROW && col>=0 && col <COLUMN 
                && !visited[row][col] && m[row][col]==1;
           
    }
}
