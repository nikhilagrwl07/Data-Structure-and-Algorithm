
package removeduplicates;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

    
    public static void main(String[] args) {
      
        String str="Nikhil AGrawal is a good boy";
        char[] ch=str.toCharArray();
        LinkedHashSet lhs=new LinkedHashSet();
        int i=0;
        
        while(i<ch.length)
        {
            lhs.add(ch[i]);
            i++;
        }
        
        Iterator itr=lhs.iterator();
        
        while(itr.hasNext())
            System.out.print(itr.next()+"  ");
    }
}
