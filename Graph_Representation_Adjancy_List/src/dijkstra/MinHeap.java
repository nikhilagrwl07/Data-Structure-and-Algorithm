/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

/**
 *
 * @author admin
 */
class MinHeap {

   int capacity;
   int size;
   Node[] heap;
   int[] pos;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size=capacity;
        heap=new Node[capacity];
        pos=new int[capacity];
//
//        for(int i=0;i<capacity;i++)
//        {
//            heap[i+1]=new Node(i+1,Integer.MAX_VALUE);
//            pos[i+1]=i;
//        }
    }

  



}
