/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practice_island_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;




class graph
{
    int numberOfNodes;
    List<LinkedList<Integer>> adjacenyList;

    public graph(int numberOfNodes) {
        this.adjacenyList =  new ArrayList<LinkedList<Integer>>(numberOfNodes);
        
        this.numberOfNodes = numberOfNodes;
    }
    
    public void addEdge(int src , int dest)
    {
        
        LinkedList linkedList = adjacenyList.get(src);
        linkedList.add(dest);
        
        
    }
    
    
    // considering index from  1 . Not from 0
    public void printGraph()
    {
        System.out.println("Printing the adjancey List ::: ");
        
        for(int i=0;i<numberOfNodes; i++)
        {
            System.out.print(i+ " -->");
            LinkedList<Integer> head = adjacenyList.get(i);
            
            while(head != null)
            {
                System.out.print(head + " ");
            }
            System.out.println();
        }
        
    }
    
    public void constructAdjaceneyListFromMatrix(int[][] m , int r , int c) 
    {
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                
            }
        }
    }
    
}
public class Island {
    
    
    public static void main(String[] args) {
        int[][] islandMatrix = {
                                {0,1,1,0,1},
                                {1,1,1,0,0}, 
                                {0,0,0,1,1},
                                {1,0,0,1,0}
                               };
        
        
        
        
    }


}
