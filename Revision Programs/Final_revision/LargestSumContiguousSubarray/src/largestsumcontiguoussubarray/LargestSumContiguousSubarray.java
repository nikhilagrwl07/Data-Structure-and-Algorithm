package largestsumcontiguoussubarray;

public class LargestSumContiguousSubarray {

    public static void main(String[] args) {
        int a[] = {6, -3, -10, 0, 2};

        int max_sum = maxSubArraySumUsingKadanceAlgo(a);
        System.out.println("Maximum contiguous sum is  " + max_sum);
//
//        int max_sumDP = maxSubArraySumDP(a);
//        System.out.println("Maximum contiguous sum is using DP  " + max_sumDP);
//        
        
//        int max_product_dp = maxSubArrayProductDP(a);
//        System.out.println("Maximum Product Subarray is using DP  " + max_product_dp);
        

    }

    static int maxSubArraySumUsingKadanceAlgo(int a[]) {
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < a.length; i++) {
            max_ending_here = max_ending_here + a[i];

            if (max_ending_here < 0) {
                max_ending_here = 0;
            } /* Do not compare for all elements. Compare only   
            when  max_ending_here > 0 */ else if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
        }
        return max_so_far;
    }

    // DP approach
    static int maxSubArraySumDP(int a[]) {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    
      static int maxSubArrayProductDP(int a[]) {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++) {
            curr_max = Math.max(a[i], curr_max * a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    
}
