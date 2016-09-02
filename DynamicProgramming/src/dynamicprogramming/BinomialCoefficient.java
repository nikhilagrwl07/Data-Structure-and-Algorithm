
package dynamicprogramming;

public class BinomialCoefficient {
    
     public static void main(String[] args) {
         
        int n=10,k=3;
        
        solution(n,k);
     
     
    }
     public static void solution(int n,int k)
     {
         //System.out.println("Iterative naive approach = "+naive_iterative(m));
         System.out.println("Recursive naive approach = "+Naive_recursive(n,k));
         System.out.println("DP bottom Up = "+dp_bottomUp(n,k));
     }

     public static int Naive_recursive(int n,int k)
     {
         if(n<k)
             return -1;
         
         if(n==k)
             return 1;
         
         if(k==1)
             return n;
         
         return (n*Naive_recursive(n-1,k-1))/k;
     }

     public static int dp_bottomUp(int n,int k)
     {
         int i=0,j=0;
         // table
         int[][] table=new int[n+1][k+1];
         
         for(i=0;i<=n;i++)
             table[i][0]=1;
         
         for(i=1;i<=n;i++)
         {
             for(j=1;j<=k;j++)
             {
                 if(i==j)
                     table[i][j]=1;
                 else if(i<j)
                     table[i][j]=-1;
                 else
                     table[i][j]=(table[i-1][j-1]*i)/j;
             }
         }
         
         return table[--i][--j];
     }
}
