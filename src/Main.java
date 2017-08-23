import java.util.Random;

public class Main {

    public void initProblem(Object search, boolean hillClimbing){

        int goalState = 0;
        int localMaxima = 0;
        int goalMoves = 0;
        int localMoves = 0;

        int max_moves = 100;

        double temperature = 3;

        for(int i = 0; i < max_moves; i++){
            Board board = new Board();


            Node current = null;

            if (hillClimbing)
                current = ((HillClimbing)search).solveProblem();
            else {

                current = ((SimulatedAnnealing)search).solveProblem(current, new Schedule(temperature));
                if(current.heuristicVal != 0){
                    current = ((SimulatedAnnealing)search).solveProblem(current);
                }

            }

            if(current.heuristicVal == 0) {
                goalState++;
                goalMoves += current.getMoves();
            }
            else {
                localMaxima++;
                localMoves += current.getMoves();

            }


            if(i % 100 == 0)
                System.out.print( i + " ");


        }


        double percent = ((double)goalState) / max_moves*100.0;
        String s = percent + "%   ";
        System.out.print(s);
        System.out.println(String.format("%.2f\t%.2f", ((double)goalMoves)/goalState, ((double)localMoves)/localMaxima));

    }



    public static void main(String[] args) {

        Main main = new Main();
        main.initProblem(new HillClimbing(), true);
        main.initProblem(new SimulatedAnnealing(), false);

    }
}
