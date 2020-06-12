import java.net.*;
import java.io.*;

public class ReverServerApp
{
	public static void main(String args[])
	{
		String outLine =null;

		try
		{     
			ServerSocket server	= new ServerSocket(1037);
			int localPort		= server.getLocalPort();
			System.out.println("Reverse Server is listening on port " + localPort + ".");
			Socket client		= server.accept();
			String destName		= client.getInetAddress().getHostName();
			int destPort		= client.getPort();
			System.out.println("Accepted connection to " + destName + " on port " + destPort + ".");
			BufferedReader inStream	= new BufferedReader(new InputStreamReader(client.getInputStream()));
			DataOutputStream outStream	= new DataOutputStream(client.getOutputStream());
			boolean finished	= false;

			do
			{
				String inLine = inStream.readLine();
				if(inLine.equalsIgnoreCase("quit"))
					finished = true;
				System.out.println("inlineS" + inLine);
					
                  

				for(int i=0; i<inLine.length(); ++i)
					outStream.write((byte)inLine.charAt(i));
				outStream.write(13);
				outStream.write(10);
				outStream.flush();
				System.out.println("Sent: " + inLine);
			} while(!finished);
			inStream.close();
			outStream.close();
			client.close();
			server.close();
		}
		catch(IOException ex)
		{
			System.out.println("IOException occurred. ");
		}
	}
}
/*
class ReverseString
{
	String s;

	public ReverseString(String in)
	{
		int len	= in.length();
		char outChars[] = new char[len];
		for(int i=0; i<len; i++)
			outChars[len - 1 - i] = in.charAt(i);
		s	= String.valueOf(outChars); 
	}
	public String getString()
	{
		return s;
	}

}
*/



