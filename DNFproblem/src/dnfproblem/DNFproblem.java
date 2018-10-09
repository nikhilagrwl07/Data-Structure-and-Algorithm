
package dnfproblem;


public class DNFproblem {

   
    public static void main(String[] args) {
       int a[]={0,1,0,0,2,2,2,1,2,0,2,1,2};
       display(a);
       sort012(a,a.length-1);
       display(a);
    }
    
    public static void sort012(int p[],int s)
    {
        int lo=0;
        int hi=s;
        int mid=0;
        while(mid<=hi)
        {
            switch(p[mid])
            {
                case 0:
                    int t=p[lo];
                    p[lo]=p[mid];
                    p[mid]=t;
                    lo++;
                    mid++;
                    break;
                    
                case 1:
                    mid++;
                    break;
                    
                case 2:
                      t=p[hi];
                    p[hi]=p[mid];
                    p[mid]=t;
                    hi--;
                    break;
                    
            }
        }
    }
    
    public static void display(int ar[])
    {
        int i;
        for(i=0;i<ar.length;i++)
        {
                    System.out.print(ar[i]+"  ");
        }   
               System.out.println();
    }
}
