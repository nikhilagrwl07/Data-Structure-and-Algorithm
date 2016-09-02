
package threadedbinarytree;
// Source = http://arunramesh4u.wordpress.com/data-structures-in-java/threaded-binary-tree/
import java.io.*;

public class ThreadedBinaryTree
{
public static void main(String args[])throws IOException
{
String ch="y";
DataInputStream inp=new DataInputStream(System.in);
ThreadedTree t=new ThreadedTree();
while(ch.equals("y"))
{
System.out.println("Menu");
System.out.println("--");
System.out.println("1.Insert");
System.out.println("2.Display");
System.out.println("Enter your choice ");
int n=Integer.parseInt(inp.readLine());
switch(n)
{
case 1: while(ch.equals("y"))
{
System.out.println("Enter the data");
int a=Integer.parseInt(inp.readLine());
t.insert(a);
System.out.print("Enter y to continue inserting");
ch=inp.readLine();
}
break;
case 2: System.out.println("Tree Elements");
System.out.println("————-");
t.traverse();
break;
default:System.out.println("Invalid Choice");
}
System.out.println("");
System.out.print("Enter y to continue ");
ch=inp.readLine();
}
}
}


class ThreadedTree
{
private Node header;

public ThreadedTree()
{
header=new Node();
header.lChild=header;
header.rChild=header;
}


public void insert(int id)
{
Node xPtr=getNode(id);
Node newNode=new Node(id);
if(xPtr==header)
{

newNode.lChild=header;
newNode.rChild=header;
newNode.lTag=true;
newNode.rTag=true;
header.lTag=false;
header.lChild=newNode;
}
else if(id<xPtr.data)
{
newNode.lChild=xPtr.lChild;
newNode.rChild=xPtr;
newNode.lTag=true;
newNode.rTag=true;
xPtr.lTag=false;
xPtr.lChild=newNode;
}
else
{
newNode.rChild=xPtr.rChild;
newNode.lChild=xPtr;
newNode.lTag=true;
newNode.rTag=true;
xPtr.rTag=false;
xPtr.rChild=newNode;
}
}
private Node getNode(int id)
{
Node ptr=header;
Node parent=ptr;

ptr=insucc(ptr);

if(ptr!=header)
{
if(id>=ptr.data)
{
while(true)
{
parent=ptr;
ptr=insucc(ptr);

if(ptr==header)
break;
if(id<ptr.data)
{
if(parent.rTag)
ptr=parent;
break;
}
}
}
}
if(ptr==header&&!header.lTag)
return parent;
return ptr;
}


private Node insucc(Node ptr)
{
Node succ=ptr.rChild;
if(ptr.rTag==false)
{
while(succ.lTag==false)
succ=succ.lChild;
}
return succ;
}
public void traverse()
{
System.out.print("Inorder Traversal:-     ");
inOrder(header);
System.out.println("");
}
private void inOrder(Node ptr)
{

while(true)
{
ptr=insucc(ptr);
if(ptr==header)
break;
ptr.displayNode();
}
}

}

class Node
{
    public int data;
    public Node lChild;
    public Node rChild;
    public boolean lTag;
    public boolean rTag;

public Node(int x)
{
data=x;
}
public Node()
{
lTag=true;
rTag=false;
}
public void displayNode()
{
System.out.print(data+"  ");
}
}