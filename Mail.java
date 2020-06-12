import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;


public class Mail extends JFrame
{
	public static int HEIGHT=500;
	public static int WIDTH=500;
	public static String TITLE="Mail";


  Container framecontainer;

        //JPanel[] panels=new JPanel[3];
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	JPanel panel4=new JPanel();

	

	
	JLabel label1,label2,label3;
	JTextArea textarea1;
	JTextField text1,text2;

	JMenuBar Menubar=new JMenuBar();
	JMenu Filemenu=new JMenu("File");
	JMenuItem Exit;
	JButton button1,button2;


  public  Mail()
 {
	super(TITLE);
	buildGUI();
	//setupEventHandlers();
	setSize(WIDTH,HEIGHT);
	show();
	pack();
 }


void buildGUI()
{
	setupMenuBar();
	layoutComponents();
}

  void layoutComponents()
	{
	panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
	text1=new JTextField(100);
	label1=new JLabel("Mail ID:",JLabel.LEFT);
	label1.setSize(1,1);
	panel1.add(label1);
	//panel1.setBorder(BorderFactory.createLineBorder(Color.black));
	panel1.add(text1);
	
	text2=new JTextField(100);
	label2=new JLabel("Subj:",JLabel.LEFT);
	panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
	label2.setSize(1,1);
	panel2.add(label2);
	panel2.add(text2);
	//panel2.setBorder(BorderFactory.createLineBorder(Color.black));

	panel3.setLayout(new BorderLayout());
	textarea2=new JTextArea(50,50) ;
	button1=new JButton("Send");
	button2=new JButton("Reset");
	panel3.add(textarea2,BorderLayout.NORTH);
	panel3.add(button1,BorderLayout.WEST);
	panel3.add(button2,BorderLayout.EAST);
	label3=new JLabel();
	panel3.add(label3,BorderLayout.SOUTH);
	//panel3.setBorder(BorderFactory.createLineBorder(Color.black));
	

	panel4.setLayout(new BorderLayout());
	panel4.add(Menubar,BorderLayout.NORTH);
	panel4.add(panel1,BorderLayout.WEST);
	panel4.add(panel2,BorderLayout.CENTER);
	panel4.add(panel3,BorderLayout.SOUTH);
	

	framecontainer=getContentPane();
	framecontainer.setLayout(new BorderLayout());
	//framecontainer.add(Menubar);
	framecontainer.add(panel4);
	}
void setupMenuBar()
{
	 
	Menubar.setBorder(new BevelBorder(BevelBorder.RAISED));
	Menubar.setBorderPainted(true);
	Menubar.add(Filemenu);
	Filemenu.add(Exit=new JMenuItem("Exit"));
}
public static void main(String []args)
    {
	Mail m=new Mail();
	m.setSize(WIDTH,HEIGHT);
    }
 public class WindowEventHandler extends WindowAdapter
    {

	   public void windowClosing(WindowEvent e)
	   {
	     System.exit(0);
     }

  }
}
