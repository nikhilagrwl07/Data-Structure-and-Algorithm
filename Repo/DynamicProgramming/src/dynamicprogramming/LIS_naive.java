package dp.nikhil.zigZagSequence;

public class LIS_naive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={10, 22, 9, 33, 21, 50, 41, 60,80};
		
		int b[]=new int[a.length];
		//System.out.println("Max LIS lenght = "+lis(a));
		System.out.println("LIS ");
		b=lis(a);
		
		int i=0;
		
		while(i<b.length && b[i]!=-1)
		{
			System.out.print(b[i]+"  ");
			i++;
		}
		System.out.println();
	}
	public static int[] lis(int a[])
	{
		if(a.length==0 || a.length==1)
			return a;
		
		int i,j,g,t,t2,maxlen=0,final_max=0,b_counter=0;
		
		int b[]=new int[a.length];
		
		for(int k=0;k<a.length;k++)
			b[k]=-1;
		
		for(i=0;i<a.length-1;i++)
		{
			b_counter=0;
			t=a[i];
			t2=a[i];
			j=i+1;
			g=i+1;
			maxlen=1;
		//	b[b_counter++]=a[i];
		//	System.out.println("i = "+a[i]);
			while(j<a.length)
			{
				if(t<=a[j])
				{
					//System.out.print(" "+a[j]);
					b[b_counter]=a[i];
					maxlen++;
					t=a[j];
				}
				j++;
			}
			
			System.out.println("maxlen= "+maxlen);
			System.out.println("final_max= "+final_max);
			
			if(final_max<maxlen)
			{				
				final_max=maxlen;
				
				while(g<a.length)
				{
					if(t2<=a[g])
					{
						b[++b_counter]=a[g];
						t2=a[g];
					}
					
					g++;
				}
			}
		//	System.out.println();
		}
		return b;
	}

}
