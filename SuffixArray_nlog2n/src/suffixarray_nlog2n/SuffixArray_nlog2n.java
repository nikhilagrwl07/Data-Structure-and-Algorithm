
package suffixarray_nlog2n;

// the basis on which two objects of same class would be compared

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class entry
{
    int nr[]=new int[2];
    int p;
}


public class SuffixArray_nlog2n {
       
    public static int cmp(entry a, entry b)
    {
         return a.nr[0]==b.nr[0] ?(a.nr[1]<b.nr[1] ?1: 0): (a.nr[0]<b.nr[0] ?1: 0);
    }
    
    public static void main(String[] args) throws IOException {
          int MAXN=65636;
      int MAXLG=17;
    
   // char[] A=new char[MAXN];
    int p[][]=new int[MAXLG][MAXN];   
   
    entry L[]=new entry[MAXN];
              System.out.println("Enter the string.");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
       String A= br.readLine();       
    
        int N=A.length(),i,stp,cnt;
        
       for(i=0;i<N;i++)
          p[0][i]=A.charAt(i) -'a';
       
       
       for(stp=1,cnt=1;cnt<N;stp++,cnt*=2)
       {
           for(i=0;i<N;i++)
           {
               L[i]=new entry();
               //System.out.println("p[stp-1][i] = "+p[stp-1][i]+" i="+i);
               L[i].nr[0]=p[stp-1][i];
               L[i].nr[1]=i +cnt <N? p[stp -1][i+ cnt]:-1;
               L[i].p= i;
           }
           
           // Comparing part
           
           for(int i3=N-1;i3>=0;i3--)
           {
               for(int i4=0;i4<i3-1;i4++)
               {
                 if(cmp(L[i4],L[i4+1])==0)
                 {
                     // swap L[i3] with L[i4]
                    entry demo=new entry();
                    demo.nr[0]=L[i4].nr[0];
                    demo.nr[1]=L[i4].nr[1];
                    demo.p=L[i4].p;
                    
                    L[i4].nr[0]=L[i4+1].nr[0];
                    L[i4].nr[1]=L[i4+1].nr[1];
                    L[i4].p=L[i4+1].p;
                    
                    L[i4+1].nr[0]=demo.nr[0];
                    L[i4+1].nr[1]= demo.nr[1];
                    L[i4+1].p=demo.p;
                 }
               }
           }
           
        
           for(i=0; i < N; i++)
           {
               p[stp][L[i].p] =i> 0 && 
                       L[i].nr[0]==L[i-1].nr[0] && 
                       L[i].nr[1] == L[i- 1].nr[1] ? 
                       p[stp][L[i-1].p] : i;
           }
    }
       
       // Printing the output
       for(int k=0;k<N;k++)
       {
           System.out.println(p[stp-1][k]);
       }
}

}