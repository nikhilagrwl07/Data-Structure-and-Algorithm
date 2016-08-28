package dynamicprogramming;

public class LIS_dp_nlogn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={10, 22, 9, 33, 21, 50, 41, 60, 80};
		
		
		LIS_dp_nlogn ob=new LIS_dp_nlogn();
		
		//ob.printArray(a,a.length);
		
		ob.lis(a);	
		
		
	}
	
	
	public void lis(int a[])
	{
		// declaring another array of same length
		int tailArry[]=new int[a.length];
		int prevIndices[]=new int[a.length];
		
		tailArry[0]=0;
		prevIndices[0]=-1;
		
		int len=1; // always pointing to empty slot
		
		for(int i=1;i<a.length;i++)
		{
			
			// condition 1: new smallest value
			if(a[i]<tailArry[0])
			{
				tailArry[0]=i;
			}
			
			// condition 2: A[i] wants to extend largest subsequence
			else if(a[i]>a[tailArry[len-1]])
			{
				prevIndices[i]=tailArry[len-1];
				tailArry[len++]=i;
			}
			
			// condition 3: if a[i] replaces the current element of the subsequence
			else
			{
				int pos=ceilIndex(tailArry,-1,len-1,a[i]);
				
				System.out.println("pos = "+pos);
				
				prevIndices[i]=tailArry[pos-1];
				
				tailArry[pos]=i;
			}
			System.out.println(" prevIndices[" +i+"] = "+prevIndices[i]+" tailArry[" +i+"] = "+tailArry[i]);
			
			
		}		
		/*for(int j=0;j<prevIndices.length;j++)
		{
			System.out.print(prevIndices[j]+"  ");
		}*/
		
		
		// printing the array
		for(int i=tailArry[len-1];i>=0;i=prevIndices[i])
			System.out.println("index = "+prevIndices[i]+ " value= "+a[i]);
	}
	
/*	public void lis(int a[])
	{
		// declaring another array of same length
		int tailArry[]=new int[a.length];
		
		tailArry[0]=a[0];
		
		int len=1; // always pointing to empty slot
		
		for(int i=1;i<a.length;i++)
		{
			
			// condition 1: if a[i] is smaller than tailArry[0]
			if(a[i]<tailArry[0])
			{
				tailArry[0]=a[i];
			}
			
			// condition 2: if a[i] is greater than the tailArry[len]
			else if(a[i]>tailArry[len-1])
			{
				tailArry[len++]=a[i];
			}
			
			// condition 3: if a[i] replaces the current element of the subsequence
			else
			{
				tailArry[ceilIndex(tailArry,-1,len-1,a[i])]=a[i];
				
			}
			
		}		
		printArray(tailArry,len);
		
		
	}
	*/

	public int ceilIndex(int a[],int l,int r, int key)
	{
		int m;
		
		while(r-l>1)
		{
			m=l+(r-l)/2;
			int x=(a[m]>=key?r:l);
			
			if(x==r)
				r=m;
			else
				l=m;		
			
		}
		
		return r;
	}
	
	
	public void printArray(int a[],int s)
	{
		for(int i=0;i<s;i++)
		{
			System.out.print(a[i]+"  ");
		}
		
		System.out.println();
	}

}
