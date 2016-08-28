

package Codeforces_pratice;

import java.io.*;
import java.util.*;

public class C317D
{

private static StringTokenizer st;

    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }

    public static String next()
    {
        return st.nextToken();
    }

    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }

    static long[] arr;
    static int rem, quot, n, k;
    static long[][] dp;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        n = nextInt();
        k = nextInt();
        arr = new long[n];
        nextLine(br);
        for (int i = 0; i < n; i++)
        {
            arr[i] = nextLong();
        }
        Arrays.sort(arr);
        rem = n % k;
        quot = n / k;
        dp = new long[k+1][];
        // let dp[i][j] be the min cost of maintaining j quot+1 sized and i-j quot sized chains
        // after i chains are counted

        for (int i = 0; i < k+1; i++)
        {
            dp[i] = new long[i+1];
        }

        for (int i = 0; i < k+1; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        find(k, rem);
        /*
        for (int i = 0; i < k+1; i++)
        {
            System.out.println(Arrays.toString(dp[i]));
        }
        */

        System.out.println(dp[k][rem]);
    }

    public static long find(int t, int l)
    {
        if (t == 0) return 0;
        if (dp[t][l] != -1) return dp[t][l];

        long ans = Long.MAX_VALUE;
        int pos = t * quot + l;
        if (l > 0)
        {
            long cost = arr[pos-1] - arr[pos-quot-1];
            ans = cost + find(t-1, l-1);
        }
        if (l != t)
        {
            long cost = arr[pos- 1] - arr[pos-quot];
            ans = Math.min(ans, cost + find(t-1, l));
        }
        dp[t][l] = ans;
        return ans;
    }

}


