package dp.nikhil.zigZagSequence;

public class LIS_dp {

	public static void main(String[] args) {
		int a[]={10, 22, 9, 33, 21, 50, 41, 60,80};
		
		int b[]=new int[a.length];
		
		//System.out.println("Max LIS lenght = "+lis(a));
		
		System.out.println("LIS ");
		b=lis(a);

		System.out.print(b[0]);
		for(int i=1;i<b.length;i++)
		{
			if(b[i]!=b[i-1])
				System.out.print("  "+ b[i]+" ");
		}
		System.out.println();
	}
	
	// tabulation(Bottom Up) version of LIS 
	public static int[] lis(int a[])
	{
		if(a.length==0 || a.length==1)
			return a;
		
		int i;
//		/int b[]=new int[a.length];
		
		//b[0]=a[0];
		
		for(i=1;i<a.length;i++)
		{
			if(a[i-1]>a[i])
				a[i]=a[i-1];
			
		}
		return a;
	}

}
