
package longestconsecutivesubsequence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
     public static int longestConsecutive(final List<Integer> a) {
        
        
        Integer[] num = a.toArray(new Integer[a.size()]);
	// if array is empty, return 0
	if (num.length == 0) {
		return 0;
	}
 
	Set<Integer> set = new HashSet<Integer>();
	int max = 1;
 
	for (int e : num)
		set.add(e);
 
	for (int e : num) {
		int left = e - 1;
		int right = e + 1;
		int count = 1;
 
		while (set.contains(left)) {
			count++;
			set.remove(left);
			left--;
		}
 
		while (set.contains(right)) {
			count++;
			set.remove(right);
			right++;
		}
 
		max = Math.max(count, max);
	}
 
	return max;
}


}
