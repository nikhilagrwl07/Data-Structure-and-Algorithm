
package llloopdetection;

import java.util.LinkedList;

public class LLloopDetection 
{
    public static void main(String[] args) 
    {      
        LinkedList<Integer> l=new LinkedList<Integer>();
                
       LinkedList IList=new LinkedList();  // creating the linkedlist 
       IList.add('r');                     // adding the object to LL
       IList.add('a');
     IList.add('d');
       IList.add('a');
       IList.add('r');
     System.out.println(detectLoop(IList,0,IList.size()));
    }
    
// using the Hash table
   public static boolean detectLoop(LinkedList ill,int l,int r)
    {
         int n=ill.size();
         int i=0;
         int mid=(n/2)+1;
  
    
    return true;
          
    }
}

