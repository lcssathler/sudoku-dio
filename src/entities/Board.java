package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private List<List<Space>> squares;

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

    public void addNumber(int number, Integer intendedLine, Integer intendedColumn) {
        List<List<Space>> squaresInLine = getSquaresInLine(intendedLine);
        List<Space> squareOfOccurrence = findSquareOfCoordinates(intendedLine, intendedColumn, squaresInLine);
        List<Space> allNumbersInSpecifiedLine = getAllNumbersInSpecifiedLine(intendedLine, intendedColumn, squaresInLine);
        List<List<Space>> squaresInColumn = getSquaresInColumn(intendedColumn);
        List<Space> allNumbersInSpecifiedColumn = getAllNumbersInSpecifiedColumn(intendedColumn, squaresInColumn);
        Space spaceInOccurrence = allNumbersInSpecifiedLine.get(intendedColumn - 1);

        if (spaceInOccurrence.isFixed()) {
            System.out.println("You can't add a number in a fixed coordinate");
            return;
        } else {
            if (!checkIfNumberIsNotPresent(number, List.of(squareOfOccurrence, allNumbersInSpecifiedLine, allNumbersInSpecifiedColumn))) {
                System.out.println("Invalid number, try again.");
                return;
            }
            allNumbersInSpecifiedLine.get(intendedColumn - 1).setActual(number);
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

    private List<Space> findSquareOfCoordinates(Integer intendedLine, Integer intendedColumn, List<List<Space>> possibleSquares) {
        int index = Math.divideExact((intendedColumn - 1), 3);
        List<Space> square = possibleSquares.get(index);
        return square;
    }

    private List<Space> getAllNumbersInSpecifiedLine(Integer intendedLine, Integer intendedColumn, List<List<Space>> possibleSquares) {
        List<Space> possibleNumbersInline = new ArrayList<>();
        int indexLine = 2;

        if (intendedLine % 3 != 0) {
            indexLine = Math.abs((intendedLine % 3) - 1);
        }
        indexLine *= 3;

        for (List<Space> possibleSquare : possibleSquares) {
            List<Space> spaces = possibleSquare.subList(indexLine, indexLine + 3);
            spaces.forEach(s -> possibleNumbersInline.add(s));
        }
        return possibleNumbersInline;
    }

    private List<List<Space>> getSquaresInLine(Integer intendedLine) {
        List<List<Space>> possibleSquares = new ArrayList<>();
        if (intendedLine >= 1 && intendedLine <= 3) {
            possibleSquares.add(squares.get(0));
            possibleSquares.add(squares.get(1));
            possibleSquares.add(squares.get(2));
        } else if (intendedLine >= 4 && intendedLine <= 6) {
            possibleSquares.add(squares.get(3));
            possibleSquares.add(squares.get(4));
            possibleSquares.add(squares.get(5));
        } else {
            possibleSquares.add(squares.get(6));
            possibleSquares.add(squares.get(7));
            possibleSquares.add(squares.get(8));
        }
        return possibleSquares;
    }

    private List<List<Space>> getSquaresInColumn(Integer intendedColumn) {
        List<List<Space>> possibleSquares = new ArrayList<>();
        int i = Math.divideExact((intendedColumn - 1), 3);
        switch (i) {
            case 0:
                possibleSquares.add(squares.get(0));
                possibleSquares.add(squares.get(3));
                possibleSquares.add(squares.get(6));
                break;
            case 1:
                possibleSquares.add(squares.get(1));
                possibleSquares.add(squares.get(4));
                possibleSquares.add(squares.get(7));
                break;
            case 2:
                possibleSquares.add(squares.get(2));
                possibleSquares.add(squares.get(5));
                possibleSquares.add(squares.get(8));
                break;
        }
        return possibleSquares;
    }

    private List<Space> getAllNumbersInSpecifiedColumn(Integer intendedColumn, List<List<Space>> squaresInColumn) {
        List<Space> allNumbersInColumn = new ArrayList<>();
        int i = (intendedColumn - 1) % 3;
        for (List<Space> square : squaresInColumn) {
            for (int j = i; j <= i + 6; j = j + 3) {
                allNumbersInColumn.add(square.get(j));
            }
        }
        return allNumbersInColumn;
    }
}
