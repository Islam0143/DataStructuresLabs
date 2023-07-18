import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
public void print();
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class DoubleLinkedList implements ILinkedList {
    
    
    class Node{
        Object data;
        Node next;
        Node prev;
        
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
    
    
    //method1
    public void add(int index , Object data){
        if(head != null && index == 0){
            Node New = new Node(data);
            New.next = head;
            head.prev = New;
            head = New;
            size++;
            doneA = 1;
        }
        else if(index == size){
            Node New = new Node(data);
            tail.next = New;
            New.prev = tail;
            tail = New;
            size++;
            doneA = 1;
        }
        else if(head == null && index == 0){
            Node New = new Node(data);
            head = New;
            tail = New;
            size++;
            doneA = 1;
        }
        else if(index < size && index > 0){
            Node New = new Node(data);
            Node current = head;
            Node temp = null;
            for(int i = 0; i < index ; i++){
                temp = current;
                current = current.next;
            }
            New.prev = temp;
            New.next = current;
            temp.next = New;
            current.prev = New;
            size++;
            doneA = 1;
        }
        else{
            System.out.print("Error");
        }
        
    }
    
    
    //method 2
    public void add(Object element){
        size++;
        Node New = new Node(element);
        if(head == null){
            head = New;
            tail = New;
        }
        else{
            tail.next = New;
            New.prev = tail;
            tail = New;
        }
    }
    
    
    //method3
    public Object get(int index){
        Node current = head;
        int counter = 0;
        if(index < size && index >= 0){
            while(current != null){
                if(counter == index){
                    return current.data;
                }
                counter++;
                current = current.next;
            }
        }
        else
            System.out.print("Error");
        return -1;
    }
    
    
    //method 4
    public void set(int index, Object element){
        Node current = head;
        int counter = 0;
        if(index < size && index >= 0){
            while(current != null){
                if(counter == index){
                    current.data = element;
                    doneS = 1;
                    return;
                }
                current = current.next;
                counter++;
            }
        }
        else
            System.out.print("Error");
        return;
    }
    
    
    
    //method 5
    public void clear(){
        head = null;
    }
    
    
    
    
    //method 6
    public boolean isEmpty(){
        return head == null;
    }
    
    
    
    //method 7
    public void remove(int index){
        if(index == 0 && head != null){
            head = head.next;
            head.prev = null;
            size--;
            doneR = 1;
        }
        else if(index == size - 1 && head != null){
            tail = tail.prev;
            tail.next = null;
            size--;
            doneR = 1;
        }
        else if(index > 0 && index < size - 1){
            int counter = 0;
            Node current = head;
            Node temp = null;
            while(current != null){
                if(counter == index){
                    temp.next = current.next;
                    temp.next.prev = temp;
                    size--;
                    doneR = 1;
                    return;
                }
                counter++;
                temp = current;
                current = current.next;
            }
        }
        else
            System.out.print("Error");
    }
    
    
    
    
    //method 8
    public int size(){
        return size;
    }
    
    
    
    //method 9
    public ILinkedList sublist(int fromIndex, int toIndex){
        ILinkedList list2 = new DoubleLinkedList();
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
        
        
        DoubleLinkedList list = new DoubleLinkedList();
        for(int i = 0;i < arr.length; i++){
            list.add(arr[i]);
        }
        
        
        
        
        switch(method){
            case "add":
                list.add(first);
                list.print();
                break;
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
            case "get":
                if((int)list.get(first) != -1)
                    System.out.print( list.get(first) );
                break;
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
            case "clear":
                list.clear();
                list.print();
                break;
            case "isEmpty":
                if(list.isEmpty() == false)
                    System.out.print("False");
                else
                    System.out.print("True");
                break;
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
            case "size":
                System.out.print(list.size());
                break;
            case "sublist":
                ILinkedList list2 = new DoubleLinkedList();
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
            case "contains":
                if(list.contains(first) == false)
                    System.out.print("False");
                else
                    System.out.print("True");
                break;
            default:
                break;
        }
        
    }
}