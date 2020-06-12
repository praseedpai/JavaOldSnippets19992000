import java.awt.*;
import java.applet.*;

public class FilledBox extends Applet
{
  Color boxColor;

  public void init() 
  {
    String s ;
    s=getParameter("color");
    boxColor = Color.gray;
    
    if ( s != null ) {
         if (s.equals("red"))
               boxColor = Color.red;
                 
         if (s.equals("white"))
               boxColor = Color.white;

         if (s.equals("blue"))
               boxColor = Color.blue;

     }
    

  }


  public void paint(Graphics g ) 
  {

     g.setColor(boxColor);
     g.fillRect(0,0,getSize().width,getSize().height);

  }




}
