
package kfrequentwords;


import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class TrieNode
{
     public static final int MAX_CHARS=26;   
     
   int indexMinHeap; // the index of the word in minHeap
    TrieNode[] child=new TrieNode[MAX_CHARS]; // represents 26 slots each for 'a' to 'z'.
    int isEnd;  // indicates end of word
    int freq;   // frequency of occurence of a word
        
    public void TrieNode()
    {
         // Allocate memory for Trie Node
  //  TrieNode trieNode = new TrieNode();
 
    // Initialize values for new node
    isEnd = 0;
    freq = 0;
    indexMinHeap = -1;
    
//    for( int i = 0; i < MAX_CHARS; ++i )
//        trieNode.child[i] = NULL;
 
  //  return trieNode;
    }
        
}

class MinHeapNode
{
    
   TrieNode root= new TrieNode(); // indicates the leaf node of TRIE 
   
    int frequency; //  number of occurrences
    char[] word; // the actual word stored
    
    public MinHeapNode()
    {
        frequency=0;
        word =new char[30];
    }
}

class MinHeap
{
  int capacity; //  total size of min Heap
   int count; // indicates the number of slots filled.
   MinHeapNode[] array; //  represents the collection of minHeapNodes
   
   public MinHeap(int capacity)
   {
     //  MinHeap minHeap=new MinHeap();
        this.capacity=capacity;
       count=0;
       
        // Allocate memory for array of min heap nodes
       array=new MinHeapNode[capacity];
       
       //return minHeap;
       
   }
   // A utility function to swap two min heap nodes. This function
    // is needed in minHeapify
   public void swapMinHeapNodes(MinHeapNode a,MinHeapNode b)
   {
    MinHeapNode t=a;
    a=b;
    b=t;
   }
   
   // This is the standard minHeapify function. It does one thing extra.
// It updates the minHapIndex in Trie when two nodes are swapped in
// in min heap
   public void minHeapify(MinHeap minHeap,int idx)
   {
        int left, right, smallest;
 
    left = 2 * idx + 1;
    right = 2 * idx + 2;
    
      smallest = idx;
    if ( left < minHeap.count && minHeap.array[left].frequency <minHeap.array[smallest].frequency)
        smallest = left;
    
    if ( right < minHeap.count && minHeap.array[ right ]. frequency < minHeap.array[ smallest ]. frequency)
        smallest = right;
    
    
     if( smallest != idx )
    {
        // Update the corresponding index in Trie node.
        minHeap.array[ smallest ]. root.indexMinHeap = idx;
        minHeap.array[ idx ]. root.indexMinHeap = smallest;
 
        // Swap nodes in min heap
        swapMinHeapNodes (minHeap.array[ smallest ], minHeap.array[ idx ]);
 
        minHeapify( minHeap, smallest );
    }
   }
   
   // A standard function to build a heap
void buildMinHeap( MinHeap minHeap )
{
    int n, i;
    n = minHeap.count - 1;
 
    for( i = ( n - 1 ) / 2; i >= 0; --i )
        minHeapify( minHeap, i );
}
   

// Inserts a word to heap, the function handles the 3 cases explained above
void insertInMinHeap( MinHeap minHeap, TrieNode root, char[] word ) 
{
    // Case 1: the word is already present in minHeap
    if( (root).indexMinHeap != -1 )
    {     
//       System.out.println("Freq = "+minHeap.array[ (root).indexMinHeap ].frequency);
       
        minHeap.array[ (root).indexMinHeap ]. frequency =minHeap.array[ (root).indexMinHeap ]. frequency+1;
 
        // percolate down
        minHeapify( minHeap, (root).indexMinHeap );
    }
 
    // Case 2: Word is not present and heap is not full
    else if( minHeap.count < minHeap.capacity )
    {
        int count = minHeap.count;
        minHeap.array[ count ].frequency = (root).freq;
        minHeap.array[ count ].word = new char [( word.length ) + 1];
         minHeap.array[ count ].word=word.clone();
 
        minHeap.array[ count ]. root = root;
        (root).indexMinHeap = minHeap.count;
 
        ++( minHeap.count );
        buildMinHeap( minHeap );
    }
 
    // Case 3: Word is not present and heap is full. And frequency of word
    // is more than root. The root is the least frequent word in heap,
    // replace root with new word
    else if ( (root).freq > minHeap.array[0]. frequency )
    {
 
        minHeap.array[ 0 ]. root.indexMinHeap = -1;
        minHeap.array[ 0 ]. root = root;
        minHeap.array[ 0 ]. root.indexMinHeap = 0;
        minHeap.array[ 0 ]. frequency = (root).freq;
 
        // delete previously allocated memoory and
        minHeap.array[ 0 ]. word=null;
        
        minHeap.array[ 0 ]. word = new char [( word.length ) + 1];
        minHeap.array[ 0 ]. word=word.clone() ;
 
        minHeapify ( minHeap, 0 );
    }
    

}

    // A utility function to show results, The min heap
// contains k most frequent words so far, at any time
public void displayMinHeap( MinHeap minHeap )
{
    int i;
 
    // print top K word with frequency
    for( i = 0; i < minHeap.count; ++i )
    {
        System.out.println(  minHeap.array[i].word +" , "+
                            minHeap.array[i].frequency );
    }
}

 void insertTrieAndHeap(char[] word,TrieNode root,MinHeap minHeap)
    {
        insertUtil(root, minHeap, word, word, 0);
    }
 
 
    void insertUtil( TrieNode root, MinHeap minHeap,
                         char[] word,  char[] dupWord,int i)
{
    // Base Case
    if ( root == null )
        root = new TrieNode();
 
    //  There are still more characters in word
    if (i<word.length)
    {
        System.out.println("Address = "+ ((int)word[i]  - 97) + " char :: " + (root.child[ (int)word[i]  - 97 ]));
        insertUtil ( (root.child[ (int)word[i]  - 97 ]),
                         minHeap, word, dupWord,i+1 );
    }
    else // The complete word is processed
    {
        // word is already present, increase the frequency
        if ( (root).isEnd==1)
            (root).freq +=1;
        else
        {
            (root).isEnd = 1;
            (root).freq= 1;
        }
 
        // Insert in min heap also
      //  MinHeap mH=new MinHeap();
        insertInMinHeap( minHeap, root, dupWord );
    }
}
    
 // The main funtion that takes a file as input, add words to heap
// and Trie, finally shows result from heap
void printKMostFreq(String filename, int k )
{
    int MAX_WORD_SIZE=30;
    // Create a Min Heap of Size k
    MinHeap minHeap= new MinHeap(k);
    
    // Create an empty Trie
    TrieNode root = null;
 
    // A buffer to store one word at a time
   // char buffer[]=new char[MAX_WORD_SIZE];
 
    // Read words one by one from file.  Insert the word in Trie and Min Heap
   // while( fscanf( fp, "%s", buffer ) != EOF )
    File fname=new File(filename);
       FileReader fr = null;
         
        try {
            fr = new FileReader(fname);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MinHeap.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            Scanner scanner = new Scanner(fr);
            
       while (scanner.hasNextLine()) 
       {
         String nextToken = scanner.next();
         System.out.println(" Token :: " + nextToken.toLowerCase());
          insertTrieAndHeap(nextToken.toLowerCase().toCharArray(), root, minHeap);  
 
	}
      
 
    // The Min Heap will have the k most frequent words, so print Min Heap nodes
    displayMinHeap(minHeap);
}   

}



public class KFrequentWords {

   
    public static void main(String[] args) {
        
        int k=5;
         String fname="/Users/nikhil.agrawal/Desktop/maxKfrequencyWord.txt";
       MinHeap mH=new MinHeap(k);
        mH.printKMostFreq(fname, k);
        
    }
}
