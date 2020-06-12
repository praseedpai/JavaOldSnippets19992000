
import java.io.*;
import java.net.*;


public class wclient 
{
   public static void main(String args[])
    {
        try
        {
            
            Socket clientSocket1 = new Socket("199.199.0.11", 430);
            DataOutputStream outbound = new DataOutputStream(
                clientSocket1.getOutputStream() );
            String ps = "PAI IS A FOOL";
  
            outbound.writeBytes(ps.getBytes());
            outbound.flush();
            clientSocket1.close();   
            
        }
        catch (UnknownHostException uhe)
        {
            System.out.println("UnknownHostException: " + uhe);
        }
        catch (IOException ioe)
        {
            System.err.println("IOException: " + ioe);
        }
    }

  

}
