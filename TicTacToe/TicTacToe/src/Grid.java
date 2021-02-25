import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle grid;
    private final int cols = 3;
    private final int rows = 3;
    private Cell cell;

    Cell[][] cellArray;


    public Grid () {

    }

    public void gridInit() {
        cellArray = new Cell[cols][rows];
        for (int i = 0; i < cols ; i++) {
            for (int j = 0; j < rows ; j++) {
                cellArray[i][j] = new Cell(i,j);
            }
        }
    }
    public Cell[][] getCellArray() {
        return cellArray;
    }
}
