package nikhil.geeksforgeeks;

public class SegementTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 7, 9, 11};
		int ss=1,se=5;
		// Build segment tree from given array
		int a[]=constructST(arr);
		System.out.println("Tree has been constructed");
		
	//	System.out.println("Minimum value in range " + ss+" to "+se +" is "+RMQ(a,arr.length,ss,se));
	}
	public static int[] constructST(int a[])
	{
		double x=Math.log(a.length)/Math.log(2)+1.0;
		
		// calculate height of tree
		int ht=(int) x;

		// maximum size of segement tree
		int n=2*(int)Math.pow(2, ht)-1;
		
		int s[]=new int[n]; // segement tree array formation
		
		//fill the constructed tree
		constructSTUtil(a,0,a.length-1,s,0);
		
		// returning the constructed segement tree
		return s;
	}
	// A recursive function that constructs Segment Tree for array[ss..se].
	// si is index of current node in segment tree st
	public static int constructSTUtil(int a[],int ss,int se,int s[],int si)
	{
		// if there is only one element then put element in s array
		if(ss==se)
		{
			s[si]=a[ss];
			return a[ss];
		}
		
		// if there are more than one element than recur both left and right ans store the minimum element 
		int midIndex=ss+(se-ss)/2;
		s[si]=minVal(constructSTUtil(a,ss,midIndex,s,si*2+1),constructSTUtil(a,ss,midIndex,s,si*2+2));
		return s[si];
	}
	public static int minVal(int a, int b)
	{
		if(a<b)
		{
			return a;
		}
		else 
			return b;
	}

	/*public int RMQ(int s[],int len,int qs,int qe)
	{
		if(qs<0 || qs>len-1 || len==0 || qs>qe)
		{
			System.out.println("Invalid input");
			return -1;
		}
		
		return RMQUtils(s,0,len-1,qs,qe,0);
	}*/
	//public int RMQUtils()
}
