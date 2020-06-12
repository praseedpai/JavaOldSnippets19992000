import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cal extends Frame 
{
   Button DateButton = new Button(
   "                   Click me!                     ");
   Button okbtn = new Button("OK");
   Cal(String s)  
   {
      super(s);
      ButtonListener bl = new ButtonListener(DateButton);
     // setLayout(new FlowLayout(FlowLayout.LEADING));
    //  add(DateButton);     
    //  add(okbtn);
      //setLayout(new FlowLayout(FlowLayout.RIGHT));
           setLayout(new BorderLayout());
          add(new Button("North"), "North");
          add(new Button("East"), "East");
          add(new Button("South"), "South");
          add(new Button("West"), "West");          
          add(new Button("Centre"));
      DateButton.addActionListener(bl);    
      okbtn.addActionListener(bl); 
      pack();
      setSize(200,200);
      show();
   }

   public static void main(String[] rs )  
   {
        Cal s = new Cal("Fool");
   }

}

class ButtonListener implements ActionListener {    
           Date TheDate = new Date();
           Button theButton;    
           public ButtonListener(Button aButton) 
           {
                theButton = aButton;    
           }    

           public void actionPerformed (ActionEvent e) 
           {
            if ( e.getActionCommand().equals("OK") )
                  System.exit(0);
            else
                  theButton.setLabel(TheDate.toString());    
           }

}