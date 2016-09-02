/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LinkedListSum;

class LinkedListSum {

    public static LinkedList d1=new LinkedList();
    public static LinkedList d2=new LinkedList();
    public static LinkedList d3=new LinkedList();
    public static int carry=0;
    public static void main(String[] args) {
        
        int a[]={1,2,3};
        int b[]={1,8};
        sumOfLinkedLists(a, b);
        

    }

    public static void sumOfLinkedLists(int a[],int b[])
    {
        int len1=a.length;
        int len2=b.length;


        for(int i=len1-1;i>=0;i--)
        {
            d1.head=d1.insert(d1.head, a[i]);
        }
        d1.print(d1.head);

        for(int i=len2-1;i>=0;i--)
        {
            d2.head=d2.insert(d2.head, b[i]);
        }
        
        d2.print(d2.head);
        d3.head=addList(d1.head, d2.head, d3.head);
        d3.print(d3.head);
        
    }

    public static Node addList(Node h1,Node h2,Node result)
    {
        Node curr;
        if(h1==null)
        {
            result=h2;
            return result;
        }

        if(h2==null)
        {
            result=h1;
            return result;
        }

        int s1=d1.getSize(h1);
        int s2=d2.getSize(h2);
        

        if(s1==s2)
        {
           result=addSameSize(h1, h2);
        }
        else
        {
            int diff=Math.abs(s1-s2);
            if(s1>s2)
            {
                System.out.println("inside frst");
                curr=h1;
                while(diff>0)
                {
                    curr=curr.next;
                    diff--;
                }
                System.out.println("cur vale " + curr.data);
                result=addSameSize(curr, h2);
                d3.head=result;
                result=addCarryToRemaining(h1, curr);
            }
            else
            {
                curr=h2;
                while(diff>0)
                {
                    curr=curr.next;
                    diff--;
                }
                result=addSameSize(h1, curr);
                d3.head=result;
                result=addCarryToRemaining(h2, curr);
            }
        }

        if(carry!=0)
        {
            result=d3.insert(result, carry);
            carry=0;
        }

        return result;


    }

    public static Node addSameSize(Node h1,Node h2)
    {
        if(h1==null)
            return null;

        Node res=new Node(0);
        int sum;
        res.next=addSameSize(h1.next, h2.next);
        sum=h1.data+h2.data+carry;
        System.out.println("after sum " + sum);
        carry=sum/10;
        System.out.println("carry after sum "+carry);
        sum=sum%10;
        res.data=sum;
        System.out.println("res data " + res.data);
        return res;


    }

    public static Node addCarryToRemaining(Node head,Node curr)
    {
        int sum;
        //System.out.println("carry value " + carry);
        if(head!=curr)
        {
            //System.out.println("result data  " + result.data);
            addCarryToRemaining(head.next, curr);
            sum=head.data+carry;
            carry=sum/10;
            sum=sum%10;
            //System.out.println("after sum " + sum);
            //System.out.println("carry after sum "+carry);
            d3.head=d3.insert(d3.head, sum);
            //System.out.println("result data after " + result.data);
        }
        return d3.head;

    }

}

class LinkedList
{
    Node head;
    
    public Node insert(Node head,int x)
    {
        if(head==null)
        {
            head=new Node(x);
            head.next=null;

        }
        else
        {
           
            Node temp=new Node(x);
            temp.next=head;
            head=temp;
            
        }
        return head;
    }
    
    public int getSize(Node head)
    {
        int len=0;
        Node temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        return len;
    }
    
    public void print(Node head)
    {
        Node temp=head;
        while(temp!=null)
            
        {
            System.out.print(temp.data+"----> ");
            temp=temp.next;
        }
        System.out.println("");
    }
}

class Node
{
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

}