
package stringalgorithm.ReverseLookUpCacheUsingTrie;


import java.util.HashMap;
class TrieNode
{
    private HashMap<Character,TrieNode> children;
    private boolean bIsEnd;
    private String url;
    
    public TrieNode()
    {
        children = new HashMap();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
class Trie
{
    private TrieNode root;
    
    public Trie()
    {
        root= new TrieNode();
    }
 
    public void insertWithUrl(String word, String url)
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
                TrieNode temp=new TrieNode();
                child.put(ch, temp);
                crawl=temp;
            }
        }
        // set bisEnd true for last character 
        crawl.setIsEnd(true);
        crawl.setUrl(url);
        
    }
    
    
    
    public void getMatchingUrlFromIpAddress(String ipaddress){
        
        if(ipaddress==null || ipaddress.isEmpty())
        {
            System.out.println("Input is invalid");
            return;
        }
        
        
        String url = getMatchingUrlFromIpAddressUtil(ipaddress);
        
        if(url.isEmpty())
        {
             System.out.println("No valid url found for ipaddress : " + ipaddress);
        }
        else
        {
            System.out.println(" url found for ipaddress is : " + url);
        }
    }
   // the main method which finds out the longest string 'ipaddress'
    public String getMatchingUrlFromIpAddressUtil(String ipaddress)
    {
        String url=""; // Initialize the resultant string
        int length=ipaddress.length();
        
        // Initialize the reference to traverse the trie
        TrieNode crawl=root;
        
        // Iterate through all the characters of the ipaddress string and traverse 
        // down the trie
        
        int level;
        
        for(level=0;level<length;level++)
        {
            // find the current character of str
            char ch=ipaddress.charAt(level);
                        
            HashMap<Character,TrieNode> child=crawl.getChildren();
            
            if(child.containsKey(ch))
            {
                // update the crawl
                crawl=child.get(ch);
                
                if(level==length-1 && crawl.IsEnd())
                {
                    return crawl.getUrl();
                }
            }
            else
                break;
        }
        
        return url;
       
    }
    
}

public class ReverseLookUpCacheUsingTrie {

    public static void main(String[] args) {
        Trie dict= new Trie();
        dict.insertWithUrl("107.108.11.123", "www.samsung.com");
        dict.insertWithUrl("107.109.123.255","www.samsung.net");
        dict.insertWithUrl("74.125.200.106","www.google.in");   
        dict.getMatchingUrlFromIpAddress("74.125.200.106");
        
      
    }
}
