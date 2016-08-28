
class Generator {

	public static boolean check;
	
	public static int[][] generator()
	{
		int n = Main.n;
		int d=Main.d;
		int theta=Main.theta;
		int rho=Main.rho;
		
		int i,j,flag=0,a=0,fill=0,temp = 0,mem=0,k=0,p=0,c=0;
		int[] row = new int[n];													 	
		int[] colm = new int[theta];
		int[] rcnt = new int[n];
		int[] ccnt = new int[theta]; 
		int[][] matrix = new int[n][theta];
		
		for(i=0;i<n;i++)
		{			
			for(j=temp;j<theta;j++)
			{
/*If n==theta and for comparable values of d and n i.e d>n/2, follow the cyclic shift approach for generating the matrix. This is done so as to reduce the complexity.
*/
				if(n==theta && d>n/2)
				{				
					c=1;														//Sets the check =1, that the cyclic shift method is to be followed.
					if(fill==0)													// First element of the iteration being filled, 
					{																		
						mem=temp;												//	mem stores the current column value		
						fill=1;
					}
					else if (colm[j]<rho)
					{
						fill=1;
						matrix[i][j]=1;											// Other than the first element is filled, 
						row[i]++;
						colm[j]++;
						if(row[i]==d)
							break;						
					}
					else
					{
						continue;
					}
				}
/* For all other values */	
		
				else if(colm[j]<rho && fill==0)									// The first element of the iteration is to be filled
				
				{					
					if(matrix[i][j]==1)
					{														
						continue;												// If element already present, continue
					}
					fill=1;
					mem=j;
					matrix[i][j]=1;
					row[i]++;
					colm[j]++;
					for(a=0;a<i;a++)											// Find the row with which 1 is coinciding in the filled column		
					{
						if(matrix[a][j]==1)
							break;
					}
					p=0;
					for(k=j+1;k<theta;k++)										//Finds the column with minimum weight, accordingly increment flag
					{
						if(colm[k]<=flag && matrix[a][j]!=1)
						{
							p=1;
							break;
						}
						if(colm[k]<=flag && matrix[a][j]==1 )
						{
							p=2;
						}						
					}
					if(p==0)														
						{
						flag++;													// No column with minimum weight equals the flag value, increment flag
						}
					if(p==1)
					{
						System.out.println("I was called");
					}
					continue;
				}
				
				else if(fill==1)												// Other than first element is being filled
				{
					if(colm[j]>=rho || row[i]>=d)								// If values of the column and row are already full
					{
						break;
					}
					if(matrix[i][j]==1)											// If element already 1, continue	
					{
						continue;						
					}
					if(colm[j]==flag)											
					{	
						if(matrix[a][j]==0)										// 	checks if the column has a coinciding 1 with the row stored in a 												
						{
						matrix[i][j]=1;
						colm[j]++;
						row[i]++;
						if(flag>0)
							a++;
						if(row[i]==d)
							break;
						else
							continue;
						}
						else if(p==2)											// for p=2, the minimum weight column exists, 
						{														//	but not satisfying the coinciding 1 clause,	
							matrix[i][j]=1;										// Fill all these columns having minimum weight,so weight of all the columns are matched evenly
							colm[j]++;
							row[i]++;							
							if(row[i]==d)
								{
								p=3;	
								break;
								}
							else 
								continue;							
						}						
					}
					else
					{
						continue;
					}					
				}				
			}
			fill=0;	
			if(c==1)														  // Check if the case is n==theta, d>n/2 
			{
				if(row[i]<d || temp>=theta)									  // Check if row weight and column weights are satisfied
 				{
					fill=1;
					i=i-1;
					temp=0;
				}
				else
				{
					fill=0;
					temp=mem+1;
					if(temp>=theta)
						temp=0;					
				}
			}
			else if(row[i]<d)													// Checks if the row has been fully filled, 
			{
				temp=mem+1;														//If not start the iteration again for the same row
				i=i-1;															// for the column next to the first column of the previous iteration	
			}
			else
			{
				temp=0;															// If row has been filled with d 1's, start again from column 0
			}
		}

// Now checking whether all columns and rows have rho and d 1's respectively		
		for(i=0;i<n;i++)
		{
			for(j=0;j<theta;j++)
			{
				if(matrix[i][j]==1)
					{
					rcnt[i]++;
					ccnt[j]++;
					}					
			}
			if(rcnt[i]!=d)
			{
				check=false;
				break;
			}		
		}		
		for(j=0;i<theta;i++)
		{
				if(ccnt[j]==rho)
				{
					continue;
				}
				else
				{
				check=false;
				break;
				}
		}
		return matrix;
	}	

}

