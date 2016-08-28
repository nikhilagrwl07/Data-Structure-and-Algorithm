
package thebricktowereasy;
import java.math.*;

public class TheBrickTowerEasy 
{

    public static void main(String[] args) 
    {
        System.out.println(find(47,47,47,47));

    }
    
    public static int find(int redCount, int redHeight, int blueCount, int blueHeight)
    {
        int min= Math.min(redCount, blueCount);
          int f=0,f2=0,g1=1;
        
        if(min==redCount)
        {
            f=1;
        }    
        
        int i,j,k=0,ht,p,n;
        int height[]=new int[redCount*blueCount+1];
        
        if(f==1)
        {
           for(i=1;i<=min;i++)
         {
            for(j=i-1;j<=i+1 && j<= blueCount;j++)
            {
             
                  ht=(redHeight*i) + (blueHeight*j);
                      
                   System.out.println( ht+"      ");
                  for(p=0;p<=k;p++)   // loop for checking already present value
                  {
                      if(height[p]==ht) 
                          f2=1;
                      
                  }
                  
                  if(f2==0)
                  {
                      k++;
                          height[k]=ht;
                         System.out.println(k+ "  "+ ht);
                  }
                  else
                  {
                      continue;
                  }
                  f2=0;
            }
        }
       
            if(height[1]==blueHeight)
                return k;
            
            else
                return k+1;
        }
        else
        {
         for(i=1;i<=min;i++)
         {
            for(j=i-1;j<=i+1 && j<= redCount;j++)
            { 
                ht=(redHeight*j) + (blueHeight*i);
             System.out.print(ht+"   ");
                  for(p=0;p<=k;p++)
                  {
                      if(height[p]==ht)
                          f2=1;
                  }
                  
                  if(f2==0)
                  {
                      k++;
                      height[k]=ht;
                        System.out.println(k);
                  }
                  else
                  {
                      continue;
                  }
                  f2=0;
            }
        }
           if(height[1]==redHeight)
                return k;
            
            else
                return k+1;
        }
        
       
}
}