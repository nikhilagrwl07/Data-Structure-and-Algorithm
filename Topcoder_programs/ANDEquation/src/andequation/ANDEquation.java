
package andequation;

import java.io.*;

public class ANDEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int A[]={191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,
 191411,195511,191419,191411,256947,191415,191475,195579,191415,191411,
 191483,191411,191419,191475,256947,191411,191411,191411,191419,256947,
 191411,191411,191411};
       
        System.out.println(restoreY(A));
        
    }
    
    
    public static int restoreY(int[] A)
    {
        int min=A[0],minindex=0;
        int i,v=1048575,k=0;
        int len=A.length;
        
        if(len==2)
            return -1;
        
        
        for(i=1;i<len;i++)
        {
            if(min>A[i])
            {
                min=A[i];
                    minindex=i;
            }  
        }
        
       // System.out.println(min);
        
        if(minindex >=2)
        {
            for(k=0;k<minindex-1;k++)
            {
                v= v & A[k] & A[k+1];
            }
            
            if(minindex!=len-1)
            {
                for(k=minindex+1;k<len-1;k++)
                {
                     v= v & A[k] & A[k+1];
                }
            }
            
        }
        
        else
        {
            if(minindex==0)
            {
                for(k=1;k<len-1;k++)
                {
                     v= v & A[k] & A[k+1];
                }
            }
            
            else
            {
                int t=A[0];
                A[0]=A[1];
                A[1]=t;
                for(k=1;k<len-1;k++)
                {
                     v= v & A[k] & A[k+1];
                }
                
            }
        }
        if(v== min)
        return v;
        
        else
            return -1;
        
    }
}
