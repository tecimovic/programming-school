package programming.school.student.julia;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.PrintGraphics;


import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
        
public class drawgonometweedotjava implements IDrawingInstructions {
    private static int SIZE_X = 360;
    private static int SIZE_Y = 200;
    @Override
    public void draw(Graphics2D g) {
        int a;
        double e;
        
        g.setColor(Color.BLUE);
       // g.drawLine(0, 200, 360, 200);
      //  g.drawLine(360, 0, 360, 200);
        g.setColor(Color.BLACK);
        g.drawString("PLEASE ZOOM IN SO YOU SEE THE FRAMED AREA", 500, 500);
        g.setColor(Color.ORANGE);
        //g.drawLine(0, 230, 390, 230);
       // g.drawLine(390, 0, 390, 230);
       
        for (a=0;a<360;a++) {
            e = (Math.sin(a)*200.0+100.0);
             g.drawOval(a, (int)Math.round (e), 2, 2 );
        }
    }
        
    public static void main(String[] args) {
        
        
        new DrawingContainer(new drawgonometweedotjava()).runContainer(args);
        
    }
}
