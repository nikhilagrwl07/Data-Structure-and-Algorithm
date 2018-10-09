
package stringalgorithm;

import java.util.HashMap;

class TrieNode
{
    private char value;
    private HashMap<Character,TrieNode> children=null;
    private boolean bIsEnd;
    
    public TrieNode(char ch)
    {
        value=ch;
        children = new HashMap<>();
        bIsEnd=false;
    }
    
    public HashMap<Character,TrieNode> getChildren()
    {
        return children;
    }
    
    public void setChildrenNULL()
    {
        children=null;
    }
    
    public void setIsEnd(boolean val)
    {
        this.bIsEnd=val;
    }
    
    public boolean IsEnd()
    {
        return bIsEnd;
    }
}

// implement the actual Trie
class Trie
{
    private TrieNode root;
    
    public Trie()
    {
        root= new TrieNode((char)0);
    }
    
    public void insert(String word)
    {
        // length of given word
        int len=word.length();
        TrieNode crawl=root;
        
        // traverse through all character of the given word
        
        for(int level=0;level<len;level++)
        {
            HashMap<Character,TrieNode> child= crawl.getChildren();
            char ch=word.charAt(level);
            
              // If there is already a child for current character of given word 
            if(child.containsKey(ch))
            {
                crawl =child.get(ch);
            }
            else // create a child
            {
                TrieNode temp=new TrieNode(ch);
                child.put(ch, temp);
                crawl=temp;
            }
        }
        // set bisEnd true for last character 
        crawl.setIsEnd(true);
        
    }
    
   // the main method which finds out the longest string 'input'
    public String getMatchingPrefix(String input)
    {
        String result=""; // Initialize the resultant string
        int length=input.length();
        
        // Initialize the reference to traverse the trie
        TrieNode crawl=root;
        
        // Iterate through all the characters of the input string and traverse 
        // down the trie
        
        int level, prevMatch=0;
        
        for(level=0;level<length;level++)
        {
            // find the current character of str
            char ch=input.charAt(level);
                        
            HashMap<Character,TrieNode> child=crawl.getChildren();
            
            if(child.containsKey(ch))
            {
                // move down the trie
                result +=ch;
                // update the crawl
                crawl=child.get(ch);
                
                // If this is the end of a word , then update prevMatch
                if(crawl.IsEnd())
                {
                    prevMatch=level+1;
                }
            }
            else
                break;
        }
        
        // If the last character of input string does not match with any 
        // of the word the dictionary , then return the last matched word
        if(crawl.IsEnd()==false)
        {
            return input.substring(0, prevMatch);
        }
        else
        {
            return result;
        }
    }
    
    public  void Delete(String key)
    {
        int prevMatch=0;
        // if key is null , return without  modifying the trie
        if(key.length()==0) return ;
        
          TrieNode crawl=root; // for reference of the node
          int N=key.length(),level=0;
          
          // start searching the node in trie
          for(level=0;level<N;level++)
          {
            //  System.out.print(" level = "+level);
              char ch=key.charAt(level);
              
             HashMap<Character,TrieNode> child=crawl.getChildren();
             
                         
             if(child.containsKey(ch)) // means the trie contains the particular character
             {        
               //  System.out.println(" Charcter ="+ch);
                      crawl=child.get(ch);
               //  System.out.println(" crawl.IsEnd() "+ crawl.IsEnd());
                 
            // If this is the end of a word , then update prevMatch
                if(crawl.IsEnd() && level<N-1)
                {
                    prevMatch=level+1;
                }
             }
             else
             {
              //  System.out.println(" crawl.IsEnd() "+ crawl.IsEnd());
                 break;
             }
             
          }
         
          
         // Case 1: element is NOT found in trie
          if(crawl.IsEnd()==false || level<N)
          {
              System.out.println(key +" is NOT found");
          }
          else
          {
              // Case 2: Key present as unique key in trie
              if( prevMatch==0&& crawl.getChildren().isEmpty())
              {
                  TrieNode crawlNode2=root;
                  char ch2=key.charAt(0);
                  HashMap<Character,TrieNode> child2= crawlNode2.getChildren();
                  child2.remove(ch2);
                  
                  System.out.println("Case 2");
              }
              // Case 3: Key is prefix key of another key
              else if(prevMatch==0 && !crawl.getChildren().isEmpty())
              {
                  crawl.setIsEnd(false);
               System.out.println("Case 3");
              }
              // Case 4: key is postfix of another key
              else if(prevMatch!=0 && crawl.getChildren().isEmpty())
              {
                  TrieNode temp=root;
                  
                  for(int i=0;i<prevMatch;i++)
                  {
                      char ch=key.charAt(i);
                         HashMap<Character,TrieNode> child3= temp.getChildren();
                         temp=child3.get(ch);
                         
                  }
             
                  temp.setChildrenNULL();
                  
                  System.out.println("Case 4");
              }
              
            System.out.println(key +" successfully deleted");
           // System.out.println(" crawl.getChildren() "+ (crawl.getChildren().isEmpty()));
            
          }
      
          
          
    }
}

public class LongestPrefixMatching {

    public static void main(String[] args) {
        Trie dict= new Trie();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");       
        dict.insert("basement");
          dict.insert("pick");
        
        String input="caterer";
        System.out.print(input+":  ");
        System.out.println(dict.getMatchingPrefix(input));
        
         input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input)); 
        
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));             
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));             
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                     
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));    
        
        String del="cate";
        System.out.print(del + ":   ");
//      /  dict.Delete(del);
        System.out.println(dict.getMatchingPrefix(del));
        
//        input = "pick";
//        System.out.print(input + ":   ");
//        System.out.println(dict.getMatchingPrefix(input)); 
    }
}
