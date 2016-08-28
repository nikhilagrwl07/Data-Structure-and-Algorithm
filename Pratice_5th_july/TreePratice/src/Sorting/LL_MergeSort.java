
package Sorting;

class LL_MergeSort {

    public static void main(String[] args) {
      linklist l1 = new linklist();
       l1.add(-1);
       l1.add(10);
       l1.add(-5);
       l1.add(20);
       l1.add(-10);
       l1.add(30);
       l1.add(-30);

        l1.display("Before Sort ::", l1.start);
       Node headOfH1 = mergeSort(l1.start);
        l1.display("After Sort ::" , headOfH1);

                 linklist l2=new linklist();
       l2.add(100);
       l2.add(-89);
       l2.add(500);
       l2.add(-100);
       l2.add(66);
       l2.add(33);
       l2.add(-97);
       l2.add(555);
        l1.display("Before Sort ::", l2.start);
       Node headOfH2 = mergeSort(l2.start);
        l1.display("After Sort ::" , headOfH2);


        Node combinedLL = iterativeMerge(headOfH1, headOfH2);
         l1.display("After 2 LL merge  ::" , combinedLL);
    }

    public static Node mergeSort(Node s){

        if(s==null || s.next==null) return s;

        // dividing the linkedlist into 2 parts

        Node a =s;
        Node b = s.next;

        while(a!=null && b!=null && b.next!=null){
            a=a.next;
            b=b.next.next;
        }
        b=a.next;
        a.next=null;


        Node s1= mergeSort(s);
        Node s2 = mergeSort(b);

        return iterativeMerge(s1, s2);

    }

    public static Node iterativeMerge(Node h1 , Node h2){

        if(h1==null) return h2;
        if(h2==null) return h1;


        Node temp = new Node();
        Node start = temp;

        while(h1!=null && h2!=null){

            if(h1.data<=h2.data){
                temp.next=h1;
                h1=h1.next;
            }
            else
            {
                temp.next=h2;
                h2=h2.next;
            }
            temp=temp.next;
        }

        if(h1==null)
            temp.next=h2;
        else
            temp.next=h1;

        return start.next;

    }

    
}


class linklist
{
    Node start;     //=new Node();

    public void add(int x)
    {
        if(start==null)
        {
           start=new Node();
            start.setData(x);
            start.setNext(null);

        }
        else
        {
            Node t=start;
            Node lastbefore=start;

           while(t!=null)
           {
               lastbefore=t;
               t=t.next;
           }

           lastbefore.next=new Node();
           lastbefore.next.setData(x);
           lastbefore.next.setNext(t);

        }
    }

    public void display(String msg , Node s)
    {
        System.out.println(msg);
        Node t=s;

        while(t!=null)
        {
            System.out.print(t.data+"   ");
            t=t.next;
        }
        System.out.println();
    }
}


class Node {
    int data;
    Node next ;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

