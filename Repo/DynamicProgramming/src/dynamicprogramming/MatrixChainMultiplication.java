
package dynamicprogramming;

public class MatrixChainMultiplication {
    
     public static void main(String[] args) {
         
        int m[]={40, 20, 30, 10, 30};
        
        solution(m);
     
     
    }
     public static void solution(int m[])
     {
         System.out.println("DP = ");
         DP_bottomUp(m);
         System.out.println("Recursive naive approach = "+MatrixChainOrder(m,1,m.length-1));
     }

 public static int MatrixChainOrder(int p[], int i, int j)
{
    if(i == j)
        return 0;
    int k;
    int min = Integer.MAX_VALUE;
    int count;
 
    // place parenthesis at different places between first and last matrix,
    // recursively calculate count of multiplcations for each parenthesis
    // placement and return the minimum count
    for (k = i; k <j; k++)
    {
        count = MatrixChainOrder(p, i, k) +
                MatrixChainOrder(p, k+1, j) +
                p[i-1]*p[k]*p[j];
 
        if (count < min)
            min = count;
    }
 
    // Return minimum count
    return min;
}
     
     public static void DP_bottomUp(int[] m)
     {
         int l=m.length,diff,j,i,k,p=-1;
         
         int[][] t=new int[l][l];
         
         for(i=0;i<l;i++)
             t[i][i]=0;
         
         
         // i--> for taking the difference
         // j --> for implementing the result
         for(diff=1;diff<l;diff++)
         {
             for(j=diff;j<l;j++)
             {
                   i=j-diff;
                   // i and j has been created
     // recursion : m(i,j)=Max{m(i,k)+m(k+1,j)+P(i-1)*P(k)*P(j)} i<=k<j
                   int min=Integer.MAX_VALUE;
                for(k=i;k<j;k++)   
                {
                    System.out.println("i= "+i+" j= "+j+" k= "+k);
                    
                    if(j==i+1)
                        p=i*j*(j+1);
                    else
                    {    
                        p=t[i][k]+t[k+1][j]+(m[i-1]*m[k]*m[j]);

                        if(p<min)
                        {
                            min=p;
                        }
                    }
                    
                }
                t[i][j]=p;   
             }
             
         }
         
         for(i=0;i<l;i++)
         {
             for(j=0;j<l;j++)
             {
                 System.out.print(t[i][j]+" ");
             }
             System.out.println();
         }
     }



}
