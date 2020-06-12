/////////////////////////////////////
//
//
//
//
import java.lang.*;
import java.sql.*;
import sun.jdbc.odbc.*;
///////////////////////////////////////
//
//
//
//
public class RetData
{
 
  public static void main(String arg[]) 
   {
      int id;
      String status;
      String result;
      Timestamp ls;

      try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc:CYBERDATA";
        Connection con = DriverManager.getConnection(url,"", "");
        Statement stmt = con.createStatement();
        String sqlselect = "Select id, name,TDate from USERTAB";
        ResultSet rs = stmt.executeQuery(sqlselect);
        while(rs.next()) 
        {
                result  = "";
                id      = rs.getInt(rs.findColumn("id"));
                status  = rs.getString(2);
                ls      = rs.getTimestamp("TDate");
                result = result.valueOf(id) + " "+status + "  " + ls.toString();
                System.out.println("Values are: " + result);
        }
        con.close();
        }
     catch(Exception e) {
           System.out.println(e.getMessage());
        }
}


}
