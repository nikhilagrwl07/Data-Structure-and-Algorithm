
package countingsort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CountingSort2 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
        int N = Integer.parseInt(line);
        
        if(N>=1 && N<=1000000)
        {

        int b[]=new int[N];
        int k=100;
        String[] temp=br.readLine().split(" ");
        
        for(int i=0;i<N;i++)
        {
            int x=Integer.parseInt(temp[i]);
            if(x>=0 && x<k)
            {
                b[i]=x;
            }
            
        }
        
        int a[]=new int[N];
        
         countingSort(b,a,k);
         
     printout(a,a.length);//,"Sorted Input Sequence");
        }
       // printout(a,a.length,"Input String");
      
          
    
    }
    
     public static void printout(int a[],int r)
    {
        for(int i=0;i<r;i++)
            System.out.print(a[i]+" ");
        
        System.out.println();
    }
    public static void countingSort(int a[],int b[],int k)
    {
        int n=a.length;
        
        int c[]=new int[k];
        int i,j;
        
        // intinializing C[k] i.e., type array
        for(i=0;i<k;i++)
            c[i]=0; 
       // incremeneting the frequcency by 1  
        for(j=0;j<n;j++)
            c[a[j]]=c[a[j]]+1;    // Counting Sort is only possible for positive number.
        
        // Now calculating the cumulative frequency    
        for(i=1;i<k;i++)
            c[i]=c[i]+c[i-1];
        
          //System.out.println();
        ///for(j=n-1;j>=0;j--)
        for(j=0;j<n;j++)
        {
//            System.out.println(a[j]);
            b[--c[a[j]]]=a[j];
         //   c[a[j]]=c[a[j]]-1;
        }
        
    }

    public static void countingSortWithinRange(int a[],int b1[],int m,int n)
    {
        int c[]=new int[n-m+1];
        int i=0;
        
        // intintializing the value to 0
        for(i=0;i<c.length;i++)
            c[i]=0;
        
        // counting the frequency of each element
        for(i=0;i<a.length;i++)
        {
            if(m<=a[i] && a[i]<=n)
            {
                c[a[i]-m]=c[a[i]-m]+1;
            }
        }
        
        // calculating the cumulative frequency
        for(i=1;i<c.length;i++)
            c[i]=c[i]+c[i-1];
        
        
        // finally placing the sorted array in b
        
         for(i=0;i<a.length;i++)
        {
            if(m<=a[i] && a[i]<=n)
            {
              //  System.out.println("V = "+c[a[i]]);
                b1[--c[a[i]-m]]=a[i];
            }
        }
        
    }

}
