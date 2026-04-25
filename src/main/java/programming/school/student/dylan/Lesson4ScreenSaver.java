package programming.school.student.dylan;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.IKeyboardAction;

public class Lesson4ScreenSaver implements IDrawingInstructions, IKeyboardAction {

    private int speed = 10;
    private int skeletalextremigans = 0;
    private int circlecount = 0;
    private List<String> listylist = new ArrayList<>();
    private boolean rerail = false;

    private final Random rnd = new Random();
    
    private int x = rnd.nextInt(DrawingContainer.MAX_X);
    private int y = rnd.nextInt(DrawingContainer.MAX_Y);
    private int vx = speed;
    private int vy = speed;
    private void reset() {
        x += vx;
        y += vy;

        if ( x < 0 ) {
            x = 0;
            vx = speed;
        } else if ( x > DrawingContainer.MAX_X ) {
            x = DrawingContainer.MAX_X;
            vx = -speed;
        }

        if ( y < 0 ) {
            y = 0;
            vy = speed;
        } else if ( y > DrawingContainer.MAX_Y ) {
            y = DrawingContainer.MAX_Y;
            vy = -speed;
        }
    }

	@Override
	public void draw(final Graphics2D g) {
        if (rerail) {
        g.clearRect(0, 0, DrawingContainer.MAX_X, DrawingContainer.MAX_Y);
        rerail = false;
        }
        if (skeletalextremigans == 5) {
            g.setColor(Color.BLUE);
            g.drawString("take me to david busters next week then >:(", 100, 100);
            g.setColor(Color.ORANGE);
            g.drawOval(0, 0, 1000, rnd.nextInt(1000));
        }
        
        else if (skeletalextremigans == 4) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 3000, 3000);
            g.setColor(Color.BLUE);
            g.fillOval(-50, 674, 100, 100);
            for(circlecount = 0; circlecount<=13; circlecount++) {
                g.fillOval(-50 + circlecount * 80, 674, 100, 100);
            }
            g.setColor(Color.GRAY);
            g.fillOval(820, 30, 100, 100);
            g.setColor(Color.DARK_GRAY);
            g.fillOval(835, 40, 30, 30);
            g.fillOval(860, 65, 40, 40);
            g.setColor(Color.YELLOW);
            g.fillArc(500, 630, 200, 80, 180, 360);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(500, 630, 200, 40);
            g.setColor(Color.ORANGE);
            g.fillRect(600, 480, 10, 195);
            g.setColor(Color.WHITE);
            g.fillOval(600, 470, 150, 50);
            g.drawString("wow this is a masterpiece :o", 100, 100);
        } 
        
        else if (skeletalextremigans == 3) {
            g.drawString(listylist.get(0), 350, 100);
            g.drawString(listylist.get(1), 350, 200);
            g.drawString(listylist.get(2), 350, 300);
            g.drawString(listylist.get(3), 350, 400);
        }
        
        else if (skeletalextremigans == 2) {
            g.drawString("HOLY [Cungadero] KRis!!!!! I'M IN YOUR [Two for One] [Specil Deal] [Hyperlink Blocked]!!!!!!", 100, 100);
            g.setColor(Color.PINK);
            g.drawOval(350, 300, 10 + rnd.nextInt(40), 20);
            g.setColor(Color.YELLOW);
            g.drawOval(450, 300, 10 + rnd.nextInt(40), 20);
        }
        
        else if (skeletalextremigans == 0) {
        reset();
        switch(rnd.nextInt(6)) {
            case 0: g.setColor(Color.RED); break;
            case 1: g.setColor(Color.ORANGE); break;
            case 2: g.setColor(Color.YELLOW); break;
            case 3: g.setColor(Color.GREEN); break;
            case 4: g.setColor(Color.BLUE); break;
            case 5: g.setColor(Color.MAGENTA); break;
        }
               g.drawOval(x, y, 10 + rnd.nextInt(40), 20);
                    g.drawString("Buy the waboo plushies", rnd.nextInt(1000), rnd.nextInt(1000));
    } else {
        drawing(g);
    }


	}
    public void drawing(final Graphics2D g) {
        g.drawArc(10, rnd.nextInt(2300), rnd.nextInt(2300), 100, 100, 30);
    }

    @Override
    public void keyPressed(final Graphics2D g, final char ch) {
    listylist.add("...");
    listylist.add("...");
    listylist.add("...");
    listylist.add("...");
        switch(ch) {
        case 'm':
            listylist.set(0, "Do not enter, you who dare");
            break;
        case 'b':
            listylist.set(1, "You might come back without your hair.");
            break;
        case 't':
            listylist.set(2, "For snakes and eels make their decree...");
            break;
        case 'a':
            listylist.set(3, "...There is no exit, there is no key.");
            break;
        case '+':
        	speed++;
        	break;
        case '-':
        	speed--;
        	if ( speed < 1 ) speed = 1;
        	break;
        case '0':
            rerail = true;
            if (skeletalextremigans == 1) {skeletalextremigans = 0;
            } else {skeletalextremigans = 1;}
            skeletalextremigans = 1;
            break;
        case '9':
            rerail = true;
            if (skeletalextremigans == 2) {skeletalextremigans = 0;
            } else {skeletalextremigans = 2;}
            skeletalextremigans = 2;
            break;
        case '8':
            rerail = true;
            if (skeletalextremigans == 3) {skeletalextremigans = 0;
            } else {skeletalextremigans = 3;}
            skeletalextremigans = 3;
            break;
        case '7':
            rerail = true;
            if (skeletalextremigans == 4) {skeletalextremigans = 0;
            } else {skeletalextremigans = 4;}
            skeletalextremigans = 4;
            break;
        case '6':
            rerail = true;
            if (skeletalextremigans == 5) {skeletalextremigans = 0;
            } else {skeletalextremigans = 5;}
            skeletalextremigans = 5;
            break;
        case '5':
            rerail = true;
            skeletalextremigans = 0;
        }
    }


	public static void main(final String[] args) {
        Lesson4ScreenSaver l = new Lesson4ScreenSaver();
        new DrawingContainer(l,l, true).runContainer(args);
	}

}