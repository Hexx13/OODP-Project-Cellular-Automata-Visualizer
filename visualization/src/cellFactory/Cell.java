package cellFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Cell extends ClonableCell{

    //Panel used to render as a visualized cell
    private CellPanel cellPanel;

    private char cellState;



    public JPanel getPanel(){
        return cellPanel.getCellPanel();
    }

    public Cell(char cellState) {
        this.cellState = cellState;
        //prepare colour
        cellPanel = new CellPanel(cellState);
    }


    public Cell makeClone(){
        //Variable where reference is stored;
        Cell cellObject = null;
        try{
            cellObject = (Cell) super.clone();

            cellObject.cellPanel = (CellPanel) cellPanel.makeClone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        //returns cloned object or null
        return cellObject;
    }
    public char getCellState() {return cellState;}
}
