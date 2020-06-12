//////////////////////////////////////////////////
//
//
//
//
import java.lang.*;
import java.sql.*;
import java.text.*;
import sun.jdbc.odbc.*;
import java.util.*;
/////////////////////////////////////////
//
//
//
//
class GetMilliSecondsSince1970 extends GregorianCalendar
{
    public long getTimeInMillis() 
    {
       return super.getTimeInMillis();
    }

   GetMilliSecondsSince1970( int year , int month , int day , int hour , int minute )
   {
          super(year,month,day,hour,minute);

   }

}
////////////////////////////////////////////
//
//
//
//

public class UpdateJDBC
{
   public static void main(String arg[]) 
   {
      int id;
      String status;
      String result;

      try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Class.forName("java.awt.Buttont");

        String url = "jdbc:odbc:CYBERDATA";
        Connection con = DriverManager.getConnection(url,"", "");
        String sqlselect = "INSERT INTO USERTAB VALUES( ? , ? , ?)";
        PreparedStatement stmt = con.prepareStatement(sqlselect);
        stmt.setInt(1,234);       
        stmt.setString(2, "Test Data");
        GetMilliSecondsSince1970 sr = new GetMilliSecondsSince1970(1900+90,10,1,10,5);
        stmt.setTimestamp(3, new java.sql.Timestamp(sr.getTimeInMillis()));
        int count = stmt.executeUpdate();
        con.close();
        }
     catch(Exception e) 
        {
           System.out.println(e.getMessage());
        }
      }

}