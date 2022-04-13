import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Cell extends ClonableCell{

    private char cellState;



    private Color colour;


    public Cell(char cellState) {
        this.cellState = cellState;
        Colour();
    }

    private void Colour(){
        if(cellState == 'A'){
            this.colour = Color.GREEN;
        }
        else if(cellState == 'C'){
            this.colour = Color.RED;
        }
        else if(cellState == 'D'){
            this.colour = Color.BLACK;
        }
        else if(cellState > 70 && cellState <= 89){
            this.colour = Color.BLUE;
        }
    }
    public Color getColour() {
        return colour;
    }

    public Cell makeClone(){
        //Variable where reference is stored;
        Cell cellObject = null;
        try{
            cellObject = (Cell) super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        //returns cloned object or null
        return cellObject;
    }
    public void setCellState(char state){
        this.cellState = state;
    }
}
