package cellFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CellPanel extends JPanel implements Cloneable {

    //Constructor prepares border and colour
    public CellPanel(char cellState) {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        setBorder(blackLine);
        setBackground(getColor(cellState));

    }

    //Function for creating a clone
    public CellPanel makeClone() throws CloneNotSupportedException{
        return (CellPanel) super.clone();
    }

    //Determines the cell colour based on its current state
    private Color getColor(char state){
        System.out.println(state);
        if(state == 'A'){
            return Color.GREEN;
        }
        else if(state == 'C'){
            return Color.RED;
        }
        else if(state == 'D' || state == 'B'){
            return Color.BLACK;
        }
        else if(state > 70 && state < 90){
            return Color.BLUE;
        }
        return null;
    }

    //Returns the panel
    public JPanel getCellPanel() {
        return this;
    }
}
