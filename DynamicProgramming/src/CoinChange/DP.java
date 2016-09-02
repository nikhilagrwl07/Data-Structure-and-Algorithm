
package CoinChange;

public class DP 
{
    public static void main(String[] args) {
       int N=4;
       int S[] ={1,2,3};
      
       //System.out.println(Arrays.toString(a));
//        int coinCount=TopDown(S,N,0);
//        System.out.println("Sum= "+N+" Min # of Coins= "+coinCount);
        
//        int coinCountBottomUp=bottomUp(S,N,0,0);
//       System.out.println("Sum= "+N+" Min # of Coins= "+coinCountBottomUp);
        
//         System.out.println("R Sum= "+N+" Possible # of ways= "+rec(S, S.length-1, N));
    }
  

    // Top down approach - means breaking from sum to 0
  public static int TopDown(int[] coins,int sum,int minCount)
    {
       if(sum==0)
           return minCount;
       
       int minValue=Integer.MAX_VALUE;
       
       for(int i=0;i<coins.length;i++)
       {
           if(coins[i]<=sum)
           {
               // testing for each coin of different denomination to be taken 
               int t=TopDown(coins, sum-coins[i], minCount+1);
               
               if(minValue>t)
               {
                   minValue=t;
               }
           }
       }
    
       return minValue;
    }

     // Bottom Up approach - means breaking from 0 to sum
  public static int bottomUp(int[] coins,int sum,int minCount,int calculateSum)
    {
        
       if(calculateSum==sum)
           return minCount;
       
       int minValue=Integer.MAX_VALUE;
       
       for(int i=0;i<coins.length;i++)
       {
           if(calculateSum+coins[i]<=sum)
           {
               // testing for each coin of different denomination to be taken 
               int t=bottomUp(coins, sum, minCount+1,calculateSum+coins[i]);
               
               if(minValue>t)
               {
                   minValue=t;
               }
           }
       }
    
       return minValue;
    }
  
  public static int rec(int[] coins, int length,int sum )
  {
      if(sum == 0)
      {
          return 1;
      }
      else if(sum<0 || length<0)    // not considering it
      {
       return 0;   //rec(coins, length-1, sum,ways);
      }
     
       return rec(coins, length-1, sum) + rec(coins, length, sum-coins[length]);
     }
}
