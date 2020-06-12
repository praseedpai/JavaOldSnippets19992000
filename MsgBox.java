///////////////////////////////////////////
// MsgBox.java -- VB-style message box for Java
// 
//
//
//
//
//
import java.awt.*;
import java.awt.event.*;

public class MsgBox extends Frame 
{
  public String message;
  public String title;

  MsgBox( String msg ) {
        this( msg, "Attention" );
  }


  MsgBox( String msg, String title ) 
  {
      super( title );
      this.title = title;
      message = msg;
      resize( good_width(), 120 );
      Label lblMessage = new Label( message );
      lblMessage.setAlignment( Label.CENTER );
      add( "Center", lblMessage );
      add( "South", new OKbtn(this) );
      addWindowListener(new WindowAdapter() {
        public void windowClosed(WindowEvent e) 
        { 
            hide();
            dispose();
          
        }
      });
 
      show(); 
       
      Toolkit tk = getToolkit();
      Dimension d = tk.getScreenSize();
     // move ( (d.width - size().width)/2,
      //         (d.height - size().height)/2 );
    }

   


  class OKbtn extends Button implements ActionListener {
    MsgBox parent;
    OKbtn( MsgBox mb ) 
    {
       super( "  OK  " );
       parent = mb;
       addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) 
     {
        parent.hide();
        parent.dispose();
        
     }
    
} 

 
       
    private int good_width() {

        int wid1, wid2;

        setFont( new Font("Helvetica", Font.PLAIN, 12) );
        FontMetrics fm = getFontMetrics( getFont() );

        wid1 = 50 + fm.stringWidth( message );
        wid2 = 150 + fm.stringWidth( title );

        if ( wid1 > wid2 )
            return wid1;
        else
            return wid2;
    }

 public static void main(String[] args )
  {
    new MsgBox("HELLO","WORLD");    

  }

} 



