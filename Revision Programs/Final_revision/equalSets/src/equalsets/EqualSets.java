
package equalsets;
import java.util.HashMap;

public class EqualSets {

    public static void main(String[] args) {
     int a[]={2,5,6,8,10,2,2};
     int b[]={2,5,2,8,10,2,6};
       
     HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
     
     int i=0,j=0;
     
     while(i<a.length)
     {
         int key=a[i];
         
         Integer freq=hm.get(key);
         
         if(freq==null)
             freq=1;
         else
             freq++;
         
         hm.put(key, freq);
         
         i++;
     }
     --i;
     
     System.out.println(hm);
 
     int flag=0;
   
      while(j<b.length)
     {
         int key1=b[j];
         
         Integer freq=hm.get(key1);
         
         if(freq==null || freq==0)
         {
             System.out.println("NOT equal sets");
             flag=1;
             break;
         }
         
         else
         {
             hm.put(key1, --freq);
           
         }
        
       ++j;
     }
    
      if(flag==0)
     System.out.println("Equal sets");
     
    }
}
