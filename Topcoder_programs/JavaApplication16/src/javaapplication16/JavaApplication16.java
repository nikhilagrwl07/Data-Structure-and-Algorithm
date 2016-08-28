/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.Stack;
public class JavaApplication16 {
   
    public static void main(String[] args) throws java.util.EmptyStackException
    {
        // TODO code application logic here
        Stack<Integer> s=new Stack<Integer>();
        
        int arr[]={16, 17, 4, 3, 5, 2};
        int i,n,t;
        for(i=0;i<arr.length;i++)
        {
            if(s.empty()== true)
            {
                s.push(arr[i]);
            }
            
            else
            {
                if(s.peek() > arr[i])
                    s.push(arr[i]);
                else
                {
                   n=s.size();                
                    while(n >= 0)
                    {
                           t=s.pop();
                           n--;
                           if(n>0)
                           {
                               if(s.peek() > arr[i])
                                {
                                    s.push(arr[i]);
                                     break;
                                }
                            }
                           else
                                s.push(arr[i]);
                    }
            }
         }
        }
        
        while(s.size()>=0)
        {
            System.out.println(s.pop());
        }
}
    }