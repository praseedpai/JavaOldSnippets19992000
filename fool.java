import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//////////////////////////////////
///
//
//
class idiot  implements
               ActionListener {
public void actionPerformed(ActionEvent e )
{
     Object s = e.getSource();
     String fp = ((JButton)s).getText();

    if (fp.equals("CLICK"))
     ((JButton)s).setText("PAIISAFOOL-I");
   else
    ((JButton)s).setText("CLICK"); 
  
  
}


}
////////////////////////
//
//
//
//
//
public class fool extends javax.swing.JFrame implements
               ActionListener 
{
  JButton ajith = new JButton("CLICK");
  fool( String title )
  {
    super(title);
    getContentPane().add(ajith);
    ajith.addActionListener(this);  
   // ajith.addActionListener(new idiot());  
   
    pack();
    show();
  }

public static void main(String[] args )
{
     fool st = new fool("HELLO FROM PAI");
}
  
public void actionPerformed(ActionEvent e )
{
     Object s = e.getSource();
     String fp = ((JButton)s).getText();

  if (fp.equals("CLICK"))
     ajith.setText("PAIISAFOOL-O");
   else
   ajith.setText("CLICK"); 
  
  
}
 

}



