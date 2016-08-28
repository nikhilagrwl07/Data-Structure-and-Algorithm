package nikhil.palindrome.work;

public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String longestPalindromeDP(String s)
	{
		 int n = s.length();
		  int longestBegin = 0;
		  int maxLen = 1;
		  boolean table[1000][1000] = {(boolean) false};
		  for (int i = 0; i < n; i++) {
		    table[i][i] = true;
		  }
		  for (int i = 0; i < n-1; i++) {
		    if (s[i] == s[i+1]) {
		      table[i][i+1] = true;
		      longestBegin = i;
		      maxLen = 2;
		    }
		  }
		  for (int len = 3; len <= n; len++) {
		    for (int i = 0; i < n-len+1; i++) {
		      int j = i+len-1;
		      if (s[i] == s[j] && table[i+1][j-1]) {
		        table[i][j] = true;
		        longestBegin = i;
		        maxLen = len;
		      }
		    }
		  }
		  return s.substr(longestBegin, maxLen);
	}
}


