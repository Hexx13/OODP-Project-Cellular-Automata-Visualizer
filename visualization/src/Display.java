import IO.CellIO;
import cellFactory.Cell;
import cellFactory.CellCache;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Display extends JFrame {
    private CellIO io = new CellIO();

    //declares a 2d array and sources cell data from txt file using IO class
    private char[][] cellDataArr = io.getCellData();
    //gets the size of the automata dimension using the IO class
    private int size = io.getSize();

    public static void main(String[] args) throws IOException, InterruptedException {
        new Display();
    }


    public Display() throws IOException, InterruptedException {
        super("Display Application");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CellCache.loadCache();


        //Main content pane
        Container contentPane = getContentPane();


        //this for loop repeats once per generation
        for (int i = 0; i <cellDataArr.length; i++) {
            //removes the last generation
            contentPane.removeAll();
            //gets new generation
            contentPane.add(getGenerationPanel(cellDataArr[i]));

            //Revalidate and repaint to display new generation
            contentPane.revalidate();
            contentPane.repaint();

            //Sets the title to the current generation
            super.setTitle("This is Generation "+(i+1));

            //Determines speed of simulation
            Thread.sleep(50);
        }
    }

    //Populates a JPanel with processed cells
    // returns a JPanel Object ready to be displayed
    private JPanel getGenerationPanel(char array[]){
        //Create panel to hold cells
        JPanel generationPanel = new JPanel(new GridLayout(size, size));
        //Loop to create and add cells to populate the Generation Panel
        for(int i= 0; i < array.length; i++){
            //translate character to string to use as hashtable key
            String cellState = Character.toString(array[i]);
            //Create cell from prototype in hashmap
            Cell cell = CellCache.getCell(Character.toString(array[i]));
            //get panel from cell and assign to Jpanel object
            JPanel cellPanel = cell.getPanel();
            //Add Cell Panel to Generation Panel
            generationPanel.add(cellPanel);
        }
        //return finished panel
        return generationPanel;
    }



}
