
package amazontest;

import java.util.Arrays;


public class NextGreaterElement {
   
    public static void main(String[] args) {
        
     int[] a={4, -5, 2, 25, 20, 11, 1300, -8};
  //  System.out.println("Initial Array: \n"+Arrays.toString(a));
    
     
    String s="Nik"+" hil Agr wal";
     System.out.println("Before String s= "+s);
    // s=s.trim();
     
   s=s.replaceAll(" ","");   
  
      System.out.println("After String s= "+s);
      
//       int i=0,N=s.length()-1;
//       
//       while(i<=N)
//       {
//           if(s.charAt(i)==' ')
//           {
//               
//           }
//       }
    
    
    //NGE(a);
   // minMax(a);
    
    }
    
    
 // Wrong method: Correct Method : Use Stack   
    // Action : Implement this latter
    public static void NGE(int a[])
    {
        int g[]=new int[a.length];
        //int i;
        
        g[a.length-1]=-1;
        
        for(int i=a.length-2;i>=0;i--)
        {
            if(a[i]<=a[i+1])
            {
                g[i]=a[i+1];
            }
            else
            {
                if(g[i+1]<a[i])
                {
                    g[i]=-1;
                }
                else
                {
                    g[i]=g[i+1];
                }
                
            }
        }
  System.out.println("NGE Array: \n"+Arrays.toString(g));      
        
        
    }
    
    // finding min and max element of an array
    // Number of comparison= 3*n/2
        public static void minMax(int a[])
        {
            int N=a.length;
            
            if(N==0)
            {
                System.out.println("Empty array");
                return;
            }
            else if(N==1)
            {
                System.out.println("Min = "+a[0]+" Max= "+a[0]);
                return;
            }
            
            int minTotal=Integer.MAX_VALUE;
            int maxTotal=Integer.MIN_VALUE;
            int i=0;
            int min,max;
            
            if(N%2==1) // odd case
            {
                min=max=a[i++];
            }

            while(i<=N-2)
            {
                if(a[i]<a[i+1])
                {
                    min=a[i];
                    max=a[i+1];
                }
                else
                {
                     max=a[i];
                    min=a[i+1];
                }
                
               if(minTotal>min)
               {
                   minTotal=min;
               }
               
               if(maxTotal<max)
               {
                   maxTotal=max;
               }
                i+=2;
                
            }
            
             System.out.println("Min = "+minTotal+" Max= "+maxTotal);
            
        }
    
    
}
