package queue.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MyQueue {

    public int front = 0;
    public int rear = 0;
    public int size = 0;
    public int MaxSize;
    public Object queue[];
    
    public MyQueue(int n){
        MaxSize = n;
        queue = new Object[n];
    }
    
    
    public void print(){
        System.out.print("[");
        for(int i = front ; i < rear; i++){
            System.out.print(queue[i]);
            if(i+1 != rear)
                System.out.print(", ");
        }
        System.out.print("]");
    }
    
    
    public void enqueue(Object item){
        if(size == MaxSize){
            System.out.print("Error");
            System.exit(0);
        }
        queue[rear] = item;
        rear = (rear + 1) % MaxSize;
        size++;
    }
    
    
    public Object dequeue(){
        if(size == 0){
            System.out.print("Error");
            System.exit(0);
        }
        Object temp = queue[front];
        queue[front] = null;
        front = (front + 1) % MaxSize;
        size--;
        return temp;
    }
    
    
    public boolean isEmpty(){
        return size == 0;
    }

    
    
    public int size(){
        return size;
    }
    
    
    public static void main(String[] args) {
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
        
        MyQueue Queue = new MyQueue(1000);
        for(int i = 0; i < arr.length; i++)
            Queue.enqueue(arr[i]);
        
        String method = Input.nextLine();
        switch(method){
            case "enqueue":
                int item = Input.nextInt();
                Queue.enqueue(item);
                Queue.print();
                break;
            case "dequeue":
                Queue.dequeue();
                Queue.print();
                break;
            case "isEmpty":
                if(Queue.isEmpty())
                    System.out.print("True");
                else
                    System.out.print("False");
                break;
            case "size":
                System.out.print(Queue.size());
                break;
            default:
                System.out.print("Error");
                System.exit(0);
                break;
        }
        
    }
    
}
