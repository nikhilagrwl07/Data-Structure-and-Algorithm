
package sum2elements;

public class Sum2elements {

    public static void main(String[] args)
    {
      int array[]={-8,-4,1, 8,8, 10,20};
      int sum=16;
      int l=0,i;
      int r=array.length-1;
      
  // quick_srt(array,l, r); // NOT working for duplicate elements
     
      for(l=0;l<r;)
      {
          if(array[l]+array[r]==sum)
          {
              System.out.println(array[l]+"  "+array[r]);
              r--;
          }
          
          else if(array[l]+array[r]<sum)
          {
              l++;
          }
          
          else
          {
              r--;
          }
      }
    }
    
    
  //quicksort implementation 
    
  public static void quick_srt(int array[],int low, int n)
  {
    int lo = low;
     int hi = n;
     if (lo >= n) 
     {
         return;
      }
     
  int mid = array[(lo + hi) / 2];
  
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
      int T = array[lo];
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
