
package dynamicprogramming;

public class MatrixChainMultiplication {
    
     public static void main(String[] args) {
         
        int m[]={1, 2, 3, 4 };                       
        
        solution(m);
     
     
    }
     public static void solution(int m[])
     {
        // System.out.println("DP = ");
         System.out.println("DP approach = "+DP_bottomUp(m));
        
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
 
 
    public static int DP_bottomUp(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++)
        {
            for(int i=0; i < arr.length - l; i++)
            {
                int j = i + l;
                temp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k < j; k++)
                {
                    System.out.println("i = " + i + " k= "+ k + " j=" +j);
                    
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
//        
//        System.out.println(" a[0][1];;; " + temp[0][1]);
//         System.out.println(" a[0][2];;; " + temp[0][2]);
//          System.out.println(" a[0][3];;; " + temp[0][3]);
//           System.out.println(" a[1][2];;; " + temp[1][2]);
//            System.out.println(" a[1][3];;; " + temp[1][3]);
//             System.out.println(" a[2][3];;; " + temp[2][3]);
        
        return temp[0][arr.length-1];
    }



}
