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
     InputStream in = null;
     byte[] bs = new byte[2000];
     try
     {
       in = client.getInputStream();

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
        int n = in.read(bs,0,100);
        if ( n < 0)
             continue;
        String st = new String(bs,0,n);
        textArea.append(st+"\n");
       } 
       catch (Exception e) 
       {         
             System.out.println("Read failed");
               return;
       }
    }  
   }

}

class JavaServ2 extends JFrame
{
     JMenuItem optionclear = new JMenuItem("Clear");
     JMenuItem optionexit  = new JMenuItem("Exit");
     JTextArea jtx = new JTextArea();   
     JavaServ2(String title)
     {
         
         super(title);  
         JMenuBar menubar = new JMenuBar();
         JMenu fileMenu = new JMenu("Options");
         menubar.add(fileMenu);
         fileMenu.add(optionclear); 
         fileMenu.add(optionexit); 
         setSize(new Dimension(400, 300));
         setJMenuBar(menubar); 
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
       JavaServ2 rt = new JavaServ2("Helllo World");
       rt.listenSocket();
     }

}


