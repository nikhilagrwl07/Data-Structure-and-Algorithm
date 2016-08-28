package KMostFrequentWords;



import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TrieForOccurenceOfString {
    public static void main(String[] args) throws IOException {
       
        File file=new File("/Users/nikhil.agrawal/Documents/DSA/Revision Programs/Final_revision/KFrequentWords/src/KMostFrequentWords/maxKfrequencyWord.txt");
        BufferedReader reader=new BufferedReader(new FileReader(file));
         int k=6;
        MyTrie t = new MyTrie(k);
        String ss=null;
        while((ss=reader.readLine())!=null){
            String[] array=ss.split(" ");
            for (int i = 0; i < array.length; i++) {
                t.insert(array[i]);
            }
        }
        reader.close();
     
        t.display();
        
//        String toSearch = "Geeks";
//        System.out.println("String :: " + toSearch + " :: " + t.search(toSearch));
       
    }
} 


class MyTrieNode {
    char data;
    boolean is_end_of_string;
    Map<Character, MyTrieNode> nodes;
    int frequency = 0;
    int minHeapIndex = -1;

    public MyTrieNode(char data) {
        this.data = data;
        is_end_of_string = false;
        nodes = new HashMap<Character, MyTrieNode>();
    }

    public MyTrieNode children(char data) {
        return nodes.get(data);
    }

    public boolean isChildExist(char c) {
        return children(c) != null;
    }
}


class MinHeap 
{
    int size;
    int capacity;
    MinHeapNode[] nodes;
}


class MinHeapNode {
    String word;
    int frequency;

    //This is extra pointer to point to Trie
    MyTrieNode trieNodeInsideHeap;
} 
class MyTrie {
    MyTrieNode root;
    MinHeap minHeap;

    public MyTrie(int frequency) {
        root = new MyTrieNode(' ');
        this.minHeap = new MinHeap();
        this.minHeap.nodes = new MinHeapNode[frequency];
        this.minHeap.capacity = frequency;
    }

    /*
     * This method to insert the trieNodeInsideHeap into the TRIE
     * */
    public void insert(String s) {
        if (s == null || s.trim().length() == 0) {
            return;
        }
        MyTrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.isChildExist(c)) {
                MyTrieNode node = new MyTrieNode(c);
                current.nodes.put(c, node);
            }
            current = current.children(c);
        }
        
        if (current.is_end_of_string) {
            current.frequency++;
        } else {
            current.frequency = 1;
            current.is_end_of_string = true;
        }
        insertInMinHeap(s, current);

    }

    /*
     * This method is to insert the word into Min Heap using below rule.
     * 1. If word is already is present then, increment the count in MinHeap and call heapify method.
     * 2. If Min Heap is not full(not contains k element), and word is not present then add the trieNodeInsideHeap to Min Heap and update its minHeapIndex, and call heapify.
     * 3.If word is not present and Min Heap is full and new word frequency is more than minimum head then replace the top element(index=0) with new word and update the minHeapIndexOf both the words.
     * */
    private void insertInMinHeap(String s, MyTrieNode current) {
        if (current.minHeapIndex != -1) {
            this.minHeap.nodes[current.minHeapIndex].frequency++;
            minheapify(current.minHeapIndex);
        } else if (this.minHeap.size < this.minHeap.capacity) {
            MinHeapNode node = new MinHeapNode();
            node.word = s;
            node.frequency = current.frequency;
            node.trieNodeInsideHeap = current;
            node.trieNodeInsideHeap.minHeapIndex = this.minHeap.size;
            this.minHeap.nodes[this.minHeap.size] = node;
            ++this.minHeap.size;
            buildHeap();

        } else if (current.frequency > this.minHeap.nodes[0].frequency) {
            this.minHeap.nodes[0].trieNodeInsideHeap.minHeapIndex = -1;
            this.minHeap.nodes[0].trieNodeInsideHeap = current;
            this.minHeap.nodes[0].frequency = current.frequency;
            this.minHeap.nodes[0].word = s;
            current.minHeapIndex = 0;
            minheapify(0);
        }
    }

    private void buildHeap() {
        for (int i = (this.minHeap.size - 1) / 2; i >= 0; i--) {
            minheapify(i);
        }

    }

    /*
     * To search any word is the Trie
     * */
    public boolean search(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        MyTrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.isChildExist(c)) {
                return false;
            }
            current = current.children(c);
        }
        
        return current.is_end_of_string;
    }

    /*
     * This method is to heapify the given and make sure it satisfies the property of the trieNodeInsideHeap
     * */
    public void minheapify(int node) {
        int left = (2*node + 1);
        int right = (2*node + 2);
        int smallest = node;
        if (left < this.minHeap.size
                && this.minHeap.nodes[smallest].frequency > this.minHeap.nodes[left].frequency) {
            smallest = left;
        }
        if (right < this.minHeap.size
                && this.minHeap.nodes[smallest].frequency > this.minHeap.nodes[right].frequency) {
            smallest = right;
        }
        if (smallest != node) {
            int index = this.minHeap.nodes[smallest].trieNodeInsideHeap.minHeapIndex;
            this.minHeap.nodes[smallest].trieNodeInsideHeap.minHeapIndex = this.minHeap.nodes[node].trieNodeInsideHeap.minHeapIndex;
            this.minHeap.nodes[node].trieNodeInsideHeap.minHeapIndex = index;
            MinHeapNode temp = this.minHeap.nodes[smallest];
            this.minHeap.nodes[smallest] = this.minHeap.nodes[node];
            this.minHeap.nodes[node] = temp;
            minheapify(smallest);
        }
    }

    /*
     * Traverse through Min Heap and show all words and their frequency 
     * */
    public void display() {
        for (int i = 0; i < this.minHeap.size; i++) {
            System.out.println("word  :  " + this.minHeap.nodes[i].word
                    + " :: frequency  :  " + this.minHeap.nodes[i].frequency);
        }
    }
} 

