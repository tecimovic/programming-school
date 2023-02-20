package programming.school.student.dylan.GOLgoal;

import java.util.Random;

import javax.lang.model.util.ElementScanner6;

import programming.school.cell.ICellularRules;

public class deadlywar implements ICellularRules {
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
        return "World War III";
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

                    return EMPTY;
                
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
