package dynamicprogramming;

public class LIS_naive {

	public static void main(String[] args) {
		
		int a[]={10, 22, 9, 33, 21, 50, 41, 60,80};
		
		//int b[]=new int[a.length];
		
                System.out.println("LIS length :: " + lis_check(a, a.length));
//                
//                
//		int i=0;
//		
//		while(i<b.length && b[i]!=-1)
//		{
//			System.out.print(b[i]+"  ");
//			i++;
//		}
//		System.out.println();
	}
        
        
        // writing recusrive 
        
        
   static int max =1;
   
   
    
// The wrapper function for _lis()
public static int lis_check(int arr[], int n)
{
    // The max variable holds the result
   // int max = 1;
 
    // The function _lis() stores its result in max
    _lis( arr, n);
    
 
    // returns max
    return max;
}


public static int _lis( int arr[], int n)
{
    /* Base case */
    if (n == 1)
        return 1;
 
    // 'max_ending_here' is length of LIS ending with arr[n-1]
    int res, max_ending_here = 1; 
 
    /* Recursively get all LIS ending with arr[0], arr[1] ... 
       arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and 
       max ending with arr[n-1] needs to be updated, then 
       update it */
    for (int i = 1; i < n; i++)
    {
        res = _lis(arr, i);
        if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
            max_ending_here = res + 1;
    }
 
    // Compare max_ending_here with the overall max. And 
    // update the overall max if needed
    if (max < max_ending_here)
    {
        max = max_ending_here;
    }
 
    // Return length of LIS ending with arr[n-1]
    return max_ending_here;
}

 
        
//	public static int[] lis(int a[])
//	{
//		if(a.length==0 || a.length==1)
//			return a;
//		
//		int i,j,g,t,t2,maxlen=0,final_max=0,b_counter=0;
//		
//		int b[]=new int[a.length];
//		
//		for(int k=0;k<a.length;k++)
//			b[k]=-1;
//		
//		for(i=0;i<a.length-1;i++)
//		{
//			b_counter=0;
//			t=a[i];
//			t2=a[i];
//			j=i+1;
//			g=i+1;
//			maxlen=1;
//		//	b[b_counter++]=a[i];
//		//	System.out.println("i = "+a[i]);
//			while(j<a.length)
//			{
//				if(t<=a[j])
//				{
//					//System.out.print(" "+a[j]);
//					b[b_counter]=a[i];
//					maxlen++;
//					t=a[j];
//				}
//				j++;
//			}
//			
//			System.out.println("maxlen= "+maxlen);
//			System.out.println("final_max= "+final_max);
//			
//			if(final_max<maxlen)
//			{				
//				final_max=maxlen;
//				
//				while(g<a.length)
//				{
//					if(t2<=a[g])
//					{
//						b[++b_counter]=a[g];
//						t2=a[g];
//					}
//					
//					g++;
//				}
//			}
//		//	System.out.println();
//		}
//		return b;
//	}

}
