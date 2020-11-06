package main.java.com.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NQueensProblem {

    final static int N = 4;

    public static void main(String[] args) {

        int [][] chessBoard = new int[N][N];
        printSolution(chessBoard);
        NQueensProblem nQueens = new NQueensProblem();
        if(nQueens.getQueensCoordinates(chessBoard, 0)){
            System.out.println("Solution found");
            System.out.println(chessBoard);
        }
        printSolution(chessBoard);

    }

    public static void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }


    /**
     *  This is one solution as we see
     *  Queens are placed at coordinates marked
     *  as 1 and are not in same column or not
     *  diagonal thus not under attack.
     *
     *   [ * 1 * *]
     *   [ * * * 1]
     *   [ 1 * * *]
     *   [ * * 1 *]
     *
     */

    public boolean isQueenSafe(int row, int column, int [][] chessBoard){

        int i,j;
        for(i = 0; i < column; i++){
            if(chessBoard[row][i] == 1)
                return false;
        }

        for(i = row, j = column; i >= 0 && j >= 0; i--, j--){
            if(chessBoard[i][j] == 1)
                return false;
        }

        for(i = row, j = column; i < N && j>=0; i++, j-- ){
            if(chessBoard[i][j] == 1)
                return false;
        }

        return true;
    }
    public boolean getQueensCoordinates(int [][] chessBoard, int column){

        if(column >= N) {
            return true;
        }
        for(int i = 0; i < N; i++){

            if(isQueenSafe(i, column, chessBoard)) {
                chessBoard[i][column] = 1;

                if (getQueensCoordinates(chessBoard, column + 1) == true)
                    return true;

                chessBoard[i][column] = 0;

            }
        }

        String [] str = {"a", "b", "c"};
        //str.length;
        Map<Integer,String []> map = new HashMap<>();
        map.put(2, str);
        return false;
    }
}
