import java.lang.*;
import java.sql.*;
import sun.jdbc.odbc.*;

public class jdbc
{
   public static void main(String arg[]) 
   {
      int id;
      String status;
      String result;
      Timestamp ls;
     try {
        //connect to ODBC database
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc:CYBERDATA";
        // connect
        Connection con = DriverManager.getConnection(url,"", "");
        // create Statement object

        Statement stmt = con.createStatement();

        String sqlselect = "Select id, name,TDate from USERTAB";
               // run query
        ResultSet rs = stmt.executeQuery(sqlselect);
        // process results
        while(rs.next()) {
                result  = "";
                id      = rs.getInt(1);
                status  = rs.getString(2);
                ls      = rs.getTimestamp("TDate");
                result = result.valueOf(id) + " "+status + "  " + ls.toString();
                System.out.println("Values are: " + result);
                }

        //close connection
        con.close();
        }
     catch(Exception e) {
           System.out.println(e.getMessage());
        }
}


}