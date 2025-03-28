import entities.Board;
import services.SudokuInitializer;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SudokuInitializer sudokuInitializer = SudokuInitializer.getInstance();
        Board board = sudokuInitializer.initializeBoard();

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.print("""
                Menu:
                    1- Add number
                    2- Remove number
                    3- Display board
                    4- Status
                    5- Finish game
                    6- Exit game
                Your choice:  """);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    int numberToAdd;
                    System.out.print("Number to add: ");
                    numberToAdd = scanner.nextInt();
                    board.addNumber(numberToAdd, 3, 4);
                    break;
                case 3: board.displayBoard();
            }
        } while (option != 6);

    }
}