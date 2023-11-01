package d02_dao.dataAcessObject;

public class Student {
	
	private int ID;
	private String studentNo;
	private String userName;
	private String vorname;
	private String nachname;
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public void bilgiVer() {
		String bilgi = "StundentNo: "+studentNo+" UserName: "+userName+" Vorname: "+vorname+" Nachname: "+nachname;
		System.out.println(bilgi);
	}
	

}
