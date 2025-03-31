package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private List<List<Space>> squares;
    private BoardOperations boardOperations = new BoardOperations(this);

    public Board(List<List<Space>> lines) {
        this.squares = lines;
    }

    public List<List<Space>> getSquares() {
        return squares;
    }

    public void displayBoard() {
        for (int line = 0; line < 3; line++) {
            for (int i = 0; i < 3; i++) {
                for (int square = 0; square < 3; square++) {
                    int squareIndex = line * 3 + square;

                    System.out.print("[");
                    for (int j = 0; j < 3; j++) {
                        Integer actual = squares.get(squareIndex).get(i * 3 + j).getActual();
                        if (actual == null) {
                            System.out.print(" ");
                        } else System.out.print(actual);
                        if (j < 2) System.out.print(" ");
                    }
                    System.out.print("] ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void removeNumber(int number, Integer intendedLine, Integer intendedColumn) {

    }

    public void addNumber(int number, Integer intendedLine, Integer intendedColumn) {
        boardOperations.setData(number, intendedLine, intendedColumn);

        if (boardOperations.getSpaceOfOcurrence().isFixed()) {
            System.out.println("You can't add a number in a fixed coordinate");
            return;
        } else {
            if (!checkIfNumberIsNotPresent(number, List.of(boardOperations.squareOfOccurrence, boardOperations.allNumbersInSpecifiedLine, boardOperations.allNumbersInSpecifiedColumn))) {
                System.out.println("Invalid number, try again.");
                return;
            }
            boardOperations.allNumbersInSpecifiedLine.get(intendedColumn - 1).setActual(number);
            System.out.println("Number added successfully");
        }
    }

    private boolean checkIfNumberIsNotPresent(int number, List<List<Space>> spaceList) {
        for (List<Space> list : spaceList) {
            for (Space space : list) {
                Optional<Integer> actual = Optional.ofNullable(space.getActual());
                if (actual.isPresent() && actual.get() == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
