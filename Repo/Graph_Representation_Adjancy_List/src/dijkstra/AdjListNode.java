/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

/**
 *
 * @author admin
 */
public class AdjListNode {

    int vertexNumber;
    int weight;
    AdjListNode next;

    public AdjListNode(int d,int w) {

        this.vertexNumber=d;
        this.weight=w;
        this.next=null;
    }


}
