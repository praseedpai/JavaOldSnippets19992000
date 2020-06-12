public class PopupPanel extends JPanel {
  JPopupMenu popup = new JPopupMenu ();
  public PopupPanel() {
    JMenuItem item;
    popup.add (item = new JMenuItem ("Cut"));
    popup.add (item = new JMenuItem ("Copy"));
    popup.add (item = new JMenuItem ("Paste"));
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

 public static void main( String arg[] )
 {
   new  PopupPanel() ;
 }
}
