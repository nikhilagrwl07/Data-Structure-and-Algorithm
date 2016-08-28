import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.io.*;

//public 
class Main {
	
public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
    Set<T> tmp = new TreeSet<T>(setA);
    tmp.addAll(setB);
    return tmp;
  }

  public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
    Set<T> tmp = new TreeSet<T>();
    for (T x : setA)
      if (setB.contains(x))
        tmp.add(x);
    return tmp;
  }

public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
    Set<T> tmp = new TreeSet<T>(setA);
    tmp.removeAll(setB);
    return tmp;
  }

	public static int choice,c=1;
	public static int op=0;
	public static int n, d, theta, rho;						//Parameters of a distributed storage system
	public static  Scanner input; 							
	public static int[][] FRmatrix;							//Array for Incidence matrix
	public static int[][] dthetaarray;						//Array for storing values of d and corresponding theta, for known values of n and rho			
	public static int[] list;								//Array for the Enumeration list of nodes and FR codes
	public static int[] optimalcode;
	public static String[] a1 = {"Nodes","Packets"};
	public static String[] a2 = {"d","theta"};
	public static String[] a3 = {"No. of nodes, n","No. of FR codes possible"};
	
      public static String[] a4 = {"No. of nodes, n","No. of FR codes possible","No. of Universally good & optimal FR codes possible"};  // extra added
      public static String[] a5 = {"Nodes","Repair Degree"};

	static Generator g =null;
	public static int count=0,isomorphNo=0;
	public static PrintWriter pwriter, tablewriter, regularwriter,rwriter;

/*
 * Following are the paths where the Project gets created, User can easily change the paths according to their choice  
 */
	
	public static String path_allcodes 	= "FRcodes/general/";
	public static String path_regular 	= "FRcodes/regularData/";
	public static String path 	= "FRcodes/";
	public static String path_n = "FRcodes/n/";
	public static String general="general/";
/*	
 */
	
//================================== main method ==========================================//
	
	public static void main(String[] args) throws Exception
	{
		new File(path).mkdirs();
		new File(path_allcodes).mkdirs();
		new File(path_n).mkdirs();
		new File(path_regular).mkdirs();
		
		boolean allow = true;
		do{
		pwriter=null;	
		System.out.println("Please choose from the options below : ");
		System.out.println("1. Enumeration for all values upto a given n");
		System.out.println("2. Enumeration for a given value of n");
		System.out.println("3. Enumerate for a known number of nodes and no.of failures to sustain.");
		System.out.println("4. Packet distribution for known values of all the parameters.");
		System.out.println("5. Regular graph distribution.");
		System.out.println("6. Exit");
		input = new Scanner(System.in);
		choice= input.nextInt();
		System.out.println();
		switch(choice)
		{
		case 1: 	func1();
					break;
		case 2: 	func2();
					break;
		case 3: 	func3();
					break;	
		case 4: 	func4();
					break;
		case 5: 	regular();
					break;
		case 6 : 	allow=false;
					break;
		default:	System.out.println("Please choose from one of the options");			
					continue;
		}

		}while(allow!=false);
		
	}
	

	
//========================== Function for choice 5, fetches the data from the website ==================//
	
	private static void regular() throws IOException{
		try{
			URL google;
			BufferedReader in = null;
			int a=0,b=0,nod,deg,n=0,d=1;
			String s;
			String[] astr = new String[2];
			String[][] str = null;
			regularwriter = new PrintWriter(new File(path+"website.txt"));
			for(nod=4;nod<11;nod++)
			{
				regularwriter.println("nodes = "+nod);
				System.out.println("nodes = "+nod);
			
				for(deg=3;deg<8;deg++)
				{				
					if(nod<10)
					{
						google = new URL("http://www.mathe2.uni-bayreuth.de/markus/REGGRAPHS/ASC/0"+nod+"_"+deg+"_3.asc");
					}
					else
					{
						google = new URL("http://www.mathe2.uni-bayreuth.de/markus/REGGRAPHS/ASC/"+nod+"_"+deg+"_3.asc");
					}
					URLConnection yc = google.openConnection();
					try{
						in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
					}catch(Exception e)
					{
						if(e.toString().equalsIgnoreCase("java.io.FileNotFoundException"));
						{
							continue;
						}
					}
					regularwriter.println(" degree = "+ deg);
					System.out.println(" degree =  "+deg);
					String inputLine;
					str = new String[nod+1][deg+1];
					while ((inputLine = in.readLine()) != null) 
					{	
						if(inputLine.contains("Taillenweite"))
						{	
							a=0;
							func5(str,n,deg);					
						}
						if(inputLine.contains("Graph"))
						{
							regularwriter.println();
							regularwriter.println(" "+inputLine);
							System.out.println(" "+inputLine);
							a=1;
							isomorphNo++;
							n=0;
							d=0;
						}		
						if(a==1)
						{
							if(!inputLine.startsWith(" "))
							{
								astr = inputLine.split(":");						
								if(astr.length==2)
								{
									n++;	
									str[n]=astr[1].split(" ");;						
									regularwriter.println("  "+inputLine);					
								}
							}
								
						}
										
					}
					isomorphNo=0;
					regularwriter.println("\n");
				}
				
				regularwriter.println("\n");
			}
				regularwriter.close();
				try{
					in.close();
				}catch(Exception e){
				System.out.println("Could not connect to the internet");
				}	
			}
		catch(Exception e){}
	}
	
//============================ Function to calculate incidence matrix from the adjacency list data available from the website =============//
	
	
	private static void func5(String str[][], int nod, int deg) throws FileNotFoundException {
		
		int[][] arr =new int[nod][deg];	
		int i,j,k,a = 0,t=0;
		for(i=1;i<nod+1;i++)
		{
			for(j=1;j<deg+1;j++)
			{
				arr[i-1][j-1]= Integer.parseInt(str[i][j]);
			}
		}		
		
		int c=0,fill=0,check=0;
		n=nod;
		d=deg;
		rho=2;
		theta=(n*d)/2;
		int[][] matrix = new int[n][theta];
		FRmatrix = new int[n][theta];
		int[] checkrow = new int[n] ;
		int[] checkcolumn = new int[theta];
		int[] cnt = new int[n];
		
		for(i=0;i<n;i++)
		{
			for(j=0,k=0;j<theta;j++)
			{			
				check=0;
				if(checkcolumn[j]==2 || checkrow[i]==deg)
				{
					continue;
				}
				
				if(i==0)
				{
					matrix[i][j]=1;
					checkrow[i]++;
					checkcolumn[j]++;
				}

				else if(checkcolumn[j]<2 && checkrow[i]<deg)
				{
					for(k=0;k<deg;k++)
					{										
						a = arr[i][k]-1; 
						if(a>i)
						{
							break;
						}
						if(matrix[a][j]==1 && cnt[a]==0)
						{
							fill=1;
							c=a;
							break;
						}			
						else if( matrix[a][j]==1 && cnt[a]==1)
						{
							fill=-1;
							c=a;
							break;
						}
						else if(matrix[a][j]==0 && cnt[a]==1)
						{
							fill=1;
							continue;
						}
						else if(matrix[a][j]==0 && cnt[a]==0)
						{
							fill=1;
							continue;
						}
					}

					if(fill==-1)
					{
						fill=0;
						continue;	
					}
					if(fill==1)
					{
						for(k=0;k<i;k++)
						{							
							if(matrix[k][j]==1)
							{
								if(k!=c)
								{
								check=-1;
								break;
								}
							}
						}
						if(check==-1)
						{
							continue;
						}
						matrix[i][j]=1;
						checkrow[i]++;
						checkcolumn[j]++;
						cnt[c]=1;
						fill=0;
						check=0;						
						}	
				}				
			}
			check=0;	
			fill=0;
			for(c=0;c<n;c++)
				cnt[c]=0;		
		}
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<theta;j++)
			{
				FRmatrix[i][j]=matrix[i][j];
			}
		}
	
		String name = n+"_"+d+"_"+isomorphNo;
		pwriter = new PrintWriter(new File(path_regular+n+"_"+d+"_"+isomorphNo+".html"));
		pwriter.println("<html>\n<body>\n<h1>");
		pwriter.println("n="+n+", d="+d+", theta="+theta+"  ("+isomorphNo+")</h1>");
		pwriter.println("<h3>Incidence Matrix</h3>");		
		printer();
		pwriter.println("</body>\n</html");
		pwriter.close();
		
	}
	

//======================= Prints the webpage displaying the Incidence matrix and the node packet distribution table ===============//
	
	public static void printer()
	{ 
	 TreeSet<Integer> set1 = new TreeSet<Integer>();    //  sets
	  TreeSet<Integer> set2 = new TreeSet<Integer>();	

		//int i=0,j=0,t=0;
		//int[][] nparray= new int[n][d];
  int i,j,rho=0,count,t,v,b,v2,flag,v3,c,k,k_result=0,p2,intersection_wt=-1,option=-1,q,index_min=-1,i2,p3;
		// creating the array of d_i
		 int[] dp=new int[n];
		  
		int[] dt=new int[n];
  
		if(choice==1 || choice==5){
			
	/*	for(i=0;i<n;i++)
		{	for(j=0;j<theta;j++)
				{
				//System.out.print(FRmatrix[i][j]+" ");
				pwriter.write(FRmatrix[i][j]+" ");
				if(FRmatrix[i][j]==1)
				{
					nparray[i][t]=j;
					t++;
				}
				}
		//System.out.print("\n");
		pwriter.write("<br />");
		t=0;
		}
		//System.out.println();
		pwriter.println("<br />");
		pwriter.println("<h3>Node-Packet Distribution");
		pwriter.println("<br />");
		
		pwriter.write("<table border="+1+"><tr><th align=center>"+a1[0]+"</th><th align=center>"+a1[1]+"</th></tr>");
		//System.out.println(a1[0] + "\t\t" + a1[1]);
		
		for(i=0;i<n;i++)
		{
			pwriter.write("<tr>");
			//System.out.print("v"+(i+1)+"\t\t");
			pwriter.write("<td align=center>v"+(i+1)+"</td>");
			pwriter.write("<td align=center>");
			for(j=0;j<d;j++)
			{
				nparray[i][j]++;
				//System.out.print((nparray[i][j]) + " ");
				pwriter.write((nparray[i][j])+"  ");
				
			}
			System.out.print("\n");
			pwriter.print("</td></tr>");
		}
		System.out.println("\n");
		pwriter.println("<br />");
	*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////
for(i=0;i<n;i++)
{
  count=0;
 // System.out.println("Start filling the elements for row number ="+(i+1));
for(j=0;j<theta;j++)
{
   pwriter.write(FRmatrix[i][j]+" ");
    if(FRmatrix[i][j]==1)
    {
      count++;
    }

}
dp[i]=count; // d_i are obtained here
pwriter.write("<br />");
}

// checking for constant rho 
for(j=0;j<theta;j++)
{
  t=0;  
for(i=0;i<n;i++)
{
  if(FRmatrix[i][j]==1) 
    t++;
}

if(j==0)
   rho=t;
else 
{
    if(rho!=t)
    {
      System.out.println("Not fractional repetition code");
      break;
    }
}
}

		pwriter.println("<br />");
		pwriter.println("<h3>Node-Packet Distribution");
		pwriter.println("<br />");
		pwriter.write("<table border="+1+"><tr><th align=center>"+a1[0]+"</th><th align=center>"+a1[1]+"</th></tr>");


System.out.println();
System.out.println("-------------------------------------");
System.out.println("Node packet distribution Table");
System.out.println("-------------------------------------");
for(i=0;i<n;i++)
{
count=0;
			pwriter.write("<tr>");
			//System.out.print("v"+(i+1)+"\t\t");
			pwriter.write("<td align=center>v"+(i+1)+"</td>");
			pwriter.write("<td align=center>");
 for(j=0;j<theta;j++)
{
   count++;
  if(FRmatrix[i][j]==1)
  {   
    System.out.print(count+"  ");
    pwriter.write(count+"  ");
  }
  
}
  System.out.println();
 pwriter.print("</td></tr>");
}
System.out.println("-------------------------------------");
pwriter.println("<br />");


//removing parity bit by removing the last column of incidence martix
int p[][]=new int[n][theta-1];
for(i=0;i<n;i++)
{
count=0;
for(j=0;j<(theta-1);j++)
{
  p[i][j]=FRmatrix[i][j];

  if(p[i][j]==1)
    count++;
}
dt[i]=count;

}

// calculating maximum d_i
int max=0,max_index=0;
for(i=0;i<n;i++)
{
    if(dt[i]>=max)
     {
      max=dt[i];
      max_index=i;
      }
}

//declaring n * max matrix
int sets[][]=new int[n][max];
// for calculating code rate
int codeRate[][]=new int[n][max];
//for calculating repair degree
int repairCalculation[][]=new int[n][max];
// declaring repair degree array
int[] repairDegree=new int[n];

for(i=0;i<n;i++)
  repairDegree[i]=-1;

int x=0;

//initializing zero matrix
for(i=0;i<n;i++)
{
  for(j=0;j<max;j++)
    {
      sets[i][j]=0;
      codeRate[i][j]=0;
      repairCalculation[i][j]=0;
    }
}

for(i=0;i<n;i++) 
{
  x=0;
  for(j=0;j<(theta-1);j++)
  {
    if(p[i][j]==1)
    {
      sets[i][x]=(j+1);
       codeRate[i][x]=(j+1);
	repairCalculation[i][x]=(j+1);
      x++;
    }
  }
}

System.out.println();
System.out.println();
System.out.println();
System.out.println();
System.out.println("---------------------------------------------------");
System.out.println("Node packet distribution Table excluding parity bit");
System.out.println("---------------------------------------------------");
for(i=0;i<n;i++)
{
 for(j=0;j<dt[i];j++)
{
  System.out.print(sets[i][j]+"  ");
 
}
  System.out.println();
 
}



System.out.println("---------------------------------------------------");

//calculating subsets of each set and removing the subsets
for(v=0;v<n;v++)  // taking each set
{
int numOfSubsets = 1 << dt[v]; 

int array[]=new int[dt[v]];   // the value of each array

// copying each row from sets 2D array into single array
for(b=0;b<dt[v];b++)
  array[b]=sets[v][b];

//creating maximum size subset array 
int subset[]=new int[dt[v]];

//////////////////////////////////////////////////////////////
for(i = 0; i < numOfSubsets; i++)             
 {
    int pos = array.length - 1;
   int bitmask = i;
    int start=0;

  // System.out.print("{");
   while(bitmask > 0)    // single subset is generated here
   {
    if((bitmask & 1) == 1)
     {
   //   System.out.print(array[pos]+",");
      subset[start++]=array[pos];
     }
     
    bitmask >>= 1;
    pos--;
   }

  // System.out.print("}");

  // sorting the generated subset 
    int size = start-1;
    for (int w = 0; w < start - 1; w++) {
        for (int w2 = 0; w2 < size; w2++) {
            if (subset[w2] > subset[w2 + 1]) {
                int te = subset[w2];
                subset[w2] = subset[w2 + 1];
                subset[w2 + 1] = te;
            }
        }
        size--;
    }


//for(k=0;k<start;k++)
//System.out.print(subset[k]+"  ");

//System.out.println();

// writing function for equlaity for 2 arrays which are one subset and all other sets

for(v2=0;v2<n;v2++) //taking each subset
{
  flag=0;
  if(v2!=v && start==dt[v2])
  {     
    for(v3=0;v3<start;v3++)
      {
	if(subset[v3]!=sets[v2][v3])
	 {
	    flag=1;
	      break;
	  }
	else
	  continue;
      }
  //}

   if(flag==0) /// there is set in system which is subset of another sets
    {
	// then put all zeros in that particular row v2
	 for(c=0;c<dt[v2];c++)
	  {
	    sets[v2][c]=0;
	  }
	   
    }
    else
    {
        continue;
    }
   }   
}

}
////////////////////////////////////////////////////////////  
}

//calculating all non-zero rows adnd length for each non-zero row
int zero_rows=0;
//int[] dtemp=new int[];
for(i=0;i<n;i++)
{
 for(j=0;j<dt[i];j++)
{
  if(sets[i][j]==0)
  {
      zero_rows++;
      break;
  }
  

}

}
//--------------------------- for calculating d_i and filling in d_new array-----------------------------------------
int row_new=n-zero_rows;
int selectedsets[][]=new int[row_new][max];

int d_new[]=new int[row_new];
int d_i=0;
int check=0;

for(i=0;i<n;i++)
{
    d_i=0;
    flag=0;
 for(j=0;j<dt[i];j++)
{
  if(sets[i][j]==0)
  {
	continue;
  }
  else
  {
      d_i++;
      flag++;
  }

}
if(flag!=0)
  d_new[check++]=d_i;
}
//-----------------------------------------------------------------------------------------------------------------------------

//--------------------- removing all zero rows from the matrix------------------------------------
int startindex =0;

for(i=0;i<n;i++)
{
    flag=0;
  for(j=0;j<dt[i];j++)
  {
    if(sets[i][j]==0)
      {
	continue;
      }
    else
    {
      selectedsets[startindex][j]=sets[i][j];	
      flag++;
    }

  }
if(flag!=0)
  startindex++;
}


//----------------------------printing module for sets which are not subsets of each other---------------------------------------------------------
System.out.println();
System.out.println("---------------------------------------------------");
System.out.println("Node packet distribution Table with sets NOT subset ");
System.out.println("---------------------------------------------------");
for(i=0;i<row_new;i++)
{
  for(j=0;j<d_new[i];j++)
 { 
      System.out.print(selectedsets[i][j]+"  ");
  
  }
    System.out.println();
  
}


System.out.println();


//------------------------------------------------k calculation-------------------------------------------------------------

int hitlistIndex=0;
int dredlist[]=new int[row_new]; // contains index of those d_i's which has been considered for k
int bh=0,j2=0;
int z2=0;
int[] k_min=new int[row_new];


for(j2=0;j2<row_new;j2++)
{
hitlistIndex=0;
k_result=0;
for(i=0;i<d_new[j2];i++)
{
  set1.add(selectedsets[j2][i]);
}

dredlist[hitlistIndex]=j2;    
//bh++;

hitlistIndex++;
k_result++;		// first value of k is considered here 

for(i2=0;i2<row_new;i2++)  
{
intersection_wt=-1;
if(set1.size()<(theta-1))
{
for(i=0;i<row_new;i++)     // finding row number which is having minimum intersection with set 1
{
    flag=0;
   for(q=0;q<hitlistIndex;q++)  // checking hit list of d
    {
      if(i==dredlist[q])   // checking row i is not among the selected row number
	{
	  flag=1;
	   break;
	}
	else
	{
	  continue;
	}
    }
if(flag==1)  // row number i  is already present in d's red list
{
  continue;
}
else      // row number i is NOT present in hit list
{
	  // Taking each row which has been NOT taken and adding to set2 to find intersection with set1
	  for(p2=0;p2<d_new[i];p2++)
	  {
	    set2.add(selectedsets[i][p2]);
	  }

    //  System.out.println("Intersection size "+intersection(set1, set2).size());
	  //int x1=intersection(set1, set2).size();
	//System.out.println("intersection_wt"+intersection_wt);
	//System.out.println("x1 "+x1);
         if(intersection_wt<union(set1, set2).size())
	  {
	     //    System.out.println("Test 2");
	    intersection_wt=union(set1, set2).size();
	    index_min=i;  // row number i is having maximum intersection with set1 
	  //  System.out.println("Row number with minimum intersection ="+index_min);
	   }

	 // Taking each row which has been NOT taken and removing from set2
	  set2.removeAll(set2);
	// System.out.println("Row number with minimum intersection with set1 is"+index_min);
    
}

}

dredlist[hitlistIndex++]=index_min;  // adding row number "index_min"  to d red list 

k_result++;  // incresing value of k by 1

	//System.out.println("Row number with minimum intersection with set1 is"+index_min);

 // Taking each row which has been NOT taken and adding to set2 to find intersection with set1
	  for(p2=0;p2<d_new[index_min];p2++)
	  {
	     // System.out.print(selectedsets[index_min][p2]+"   ");
	    set2.add(selectedsets[index_min][p2]);
	  }

set1.addAll(set2); // taking union of set1 and set2
//System.out.println("Set 1 ="+set1);
//System.out.println("Set 2 ="+set2);
 // Taking each row which has been NOT taken and removing from set2
	  set2.removeAll(set2);
}
else
{
    k_min[z2++]=k_result;

    break;
}

}

set1.removeAll(set1);
set2.removeAll(set2);
}

int min=k_min[0];

for(i=0;i<z2;i++)
{
    if(min>k_min[i])
      min=k_min[i];
}

System.out.println("Construction Degree k="+min);

               pwriter.println("<br />");
		pwriter.println("<h3>Construction Degree k="+min);
		pwriter.println("<br />");

//-----------------------Calculating repair degree of each node-------------------------------------------

set1.removeAll(set1); // emptying all set
set2.removeAll(set2);
int length;
int smallest=25000;
int hitlist[]=new int[n];
int smallestIndex=-1;
int maxrepairDegree=-1;
for(i=0;i<n;i++)   	// Taking each node from 1 to n
{
  smallest=25000;
  length=0;

  for(p3=0;p3<dt[i];p3++)         // adding data packets of each node in set1
{
  set1.add(repairCalculation[i][p3]);
}
//System.out.println("Set 1="+set1);

  while(smallest>0)
  {
  for(j=0;j<n;j++)
    {
      flag=0;

    for(k=0;k<length;k++)
    {
      if(j!=hitlist[k])
	continue;
      else
	flag=1;
    }

      if(flag==0 && i!=j)
      {
	  for(p3=0;p3<dt[j];p3++)	
	  {
	      set2.add(repairCalculation[j][p3]);
	  }
	  
	if(smallest>difference(set1,set2).size())
	  {
	  smallest=difference(set1,set2).size();
	 smallestIndex=j;
	  }
     // System.out.println("Set 2="+set2);
	//  set1.removeAll(set2);
          set2.removeAll(set2);
     }
  }// finding row having minmum number of difference means max intersection


  hitlist[length]=smallestIndex;
length++;
  //  System.out.println("Length="+length);

	  for(p3=0;p3<dt[smallestIndex];p3++)	
	  {
	      set2.add(repairCalculation[smallestIndex][p3]);
	  }
	   
	  set1.removeAll(set2);
	  set2.removeAll(set2);
  }
   //pwriter.write("----------"+repairDegree[i]);
  repairDegree[i]=length;
    set1.removeAll(set1);
    set2.removeAll(set2);
}
pwriter.write("<br />");

pwriter.write("<table border="+1+"><tr><th align=center>"+a5[0]+"</th><th align=center>"+a5[1]+"</th></tr>");
System.out.println();
System.out.println();
System.out.println();
System.out.println();
System.out.println("---------------------------------------------------");
System.out.println("Repair Degree of each Node");
System.out.println("---------------------------------------------------");

for(i=0;i<n;i++)
{
			pwriter.write("<tr>");
			pwriter.write("<td align=center>v"+(i+1)+"</td>");
			pwriter.write("<td align=center>");

pwriter.write("  "+repairDegree[i]);
  System.out.println();
 pwriter.print("</td></tr>");
}



for(i=0;i<n;i++) 
 {
 System.out.println(" v("+(i+1)+") "+repairDegree[i]);

  if(i==0)
    maxrepairDegree=repairDegree[i];

  else if(i>0 && maxrepairDegree < repairDegree[i])
    maxrepairDegree=repairDegree[i];

}


System.out.println("---------------------------------------------------");
System.out.println("");


//-------------------------------------------------Code Rate-----------------------------------
// dimension of codeRate[][] is n*max where max= max{d1,d2,....dn} and dt[i] where di's are stored
int hitlistIndex2=0;
int dredlist2[]=new int[n]; // contains index of those d_i's which has been considered for k
int j3=0;
int z22=0;
int[] rc_min=new int[n];
int rc_result=0;
int min_global=-1,packet_min=-1;


for(j3=0;j3<n;j3++)
{
hitlistIndex2=0;
rc_result=0;

for(i=0;i<dt[j3];i++)
{
  set1.add(codeRate[j3][i]);
}

dredlist[hitlistIndex2]=j3;    
z22=0;

hitlistIndex2++;
rc_result++;		// first value of k is considered here 

for(i2=0;i2<(min-1);i2++)  // min means k 
{
intersection_wt=-1;
//if(set1.size()<(theta-1))
//{
for(i=0;i<n;i++)     // finding row number which is having minimum intersection with set 1
{
    flag=0;
   for(q=0;q<hitlistIndex2;q++)  // checking hit list of d
    {
      if(i==dredlist[q])   // checking row i is not among the selected row number
	{
	  flag=1;
	   break;
	}
	else
	{
	  continue;
	}
    }
if(flag==1)  // row number i  is already present in d's red list
{
  continue;
}
else      // row number i is NOT present in hit list
{
	  // Taking each row which has been NOT taken and adding to set2 to find intersection with set1
	  for(p2=0;p2<dt[i];p2++)
	  {
	    set2.add(codeRate[i][p2]);
	  }

    //  System.out.println("Intersection size "+intersection(set1, set2).size());
	  //int x1=intersection(set1, set2).size();
	//System.out.println("intersection_wt"+intersection_wt);
	//System.out.println("x1 "+x1);
         if(intersection_wt<intersection(set1, set2).size())
	  {
	     //    System.out.println("Test 2");
	    intersection_wt=intersection(set1, set2).size();
	    index_min=i;  // row number i is having maximum intersection with set1 
	  //  System.out.println("Row number with minimum intersection ="+index_min);
	   }

	 // Taking each row which has been NOT taken and removing from set2
	  set2.removeAll(set2);
	// System.out.println("Row number with minimum intersection with set1 is"+index_min);
	 
}

}

dredlist[hitlistIndex2++]=index_min;  // adding row number "index_min"  to d red list 

rc_result++;  // incresing value of k by 1

	//System.out.println("Row number with minimum intersection with set1 is"+index_min);

 // Taking each row which has been NOT taken and adding to set2 to find intersection with set1
	  for(p2=0;p2<dt[index_min];p2++)
	  {
	     // System.out.print(selectedsets[index_min][p2]+"   ");
	    set2.add(codeRate[index_min][p2]);
	  }

set1.addAll(set2); // taking union of set1 and set2
//System.out.println("Set 1 ="+set1);
//System.out.println("Set 1 ="+set1);
//System.out.println("Set 2 ="+set2);
 // Taking each row which has been NOT taken and removing from set2
	  set2.removeAll(set2);
	   rc_min[z22++]=index_min;
//  System.out.println("length="+z22);

//z22=0;
}
set1.removeAll(set1);
set2.removeAll(set2);


//for(int kp=0;kp<dt[j3];kp++)
  //set1.add(codeRate[j3][kp]);

for(int kk=0;kk<min;kk++)
      {
	for(int kp=0;kp<dt[dredlist[kk]];kp++)
	  set1.add(codeRate[dredlist[kk]][kp]);
  
      //set1.add(codeRate[dredlist[kk]]);      
      }

if(j3==0)
   packet_min=set1.size();
else if(j3>0 && packet_min> set1.size())
    packet_min=set1.size();
 
/*System.out.println("Set="+set1);
System.out.println("Minimum numnber of packets ="+packet_min);
System.out.println();
System.out.println();
 */
set1.removeAll(set1);


}

System.out.println("Code Rate RC(k)="+packet_min);
System.out.println();


               pwriter.println("<br />");
		pwriter.println("<h3>Code Rate RC(k)="+packet_min);
		pwriter.println("<br />");

System.out.println();
//---------------------------------------------------------------------------------------------

//------------------------------------------universally good code ---------------------------------------------------
int capacity=(min*maxrepairDegree)-(min*(min-1)/2);

System.out.println("Capacity of C(MBR) code="+capacity);

		pwriter.println("<br />");
		pwriter.println("<h3>Capacity of C(MBR) code="+capacity);
		pwriter.println("<br />");

if(packet_min > capacity)
 {
  System.out.println("Universally good code");
  pwriter.println("<br />");
		pwriter.println("<h3> Universally good code");
		pwriter.println("<br />");
++op;
 }
else if(packet_min==capacity)
 {
  System.out.println("Optimal code");
		pwriter.println("<br />");
		pwriter.println("<h3> Optimal code");
		pwriter.println("<br />");
++op;
  }
else if(packet_min<capacity)
 {
  System.out.println("Non-Optimal code");
  pwriter.println("<br />");
		pwriter.println("<h3> Non-Optimal code");
		pwriter.println("<br />");

 }


///////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
		/*
		else
		{
			for(i=0;i<n;i++)
			{	for(j=0;j<theta;j++)
					{
					System.out.print(FRmatrix[i][j]+" ");
					if(FRmatrix[i][j]==1)
					{
						nparray[i][t]=j;
						t++;
					}
					}
			System.out.print("\n");
			t=0;
			}
			System.out.println();
			System.out.println(a1[0] + "\t\t" + a1[1]);
			
			for(i=0;i<n;i++)
			{
				System.out.print("v"+(i+1)+"\t\t");
				for(j=0;j<d;j++)
				{
					
					System.out.print((nparray[i][j]+1) + " ");
					
				}
				System.out.print("\n");
			}
			System.out.println("\n");
			
			if(choice==3){
			
			System.out.println();
			System.out.println(a2[0]+"\t"+a2[1]);			
			for(i=0;i<dthetaarray.length;i++)
			{
				if(dthetaarray[i][0]!=0)
					{
					System.out.println(dthetaarray[i][0] + "\t"+ dthetaarray[i][1]);
					}					
			}
			}
		}
		*/
		
	

}
	

	
//=====================Function for choice 4, to find the node packet distribution, with all the parameters known  =============//	
	
	private static void func4() throws FileNotFoundException {
		
		do{
		System.out.println("Enter number of nodes in the system");
		n = input.nextInt();
		System.out.println("Enter the repair degree");
		d = input.nextInt();
		System.out.println("Enter the number of packets");
		theta = input.nextInt();
		System.out.println("Enter the replication factor");
		rho = input.nextInt();
		System.out.println();
		if(n*d != theta*rho) 
		{
			System.out.println("Please follow n*d==theta*rho");
		}
		else
			break;
		}while(true);
		System.out.println("n= "+n+",  d= "+d+", theta= "+theta+", rho= "+rho+"\n");	    				
		FRmatrix = g.generator();
		printer();
	}

	
//============Function for choice 3, to find the possible values of d and theta , corresponding to given value of nodes and failures============//
	
	private static void func3() throws FileNotFoundException {
		do{
		System.out.println("Enter number of nodes in the system");
		n = input.nextInt();
		System.out.println("Enter the number of failures to sustain");
		rho = input.nextInt()+1;
		if(rho<=n)
			break;
		else
			System.out.println("Failures cannot exceed number of nodes\n");
		}while(true);
		dthetaarray = new int[n-1][2];
		int i,r;
		System.out.println("n= "+n+",rho= "+rho);
		for(i=0,d=1;d<=n-1;d++)
		{
			if((n*d)%rho==0)
			{
				theta=(n*d)/rho;
				r = binomial(theta, d);
				if(r<=0)
				{
				dthetaarray[i][0]=d;
				dthetaarray[i][1]=theta;
				i++;
				System.out.println("d= "+d+",theta= "+theta);
				FRmatrix = g.generator();
				printer();
				System.out.println("\n");
				}	
			}
			else
				continue;
		}		
		
	}

	
//======================= Function for choice 2, to enumerate all possible FR codes for a given value of n ===================//
	
	private static void func2() {
		System.out.println("Enter the value of n");
		n= input.nextInt();
		int r;
		for(rho=2;rho<=n;rho++)
		{
			for(d=1;d<=n-1;d++)
			{			
				if((n*d)%rho==0)
    			 {
    				theta=(n*d)/rho;
    				r =binomial(theta, d);   				
    				if(r<=0)
    				{	   					
    				System.out.println("\n n= "+n+",  d= "+d+", theta= "+theta+", rho= "+rho+"\n");	
    				FRmatrix = g.generator();
    				printer();
    				}
    				else
    				{
    					continue;
    				}
    			 }
				else
				{
					continue;
				}
			}
		}
	}

	
//================= Function for choice 1, to enumerate FR codes for all values of n upto the entered value of n ===================//
	
	private static void func1() throws FileNotFoundException {
		
		System.out.println("Enter the value of n");
		int in  = input.nextInt();
		list = new int[in+1];
		int t=0,i,j,thetaCd,r;
		String str = null;
		int temp=0,flag=0;
		optimalcode=new int[in+1];
		int universal=0;
		for(n=0;n<=in;n++)
		{
			tablewriter = new PrintWriter(new File(path_n+n+".html"));
			tablewriter.write("<html>\n<body>\n<h1>No of nodes, n ="+n+"</h1>");
			
			for(rho=2;rho<=n-1;rho++)
			{
				int[][]dvalue = new int [in][2];	
				
				for(d=2;d<=n-1;d++)
				{
					if((n*d)%rho==0)
	    			 {
						theta=(n*d)/rho;
						r =binomial(theta, d);
	    				if(r<=0)
	    				{	
	    				dvalue[temp][0]=theta;
	    				dvalue[temp][1]=d;
	    				temp++;
	    				str = n+"_"+d+"_"+theta+"_"+rho;
	    				String name = "n= "+n+",  d= "+d+", theta= "+theta+", rho= "+rho;	    				
	    				
	    				pwriter = new PrintWriter(new File(path_allcodes+str+".html"));
	    			    
	    				pwriter.println("<html>\n<body>\n<h1>");
	    				pwriter.println(name+"</h1>");
	    			    pwriter.println("<h3>Incidence Matrix</h3>");
	    				System.out.println("n= "+n+",  d= "+d+", theta= "+theta+", rho= "+rho+"\n");	    				
	    				
	    				count++;
	    				FRmatrix = g.generator();
	    				printer();
	    				//optimalcode[n] +=optimalcode[n];
	    				pwriter.println("</body>\n</html>");
	    				pwriter.close();
	    				}
	    				else{
							dvalue[temp][0]=0;
	    					temp++;
	    				}

					if(op==1)
					{
					universal++;
					op=0;
					}
	    			 }
					else
					{
						dvalue[temp][0]=0;
						temp++;
						continue;
					}
				}
				//op=0;
				if(flag==0)
				{		
					tablewriter.write("<table border="+1+"><tr><th align=center>rho</th>");
					for( i=2;i<n;i++)
					{
						tablewriter.write("<th align=center>d="+i+"</th>");
					}
					tablewriter.write("</tr>");
				}
				flag=1;
				htmllist(dvalue,str);								
				temp=0;
			}
			list[t]=count;
			t++;
			count=0;
			tablewriter.write("</body></html>");
			tablewriter.close();
			flag=0;
		//optimalcode[n] +=optimalcode[n];
		 optimalcode[n]=universal;
		    universal=0;
		}
		enumerator();
	}

	
//================= Prints the webpage displaying table of d, rho and theta for each node ======================//
	
	private static void htmllist(int[][] dvalue,String s) throws FileNotFoundException {
		
		tablewriter.write("<tr><th>"+rho+"</th>");
		for(int i=2;i<n;i++)
		{
			if(dvalue[i-2][0]!=0)
			{
				tablewriter.write("<td align=center><a href=../"+general+n+"_"+dvalue[i-2][1]+"_"+dvalue[i-2][0]+"_"+rho+".html>"+dvalue[i-2][0]+"</a></td>");
			}
			else{
				tablewriter.write("<td align=center>-</td>");
			}
			
		}
		tablewriter.write("</tr>");
	}

	
//================== Prints the list displaying the nodes and the possible no. of FR codes for each ===============//
	
	private static void enumerator() throws FileNotFoundException {
		int i;
			pwriter = new PrintWriter(new File(path+"List.html"));
			System.out.println(a3[0]+"\t\t"+a3[1]);
			pwriter.write("<html><body>");
			pwriter.write("<table border="+1+"><tr><th align=center>No. of nodes, n</th><th align=center>No. of FR codes possible</th><th align=center>No. of Universally good and Optimal codes possible</th></tr>");
			pwriter.write("<tr>");
			
			for(i=3;i<n;i++)
			{
				System.out.println(i+"\t\t\t"+list[i]);
				pwriter.write("<td align =center>"+i+"</td><td align=center><a href=n/"+i+".html>"+list[i]+"</a></td>"+"<td align =center>" +optimalcode[i]+"</td>");
				pwriter.write("</tr>");
			}
		pwriter.write("</body></html>");
		pwriter.close();
	}

	
//============ Calculates the value of combination NcK ======================//	
	private static int binomial(final int N, final int K) {
	    BigInteger ret = BigInteger.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigInteger.valueOf(N-k))
	                 .divide(BigInteger.valueOf(k+1));
	    }
	    int r = (BigInteger.valueOf(n)).compareTo(ret);
	    return r;
	}
	
}
