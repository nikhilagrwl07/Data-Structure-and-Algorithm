

package HackerEarth_22July_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestClass {
     public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String givenString = br.readLine();
        kUniques(givenString, N);
    }
     
     
 public static int isValid(int count[], int k)
    {
    int val = 0;
    for (int i=0; i<26; i++)
        if (count[i] > 0)
            val++;
 
    if(k>val)
    {
        return 1;
    }
    else if(k==val)
    {
        return 0;
    }
    else
        return -1;
    
}
 
// Finds the maximum substring with exactly k unique chars
   static void kUniques(String str, int k)
{
    int u = 0; // number of unique characters
    int n = str.length();
 
    char[] s = str.toCharArray();
    // Associative array to store the count of characters
    int count[] = new int[26];
    int countAfter[] = new int[26];
    int finalAnswer =0 ;
    // Traverse the string, Fills the associative array
    // count[] and count number of unique characters
    for (int i=0; i<n; i++)
    {
        if (count[s[i]-'a']==0)
            u++;
        count[s[i]-'a']++;
    }
 
    // If there are not enough unique characters, show
    // an error message.
    if (u < k)
    {
        System.out.println(finalAnswer);
        return;
    }
 
    // Otherwise take a window with first element in it.
    // start and end variables.
    int curr_start = 0, curr_end = 0;
 
    // Also initialize values for result longest window
//    int max_window_size = 1, max_window_start = 0;
 
    countAfter[s[0]-'a']++;  // put the first character
    
    // Start from the second character and add
    // characters in window according to above
    // explanation
    for (int i=1; i<n; i++)
    {
        // Add the character 's[i]' to current window
        countAfter[s[i]-'a']++;
        curr_end++;
 
        // If there are more than k unique characters in
        // current window, remove from left side
        while (true)
        {
            int ans = isValid(countAfter, k);
            if(ans>=0){
            System.out.println("curr_start... " + curr_start);
            countAfter[s[curr_start]-'a']--;
            curr_start++;
                if(ans==0)
                {
                    finalAnswer++;
                }
            
            }
            else
                break;
        }
        System.out.println(finalAnswer);
        
    }
    }

}
