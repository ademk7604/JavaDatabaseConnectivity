package d01;
// 1. import java.sql
// 2 load and register the driver
// 3. create connection
// 4. cteate a statement 
// 5.execute the query
// 6.process the results
// 7. close
import java.sql.*;
public class Driver {
	public static void main(String[] args) throws SQLException {
		String url ="jdbc:mysql://localhost3306/schule";
		String username = "root";
		String password = "Ademk1@";
		String query = "select * from students";
		
		Connection conn = null;
		
			conn = DriverManager.getConnection(url, username, password);
	
		
		//SQL Komutlarinin kategorileri (DDL, DML, DQL, TCL, DCL)
		//DDL (CREATE, DROP, ALTER, TRUNCATE)
		//DML (INSERT, UPDATE, DELETE, CALL, EXPLAIN CALL, LOCK
		//DQL (SELECT)
		
		Statement st = conn.prepareStatement(query);
		ResultSet rs = st.executeQuery(query);
		
		
		
		// ID
		int stundentID = rs.getInt("ID");
		
		// stundentNo
		String stundentNo = rs.getString("studentNo");
		
		// userName
		String userName = rs.getString("userName");
		
		// vorname
		String vorname = rs.getString("vorname");
		// nachname
		String nachname = rs.getString("nachname");
		System.out.println("ID: "+stundentID+ " StudentNo: "+stundentNo+
				" Adi Soyadi: "+username+" vorname: "+vorname+" nachname: "+nachname);
		
		
		
	}
}
