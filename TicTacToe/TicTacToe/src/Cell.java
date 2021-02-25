import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Cell {

    private Rectangle cell;
    public static final int PADDING = 10;
    private int cellSize = 200;
    private int col;
    private int row;

    private boolean painted;


    public Cell (int col, int row) {
        painted = false;
        this.col= col;
        this.row = row;
        cell = new Rectangle((col *cellSize) + PADDING, (row *cellSize) + PADDING, cellSize ,cellSize);
        cell.draw();
    }


    public void checkAndPaint (double y, double x, Color playerColor) {
        if(cell.getY() < y && cell.getY()*cellSize  > y && cell.getX() < x && cell.getX()*cellSize > x) {
            if(!painted) {
                cell.setColor(playerColor);
                cell.fill();
                painted = true;
            }
        }
    }


    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public void draw() {
        cell.setColor(Color.PINK);
        cell.draw();
    }

    public void fill() {
        cell.setColor(Color.RED);
        cell.fill();
    }




}
