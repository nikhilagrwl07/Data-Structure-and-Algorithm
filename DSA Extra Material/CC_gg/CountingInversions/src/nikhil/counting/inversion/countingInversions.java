package nikhil.counting.inversion;

public class countingInversions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a[]={10,5,-68,65,78,-100,89};
		int temp[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		System.out.println("Inversion number: "+mergeSort(a,temp,0,a.length-1));
		System.out.println("After sorting....");
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(temp[i]);
		}
	}
	
	public static int mergeSort(int a[],int temp[],int l, int r)
	{
		int inv_total=0;
		if(l<r)
		{
			int mid=(l+r)/2;
			inv_total=mergeSort(a,temp,l,mid);
			inv_total+=mergeSort(a,temp,mid+1,r);
			
			inv_total+=merge(a,temp,l,mid+1,r);
		}
		return inv_total;
	}
	
	public static int merge(int a[],int temp[],int s,int mid,int e)
	{
		int x=0,inv=0;
		int mid2=mid++;
		while(true)
		{
			if(s<mid && a[s]<a[mid2])
			{
				temp[x]=a[s];
				s++;
				
			}
			else if(mid2<e && a[s]>a[mid2])
			{
				temp[x]=a[mid2];
				mid2++;
				inv +=e-mid2;
			}
			else 
				break;
			
			x++;
			
		}
		
		if(s<mid)
		{
			inv +=mid-s;
			
			for(int t=s;t<=mid;t++)
			{
				temp[x]=a[t];
				x=x+1;
			}
		}
		if(mid2<e)
		{
			for(int t=mid2;t<e;t++)
			{
				temp[x]=a[t];
				x=x+1;
			}
		}
		return inv;
	}

}


