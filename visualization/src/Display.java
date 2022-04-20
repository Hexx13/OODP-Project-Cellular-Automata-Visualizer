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


    public Display() throws InterruptedException, IOException {
        super("Display Application");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CellCache.loadCache();


        //Main content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1,1));
        JPanel centerPanel = new JPanel(new GridLayout(1,1));
        JPanel botPanel = new JPanel(new GridLayout(1,1));

        JLabel generation = new JLabel("CURRENT GENERATION IVAN DRAGANOVIC", SwingConstants.CENTER);
        generation.setFont(new Font("SanSerif", Font.BOLD, 20));

        topPanel.add(generation);
        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(botPanel, BorderLayout.LINE_END);


        runSimulation(centerPanel);
    }

    private void runSimulation(Container parent) throws InterruptedException {

        //this for loop repeats once per generation
        for (int i = 0; i <cellDataArr.length; i++) {
            //removes the last generation
            parent.removeAll();
            //gets new generation
            parent.add(getGenerationPanel(cellDataArr[i]));

            //Revalidate and repaint to display new generation
            parent.revalidate();
            parent.repaint();

            //Sets the title to the current generation
            super.setTitle("This is Generation "+(i+1));

            //Determines speed of simulation
            Thread.sleep(10);
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
            //get panel from cell and assign to JPanel object
            JPanel cellPanel = cell.getPanel();
            //Add Cell Panel to Generation Panel
            generationPanel.add(cellPanel);
        }
        //return finished panel
        return generationPanel;
    }



}
