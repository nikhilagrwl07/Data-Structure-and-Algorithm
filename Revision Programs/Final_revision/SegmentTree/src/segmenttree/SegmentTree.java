//http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/

package segmenttree;
import java.math.*;

public class SegmentTree {

    public static void main(String[] args) {
       
         int arr[] = {1, 3, 5, 7, 9, 11};
         
         // Build segment tree from given array
         int st[]=constructST(arr,arr.length);
         // Print sum of values in array from index 1 to 3
    System.out.println("Sum of values in given range ="+ getSum(st, arr.length, 2, 4));
         
     // Update: set arr[1] = 10 and update corresponding segment
    // tree nodes
    updateValue(arr, st, arr.length, 1, 10);
    // Find sum after the value is updated
  System.out.println("Updated sum of values in given range ="+getSum(st, arr.length, 1, 3));
     
    }
    
    //Function to construct segment tree from given array.
    public static int[] constructST(int arr[],int n)
    {
      double x=Math.log10(n)/0.301029;
        
       int height=(int)x +1;
       
       double max_size_d=2*Math.pow(2, height) -1;  // This is total number of nodes
        int total_nodes=(int) max_size_d;
       
   int st[]=new int[total_nodes];
   
   // fill the allocated memory st
    constructSTUtil(arr, 0, n-1, st, 0);
    
     // Return the constructed segment tree
    return st;
    }
    
    // A recursive function that constructs Segment Tree for array[ss..se].
// si is index of current node in segment tree st
    public static int constructSTUtil(int arr[], int ss, int se, int st[], int si)
    {
         // If there is one element in array, store it in current node of
    // segment tree and return
    if (ss == se)
    {
        st[si] = arr[ss];
        return arr[ss];
    }
     // If there are more than one elements, then recur for left and
    // right subtrees and store the sum of values in this node
    int mid = getMid(ss, se);
    st[si] =  constructSTUtil(arr, ss, mid, st, si*2+1) +
              constructSTUtil(arr, mid+1, se, st, si*2+2);
    return st[si];    
        
    }
    
    // A utility function to get the middle index from corner indexes.
public static int getMid(int s, int e) 
{   
    return s + (e -s)/2; 
}

// Return sum of elements in range from index qs (quey start) to
// qe (query end).  It mainly uses getSumUtil()
public static int getSum(int st[], int n, int qs, int qe)
{
    // Check for erroneous input values
    if (qs < 0 || qe > n-1 || qs > qe)
    {
        System.out.println("Invalid Input");
        return -1;
    }
 
    return getSumUtil(st, 0, n-1, qs, qe, 0);
}


/*  A recursive function to get the sum of values in given range of the array.
    The following are parameters for this function.
 
    st    --> Pointer to segment tree
    index --> Index of current node in the segment tree. Initially 0 is
             passed as root is always at index 0
    ss & se  --> Starting and ending indexes of the segment represented by
                 current node, i.e., st[index]
    qs & qe  --> Starting and ending indexes of query range */
public static int getSumUtil(int[] st, int ss, int se, int qs, int qe, int index)
{
    // If segment of this node is a part of given range, then return the
    // sum of the segment
    if (qs <= ss && qe >= se)
        return st[index];
 
    // If segment of this node is outside the given range
    if (se < qs || ss > qe)
        return 0;
 
    // If a part of this segment overlaps with the given range
    int mid = getMid(ss, se);
    return getSumUtil(st, ss, mid, qs, qe, 2*index+1) +
           getSumUtil(st, mid+1, se, qs, qe, 2*index+2);
}



// The function to update a value in input array and segment tree.
// It uses updateValueUtil() to update the value in segment tree
public static void updateValue(int arr[], int st[], int n, int i, int new_val)
{
    // Check for erroneous input index
    if (i < 0 || i > n-1)
    {
        System.out.println("Invalid Input");
        return;
    }
 
    // Get the difference between new value and old value
    int diff = new_val - arr[i];
 
    // Update the value in array
    arr[i] = new_val;
 
    // Update the values of nodes in segment tree
    updateValueUtil(st, 0, n-1, i, diff, 0);
}



/* A recursive function to update the nodes which have the given index in
   their range. The following are parameters
    st, index, ss and se are same as getSumUtil()
    i    --> index of the element to be updated. This index is in input array.
   diff --> Value to be added to all nodes which have i in range */
public static void updateValueUtil(int st[], int ss, int se, int i, int diff, int index)
{
    // Base Case: If the input index lies outside the range of this segment
    if (i < ss || i > se)
        return;
 
    // If the input index is in range of this node, then update the value
    // of the node and its children
    st[index] = st[index] + diff;
    if (se != ss)
    {
        int mid = getMid(ss, se);
        updateValueUtil(st, 0, mid, i, diff, 2*index + 1);
        updateValueUtil(st, mid+1, se, i, diff, 2*index + 2);
    }
}



}
