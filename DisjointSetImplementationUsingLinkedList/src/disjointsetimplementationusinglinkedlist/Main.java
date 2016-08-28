

package disjointsetimplementationusinglinkedlist;

public class Main {

    public static void main(String[] args) {
        Set a = makeset('a');
        Set b = makeset('b');
        Set c = makeset('c');

        Set u1 = union(a, b);
        printSet(u1);
        Set u2 = union(c, u1);
        printSet(u2);

        Set d = makeset('d');
        Set e = makeset('e');
        Set f = makeset('f');
        Set g = makeset('g');

        Set u3 = union(d, e);
        Set u4 = union(f, g);
        printSet(u4);

        Set u5 = union(u3, u4);
        printSet(u5);

        Set u6 = union(u1, u5);
        printSet(u6);
    }


    public static Set makeset(char c)
    {
       Set s = new Set();
       Node n = new Node(c,null , null);
       s.tail = n;
       s.Head = n;
       n.pointingToHead = s.Head;
       s.length++;
       return s;
    }

    // Weighted union heuritics
    public static Set union( Set s1 , Set s2)
    {
        System.out.println(" s1 :: "+ s1.length + "  s2 :: "+ s2.length);
        if(s1.length<s2.length)
        {
            Node s2LastNode = s2.tail;

            if(s2LastNode != null)
            {
                s2LastNode.nextNode = s1.Head;
                // removing  each node of s1 to s2's head Node
                Node temp =null;
                while(s1.Head !=null)
                {
                    s1.Head.pointingToHead = s2.Head;
                    temp = s1.Head;
                    s1.Head = s1.Head.nextNode;
                    if(s2 != null)
                        s2.length++;
                }
            
                s2.tail = temp;
            }
            return s2;
        }
        else
        {
            Node s1LastNode = s1.tail;

            if(s1LastNode != null)
            {
                s1LastNode.nextNode = s2.Head;
                // removing  each node of s1 to s2's head Node
                Node temp =null;
                while(s2.Head !=null)
                {
                    s2.Head.pointingToHead = s1.Head;
                    temp = s2.Head;
                    s2.Head = s2.Head.nextNode;
                    if(s1 != null)
                        s1.length++;
                }
            
                s1.tail = temp;
            }
             return s1;
        }
    }

    public static Node findSet(Set s1)  // or Node n1
    {
        if(s1 !=null)
            return s1.Head;

        return null;
    }

    public static void printSet(Set s)
    {
        if(s !=null || s.Head !=null)
        {
            System.out.println("Printing set ##### " );
            Node n = s.Head;
            while(n != null)
            {
                System.out.print(n.c + "  ");
                n=n.nextNode;
            }
              System.out.println();
        }

    }
}


class Set
{
    Node Head;
    Node tail;
    int length;   // Weight union heuristics

}

class Node
{
    char c;
    Node nextNode ;
    Node pointingToHead;

    public Node(char c, Node nextNode, Node pointingtoHead)
    {
        this.c=c;
        this.nextNode = nextNode;
        this.pointingToHead = pointingtoHead;
    }
}
