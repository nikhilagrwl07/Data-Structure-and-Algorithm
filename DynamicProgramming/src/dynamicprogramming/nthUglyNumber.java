
package dynamicprogramming;

public class nthUglyNumber {
     public static void main(String[] args) {
    
        int k=11;      
        
        bottumUp_DP(k);
         //System.out.println(k);
    } 

public static void bottumUp_DP(int len)
{
         int i;
         int min1=1,min2=1,min3=1,min=1,prevMin=-1;
         
        System.out.println("1");
        
         for(i=2;i<=len;)
         {
             int a=min1*2;
             int b=min2*3;
             int c=min3*5;
             
             // finding minimum of all 3 numbers 
             min=(a<b)?(a<c?a:c):(b<c?b:c);
             //Math.min(c,Math.min(a,b));
             
            if(prevMin!=min)
             {                
                prevMin=min;
              // System.out.println(min1+" "+min2+" "+min3+" "+min);
                 System.out.println(min);
               i++;
             }
             
             if(min==a)
             {
                 min1++;
                 if(min1%2==0 || min1%3==0 || min1%5==0 )
                 {
                     //min1++;
                 }                     
                 else
                   min1=min1+1;
             }
             else if(min==b)
             {
                 min2++;
                 if(min2%2==0 || min2%3==0 || min2%5==0 )
                 {
                     //min2++;
                 }
                 else
                    min2=min2+1;
             }
             else
             {
                 min3++;
                 if(min3%2==0 || min3%3==0 || min3%5==0 )
                 {
                    // min3++;
                 }//=min3+2;
                 else
                    min3=min3+1;
             }
             
         }
         
}
    
}
