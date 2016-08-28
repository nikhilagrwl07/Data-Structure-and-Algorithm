package cc.nikhil.stack;

import java.util.Stack;

import java.util.*;

public class stackMostFrequent {

	// use two stacks and 1 hashtable
		int max=-1;
	public static void main(String[] args) {
		
		stackMostFrequent ob=new stackMostFrequent();
		
		Stack<Integer> s1=new Stack<Integer>();
	
		Hashtable<Integer,Integer> ht=new Hashtable();
		
		ob.push(10,s1,ht);
		ob.push(2,s1,ht);
		ob.push(5,s1,ht);
		ob.push(2,s1,ht);
		ob.push(10,s1,ht);
		ob.push(10,s1,ht);		
		ob.push(8,s1,ht);
		
		System.out.println(ob.pop(s1,ht));
	}
	
	public void push(int item,Stack s,Hashtable h){
		
		s.push(item);
		if(h.contains(item)){
			//Object count=h.get(item);
			if(max<(Integer)h.get(item))
			{
				max=(Integer)h.get(item);
			}
			
			h.put(item,(Integer)h.get(item)+1);
			}
		else{
			h.put((Integer)h.get(item), 1);
		}
	}
	
	public int pop(Stack s,Hashtable h){
		Stack<Integer> s2=new Stack<Integer>();
		
		int maxstart=(Integer) h.get(max);
		
		int val=(Integer) s.pop();
		
		while(val!=maxstart){
			s2.push(val);
			val=(Integer) s.pop();
		}
		
		while(!s2.isEmpty()){
			s.push(s2.pop());
			//val=(Integer) s.pop();
		}
		
		return maxstart;
		
		
	}

}
