
package sorting;

public class IterativeQuickSort {
  
    public static void main(String[] args) {
        
       // int a[]={5,6,8,0,-1,-100,5,8,200,5};
        
        int a[]={4,8,5,6,9,10,6,10,1,2,1,2,2,1,15,14,17, 0 , 0};
        int l=0,h=a.length-1;
        
        System.out.println("Input Unsorted Array");
        display(a);
        
        IterativeQuickSort(a,l,h);
        
        System.out.println("Output Sorted Array");
        display(a);
        
    }
    
    public static void IterativeQuickSort(int a[],int low,int high)
    {
        int l,h;
       int top=-1;
       int stack[]=new int[high-low+1];
       
       stack[++top]=low;
       stack[++top]=high;
       
       while(top>=0)
       {
           h=stack[top--];
           l=stack[top--];
           
           int p=partition(a,l,h);
         
           if(l<p-1)
           {
               stack[++top]=l;
               stack[++top]=p-1;
           }
           
           if(p+1<h)
           {
               stack[++top]=p+1;
               stack[++top]=h;
               
           }
            
             
          
       }
       
    }
    
    
     public static int partition(int ar[],int l,int h)
     {
         int pivot=ar[h];
         int j;
         int i=l-1;
         for(j=l;j<=h-1;j++)
         {
             if(ar[j]<=pivot)
             {
                 i++;
                 int t=ar[j];
                 ar[j]=ar[i];
                 ar[i]=t;
                              
             }
         }
         //swap a[i+1] and a[h]
         int n=ar[i+1];
         ar[i+1]=ar[h];
         ar[h]=n;
         
         return (i+1);
     }
    
    
    public static void display(int ar[])
    {
        for(int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]+"  ");
        }
        System.out.println();
        
    }
}
