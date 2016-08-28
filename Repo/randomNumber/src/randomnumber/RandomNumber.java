
package randomnumber;
import java.util.*;
public class RandomNumber {

    public static void main(String[] args) {
        random obj=new random();
        
       int n=5;
       int x=7;
       
  //  System.out.println("Random Number between 1 to 5(inclusive)  = "+obj.randomNumber(n));
         
   
        
    long start = System.currentTimeMillis ();
    System.out.println("Random Number between 1 to 7  = "+obj.my_rand(n,x));
    System.out.println("Random Number between 1 to 5(inclusive)  = "+obj.randomNumber(n));
    long end = System.currentTimeMillis ();
System.out.println("Time taken for execution is= " + (end-start));

        start = System.currentTimeMillis ();
        System.out.println("Random Number between 1 to 5(inclusive)  = "+obj.randomNumber(n));
         end = System.currentTimeMillis ();
    
System.out.println("Time taken for execution is= " + (end-start));

    }
}

class random
{
    public int my_rand(int n,int x)
    {
//          int MaxRandom =5*n+n-5;
//          
//          //  System.out.println("Max Allowed1 = "+MaxRandom);     
//            
//          int maxAllowed=1;
//          
//         while(maxAllowed<=MaxRandom)
//         {
//             maxAllowed=maxAllowed*x;
//         }
//             maxAllowed=maxAllowed/x;       
//             
//        System.out.println("Max Allowed = "+maxAllowed);     
        
       int i;      
       do
       {
       int a=randomNumber(n)+1;
       int b=randomNumber(n)+1;
        i=5*a+b-5;
       }while(i>=22);
       
       return i%x+1;
        
    }
    
   // using predefined function          
    public int randomNumber(int n)
    {
        Random generator=new Random();
        int c=generator.nextInt(n)+1;  //generates between 0 to n-1
        
  /*      while(c==0)
        {
            c=generator.nextInt(n);
        }
    */    
        
        return c;
    }
    
}
