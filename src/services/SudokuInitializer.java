package services;

import entities.Board;
import entities.Space;

import java.util.Arrays;

public class SudokuInitializer {
    private static SudokuInitializer instance;
    private boolean isInitialized = false;
    private Board initialBoard;

    private SudokuInitializer() {

    }

    public static SudokuInitializer getInstance() {
        if (instance == null) {
            instance = new SudokuInitializer();
        }
        return instance;
    }

    public Board initializeBoard() {
        if (!isInitialized) {
            System.out.println("Initializing a new board...");
            initialBoard = new Board(Arrays.asList(
                    Arrays.asList(
                            new Space(true, 9),
                            new Space(true, 5),
                            new Space(true, 8),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 6)
                    ),
                    Arrays.asList(
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 2),
                            new Space(true, 5),
                            new Space(true, 6),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null)
                    ),
                    Arrays.asList(
                            new Space(false, null),
                            new Space(true, 2),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 4),
                            new Space(false, null),
                            new Space(true, 5),
                            new Space(true, 1),
                            new Space(true, 7)
                    ),
                    Arrays.asList(
                            new Space(true, 6),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 7),
                            new Space(true, 8),
                            new Space(true, 4),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null)
                    ),
                    Arrays.asList(
                            new Space(true, 3),
                            new Space(true, 7),
                            new Space(true, 8),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 4),
                            new Space(true, 2),
                            new Space(true, 9)
                    ),
                    Arrays.asList(
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 9),
                            new Space(true, 3),
                            new Space(true, 2),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 8)
                    ),
                    Arrays.asList(
                            new Space(true, 4),
                            new Space(true, 9),
                            new Space(true, 2),
                            new Space(false, null),
                            new Space(true, 6),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 1),
                            new Space(false, null)
                    ),
                    Arrays.asList(
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 5),
                            new Space(true, 8),
                            new Space(true, 1),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null)
                    ),
                    Arrays.asList(
                            new Space(true, 1),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(false, null),
                            new Space(true, 7),
                            new Space(true, 6),
                            new Space(true, 3)
                    ))
            );
            isInitialized = true;
            return initialBoard;
        }

        System.out.println("Board already initialized!");
        return initialBoard;
    }


}
