
package repeatedelementhashing;
import java.util.Hashtable;
public class RepeatedElementHashing {

    public static void main(String[] args) {
       // char[] str={'n', 'i' ,'k','h','i', 'e'};
       // System.out.println(str[5]);
        String str1="nikhil";
       char str[]=str1.toCharArray();
        Hashtable h=new Hashtable();
        int cur=0,last=0,g=0;
        h.put(str[g],'u');
         h.put(str[g+1],'n');
          h.put(str[g+2],'i');
           h.put(str[g+3],'o');
            h.put(str[g+4],'a');
            
        for(;cur<str.length;cur++)
        {
           
            if(!h.containsValue(str[cur]))            //HashSearch(h,str[cur]))
          //  if(!h.containsValue(str[cur]))
            {
                str[last++]=str[cur];
                
             //   h.put(str[cur], 'i');
               
            }
        }
      
       int k=0;
        while(k<last)
        {
            System.out.print(str[k]);
           // int s=(int) h.get(k);
          //  System.out.println(s);
            k++;
         }
}
}