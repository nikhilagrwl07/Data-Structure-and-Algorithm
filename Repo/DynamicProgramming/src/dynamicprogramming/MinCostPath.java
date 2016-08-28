
package dynamicprogramming;

public class MinCostPath {
    
     public static void main(String[] args) {
    
     int m[][]={ {1,2,3},
                 {4,8,2},     
                 {1,5,3}};
      
     printMatrix(m);
     
        solution(m);
     
    }
     public static void solution(int m[][])
     {
         int row=m.length-1;
         int col=m[0].length-1;
 System.out.println("Naive recursive solution = "+naiveUtil(m,row,col));
 System.out.println("DP solution = "+DP(m,row,col));         
     }

     public static int naiveUtil(int m[][],int r,int c)
     {
           if (r < 0 || c < 0)
             return Integer.MAX_VALUE;//_MAX;
           
           
         if(r==0 && c==0)
         {
             return m[r][c];
         }
         
         int p1=naiveUtil(m,r-1,c-1);
         int p2=naiveUtil(m,r,c-1);
         int p3=naiveUtil(m,r-1,c);
         
         return m[r][c]+Math.min(p1, Math.min(p2, p3));
     }
     
     public static int DP(int m[][],int r,int c)
     {
         int t[][]=new int[r][c];
         
         t=intialize(t,r,c);
         int i,j;
         
         for(i=0;i<r;i++)
         {
             for(j=0;j<c;j++)
             {
                 if(i==0 && j==0)
                     t[i][j]=m[i][j];
                 else
                 {
                     if(i-1>=0)
                     {
                         
                     }
                 }
             }
         }
         return -1;
     }
     
     public static int[][] intialize(int a[][],int r,int c)
     {
         for(int i=0;i<r;i++)
         {
             for(int j=0;j<c;j++)
             {
                 a[i][j]=Integer.MAX_VALUE;
             }
         }
         return a;
     }
     public static void printMatrix(int m[][])
     {
         int row=m.length;
         int col=m[0].length;
         int i,j;
         
         for(i=0;i<row;i++)
         {
             for(j=0;j<col;j++)
             {
                 System.out.print(m[i][j]+" ");
             }
             System.out.println();
         }
         
     }
}
