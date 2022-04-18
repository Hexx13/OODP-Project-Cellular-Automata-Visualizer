package cellFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Cell extends ClonableCell{

    //Panel used to render as a visualized cell
    private JPanel cellPanel = new JPanel();

    private char cellState;
    private Color colour;







    public Cell(char cellState) {
        this.cellState = cellState;
        //prepare colour
        Colour();
        //prepare pannel
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        cellPanel.setBorder(blackLine);
        cellPanel.setBackground(getColour());
    }

    private void Colour(){
        if(cellState == 'A'){
            this.colour = Color.GREEN;
        }
        else if(cellState == 'C'){
            this.colour = Color.RED;
        }
        else if(cellState == 'D' || cellState == 'B'){
            this.colour = Color.BLACK;
        }
        else if(cellState > 70 && cellState <= 89){
            this.colour = Color.BLUE;
        }
    }
    public Color getColour() {
        return colour;
    }
    public JPanel getPanel(){
        return cellPanel;
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
    public char getCellState() {return cellState;}
}
