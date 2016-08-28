
package dynamicprogramming;

public class CoinExchange {
    
     public static void main(String[] args) {
         
         int sum=10;  // sum to be calculated
         
         // types of coins
         int coin[]=new int[4];
         coin[0]=3;
         coin[1]=2;
         coin[2]=5;
        coin[3]=6;
         ////coin[3]=6;
         
     solution(coin,coin.length-1,sum);
     
    }
     public static void solution(int coin[],int len,int sum)
     {
   System.out.println("Number of possible ways (recursive) = "+naiveUtil2(coin,len,sum));
 System.out.println("Number of possible ways (DP) = "+bottomUp_DP(coin, sum));
 System.out.println("Number of possible ways (Space optimized DP) = "+bottomUp_spaceOptimized_DP(coin, sum));    
     }


     //Souce: http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
      public static int naiveUtil2(int coin[],int types,int sum)
      {
          if(sum==0)   // if sum=0 , then only 1 way is possible (no coin)
              return 1;
          
          if(sum <0)
              return 0;
          
          if(sum>0 && types<0)  // types starts from 0 to types , so types<0
              return 0;
          
          return naiveUtil2(coin,types,sum-coin[types])+naiveUtil2(coin,types-1,sum);
                  // including coin[types]                   exculeding coin[types]
      
      }

      
      // value array contains different values of coins // sum is total sum
      public static int bottomUp_DP(int value[],int sum)
      {
          int i,j,types=value.length,x,y;
          
          // forming the table
          int[][] table=new int[sum+1][types];
          
          // for sum =0 --> no of counts possible =1(No coins)
          for(j=0;j<types;j++)
          {
              table[0][j]=1;
          }
          
          // travsersing for each value of sum = 1 to sum
          for(i=1;i<=sum;i++)
          {
              
              for(j=0;j<types;j++)  // for each coin types
              {
                  // include value[j] in sum
                  x=(i-value[j]>=0)?table[i-value[j]][j]:0;
                  
                  // exclude value[j] from sum
                  y=(j>=1)?table[i][j-1]:0;
                  
                  table[i][j]=x+y;
              }
          }
          
          return table[--i][--j];
      }

      public static int bottomUp_spaceOptimized_DP(int value[],int sum)
      {
          int[] table=new int[sum+1];
          int i,j;
          
          for(i=0;i<table.length;i++)
              table[i]=0;
        
         table[0]=1;
         
         for(i=0;i<value.length;i++)
         {
             for(j=value[i];j<table.length;j++)
             {
                 table[j]+=table[j-value[i]];
             }
         }
          return table[table.length-1];
          
      }
}
