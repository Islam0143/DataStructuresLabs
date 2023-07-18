
package queue.linked;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MyQueue implements IQueue{
    
    public static SingleLinkedList List = new SingleLinkedList();

    
    public void print(){
        List.print();
    }
    
    
    public void enqueue(Object item){
        List.add(item);
    }
    
    
    public Object dequeue(){
        if(List.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
        Object temp = List.get(0);
        List.remove(0);
        return temp;
    }

    
    public boolean isEmpty(){
        return List.isEmpty();
    }
    
    
    public int size(){
        return List.size();
    }
    
    

    
}
