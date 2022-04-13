package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CellIO {

    public char[][] getCellData() throws IOException {

        File file = new File("text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        //reads in data from the file adding it to st
        String st = br.readLine();

        String[] generations;

        //the data is split at every comma and is added to the generations array
        generations = st.split(",");

        //declaring characterArray for cell data
        char characterArray[][] = new char[generations.length][generations[0].length()];

        //populate array
        for (int i =0; i<generations.length; i++){
            for(int j = 0; j<generations[i].length();j++) {
                characterArray[i][j] = generations[i].charAt(j);
            }
        }

        return characterArray;
    }
}
