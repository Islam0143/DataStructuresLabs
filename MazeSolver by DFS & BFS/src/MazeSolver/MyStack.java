
package MazeSolver;


public class MyStack {
    
    SingleLinkedList List = new SingleLinkedList();
    
    public void print(){
        List.print();
    }
    
    
    public Object pop(){
        Object temp = List.get(0);
        List.remove(0);
        return temp;
    }
    
    
    public Object peek(){
        return List.get(0);
    }
    
    
    public void push(Object element){
        List.add(0,element);
    }
    
    
    public boolean isEmpty(){
        return List.isEmpty();
    }
    
    
    public int size(){
        return List.size();
    }
}
