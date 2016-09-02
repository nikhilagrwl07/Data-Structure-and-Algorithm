package dp.nikhil.zigZagSequence;

// length of longest zig zag sequence 
public class zigZigSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int seq[]={44};
			int len_zig_zag[]=zig_zag(seq);	

			
			for(int i=0;i<len_zig_zag.length;i++)
			{
				System.out.println(seq[i]+"  "+len_zig_zag[i]);
			}
			
	}
	public static int[] zig_zag(int []s)
	{
		int temp[]=new int[s.length]; //stores the length of max len subsequence
		
		if(s.length==0 || s.length==1)  // demo cases
			return s;
		
		if(s.length==2 && s[0]!=s[1])
			return s; 
		
		// dp approach 
		
		
		for(int i=0;i<temp.length;i++)
		{
			temp[i]=-1;
		}
		
		int pos=-1; // want to have positive diff
		
		for(int i=0;i<temp.length-1;i++)
		{
			if(i==0)
			{
			if((s[i+1]-s[i])<0 )
			{
				pos=1;     
				temp[i]=2;//-->
			}
			else if((s[i+1]-s[i])>0)
			{
				pos=0;  // want the next diff to be negative
				temp[i]=2;  //-->
			}
			}
			else if(i!=0)
			{
			if(pos==1) // diff should be positive
			{
				if((s[i+1]-s[i])<=0)
				{
					temp[i]=temp[i-1];
				}
				
				else if((s[i+1]-s[i])>0)
				{
					pos=0;
					temp[i]=temp[i-1]+1;
				}
			}
			
			else // diff should be negative
			{
				if((s[i+1]-s[i])>=0)
				{
					temp[i]=temp[i-1];
				}
				
				else if((s[i+1]-s[i])<0)
				{
					pos=1;
					temp[i]=temp[i-1]+1;
				}
			}
			}
		}
		return temp;
	}

}
