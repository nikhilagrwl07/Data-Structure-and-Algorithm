
package stringalgorithm;

// Very Important formula to remember --> pdp patiq


public class RabinKarp {

   
    public static void main(String[] args) {
        String txt="The average  Karp and best case running time of the Rabin-Karp algorithm";
        String pat="Karp";
   
        
  //String txt="AAAAAAAA";
 // String pat="AAA";
        
        System.out.println("txt = "+txt+" length = "+txt.length());
        System.out.println("pat = "+pat);
        int q=23; // choosing prime number
        
        RKsearch(txt.toCharArray(),pat.toCharArray(),q);
    }
   
    
    public static void RKsearch(char[] txt,char[] pat,int q)
    {
       if(txt.length==0 || pat.length==0)
       {
           System.out.println("Invalid inputs. ");
           return;
       }
       
       int M=pat.length;
       int N=txt.length;
       
       int h=1;
       
       int t=0;
       int p=0;
       
       int d=256;  // number of input alphabets in txt string
       
       int i,j;
       
//       int h2=1;
//       
//       // calculating h 
//       for(i=0;i<=M-2;i++)  
//           h2=(h2*d)%q;    // h=(d^m-1)%q
//      
       //System.out.println("");
      
        h=(int) (Math.pow(d, M-1)%q);
       
      //System.out.println("h= "+h+" h2 = "+h2);
        
       // preprocessing the t and p;
       for(i=0;i<M;i++)
       {
           // Very Important formula to remember --> pdp patiq
           
           p=(d*p+pat[i])%q;   // No need to include the h 
           t=(d*t+txt[i])%q;
       }
       
       
       // verifiying the hash value and sliding the window
       for(i=0;i<=N-1;i++)
       {
           if(p==t)
           {
               for(j=0;j<M;j++)// deep comparison
               {
                   if(pat[j]!=txt[i+j])
                       break;
               }
               if(j==M)
                   System.out.println("Match Occur i = "+i);
           }
           
           // updating the t by sliding the window
           if(i+M<=N-1)
           {
               t=((d*(t-txt[i]*h))+txt[i+M])%q;
                            
               if(t<0)
                   t=t+q;
               
         //       System.out.println("d= "+d+" t= "+t+" h= "+h);
           }
           else
               break;
           
       }
       
    }
    
     public static void printArray(int[] a)
     {
         for(int i=0;i<a.length;i++)
             System.out.print(a[i]+" ");
     }

}
