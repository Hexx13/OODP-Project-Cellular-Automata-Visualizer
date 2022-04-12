public class Cell extends ClonableCell{

    private char cellState;

    public Cell(char cellState) {
        this.cellState = cellState;
    }

    public ClonableCell makeClone(){
        //Variable where reference is stored;
        Cell cellObject = null;
        try{
            cellObject = (Cell)super.clone();
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
}
