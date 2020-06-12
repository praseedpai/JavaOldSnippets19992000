import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.Date;





public class DialogFrame extends JFrame implements ActionListener, WindowListener {

     JDialog dialog;
     JButton openDialogButton;
     JButton closeDialogButton;
     JButton closeFrameButton;

     public DialogFrame() 
     {
       super("Dialog and Frame example");
       getContentPane().setLayout(new FlowLayout());
       addWindowListener(this);
       openDialogButton = new JButton("Open dialog");
       openDialogButton.addActionListener(this);
       closeFrameButton = new JButton("Close me");
       closeFrameButton.addActionListener(this);
       getContentPane().add(openDialogButton);
       getContentPane().add(closeFrameButton);
       pack();
       show();
     }

     public void showDialog() {
          dialog = new JDialog(this, "This is the dialog", true);
          dialog.getContentPane().setLayout(new FlowLayout());

          //#1 dialog.addWindowListener(this);
           
          //#2dialog.addWindowListener(new WindowAdapter() {
          //      public void windowClosing(WindowEvent e) {
          //Window originator = e.getWindow();
          //if(originator.equals(this)) {
              // this.dispose();
           //    System.exit(0);
          //} else if(originator.equals(dialog))
           //    dialog.dispose();
           //}});

           dialog.addWindowListener(new  SanjayAdapter()); 

          
          
          closeDialogButton = new JButton("Close dialog");
          closeDialogButton.addActionListener(this);
          dialog.getContentPane().add(closeDialogButton);
          dialog.pack();
          dialog.show();
     }

     class SanjayAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
          Window originator = e.getWindow();
          if(originator.equals(this)) {
              // this.dispose();
               System.exit(0);
          } else if(originator.equals(dialog))
               dialog.dispose();
           }
     }
 
     
     public void actionPerformed(ActionEvent e) {
          String buttonCommand = e.getActionCommand();
          if(buttonCommand.equals("Open dialog"))
               showDialog();
          else if(buttonCommand.equals("Close dialog"))
               dialog.dispose();
          else if(buttonCommand.equals("Close me"))
               processEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
     }

     public void windowClosing(WindowEvent e) {
          Window originator = e.getWindow();
          if(originator.equals(this)) {
               this.dispose();
               System.exit(0);
          } else if(originator.equals(dialog))
               dialog.dispose();
     }

     public void windowActivated(WindowEvent e) { }
     public void windowDeactivated(WindowEvent e) { }
     public void windowDeiconified(WindowEvent e) { }
     public void windowClosed(WindowEvent e) { }
     public void windowIconified(WindowEvent e) { }
     public void windowOpened(WindowEvent e) { }

     public static void main(String[] args) {
          DialogFrame me = new DialogFrame();
     }
}
