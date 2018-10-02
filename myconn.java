package minor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class myconn {

	String jdbcUrl;
	
	public myconn(){
		jdbcUrl = "jdbc:sqlserver://localhost:50909;databaseName=minor;integratedSecurity=true;";
	}
	
	public Connection getconn(){
		Connection con=null;
		
		   try {
              
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               System.out.println("# - Driver Loaded");
              
                con = DriverManager.getConnection(jdbcUrl);
               System.out.println("# - Connection Obtained");
              
               Statement stmt = con.createStatement();
               System.out.println("# - Statement Created");
              
               ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM patinfo;");
               System.out.println("# - Query Executed");
              
               if(rs.next()) {
                       System.out.println("Product Count : "+rs.getInt(1));
               }
              
               rs.close();
               stmt.close();
              // con.close();
               System.out.println("# - Resources released");
       } catch (Exception ex) {
               System.out.println("Error : "+ex);
       }
		return con;
		
	}
	
	
	
	
}
