package d02_dao.dataAcessObject;
import java.sql.*;

public class StudentDAO {
	
	private Connection conn =null;
	
	private void databaseConnection() {
		String url = "jdbc:mysql://localhost:3306/students";
		String username = "root";
		String pasword = "Ademk1@";
		
		try {
			conn = DriverManager.getConnection(url, username, pasword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Student getStundent(String stundentNo) throws SQLException {
		databaseConnection();
		 
		 Student s = new Student();
		 
		 String query = "select * from students where studentNo="+stundentNo;
		 Statement st = conn.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 
		 if(rs.next()) {
			 s.setID(rs.getInt("ID"));
			 s.setStudentNo(stundentNo);
			 s.setUserName(rs.getString("userName"));
			 s.setVorname(rs.getString("vorname"));
			 s.setNachname(rs.getString("nachname"));
		 } else {
			 s = null;
		 }
		return s;
	}
	
	public void setStudent(Student s) throws SQLException {
		databaseConnection();
		String query = "INSERT INTO (stundetNo,userName,vorname,nachname) VALUES (?,?,?,?)";
		
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, s.getStudentNo());
		st.setString(2, s.getUserName());
		st.setString(3, s.getVorname());
		st.setString(4, s.getNachname());
		
		//bunlari calistirma zamani
		int count = st.executeUpdate();
		
		System.out.println("Ogrenci basarili eklendi!");
		
		
	}
	
	
}
