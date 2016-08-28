
package suffixarraynaive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// Source: http://discuss.codechef.com/questions/21385/a-tutorial-on-suffix-arrays
public class SuffixArrayNaive {

    public static void main(String[] args) throws IOException {
        
          System.out.println("Enter the string.");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
       String s1= br.readLine();       
       
       int N=s1.length();
       
        
       // Hashtable  for storing all substring of the array
       HashMap<String,Integer> ht=new HashMap<String,Integer>();
        
       Vector<String> vec = new Vector(N);
      
       
       for(int i=0;i<N;i++)
       {         
        ht.put(s1.substring(i, N), i);
         vec.add(s1.substring(i, N));//  add(s1.substring(i, N), i); 
         
       }
      
       Collections.sort(vec);
       //Store entry (Key/Value)of HashMap in set
             //   Set mapSet = (Set) ht.entrySet();

               //Create iterator on Set 
               // Iterator mapIterator = mapSet.iterator();
                //System.out.println("Display the key/value of HashMap.");
 
//      while (mapIterator.hasNext()) {
//                        Map.Entry mapEntry = (Map.Entry) mapIterator.next();
//                        // getKey Method of HashMap access a key of map
//                        String keyValue = (String) mapEntry.getKey();
//                        //getValue method returns corresponding key's value
//                        int value = (Integer) mapEntry.getValue();
//                        System.out.println(keyValue + " : " + value);
//                }

    for(int i = 0; i < vec.size();i++)
    {
        String keyValue=vec.get(i);
        int c=ht.get(keyValue);        
         //if(mapSet.contains(vec.get(i)))
           System.out.println(c+" "+keyValue);
    }
       
    }
}

