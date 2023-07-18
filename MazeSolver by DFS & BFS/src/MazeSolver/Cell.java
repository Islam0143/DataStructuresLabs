
package MazeSolver;


public class Cell {
    int x;
    int y;
    Cell parent;
    public Cell(int x,int y,Cell parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
}
