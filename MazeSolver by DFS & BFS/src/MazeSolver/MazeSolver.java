
package MazeSolver;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MazeSolver implements IMazeSolver{

    
    int rows,columns;
    public static int size = 0;
    char[][] map;
    static int[][] path;
    
    
    
    public int PathSize(Cell temp){
        int counter = 0;
        while(temp != null){
            temp = temp.parent;
            counter++;
        }
        return counter;
    }
    
    
    
    
    public void print(int[][] path){
        System.out.print("{" + path[0][0] + "," + path[0][1] + "}");
        for(int i = 1 ; i < size ; i++){
            System.out.print(",{" + path[i][0] + "," + path[i][1] + "}");
        }
        System.out.println();
    }
 
    
    
    public void FileReader(java.io.File maze) {
        try {
            Scanner Input = new Scanner(maze);
            rows = Input.nextInt();
            columns = Input.nextInt();
            map = new char[rows][columns];
            String Line;
            for(int i = 0 ; i < rows ; i++){
                Line = Input.next();
                for(int j = 0 ; j < columns ; j++){
                    map[i][j] = Line.charAt(j);
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
            System.exit(0);
        }
    }
    
    
    
    public int[][] solveBFS(java.io.File maze) {
        FileReader(maze);
        MyQueue Queue = new MyQueue();
        boolean flag = false;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                if(map[i][j] == 'S'){
                    Queue.enqueue(new Cell(j ,i ,null));
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        Cell C = null;
        while(!Queue.isEmpty()){
            C = (Cell)Queue.dequeue();
            if(map[C.y][C.x] == 'E'){
                break;
            }
            if(C.y + 1 < rows && map[C.y +1][C.x] != '#' && map[C.y + 1][C.x] != 'v'){
                if(map[C.y + 1][C.x] == '.')
                    map[C.y + 1][C.x] = 'v';
                Queue.enqueue(new Cell(C.x ,C.y + 1 ,C));
            }
            if(C.y - 1 >= 0 && map[C.y - 1][C.x] != '#' && map[C.y - 1][C.x] != 'v'){
                if(map[C.y - 1][C.x] == '.')
                    map[C.y - 1][C.x] = 'v';
                Queue.enqueue(new Cell(C.x ,C.y - 1 ,C));
            }
            if(C.x + 1 < columns && map[C.y][C.x + 1] != '#' && map[C.y][C.x + 1] != 'v'){
                if(map[C.y][C.x + 1] == '.')
                    map[C.y][C.x + 1] = 'v';
                Queue.enqueue(new Cell(C.x + 1 ,C.y ,C));
            }
            if(C.x - 1 >= 0 && map[C.y][C.x - 1] != '#' && map[C.y][C.x - 1] != 'v'){
                if(map[C.y][C.x - 1] == '.')
                    map[C.y][C.x - 1] = 'v';
                Queue.enqueue(new Cell(C.x - 1, C.y, C));
            }
        }
        if(map[C.y][C.x] != 'E'){
            System.out.println("No Path Found!");
            System.exit(0);
        }
        Cell temp = C;
        size = PathSize(temp);
        path = new int[size][2];
        for(int i = size - 1 ; i >= 0 ; i--){
            path[i][0] = C.y;
            path[i][1] = C.x;
            C = C.parent;
        }
        return path;
    }
    
    
    
    
    
    public int[][] solveDFS(java.io.File maze) {
        FileReader(maze);
        MyStack Stack = new MyStack();
        boolean flag = false;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                if(map[i][j] == 'S'){
                    Stack.push(new Cell(j ,i ,null));
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        Cell C = null;
        while(!Stack.isEmpty()){
            C = (Cell)Stack.pop();
            if(map[C.y][C.x] == '.')
                map[C.y][C.x] = 'v';
            if(map[C.y][C.x] == 'E')
                break;
            if(C.y -1 >= 0 && (map[C.y - 1][C.x] == '.' || map[C.y - 1][C.x] == 'E'))
                Stack.push(new Cell(C.x ,C.y - 1 ,C));
            if(C.x -1 >= 0 && (map[C.y][C.x - 1] == '.' || map[C.y][C.x - 1] == 'E'))
                Stack.push(new Cell(C.x - 1 ,C.y ,C));
            if(C.x +1 < columns && (map[C.y][C.x + 1] == '.' || map[C.y][C.x + 1] == 'E'))
                Stack.push(new Cell(C.x + 1 ,C.y ,C));
            if(C.y +1 < rows && (map[C.y + 1][C.x] == '.' || map[C.y + 1][C.x] == 'E'))
                Stack.push(new Cell(C.x ,C.y + 1 ,C));
        }
        if(map[C.y][C.x] != 'E'){
            System.out.println("No Path Found!");
            System.exit(0);
        }
        Cell temp = C;
        size = PathSize(temp);
        path = new int[size][2];
        for(int i = size - 1 ; i >= 0 ; i--){
            path[i][0] = C.y;
            path[i][1] = C.x;
            C = C.parent;
        }
        return path;
    }
    
    
    
    
        
    public static void main(String[] args) throws IOException {
        Scanner Input = new Scanner(System.in);
        int rows = Input.nextInt();
        int columns = Input.nextInt();
        java.io.File maze = new java.io.File("maze.txt");
        maze.createNewFile();
        FileWriter WR = new FileWriter("maze.txt");
        WR.write(rows + " " + columns + "\n");
        for(int i = 0; i < rows; i++){
            WR.write(Input.next() + "\n");
        }
        WR.close();
        path = new MazeSolver().solveBFS(maze);
        System.out.print("BFS: ");
        new MazeSolver().print(path);
        path = new MazeSolver().solveDFS(maze);
        System.out.print("DFS: ");
        new MazeSolver().print(path);
    }
}
