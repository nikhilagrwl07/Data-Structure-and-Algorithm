
package RV2.DisjointSets;

import java.util.LinkedList;


public class UnionFindUsingLinkedList {
    public static void main(String args[])
    {
        int v=6;   // number of vertices
        ItemNode[] itemList = new ItemNode[v+1]; 
       
        
        itemList[0] = new ItemNode(0, true);
        
        itemList[1]  = new ItemNode(1,false);
        itemList[2]  = new ItemNode(2,false);
        itemList[3]  = new ItemNode(3,false);
        itemList[4] = new ItemNode(4,false);
        itemList[5]  = new ItemNode(5,false);
        itemList[6] = new ItemNode(6,true);
        itemList[0].edges.add(itemList[2]);
        itemList[0].edges.add(itemList[1]);
        itemList[2].edges.add(itemList[3]);
        itemList[3].edges.add(itemList[4]);
        itemList[6].edges.add(itemList[5]);
        itemList[4].parentNode=itemList[3];
        itemList[3].parentNode=itemList[2];
        itemList[2].parentNode=itemList[0];
        itemList[0].parentNode=itemList[0];
        itemList[5].parentNode=itemList[6];
        itemList[1].parentNode=itemList[0];
        UnionFindUsingLinkedList ulist = new UnionFindUsingLinkedList();
        System.out.println("Node    ParentNode ");
        System.out.println(itemList[6].val + "        "+ ulist.find(itemList[6]).val);
        System.out.println(itemList[5].val + "        "+ ulist.find(itemList[5]).val);
        System.out.println(itemList[4].val + "        "+ ulist.find(itemList[4]).val);
        System.out.println(itemList[3].val + "        "+ ulist.find(itemList[3]).val);
        System.out.println(itemList[2].val + "        "+ ulist.find(itemList[2]).val);
        System.out.println(itemList[1].val + "        "+ ulist.find(itemList[1]).val);
        System.out.println(itemList[0].val + "        "+ ulist.find(itemList[0]).val);

        System.out.println("######### After union #########");
        ulist.union(itemList[0], itemList[6]);
          System.out.println("Node    ParentNode ");
        System.out.println(itemList[6].val + "        "+ ulist.find(itemList[6]).val);
        System.out.println(itemList[5].val + "        "+ ulist.find(itemList[5]).val);
        System.out.println(itemList[4].val + "        "+ ulist.find(itemList[4]).val);
        System.out.println(itemList[3].val + "        "+ ulist.find(itemList[3]).val);
        System.out.println(itemList[2].val + "        "+ ulist.find(itemList[2]).val);
        System.out.println(itemList[1].val + "        "+ ulist.find(itemList[1]).val);
        System.out.println(itemList[0].val + "        "+ ulist.find(itemList[0]).val);
//        if(ulist.isCycle(itemList))
//        {
//             System.out.println("Graph is cyclic");
//        }
//        else
//            System.out.println("Graph is non-cyclic");
    }
   
    
    public ItemNode find(ItemNode i)
    {
       if(i.isRoot)
           return i;
       
       ItemNode it = find(i.parentNode);
       i.parentNode = it;
       return it;
    }

    // without union by rank
    public void union(ItemNode i, ItemNode j)
    {
        ItemNode iParent = find(i);
        ItemNode jParent = find(j);

        if(iParent == jParent)
            return;

        if(iParent.rank< jParent.rank)
        {
             iParent.parentNode=jParent;
             iParent.isRoot=false;
             jParent.edges.add(iParent);
        }
        else if(iParent.rank > jParent.rank)
        {
             jParent.parentNode=iParent;
             jParent.isRoot=false;
             iParent.edges.add(jParent);
        }
        else {
            jParent.parentNode=iParent;
             jParent.isRoot=false;
             iParent.rank++;
        }
       
    }

    // not  working 
 /*   public boolean isCycle(ItemNode[] itemList )
    {
        for(ItemNode node : itemList)
        {
            LinkedList<ItemNode> edges = node.edges;
             int len = edges.size();
             int index=0;
            while(index<len)
            {
                ItemNode h1 = find(node);
                ItemNode h2 = find(edges.get(index));
                System.out.println("h1 :: "+h1.val + " h2 ::: "+ h2.val);
                if(h1.val==h2.val)
                {
                    return true;
                }
                index++;
           }
        return  false;
       }
       return false;
    }  */

}

   class ItemNode
   {
     public ItemNode(int val, boolean isRoot) {
        this.val = val;
        this.isRoot = isRoot;
        
    }

    int val;
    LinkedList<ItemNode> edges = new LinkedList<ItemNode>();
    ItemNode parentNode;
    boolean isRoot = false ;
    int rank =0;
   }

