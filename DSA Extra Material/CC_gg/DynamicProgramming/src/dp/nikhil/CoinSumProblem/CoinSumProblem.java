// Question: Find minimum number of coins of given denominations for summing upto the given sum S. Solution via DP approach

package dp.nikhil.CoinSumProblem;

public class CoinSumProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum=110;
		int denomiation[]={1,3,5};
		int minCoin[]=new int[sum+1];  // for storing the sum 1 to sum
		
		minCoin[0]=0;  //showing the base case
		
		// initialzie the minimum to 1000;
		for(int i=1;i<minCoin.length;i++)
		{
			minCoin[i]=1000;
		}
		
		minCoin=dp_solution(sum,denomiation,minCoin);
		
		
		// initialzie the minimum to 1000;
		for(int i=0;i<minCoin.length;i++)
		{
			System.out.println("sum ="+i+" Coins= "+minCoin[i]);		
		}
	}
	
	public static int[] dp_solution(int sum,int denomination[],int minCoin[])
	{
		if(sum==0)
			return minCoin;
		
		System.out.println("DP Solution for Coin exchnage problem \n");
		
		// calucalting for every sum from 1 to sum
		for(int i=1;i<=sum;i++)
		{			
			// for each sum taking each denomation
			for(int j=0;j<denomination.length;j++)
			{
				if(denomination[j]<=i && minCoin[i-denomination[j]]+1<minCoin[i])
				{
					minCoin[i]=minCoin[i-denomination[j]]+1;
					
				}
			}
//		/	System.out.println("sum ="+i+" Coins= "+minCoin[i]+"Denominatio = "+);		
		}
		
		return minCoin;
	}
	
	
	

}
