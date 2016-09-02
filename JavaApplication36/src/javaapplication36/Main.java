
package javaapplication36;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {


private static StringTokenizer st;

    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }

    public static String next()
    {
        return st.nextToken();
    }

    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
        int h1 , h2, predence ;
        String experssion;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        h1= nextInt();
        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i=1;i<=h1*2;i++)
        {
            nextLine(br);
            predence= nextInt();
            nextLine(br);
            experssion= next();
            
            int value = evaluate(experssion, predence);
            System.out.println("value = " + value);
            bos.write(value+"\n");
        }
        
        bos.flush();
    }
    
    
    public static int evaluate(String expression , int predence)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'operand'
        Stack<Integer> operand = new Stack<Integer>();
 
        // Stack for Operators: 'operator'
        Stack<Character> operator = new Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                operand.push(Integer.parseInt(sbuf.toString()));
            }
 
            // Current token is an opening brace, push it to 'operator'
            else if (tokens[i] == '(')
                operator.push(tokens[i]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (operator.peek() != '(')
                  operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
                operator.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'operator' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'operator'
                // to top two elements in operand stack
                while (!operator.empty() && hasPrecedence(tokens[i], operator.peek() , predence))
                  operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
 
                // Push current token to 'operator'.
                operator.push(tokens[i]);
            }
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // operator to remaining operand
        while (!operator.empty())
            operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
 
        // Top of 'operand' contains result, return it
        return operand.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2, int predence)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if (predence==1 && (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return true;
        else if(predence==0 && (op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-')) 
            return true;
        else
            return false;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a )
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
   
    public static void print(int h1, int h2)
    {
        System.out.println("h1 = " + h1 + " h2 = " + h2);
    }
            
            

}