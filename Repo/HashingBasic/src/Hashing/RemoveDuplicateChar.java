
package Hashing;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateChar {
    
    public static void main(String args[])
    {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(1, 3);
        hm.put(2, 6);
        hm.put(3, 5);
        hm.put(7, 4);
        hm.put(5, 3);
        hm.put(8, 7);
      printPalindromePair(hm);

//        char[] c="ergbdowqhjfrhgAJHVSKJQPOMNQERFNVjbvfvdfgborbvvbnn".toCharArray();
//
//        System.out.println("Original String :\n"+Arrays.toString(c) );
//
//        System.out.println("Array after removing duplicate charcters : " );
//        removeDuplicates(c);
    }
    
    public static void removeDuplicates(char[] c)
    {
        if(c.length==0 || c.length==1)
        {
            System.out.println(c);
            return;
        }
        
        int[] a=new int[26+26];
        
        for(int j=0;j<a.length;j++)
        {
            a[j]=0;
        }
        
        for(int i=0;i<c.length;i++)
        {
            int t;
            if(c[i]>=97 && c[i]<=122)
            {
                t=c[i]-97+26;
            }
            else 
            {
                t=c[i]-65;
            }
           
           // System.out.println(t);
            if(a[t]==0)
            {
                System.out.print(c[i]+" ");
                a[t]=1;
            }
            
        }
    }

    public static void printPalindromePair(HashMap<Integer,Integer> hm){

        if(hm == null || hm.size()==0){
            System.out.println("HashMap is null or empty");
            return;
        }

        if(hm.size()==1){
            System.out.println("Only one element in hashmap");
            return;
        }


       for(Map.Entry<Integer,Integer> e : hm.entrySet()){
           int key = e.getKey();
           int value = e.getValue();

  //System.out.println(key + " :: "+ value);
           if(hm.containsValue(key) && hm.containsKey(value)){
               System.out.println("Pair is present =  " + key+ " "+ value);
               hm.put(key, -1);
           }

       }

    }

}

