
package singleyllpalindrome;

import java.util.Iterator;
import java.util.LinkedList;

public class SingleyLLpalindrome {

    public static void main(String[] args) 
    {
       
       LinkedList IList=new LinkedList();  // creating the linkedlist 
       IList.add('r');                     // adding the object to LL
       IList.add('a');
     IList.add('d');
       IList.add('a');
       IList.add('r');
       //IList.add(1);
       System.out.println(palindrome(IList,0,IList.size()));
    }
    
    //doing it with recursion
   public static boolean palindrome(LinkedList ill,int l,int r)
    {
         int n=ill.size();
         int i=0;
         int mid=(n/2)+1;
   // for(i=0;i<=mid-1;i++)
    //{
        if(ill.get(i)==ill.get(n-i-1))
        {
            if(i==mid)
                return true;
            
            i++;
           palindrome(ill,i,n-i-1);
        }
        else
        {
            return false;
        }
   // }
    
    return true;
          
    }
}



  /* Iterator iterator =IList.iterator();
      
      while(iterator.hasNext())
      {
          System.out.println(iterator.next());
      }
      if(IList.isEmpty()) 
          System.out.println(true);
      else
           System.out.println(false);
      
      IList.addFirst(55);
         
       IList.add(5, 100);
     
       System.out.println(IList.hashCode());
       */