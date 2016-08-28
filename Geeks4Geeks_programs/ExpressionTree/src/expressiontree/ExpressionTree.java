
package expressiontree;

import java.util.Stack;
public class ExpressionTree {

  
    public static void main(String[] args) {
      binarytree obj=new binarytree();
       obj.run();
        
    }
  public static class binarytree
    {
       public class Node
       {
         char op;
        Node right;
        Node left;            
        
        public Node(char x)   
        {
            this.op=x;
        }
                  
       }
    
     public void run()
     {  
         int j;
         char[] expression={'a', 'b', '+', 'c', 'd', 'e', '+', '*', '*'};   // postfix expression
         
         for(j=0;j<expression.length;j++)
         System.out.print(expression[j]+" ");
         
         Node root=buildExpressionTree(expression);        // expression tree formed
          System.out.println();
         // performing postfix traversal of constructed Expression Tree
         postfixTraversal(root);
         
     }
     
     public Node buildExpressionTree(char[] exp)
     {
         
         Stack s=new Stack();
         int size=exp.length;
         int i;
         for(i=0;i<size;i++)
         {
             
         if(exp[i]=='+' || exp[i]=='-' || exp[i]=='/' || exp[i]=='*')     // operator case
         {
             Node t1=(Node) s.pop();
             Node t2=(Node) s.pop();
             
            Node n=new Node(exp[i]);  
            n.right=t1;
            n.left=t2;
            
            s.push(n);
             
         }
         else                       // operand case
         {
             Node n=new Node(exp[i]);   
             n.left=null;
             n.right=null;
             
             s.push(n);
         }
         
         }
         return (Node) s.pop();
     }
    

    public void postfixTraversal(Node r)
    {
        
        if(r!=null)
        {
            postfixTraversal(r.left);
            postfixTraversal(r.right);
            System.out.print(r.op+"  ");
        }
        else
        {
            return;
        }
        
        
    }
  
  }    

}