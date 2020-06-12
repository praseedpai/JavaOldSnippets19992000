import java.util.Date;
import java.rmi.*;
public class CalendarUser {
  public CalendarUser() {}
  public static void main(String args[]) {
    long       t1=0,t2=0;
    Date       date;
    iCalendar  remoteCal;
    try {
      remoteCal = (iCalendar)
                  Naming.lookup("rmi://PAI/CalendarImpl");
      t1 = remoteCal.getDate().getTime();
      System.out.println("sadffffffffffffff"+t1);
      t2 = remoteCal.getDate().getTime();
      System.out.println("sadffffffffffffff"+t2);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("This RMI call took " + (t2-t1) +
                       " milliseconds");
  }


}
