import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int columnNumber;

    int[][] map;
    int[][] board;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    MineSweeper(int rowNumber,int columnNumber){
        this.rowNumber=rowNumber;
        this.columnNumber=columnNumber;
        this.map = new  int[rowNumber][columnNumber];
        this.board=new int[rowNumber][columnNumber];
    }

    void run(){

    }

}
