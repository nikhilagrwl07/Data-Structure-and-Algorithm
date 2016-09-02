
package tworepeatingelementinarray;


public class TwoRepeatingElementInArray {

    // finding two elements repeating two times in an array
    public static void  printRepeating(int a[])
    {
        int xor=a[0]; // will hold the xor of all the elements
        int set_bit_no; // will have only single set bit of xor
        int i;
        int n=a.length-2;
        int x=0,y=0;
        
        
        // get xor of all elements in array a and {1......n}
        
        for(i=1;i<a.length;i++)
            xor ^=a[i];
        
        for(i=1;i<=n;i++)
            xor ^=i;
        
        // get the rightmost set bit in set_bit_no
        set_bit_no=xor & ~(xor-1);
        
         /* Now divide elements in two sets by comparing rightmost set
   bit of xor with bit at same position in each element. */
  for(i = 0; i < a.length; i++)
  {
        if((a[i] & set_bit_no)!=0)
        x = x ^ a[i]; /*XOR of first set in arr[] */
        else
        y = y ^ a[i]; /*XOR of second set in arr[] */
  }
        
        
     for(i = 1; i <=n; i++)
  {
        if((i& set_bit_no)!=0)
        x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
        else
        y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
  }
     
        System.out.println("Two repeating elements x = "+x+" y = "+y);
        
    }
    
    public static void main(String[] args) {
        
          int arr[] = {3, 2, 4, 5, 2, 5, 1};
           printRepeating(arr);
          
        
    }
}
