import java.awt.*;
import java.awt.Color.*;
import java.beans.*;

public class SmileyBean extends Canvas
{
  private Color ourColor = Color.yellow;
  private boolean smile=true;

  public SmileyBean()
  {
    setSize(new Dimension(250,250));
  }

  public synchronized void toggleSmile()
  {
    smile = !smile;
    repaint();
  }


  public void paint( Graphics g )
  {
     int cx = getSize().width/2;
     int cy = getSize().height/2;

     double r = Math.min(cx,cy)*0.97;

     int r007 = (int) (r*0.07);
     int r007x2 = r007*2;



     int r020 = (int) (r*0.20);
     int r020x2 = r020*2;


     int r030 = (int) (r*0.30);
     int r030x2 = r030*2;

     int r060 = (int) (r*0.60);
     int r060x2 = r060*2;
   
     int r100 = (int) (r*1.00);
     int r100x2 = r100*2;


     g.setColor(ourColor);
     g.fillOval(cx-r100,cy-r100,r100x2,r100x2);

     g.setColor(Color.black);
     g.drawOval(cx-r100,cy-r100,r100x2,r100x2);


     if (smile) {
         g.drawArc(cx-r060,cy-r060,r060x2,r060x2,200,140);
     }
     else {
        g.drawArc(cx-r060,cy+r030,r060x2,r060x2,20,140);
    }


    g.fillOval(cx-r030-r007,cy-r030-r007,r007x2,r007x2);
    g.fillOval(cx+r030-r007,cy-r030-r007,r007x2,r007x2);
    g.fillOval(cx-r007,cy+r020-r007,r007x2,r007x2);

  }







}