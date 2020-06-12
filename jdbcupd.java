import java.lang.*;
import java.sql.*;
import java.text.*;
import sun.jdbc.odbc.*;
import java.util.*;

class lps extends GregorianCalendar
{
  public long getTimeInMillis() {
    return super.getTimeInMillis();
   }

  lps( int year , int month , int day , int hour , int minute )
  {
          super(year,month,day,hour,minute);

  }

}

public class jdbcupd
{
   public static void main(String arg[]) 
   {
      int id;
      String status;
      String result;

     try {
        //connect to ODBC database
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc:CYBERDATA";
        // connect
        Connection con = DriverManager.getConnection(url,"", "");
        // create Statement object

        //Statement stmt = con.createStatement();
        
        String sqlselect = "INSERT INTO USERTAB VALUES( ? , ? , ?)";
        //Statement stmt  =con.prepareStatement(sqlselect);
        PreparedStatement stmt = con.prepareStatement(sqlselect);
        stmt.setInt(1,234);       
        stmt.setString(2, "PAIS");
        lps sr = new lps(1900+90,10,1,10,5);
        stmt.setDate(3, new java.sql.Date(sr.getTimeInMillis()));
        //stmt.setString(5,"OP");
        int count = stmt.executeUpdate();

               // run query
        //ResultSet rs = stmt.executeQuery(sqlselect);
        // process results
        //while(rs.next()) {
          //      result  = "";
            //    id      = rs.getInt(1);
              //  status  = rs.getString(2);
               // result = result.valueOf(id) + " "+status;
               // System.out.println("Values are: " + result);
                //}

        //close connection
        con.close();
        }
     catch(Exception e) {
           System.out.println(e.getMessage());
        }
}


}