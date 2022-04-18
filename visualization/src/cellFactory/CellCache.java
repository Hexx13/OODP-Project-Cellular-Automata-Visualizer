package cellFactory;

import java.util.Hashtable;


public class CellCache {
    //Did not originally plan to use a hash table, however due to there being 19 different
    // possible values for the immune cell it would be better to have them stored in a hash table
    // to reduce the over all amount of code written
    private static Hashtable<String, Cell> cellMap = new Hashtable<String, Cell>();


    //Used to make clones of the prototypes stored in the Hash table
    public static Cell getCell(String cellId){
        Cell cachedCell = cellMap.get(cellId);
        return (Cell) cachedCell.makeClone();
    }
    //Create prototypes and store them in hash map
    public static void loadCache(){
        Cell healthy = new Cell('A');
        healthy.setId("1");
        cellMap.put(healthy.getId(), healthy);

        Cell infected = new Cell('C');
        infected.setId("2");
        cellMap.put(infected.getId(), infected);

        Cell dead = new Cell('D');
        dead.setId("3");
        cellMap.put(dead.getId(), dead);

        Cell removed = new Cell('B');
        removed.setId("4");
        cellMap.put(removed.getId(), removed);

        //used for loop to create immune cells
        for(int i = 70; i <= 89; i++){
            Cell immune = new Cell((char) i);
            immune.setId(Integer.toString(i));
            cellMap.put(removed.getId(), immune);
        }
    }
}
