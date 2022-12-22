package programming.school.student.julia;

import java.util.Random;

import programming.school.cell.ICellularRules;

public class THEVOTINGAME implements ICellularRules {
    

    private static final Random rnd = new Random();

    @Override
    public String name() {
        return "THE VOTINGAME";
    }

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
        return rnd.nextInt(3);
    }

    @Override
    public int newState(int oldState, int[] neigbors) {
        int redC = 0;
        int blueC = 0;
        int emptyC = 0;
        for ( int n: neigbors ) {
            if ( n == RED )
                redC++;
            if ( n == BLUE )
                blueC++;
            if ( n == EMPTY)
               emptyC++;
        }
        if ( oldState == EMPTY ) {
            if ( redC + blueC > 5 ) {
                if (redC > blueC ) return BLUE;
                if (blueC > redC ) return BLUE;
                return 1 + rnd.nextInt(2);
            }
        } else if ( oldState == RED ) {
            //if ( redC + blueC < 2 ) return EMPTY;
            if ( blueC > 7 ) return EMPTY;
            if ( blueC > 0 ) return BLUE;
        } else if ( oldState == BLUE) {
            //if ( redC + blueC < 2 ) return EMPTY;
            if ( redC > 0 ) return BLUE;
            if ( emptyC > 5) return EMPTY;
        }
        return oldState;
    }

}
