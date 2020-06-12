import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class PopupPanel extends JPanel implements ActionListener {
  JPopupMenu popup = new JPopupMenu ();
  public PopupPanel() {
    JMenuItem item;
    popup.add (item = new JMenuItem ("Cut"));
    popup.add (item = new JMenuItem ("Copy"));
    popup.add (item = new JMenuItem ("Paste"));
    item.addActionListener(this); 
    popup.addSeparator();
    popup.add (item = new JMenuItem ("Select All"));
    popup.setInvoker (this);
    addMouseListener (new MouseAdapter() {
      public void mousePressed (MouseEvent e) {
        if (e.isPopupTrigger()) {
          popup.show (e.getComponent(), 
            e.getX(), e.getY());
        }
      }
      public void mouseReleased (MouseEvent e) {
        if (e.isPopupTrigger()) {
          popup.show (e.getComponent(), 
            e.getX(), e.getY());
        }
      }
    });


  

  }
   public void actionPerformed( ActionEvent e )
   {
              System.exit(0);
     
   }
 public static void main( String arg[] )
 {
  JFrame st =new JFrame("POPUP DEMO");
  PopupPanel x =  new  PopupPanel() ;
  st.getContentPane().add(x);
  st.show();
 }
}
