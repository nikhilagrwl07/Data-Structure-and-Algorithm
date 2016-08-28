
package dynamicprogramming;

public class ZeroOneKnapsack {
    
     public static void main(String[] args) {
         
       int val[] = {60, 100, 120};
    int wt[] = {10, 20, 30};
    int  W = 50;
        
        solution(val,wt,W);
     
     
    }
     public static void solution(int[] val,int[] wt,int W)
     {
    System.out.println("Recursive naive approach = "+Naive_recursive(val,wt,W,0));
    System.out.println("DP bottom Up = "+dp_bottomUp(W,wt,val));
     }

      
     // want to maximize the subset value of val for W=0
     public static int Naive_recursive(int[] val,int[] wt,int W,int i)
     {
         // variable i indicate particular value to be included or not
         if(W==0 || i>wt.length-1) 
         {
                return 0;
         }         
         
      if(wt[i]>W)   
          return Naive_recursive(val,wt,W,i+1);
      else   
     return Math.max(val[i]+Naive_recursive(val,wt,W-wt[i],i+1),Naive_recursive(val,wt,W,i+1));
     
     }


    public static int dp_bottomUp(int W, int wt[], int val[])
    {
        // table formation
      //  System.out.println("len = "+(val.length+1));
        
        int[][] t=new int[val.length+1][W+1];
        int i,j;
        
        for(i=0;i<=val.length;i++)
            t[i][0]=0;
        
        for(j=0;j<=W;j++)
            t[0][j]=0;
        
        for(i=1;i<=val.length;i++)
        {
            for(j=1;j<=W;j++)
            {
                //System.out.println("i= "+i+" j= "+j);
                    if(wt[i-1]<=j)
                    {
                        t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                    }
                    else
                    {
                        t[i][j]=t[i-1][j];
                    }
            }
        }
        
        return t[--i][--j];
        
    }
}
