import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] newgameTable=new int[3][3];
        GameTable gameTable=new GameTable(newgameTable);
       int k=1;
        Scanner scanner=new Scanner(System.in);
        gameTable.play();
    }
}