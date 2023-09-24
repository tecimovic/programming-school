package programming.school.student.timotej;

import java.util.Random;

import programming.school.cell.ICellularRules;

public class GameOfLifeAndWar implements ICellularRules {
    private Random rnd = new Random();

    @Override
    public int width() {
        return 100;
    }

    @Override
    public int height() {
        return 100;
    }

    @Override
    public int initialValue(int x, int y) {
        return EMPTY;
    }

    @Override
    public String name() {
        return "Game of life and war";
    }

    @Override
    public int newState(int oldState, int[] neigbors) {
        int redCount = 0, blueCount = 0;
        for (int i : neigbors) {
            if (i == RED)
                redCount++;
            if (i == BLUE)
                blueCount++;
        }
        int totalCount = redCount + blueCount;

        switch (oldState) {
            case EMPTY:
                if (totalCount == 3) {
                    if (blueCount > redCount) {
                        return BLUE;
                    } else {
                        return RED;
                    }
                } else if (redCount != 0 && blueCount != 0) {
                    if (redCount > blueCount) {
                        return RED;
                    } else if (blueCount > redCount) {
                        return BLUE;
                    } else {
                        return 1 + rnd.nextInt(2);
                    }
                } else {
                    return EMPTY;
                }
            case BLUE:
                if (totalCount < 2)
                    return EMPTY;
                if (totalCount > 3)
                    return EMPTY;
                if (redCount > blueCount) {
                    return RED;
                } else {
                    return BLUE;
                }
            case RED:
                if (totalCount < 2)
                    return EMPTY;
                if (totalCount > 3)
                    return EMPTY;
                if (blueCount > redCount) {
                    return BLUE;
                } else {
                    return RED;
                }
        }
        return 0;
    }
}
