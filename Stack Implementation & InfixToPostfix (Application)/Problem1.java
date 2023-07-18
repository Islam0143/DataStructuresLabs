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
interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
    /**
     *
     * @return
     */
    public int size();
}

/**
 *
 * @author Islam
 */
public class MyStack implements IStack {
    
    /**
     *
     */
    public static SingleLinkedList List = new SingleLinkedList();
    
    //print method

    /**
     *
     */
    public void print(){
        List.print();
    }
    
    
    //method 1
    public Object pop(){
        if(List.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
        Object temp = List.get(0);
        List.remove(0);
        return temp;
    }
    
    
    //method 2
    public Object peek(){
        if(List.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
        return List.get(0);
    }
    
    
    
    //method 3
    public void push(Object element){
        List.add(0,element);
    }
    
    
    
    //method 4
    public boolean isEmpty(){
        return List.isEmpty();
    }
    
    
    
    //method 5 

    /**
     *
     * @return
     */
    public int size(){
        return List.size();
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner Input = new Scanner(System.in);
        String S = Input.nextLine().replaceAll("\\[|\\]","");
        String[] s = S.split(", ");
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        
        MyStack Stack = new MyStack();
        for(int i = arr.length-1 ; i >=0 ; i--){
            Stack.push(arr[i]);
        }
        String method = Input.nextLine();
        switch(method){
            case "pop":
                Stack.pop();
                Stack.print();
                break;
            case "peek":
                System.out.print(Stack.peek());
                break;
            case "push":
                int data = Input.nextInt();
                Stack.push(data);
                Stack.print();
                break;
            case "isEmpty":
                if(Stack.isEmpty())
                    System.out.print("True");
                else
                    System.out.print("False");
                break;
            case "size":
                System.out.print(Stack.size());
                break;
            default:
                break;
        }
        
    }
}