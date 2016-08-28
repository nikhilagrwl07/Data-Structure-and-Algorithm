/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberOfPathWithCostK;

/**
 *
 * @author nikhil.agrawal
 */
public class Main {
    
    static int[][][] rubikcube;
    
    public static void main(String[] args) {

        int a[][] = {
                    {1, 2, 3},
                    {4, 6, 5},
                    {3, 2, 1 }
                     };
        
        int k =12;
//        
        System.out.println(numberOfPath(a, k, a.length-1, a[0].length-1));
//        
//        System.out.println(" x= " + x);
        initilize3DMatrix(a.length , a[0].length, 13);
//        print3DMatrix(a.length-1 , a[0].length-1, 13);
        
        System.out.println(pathCountDPRecDP(a, a.length-1, a[0].length-1 , k));
        
//        System.out.println(" y= " + y);
    }
    
    static int x = 0 , y =0;
    public static int numberOfPath(int a[][], int k , int m , int n){
        
        x++;
       // System.out.println("m = " + m + " n = " +n + " K = " + k);
        
        if(m<0 || n<0) 
            return 0;
        
        if(m==0 && n ==0) 
        {
            if(a[m][n]==k)
                return 1;
            else
                return 0;
        }
        
        int t = numberOfPath(a, k-a[m][n], m-1, n) 
                + numberOfPath(a, k-a[m][n], m, n-1);
        
        return t;
 
    }
    

    
   public  static int pathCountDPRecDP(int mat[][], int m, int n, int k)
{
       y++;
    // Base cases
    if (m < 0 || n < 0) 
        return 0;
    
    if (m==0 && n==0) 
    {
        if(k == mat[m][n]) 
            return 1;
        else 
            return 0;
        
    }
 
       System.out.println("m = " + m + " n = " +n + " K = " + k);
       
    // If this subproblem is already solved
    if (rubikcube[m][n][k] != -1) 
        return rubikcube[m][n][k];
 
    // (m, n) can be reached either through (m-1, n) or
    // through (m, n-1)
    rubikcube[m][n][k] = pathCountDPRecDP(mat, m-1, n, k-mat[m][n]) +
                  pathCountDPRecDP(mat, m, n-1, k-mat[m][n]);
 
    return rubikcube[m][n][k];
}
   
   public static void  initilize3DMatrix(int m , int n , int k)
   {
       //System.out.println("Inside initilizr " + m + "    "+ n+ "    " + k );
       rubikcube = new int[m][n][k];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               for(int x=0;x<k;x++){
                   rubikcube[i][j][x]=-1;
               }
           }
       }
   }
   
  public static void  print3DMatrix(int m , int n , int k)
   {
      // rubikcube = new int[m][n][k];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               for(int x=0;x<k;x++){
                   System.out.print(rubikcube[i][j][x] + "  ");
               }
           }
       }
   }

}
