package dynamicprogramming;

public class LCS_dp_bottomUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] x={'a','b','a','c','e','b'};
		char[] y={'a','d','b','a','v','c','e','b'};
	
		LCS_dp_bottomUp ob=new LCS_dp_bottomUp();
		ob.lcs(x,y);
	}
	
	// dp bottom up approach 
	public void lcs(char[] x,char[] y)
	{
		int len=0;
		
		char []result=new char[Math.min(x.length, y.length)];
		
		int row=x.length;
		int col=y.length;
		
		int newrow=row+1;
		int newcol=col+1;
		
		int m[][]=new int[newrow][newcol];
		
		for(int i=0;i<newrow;i++)
		{
			m[i][0]=0;
		}
		
		for(int i=0;i<newcol;i++)
		{
			m[0][i]=0;
		}
		
		int i=-1,j=-1;
		
		// filing of matrix starts here
		for( i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				if(x[i]==y[j])
				{
					if((len!=0 && result[len-1]!=x[i]) || len==0)
					{
						result[len]=x[i];	
						len++;
					}			
					
					m[i+1][j+1]=1+m[i][j];
					
				}
				else
				{
					m[i+1][j+1]=Math.max(m[i][j+1], m[i+1][j]);
				}
			}
		}		
		
		
		for( i=0;i<newrow;i++)
		{
			for(j=0;j<newcol;j++)
			{
				System.out.print(m[i][j]+"  ");
			}
			System.out.println();
		}
		
		
		System.out.print("LCS =");
		
		for(i=0;i<len;i++)
		{
			System.out.print(result[i]+" ");
		}
		
	}

}
