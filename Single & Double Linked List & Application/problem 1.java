import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
public void print();
/*
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);             
/*
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/*
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/*
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/*
* Removes all of the elements from this list.
*/
public void clear();
/*
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/*
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/*
* @return the number of elements in this list.
*/
public int size();
/*
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/*
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class SingleLinkedList implements ILinkedList {
  /* Implement your linked list class here*/
    
    class Node{
        Object data;
        Node next;
        
        public Node(Object data){          // making Constructor
            this.data = data;              // this method 
        }
        
    }
    
    
    public Node head = null;
    public Node tail = null;
    public static int size = 0;
    public static int doneR = 0;
    public static int doneA = 0;
    public static int doneS = 0;
    public static int doneB = 0;

    
    
    //print method
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
    
    
    // method 1
    public void add(int index , Object data){
        
        // first = index = count 
        // second = data
        
        Node New = new Node(data);
        if(head == null && index == 0){                       // case 1 : empty list
            head = New;
            tail = New;
            doneA = 1;
            size++;
        }
        else if( index < 0 || index > size || (head == null && index != 0))
            {
                System.out.println("Error");
                doneA = 0;
            }
        else if (index == 0 && head != null )
        {
            tail = head;
            head = New ;
            New.next = tail;
            doneA=1;
            size++;
            
        }
            
        else
        {
            Node current;
            tail = head;
            current = null;
            
            for(int i = 0 ; i < index ; i ++ )                
            {
                current = tail;
                tail=tail.next;
            }
            current.next = New;
            New.next = tail;
            doneA = 1;
            size++;
        }    
    }
    
    
    
    // method 2
    public void add(Object data){                 // append
        
        Node New = new Node(data);
        if(head == null){                       // case 1 : empty list
            head = New;
            tail = New;
        }
        else
        {
            tail.next = New;
            tail = New;
            tail.next = null;
        }
        size++;
    }
    
    
    //method 3
    /*
    public Object get(int index){
        int counter = 0;
        Node current = head;
        if(index < size && index >= 0 && head != null){
            while(current != null){
                if(counter == index){
                    System.out.print(current.data);
                    return current.data;
                }
                counter++;
                current = current.next;
            }
        }
        System.out.print("Error");
        return -1;
    }
    */
    
    // method 3
    public Object get(int index)  
    {
        /*
        System.out.println(value);
        return 0;
        */
        
        if(index < size && index >= 0 && head != null)
        {
            tail = head;
            for(int i = 0 ; i < index ; i ++ )
            {
                tail=tail.next;
            }
            System.out.println(tail.data);
        }
        else if(index >= size || index < 0 || head == null)
        {
            System.out.println("Error");
        }
        else 
        {
            System.out.println("Error");
        }
        return 0;
        
    }
    
    
    
    
    
    //method 4
    public void set(int index, Object data)
    {
        // first = index 
        // second = data
        
        if(size == 1 && index == 0){                    
            tail.data = data;
            doneS = 1;
            
        }
        else if (head == null || index >= size || index < 0)                                
        {
            System.out.println("Error");
            doneS = 0;
        }
        else if(index < size && index >= 0 && head != null)
        {
            tail = head;
            for(int i = 0 ; i < index ; i ++ )
            {
                tail=tail.next;
            }
            tail.data = data;
            doneS = 1;
        }
        else 
        {
            System.out.println("Error");
            doneS = 0;
        }
            
    }
    
    // method 5
    public void clear()
    {
        head = null;
    }

    
    //method 6
    public boolean isEmpty(){
        return head==null;
    }
    
    
    
    public void remove(int index){
        
        tail = head;
        
        if(index == 0 && head != null)
        {
            head = tail.next;
            size--;
            doneR = 1;
        }
        
        else if (index < size && head != null && index > 0)
        {
            Node current;
            current = null;
            
            for(int i =0; i < index; i++){
                current = tail;
                tail = tail.next;
            }
            current.next = tail.next;
            size--;
            doneR = 1;
        }
        else if (index < 0 || index >= size || head ==null)
        {
            System.out.print("Error");
            doneR = 0;
        }
        else
        {
            System.out.print("Error");
            doneR = 0;
        }
            
    }
    
    
    // method 8
    public int size()
    {
        return size;
    }
    
    
    
    //method 9
    public ILinkedList sublist(int fromIndex, int toIndex){
        ILinkedList list2 = new SingleLinkedList();
        int i=0;
        if(fromIndex >= size || toIndex >=size || head == null || fromIndex>toIndex || fromIndex < 0 || toIndex < 0)
        {
            System.out.println("Error");
            doneB = 0;            
        }
        else
        {
            Node current = head;
            for(i = 0;i < fromIndex; i++){
                current = current.next;
            }
            list2.add(current.data);
            while(i < toIndex){
                current = current.next;
                list2.add(current.data);
                i++;
            }
            doneB=1;
        }
        return list2;
        
    }
    
    
    
    //method 10
    public boolean contains(Object o){
        Node current = head;
        for(int i =0; i < size; i++){
            if(current.data == o){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
   
    
    
    public static void main(String[] args) {
        
        int first=0,second=0;
        
        Scanner input = new Scanner(System.in);                        // taking the input from the user "array" 
        String s = input.nextLine().replaceAll("\\[|\\]", "");
        String[] S = s.split(", ");
        
        String method = input.nextLine();                            // taking the method from the user
        
        switch(method){
            case "add":
                first = input.nextInt();
                break;
            case "get":
                first = input.nextInt();
                break;
            case "contains":
                first = input.nextInt();
                break;
            case "remove":
                first = input.nextInt();
                break;
            case "addToIndex":
                first = input.nextInt();
                second = input.nextInt();
                break;
            case "set":
                first = input.nextInt();
                second = input.nextInt();
                break;
            case "sublist":
                first = input.nextInt();
                second = input.nextInt();
                break;
            default:
                break;
        }
        
        Object[] arr = new Object[S.length];
        if (S.length == 1 && S[0].isEmpty())
            arr = new Object[]{};
        else {
            for(int i = 0; i < S.length; i++)
               arr[i] = Integer.parseInt(S[i]);
        }
 
        
        SingleLinkedList list = new SingleLinkedList();
        for(int i = 0;i < arr.length; i++){    
            list.add(arr[i]);
        }
        
        
       
        
        switch(method)
        {
            
                
            // method 1  
            case "addToIndex":
                list.add(first , second);
                switch (doneA)
                {
                    case 0 :
                        break;
                    case 1 :
                        list.print();
                        doneA = 0;
                        break;
                }
                break;  
                
            // method 2
            case "add":
                list.add(first);
                list.print();
                break;
                
            // method 3
            case "get":
                list.get(first);
                break;
            
            // method 4
            case "set":
                list.set(first,second);
                switch (doneS)
                {
                    case 0 :
                        break;
                    case 1 :
                        list.print();
                        doneS = 0;
                        break;
                }
                break;
                
            // method 5
            case "clear":
                list.clear();
                list.print();
                break;
            
            // method 6
            case "isEmpty":
                if(list.isEmpty() == false)
                    System.out.print("False");
                else
                    System.out.print("True");
                break;
            
            // method 7    
            case "remove":
                list.remove(first);
                switch (doneR)
                {
                    case 0 :
                        break;
                    case 1 :
                        list.print();
                        doneR = 0;
                        break;
                }
                break;
             
            case "contains":
                if(list.contains(first) == false)
                    System.out.print("False");
                else
                    System.out.print("True");
                break;
            
            
            case "sublist":
                ILinkedList list2 = new SingleLinkedList();
                list2 = list.sublist(first, second);
                switch (doneB)
                {
                    case 0 :
                        break;
                    case 1 :
                        list2.print();
                        doneB = 0;
                        break;
                }
                break;
            
            case "size":
                System.out.print(list.size());
                break;
            default:
                break;
        } 
    }
}