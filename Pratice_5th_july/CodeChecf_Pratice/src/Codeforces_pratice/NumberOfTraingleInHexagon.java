
package Codeforces_pratice;
import java.util.Scanner;


public class NumberOfTraingleInHexagon {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a,b,c,d,e,f;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sc.nextInt();
        e = sc.nextInt();
        sc.nextInt();

        System.out.println((int)(Math.pow((a + b + c),2)-Math.pow(a,2)-Math.pow(c,2)-Math.pow(e,2)));
    }
}
