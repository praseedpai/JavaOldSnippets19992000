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


public class MouseExample extends JFrame implements ActionListener , MouseListener
{
  
   static final int numShapes = 5; 
   static final int width     = 600;
   static final int height    = 400;
   Shape shapes[] = new Shape[numShapes]; 
   JMenuBar menubar;  
  
   public  MouseExample () 
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
     setSize(new Dimension(800, 700));
     ExtendedCanvas sr = new  ExtendedCanvas();
     
     getContentPane().setLayout(new BorderLayout());
     //getContentPane().add("Center", sr);

     JPanel srt = new JPanel();
     srt.add(new JLabel("                                                      "));
     srt.add(new JLabel("                                                      "));
     srt.add(new JLabel("                                                       "));
     getContentPane().add(srt,BorderLayout.NORTH);
     getContentPane().add(sr,BorderLayout.CENTER);

     //sr.setBounds(10,10,790,690);
     //getContentPane().add(sr);
     pack();
     
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
    MouseExample  st = new MouseExample(); 

  } 
    public void mouseClicked(MouseEvent e) {}
     public void mouseEntered(MouseEvent e) { }
     public void mouseExited(MouseEvent e) { }
     public void mousePressed(MouseEvent e) { }
     public void mouseReleased(MouseEvent e) { }

class ExtendedCanvas extends Canvas implements MouseListener , MouseMotionListener
{
 static final int COPYMODE = 1;
 static final int XORMODE  = 2; 
 float x1;
 float y1;
 float x2;
 float y2;
 int   draw;
 int   mode;
 Shape curr_shape; 

  public ExtendedCanvas() {
        draw =0; 
        curr_shape=null;
 	setBackground(Color.black);
        setBackground(Color.black);
        setForeground(Color.red);    
        setSize(400,400); 
	addMouseMotionListener(this);
	addMouseListener(this);
        mode = COPYMODE;
    }

 public void paint(Graphics gr ) 
 {
   Graphics2D g = (Graphics2D)gr;
  if (curr_shape != null ) 
  {

   if ( mode == COPYMODE )
       g.setPaintMode();
   else
      g.setXORMode(getBackground());  
   g.draw(curr_shape);

  }
   
  


 }

     public void mouseClicked(MouseEvent e) {}
     public void mouseEntered(MouseEvent e) { }
     public void mouseExited(MouseEvent e) { }
     public void mousePressed(MouseEvent e) 
     { 
       x1 = e.getX();
       y1 = e.getY();
       x2 = e.getX();
       y2 = e.getY();
       curr_shape = new Rectangle2D.Double(x1,y1,0,0);
       repaint();
       draw=1;
    
     }
     public void mouseReleased(MouseEvent e) {
     if (draw == 0 )
             return; 
        mode = COPYMODE;
        repaint();         
      	draw=0;
    }


     public void mouseDragged(MouseEvent e) 
     {
        e.consume();
        
        if (draw == 0 )
             return; 
        mode = XORMODE;
        repaint();
        x2 = e.getX();
        y2 = e.getY();

        if ( x2 < x1 ) 
         {
            float t = x2;
            x2=x1;
            x1=t;
        }

         if ( y2 < y1 ) 
         {
            float t = y2;
            y2=y1;
            y1=t;
        }
        
        curr_shape = new Rectangle2D.Double(x1,y1,(x2-x1),(y2-y1));
        repaint();
            
     }


     public void mouseMoved(MouseEvent e) 
      {
        

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
