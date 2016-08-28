
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author nikhil
 */
class findpopular
{
public static void main(String args[]) throws IOException
{
int i,n,k,p,j;


BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
         n = Integer.parseInt(s);

int freq[]=new int[n];

for(i=0;i<n;i++)
   freq[i]=0;


if(n<300000 && n>0)
{
 String arr[]=new String[n];


for(i=0;i<n;i++)
{
  arr[i]=br.readLine();
System.out.println("check"+i);

  for(j=0;j<=i;j++)      // putting all strings in lexicographic manner
  {
           if (arr[j].compareTo(arr[i]) > 0)
                {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
	  
  }

}

	 s = br.readLine();
         k = Integer.parseInt(s);  // top k most freqent elemet to be print
 
int total=0,each=1;
j=0;


for(i=0;i<(n-1);j++)
{
  while(arr[i].equals(arr[i+1]))
  {	
	each++;
    total++;
   i++;
  }   
  i++;
arr[j]=arr[i];   // same
 //i=i+each;

 freq[j]=each;  //same
 each=0;
}


/*using quicksortsorting alog applied here
 quickSort(freq,0,n-1,arr);  */

//using selection sort for appyling 
for(i=0;i<n-1;i++)
{
for(j=i+1;j<n;j++)
{
   if(freq[j]>freq[i])
   {
      int t=freq[j];
	freq[j]=freq[i];
	freq[i]=t;

      String str=arr[j];
	arr[j]=arr[i];
	arr[i]=str;

   }

	
}
}

for(p=0;p<k;p++)
 System.out.println(arr[p]);
}

}


}
/*public static int partition(int arr[], int left, int right,String stringval[])

{

      int i = left, j = right;

      int tmp;
	String str;

      int pivot = arr[(left + right) / 2];

     

      while (i <= j) {

            while (arr[i] < pivot)

                  i++;

            while (arr[j] > pivot)

                  j--;

            if (i <= j) {

                  tmp = arr[i];

                  arr[i] = arr[j];

                  arr[j] = tmp;
		
		 str=stringval[i];
		stringval[i]=stringval[j];
		stringval[j]=str;

                  i++;

                  j--;

            }

      };

     

      return i;

}

public static void quickSort(int arr[], int left, int right,String stringval[]) {

      int index = partition(arr, left, right,stringval);

      if (left < index - 1)

            quickSort(arr, left, index - 1,stringval);

      if (index < right)

            quickSort(arr, index, right,stringval);

}
*/
















