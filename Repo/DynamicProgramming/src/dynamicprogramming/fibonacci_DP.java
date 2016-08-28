package dp.nikhil.zigZagSequence;

public class fibonacci_DP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibonacci_DP ob=new fibonacci_DP();
		
		int n=10;
		
		int a[]=new int[n+1]; // temp array
			
		ob.initialze(a);
		
	System.out.println("Top down ="+ob.fib_Top_down(n,a));
		
		System.out.println("Bottom Up ="+ob.fib_Bottom_Up(n,a));
		
	}
	
	// top down approach
	public int fib_Top_down(int n,int a[])
	{
		if(a[n]==-1) // apply the concept
		{
			if(n<=1)
			{
				a[n]=n;
			}
			
			a[n]=fib_Top_down(n-1, a)+ fib_Top_down(n-2, a);
			
		}
		
			return a[n];
		
	}

	// bottom up approach
	public int fib_Bottom_Up(int n,int a[])
	{
		int i;
		for( i=2;i<a.length;i++)
		{
			a[i]=a[i-1]+a[i-2];
			
		}
		return a[--i];
	}
	
	public void initialze(int a[])
	{
		a[0]=0;
		a[1]=1;		
		
		for(int i=2;i<a.length;i++)
			a[i]=-1;
	}

}
