import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * Created by rockink on 4/19/17.
 */
public class Board {

//    private int[] queensArray;
    Random random = new Random();
    static int BOARD_LENGTH = 8;


    /**
     * Randomly generates the board
     */
    public Board(){
        int[] queensArray = new int[BOARD_LENGTH];
//        generateRandomBoard();
        ////System.out.println(Arrays.toString(queensArray));
//        generateHeuristicBoard();
        //printboard();

    }

    //filling up the queen
    private int[] generateRandomBoard() {
        int[] queensArray = new int[BOARD_LENGTH];
        for(int i = 0; i < BOARD_LENGTH; i++){
            queensArray[i] = random.nextInt(BOARD_LENGTH);
//            queensArray[i] = i % 3;
        }

        return queensArray;
//        totalBoardHeuristic = Utils.calculateBoardHeuristic(queensArray);
    }

    private void printboard(int[][] heuristicBoard) {

        for(int[] eachRow : heuristicBoard){
            //System.out.println(Arrays.toString(eachRow));
        }
        //System.out.println();
    }


    /**
     * It means randomly select row, and search for queen in one of the columns
     * @return
     */
    public Node randomlySelectNewState() {
//        int randomRow = random.nextInt(BOARD_LENGTH);
        //diagram is row / column
//        int randomCol = random.nextInt(BOARD_LENGTH);

        int[] queensArray = generateRandomBoard();;
//        array[randomCol] = randomRow;
        return generateHeuristicBoard(queensArray);
    }


    /**
     *
     */

    //testing to see if heuristic works
    public static void main(String[] args){
        Board board = new Board();

//        int[] queenArray  = new int[] {0,1,2,0};
//
//        Set<String> repeatedVals = new HashSet<>();
//        these are in same row
//        int rows = Utils.checkSameRow(repeatedVals, queenArray, 0, 0);

        //diagonal should be 3
//        repeatedVals = new HashSet<>();
//        int diagCount = Utils.checkSameDiag(repeatedVals, queenArray, 0, 0);
//        //System.out.println("diags" + diagCount);


        //calculate the board heuristic relies on removing repeated too,
//        int calculateHeuristic = Utils.calculateBoardHeuristic(queenArray);
//        //System.out.println(calculateHeuristic);
    }

    public Node getInitialStateNode() {
        return randomlySelectNewState();
    }

    public Node successor(Node current) {
        int[] newQueen = copyInitialBoard(current.queensArray);

        //move the queen in new state
        newQueen[current.column] = current.row;
        return generateHeuristicBoard(newQueen);
    }

    public void setCurrentState(Node node) {
        //System.out.println("old state " + Arrays.toString(node.queensArray));
        node.queensArray[node.column] = node.row;
        //System.out.println("new state " + Arrays.toString(node.queensArray));
    }

    public Node randomlySelectSuccessor(Node current) {

        int[] newQueensArray = copyInitialBoard(current.queensArray);

        int neighborColumn = random.nextInt(45 % 7);
        int neighborRow = random.nextInt(45 % 7) ;


        newQueensArray[neighborColumn] = (neighborRow + current.row) % 7;

//        //System.out.println("current state " + Arrays.toString(current.queensArray));
//        //System.out.println("neighbor state " + Arrays.toString(newQueensArray));

        Node neighbor =  generateHeuristicBoard(newQueensArray);
//        //System.out.println("neighbor state " + Arrays.toString(neighbor.queensArray));

        return neighbor;
    }

    private Node generateHeuristicBoard(int[] array) {
        int[] initQueensState = copyInitialBoard(array);
        int[][] heuristicBoard = new int[BOARD_LENGTH][BOARD_LENGTH];
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for(int column = 0; column < BOARD_LENGTH; column++){
            for(int row = 0; row < BOARD_LENGTH; row++){
                int[] temp = copyInitialBoard(array);
                //change now the position
                temp[column] = row;
                ////System.out.println(Arrays.toString(array));
                heuristicBoard[row][column] = Utils.calculateBoardHeuristic(temp);
                nodes.add(new Node(row, column, Utils.calculateBoardHeuristic(temp), initQueensState));
            }

        }

//        printboard(heuristicBoard);

        return nodes.peek();

    }

    private int[] copyInitialBoard(int[] array) {
        int[] newArray = new int[array.length];
        int i = 0;
        for(int each : array){
            newArray[i++] = each;
        }
        return newArray;
    }
}
