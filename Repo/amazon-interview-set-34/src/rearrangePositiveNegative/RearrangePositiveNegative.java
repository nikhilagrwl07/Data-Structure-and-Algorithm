package rearrangePositiveNegative;

public class RearrangePositiveNegative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangePositiveNegative obj=new RearrangePositiveNegative();
		int a[]={-1, 2, -3, 4, -5, 6, -7, 8, -9};
		System.out.println("Before sorting:");
		obj.print(a);
		
		obj.rearrange(a);
		System.out.println("After sorting:");
		obj.print(a);
	}
	
	public void rearrange(int a[])
	{
		// first separate the positive and negative element using partition method of quicksort technique
		// considering 0 as pivot element
		
		int i=-1;
		for(int j=0;j<a.length;j++)
		{
			if(a[j]<0)
			{
				i++;
				swap(a,i,j);
				
			}
			
		}
		System.out.println("Middle check point--");
		print(a);
		
		// now putting positive element and negative elements alternatively
		int neg=0,pos=i+1;
		
		while(neg<pos && pos<a.length && a[neg]<0)
		{
			// swapping the positive and negative elements			
			//if(a[neg]<0)
		//	{
					swap(a,neg,pos);
					neg+=2;
					pos++;
			//}			
		}
		
	}
	public void swap(int a[], int c, int b)
	{
		int t=a[c];
		a[c]=a[b];
		a[b]=t;
		
	}
	
	public void print(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"  ");
		}
	}

	
}
