package cellFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CellPanel implements Cloneable {

    private char cellState;
    public JPanel cellPanel = new JPanel();
    public CellPanel(char cellState) {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        cellPanel.setBorder(blackLine);
        cellPanel.setBackground(getColor(cellState));

    }

    public CellPanel makeClone() throws CloneNotSupportedException{
        return (CellPanel) super.clone();
    }

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

    public JPanel getCellPanel() {
        return cellPanel;
    }
}
