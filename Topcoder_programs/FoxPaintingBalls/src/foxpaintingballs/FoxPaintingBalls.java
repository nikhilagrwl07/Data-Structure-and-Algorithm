
package foxpaintingballs;

import java.io.*;
import java.math.*;

public class FoxPaintingBalls {

    public static void main(String[] args)
    {
       long R=1,G=1, B=1;
       int N=5;
       System.out.println(theMax(R,G,B,N));
    }
    
    public static long theMax(long R, long G, long B, int N)
    {
        int f1=0,f2=0;
        long colorpball=0;
        long temp=0;
        int totalballs=(N*(N+1))/2;
          long min=0,p=0;
        if(R<G)
        {
            if(R<B)
                min= R;
            else
                min=  B;
        }
        
        else
        {
            if(B<G)
                min= B;
            else
                min= G;
        }
          
        
        if(totalballs%3!=0)
            f1=1;
        
        colorpball=min/3;
        
        if(min%3!=0)
            f2=1;
        
        temp=min/(long)3;
        
        if(f1==1 && f2==1)
        {
            p=min%3;
            return (colorpball-(p*3));
        }
        
        else
            return temp;
        
    }
}
