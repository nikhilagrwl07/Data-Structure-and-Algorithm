/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package substringsofastring;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author nikhil.agrawal
 */
public class Allsubstringsofastring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to print it's all substrings");
        string = in.nextLine();

        System.out.println("Substrings of \"" + string + "\" are :- ");
        
        int x = numberdssNaive(string);
//        int y = numberdssUsingDp(string);
        System.out.println(" x = " + x);

    
    }
    public static int numberdssNaive(String str) {
        HashSet<String> set = new HashSet<String>();
        int i, c, length;
        String sub;
        length = str.length();
//        int count = 0;
        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
//                System.out.println("c = " + c + " c+i = " + (c + i));
                sub = str.substring(c, c + i);
                if (!set.contains(sub)) {
//                    count++;
                    System.out.println(sub);
                    set.add(sub);

                }

            }
        }
        return set.size();
    }
    
    

    public static int numberdssUsingDp(String str) {
        HashSet<String> all = new HashSet<String>();
        HashSet<StringBuilder> last = new HashSet<StringBuilder>();

        for (int i = 0; i < str.length(); i++) 
        {
            for (StringBuilder sb : last) 
            {
                sb.append(str.charAt(i));
                
                if (!all.contains(sb.toString())) 
                {
                    all.add(sb.toString());
                }
            }
            
            if (!all.contains(str.charAt(i) + ""))
            {
                all.add(str.charAt(i) + "");
            }
            
            last.add(new StringBuilder(str.charAt(i) + ""));
        }
        return all.size();
    }
}



