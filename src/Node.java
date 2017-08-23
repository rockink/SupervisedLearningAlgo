/**
 * Created by rockink on 4/19/17.
 */
public class Node implements Comparable<Node> {


    public int[] queensArray;
    public int row;
    public int column;
    public int heuristicVal;
    private int moves;

    public Node(int row, int column, int heuristicVal, int[] queensArray) {
        this.row = row;
        this.column = column;
        this.heuristicVal = heuristicVal;
        this.queensArray = queensArray;
    }
    
    

    @Override
    public int compareTo(Node o) {
        return heuristicVal - o.heuristicVal;
    }

    public Node getCurrentState(int moves) {
        this.moves += moves;
        return this;
    }

    public int[] copyInitialBoard() {
        int[] retArray = new int[queensArray.length];

        for (int i = 0; i < queensArray.length; i++) {
            int row = queensArray[i];
            retArray[i] = row;
        }
        return retArray;
    }


    @Override
    public String toString() {
        return String.format("row %s col %s : %s ", row, column, heuristicVal);
    }

    public void setMoves(int moves) {
        this.moves += moves;
    }

    public int getMoves(){
        return moves;
    }
}
