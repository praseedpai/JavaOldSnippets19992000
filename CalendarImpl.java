////////////////////////////////
///
//
//
//
//
import java.util.Date;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class CalendarImpl  extends UnicastRemoteObject  implements iCalendar 
{
  public CalendarImpl() throws RemoteException 
  {

  }

  public Date getDate () throws RemoteException 
  {
    return new Date();
  }

  public static void main(String args[]) {
    CalendarImpl cal;
    try {
      LocateRegistry.createRegistry(2099);
      cal = new CalendarImpl();
      Naming.bind("rmi://PAI/CalendarImpl", cal);
      System.out.println("Ready for RMI's");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
