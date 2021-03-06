
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MenuFrame extends JFrame implements ActionListener,WindowListener {
     JMenuItem fileNew = new JMenuItem("New");
     JMenuItem fileOpen = new JMenuItem("Open...");
     JMenuItem fileSave = new JMenuItem("Save");
     JMenuItem fileExit = new JMenuItem("Exit");
     JMenuItem editUndo = new JMenuItem("Undo");
     JMenuItem editCut = new JMenuItem("Cut");
     JMenuItem editCopy = new JMenuItem("Copy");
     JMenuItem editPaste = new JMenuItem("Paste");
     JMenuItem helpContents = new JMenuItem("Contents");
     JMenuItem helpAbout = new JMenuItem("About MenuFrame...");

     public MenuFrame() {
          super("Menu example");

          JMenuBar menubar = new JMenuBar();
          JMenu fileMenu = new JMenu("File");
          JMenu editMenu = new JMenu("Edit");
          JMenu helpMenu = new JMenu("Help");

          fileMenu.add(fileNew);
          fileMenu.add(fileOpen);
          fileSave.setEnabled(false);
          fileMenu.add(fileSave);
          fileMenu.addSeparator();
          fileMenu.add(fileExit);
          fileExit.addActionListener(this);
          editUndo.setEnabled(false);
          editMenu.add(editUndo);
          editMenu.addSeparator();
          editCut.setEnabled(false);
          editMenu.add(editCut);
          editCopy.setEnabled(false);
          editMenu.add(editCopy);
          editPaste.setEnabled(false);
          editMenu.add(editPaste);

          helpMenu.add(helpContents);
          helpMenu.addSeparator();
          helpMenu.add(helpAbout);

          menubar.add(fileMenu);
          menubar.add(editMenu);
          menubar.add(helpMenu);
          setJMenuBar(menubar);
          //addWindowListener(this); 
         
         addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) 
            {
               dispose();     
               System.exit(0);
            }
         });  
         // getContentPane().add(menubar);
          //getContentPane().
          setSize(new Dimension(400, 300));
          show();
           
     }

     
 

     public void windowClosing(WindowEvent e) 
     {
                MsgBox xt = new MsgBox("PAI IS A FOOL","DEV IS A VEDLA");
               dispose();     
            
               System.exit(0);
     }
     public void windowActivated(WindowEvent e) { }
     public void windowDeactivated(WindowEvent e) { }
     public void windowDeiconified(WindowEvent e) { }
     public void windowClosed(WindowEvent e) { }
     public void windowIconified(WindowEvent e) { }
     public void windowOpened(WindowEvent e) { }

     public void actionPerformed(ActionEvent e) {
          String s = e.getActionCommand();
          if (s.equals("Exit")) {
            MsgBox xt = new MsgBox("PAI IS A FOOL","DEV IS A VEDLA");
            System.exit(0); 
          }
         
     }
           

     

     public static void main(String[] args) {
          MenuFrame me = new MenuFrame();
     }
}

