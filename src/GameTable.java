import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameTable {
    int[][] gameTable;
    public GameTable(int[][] gameTable){
        this.gameTable =gameTable;
    }
    public void printTheTable(){
        for(int i=0;i< gameTable.length;i++) {
            for (int j = 0; j < gameTable.length; j++) {
                if(gameTable[i][j]==0){
                    System.out.print("  ");
                }
                else if (gameTable[i][j] == 1) {
                    System.out.print("O ");
                }
                else if(gameTable[i][j] == 2){
                    System.out.print("X ");
                }
                if (j != 2) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if(i!=2){
                System.out.print(" ");
            System.out.println("********");
            }
        }
    }
    public  boolean isDiagonal(int k){
         boolean checkMain=true;
         boolean checkAnti=true;
         for(int i=0;i<gameTable.length;i++){
             if(k%2==0){
                 if(gameTable[i][i]!=1){
                     checkMain=false;
                    }
                 if(gameTable[3-i-1][i]!=1){
                     checkAnti=false;
                 }
                 }
                 else{
                 if(gameTable[i][i]!=2){
                     checkMain=false;
                 }
                     if(gameTable[3-i-1][i]!=2){
                        checkAnti=false;
                     }
                 }
        }
         return checkMain || checkAnti;
    }
    public boolean isRow(int k){
        boolean isRow=true;
        for(int i=0;i<gameTable.length;i++){
            isRow=true;
            for(int j=0;j<gameTable.length;j++){
                if(k%2==0){
                if (gameTable[i][j] != 1) {
                    isRow = false;
                }

                }
                else{
                    if (gameTable[i][j] != 2) {
                        isRow = false;
                    }
                }
            }
            if(isRow){
                return true;
            }
        }
        return isRow;
    }
    public boolean isCol(int k){
        boolean isCol=true;
        for(int i=0;i<gameTable.length;i++){
            isCol=true;
            for(int j=0;j<gameTable.length;j++){
                if(k%2==0){
                    if (gameTable[j][i] != 1) {
                        isCol = false;
                    }
                }
                else{
                    if (gameTable[j][i] != 2) {
                        isCol = false;
                    }
                }
            }
            if(isCol){
                return true;
            }
        }
        return isCol;
    }
    public void play(){
        int k=1;
        while(k!=10){
            if(k%2==1){
                System.out.println("Board");
                printTheTable();
                System.out.println("Player X's turn. Enter the row and column (1-3): ");
                Scanner scanner=new Scanner(System.in);
                while(true){
                int row=scanner.nextInt()-1;
                int column=scanner.nextInt()-1;
                if(gameTable[row][column]==0){
                    gameTable[row][column]=2;
                    break;
                }
                else{
                    System.out.println("This place is already occupied, so print another value");
                    }
                }
                printTheTable();
                if( isCol(k) || isRow(k) || isDiagonal(k)){
                    System.out.println("Player X won");
                    break;
                    }
            }
            else{
                System.out.println("Board");
                printTheTable();
                System.out.println("Player O's turn. Enter the row and column (1-3):");
                Scanner scanner=new Scanner(System.in);
                while(true){
                    int row= scanner.nextInt()-1;
                    int column= scanner.nextInt()-1;
                    if(gameTable[row][column]==0){
                        gameTable[row][column]=1;
                        break;
                        }
                else{
                    System.out.println("This place already picked");
                    System.out.println("Write another values");
                    }
                }
                printTheTable();
                if( isCol(k) || isRow(k) || isDiagonal(k)){
                    System.out.println("Player O won");
                    break;
                }
            }
            k++;
        }
        if(k==10){
            System.out.println("TIE");
        }
        System.out.println("Game over");
    }
}

