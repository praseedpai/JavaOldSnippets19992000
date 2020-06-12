//////////////////////////
//
//
//
//
//
//
import java.net.*;
import java.io.*;

public class Cross 
{
   public static void main(String[] as )
   {
      
      OutputStream out;
      InputStream  in;  
      try {
      Socket socket = new Socket("PAI",250);
      out = socket.getOutputStream();
      in = socket.getInputStream();
      String st = "Hello World From Pai";
      out.write(st.getBytes()); 
      Thread.sleep(500);
      
     }
     catch(Exception e)
     {
      

     } 
    
      
      
      


   }






}

