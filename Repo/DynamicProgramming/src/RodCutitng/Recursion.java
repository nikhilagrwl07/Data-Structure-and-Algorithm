
package RodCutitng;


public class Recursion {

    public static void main(String[] args) {
     
       
       int[] price={1 ,  5 ,  8 ,  9 , 10 , 17 , 17  ,20};
       
         int n=price.length;
         
         
       int maxIncome=cutRodRecursion(price,n);

       System.out.println("(Recursion) Max income= "+maxIncome);
       
       int maxIncomeDP=DP(price,n);

       System.out.println("(DP) Max income= "+maxIncomeDP);
    }
    
    // return best possible income for cutting rod of length=n
    // Remember n= length of rod NOT indices of length
   public static int cutRodRecursion(int[] p,int n)
   {
       if(n<=0)
           return 0;
       
       int max_val=Integer.MIN_VALUE;
       
       // checking each posssible cut that can be made on length n
       for(int i=1;i<=n;i++)
       {// here i is working as length of rod
           max_val=Math.max(max_val, p[i-1]+cutRodRecursion(p, n-i));
       }
       
       return max_val;
   }
   
    // Time complexity- O(n^2)
   public static int DP(int p[],int len)
   {
       if(len<=0)
           return 0;
       // stores the optimal income by selling log of length i =val[i]
       int val[]=new int[p.length+1];
       val[0]=0;
       
       for(int i=1;i<=len;i++)
       {
           int max_val=Integer.MIN_VALUE;
           
           for(int j=0;j<i;j++)
           {
               max_val=Math.max(max_val, p[j]+val[i-j-1]);
           }
           val[i]=max_val;
       }
       
       return val[len];
   }
    
}
