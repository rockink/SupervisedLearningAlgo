import java.util.ArrayList;
import java.util.List;

/**
 * Created by rockink on 4/19/17.
 */
public class HillClimbing extends Search {


    Board board = new Board();

    public Node solveProblem(Node node){
        Node current, neighbor;

        if(node != null){
            current = node;
        }else {
            current = board.getInitialStateNode();
        }

        int moves = current.getMoves();
        for(;;){
            moves++;
            neighbor = board.successor(current);
            //means that neighbor is greater
            if (neighbor.heuristicVal == 0 || neighbor.heuristicVal >= current.heuristicVal) {
                return neighbor.getCurrentState(moves);
            }
            current = neighbor;
            board.setCurrentState(current);
        }
    }


    public static void main(String[] args){
        HillClimbing hillClimbing = new HillClimbing();
        Node current = new Board().getInitialStateNode();
        hillClimbing.solveProblem(current);
    }

    public Node solveProblem() {
        Node current, neighbor;

        current = board.getInitialStateNode();
        int moves = current.getMoves();
        for(;;){
            moves++;
            neighbor = board.successor(current);
            //means that neighbor is greater
            if (neighbor.heuristicVal == 0 || neighbor.heuristicVal >= current.heuristicVal) {
                return neighbor.getCurrentState(moves);
            }
            current = neighbor;
            board.setCurrentState(current);
        }

    }
}
