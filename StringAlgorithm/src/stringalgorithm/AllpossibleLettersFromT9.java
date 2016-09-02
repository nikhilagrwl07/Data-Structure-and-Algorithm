package stringalgorithm;

import java.io.*;

/**
 *
 * @author nikhil.agrawal
 */
public class AllpossibleLettersFromT9 {

    public static String a[][] = new String[][]{{}, {}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}, {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"}, {"T", "U", "V"}, {"W", "X", "Y", "Z"}};
    public static int n[],  l;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 2, j;
        String s[];
        s = br.readLine().split(" ");
        l = s.length - 1;
        n = new int[s.length];
        for (i = 0; i < s.length; i++) {
            n[i] = Integer.parseInt(s[i]);
        }
        
        process(0, "");


    }

    public static void process(int i, String s) {
//        System.out.println("i = " + i);
        if (i <= l) 
        {
            int len = a[n[i]].length - 1;
            
            for (int j = 0; j <= len; j++) {
                process(i + 1, s+a[n[i]][j]);
            }

        } 
        else {
            System.out.println(s);
        }
    }
}
