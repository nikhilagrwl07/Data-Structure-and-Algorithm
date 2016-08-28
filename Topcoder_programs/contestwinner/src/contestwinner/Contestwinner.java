/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contestwinner;

/**
 *
 * @author nikhil
 */
import java.io.*;
import java.util.*;

public class Contestwinner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
         int events[]={123,123,456,456,456,123};
        System.out.println(getWinner(events));
    }

     public static int getWinner(int[] events)
    {
        int i;
        HashMap hm = new HashMap();
        Set set = hm.entrySet();
        Iterator k = set.iterator(); 
          Iterator p = set.iterator(); 
           Map.Entry me = (Map.Entry)k.next();
           Map.Entry me2 = (Map.Entry)p.next();
        int currentleader=-1;
        int maxsolve=0;
        
        int len=events.length;
        int x=0;
          // mapping each event array element to member of Hashmap

        for(i=0;i<len;i++)
        {
            if(hm.containsKey(events[i])==false)
	    {
		hm.put(new Integer(events[i]), new Integer(1));  // (object,object)
            }
	   
            else
	    {
                
                while(k.hasNext()) 
                {
                    if((int) me.getKey() == events[i])
                    {
                         int bal=(int) me.getValue();
               hm.put(events[i], new Integer(bal+1));
                    }
                } 
              
                              
	    }       
            
          
                while(p.hasNext()) 
                {
                    if((int) me2.getValue() > 0)
                    {
                        currentleader=events[i];
                    
                    }
                } 
        
                   
        }
        
          return currentleader;
    }
}
