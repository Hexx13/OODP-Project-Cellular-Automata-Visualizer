import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;

public class Display extends JFrame {

    public Display() throws IOException, InterruptedException {
        super("Display Application");
        //declares a 2d array from the text file in the display from the retsus function
        char[][] newArray = retsus();

        //border declaration
        Border blackline = BorderFactory.createLineBorder(Color.black);

        //declares the number of rows by dividing the generations by the square root
        int rows = retRows();
        //returns the number of healthy people per iteration
        healthyCount(newArray);
        // infectedCount(newArray);
        // deceasedCount(newArray);
        // recoveredCount(newArray);
        //declaring items for the GUI
        Container contentPane = getContentPane();
        JPanel[] panelarray = new JPanel[newArray[0].length];
        JLabel genLab = new JLabel("",JLabel.CENTER);
        JPanel mainpan = new JPanel(new GridLayout(rows+1, rows));
        //this for loop repeats once per generation
        for (int i = 0; i <newArray.length; i++) {
            mainpan.removeAll();

            for(int j= 0;   j < newArray[0].length; j++){
                //creates panel and adds border
                panelarray[j] = new JPanel();
                panelarray[j].setBorder(blackline);
                //if statement to determine the color of the panel of each index in the array for that generation
                if(newArray[i][j] == 'A'){
                    panelarray[j].setBackground(Color.green);
                }//sus count
                else if(newArray[i][j] == 'B' ||retsus()[i][j] == 'D'){
                    panelarray[j].setBackground(Color.black);
                }//dead count
                else if(newArray[i][j] == 'C'){
                    panelarray[j].setBackground(Color.red);
                }//infect count
                else{
                    panelarray[j].setBackground(Color.blue);
                }//immune count
                //these panels are then added to the contentpane
                mainpan.add(panelarray[j]);
                setSize(1000, 1000);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            super.setTitle("This is Generation "+(i+2));
            contentPane.add(mainpan);
            contentPane.revalidate();
            Thread.sleep(10);
            //the generation count is added here to avoid being looped
            contentPane.add(genLab);
            //+1 is added so it matches the generation count
            genLab.setText("This is Generation "+(i+2));
            //allows the user to process a generation before it is overwritten

            //removes all content from contentpane
            contentPane.removeAll();
        }
        //Thread.sleep(10);

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        new Display();

    }




    public int retRows() throws IOException {

        File file = new File("text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        //reads in data from the text file line by line, adding it to the string
        String st = br.readLine();

        //the string is then split at every comma and added to the array
        String[] generations = st.split(",");



        // rowcol is the amount of generations in the array
        int rowcol = (int)Math.sqrt(generations[0].length());

        return rowcol;
    }

    public char[][] retsus() throws IOException {

        File file = new File("text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        //reads in data from the file adding it to st
        String st = br.readLine();

        String[] generations;


        //the data is split at every comma and is added to the generations array
        generations = st.split(",");

        //declaration of all counter arrays
        int susArray[]= new int[generations.length];
        int infectArray[]= new int[generations.length];
        int deceasedArray[]= new int[generations.length];
        int recoveredArray[]= new int[generations.length];
        //declaration of all counters
        int susCount=0;
        int infectCount=0;
        int deceasedCount=0;
        int recoveredCount=0;
        //declaring characterArray
        char characterArray[][] = new char[generations.length][generations[0].length()];


        for (int i =0; i<generations.length; i++){
            for(int j = 0; j<generations[i].length();j++) {
                characterArray[i][j] = generations[i].charAt(j);
                /*if(generations[i].charAt(j) == 'A'){
                    susCount = susCount+1;

                }//sus count
                else if(generations[i].charAt(j) == 'B' ||generations[i].charAt(j) == 'D'){
                    deceasedCount=deceasedCount+1;
                }//dead count
                else if(generations[i].charAt(j) == 'C'){
                    infectCount=infectCount+1;
                }//infect count
                else{
                    recoveredCount=recoveredCount+1;
                }//immune count*/
            }
            susArray[i]=susCount;
            susCount=0;
            deceasedArray[i]=deceasedCount;
            deceasedCount=0;
            infectArray[i]=infectCount;
            infectCount=0;
            recoveredArray[i]=recoveredCount;
            recoveredCount=0;

        }


        return characterArray;
    }

    public int[] healthyCount(char[][] newArray){
        //declaration of all counter arrays
        int susArray[]= new int[newArray.length];

        //declaration of all counters
        int susCount=0;

        for (int i =0; i<newArray.length; i++){
            for(int j = 0; j<newArray[i].length;j++) {
                if(newArray[i][j] == 'A'){
                    susCount = susCount+1;

                }//sus count
            }
            susArray[i]=susCount;
            System.out.println(susCount);
            susCount=0;

        }
        return susArray;
    }

    public int[] infectedCount(char[][] newArray){
        //declaration of all counter arrays
        int infectArray[]= new int[newArray.length];
        //declaration of all counters
        int infectCount=0;

        for (int i =0; i<newArray.length; i++){
            for(int j = 0; j<newArray[i].length;j++) {
                if(newArray[i][j] == 'C'){
                    infectCount=infectCount+1;
                }//infect count
            }
            infectArray[i]=infectCount;
            System.out.println(infectCount);
            infectCount=0;


        }
        return infectArray;
    }

    public int[] deceasedCount(char[][] newArray){
        //declaration of all counter arrays
        int deceasedArray[]= new int[newArray.length];

        //declaration of all counters
        int deceasedCount=0;

        for (int i =0; i<newArray.length; i++){
            for(int j = 0; j<newArray[i].length;j++) {
                if(newArray[i][j] == 'B' ||newArray[i][j] == 'D'){
                    deceasedCount=deceasedCount+1;
                }//dead count

            }

            deceasedArray[i]=deceasedCount;
            System.out.println(deceasedCount);
            deceasedCount=0;



        }
        return deceasedArray;
    }

    public int[] recoveredCount(char[][] newArray){
        //declaration of all counter arrays

        int recoveredArray[]= new int[newArray.length];
        //declaration of all counters

        int recoveredCount=0;

        for (int i =0; i<newArray.length; i++){
            for(int j = 0; j<newArray[i].length;j++) {

                if(newArray[i][j] != 'B' &&newArray[i][j] != 'D'&& newArray[i][j] != 'A'&& newArray[i][j] != 'C'){

                    recoveredCount=recoveredCount+1;

                }//immune count

            }

            recoveredArray[i]=recoveredCount;
            System.out.println(recoveredCount);
            recoveredCount=0;

        }
        return recoveredArray;
    }

}
