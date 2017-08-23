/**
 * Created by rockink on 4/19/17.
 */
public class Problem {


    private final Board board;

    public Problem(Board board) {
        this.board = board;
    }

    /**
     * This means initiate, and also calculate the heuristics for operations
     * @return
     */
    public Node getInitialStateNode() {
        return board.randomlySelectNewState();
    }

    public Problem getCurrentState() {
        return null;
    }
}
