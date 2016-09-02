/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author nikhil.agrawal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int x =100;
        int y =~x;
        System.out.println(y);
        
//        BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
//            String line = input.readLine();
//            String[] splitLine = line.split(" ");
//            int n= Integer.parseInt(splitLine[0]);
//            int m= Integer.parseInt(splitLine[1]);
//            
//            int tickets[] = new int[n];
//          
//         line = input.readLine();
//         splitLine = line.split(" ");
//         
//         int sum =0;
//         for(int i=0;i<splitLine.length;i++)
//         {
//             tickets[i]= Integer.parseInt(splitLine[i]);
//             sum +=tickets[i];
//         }
    }
    
    public static int sell(int n ,int m , int ticket[] ,int sum)
    {
        if(n<0 || n==0 || m< 0 || m==0 || ticket == null) return -1;
        
        
        int[] arr= new int[sum];
        int i=0;
            for(int j=0;j<ticket.length;j++)
            {
                for(int k=1;k<=ticket[j];k++)
                {
                  arr[i++]=k;    
                }
                
            }
        
        quickSort2(arr, 0, arr.length-1);
        
        int sumtemp=0;
        
        int reverse=arr.length-1;
        for(int count =1;count<=m;count++)
        {
            sumtemp +=arr[reverse];
            reverse--;
        }
        
        return sumtemp;
    }
    
    
public static void quickSort2(int a[],int l,int h)
{
    if(l<h)
    {
        int p=partition(a,l,h); // partitioning index
        
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        
        quickSort2(a, l, p-1);
        quickSort2(a, p+1, h);
        
    }
    
}

public static int partition(int arr[],int l,int h)
{
    int x = arr[h];    // pivot
    int i = (l - 1);  // Index of smaller element
 
    for (int j = l; j <= h- 1; j++)
    {
        // If current element is smaller than or equal to pivot 
        if (arr[j] <= x)
        {
            i++;    // increment index of smaller element
//            System.out.println("i = " + i + " j = " + j);
//            System.out.println("a[i] = " + arr[i] + "  a[j] = " + arr[j]);
            swap(arr,i, j);  // Swap current element with index
        }
    }
    
    swap(arr, i+1, h ) ; 
    return (i + 1);
  
    
}
    public static void swap(int arr[], int a, int b)
    {
        int c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }


}
