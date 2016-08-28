package nikhil.segment.Tree;

public class SegmentTreeHandler {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
		SegmentTreeHandler sg=new SegmentTreeHandler();
		
		// Build segment tree from given array
	    int st[] = sg.constructST(arr, arr.length);
	    
	 // Print sum of values in array from index 1 to 3
	    System.out.println("Sum of values in range 1 to 3 is "+sg.getSum(st,arr.length,1,3));
	    
	 // Update: set arr[1] = 10 and update corresponding segment
	    // tree nodes
	 //   updateValue(arr, st, arr.length, 1, 10);
	}

	/* Function to construct segment tree from given array. This function
	   allocates memory for segment tree and calls constructSTUtil() to
	   fill the allocated memory */
	public int[] constructST(int a[],int len)
	{
		
		double ht=Math.ceil(Math.log10(len)/Math.log10(2.0)); // calculating the height of tree
		int max_size=2*(int)Math.pow(2.0, ht)-1;
		int s[]=new int[max_size];
		
		// Fill the allocated memory st
	    constructSTUtil(a, 0, len-1, s, 0);	 
		return s;
	}
	
	// A recursive function that constructs Segment Tree for array[ss..se].
	// si is index of current node in segment tree st
	public int constructSTUtil(int arr[],int ss,int se,int st[],int si)
	{
		// If there is one element in array, store it in current node of
	    // segment tree and return
		System.out.println("Its check 1");
	    if(ss==se)
	    {
	    	System.out.println("Its check 2");
	        st[si] = arr[ss];
	        return arr[ss];
	    }   
	    
	 // If there are more than one elements, then recur for left and
	    // right subtrees and store the sum of values in this node
	    int mid = se+(se-ss)/2;
	    if(si*2+1<=arr.length-1 && si*2+2<=arr.length-1)
	    	st[si] =  constructSTUtil(arr, ss, mid, st, si*2+1) +constructSTUtil(arr, mid+1, se, st, si*2+2);
	    
	    
	    return st[si];
	}
	
	public int getSum(int st[], int n, int qs, int qe)
	{
		 // Check for erroneous input values
	    if (qs < 0 || qe > n-1 || qs > qe)
	    {
	        System.out.println("Invalid Input");
	        return -1;
	    }
	    
	    return getSumUtil(st, 0, n-1, qs, qe, 0);
	}
	
	/*  A recursive function to get the sum of values in given range of the array.
    The following are parameters for this function.
 
    st    --> Pointer to segment tree
    index --> Index of current node in the segment tree. Initially 0 is
             passed as root is always at index 0
    ss & se  --> Starting and ending indexes of the segment represented by
                 current node, i.e., st[index]
    qs & qe  --> Starting and ending indexes of query range */
	public int getSumUtil(int st[], int ss, int se, int qs, int qe, int index)
	{
		// If segment of this node is a part of given range, then return the
	    // sum of the segment
	    if (qs <= ss && qe >= se)
	        return st[index];
	 
	    // If segment of this node is outside the given range
	    if (se < qs || ss > qe)
	        return 0;
	 
	    // If a part of this segment overlaps with the given range
	    int mid = se+(se -ss)/2;
	   // if(index<=st.length-1 && index<=st.length-1)
		System.out.println("Its check 3");
	    	return (getSumUtil(st, ss, mid, qs, qe, 2*index+1) +getSumUtil(st, mid+1, se, qs, qe, 2*index+2));
	   // elsekbkj
	    //	return 0; 
	}
}
