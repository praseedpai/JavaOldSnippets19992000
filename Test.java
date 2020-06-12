import java.net.*;

public class Test
{
	public static void main(String args[]) throws UnknownHostException
	{
		InetAddress host = InetAddress.getByName("");
		System.out.println("Host NAme is "+ host.getHostName());
		System.out.println("Host Ip is "+ host.getHostAddress());
	}
}