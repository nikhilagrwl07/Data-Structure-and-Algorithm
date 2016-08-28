
package trie;

class TrieNode
{
    char letter;
    TrieNode[] links;
    boolean fullWord;
   
    TrieNode(char letter, boolean fullWord)
    {
        this.letter = letter;
        links = new TrieNode[26];
        this.fullWord = fullWord;
    }   
    
}


public class Trie {
    
    static TrieNode createTree()
    {
        return(new TrieNode('\0', false));   // This is used once only for root node
    }
   
    static boolean isItFreeNode(TrieNode node)
    {
        int i;
        for(i=0;i<node.links.length;i++)
        {
            if(node.links[i]!=null)
                return false;
        }
        return true;
    }
     
    
//   Case 1. Key may not be there in trie. Delete operation should not modify trie.
//   Case 2. Key present as unique key (no part of key contains another key (prefix), 
        //nor the key itself is prefix of another key in trie). Delete all the nodes.
//   Case 3. Key is prefix key of another long key in trie. Unmark the leaf node.
//   Case 4. Key present in trie, having atleast one other key as prefix key. 
        //Delete nodes from end of key until first leaf node of longest prefix key.

    
    
    static void deleteKey(TrieNode root, String key)
    {
        char[] word=key.toCharArray();
        int len=word.length;
        Boolean f;
        if(len>0)
        {
            if(find(root, key)) 
            { 
                f=deleteHelper(root,word,0);
                
            //   System.out.println("Check= "+f);
           //   if(f==true)
            //  {
                    System.out.println("Deleted Successfully! = "+key+"\n");
             // }
              //else
                    //System.out.println("Check point ");
            }
            else  // Case 1
                System.out.println("Data NOT found = "+key+"\n");
        }
    }
   
   
    // Deleting node in bottom up manner using recursion
    static boolean deleteHelper(TrieNode root,char[] key,int level)
    {
          int offset=97;
          
        if(root!=null)
        {
             int len=key.length;
             TrieNode curNode=root;
             
             // Base Case:
             if(level==len)
             {
                 if(curNode.fullWord)
                 {
                     // Unmark the leaf Node
                     curNode.fullWord=false;
                     
                     //If empty node to be deleted
                     if(isItFreeNode(curNode))
                     {
                         return true;
                     }
                     return false;
                 }
             }
             // Recursive Case
             else
             {
                 int index=key[level]-offset;
                 
                 if(deleteHelper(root.links[index], key, level+1))
                 {
                     // Last Node marked , delete it
                     curNode.links[index]=null;
                     
                     // recursively climb up , and delete eligible nodes
                     return (curNode.fullWord && isItFreeNode(curNode));
                 }
             }
        }
        return false;
    }
    
    static void insertWord(TrieNode root, String word)
    {
        int offset = 97;
        int l = word.length();
        char[] letters = word.toCharArray();
        TrieNode curNode = root;
       
        for (int i = 0; i < l; i++)
        {
            if (curNode.links[letters[i]-offset] == null)
                curNode.links[letters[i]-offset] = new TrieNode(letters[i], i == l-1 ? true : false);
            
            curNode = curNode.links[letters[i]-offset];
        }
    }

    // find whether word is a fullword or not?
    //if Yes-> return true ; No--> return false
    static boolean find(TrieNode root, String word)
    {
        char[] letters = word.toCharArray(); // these are characters of string
        int l = letters.length;
        int offset = 97;
        TrieNode curNode = root;
       
        int i;
        for (i = 0; i < l; i++)
        {
            if (curNode == null)
                return false;
            
            curNode = curNode.links[letters[i]-offset];
        }
       
        if (i == l && curNode == null)
            return false;
       
        if (curNode != null && !curNode.fullWord)
            return false;
       
        return true;
    }
   
    static void printTree(TrieNode root, int level, char[] branch)
    {
        if (root == null)
            return;
       
        for (int i = 0; i < root.links.length; i++)
        {
            branch[level] = root.letter;
            printTree(root.links[i], level+1, branch);   
        }
       
        if (root.fullWord)
        {
            for (int j = 1; j <= level; j++)
                System.out.print(branch[j]);
            
            System.out.println();
        }
    }
   
    public static void main(String[] args)
    {
        TrieNode root = createTree();
       
        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
        for (int i = 0; i < words.length; i++)
            insertWord(root, words[i]);
       
        char[] branch = new char[6];
      printTree(root, 0, branch);
     
              System.out.println("---------------------");
              
        String searchWord = "aloe";
       
       if (find(root, searchWord))
        {
            System.out.println("\nWord Found= "+searchWord);
        }
        else
        {
            System.out.println("\nWord NOT Found= "+searchWord);
        } 
        
      //  deleteKey(tree, searchWord);
       
     //  printTree(tree, 0, branch);
       
         deleteKey(root, "allot");
        
         printTree(root, 0, branch);

         System.out.println("---------------------");
         
           deleteKey(root, "alloy");
           printTree(root, 0, branch);

//           deleteKey(tree, "an");
//           printTree(tree, 0, branch);
    }
}


