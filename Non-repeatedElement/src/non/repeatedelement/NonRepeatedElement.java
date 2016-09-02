/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package non.repeatedelement;

/**
 *
 * @author N1K$$
 */
public class NonRepeatedElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s="abzddab";
        
        nonRepeatedElement(s);
    }
    
    // limitation is that it supports only 256 character handset
    public static void nonRepeatedElement(String s)
    {
        char c[]=s.toCharArray();
        int i;
        // auxillary array of 256 characters
        int ch[]=new int[256];
        
        for(i=0;i<ch.length;i++) ch[i]=0;
        
        for(i=0;i<c.length;i++) 
            ch[c[i]]++;
        
        for(i=0;i<c.length;i++)
        {
            // System.out.println(ch[c[i]]);
            if(ch[c[i]]==1)
            {
                System.out.println("First non-repeating character="+c[i]);
               break;
            }
            else
            {
              System.out.println("First repeating character="+c[i]);   
              break;
            }
        }
    }
}
