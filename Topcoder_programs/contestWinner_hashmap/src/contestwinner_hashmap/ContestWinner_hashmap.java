/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contestwinner_hashmap;

/**
 *
 * @author nikhil
 */
import java.util.*;
public class ContestWinner_hashmap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int events[]={3,4,3,3,5,5};
        System.out.println(getWinner(events));
        
    }
    
     public static int getWinner(int[] events)
    {
        int i;
        HashMap hm = new HashMap();
        int currentleader=-1;
        int maxsolve=0;
        int len=events.length;

// mapping each event array element to member of Hashmap

        for(i=0;i<len;i++)
        {
            if(hm.containsKey(events[i])==false)    // if the contest number is NOT present (first time)
	    {
		hm.put(new Integer(events[i]),new Integer(1));
	    }	   
            else
	    {
		int freq=((Integer)hm.get(events[i])); //(other than first time)
		hm.put(events[i],new Integer(freq+1));
	    }
            
          /*  if(solved[events[i]] > maxsolve)
            {
                maxsolve=solved[events[i]];
                currentleader=events[i];
            }*/
            
        }
        
         //Get a set of entries
        Set set=hm.entrySet();
        
        //Get an iterator
        Iterator it=set.iterator();
        
        //Display elements
        while(it.hasNext())
        {
            Map.Entry me=(Map.Entry)it.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
          //System.out.println("NULL value can be implemented ");
        }
        return currentleader;
    }
     
}
