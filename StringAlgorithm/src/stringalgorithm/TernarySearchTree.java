//http://flexaired.blogspot.in/2011/02/ternary-search-tree-implementation.html


package stringalgorithm;

import java.util.ArrayList;

public class TernarySearchTree {

    public static void main(String args[])
    {
        TernarySearchTreeService ts=new TernarySearchTreeService();
        System.out.println("Insert Element");
        ts.insert("IN");
        ts.insert("APPLE");
        ts.insert("ZXY");
        ts.insert("PINE");
        ts.insert("PINX");
        ts.insert("INININGS");
        ts.insert("PETS");
        ts.insert("PINEAPPLE");
        System.out.println("1st Traveral :: " + ts.tostring());
        //ts.insert("AN");
       

//        System.out.println("check whether elemts are present" + " " +ts.search("PINEAPPLE"));
       // System.out.println("************");
        //System.out.println("next  Traveral :: ");
        ts.nextLookUp("APPLE");
    }
}

class TSTNode
{
    char data;
    boolean isEnd;
    TSTNode left,middle,right;

    public TSTNode(char x)
    {
        this.data=x;
        this.isEnd=false;
        this.left=null;
        this.middle=null;
        this.right=null;
    }
}

class TernarySearchTreeService{

    private TSTNode root;
    private ArrayList<String> al;
    private String givenStr="";

    public TernarySearchTreeService()
    {
        root=null;
    }

    public void makeEmpty()
    {
        root=null;
    }

    public void insert(String word)
    {
        root=insert(root,word.toCharArray(),0);
//        System.out.println("root = " + root.data);
    }

    public TSTNode insert(TSTNode r,char[] word,int ptr)
    {
        if(r==null)
        {
            r=new TSTNode(word[ptr]);
        }
        // System.out.println("Root :: " +r.data + " :: word[ptr] :: "+ word[ptr]);
        if(word[ptr]>r.data)
        {
            r.right=insert(r.right,word,ptr);
        }
        else if(word[ptr]<r.data)
        {
            r.left=insert(r.left,word,ptr);
        }
        else
        {
            if(ptr+1 < word.length)
                r.middle=insert(r.middle,word,ptr+1);
            else
                r.isEnd=true;
        }
        return r;
    }

    public boolean search(String word)
    {
        return search(root,word.toCharArray(),0);
    }

    public boolean search(TSTNode r,char[] word,int ptr)
    {
        if(r==null)
            return false;
        if(word[ptr]<r.data)
            return search(r.left,word,ptr);
        else if(word[ptr]>r.data)
            return search(r.right,word,ptr);
        else
        {
            if(r.isEnd && ptr==word.length-1)
                return true;
            else if(ptr==word.length-1)
                return false;
            else
                return search(r.middle,word,ptr+1);
        }
    }

     public String tostring()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : "+ al;
    }
    /** function to traverse tree **/
    private void traverse(TSTNode r, String str)
    {
        
        if (r != null)
        {
            traverse(r.left, str);

            str = str + r.data;
            if (r.isEnd)   //IMP: Important to note that str is added only when we meet in end
            {
                al.add(str);
            }

            traverse(r.middle, str);
            str = str.substring(0, str.length()-1);
//             System.out.println(" :: str.length() " + str.length()+ " :: r = " + r.data + " str = "+str);
            traverse(r.right, str);
        }
    }
    
     public void nextLookUp(String givenStr)
    {
         this.givenStr=givenStr;
         
        al = new ArrayList<String>();
        nextLookUpUtil(root, "");
        
        //return "\nTernary Search Tree : "+ al;
    }
    /** function to traverse tree **/
  //   boolean flag = false;
     int flag =0;
     
     
    private void nextLookUpUtil(TSTNode r, String str)
    {
        
        if (r != null)
        {
          //  System.out.println("root "+ r.data);
            nextLookUpUtil(r.left, str);

            str = str + r.data;
            if (r.isEnd)
            {
                al.add(str);
                if(flag ==1)
                {
                    System.out.println("next element :: " + al.get(al.size()-1)); 
                    flag ++;
                    return;
                }
                if(str.equalsIgnoreCase(givenStr) && flag==0)
                {
                    System.out.println("Inside if ");
                 flag++;
                }
                
                //System.out.println("result is  " + al);
            }

            nextLookUpUtil(r.middle, str);
            str = str.substring(0, str.length()-1);
       // System.out.println(" :: str.length() " + str.length()+ " :: r = " + r.data + " str = "+str);
            nextLookUpUtil(r.right, str);
        }
    }
}