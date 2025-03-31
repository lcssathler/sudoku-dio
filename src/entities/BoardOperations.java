package entities;

import java.util.ArrayList;
import java.util.List;

public class BoardOperations {
    private Board board;
    private int number;
    private Integer line;
    private Integer column;
    protected List<List<Space>> squaresInLine;
    protected List<Space> squareOfOccurrence;
    protected List<Space> allNumbersInSpecifiedLine;
    protected List<List<Space>> squaresInColumn;
    protected List<Space> allNumbersInSpecifiedColumn;
    protected Space spaceOfOcurrence;

    public BoardOperations(Board board) {
        this.board = board;
    }

    protected void setSquaresInLine() {
        List<List<Space>> possiblesSquaresInLine = new ArrayList<>();
        if (line >= 1 && line <= 3) {
            possiblesSquaresInLine.add(board.getSquares().get(0));
            possiblesSquaresInLine.add(board.getSquares().get(1));
            possiblesSquaresInLine.add(board.getSquares().get(2));
        } else if (line >= 4 && line <= 6) {
            possiblesSquaresInLine.add(board.getSquares().get(3));
            possiblesSquaresInLine.add(board.getSquares().get(4));
            possiblesSquaresInLine.add(board.getSquares().get(5));
        } else {
            possiblesSquaresInLine.add(board.getSquares().get(6));
            possiblesSquaresInLine.add(board.getSquares().get(7));
            possiblesSquaresInLine.add(board.getSquares().get(8));
        }
        squaresInLine = possiblesSquaresInLine;
    }

    private void setSquareOfOcurrence() {
        int index = Math.divideExact((column - 1), 3);
        List<Space> square = squaresInLine.get(index);
        squareOfOccurrence = square;
    }

    private void setAllNumbersInSpecifiedLine() {
        List<Space> possibleNumbersInline = new ArrayList<>();
        int indexLine = 2;

        if (line % 3 != 0) {
            indexLine = Math.abs((line % 3) - 1);
        }
        indexLine *= 3;

        for (List<Space> square : squaresInLine) {
            List<Space> spaces = square.subList(indexLine, indexLine + 3);
            spaces.forEach(s -> possibleNumbersInline.add(s));
        }
        allNumbersInSpecifiedLine = possibleNumbersInline;
    }

    private void setSquaresInColumn() {
        List<List<Space>> possibleSquares = new ArrayList<>();
        int i = Math.divideExact((column - 1), 3);
        switch (i) {
            case 0:
                possibleSquares.add(board.getSquares().get(0));
                possibleSquares.add(board.getSquares().get(3));
                possibleSquares.add(board.getSquares().get(6));
                break;
            case 1:
                possibleSquares.add(board.getSquares().get(1));
                possibleSquares.add(board.getSquares().get(4));
                possibleSquares.add(board.getSquares().get(7));
                break;
            case 2:
                possibleSquares.add(board.getSquares().get(2));
                possibleSquares.add(board.getSquares().get(5));
                possibleSquares.add(board.getSquares().get(8));
                break;
        }
        squaresInColumn = possibleSquares;
    }

    private void setAllNumbersInSpecifiedColumn() {
        List<Space> allNumbersInColumn = new ArrayList<>();
        int i = (column - 1) % 3;
        for (List<Space> square : squaresInColumn) {
            for (int j = i; j <= i + 6; j = j + 3) {
                allNumbersInColumn.add(square.get(j));
            }
        }
        allNumbersInSpecifiedColumn = allNumbersInColumn;
    }

    private void setSpaceOfOcurrence() {
        spaceOfOcurrence = allNumbersInSpecifiedLine.get(column - 1);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setData(int number, int line, int column) {
        setNumber(number);
        setLine(line);
        setColumn(column);
        setupAttributes();
    }

    private void setupAttributes() {
        setSquaresInLine();
        setSquareOfOcurrence();
        setAllNumbersInSpecifiedLine();
        setSquaresInColumn();
        setAllNumbersInSpecifiedColumn();
        setSpaceOfOcurrence();
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setLine(int line) {
        this.line = line;
    }

    private void setColumn(int column) {
        this.column = column;
    }

    public Space getSpaceOfOcurrence() {
        return spaceOfOcurrence;
    }
}
