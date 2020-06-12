import java.net.*;
import java.io.*;
import java.lang.System;

public class PortTalkApp
{
	public static void main(String args[])
	{
		PortTalk portTalk	= new PortTalk(args); 
		portTalk.displayDestinationParameters();
		portTalk.displayLocalParameters();
		portTalk.chat();
		portTalk.shutdown();
	}
}

class PortTalk
{
	Socket connection;
	DataOutputStream outStream; 
	BufferedReader inStream;

	public PortTalk(String args[])
	{
		if (args.length != 2)
			error("Usage: java PortTalkApp host port");
		String destination	= args[0];
		int port = 0;
		try
		{
			port = Integer.valueOf(args[1]).intValue(); // returns the integer
		}
		catch(NumberFormatException ex)
		{
			error("Invalid port number");
		}
		try
		{
			connection = new Socket(destination, port);
		}
		catch(UnknownHostException ex)
		{
			error("UnknownHost");
		}
		catch(IOException ex)
		{
			error("IO error creating socket");
		}
		try
		{
			inStream	= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outStream	= new DataOutputStream(connection.getOutputStream());
		}
		catch(IOException ex)
		{
			error("IO error getting streams");
		}
		System.out.println("Connected to " + destination + "at port " + port + ".");
	}
	
	public void displayDestinationParameters()
	{
		InetAddress destAddress = connection.getInetAddress();
		String name				= destAddress.getHostName();
		byte ipAddress[]		= destAddress.getAddress();
		int port				= connection.getPort();
		displayParameters("Destination", name, ipAddress, port);
	}

	public void displayLocalParameters()
	{
		InetAddress localAddress	= null;
		try
		{
			localAddress	= InetAddress.getLocalHost();
		}
		catch(UnknownHostException ex)
		{
			error("Error getting local host information");
		}
		String name			= localAddress.getHostName();
		byte ipAddress[]	= localAddress.getAddress();
		int port			= connection.getLocalPort();
		displayParameters("Local", name, ipAddress, port);
	}

	public void displayParameters(String s, String name, byte ipAddress[], int port)
	{
		System.out.println(s+ " host is " + name + ".");
		for(int i=0; i<ipAddress.length; ++i)
			System.out.print((ipAddress[i] + 256)%256 + ".");
		System.out.println();
		System.out.print(s + " port number is " + port + ".");
	}

	public void chat()
	{
		BufferedReader keyboardInput	= new BufferedReader(new InputStreamReader(System.in));
		boolean finished	= false;
		do
		{
			try
			{
				System.out.print("Send, receive or quit (S/R/Q): ");
				System.out.flush();
				String line	= keyboardInput.readLine();
				if(line.length()>0)
				{
					line = line.toUpperCase();
					switch(line.charAt(0))
					{
					case 'S':
						String sendLine	= keyboardInput.readLine();
						outStream.writeBytes(sendLine);
						outStream.write(13);
						outStream.write(10);
						outStream.flush();
						break;
					case 'R':
						int inByte;
						System.out.print("***");
						while((inByte = inStream.read()) != '\n')
						{
								System.out.write(inByte);
							
						}
						System.out.println();
						break;
					case 'Q':
						finished	= true;
						break;
					default:
						break;
					}
				}
			}catch(IOException ex)
			{
				error("Error reading from keyboard or socket");
			}
		}while(!finished);
	}

	public void shutdown()
	{
		try
		{
			connection.close();
		}
		catch(IOException ex)
		{
			error("IO error closing socket");
		}
	}

	public void error(String s)
	{
		System.out.println(s);
		System.exit(1);
	}
}

































