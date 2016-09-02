/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package optimalsubstringreversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 private static int totalcases;
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
    
     public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            nextLine(br);
            
            int cases = nextInt();
            ArrayList<Integer> arr= new ArrayList();
            
            for(int i=1;i<=cases;i++)
            {
              nextLine(br);
               String s = st.nextToken();
             int a[] = findLexographicalUtil(s.toCharArray());
             arr.add(a[0]);
             arr.add(a[1]);
          
//          System.out.println(a[0]+","+a[1]); 
            }
            
            for(int i=0;i<=arr.size()-2;i=i+2)
            {
                System.out.println(arr.get(i) + ","+arr.get(i+1));
            }
            

        } catch (IOException ex) {
        }
        
    }
     
     
      private static int[] findLexographicalUtil(char[] s) {
        int a[] = new int[2];
        int startIndex = -1;
        int prevCount = 0;
        int endIndex = 0;
        int lCount = 0;
        char c;
        for (int i = 0; i < s.length; i++) {
            c = s[i];
            if (c == 'b' && startIndex == -1) {
                startIndex = i;
            }
            if (c == 'a' && startIndex != -1) {
                lCount++;
                if (lCount >= prevCount) {
                    endIndex = i;
                }
            }
            if (c == 'b' && lCount >= prevCount) {
                prevCount = lCount;
                lCount = 0;
            }
        }
        if(startIndex == -1) {
            startIndex = 0;
            endIndex = 0;
        }
        
        a[0] = startIndex;
        a[1] = endIndex;
        return a;
    }
     
     
}