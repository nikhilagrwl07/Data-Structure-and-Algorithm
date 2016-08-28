
package horseracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math.*;

public class HorseRacing 
{  
    public static void main(String[] args) throws IOException
    {
    
  int i,t,n;
  long v1,v2;
  long min=1000;
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  t=Integer.parseInt(br.readLine());
  n=Integer.parseInt(br.readLine());

  long array[]=new long[n];
  String str=br.readLine();
  
     String str1[]=str.split(" ");

     for(i=0;i<n;i++)
     {
         array[i]=Long.parseLong(str1[i]);            
     }
     
         
  quick_srt(array,0,array.length-1);
     
     for(i=1;i<=n-2;i++)
     {
         v1=Math.abs(array[i]-array[i-1]);
         v2=Math.abs(array[i]-array[i+1]);
       long min1=Math.min(v1, v2);
       
       if(min1<min)
           min=min1;
       
     }
     
     System.out.println(min);

  
  
    }
  
  

  public static void quick_srt(long array[],int low, int n)
  {
    int lo = low;
     int hi = n;
     if (lo >= n) 
     {
         return;
      }
     
  long mid = array[(lo + hi) / 2];
  
  while (lo < hi) 
  {
        while (lo<hi && array[lo] < mid) 
        {
            lo++;
        }
        while (lo<hi && array[hi] > mid) 
        {
         hi--;
        }
    if (lo < hi) 
    {
      long T = array[lo];
        array[lo] = array[hi];
         array[hi] = T;
    }
  }
  
  if (hi < lo)
  {
  int T = hi;
  hi = lo;
  lo = T;
  }
  quick_srt(array, low, lo);
  quick_srt(array, lo == low ? lo+1 : lo, n);
  }
}