
package trailingzeros;

public class TrailingZeros {

    public static void main(String[] args) {
       
        int n=8;
        int f[]=new int[10];
        
        frequnecy(n,f);
        
       printArray(f);
    }
    
    public  static  void  frequnecy(int  k,int[] f) 
    {
        int i;
        for(int number=k;number>=1;number--)
        {
        for(i=2;i<=9;i++)
        {
            int count = 0;


        for ( int j = i; k/j >= 1; j *= i )
        {
      
        count  +=  k  /  j;
        }

        f[i]=count;
        }
        }
        }
    
     public  static  void  printArray(int[] f) 
     {
         for(int i=0;i<f.length;i++)
         {
             System.out.println(i+"--> "+ f[i]);
         }
     }
}
