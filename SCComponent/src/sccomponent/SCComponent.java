//http://www.cosc.canterbury.ac.nz/tad.takaoka/cosc229/solutions2007/SCComponent.java

package sccomponent;

import java.util.*;

// An Algorithm for Identifying Strongly Connected Components
// Programmed by Sung

public class SCComponent {
	
	Stack stk;
	int c;
		
	public SCComponent() {
		stk =new Stack();
		c=1;
	}
	
	//compares a and b and returns smaller item
	int min(int a, int b) {
		if(a<b) return a;
		else return b;
	}
	
	//procedure CONNECT(v)
	void connect(Vertex v) {
		System.out.println("Visiting "+v.getName());
		//mark v "visited"
		v.setVisited();
                
		//N[v]:=c;
		v.setN(c);
                
		//c:=c+1;
		c++;
                
		//L[v]:=N[v];
		v.setL(v.getN());
		
		v.display();
		//push(v) into STACK;
		stk.push(v);
		
		//obtains the number of out vertices from v and copies them to a temporary array outs[i]
		int numouts=v.getOutsNum();
                
		Vertex [] outs= new Vertex[numouts+1];
                
		for (int i=1;i<=numouts;i++) 
                    outs[i]=v.getOuts(i);

		//for each w in OUT(v) do
		for (int i=1;i<=numouts;i++) {
			Vertex w=outs[i];
			System.out.println(v.getName()+" now looks at "+w.getName());

			//if w is unvisited then begin
			if(!w.isVisited()) {
				//CONNECT(w);
				connect(w);
				System.out.println("1 Updates "+v.getName()+"'s L");

				//L[v]=min{L[v],L[w])};
				v.setL(min(v.getL(),w.getL()));
				v.display();
			}
			else {
				System.out.println(w.getName()+" already visited");
				//else if N[w]<N[v] and w is in STACK then
				if(w.getN()<v.getN() && stk.search(w)!=-1) { 
                                    //note that search(w), generic method of STACK returns -1 when w is not in STACK	
				        System.out.println("2 Updates "+v.getName()+"'s L");
					//L[v]:=min{N[w],L[v]};
					v.setL(min(w.getN(),v.getL()));
					v.display();
				}
			}
		}
		//if L[v]=N[v] then begin
		if (v.getL()==v.getN()) {
			Vertex tmp;
			System.out.print("Output ");
			
			//pop() out of STACK until v comes out. Write them
			tmp=(Vertex)stk.pop();
			while(tmp.getName()!=v.getName()) {
				System.out.print(tmp.getName()+" ");
				tmp=(Vertex)stk.pop();
			}
			System.out.print(tmp.getName()+" ");
			System.out.println();
		}
	}
	
			
	public static void main(String[] args){
		SCComponent sc=new SCComponent();

		///////////////////////////////////////////////////
		// GRAPH LOADING START
		///////////////////////////////////////////////////
		int numVertex=10;
		Vertex[] V= new Vertex[numVertex+1];
		
		V[1]=new Vertex('1');
		V[2]=new Vertex('2');
		V[3]=new Vertex('3');
		V[4]=new Vertex('4');
		V[5]=new Vertex('5');
		V[6]=new Vertex('6');
		V[7]=new Vertex('7');
		V[8]=new Vertex('8');
		V[9]=new Vertex('9');
		V[10]=new Vertex('@');
		
		
		//a-> e,g,b
		V[1].setOuts(V[5]);
		V[1].setOuts(V[7]);
		V[1].setOuts(V[2]);
		
		//b->g
		V[2].setOuts(V[7]);
		
		//c->b,i,j,d
		V[3].setOuts(V[2]);
		V[3].setOuts(V[9]);
		V[3].setOuts(V[10]);
		V[3].setOuts(V[4]);
		
		//d->j
		V[4].setOuts(V[10]);
		
		//e->f
		V[5].setOuts(V[6]);
		
		//f->e,a
		V[6].setOuts(V[5]);
		V[6].setOuts(V[1]);
		
		//g->f,c
		V[7].setOuts(V[6]);
		V[7].setOuts(V[3]);
		
		//h->c,g
		V[8].setOuts(V[3]);
		V[8].setOuts(V[7]);
		
		//i->h,j
		V[9].setOuts(V[8]);
		V[9].setOuts(V[10]);
		
		//j-> Nothing
		
		/////////////////////////////////////////////////
		// GRAPH LOADING END
		/////////////////////////////////////////////////

		//Check if the graph is correctly loaded
		for (int i=1;i<=numVertex;i++) {
			System.out.print(V[i].getName()+"=>");
			for (int j=1;j<=V[i].getOutsNum();j++) {
				System.out.print(V[i].getOuts(j).getName()+",");
			}
			System.out.println();
		}
		// First Vertex to visit is "c"
		Vertex v=V[3];  // starting vertex is V[3]
		
		//mark all v unvisitied
		//It's already done by creating an object sc of class SCComponent

		//while there is an "unvisited" v do CONNECT(v);
		sc.connect(v);
		int i=0;
		while(i<numVertex) {
			for (i=1;i<=numVertex;i++) {
				if(!V[i].isVisited()) 
                                    sc.connect(V[i]);
			}
		}
		
	}
}

class Vertex {
	char name;
	Vertex [] Outs;
	int numOuts;
	int N;
	int L;
	boolean visited=false;
	
	
	public Vertex(char v) {
		name=v;
		numOuts=0;
		Outs = new Vertex[100];
	}
	
	public char getName() {
		return name;
	}
	
	public void setOuts(Vertex v) {
		numOuts++;
		Outs[numOuts]=v;
	}
	public int getOutsNum() {
		return numOuts;
	}
	
	public Vertex getOuts(int i) {
		return Outs[i];
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited() {
		visited=true;
	}
	public void setL(int v) {
		L=v;
	}
	public void setN(int v) {
		N=v;
	}
	public int getL() {
		return L;
	}
	public int getN() {
		return N;
	}
	
	public void display() {
		System.out.print(name);
		System.out.println(": N:"+N+" L:"+L);
	}
	
		
}

