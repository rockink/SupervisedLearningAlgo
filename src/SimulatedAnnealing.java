import java.util.Random;

/**
 * Created by rockink on 4/19/17.
 */
public class SimulatedAnnealing extends HillClimbing{

    Random random = new Random();
    Board board = new Board();


    public Node solveProblem(Node problem, Schedule schedule) {
        Node current, next;
        double T;

        int moves = 0;
        current = board.getInitialStateNode();
        for (int t = 1; ; t++) {

            moves ++;
            T = schedule.schedule(t);
//            if (T == 0 || T < 0) {
//
//                current.setMoves(moves);
//                return current;
//            }

//            System.out.println(T);
            next = board.randomlySelectSuccessor(current);

            //System.out.println("current " + current);
            //System.out.println("next " + next);
            //System.out.println();

            if (next.heuristicVal == 0) {
                next.setMoves(moves);
                return next;
            }

            //if temperature reaches upto this, then don't do it.
            if(T <= 0.002) {
                next.setMoves(moves);
                return next;
            }


            double deltaE = next.heuristicVal - current.heuristicVal * 1.0;

            //this is hill climbing!!
            if (deltaE > 0) {
                current = next;
            }

            //this is simulated annealing!
            else {

                //if only we think it is okay to consider, take this, otherwise, don't do it.
                if (probability(Math.exp(deltaE/T))) {
                    current = next;
                }

            }

        }

    }

    private boolean probability(double probability) {
        return probability < random.nextDouble();
    }
}
