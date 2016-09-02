
package dynamicprogramming;

public class fibonacciSeries {
    public static void bottomUp_DP(int len)
    {
        if(len==0)
            return;
        int i=0,t;
        int i1=0,i2=1;
        
       // System.out.print(i1+" "+i2+" ");
        
        for(i=2;i<=len;i++)
        {           
            t=i2;            
            i2=i2+i1;
            i1=t;
         
        }
            System.out.println("Bottom Up(DP) = "+i2);
    }
    
    
    public static void topDown_DP(int len)
    {
        int MAX=10000;
        int val[]=new int[MAX];
        
        System.out.println("Top Down (DP)= "+topDownUtil(len,val));

    }
    
    public static int topDownUtil(int n,int lookup[])
    {
        if(n==1 || n==0)
            lookup[n]=n;
        else
        {
            lookup[n]=topDownUtil(n-1, lookup)+topDownUtil(n-2, lookup);
        }
        return lookup[n];
    }
    
    public static void recursive_Naive(int a)
    {
        System.out.println("Recursive = "+recursive_NaiveUtil(a));  
    }
    public static int recursive_NaiveUtil(int a)
    {
        if(a==0 || a==1)
            return a;
        
        int f1=recursive_NaiveUtil(a-1);
        int f2=recursive_NaiveUtil(a-2);
        
        return f1+f2;
    }
    
    
    public static void main(String[] args) {
    
        int k=4;       
        
        bottomUp_DP(k);
        recursive_Naive(k);
        topDown_DP(k);
    } 
}

