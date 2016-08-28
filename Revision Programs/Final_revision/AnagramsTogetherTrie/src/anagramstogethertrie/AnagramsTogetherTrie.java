
package anagramstogethertrie;

import java.util.Arrays;


class IndexNode
{
    int index;
    IndexNode next;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public IndexNode getNext() {
        return next;
    }

    public void setNext(IndexNode next) {
        this.next = next;
    }
  
}

class TrieNode
{
    int NO_OF_CHARS=26;
    
    private TrieNode children[]=new TrieNode[NO_OF_CHARS];
    private boolean bIsEnd;
    private IndexNode head;

    public int getNO_OF_CHARS() {
        return NO_OF_CHARS;
    }

    public void setNO_OF_CHARS(int NO_OF_CHARS) {
        this.NO_OF_CHARS = NO_OF_CHARS;
    }

    public boolean isbIsEnd() {
        return bIsEnd;
    }

    public void setbIsEnd(boolean bIsEnd) {
        this.bIsEnd = bIsEnd;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public IndexNode getHead() {
        return head;
    }

    public void setHead(IndexNode head) {
        this.head = head;
    } 
   
}



public class AnagramsTogetherTrie {

    public static final int NO_OF_CHARS=26;
     
      
    public static IndexNode newIndexNode(int index)
    {
        IndexNode temp=new IndexNode();
        temp.index=index;
        temp.next=null;
       return temp;        
    }
    
    public static TrieNode newTrieNode()
    {
        TrieNode temp=new TrieNode();
        temp.setbIsEnd(false);
        temp.setHead(null);
        
         for (int i = 0; i < NO_OF_CHARS; ++i)
               temp.getChildren()[i] = null;
         
        return temp;
    }
    
     static void insert(TrieNode root,char[] word,int index)
    {  
        // Base Case
        if(root==null)
        {
           root=newTrieNode();              
        }
        if(index<=word.length-1)
        {
            // System.out.println(word);
            System.out.println(word[index]);//+"  "+(word[index]-'a'));
            insert(root.getChildren()[index-'a'], word, index+1);
        }
        else // If end of string is reached
        {
             // Insert index of this word to end of index linked list
            if(root.isbIsEnd())
            {
                IndexNode pCrawl=root.getHead();
                while(pCrawl.next!=null)
                {
                    pCrawl=pCrawl.next;
                }
                pCrawl.next=newIndexNode(index);     //IndexNode(index);
                
            }
            else // If Index list is empty
            {
                root.setbIsEnd(true);
                root.setHead(newIndexNode(index));
            }
        }
    }
     
     // This function traverses the built trie. When a leaf node is reached,
// all words connected at that leaf node are anagrams. So it traverses
// the list at leaf node and uses stored index to print original words
     public static void printAnagramsUtil(TrieNode root,String[] wordArr)
     {
         if(root==null)
             return;
         
          // If a lead node is reached, print all anagrams using the indexes
    // stored in index linked list
         if(root.isbIsEnd())
         {
             // traverse the list
             IndexNode pCrawl=root.getHead();
            
             while(pCrawl!=null)
             {
                 System.out.println(wordArr[pCrawl.index]);
                 pCrawl=pCrawl.next;
                 
             }
         }
         
          for (int i = 0; i < NO_OF_CHARS; ++i)
            printAnagramsUtil(root.getChildren()[i], wordArr);
     }
    
    
    // The main function thats prints all anagrams together
    public static void printAnagramsTogether(String[] wordArr)
    {
        
    //   System.out.println(wordArr.length);
        
        // Create an empty trie
        TrieNode root=null;
        
        // Iterate through all input words
        for(int i=0;i<wordArr.length;i++)
        {
              // Create a buffer for this word and copy the word to buffer
            int len=wordArr[i].length();
            char[] buffer= new char[len+1];               
            
            
            for(int j=0;j<len;j++)
            {
                buffer[j]=wordArr[i].toCharArray()[j];
               //  System.out.println("Buffer ="+buffer[j]);
            }               
            // Sort the buffer
             Arrays.sort(buffer);
             
             // Insert the sorted buffer and its original index to Trie
          insert(root,  buffer,0);
        }
        
        // Traverse the built Trie and print all anagrms together
     printAnagramsUtil(root, wordArr);
    }
   
    public static void main(String[] args) {
     
        String[] wordArr={"cat", "dog", "tac", "god", "act", "gdo"};
        
        printAnagramsTogether(wordArr);
    }
}
