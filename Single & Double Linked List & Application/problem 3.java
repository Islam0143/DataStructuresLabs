import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
public void print();
public void add(int index, Object element);             
public void add(Object element);
public Object get(int index);
public void set(int index, Object element);
public void clear();
public boolean isEmpty();
public void remove(int index);
public int size();
public ILinkedList sublist(int fromIndex, int toIndex);
public boolean contains(Object o);
}

class SingleLinkedList implements ILinkedList {
        
        class Node{
            Object data;
            Node next;
            
            public Node(Object data){          // making Constructor
                this.data = data;              // this method 
            }
            
        }
        
        
        public Node head = null;
        public Node tail = null;
        public int size = 0;
        public static int doneR = 0;
        public static int doneA = 0;
        public static int doneS = 0;
        public static int doneB = 0;

        
        
        //print method
        public void print(){
            Node current = head;
            System.out.print("[");
            while(current != null)
            {
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
            else
            {
                Node current;
                tail = head;
                current = null;
                
                for(int i = 0 ; i < index ; i ++ )                // ***
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
                return tail.data;
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
            size = 0;
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
}
        

interface IPolynomialSolver {
    /**
    * Set polynomial terms (coefficients & exponents)
    * @param poly: name of the polynomial
    * @param terms: array of [coefficients][exponents]
    */
    void setPolynomial(char poly, int[][] terms);
  
    /**
    * Print the polynomial in ordered human readable representation
    * @param poly: name of the polynomial
    * @return: polynomial in the form like 27x^2+x-1
    */
    String print(char poly);
  
    /**
    * Clear the polynomial
    * @param poly: name of the polynomial
    */
     void clearPolynomial(char poly);
  
    /**
    * Evaluate the polynomial
    * @param poly: name of the polynomial
    * @param value: the polynomial constant value
    * @return the value of the polynomial
    */
    float evaluatePolynomial(char poly, float value);
  
    /**
    * Add two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial
    */
    int[][] add(char poly1, char poly2);
  
    /**
    * Subtract two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial*/
    int[][] subtract(char poly1, char poly2);
  
    /**
    * Multiply two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return: the result polynomial
    */
    int[][] multiply(char poly1, char poly2);
}


public class PolynomialSolver implements IPolynomialSolver {
    
    public static SingleLinkedList a = new SingleLinkedList();
    public static SingleLinkedList b = new SingleLinkedList();
    public static SingleLinkedList c = new SingleLinkedList();
    public static SingleLinkedList R = new SingleLinkedList();
    
     //method 1
    public void setPolynomial(char poly, int[][] terms)
    {
        if(terms.length == 0){
            System.out.print("Error");
            System.exit(0);
        }
        switch(poly)
            {
                case 'A':
                    a.clear();
                    for(int i = 0 ; i < terms.length ; i++)
                    {
                        a.add(terms[i][0]);
                        
                    }
                    break;
                
                case 'B':
                    b.clear();
                    for(int i = 0 ; i < terms.length ; i++)
                    {
                        b.add(terms[i][0]);
                    }
                    break;
                
                case 'C':
                    c.clear();
                    for(int i = 0 ; i < terms.length ; i++)
                    {
                        c.add(terms[i][0]);
                    }
                    break;
                case 'R':
                    R.clear();
                    for(int i = 0 ; i < terms.length ; i++)
                    {
                        R.add(terms[i][0]);
                    }
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        
    }
    
    
    
    
    public String print(char poly)
    {
        String out = "";  
        switch(poly)
        {
        
            case 'A':
                if(a.isEmpty()){
                    System.out.print("Error");
                    System.exit(0);
                }
                int sizeA = a.size();
                int indexA = 0;
                String ResA = "" ;
                for(int e = sizeA-1 ; e>=0 ; e--)
                {    
                        if(e == 1 && ((int)a.get(indexA)) == 1)
                        {
                            ResA = ResA + "x";                        
                        }
                        
                        else if(e == 0 && ((int)a.get(indexA)) != 0)
                        {
                            ResA = ResA + ((int)a.get(indexA));
                        }
                        else if ( e == 1 && ((int)a.get(indexA)) != 1 && ((int)a.get(indexA)) != 0 )
                        {
                            ResA = ResA +  ((int)a.get(indexA)) + "x";
                        }
                        else if(e != 0 && e != 1 && ((int)a.get(indexA)) != 0 )
                        {
                            if(((int)a.get(indexA)) == 1)
                                ResA = ResA + "x^" +e;
                            else
                                ResA = ResA + ((int)a.get(indexA)) + "x^" +e;
                        }
                        
                    
                    if(e != 0 && (int)a.get(indexA) != 0)
                        {
                            if(((int)a.get(indexA+1)) > 0)
                                ResA = ResA + "+";
                        }
                        
                    indexA ++;
                    
                }
                return ResA;
                
                
                
           case 'B':
                if(b.isEmpty()){
                    System.out.print("Error");
                    System.exit(0);
                }
                if(!(b.isEmpty()))
                { 
                        int sizeB = b.size();
                        int indexB = 0;
                        String ResB = "" ;
                        for(int e = sizeB-1 ; e>=0 ; e--)
                        {    
                                if(e == 1 && ((int)b.get(indexB)) == 1)
                                {
                                    ResB = ResB + "x";                        
                                }
                                
                                else if(e == 0 && ((int)b.get(indexB)) != 0)
                                {
                                    ResB = ResB + ((int)b.get(indexB));
                                }
                                else if ( e == 1 && ((int)b.get(indexB)) != 1 && ((int)b.get(indexB)) != 0 )
                                {
                                    ResB= ResB +  ((int)b.get(indexB)) + "x";
                                }
                                else if(e != 0 && e != 1 && ((int)b.get(indexB)) != 0 )
                                {
                                    if(((int)b.get(indexB)) == 1)
                                        ResB = ResB + "x^" +e;
                                    else
                                        ResB = ResB + ((int)b.get(indexB)) + "x^" +e;
                                }
                                
                            
                            if(e != 0 && (int)b.get(indexB) != 0)
                                {
                                    if(((int)b.get(indexB+1)) > 0)
                                        ResB = ResB + "+";
                                }
                                
                            indexB ++;
                        }
                        return  ResB;
                }
                else 
                {
                    System.out.println("Error");
                }
                break;
                
            case 'C':
                if(c.isEmpty()){
                    System.out.print("Error");
                    System.exit(0);
                }
                int sizeC = c.size();
                int indexC = 0;
                String ResC = "" ;
                for(int e = sizeC-1 ; e>=0 ; e--)
                {    
                        if(e == 1 && ((int)c.get(indexC)) == 1)
                        {
                            ResC = ResC + "x";                        
                        }
                        
                        else if(e == 0 && ((int)c.get(indexC)) != 0)
                        {
                            ResC = ResC + ((int)c.get(indexC));
                        }
                        else if ( e == 1 && ((int)c.get(indexC)) != 1 && ((int)c.get(indexC)) != 0 )
                        {
                            ResC = ResC +  ((int)c.get(indexC)) + "x";
                        }
                        else if(e != 0 && e != 1 && ((int)c.get(indexC)) != 0 )
                        {
                            if(((int)c.get(indexC)) == 1)
                                ResC = ResC + "x^" +e;
                            else
                                ResC = ResC + ((int)c.get(indexC)) + "x^" +e;
                        }
                        
                    
                    if(e != 0 && (int)c.get(indexC) != 0)
                        {
                            if(((int)c.get(indexC+1)) > 0)
                                ResC = ResC + "+";
                        }
                        
                    indexC ++;
                }
                return ResC;
                
                
                
            case 'R':
                if(R.isEmpty()){
                    System.out.print("Error");
                    System.exit(0);
                }
                int sizeR = R.size();                      
                int indexR = 0;
                String Res = "" ;
                for(int e = sizeR-1 ; e>=0 ; e--)
                {    
                        if(e == 1 && ((int)R.get(indexR)) == 1)
                        {
                            Res = Res + "x";                        
                        }
                        
                        else if(e == 0 && ((int)R.get(indexR)) != 0)
                        {
                            Res = Res + ((int)R.get(indexR));
                        }
                        else if ( e == 1 && ((int)R.get(indexR)) != 1 && ((int)R.get(indexR)) != 0 )
                        {
                            Res = Res +  ((int)R.get(indexR)) + "x";
                        }
                        else if(e != 0 && e != 1 && ((int)R.get(indexR)) != 0 )
                        {
                            if(((int)R.get(indexR)) == 1)
                                Res = Res + "x^" +e;
                            else
                                Res = Res + ((int)R.get(indexR)) + "x^" +e;
                        }
                        
                    
                    if(e != 0 && (int)R.get(indexR) != 0)
                        {
                            if(((int)R.get(indexR+1)) > 0)
                                Res = Res + "+";
                        }
                        
                    indexR ++;
                }
                return  Res;
                
            default:
                System.out.print("Error");
                System.exit(0);
                
                
                   
        }
        return out;
        
        
        
                                    
    }
    
    
    //method3
    public void clearPolynomial(char poly){
        if(poly == 'A')
            a.clear();
        else if(poly == 'B')
            b.clear();
        else if(poly == 'C')
            c.clear();
        else if(poly == 'R')
            R.clear();
        else{
            System.out.print("Error");
            System.exit(0);
        }
        
    }
    

    
    //method 4 
    public float evaluatePolynomial(char poly, float value){
        float result=0;
        int exp;
        switch(poly){
            case 'A':
                exp = a.size()-1;
                for(int i = 0; i < a.size(); i++){
                    result += (int)a.get(i) * Math.pow(value, exp--);
                }
                break;
            case 'B':
                exp = b.size()-1;
                for(int i = 0; i < b.size(); i++){
                    result += ((int)b.get(i))*Math.pow(value , exp--);
                }
                break;
            case 'C':
                exp = c.size()-1;
                for(int i = 0; i < c.size(); i++){
                    result += ((int)c.get(i))*Math.pow(value , exp--);
                }
                break;
            default:
                System.out.print("Error");
                System.exit(0);
                break;
        }
        return result;
    }
    
    
    
    //method 5
    public int[][] add(char poly1, char poly2){
        if((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')){
        if(a.isEmpty() || b.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
            if(a.size() == b.size()){
                for(int i = 0; i < a.size(); i++){
                    R.add((int)a.get(i) + (int)b.get(i));
                }
            }
            else if(a.size() > b.size()){
                for(int i = 0; i < a.size() - b.size(); i++){
                    R.add((int)a.get(i));
                }
                for(int i = 0; i < b.size(); i++){
                    R.add((int)a.get(i + a.size() - b.size()) + (int)b.get(i));
                }
            }
            else if(a.size() < b.size()){
                for(int i = 0; i < b.size() - a.size(); i++){
                    R.add((int)b.get(i));
                }
                for(int i = 0; i < a.size(); i++){
                    R.add((int)a.get(i) + (int)b.get(i + b.size() - a.size()));
                }
            }
        }
        
        
        else if((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')){
        if(a.isEmpty() || c.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
            if(a.size() == c.size()){
                for(int i = 0; i < a.size(); i++){
                    R.add((int)a.get(i) + (int)c.get(i));
                }
            }
            else if(a.size() > c.size()){
                for(int i = 0; i < a.size() - c.size(); i++){
                    R.add((int)a.get(i));
                }
                for(int i = 0; i < c.size(); i++){
                    R.add((int)a.get(i + a.size() - c.size()) + (int)c.get(i));
                }
            }
            else if(a.size() < c.size()){
                for(int i = 0; i < c.size() - a.size(); i++){
                    R.add((int)c.get(i));
                }
                for(int i = 0; i < a.size(); i++){
                    R.add((int)a.get(i) + (int)c.get(i + c.size() - a.size()));
                }
            }
        }
        
        
        else if((poly1 == 'B' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'B')){
        if(c.isEmpty() || b.isEmpty()){
            System.out.print("Error");
            System.exit(0);
        }
            if(b.size() == c.size()){
                for(int i = 0; i < a.size(); i++){
                    R.add((int)b.get(i) + (int)c.get(i));
                }
            }
            else if(b.size() > c.size()){
                for(int i = 0; i < b.size() - c.size(); i++){
                    R.add((int)b.get(i));
                }
                for(int i = 0; i < c.size(); i++){
                    R.add((int)b.get(i + b.size() - c.size()) + (int)c.get(i));
                }
            }
            else if(b.size() < c.size()){
                for(int i = 0; i < c.size() - b.size(); i++){
                    R.add((int)c.get(i));
                }
                for(int i = 0; i < b.size(); i++){
                    R.add((int)b.get(i) + (int)c.get(i + c.size() - b.size()));
                }
            }
        }
        else{
            System.out.print("Error");
            System.exit(0);
        }
        int[][] res = new int[R.size()][1];
        for(int i = 0; i < R.size; i++)
            res[i][0] = (int)R.get(i);
        return res;
    }
    
    
    
    //method 6
    /*
    public int[][] subtract(char poly1, char poly2){
        int[][] res = new int[][]{};
        if(poly1 == 'A' && poly2 == 'B'){
            if(a.size() > b.size()){
                
            }
        }
    }
    */
    
        
    //method 6
    
    public int[][] subtract(char poly1, char poly2){
        if((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')){
            if(a.isEmpty() || b.isEmpty()){
                System.out.print("Error");
                System.exit(0);
            }
            if(a.size() == b.size()){
                for(int i = 0; i < a.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i) - (int)b.get(i));
                    else
                        R.add((int)b.get(i) - (int)a.get(i));
                }
            }
            else if(a.size() > b.size()){
                for(int i = 0; i < a.size() - b.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i));
                    else
                        R.add(-(int)a.get(i));
                }
                for(int i = 0; i < b.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i + a.size() - b.size()) - (int)b.get(i));
                    else
                        R.add(-(int)a.get(i + a.size() - b.size()) + (int)b.get(i));
                }
            }
            else if(a.size() < b.size()){
                for(int i = 0; i < b.size() - a.size(); i++){
                    if(poly1 == 'A')
                        R.add(-(int)b.get(i));
                    else
                        R.add((int)b.get(i));
                }
                for(int i = 0; i < a.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i) - (int)b.get(i + b.size() - a.size()));
                    else
                        R.add(-(int)a.get(i) + (int)b.get(i + b.size() - a.size()));
                }
            }
        }
        
        else if((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')){
            if(a.isEmpty() || c.isEmpty()){
                System.out.print("Error");
                System.exit(0);
            }
            if(a.size() == c.size()){
                for(int i = 0; i < a.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i) - (int)c.get(i));
                    else
                        R.add(-(int)a.get(i) + (int)c.get(i));
                }
            }
            else if(a.size() > c.size()){
                for(int i = 0; i < a.size() - c.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i));
                    else
                        R.add(-(int)a.get(i));
                }
                for(int i = 0; i < c.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i + a.size() - c.size()) + (int)c.get(i));
                    else
                        R.add(-(int)a.get(i + a.size() + c.size()) + (int)c.get(i));
                }
            }
            else if(a.size() < c.size()){
                for(int i = 0; i < c.size() - a.size(); i++){
                    if(poly1 == 'A')
                        R.add(-(int)c.get(i));
                    else
                        R.add((int)c.get(i));
                }
                for(int i = 0; i < a.size(); i++){
                    if(poly1 == 'A')
                        R.add((int)a.get(i) - (int)c.get(i + c.size() - a.size()));
                    else
                        R.add(-(int)a.get(i) + (int)c.get(i + c.size() - a.size()));
                }
            }
        }
        
        
        else if((poly1 == 'B' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'B')){
            if(b.isEmpty() || c.isEmpty()){
                System.out.print("Error");
                System.exit(0);
            }
            if(b.size() == c.size()){
                for(int i = 0; i < a.size(); i++){
                    if(poly1 == 'B')
                        R.add((int)b.get(i) - (int)c.get(i));
                    else
                        R.add(-(int)b.get(i) + (int)c.get(i));
                }
            }
            else if(b.size() > c.size()){
                for(int i = 0; i < b.size() - c.size(); i++){
                    if(poly1 == 'B')
                        R.add((int)b.get(i));
                    else
                        R.add(-(int)b.get(i));
                }
                for(int i = 0; i < c.size(); i++){
                    if(poly1 == 'B')
                        R.add((int)b.get(i + b.size() - c.size()) - (int)c.get(i));
                    else
                        R.add(-(int)b.get(i + b.size() - c.size()) + (int)c.get(i));
                }
            }
            else if(b.size() < c.size()){
                for(int i = 0; i < c.size() - b.size(); i++){
                    if(poly1 == 'B')
                        R.add(-(int)c.get(i));
                    else
                        R.add((int)c.get(i));
                }
                for(int i = 0; i < b.size(); i++){
                    if(poly1 == 'B')
                        R.add((int)b.get(i) - (int)c.get(i + c.size() - b.size()));
                    else
                        R.add(-(int)b.get(i) + (int)c.get(i + c.size() - b.size()));
                }
            }
        }
        else{
            System.out.print("Error");
            System.exit(0);
        }
        int[][] res = new int[R.size()][1];
        for(int i = 0; i < R.size; i++)
            res[i][0] = (int)R.get(i);
        return res;
    }
    
    
    
    
    //method 7
    public int[][] multiply(char poly1, char poly2){
        int[][] aro = new int[][]{};
        if((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A'))
        {
            if(a.isEmpty() || b.isEmpty()){
                System.out.print("Error");
                System.exit(0);
            }
            int[][] res = new int[a.size() + b.size() - 1][1];
            for(int i =0 ; i < res.length ; i++)
                res[i][0] = 0;
            for(int i = a.size() - 1 ; i >= 0 ; i--)
            {
                for(int j = b.size() - 1 ; j >= 0 ;j--)
                {
                    res[i+j][0] += (int)a.get(i) * (int)b.get(j);
                }
            }
            return res;
        }
        
        else if((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A'))
        {
            if(a.isEmpty() || c.isEmpty()){
                System.out.print("Error");
                System.exit(0);
            }
            int[][] res1 = new int[a.size() + c.size() - 1][1];
            for(int i =0 ; i < res1.length ; i++)
                res1[i][0] = 0;
            for(int i = a.size() - 1 ; i >= 0 ; i--)
            {
                for(int j = c.size() - 1 ; j >= 0 ;j--)
                {
                    res1[i+j][0] += (int)a.get(i) * (int)c.get(j);
                }
            }
            return res1;
        }
        
        
        else if((poly1 == 'B' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'B'))
        {
            if(c.isEmpty() || b.isEmpty()){
                System.out.print("Error");
                System.exit(0);
            }
            int[][] res2 = new int[b.size() + c.size() - 1][1];
            for(int i =0 ; i < res2.length ; i++)
                res2[i][0] = 0;
            for(int i = b.size() - 1 ; i >= 0 ; i--)
            {
                for(int j = c.size() - 1 ; j >= 0 ;j--)
                {
                    res2[i+j][0] += (int)b.get(i) * (int)c.get(j);
                }
            }
            return res2;
        }
        System.out.print("Error");
        System.exit(0);
        
        
        return aro;
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        
        PolynomialSolver polynomial = new PolynomialSolver(); 
        
        Scanner Input = new Scanner(System.in);
        
        String method = Input.nextLine();                            // taking the method from the user
        char poly;                                                    // poly to work on
        float value;
        
        while (method.equals("set")  || method.equals("eval") || method.equals("add") || method.equals("sub") || method.equals("mult") || method.equals("print") || method.equals("clear"))
        {
            switch(method)
            {
                case "set":

                    poly = Input.next().charAt(0);

                        switch(poly)
                        {
                            case 'A':

                                String s1 = Input.next().replaceAll("\\[|\\]", "");
                                String[] S1 = s1.split(",");

                                int[][] arr1 = new int[S1.length][1];
                                if (S1.length == 1 && S1[0].isEmpty())
                                {
                                    arr1 = new int[][]{};
                                }   
                                else 
                                {
                                    for(int i = 0; i < S1.length; i++)
                                        arr1[i][0] = Integer.parseInt(S1[i]);
                                }

                                polynomial.setPolynomial(poly,arr1);
                                break;

                            case 'B':

                                String s2 = Input.next().replaceAll("\\[|\\]", "");
                                String[] S2 = s2.split(",");

                                int[][] arr2 = new int[S2.length][1];
                                if (S2.length == 1 && S2[0].isEmpty())
                                    arr2 = new int[][]{};
                                else 
                                {
                                    for(int i = 0; i < S2.length; i++)
                                        arr2[i][0] = Integer.parseInt(S2[i]);
                                }
                                polynomial.setPolynomial(poly,arr2);
                                break;

                            case 'C':

                                String s3 = Input.next().replaceAll("\\[|\\]", "");
                                String[] S3 = s3.split(",");

                                int[][] arr3 = new int[S3.length][1];
                                if (S3.length == 1 && S3[0].isEmpty())
                                    arr3 = new int[][]{};
                                else 
                                {
                                    for(int i = 0; i < S3.length; i++)
                                        arr3[i][0] = Integer.parseInt(S3[i]);
                                }
                                polynomial.setPolynomial(poly,arr3);
                                break;

                            default :
                                System.out.println("Error");
                                break;
                        }
                    break;
                case "print":
                    poly = Input.next().charAt(0);
                    switch(poly)
                    {
                    case 'A':
                        String res1 =polynomial.print(poly);
                        System.out.println(res1);
                        break;
                    case 'B':
                        String res4 =polynomial.print(poly);
                        System.out.println(res4);
                        break;
                    case 'C':
                        String res3 =polynomial.print(poly);
                        System.out.println(res3);
                        break;
                    case 'R':
                        String res2 =polynomial.print(poly);
                        System.out.println(res2);
                        break;
                    }
                    
                    break;
                case "eval":
                    poly = Input.next().charAt(0);
                    value = Input.nextFloat();
                    if(poly == 'A' || poly == 'B' || poly == 'C')
                        System.out.print((int)polynomial.evaluatePolynomial(poly,value));
                    else{
                        System.out.print("Error");
                        System.exit(0);
                    }
                    break;
                case "clear":
                    poly = Input.next().charAt(0);
                    if(poly == 'A' || poly == 'B' || poly == 'C'){
                        polynomial.clearPolynomial(poly);
                        System.out.print("[]");
                    }
                    else{
                        System.exit(0);
                    }
                    break;
                case "add":
                    char poly1;
                    poly1 = Input.next().charAt(0);
                    char poly2;
                    poly2 = Input.next().charAt(0);
                    int[][] res = polynomial.add(poly1,poly2);
                    polynomial.setPolynomial('R',res);
                    System.out.print(polynomial.print('R'));
                    break;
                case "sub":
                    char poly11;
                    poly11 = Input.next().charAt(0);
                    char poly22;
                    poly22 = Input.next().charAt(0);
                    int[][] res1 = polynomial.subtract(poly11,poly22);
                    polynomial.setPolynomial('R',res1);
                    System.out.print(polynomial.print('R'));
                    break;
                case "mult":
                    char poly111;
                    poly111 = Input.next().charAt(0);
                    char poly222;
                    poly222 = Input.next().charAt(0);
                    int[][] res2 = polynomial.multiply(poly111,poly222);
                    polynomial.setPolynomial('R',res2);
                    System.out.print(polynomial.print('R'));
                    break;
                default:
                    System.exit(0);
                    break;


                }
                try{
                method = Input.next();
                }
                catch(Exception e){
                    System.exit(0);
                }
        }
                System.out.print("Error");
               
    }
    
}