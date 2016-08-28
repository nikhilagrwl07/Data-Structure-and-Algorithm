
package uniquepartition;


public class UniquePartition {

    public static void main(String[] args) {
       int n=5;
       UniquePartitions(n);

    }
    
    public static void UniquePartitions(int n)
    {
        int p[]=new int[n]; // array to store partition
        int k=0; // index of last element in a partition
        
        p[k]=n; // initialize first partition as number itself
        
        // This loop first prints current partition , then 
        // generates next partition. This loop stop when current 
        // partition has all 1s
        
        while(true)
        {
            // print current partition
            printArray(p,k);
            
            // Generate the next partition
            // Find the rightmost non-one value in p[] 
            // Also update the rem_val so that we know how much value
            // can be accomodated
            int rem_val=0;
            
            while(k>=0 && p[k]==1)
            {
                rem_val+=p[k];
                        k--;
            }
          // If k<0 , all the values are 1 and there are no partitions
            if(k<0) return;
            
            // decrease the p[k] found above and adjust the rem_val
            p[k]--;
            rem_val++;
            
            // If rem_val is more , then the sorted order is violeted
            // Divide rem_val in different values of size p[k] & copy
            // these values ar different position after p[k]
            while(rem_val>p[k])
            {
                p[k+1]=p[k];
                rem_val=rem_val-p[k];
                k++;
            }
            
            // copy rem_val to next partition & increment position
            p[k+1]=rem_val;
            k++;
        }
        
    }
    
    public static void printArray(int []p,int l)
    {
        for(int i=0;i<=l;i++)
        {
            System.out.print(p[i]+" ");
        }
        System.out.println();
    }
    
    
    
}
