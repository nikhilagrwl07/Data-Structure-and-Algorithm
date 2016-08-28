
package Codeforces_pratice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class EqualString {

    public static void main(String[] args) throws IOException {

//        String original = "edcba";
//        char[] chars = original.toCharArray();
//        Arrays.sort(chars);
//        original = new String(chars);
//        System.out.println(original);

//
//        String a1 = s1.substring(0,s1.length()/2);
//            String b1 = s1.substring((s1.length()/2),s1.length());
//             System.out.println(s1.length()+ " :: "+ b1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedOutputStream bos = new BufferedOutputStream(System.out);
       String eol = System.getProperty("line.separator");
       byte [] eolb = eol.getBytes();
        String str1  = br.readLine();
        String str2  = br.readLine();

        if(isequivalent(str1, str2))
            bos.write("YES".getBytes());
        else
            bos.write("NO".getBytes());

        bos.flush();
        
    }

    public static boolean isequivalent(String s1 , String s2){
       if(s1.equals(s2)){
            return true;
        }
        else
        {
          //  System.out.println(s1+ "    "+ s2);
            char[] a1 = s1.substring(0,s1.length()/2).toCharArray();
            char[] a2 = s1.substring(s1.length()/2,s1.length()).toCharArray();

            char[] b1 = s2.substring(0,s2.length()/2).toCharArray();
            char[] b2 = s2.substring(s2.length()/2,s2.length()).toCharArray();


            Arrays.sort(a1);
            String A1= new String(a1);

            Arrays.sort(b1);
            String B1 = new String(b1);

            Arrays.sort(a2);
            String A2= new String(a2);

            Arrays.sort(b2);
            String B2= new String(b2);

         //   System.out.println(A1+ "    "+ A2 + "   "+ B1+ "    "+ B2);
        //    return ((Arrays.equals(a1, b1) && Arrays.equals(a2, b2)) || (Arrays.equals(a1, b2) && Arrays.equals(a2, b1)));
            return ((A1.equals(B1) && A2.equals(B2)) || (A1.equals(B2) && A2.equals(B1)));
            //System.out.println(a1+ "    "+ b1 + "   "+ a2+ "    "+ b2);
            //return ((isequivalent(a1, b1) && isequivalent(a2, b2)) || (isequivalent(a1, b2) && isequivalent(a2, b1))) ;

        }


    }
}
