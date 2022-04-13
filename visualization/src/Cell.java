import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Cell extends ClonableCell{

    private char cellState;
    private String colour;


    public Cell(char cellState) {
        this.cellState = cellState;
    }

    private void Colour(){
        if(cellState == 'A'){
            this.colour = "green";
        }
        else if(cellState == 'C'){
            this.colour = "red";
        }
        else if(cellState == 'D'){
            this.colour = "black";
        }
        else if(cellState > 70 && cellState <= 89){
            this.colour = "blue";
        }

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
