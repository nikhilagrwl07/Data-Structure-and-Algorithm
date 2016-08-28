
package Codeforces_pratice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C572A {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedOutputStream bos = new BufferedOutputStream(System.out);
       String eol = System.getProperty("line.separator");
       byte [] eolb = eol.getBytes();


            String input[]= br.readLine().split(" ");

            int nA= Integer.parseInt(input[0]);
            int nB= Integer.parseInt(input[1]);

            String input1[]= br.readLine().split(" ");
            int k= Integer.parseInt(input1[0]);
            int m= Integer.parseInt(input1[1]);

            String input2[]= br.readLine().split(" ");
            int A[]=new int[input2.length];
            for(int i=0;i<input2.length;i++)
            {
                A[i]=Integer.parseInt(input2[i]);
            }
            
            String input3[]= br.readLine().split(" ");
            int B[]=new int[input3.length];
            for(int i=0;i<input3.length;i++)
            {
                B[i]=Integer.parseInt(input3[i]);
            }

            if(A[k-1]<B[nB-m])
            {
               // System.out.println("Yes");
                bos.write("YES".getBytes());
            }
            else
            {
                bos.write("NO".getBytes());
              //  System.out.println("No");
            }


        bos.flush();
    }


}
