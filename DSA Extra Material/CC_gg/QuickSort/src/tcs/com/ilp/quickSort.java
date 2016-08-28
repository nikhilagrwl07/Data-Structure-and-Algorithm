package tcs.com.ilp;

public class quickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={10,6,5,56,89,55,100,-20};

	quickSort qs=new quickSort();
		//setting pivot as last element

	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+"  ");
	}
	
	// recursive implementation of quickSort
	qs.quicksort(a, 0, a.length-1);
	System.out.println("\nAfter sorting----");
	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+"  ");
	}
	}
	
	
	public int partition(int a[],int l,int h){
		int x=a[h];
		int i=(l-1);
		
		for(int j=l;j<=h-1;j++){
		 if(a[j]<=x && i!=j){
			 i++;
			 int k=a[i];
			 a[i]=a[j];
			 a[j]=k;
		 }
		}
		int g=a[i+1];
		a[i+1]=a[h];
		a[h]=g;
		return (i+1);
	}
	public void quicksort(int a[],int l,int h){
		if(l<h){
			int p=partition(a,l,h);
			quicksort(a,l,p-1);
			quicksort(a,p+1,h);
		}
	}
	

}
