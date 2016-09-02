
package findingduplicates;
//import java.util.*;

import java.util.HashMap;


public class FindingDuplicates {

    public static void main(String[] args) {
        
        int input[]={3, 34, 4, 12, 5, 2};
       
        
       System.out.println("Input elements:");
      
        printArray(input);
      
   //    duplicates(input);
    //   maxFrequency(input);
       
       // first repeating element
    //   firstRepetetedElement(input);
       
    //  sumNearToZero(input);
      
       firstOccuranceOfElement(input,0,input.length-1,-80);
       lastOccuranceOfElement(input,0,input.length-1,85);
       
       subSetSum(input,9);
    }
    
    /* finding duplicated using O(N) complexity and O(1) space complexity
    / three limitations of this method
    * (1) applicable for write array only
    * (2) all values lies 0 to n-1
    * (3) all elements should be positive
    */
    
    public static void subSetSum(int a[],int s)
    {
        // first sort the elements
        quickSort(a,0,a.length-1);
        
        // Now check from starting and ending
        int lo=0,hi=a.length-1;
        
        System.out.println("Sum = "+s);
        while(lo<hi)
        {
            int v=a[lo]+a[hi];
            
            if(v==s) 
            {
                System.out.println("Set = "+a[lo]+" , "+a[hi]);
                lo++;
                //if(a[lo+1]+a[hi])
            }
            
            else if(v<s) lo++;
            
            else hi--;
        }
    }
    
    public static void duplicates(int input[])
    {        
        
        if(input.length==0) 
            return ;
        
        int i;
        System.out.println("\nDuplicate elements:");
       for(i=0;i<input.length;i++)
       {
         //  v=input[Math.abs(input[i])];
                     
          if(Math.abs(input[i])<input.length) 
          {
           if(input[Math.abs(input[i])]<0)
           {
               System.out.println(Math.abs(input[i]));
               input[Math.abs(input[i])]=input.length;
           }
           else if(input[Math.abs(input[i])]==0)
               input[Math.abs(input[i])]=2*input.length;
           
           else if(input[Math.abs(input[i])]==input.length)
               continue;
           
           else
           input[Math.abs(input[i])]=-input[Math.abs(input[i])];
          }
          
          else if(input[Math.abs(input[i])]==2*input.length)
          {
              System.out.print(Math.abs(input[i]));
              input[Math.abs(input[i])]=input.length;
          }
          else
              continue;
       }
        
    }
    
    
    // Time Complexity O(logn) Space Complexity O(1)
    public static void firstOccuranceOfElement(int a[],int lo,int hi,int data)
    {        
        while(lo<=hi)
        {
          int mid=lo+(hi-lo)/2;
          
          if((mid==hi && a[mid]==data) || (a[mid]==data && a[mid-1]<data))
          {
              System.out.println("\nFirst Occurance = "+mid);
              break;
          }
          else if(a[mid]<=data)
          {
              lo=mid+1;
          }
          else                 
          {
              hi=mid-1;
          }       
        
        }

        
    }
    
    
      // Time Complexity O(logn) Space Complexity O(1)
    public static void lastOccuranceOfElement(int a[],int lo,int hi,int data)
    {        
        while(lo<=hi)
        {
           //  System.out.println("Low = "+lo);
             //  System.out.println("High = "+hi);
          int mid=lo+(hi-lo)/2;
          
          if((a[mid]==data && a[mid+1]>data)||( mid==hi && a[mid]==data))
          {
              System.out.println("\n Last Occurance = "+mid);
              break;
          }
          else if(a[mid]<data)
          {
              lo=mid+1;
          }
          else                 
          {
              hi=mid-1;
          }       
        
        }
                
        
    }
    
    
    public static void maxFrequency(int input[])
    {
        if(input.length==0)
            return;
        int i,max=0,maxindex=-1;
        int l=input.length;
        for(i=0;i<input.length;i++)
        {
            input[input[i]%l] +=l;
        }
        
        for(i=0;i<l;i++)
        {
            int v=(int) input[i]/l;
            if(v>max)
            {
                max=v;
                maxindex=i;
            }
        }
        
        System.out.println("\nMaximum frequency of element="+maxindex);
    }
    
    
    
    /*Method 1: Use BST and before inserting any node check whether it is <,>, or = root node
     *          The first element which become = root is first repeated element
     *          O(nlogn) and O(n)
     * Method 2: Use hashTable 
     *          O(n) and O(n)
    */    
    // Using Method 2
    public static void firstRepetetedElement(int input[])
    {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        
        int i=0;
        while(i<input.length)
        {
               Integer freq=hm.get(input[i]);
                if(freq==null)
                    freq=1;
                else
                     freq++;
                
                hm.put(input[i], freq);
                
               i++; 
        }
        
        for(i=0;i<input.length;i++)
        {
            Integer f=hm.get(input[i]);
            
            if(f>1)
            {
                System.out.println("First repeating element="+input[i]);
                break;
            }
        }
    }
    
    
    public static void sumNearToZero(int input[])
    {
        // in-place sorting algo: quick Sort
        quickSort(input,0,input.length-1);
        
   // System.out.println("Array after sorting");
    //  printArray(input);
        
        int lo=0,hi=input.length-1;
        
        int sum=input[0]+input[input.length-1];
        
        int loIndex=0,hiIndex=input.length-1;
        
        while(lo<hi)
        {
            if(sum>Math.abs(input[lo]+input[hi]))
            {
                sum=Math.abs(input[lo]+input[hi]);
                loIndex=lo;
                hiIndex=hi;
            }
                
            if(input[lo]+input[hi]>0)
            {
                hi--;
            }
            else
                lo++;
        }
      
        System.out.println("Two elements whose sum is nearest to Zero= "+input[loIndex]+" , "+input[hiIndex]);
    }
  

public static void quickSort(int A[], int l, int h)
{
    if (l < h)
    {       
        int p = partition(A, l, h); 
        quickSort(A, l, p - 1); 
        quickSort(A, p + 1, h);
    }

    
}
    
    
// in-place partition algo
public static int partition (int arr[], int l, int h)
{
    int pivot = arr[h];
    int i = (l - 1);
 
    for (int j = l; j <= h- 1; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;
           int a=arr[i];
           arr[i]=arr[j];
           arr[j]=a;
            //swap (arr[i], arr[j]);
        }
    }
    //swap (arr[i + 1],arr[h]);
    int t=arr[i+1];
    arr[i+1]=arr[h];
    arr[h]=t;
    return (i + 1);
}

public static void printArray(int input[])
{
    int i;
    System.out.println();
    
    for(i=0;i<input.length;i++)
    {
        System.out.print(input[i]+"  ");
    }
}

}



