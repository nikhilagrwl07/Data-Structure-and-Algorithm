/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

/**
 *
 * @author admin
 */
public class Graph {

    int V;
    AdjList array[];

    public Graph(int V) {
        this.V = V;
        array=new AdjList[V];

        for(int i=0;i<V;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
        }

    }

    public void addEdge(int s,int d,int w)
    {
        AdjListNode newNode=new AdjListNode(d,w);
        newNode.next=array[s].head;
        array[s].head=newNode;

        AdjListNode p=new AdjListNode(s, w);
        p.next=array[d].head;
        array[d].head=p;

    }



}
