import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;

class ClientWorker implements Runnable 
{  
   private Socket client;
   private JTextArea textArea;


   ClientWorker(Socket client,JTextArea textArea) 
   {
       this.client = client;
       this.textArea = textArea;   
   }

   public void run()
   {
     String line;
     BufferedReader in = null;
     byte[] bs = new byte[2000];
     try
     {
       in = new BufferedReader(new InputStreamReader(client.getInputStream()));

     } 
     catch (IOException e) 
     {      
             System.out.println("in or out failed");
             return;
     }

    while(true)
    { 
      try
       {
        line = in.readLine();
        textArea.append(line+"\n");
       } 
       catch (Exception e) 
       {         
             System.out.println("Read failed");
               return;
       }
    }  
   }

}

class JavaServ extends JFrame
{
     JMenuItem optionclear = new JMenuItem("Clear");
     JMenuItem optionexit  = new JMenuItem("Exit");
     JTextArea jtx = new JTextArea();   
     JavaServ(String title)
     {
         
         super(title);  
         JMenuBar menubar = new JMenuBar();
         JMenu fileMenu = new JMenu("Options");
         menubar.add(fileMenu);
         fileMenu.add(optionclear); 
         fileMenu.add(optionexit); 
         setSize(new Dimension(400, 300));
         setJMenuBar(menubar); 
         getContentPane().setBackground( Color.red );

         getContentPane().add(jtx);
         optionexit.addActionListener(new EventHandler());
         optionclear.addActionListener(new EventHandler());   
         show();
         addWindowListener( new WindowAdapter() {
             public void windowClosing(WindowEvent e )
             {
                 System.exit(0);
             }

         } );
        
       }

     public void listenSocket()
     {
       ServerSocket server=null; 
       try
        {
            server = new ServerSocket(4444); 
        } catch (Exception e) 
        {
             System.exit(-1);
        }
       while(true)
       {
          ClientWorker w;
          try{
            w = new ClientWorker(server.accept(), jtx);
            Thread t = new Thread(w);
            t.start();
           } 
           catch (Exception e) 
           {
               System.out.println("Accept failed: 4444");
               System.exit(-1);
          }
        }
     }

     class EventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e )
         {

            if (e.getActionCommand().equals("Exit"))
             {
               System.exit(0);
             }  
           else if (e.getActionCommand().equals("Clear"))
             {
               jtx.setText("");
                   

             }  
 



         }

     }
     public static void main(String[] ar )
     {
       JavaServ rt = new JavaServ("Helllo World");
       rt.listenSocket();
     }

}


