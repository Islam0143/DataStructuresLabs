import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author Islam
 */
class SingleLinkedList {

    /**
     *
     */
    class Node{

        /**
         *
         */
        Object data;

        /**
         *
         */
        Node next;
            
        /**
         *
         * @param data
         */
        public Node(Object data){
                this.data = data;
            }
        }

    /**
     *
     */
    public Node head = null;

    /**
     *
     */
    public Node tail = null;

    /**
     *
     */
    public int size = 0;
        
    /**
     *
     */
    public void print(){
        Node current = head;
        System.out.print("[");
        while(current != null){
            System.out.print(current.data);
            current = current.next;
            if(current != null)
                System.out.print(", ");
        }
        System.out.print("]");
    }
    
    /**
     *
     * @param index
     * @param data
     */
    public void add(int index , Object data){
        Node New = new Node(data);
        if(head == null && index == 0){
            head = New;
            tail = New;
        }
        else if( index < 0 || index > size || (head == null && index != 0)){
                System.out.println("Error");
                System.exit(0);
            }
        else if (index == 0 && head != null ){
            New.next = head;
            head = New;
        }
        else{
            Node current = head;
            for(int i = 0 ; i < index-1 ; i ++ ){
                current = current.next;
            }
            New.next = current.next;
            current.next = New;
        }
        size++;
    }
        
    /**
     *
     * @param index
     * @return
     */
    public Object get(int index){
            if(index < size && index >= 0 && head != null){
                Node current = head;
                for(int i = 0 ; i < index ; i ++ )
                {
                    current = current.next;
                }
                return current.data;
            }
            else {
                System.out.println("Error");
                System.exit(0);
            }
            return 0;
        }
    
    /**
     *
     */
    public void clear(){
            head = null;
            tail = null;
            size = 0;
        }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
            return head==null;
        }
        
    /**
     *
     * @param index
     */
    public void remove(int index){
            Node current = head;
            if(index == 0 && head != null){
                head = current.next;
            }
            else if (index < size && head != null && index > 0){
                Node temp = null;
                for(int i = 0; i < index; i++){
                    temp = current;
                    current = current.next;
                }
                temp.next = current.next;
            }
            else{
                System.out.print("Error");
                System.exit(0);
            }
            size--;
        }
        
    /**
     *
     * @return
     */
    public int size(){
            return size;
        }
}

/**
 *
 * @author Islam
 */
class MyStack{

    /**
     *
     */
    public static SingleLinkedList List = new SingleLinkedList();
    
    /**
     *
     */
    public void print(){
        List.print();
    }
    
    /**
     *
     * @return
     */
    public Object pop(){
        if(List.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
        Object temp = List.get(0);
        List.remove(0);
        return temp;
    }
    
    /**
     *
     * @return
     */
    public Object peek(){
        if(List.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
        return List.get(0);
    }
    
    /**
     *
     * @param element
     */
    public void push(Object element){
        List.add(0,element);
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return List.isEmpty();
    }
     
    /**
     *
     * @return
     */
    public int size(){
        return List.size();
    }
}

/**
 *
 * @author Islam
 */
interface IExpressionEvaluator {
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression infix expression
* @return postfix expression
*/
public String infixToPostfix(String expression);
/**
* Evaluate a postfix numeric expression, with a single space separator
* @param expression postfix expression
* @return the expression evaluated value
*/
public int evaluate(String expression);
}

/**
 *
 * @author Islam
 */
public class Evaluator implements IExpressionEvaluator {
    
    /**
     *
     */
    public static int a;

    /**
     *
     */
    public static int b;

    /**
     *
     */
    public static int c;
    
    /**
     *
     * @param operator
     * @return
     */
    public int precedence(char operator){                //finds the precedence of the operator
        if(operator == '^')
            return 2;
        else if(operator == '*' || operator == '/')
            return 1;
        else
            return 0;
    }
    
    /**
     *
     * @param expression
     */
    public void CheckValidity(String expression){        //checks if the infix expression is valid or not
        
        if(expression.charAt(0) == '*' || expression.charAt(0) == '/' || expression.charAt(0) == '^' || expression.charAt(0) == ')'){
            System.out.print("Error");
            System.exit(0);
        }
        if(expression.charAt(expression.length() - 1) != 'a' && expression.charAt(expression.length() - 1) != 'b' && expression.charAt(expression.length() - 1) != 'c' && expression.charAt(expression.length() - 1) != ')'){
            System.out.print("Error");
            System.exit(0);
        }
        MyStack parentheses = new MyStack();
        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) == '(')
                parentheses.push('(');
            else if(expression.charAt(i) == ')')
                parentheses.pop();
        }
        if(!parentheses.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) != 'a' && expression.charAt(i) != 'b' && expression.charAt(i) != 'c' && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) != '^' && expression.charAt(i) != '(' && expression.charAt(i) != ')'){
                System.out.print("Error");
                System.exit(0);
            }
        }
        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) == '+'){
                if(expression.charAt(i+1) == '*' || expression.charAt(i+1) == '^' || expression.charAt(i+1) == '/' || expression.charAt(i+1) == ')'){
                    System.out.print("Error");
                    System.exit(0);
                }
            }
        }
    }
    
    /**
     *
     * @param expression
     * @return
     */
    public String ModifyInfix(String expression){        //modify the infix expression into the simplest form
        for(int i = 0 ; i < expression.length(); i++){
            if(expression.charAt(i) == '-' && expression.charAt(i+1) == '-')
                expression = expression.substring(0,i) + '+' + expression.substring(i+2);
        }
        while(expression.charAt(0) == '+'){
            expression = expression.substring(1);
        }
        for(int i = 0 ; i < expression.length(); i++){
            if((expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '^') && expression.charAt(i+1) == '+')
                expression = expression.substring(0,i+1) + expression.substring(i+2);
        }
        return expression;
    }
    
    
    
    public String infixToPostfix(String expression){
        
        String Postfix = "";
        MyStack Stack = new MyStack();
        for(int i = 0 ; i < expression.length(); i++){
            if(expression.charAt(i) == 'a' || expression.charAt(i) == 'b' || expression.charAt(i) == 'c'){
                Postfix += expression.charAt(i);
            }
            else if(expression.charAt(i) == '('){
                Stack.push('(');
            }
            else if(expression.charAt(i) == ')'){
                while((char)Stack.peek() != '('){
                    Postfix += Stack.pop();
                }
                Stack.pop();
            }
            else if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '^'){
                if(Stack.isEmpty() || (char)Stack.peek() == '('){
                    Stack.push(expression.charAt(i));
                }
                else{
                    while(!Stack.isEmpty() && (char)Stack.peek() != '('){
                        if( precedence(expression.charAt(i)) > precedence((char)Stack.peek()) ){
                            Stack.push(expression.charAt(i));
                            break;
                        }
                        else{
                            Postfix += Stack.pop();
                            if(Stack.isEmpty() || (char)Stack.peek() == '('){
                                Stack.push(expression.charAt(i));
                                break;
                            }
                        }
                    }
                }
            }   
        }
        
        while(!Stack.isEmpty())
            Postfix += Stack.pop();
        return Postfix;
    }
    
    
    
    public int evaluate(String expression){
        MyStack Stack = new MyStack();
        int result = 0;
        int temp;
        int temp1;
        if(expression.equals("a"))
            return a;
        if(expression.equals("b"))
            return b;
        if(expression.equals("c"))
            return c;
        for(int i = 0 ; i < expression.length() ; i++){
            switch(expression.charAt(i)){
                case 'a':
                    Stack.push(a);
                    break;
                case 'b':
                    Stack.push(b);
                    break;
                case 'c':
                    Stack.push(c);
                    break;
                case '+':
                    result = (int)Stack.pop() + (int)Stack.pop();
                    Stack.push(result);
                    break;
                case '-':
                    result = -(int)Stack.pop();
                    if(!Stack.isEmpty())
                        result +=  (int)Stack.pop();
                    Stack.push(result);
                    break;
                case '*':
                    result = (int)Stack.pop() * (int)Stack.pop();
                    Stack.push(result);
                    break;
                case '/':
                    temp = (int)Stack.pop();
                    temp1 = (int)Stack.pop();
                    result = temp1 / temp;
                    Stack.push(result);
                    break;
                case '^':
                    temp = (int)Stack.pop();
                    temp1 = (int)Stack.pop();
                    result = (int)Math.pow(temp1,temp);
                    Stack.push(result);
                    break;
                default:
                    System.out.print("Error");
                    System.exit(0);
                    break;
            }
        }
        return result;
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Evaluator Obj = new Evaluator();
        Scanner Input = new Scanner(System.in);
        String infix = Input.nextLine();
        String A = Input.nextLine();
        String B = Input.nextLine();
        String C = Input.nextLine();
        A = A.substring(2);
        B = B.substring(2);
        C = C.substring(2);
        a = Integer.parseInt(A);
        b = Integer.parseInt(B);
        c = Integer.parseInt(C);
        Obj.CheckValidity(infix);
        String Infix = Obj.ModifyInfix(infix);
        String Postfix = Obj.infixToPostfix(Infix);
        System.out.println(Postfix);
        System.out.println(Obj.evaluate(Postfix));
    }
}