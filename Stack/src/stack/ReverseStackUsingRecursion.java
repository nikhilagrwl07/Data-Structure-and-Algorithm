/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */
public class ReverseStackUsingRecursion {

    
    public void reverse(Deque<Integer> s){
        
        if(s.size()==0)
        {
            return;
        }
        
        int popppedElement= s.pop();
        reverse(s);
        insertAtBottom(s , popppedElement);
    }
    
    
    public void insertAtBottom(Deque<Integer> s , int popppedElement)
    {
        if(s.size()==0)
        {
            s.push(popppedElement);
            return;
        }
        
        int newpopelement = s.pop();
        
        insertAtBottom(s, popppedElement);
        s.push(newpopelement);
    }
    
    public static void main(String args[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        
        Iterator<Integer> itr =  stack.iterator();
        System.out.println("Before reversing ...");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        
        ReverseStackUsingRecursion rsu = new ReverseStackUsingRecursion();
        
        rsu.reverse(stack);
        System.out.println("After reversing ...");
        itr =  stack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        
    }
    
}