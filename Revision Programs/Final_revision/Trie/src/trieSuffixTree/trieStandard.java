/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trieSuffixTree;

import trie.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

  class SuffixTrieNode{
    
    public static final int number=256;
    
    public SuffixTrieNode children [];
    public List<Integer> indexes;

    public SuffixTrieNode() {
        children=new SuffixTrieNode[number];
        indexes=new LinkedList<Integer>();
        for(int i=0;i<number;i++)
        {
            children[i]=null;
        }
    }
    
    public void insertSuffix(String s , int i)
    {
        System.out.println(" s= "+s);
      indexes.add(new Integer(i));
      
       // If string has more characters
    if (s.length() > 0)
    {
        // Find the first character
        char cIndex = s.charAt(0); 
 
        // If there is no edge for this character, add a new edge
        if (children[cIndex] == null)
        {
            children[cIndex] = new SuffixTrieNode();
        }
 
        // Recur for next suffix
       // System.out.println("i = " + i  + " subtring :: " + s.substring(1));
        children[cIndex].insertSuffix(s.substring(1), i+1);
    } 
   
    }
    
    public List<Integer> search(String s)
    {
        if (s.length() == 0)
        return indexes;
 
    // if there is an edge from the current node of suffix trie,
    // follow the edge.
    if (children[s.charAt(0)] != null)
    {
         return children[s.charAt(0)].search(s.substring(1)); 
    }
    
    // If there is no edge, pattern doesn’t exist in text
    else 
        return null;
    }
  
}

class SuffixTrie
{
    public SuffixTrieNode root;
    public SuffixTrie(String txt)
    {
        root = new SuffixTrieNode();
        
        for(int i=0;i<txt.length();i++)
        {
            root.insertSuffix(txt.substring(i),i);
        }
    }
  
    /* Prints all occurrences of pat in the Suffix Trie S (built for text)*/
   
public  void searchPat(String pat)
{
    // Let us call recursive search function for root of Trie.
    // We get a list of all indexes (where pat is present in text) in
    // variable 'result'
    List<Integer> result = root.search(pat);
 
    // Check if the list of indexes is empty or not
    if (result == null)
        System.out.println("Pattern not found");
    else
    {
        int patLen = pat.length();
        for(Integer i : result)
        {
            System.out.println("Pattern found at position " + (i - patLen));
            
        }
       
    }
}
 
}

public class trieStandard {

    public static void main(String[] args) {
        String txt = "geeksforgeeks.org";
        SuffixTrie st = new SuffixTrie(txt);
        st.searchPat("ee");
    }

}



