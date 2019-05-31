
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException;
//import java.sql.*;
//import java.util.Properties;

public class HelloMySQL {

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    System.out.println("start");
   try
	   {
	   System.out.println("driver");
	   Class.forName("com.mysql.jdbc.Driver");
	   System.out.println("getting connection...");
	   
	   //When this class (DriverManager) first attempts to establish a connection, it automatically loads
	   //any JDBC 4.0 drivers found within the class path. Note that your application must
	   //manually load any JDBC drivers prior to version 4.0.
	   conn = DriverManager.getConnection("jdbc:mysql://ubu-mysql/integration?autoReconnect=true&useSSL=false","integrate","integrate");
	   System.out.println("creating stmt...");
	   stmt = conn.createStatement();
	   rs = stmt.executeQuery("select now()");	   
	   while(rs.next())
	       System.out.println(rs.getString(1));
	   System.out.println("end");
	   }catch(Exception e)	   			   
	   {
		   System.out.println("Exception caught! Details:");
		   System.out.println(e.getMessage());		   
		   throw e;
	   }finally
	   {
	     rs.close();
	     stmt.close();
	     conn.close();
	   }
		
		
	}
	
}

