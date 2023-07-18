
package queue.linked;


public class SingleLinkedList {
        class Node{
            Object data;
            Node next;
            
            public Node(Object data){
                this.data = data;
            }
        }
        public Node head = null;
        public Node tail = null;
        public int size = 0;
        
    
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
    
    
    public void add(Object data){
        Node New = new Node(data);
        if(head == null){
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
        
        public Object get(int index){
            if(index < size && index >= 0 && head != null)
            {
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
    
        public void clear(){
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty(){
            return head==null;
        }
        
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
        
        public int size(){
            return size;
        }
}
