import java.awt.*;
import java.awt.Color.*;
import java.beans.*;
import java.awt.event.*;

public class SmileyPlace extends Frame 
{

  public SmileyPlace()
  {
    SmileyBean sm=null;

    try {
     sm = (SmileyBean)Beans.instantiate(null,"SmileyBean");
    }
   catch(Exception e ) {
     System.err.println("Exception:");
     System.err.println(e); 
   }    


   add(sm);
   addWindowListener( new WindowAdapter() {
           public void windowClosing(WindowEvent e )
           {
              System.exit(0);
           }
   });   

  


  }


public static void main(String[] arg )
{
  SmileyPlace st = new SmileyPlace();
  st.setSize(400,400);
  st.setTitle("PPPPPPPPPPPPPPPPP");
  st.pack();
  st.setVisible(true);
}
    






}