
import java.io.*;

public class kleofas {
    public static void main(String args[])
    {
        System.out.println(countGoodSequences(3,4,8));      
        
    }
    
    
   public static long countOne(long K,long N) 
   {
        long lo=K,hi=K,result=0;
        if(K%2==0)
            hi++;
        while(lo<=N)
        {
            result=result+Math.min(N,hi)-lo+1;
            lo=lo*2;
            hi=hi*2+1;
        }
        
        return result;
   }
    
    
    public static long countGoodSequences(long K, long A, long B)
    {
       return countOne(K,B)-countOne(K,A);
            
    }
    
    
    
}
    

