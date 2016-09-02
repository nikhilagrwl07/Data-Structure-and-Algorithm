/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package allsubsequencesofstring;

/**
 *
 * @author nikhil.agrawal
 */
public class AllSubSequencesOfString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        String element="ABC";
       System.out.println("All possible subtring of a given string :: " + element);
        allSubSequencesOfString(element);
    }
    
    
     
 
 static void allSubSequencesOfString(String str){
  if(str != null && str.length()!=0)
   allSubSequencesOfStringUtil("",str);
 }
 
 static void allSubSequencesOfStringUtil(String prefix,String remaining){
  if(remaining.length() == 0)
  {
      System.out.println(prefix + " ");
  }
  else{
   allSubSequencesOfStringUtil(prefix + remaining.charAt(0),remaining.substring(1));
   allSubSequencesOfStringUtil(prefix,remaining.substring(1));
   
  }
 }
 
  // Case of Back Tracking: Complexity O(!n)
 private static void perm3(char[] c,int start,int end)
 {
     if(start==end)
         System.out.println(c);
     else
     {
     for(int j=start;j<=end;j++)
     {
         swap(c,start,j);
         
         perm3(c,start+1,end);
         
         swap(c,start,j);   // back track

     }
     }
 }
 
     private static void swap(char[] a, int i, int j) {
        char c;
        c = a[i]; a[i] = a[j]; a[j] = c;
    }


}
