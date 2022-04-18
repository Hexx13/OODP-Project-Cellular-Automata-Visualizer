package cellFactory;

import javax.swing.*;

public class CloneFactory {
    public Cell getClone(Cell cellSample){
        return cellSample.makeClone();
    }
}
