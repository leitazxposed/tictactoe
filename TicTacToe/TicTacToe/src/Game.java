import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


public class Game implements MouseHandler {

    private Player player1;
    private Player player2;
    private Mouse mouse;
    private double mouseX;
    private double mouseY;
    private Cell[][] cellArray;
    private Grid grid;
    private int i;
    private int j;
    private boolean occupiedSquare;


    private Player playerPlaying;

    public Game() {
        player1 = new Player(Color.PINK);
        player2 = new Player(Color.CYAN);
        grid = new Grid();
        grid.gridInit();
        cellArray = grid.getCellArray();
        playerPlaying = player1;
        occupiedSquare = true;
    }

    public void mouseInit() {
        mouse = new Mouse(this);

    }


    @Override
    public void mouseClicked(MouseEvent event) {
        setMouseX(event.getX());
        setMouseY(event.getY());

        placeSymbol(playerPlaying);
        if (!occupiedSquare) {
            if (playerPlaying == player1) {
                playerPlaying = player2;
                occupiedSquare = true;



            } else {
                playerPlaying = player1;
                occupiedSquare = true;
            }
        }

    }


    public void placeSymbol(Player playerPlaying) {
        double positionX = getMouseX();
        double positionY = getMouseY();

        if (positionX < 210) {
            i = 0;
        } else if (positionX > 210 && positionX < 410) {
            i = 1;
        } else if (positionX > 410) {
            i = 2;
        }

        if (positionY < 210) {
            j = 0;
        } else if (positionY > 210 && positionY < 410) {
            j = 1;
        } else if (positionY > 410) {
            j = 2;
        }
        if (!cellArray[i][j].isPainted()) {
            cellArray[i][j].checkAndPaint(positionY, positionX, playerPlaying.getColor());
            occupiedSquare= false;
        }
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }
}


