
package Codeforces_pratice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Division1A577 {

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
    public static void main(String[] args) throws IOException {
        int n , k ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        n = nextInt();
        k = nextInt();
       // System.out.println(k + "k = ");
        int count =0 ;

        for(int i=1;i<=n;i++){
            int s = k/i;
            if(s<=n && s*i == k){
              //  System.out.println(i + " "+ s);
                count++;
            }
        }
       // System.out.println(count + "count");
      //  BufferedOutputStream bos = new BufferedOutputStream(System.out);
       BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(System.out));
        bos.write(count+"\n"); //    write(String.valueOf(count));
        bos.flush();
    }

}
