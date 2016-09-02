
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
         int row=m.length;
         int col=m[0].length;
       //  System.out.println("Naive recursive solution = "+naiveUtil(m,row,col));
         minCost_dp(m,row,col);         
     }

//     public static int naiveUtil(int m[][],int r,int c)
//     {
//           if (r < 0 || c < 0)
//             return Integer.MAX_VALUE;//_MAX;
//           
//           
//         if(r==0 && c==0)
//         {
//             return m[r][c];
//         }
//         
//         int p1=naiveUtil(m,r-1,c-1);
//         int p2=naiveUtil(m,r,c-1);
//         int p3=naiveUtil(m,r-1,c);
//         
//         return m[r][c]+Math.min(p1, Math.min(p2, p3));
//     }
//     
    public static void minCost_dp(int m[][],int r,int c)
    {
        int t[][]=new int[r][c];
        t[0][0]=m[0][0];

        for(int i=1;i<r;i++)
            t[i][0]= t[i-1][0]+m[i][0];
        for(int j=1;j<c;j++)
            t[0][j]= t[0][j-1]+m[0][j];

        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                t[i][j]=Math.min(t[i-1][j-1],Math.min(t[i][j-1],t[i-1][j]))+m[i][j];
            }
        }

        System.out.println("the min distance is " + t[r-1][c-1]);
    }
      
//     public static int DP(int m[][],int r,int c)
//     {
//         int t[][]=new int[r][c];
//         
//         t=intialize(t,r,c);
//         int i,j;
//         
//         for(i=0;i<r;i++)
//         {
//             for(j=0;j<c;j++)
//             {
//                 if(i==0 && j==0)
//                     t[i][j]=m[i][j];
//                 else
//                 {
//                     if(i-1>=0)
//                     {
//                         
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
     
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
