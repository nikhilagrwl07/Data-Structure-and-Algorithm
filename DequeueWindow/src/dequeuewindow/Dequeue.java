
package dequeuewindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Dequeue {

    public static void main(String[] args) {
     
        //dequeueUse();
        int arr[] ={8, 5, 10, 17, 9, 4, 15, 12, 90, 13};
          int k = 3;
         System.out.println(Arrays.toString(arr)); 
          
          printMaxInWindow(arr,k);
    }
    
    
//    public static void dequeueUse()
//    {
//        
//        int arr[] ={8, 5, 10, 17, 9, 4, 15, 12, 90, 13};
//        Deque<Integer> q=new LinkedList();
//        q.addFirst(1);
//        q.addFirst(2);
//        q.addLast(3);
//        System.out.println("Dequeue : = " + Arrays.asList(q.toArray()));
//        
//        
//        
//    }
    
//    public static void printMaxInWindow(int a[],int k)
//    {
//        Deque<Integer> q=new LinkedList();
//        int temp[]=new int[k];
//        int N=a.length;
//        q.addLast(a[0]);
//        
//        int i;
//        for(i=1;i<k;i++)
//        {
//            if(q.getLast()<a[i] )
//            {
//                q.clear();
//                q.addLast(a[i]);                
//            }
//            else  // incoming elment less than last element
//            {
//                if(q.getFirst()>a[i])
//                {
//                    //System.out.println("size = "+q.size());
//                    if(q.size()==k)
//                    {
//                        q.removeLast();
//                        q.addFirst(a[i]);
//                    }
//                    else
//                    {
//                       q.addFirst(a[i]);   
//                    }
//                }
//                else
//                {
//                    q.removeFirst();
//                    q.addFirst(a[i]);
//                }
//            }
//           
//        }
//        
//      // System.out.println(q.size());
//        System.out.println(q.getLast());
//        
//        for(;i<N;i++)
//        {
//            //System.out.println("element = "+a[i]);
//            if(q.getLast()<a[i])
//            {
//                q.clear();
//                q.addLast(a[i]);                
//                
//               // System.out.println("If "+q.getLast());
//            }
//            else  // incoming elment less than last element
//            {
//                if(q.getFirst()>a[i])
//                {
//                    
//                    if(q.size()==k)
//                    {
//                    
//                        q.removeLast();
//                        q.addFirst(a[i]);
//                    }
//                    else
//                    {
//                       q.addFirst(a[i]);   
//                    }
//                }
//                else
//                {
//                    int j=0;
//                    
//                    //System.out.println("Check ");
//                   while(true)
//                   {
//                       int e=q.removeFirst();
//                       
//                       if(e<a[i])
//                       {
//                           temp[j]=e;
//                           j++;
//                       }
//                       else
//                       {
//                           q.addFirst(e);
//                           break;
//                       }
//                   }
//                   
//                    q.addFirst(a[i]);
//                    j--;
//                    
//                    while(j>=0)
//                    {
//                        if(q.size()<k)
//                        {
//                            q.addFirst(temp[j]);
//                        }
//                        else
//                        {
//                            break;
//                        }
//                        
//                        j--;
//                    }
//                    
//                }
//           // System.out.println(q.getLast());
//            }
//           // System.out.println("Size = "+q.size());
//             System.out.println(q.getLast());
//            
//        }
//        
//    }
//    
    public static void printMaxInWindow(int a[],int k)
    {
        Deque<Integer> q=new LinkedList();
        //int temp[]=new int[k];
        int N=a.length;
       // q.addLast(a[0]);
        int i;

        for(i=0;i<k;i++)
        {
            while(!q.isEmpty() && a[i]>=a[q.getLast()])
                q.removeLast();

            q.addLast(i);
        }

        for(;i<N;i++)
        {
            System.out.println(a[q.getFirst()]);

            while(!q.isEmpty() && a[i]>=a[q.getLast()])
                q.removeLast();

            while(!q.isEmpty() && q.getFirst()<=i-k)
                q.removeFirst();

            q.addLast(i);
        }

        System.out.println(a[q.getFirst()]);

//        
    }
}
