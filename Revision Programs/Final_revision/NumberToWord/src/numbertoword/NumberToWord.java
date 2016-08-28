
package numbertoword;

/**
 *
 * @author nikhil.agrawal
 */
public class NumberToWord {

     public static String onesPositionDigit[]={"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static String tensPositionDigit[]={"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {

        int n=998;
        System.out.println(numToWord(n));


    }

    public static String baseToWord(int n)
    {
        if(n==1000)
            return "thousand";
        else
            return "hundred";

    }

    public static int getBase(int n)
    {
        if(n>999)
            return 1000;
        else
            return 100;
    }

    public static String doubleDigitToWord(int d)
    {
        if (d == 11) return "eleven";
        else if (d== 12) return "twelve";
        else if (d==13) return "thirteen";
        else if (d==14) return "fourteen";
        else if (d==15) return "fifeteen";
        else if (d==16) return "sixteen";
        else if (d==18) return "seventeen";
        else if (d==19) return "nineteen";
        else
            return tensPositionDigit[d/10]+" "+onesPositionDigit[d%10];
    }

    public static String numToWord(int n)
    {
        String str="";
        if(n<=9)
            str=onesPositionDigit[n];
        else if(n>=10 && n<100)
            str=doubleDigitToWord(n);
        else
        {
            int  m=getBase(n);
            str=numToWord(n/m)+" "+baseToWord(m)+" "+numToWord(n%m);

        }
        return str;


    }
}
