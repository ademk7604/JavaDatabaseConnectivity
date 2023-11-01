package d02_dao.dataAcessObject;
import java.sql.*;

public class StudentDAO {
	
	private Connection conn =null;
	// her method da tekrar tekrar db ye baglanacagina bir kere constroctur arasiligiyla baglandik
	public StudentDAO() {
		databaseConnection();
	}
	
	//studentDAO silinirse yani null olursa baglanti kapansin
	@Override
	protected void finalize() throws Throwable {
		System.out.println("DB closed");
		conn.close();
	}
	
	private void databaseConnection() {
		String url = "jdbc:mysql://localhost:3306/schule";
		String username = "root";
		String pasword = "Ademk1@";
		
		try {
			conn = DriverManager.getConnection(url, username, pasword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Student getStundent(String stundentNo) throws SQLException {
		//databaseConnection(); controttur a verdik
		 
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
		//databaseConnection();
		String query = "INSERT INTO students (studentNo,userName,vorname,nachname) VALUES (?,?,?,?)";
		
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, s.getStudentNo());
		st.setString(2, s.getUserName());
		st.setString(3, s.getVorname());
		st.setString(4, s.getNachname());
		
		//bunlari calistirma zamani
		int count = st.executeUpdate();
		
		System.out.println("Ogrenci basarili eklendi!");
		
		
	}
	
	public void deleteStudent(Student s) throws SQLException {
		//databaseConnection();
		String query = "delete from students where studentNo="+s.getStudentNo();
		Statement st = conn.createStatement();
		int count = st.executeUpdate(query);
		if(count==1) {
			System.out.println("Stundent successful deleted!");
		}else {
			System.out.println("Stundent could not be deleted!");
		}
		
		
		
	}
	
	public void updateStudent(Student s, String studentNo) throws SQLException {
		//databaseConnection();
		//studentNo
		//username
		//vorname
		//nachname
		/*// bu sekilde de sql sorgusunu yazabiliriz ama sql injection probleminden dolayi PreparedStatement oalrak yapiyoruz
		String query = "update students set studentNo='"+s.getStudentNo()+
				"', userName='"+s.getUserName()+"', vorname='"+s.getVorname()+
				"', nachname='"+s.getNachname() + "' where studentNo='"+studentNo+"'";
		
		Statement st = conn.createStatement();
		int count = st.executeUpdate(query);
		if(count==1) {
			System.out.println("Stundent successful updated!");
		}else {
			System.out.println("Stundent could not be updated!");
		}
		*/
		
		String query = "UPDATE students SET studentNo=?, userName=?, vorname=?, nachname=? WHERE studentNo=?";
	    
	    PreparedStatement st = conn.prepareStatement(query);
	    
	    st.setString(1, s.getStudentNo());
	    st.setString(2, s.getUserName());
	    st.setString(3, s.getVorname());
	    st.setString(4, s.getNachname());
	    st.setString(5, studentNo);
	    
	    int count = st.executeUpdate();
	    
	    if(count==1) {
			System.out.println("Stundent successful updated!");
		}else {
			System.out.println("Stundent could not be updated!");
		}
	}

}

