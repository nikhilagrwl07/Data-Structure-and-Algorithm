
package dynamicprogramming;

public class EggDroppingPuzzle {
    
     public static void main(String[] args) {
         
        int e=2,f=6;
        
        solution(e,f);
     
     
    }
     public static void solution(int e,int f)
     {
//System.out.println("Minimum # of trials with "+ e+" eggs and "+f+" floors (In worst Case -recursion)"+ " is "+Naive(e,f,Integer.MAX_VALUE));
System.out.println("Eggs="+ e+" floors= "+ f+" trials= " +recursive(e,f));         
System.out.println("DP : Eggs="+ e+" floors= "+ f+" trials= " +DP(e,f));         
//System.out.println("DP Minimum # of trials with "+ e+" eggs and "+f+" floors (In worst Case -DP)"+ " is "+DP(e,f));
System.out.println("Minimum # of trials with "+ e+" eggs and "+f+" floors (In worst Case -Formula)"+ " is "+byFomula(e,f));     
     }

     
  public static int recursive(int e,int f)
  {

      if(f==1 || f==0)
          return f;
      
      if(e==1)
          return f;
      
      
      int min=Integer.MAX_VALUE,i;
     
     for(i=f;i>=1;i--)
     {
         int minCompetitor=Math.max(recursive(e-1, i-1),recursive(e, f-i));
         
       //  System.out.println("Min= "+minCompetitor);
         
         if(min>minCompetitor)
         {
             min=minCompetitor;
         }
         
         //  System.out.println("Floor number = "+i+" trials= "+min);
     }
   
      return min+1;
  }
//     
//  public static int recursiveUtil(int e,int f,int totalFloor)   
//  {
//      // remember we are retturning number of ways 
//      // NOT the value of critical floor
//      if(e<1 || f<1)
//          return 0;
//      
//      if(f==1)
//          return 1;
//      
//      if(e==1 && f>1)
//          return f;
//      
//      int l=recursiveUtil(e-1, f-1, f);
//      System.out.println("l= "+l);
//      
//      int r=recursiveUtil(e, totalFloor-f,f);
//      System.out.println("r= "+r);
//      
//return 1+Math.max(l,r);
//  }
//     
     
     // DP approach bottom Up
     public static int DP(int e,int f)
     {
         // forming table
         int[][] t=new int[e+1][f+1];
         int[][] cricticalFloor=new int[e+1][f+1];
         
         int minfloor=-1;
                 
          // for 1 egg--> # of trials = # of floors
         int i,j,k,temp;
                 
         for(i=0;i<=f;i++)
         {
             // number of eggs =0
             t[0][i]=0;
             // number of eggs =1
             t[1][i]=i;
             
             cricticalFloor[1][i]=i;
         }
         
         for(j=1;j<=e;j++)
         {
             t[j][0]=0;
             t[j][1]=1;
             
             cricticalFloor[j][0]=0;
             cricticalFloor[j][1]=1;
         }
         
         for(i=2;i<=e;i++)
         {
             for(j=2;j<=f;j++)
             {
                 t[i][j]=Integer.MAX_VALUE;
                 //int minfloor;
                 
                 for(k=1;k<=j;k++)
                 {
                     temp=1+Math.max(t[i-1][k-1], t[i][j-k]);
                     
                     
                     if(temp<t[i][j])
                     {
                         minfloor=k;
                         t[i][j]=temp;
                     }
                 }
                 cricticalFloor[i][j]=minfloor;
              // System.out.print("floors = "+j);
              // System.out.println(" Critical floor = "+minfloor);
//                 System.out.println(" min trials = "+t[i][j]);
             }
         }
         
         for(i=0;i<=e;i++)
         {
             for(j=0;j<=f;j++)
             {
                 System.out.print(t[i][j]+" ");
             }
             System.out.println();
         }
         
             System.out.println("---------------");
         for(i=0;i<=e;i++)
         {
             for(j=0;j<=f;j++)
             {
                 System.out.print(cricticalFloor[i][j]+" ");
             }
             System.out.println();
         }
         
         return t[e][f];
     }

     public static int byFomula(int e,int f)
     {
         if(e==1)
             return f;
         
         return (int)((-1+Math.sqrt(1+8*f))/2 +0.5);
         
     }
}
