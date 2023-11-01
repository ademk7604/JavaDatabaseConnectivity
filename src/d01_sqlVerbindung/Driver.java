package d01_sqlVerbindung;
// 1. import java.sql
// 2 load and register the driver
// 3. create connection
// 4. cteate a statement 
// 5.execute the query
// 6.process the results
// 7. close
import java.sql.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/schule";
		String username = "root";
		String password = "Ademk1@";
		String query = "select * from students";
		
		Connection conn = null;
		
			conn = DriverManager.getConnection(url, username, password);
	
		
		//SQL Komutlarinin kategorileri (DDL, DML, DQL, TCL, DCL)
		//DDL (CREATE, DROP, ALTER, TRUNCATE)
		//DML (INSERT, UPDATE, DELETE, CALL, EXPLAIN CALL, LOCK
		//DQL (SELECT) veriyi okumak
		
		//Statement st = conn.prepareStatement(query); HACK lenmeye karsin PreparedStatement kullaniyoruz
		PreparedStatement st = conn.prepareStatement(query);
		ResultSet rs = st.executeQuery(query); //DQL islemi
		
		// next diyerek verileri ilk siradan baslayarak tum verileri tek tek aliyorum 
	while(rs.next()) {
		int stundentID = rs.getInt("ID");
		String stundentNo = rs.getString("studentNo");
		String userName = rs.getString("userName");
		String vorname = rs.getString("vorname");
		String nachname = rs.getString("nachname");
		System.out.println("ID: "+stundentID+ " StudentNo: "+stundentNo+
				" Username: "+userName+" Vorname: "+vorname+" Nachname: "+nachname);
		
	}
	/*
	// TABI bu yolla verileri eklemiyoruz HACK lenmeye karsin 
	// bunun yerine prepareStatement kullanarak ogrenci verilerini dolayli yoldan eklenmesini saglayacak
	// yeni ogrenci ekleme
	query = "INSERT INTO students (studentNo, userName, vorname, nachname) VALUES ('1833847','melikeburc','melike','Burc')";
	//SQL incection ederek DB de problemlere sebep olabiliyor
	// Bu bir guvenlik acigina neden oluyor. bunun yerine PreparedStatement sayesinde asagidako query i  yapiyoruz 
	int count = st.executeUpdate(query);
	System.out.println(count+ " satir etkilendi!");
	*/
	
	
	//query = "INSERT INTO students (studentNo, userName, vorname, nachname) VALUES ('1833847','melikeburc','melike','Burc')";
	query = "INSERT INTO students (studentNo, userName, vorname, nachname) VALUES (?,?,?,?)";
	st = conn.prepareStatement(query);
	
	st.setString(1, "1357555");
	st.setString(2, "yunusk123");
	st.setString(3, "Yunusk");
	st.setString(4, "Kayamakk");
	//bu sekilde SQL Injection saldirilarina karsi guvenli bir kod olusturmnus olursunuz.
	int count = st.executeUpdate();//update islemi oldugu icin tekrar query gondermiyoruz //DML islemi
	System.out.println(count+ " satir etkilendi!");
	
	// Hadi konsoldan verileri girelim ORNEK
	String studentNo, userName, vorname, nachname;
	Scanner sc = new Scanner(System.in);
	System.out.print("studentNo: ");
	studentNo = sc.nextLine();
	System.out.print("userName: ");
	userName = sc.nextLine();
	System.out.print("vorname: ");
	vorname = sc.nextLine();
	System.out.print("nachname: ");
	nachname = sc.nextLine();
	
	st.setString(1, studentNo);
	st.setString(2, userName);
	st.setString(3, vorname);
	st.setString(4, nachname);
	
	count = st.executeUpdate();
	System.out.println(count+ " satir etkilendi!");
	
	st.close();
	conn.close();
	/*
	 * Bu derste Statement ile PreparedStatement  arasindaki farklari 
	 * kullanican veri alma gibi kavamlari ogrenmis olduk
	 */

		
	}
}
