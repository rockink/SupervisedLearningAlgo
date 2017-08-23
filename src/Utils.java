import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rockink on 4/19/17.
 */
public class Utils {

    public static Problem createRandomNewProblem() {
        Board board = new Board();
        return new Problem(board);
    }

    public static int calculateBoardHeuristic(int[] queensArray){
        int boardHeuristic = 0;
        Set<String> repeatedVals = new HashSet<>();
        for (int column = 0; column < queensArray.length; column++) {
            int row = queensArray[column];
            boardHeuristic += calculateBoardHeuristic(repeatedVals, queensArray, row, column);
        }
        return boardHeuristic;
    }

    public static int calculateBoardHeuristic(Set<String> repeatedVals, int[] queensArray, int queenR, int queenC) {
        int threat = checkSameRow(repeatedVals, queensArray, queenR, queenC);
        threat += checkSameColumn(repeatedVals, queensArray, queenR, queenC);
        threat += checkSameDiag(repeatedVals, queensArray, queenR, queenC);
        return threat;
    }

    public static int checkSameDiag(Set<String> repeatedVals, int[] queensArray, int queenR, int queenC) {
        int count = 0;
        for (int column = 0; column < queensArray.length; column++) {
            int row = queensArray[column];

            if(row == queenR && column == queenC)
                continue;;

            if(Math.abs(queenR - row) == Math.abs(queenC - column)) {

                String repeatQueenLabel = repeatQueenLabelGenerator(queenR, queenC, row, column);
                if(!repeatedVals.contains(repeatQueenLabel)) {
                    repeatedVals.add(repeatQueenLabel);
                    ////System.out.println(repeatedVals);
                    count++;
                }
            }
        }
        return count;
    }

    private static String repeatQueenLabelGenerator(int queenR, int queenC, int row, int column) {
        String queenPositions[] = new String[2];
        queenPositions[0] = String.format("-%d-%d-", queenR, queenC);
        queenPositions[1] = String.format("-%d-%d-", row, column);
        Arrays.sort(queenPositions);

        //combine them both!
        String combinedString = "";
        for(String s : queenPositions){
            combinedString += s;
        }
        return combinedString;

    }


    //it is because, in the array indexed datastruct, the one column has one queen
    public static int checkSameColumn(Set<String> repeatedVals, int[] queensArray, int queenR, int queenC) {
        int count = 0;
        return count;

    }


    /**
     * It will consider counting itself too, so start from -1 works
     *
     * @param repeatedVals
     * @param queensArray
     * @param queenR
     * @param queenC
     * @return
     */
    public static int checkSameRow(Set<String> repeatedVals, int[] queensArray, int queenR, int queenC) {
        int count = 0;
        for (int column = 0; column < queensArray.length; column++) {
            int row = queensArray[column];

            if(row == queenR && column == queenC)
                continue;;


            if (row == queenR && column != queenC) {
                String repeatQueenLabel = repeatQueenLabelGenerator(queenR, queenC, row, column);
                if (!repeatedVals.contains(repeatQueenLabel)) {
                    repeatedVals.add(repeatQueenLabel);
                    ////System.out.println(repeatedVals);
                    count++;
                }
            }
        }
        return count;
    }



}
