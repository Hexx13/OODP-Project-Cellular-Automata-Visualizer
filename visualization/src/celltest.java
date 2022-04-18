import IO.CellIO;
import cellFactory.CellCache;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class celltest  extends JFrame {
    private CellIO io = new CellIO();

    //declares a 2d array and sources cell data from txt file using IO class
    private char[][] cellDataArr = io.getCellData();
    //gets the size of the automata dimension using the IO class
    private int size = io.getSize();

    public static void main(String[] args) throws IOException, InterruptedException {
       new celltest();
    }

    celltest() throws IOException, InterruptedException {
        super("Display Application");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        CellCache.loadCache();
        add(render());

        Thread.sleep(2000);
        getContentPane().removeAll();
        revalidate();
        repaint();

        Thread.sleep(1000);
        add(renderHard());
        revalidate();
        repaint();
    }

    private String[] charTStr(char [] character){
        String[] str = new String[character.length];
        for(int i = 0; i < character.length; i++){
            str[i]= Character.toString(character[i]);
        }
        return str;
    }

    private JPanel renderBig(){
        JPanel mainpan1 = new JPanel(new GridLayout(size, size));

        String[] cellData = charTStr(cellDataArr[1]);

        for(int i = 0; i < cellData.length; i++){
            System.out.print(cellData[i]);
            mainpan1.add(CellCache.getCell(cellData[i]).getPanel());
        }

        return mainpan1;
    }

    private JPanel render(){
        JPanel mainpan1 = new JPanel(new GridLayout(2, 2));

        String testaRR[] = {"A", "A", "B", "X"};
        System.out.println(testaRR);


        for(int i = 0; i < testaRR.length; i++){
            mainpan1.add(CellCache.getCell(testaRR[i]).getPanel());
        }
        return mainpan1;
    }

    private JPanel renderHard(){
        JPanel mainpan1 = new JPanel(new GridLayout(20, 20));

        for(int i = 0; i < 400; i++){
            mainpan1.add(CellCache.getCell("A").getPanel());
        }
        return mainpan1;
    }
}
