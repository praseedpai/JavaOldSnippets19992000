/////////////////////////////////////////////////////
//
//  Praseed Pai's First Swing Program
//
//
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.Date;

/////////////////////////////////////////
//
//
//
//

public class calendar extends JFrame
{
 
 public static int WIDTH     = 600;          // Width of Frame
 public static int HEIGHT    = 400;          // Height of Frame
 public static String TITLE  = "Calendar";   // Caption 
 static final int MAX_NO_YEARS = 101;        // final for Symbolic Constants
 Container frameContainer;                   // scratch Variable
 String[] years;                             // Combo box for Month
 String[] months = {"JAN","FEB","MAR","APR","MAY","JUN",
                    "JUL","AUG","SEP","OCT","NOV","DEC"};
 JComboBox comboBox;
 JList list = new JList(months);
 JScrollPane scrollPane = new JScrollPane(list);
 ///////////////////////////////////////
 // Calendar model is a class derived from
 // AbstractTableModel. To the Ctor of Jtable 
 // always pass an object which implements ( extends )
 // the abstract class Table Model  

 CalendarModel model = new CalendarModel();
 JTable table= new JTable(model);

 /////////////////////////////////////
 // Menu Related Stuff
 // 
 //
 JMenuBar menuBar = new JMenuBar();
 JMenu fileMenu = new JMenu("File");
 JMenuItem fileExit= new JMenuItem("Exit");

 public class WindowHandler extends WindowAdapter 
{
  public void windowClosing(WindowEvent e )
  {
    System.exit(0);
  }

}

public class ComboHandler implements ItemListener {
  public void itemStateChanged(ItemEvent e )
  {
    model.setMonth(comboBox.getSelectedIndex()+1980,
    list.getSelectedIndex());
    table.repaint();
  }

}



public  class ListHandler implements ListSelectionListener {
  public void valueChanged(ListSelectionEvent e )
  {
    model.setMonth(comboBox.getSelectedIndex()+1980,
    list.getSelectedIndex());
    table.repaint();
  }

}


public  class MenuItemHandler implements ActionListener {
  public void actionPerformed(ActionEvent e )
  {
    String cmd = e.getActionCommand();

    if (cmd.equals("Exit"))
           System.exit(0);
  }

}
 
 ///////////////////////////////////////
 //
 // ctor
 //
 public calendar() 
 {
   super(TITLE);
   years = new String[101];

   for(int i=0; i<101;++i)
    {
        years[i] = Integer.toString(i+1980);
    }
    
  comboBox  = new JComboBox(years);  


   buildGUI();
   setupEventHandlers();
   setSize(WIDTH,HEIGHT);
   show();
}
//////////////////////////
//
//
//
void buildGUI() 
{
 setupMenuBar();
 layoutComponents();
} 
//////////////////////////////
//
//
void setupMenuBar()
{
  fileMenu.add(fileExit);
  menuBar.add(fileMenu);
  setJMenuBar(menuBar);
}
//////////////////////
//
//
public void layoutComponents() 
{

 frameContainer = getContentPane();

 frameContainer.setLayout(null);

 comboBox.setBounds(10,10,100,30);
 comboBox.setSelectedIndex(0);
 comboBox.addItemListener(new ComboHandler());
 scrollPane.setBounds(200,10,150,100);
 list.setSelectedIndex(3);
 list.addListSelectionListener(new ListHandler());

 table.setBounds(10,150,550,200);

 model.setMonth(comboBox.getSelectedIndex()+1980,list.getSelectedIndex());

 frameContainer.add(comboBox);
 frameContainer.add(scrollPane);

 table.setGridColor(Color.black);
 table.setShowGrid(true);
 frameContainer.add(table);
}
//////////////////////////////
//
//
//
void setupEventHandlers()
{
 addWindowListener(new WindowHandler());
 fileExit.addActionListener(new MenuItemHandler());
}
////////////////////////////
///
//
//
public static void main(String[] args ) 
{
  calendar app = new calendar();
}
///////////////////////////////////////
//
//

class CalendarModel extends AbstractTableModel 
{
  String[] days = {"Sun","Mon","Tue","Wed","Tthu","Fri","Sat"};
  int[] numDays = {31,28,31,30,31,30,31,31,30,31,30,31};

  String[][] kalendar = new String[7][7];

//////////////////////////////////
//
//
//
public CalendarModel()
 {

 for(int i=0;i<days.length;++i)
 {
   kalendar[0][i] = days[i];
 }

 for(int i=1;i<7;++i)
  for(int j=0;j<7;++j)
    kalendar[ i][j] = " ";
}

////////////////////////////
//
//
//
public int getRowCount() {
 return 7;
}
////////////////////////////
//
//
//
public int getColumnCount() {
 return 7;
}
////////////////////////
//
//
//
public Object getValueAt(int r, int c )
{
  return kalendar[r][c];
}
///////////////////////////
//
//
//
public void setValueAt(Object v, int r, int c )
{
   kalendar[r][c] = (String)v;
}
///////////////////////////////////
//
//
//
public boolean isCellEditable(int row, int col) 
{
  return getValueAt(row,col) == Integer.class;

}
///////////////////////////
//
//

public void setMonth(int year , int month )
{
 
 for(int i=1;i<7;++i)
  for(int j=0;j<7;++j)
    kalendar[ i][j] = " ";

 java.util.GregorianCalendar cal = new java.util.GregorianCalendar();

 cal.set(year,month,1);

 int offset =cal.get(java.util.GregorianCalendar.DAY_OF_WEEK)-1;

 offset+=7;

 int num = daysInMonth(year,month);

 for(int i=0;i<num;++i)
{
 kalendar[offset/7][offset%7] = Integer.toString(i+1);
 ++offset;
}  

}

public boolean isLeapYear(int y )
{
   if ( ( y%4 == 0 ) ) 
         return true;

  return  false;

}

public int daysInMonth(int y,int m)
{
  int days  =numDays[m];

  if (m == 1 && isLeapYear(y) )
         ++days;

  return days;


}

}



}


