
package repeatedcharhash;

public class RepeatedCharHash {

    public static void main(String[] args) {
        int i=0;
        String str="anoop";
        char ch[]=str.toCharArray();
        //char c=str[0];
        int count[]=new int[256];  // creating array for all possible alphabets
        for(i=0;i<256;i++)     // O(n) time complexity
        {
            count[i]=0;
        }
        for(i=0;i<str.length();i++)
        {
            int a=ch[i];
            if(count[a]==1)
            {
                System.out.println("Repeated element:"+ch[i]);
                break;
            }
            else
                count[ch[i]]=1;
        }
        
    }
}
