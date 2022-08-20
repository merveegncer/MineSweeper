import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int rowNum;
    int colNum;
    int size;
    char[][] map;
    char[][] gameBoard;
    boolean game = true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    public MineSweeper(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.map = new char[rowNum][colNum];
        this.gameBoard = new char[rowNum][colNum];
        this.size = rowNum*colNum;
    }

    public void run(){
        putMine();
        printMap(map);
        int sRow,sCol;
        System.out.println("oyun basladi");
        elementsGameBoard();
        while (game){
            printMap(gameBoard);
            System.out.println("satir girin: ");
            sRow = input.nextInt();
            System.out.println("sutun girin:");
            sCol = input.nextInt();
            if(map[sRow][sCol] != '*'){
                printStarCount(sRow,sCol);
            }
            else {
                System.out.println("Mayina bastiniz.");
                System.out.println("Game Over !!!");
            }


        }
    }


    public int starCount(int sRow, int sCol){
        int nearStarCount = 0;
        if (sCol + 1 < map[0].length - 1) {
            if (map[sRow][sCol + 1] == '*')
                nearStarCount++;
        }

        if (sCol - 1 >= 0) {
            if (map[sRow][sCol - 1] == '*')
                nearStarCount++;
        }

        if (sRow + 1 < map.length - 1) {
            if (map[sRow + 1][sCol] == '*')
                nearStarCount++;
        }

        if (sRow - 1 >= 0) {
            if (map[sRow - 1][sCol] == '*')
                nearStarCount++;
        }
        if (sRow - 1 >= 0 && sCol - 1 >= 0) {
            if (map[sRow - 1][sCol - 1] == '*')
                nearStarCount++;
        }
        if (sRow - 1 >= 0 && sCol + 1 < map[0].length - 1)
            if (map[sCol - 1][sCol + 1] == '*')
                nearStarCount++;
        if (sRow + 1 < map.length - 1 && sCol - 1 >= 0)
            if (map[sRow + 1][sCol - 1] == '*')
                nearStarCount++;
        if (sRow + 1 < map.length - 1 && sCol + 1 < map[0].length - 1)
            if (map[sRow + 1][sCol + 1] == '*')
                nearStarCount++;
        return nearStarCount;
    }
    public void printStarCount(int sRow , int sCol){
        switch (starCount(sRow , sCol)){
            case 0:
                gameBoard[sRow][sCol] = '0';
                map[sRow][sCol] = '0';
                break;
            case 1:
                gameBoard[sRow][sCol] = '1';
                map[sRow][sCol] = '1';
                break;
            case 2:
                gameBoard[sRow][sCol] = '2';
                map[sRow][sCol] = '2';
                break;
            case 3:
                gameBoard[sRow][sCol] = '3';
                map[sRow][sCol] = '3';
                break;
            case 4:
                gameBoard[sRow][sCol] = '4';
                map[sRow][sCol] = '4';
                break;
            case 5:
                gameBoard[sRow][sCol] = '5';
                map[sRow][sCol] = '5';
                break;
            case 6:
                gameBoard[sRow][sCol] = '6';
                map[sRow][sCol] = '6';
                break;
            case 7:
                gameBoard[sRow][sCol] = '7';
                map[sRow][sCol] = '7';
                break;
        }
    }

    public void putMine(){
        int randRow , randCol , count =0;
        while(count != (size/4)){
            randRow = rand.nextInt(this.rowNum);
            randCol = rand.nextInt(this.colNum);
            if(map[randRow][randCol] != '*'){
                map[randRow][randCol] = '*';
                count++;
            }
        }
    }

    public void printMap(char[][] arr)
    {
        for(int i=0 ; i< arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                if(arr[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    void elementsGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

}
