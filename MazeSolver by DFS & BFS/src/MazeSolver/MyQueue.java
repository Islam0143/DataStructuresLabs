
package MazeSolver;


public class MyQueue {
    
    SingleLinkedList List = new SingleLinkedList();

    
    public void print(){
        List.print();
    }
    
    
    public void enqueue(Object item){
        List.add(item);
    }
    
    
    public Object dequeue(){
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
