package dp.nikhil.zigZagSequence;
// dp approach for calculating ugly number

public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		
		System.out.println("Ugly Number : "+getUglyNumber(n));
	}
	
	public static int getUglyNumber(int n)
	{
		int i2=2,i3=3,i5=5;
		
		int u[]=new int[n];
		int val=0,i;
		
		// initialing the array
		for(int j=0;j<n;j++)
			u[j]=0;
		
		// considering 1 as ugly number
		 u[0]=1;
		 
		for(i=1;i<n;i++)
		{			
			// finding minimum of all three values
			val=Math.min(u[i2],Math.min(u[i3], u[i5]));
			
			if(val==u[i2])
			{
				i2=u[i]*2;
			}
			else if(val==u[i3])
			{
				i3=u[i]*3;
			}
			else if(val==u[i5])
			{				
				i5=u[i]*5;
			}
			
			u[i]=val;
		System.out.println(u[i]);
		}
		return u[--i];
	}

}
