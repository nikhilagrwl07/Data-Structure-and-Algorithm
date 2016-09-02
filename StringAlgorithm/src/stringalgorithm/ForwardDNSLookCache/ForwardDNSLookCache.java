/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stringalgorithm.ForwardDNSLookCache;

/**
 *
 * @author nikhil.agrawal
 */
public class ForwardDNSLookCache {
    
    
    public static void main(String[] args) {

        String URL[] = { "www.samsung.com","www.samsung.net","www.google.in"};
       String ipAdd[] = { "107.108.11.123","107.109.123.255","74.125.200.106" };

       int n=URL.length;
        Trie t=new Trie();
        for(int i=0;i<n;i++)
        {
            t.insertUrlWithIPAddress(URL[i], ipAdd[i]);
        }

      t.getIpFromURL("www.samsung.com");
        

    }

}

class TrieNode
{
    char ch;
   TrieNode[] children;
   boolean isEnd;
   String ipAdd;

    public TrieNode() {

        children= new TrieNode[27];
        isEnd=false;
    }

    public void setIsEnd(boolean v)
    {
        this.isEnd=v;

    }

    public void setIpAdd(String s)
    {
        this.ipAdd=s;
    }


}

class Trie
{
    private TrieNode root;

    public Trie() {
        root=new TrieNode();
    }

    public int getIndex(char c)
    {
        return (c=='.')?26:(c-'a');
    }

    public void insertUrlWithIPAddress(String url,String ip)
    {
//        System.out.println("url " + url + " ip add " + ip);
        if(url==null || url.length()==0)
        {
            System.out.println("error:please enter valid url ");
            return;
        }

        int len=url.length();
//        System.out.println("length " + len);
        TrieNode crawl=root;
        for(int i=0;i<len;i++)
        {
            int index=getIndex(url.charAt(i));

            if(crawl.children[index]==null)
            {
                crawl.children[index]=new TrieNode();
                crawl=crawl.children[index];

            }
            else
            {
                crawl=crawl.children[index];
            }
        }

        crawl.setIsEnd(true);
        crawl.setIpAdd(ip);
//        System.out.println("ip set " + crawl.ipAdd);
    }

    public void getIpFromURL(String word)
    {
        if(word==null || word.length()==0)
        {
            System.out.println("invalid url");
            return;
        }

        String s=getIpFromURLUtill(word);
        if(s==null)
        {
            System.out.println("no such ip adress present for given url");
        }
        else
        {
            System.out.println("ip address for given url is " + s);
        }
    }

    public String getIpFromURLUtill(String url)
    {
        String ip=" ";
        int len=url.length();
//        System.out.println("length " + len);
        TrieNode crawl=root;
        int i;
        for( i=0;i<len;i++)
        {
            int index=getIndex(url.charAt(i));

           // System.out.println("index " + index);
            if(crawl.children[index]!=null)
            {
               // System.out.println("child not null");
                crawl=crawl.children[index];
                
            }
        }
        if(crawl!=null && crawl.isEnd==true && i==len)
                {
                   // System.out.println("ip address " + crawl.ipAdd);
                    return crawl.ipAdd;
                }
        return ip;
    }


}
