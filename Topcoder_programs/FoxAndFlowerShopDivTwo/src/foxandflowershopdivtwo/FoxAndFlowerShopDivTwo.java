/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foxandflowershopdivtwo;


import java.io.*;

public class FoxAndFlowerShopDivTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int r=1;
        int c=2;
        
        
        String flowers[]={".FF.F.F","FF...F.","..FF.FF"};
        
        System.out.println(theMaxFlowers(flowers,r,c));
                
    }
    
    public static int theMaxFlowers(String[] flowers, int r, int c)
    {
        int i,j,max=0,sum=0;
        int row=flowers.length;  // total number of coluemns
        int col=flowers[0].length();  // total number of rows
        
        char arr[][]=new char[row][col];
       //=new char[col];
        
        for(i=0;i<row;i++)   // for entering the data in 2-D array
        {
             char temp[]=flowers[i].toCharArray(); 
            
            for(j=0;j<col;j++)
            {
               arr[i][j] =temp[j]; 
            }
        }
        
               if(c>0)
               {
                   for(i=0;i<col;i++)
                   {
                       for(j=0;j<r;j++)
                       {
                           if(arr[j][i]=='F')
                           {
                               sum++;
                           }
                       }
                   }
               }
              
               if(max<sum)
                   max=sum;
               
               sum=0;
               
               if(c<(col-1))
               {
                   for(i=c+1;i<col;i++)
                   {
                       for(j=0;j<row;j++)
                       {
                           if(arr[j][i]=='F')
                           {
                               sum++;
                           }
                           
                       }
                   }
               }
                
               if(max<sum)
                   max=sum;
                 sum=0;
               
                if(r>0)
               {
                   for(i=0;i<col;i++)
                   {
                       for(j=0;j<r;j++)
                       {
                           if(arr[j][i]=='F')
                           {
                               sum++;
                           }
                       }
                   }
               }
              
               if(max<sum)
                   max=sum;
             sum=0;
             
             if(r<(row-1))
               {
                   for(i=0;i<col;i++)
                   {
                       for(j=r+1;j<row;j++)
                       {
                           if(arr[j][i]=='F')
                           {
                               sum++;
                           }
                       }
                   }
               }
                
               if(max<sum)
                   max=sum;
               
               
               return max;
    }
}
