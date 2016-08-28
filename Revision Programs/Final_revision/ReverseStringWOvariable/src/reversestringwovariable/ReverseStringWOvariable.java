
package reversestringwovariable;


public class ReverseStringWOvariable {

   
    public static void main(String[] args) {
        
        String str="Nikhil Agrawal";
        System.out.println(" String = "+str);
        // reversing the string using XOR opration
        char[] s=str.toCharArray();
      
        int start=0;
        int end=s.length-1;
        
        while(start<end)
        {
          //  System.out.println("Check");
            s[start]=(char) (s[start]^s[end]);
            s[end]=(char) (s[end]^s[start]);
            s[start]=(char) (s[start]^s[end]);
            
            start++;
            end--;
        }
        
        for(int i=0;i<str.length();i++)
        {
            System.out.print(s[i]);
        }
        
        
    }
}
