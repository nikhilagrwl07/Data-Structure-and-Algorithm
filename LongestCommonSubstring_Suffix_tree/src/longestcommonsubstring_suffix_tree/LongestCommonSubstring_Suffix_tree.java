
package longestcommonsubstring_suffix_tree;

/*

 * Java Program to Implement Suffix Tree

 */ 

import java.io.*;

 

/* SuffixNode */

class SuffixNode 

{

    int depth, begin, end;

    SuffixNode[] children;

    SuffixNode parent, suffixLink;

    /* Constructor */

    SuffixNode(int begin, int end, int depth, SuffixNode parent) 

    {

        children = new SuffixNode[38];

        this.begin = begin;

        this.end = end;

        this.parent = parent;

        this.depth = depth;

    }

    boolean contains(int d)

    {

        return (depth <= d) && (d < depth + (end - begin));

    }    

}

 

/* Class SuffixTree */

class SuffixTree 

{

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890\1\2";

    private static int alphabetSize = alphabet.length();

    private static int lcsLength ;

    private static int lcsBeginIndex ;

 

    /* Funtion to build suffix tree for given text */

    public static SuffixNode buildSuffixTree(String s) 
    {

        int n = s.length();

        byte[] a = new byte[n];

        for (int i = 0; i < n; i++) 

            a[i] = (byte) alphabet.indexOf(s.charAt(i));

 

        SuffixNode root = new SuffixNode(0, 0, 0, null);

        SuffixNode cn = root;

           root.suffixLink = root;

        SuffixNode needsSuffixLink = null;

        int lastRule = 0;

        int j = 0;

        for (int i = -1; i < n - 1; i++) 

        {

              int cur = a[i + 1]; 

              for (; j <= i + 1; j++) 

              {

                int curDepth = i + 1 - j;

                if (lastRule != 3) 

                {

                      cn = cn.suffixLink != null ? cn.suffixLink : cn.parent.suffixLink;

                      int k = j + cn.depth;

                      while (curDepth > 0 && !cn.contains(curDepth - 1)) 

                      {

                           k += cn.end - cn.begin;

                           cn = cn.children[a[k]];

                      }

                }

                if (!cn.contains(curDepth)) 

                { 

                    /* explicit node */

                    if (needsSuffixLink != null) 

                    {

                        needsSuffixLink.suffixLink = cn;

                        needsSuffixLink = null;

                    }

                    if (cn.children[cur] == null) 

                    {

                        /* no extension - add leaf */

                        cn.children[cur] = new SuffixNode(i + 1, n, curDepth, cn);

                        lastRule = 2;

                    }

                    else 

                    {     /* already exists */

                        cn = cn.children[cur];

                        lastRule = 3;

                        break;

                    }

                }

                else 

                { 

                    int end = cn.begin + curDepth - cn.depth;

                    if (a[end] != cur) 

                    { 

                        SuffixNode newn = new SuffixNode(cn.begin, end, cn.depth, cn.parent);

                        newn.children[cur] = new SuffixNode(i + 1, n, curDepth, newn);

                        newn.children[a[end]] = cn;

                        cn.parent.children[a[cn.begin]] = newn;

                        if (needsSuffixLink != null) 

                            needsSuffixLink.suffixLink = newn;

                        cn.begin = end;

                        cn.depth = curDepth;

                        cn.parent = newn;

                        cn = needsSuffixLink = newn;

                        lastRule = 2;

                    } 

                    else if (cn.end != n || cn.begin - cn.depth < j) 

                    {

                        lastRule = 3;

                        break;

                    }

                    else

                        lastRule = 1;                      

                }

             }

        }

        root.suffixLink = null;

        return root;

    }        

    /* Funtion to find longest common substring */

    public static int findLCS(SuffixNode node, int i1, int i2) 

    {

        if (node.begin <= i1 && i1 < node.end) 

            return 1;

        if (node.begin <= i2 && i2 < node.end) 

               return 2;

        int mask = 0;

        for (char f = 0; f < alphabetSize; f++) 

            if (node.children[f] != null) 

                     mask |= findLCS(node.children[f], i1, i2);

        if (mask == 3) 

        {

            int curLength = node.depth + node.end - node.begin;

            if (lcsLength < curLength) 

            {

                lcsLength = curLength;

                lcsBeginIndex = node.begin;

            }

        }

        return mask;

    }

    /* Funtion to find longest common substring */

    public static void findLCS(String s1, String s2)

    {

        String s = s1 + '\1' + s2 + '\2';

        SuffixNode root = buildSuffixTree(s);

        lcsLength = 0;

        lcsBeginIndex = 0;               

        findLCS(root, s1.length(), s1.length() + s2.length() + 1);

        boolean chk = lcsLength > 0;

        System.out.println("\nOccurence = "+ chk);

        if (chk)

        {

            System.out.println("\nLongest substring is "+ s.substring(lcsBeginIndex , lcsBeginIndex + lcsLength ));    

        }

    }

}

public class LongestCommonSubstring_Suffix_tree {
  
    public static void main(String[] args) throws IOException {
       
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Finding longest common substring using suffix trees\n");

        System.out.println("Enter two Strings\n"); 

        String s1 = br.readLine(); 

        String s2 = br.readLine();                   

        SuffixTree st = new SuffixTree();

        st.findLCS(s1, s2);         
    }
}
