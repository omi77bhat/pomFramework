package testComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
	
		String host = "localhost";
		String port = "3306";
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "mysqlomi77");
		
		Statement s = connect.createStatement();
		
		
		ResultSet rs = s.executeQuery("select * from Employeeinfo where id = 1");
		rs.next();
		
//		System.out.println("Query Result ->>>>>>> " + rs.getArray(0));
		
		System.out.println(rs.getString("name"));

	}

}
