
package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Dequeue {

    public static void main(String[] args) {
        int x[] ={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int i=0;
		int k=3;
		
		// Create a Double Ended Queue, Qi that will store indexes of array elements
	    // The queue will store indexes of useful elements in every window and it will
	    // maintain decreasing order of values from front to rear in Qi, i.e.,
	    // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
		Deque<Integer> q=new  ArrayDeque<Integer>();

		for(;i<k;i++){
			 // For every element, the previous smaller elements are useless so
	        // remove them from q
			while(!q.isEmpty() && x[q.peekLast()]<=x[i]){
				q.removeLast();
			}
			q.addLast(i); // Add new element at rear of queue
		}

                // i=k =3
		for ( ; i <x.length; ++i){

			// The element at the front of the queue is the largest element of
	        // previous window, so print it
			System.out.println(q.peekFirst() +" -- "+ x[q.peek()]);

			 // Remove the elements which are out of this window
			while(!q.isEmpty() && q.peekFirst()<=i-k){
				q.removeFirst();// Remove from rear
			}

			// Remove all elements smaller than the currently
	        // being added element (remove useless elements)
			while(!q.isEmpty() && x[q.peekLast()]<=x[i]){
				q.removeLast();
			}

			q.addLast(i);
		}

		System.out.println(x[q.peek()]);
//        int arr[] ={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
//          int k = 3;
//         System.out.println(Arrays.toString(arr));
//          max_of_subarrays(arr, 3);
//        //  printMaxInWindow(arr,k);
    }


    public static void max_of_subarrays(int ar[], int k){
		int max_i = max(ar[0], ar[1], ar[2]);
		int max = ar[max_i];
		int sec_max_i;
		int sec_max;
		if(max_i == 0){
			if(ar[1] > ar[2]){
				sec_max_i = 1;
			}
			else{
				sec_max_i = 2;
			}
			sec_max = ar[sec_max_i];
		}
		else if(max_i == 1){
			if(ar[0] > ar[2]){
				sec_max_i = 0;
			}
			else{
				sec_max_i = 2;
			}
			sec_max = ar[sec_max_i];
		}
		else{
			if(ar[1] > ar[0]){
				sec_max_i = 1;
			}
			else{
				sec_max_i = 0;
			}
			sec_max = ar[sec_max_i];
		}
		System.out.println(max);
		for(int i=1;i+2<ar.length;i++){
			if(!(max_i >= i && max_i < i+2)){
				max = sec_max;
				max_i = sec_max_i;
				sec_max_i = i + i + 1 - max_i;
				sec_max = ar[sec_max_i];
			}
			if(!(sec_max_i >= i && sec_max_i < i+2)){
				sec_max_i = i + i + 1 - max_i;
				sec_max = ar[sec_max_i];
			}
			if(ar[i+2] > max){
				sec_max = max;
				max_i = i+2;
				max = ar[max_i];
			}
			else if(ar[i+2] > sec_max){
				sec_max_i = i+2;
				sec_max = ar[sec_max_i];
			}
			System.out.println(max);
		}
	}
	public static int max(int a, int b, int c){
		// according to value of k
		// here k = 3

		if(a >= b && a >= c){
			return 0;
		}
		else if(b > c && b > a){
			return 1;
		}
		else{
			return 2;
		}
	}




    public static void printMaxInWindow(int a[],int k)
    {
        Deque<Integer> q=new LinkedList();
        int temp[]=new int[k];
        int N=a.length;
        q.addLast(a[0]);
        
        int i;
        for(i=1;i<k;i++)
        {
            if(q.getLast()<a[i] )
            {
                q.clear();
                q.addLast(a[i]);                
            }
            else  // incoming elment less than last element
            {
                if(q.getFirst()>a[i])
                {
                    //System.out.println("size = "+q.size());
                    if(q.size()==k)
                    {
                        q.removeLast();
                        q.addFirst(a[i]);
                    }
                    else
                    {
                       q.addFirst(a[i]);   
                    }
                }
                else
                {
                    q.removeFirst();
                    q.addFirst(a[i]);
                }
            }
           
        }
      // System.out.println(q.size());
        System.out.println(q.getLast());
        
        for(;i<N;i++)
        {
            //System.out.println("element = "+a[i]);
            if(q.getLast()<a[i])
            {
                q.clear();
                q.addLast(a[i]);                
                
               // System.out.println("If "+q.getLast());
            }
            else  // incoming elment less than last element
            {
                if(q.getFirst()>a[i])
                {
                    
                    if(q.size()==k)
                    {
                    
                        q.removeLast();
                        q.addFirst(a[i]);
                    }
                    else
                    {
                       q.addFirst(a[i]);   
                    }
                }
                else
                {
                    int j=0;
                    
                    //System.out.println("Check ");
                   while(true)
                   {
                       int e=q.removeFirst();
                       
                       if(e<a[i])
                       {
                           temp[j]=e;
                           j++;
                       }
                       else
                       {
                           q.addFirst(e);
                           break;
                       }
                   }
                   
                    q.addFirst(a[i]);
                    j--;
                    
                    while(j>=0)
                    {
                        q.addFirst(temp[j]);
                        
                        if(q.size()==k)
                        {
                            q.removeLast();
                        }
                        
                        j--;
                    }
                    
                }
           // System.out.println(q.getLast());
            }
           // System.out.println("Size = "+q.size());
             System.out.println(q.getLast());
            
        }
        
    }
}
