//////////////////////////////
// Program to Demonstatrate better graphics support in JDK1.2
//
//
//

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
// 
//  class GraphDemo : public JFrame 

public class GraphDemo extends JFrame implements ActionListener
{
  
   static final int numShapes = 5; // const int numShapes = 5;
   static final int width     = 600;
   static final int height    = 400;
   Shape shapes[] = new Shape[numShapes]; 
   JMenuBar menubar;  // JMenuBar *menubar;
  
   public  GraphDemo() 
   {
     super("JAVA 2D DEMO");
     JMenuItem mnu  = new JMenuItem("EXIT");
     mnu.addActionListener(this);
     JMenu     mnus = new JMenu("FILE");
     mnus.add(mnu);
     menubar = new JMenuBar();
     menubar.add(mnus);
     setJMenuBar(menubar);
    
     shapecreate();
     getContentPane().setLayout(null);
     ExtendedCanvas sr = new  ExtendedCanvas();
     sr.setBounds(50,50,600,600);
     getContentPane().add(sr);
     
     pack();
      setSize(new Dimension(600, 400));
     show();
   }

  void shapecreate()
  {
    for( int i=0; i<shapes.length; ++i )
        shapes[i] = null;
    shapes[0] = new Line2D.Double(0.0,0.0,100.0,100.0);
    shapes[1] = new Rectangle2D.Double(100.0,100.0,200.0,200.0);
    shapes[2] = new Ellipse2D.Double(200.0,200.0,100.0,100.0);
    shapes[3] = new Ellipse2D.Double(300.0,200.0,100.0,100.0);
    shapes[4] = new Ellipse2D.Double(350.0,200.0,100.0,100.0);


  }


  public void actionPerformed( ActionEvent a ) 
  {
    String estr = a.getActionCommand();
    if (estr.equals("EXIT"))
        System.exit(0);
  }
  public static void main(String[] args )
  {
    GraphDemo st = new GraphDemo();      

  } 

class ExtendedCanvas extends Canvas
{

 public void paint(Graphics gr ) 
 {
   Graphics2D g = (Graphics2D)gr;

   for(int j=0;j<shapes.length; ++j )
   {
      if (shapes[j] == null )
           continue;
      g.draw(shapes[j]);
   }
  
 }



}
  

class ActionCommandHandler implements ActionListener
{    

  public void actionPerformed( ActionEvent a ) 
  {
    String estr = a.getActionCommand();
    if (estr.equals("EXIT"))
        System.exit(0);
  }

}






}
