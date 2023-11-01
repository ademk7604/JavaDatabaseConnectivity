package d02_dao.dataAcessObject;

import java.sql.SQLException;

public class MethodTestStartUp {
	
	public static void main(String[] args) throws SQLException {
		StudentDAO studentDAO = new StudentDAO();
		//21401747
		
		Student student1 = studentDAO.getStundent("21401747");
		
		Student student2 = studentDAO.getStundent("11111111");
		if(student1 != null) {
			student1.bilgiVer();
		}else {
			System.out.println("Student not found");
		}
		
		if(student2 != null) {
			student2.bilgiVer();
		}else {
			System.out.println("Student not found");
		}
		
		//Ogrenci ekleyelim
		Student eklenecekStudent = new Student();
		eklenecekStudent.setStudentNo("15256633");
		eklenecekStudent.setUserName("Cemilk");
		eklenecekStudent.setVorname("Cemil");
		eklenecekStudent.setNachname("karbon");
		
		studentDAO.setStudent(eklenecekStudent);
		
		//Ogrenci silelim
		studentDAO.deleteStudent(eklenecekStudent);
		
		eklenecekStudent.setStudentNo("23137355");
		eklenecekStudent.setUserName("Alimk");
		eklenecekStudent.setVorname("Alimmk");
		eklenecekStudent.setNachname("barutmk");
		
		studentDAO.setStudent(eklenecekStudent);

		
		// ogrenci guncelleyelim
		eklenecekStudent.setUserName("Alimm6");
		studentDAO.updateStudent(eklenecekStudent, eklenecekStudent.getStudentNo());
		
		eklenecekStudent.setNachname("barutsuzum");
		studentDAO.updateStudent(eklenecekStudent, eklenecekStudent.getStudentNo());
		// calistirildiginda hata vermesinin nedeni 38 sayirdaki  setStudentNo den itibaren bazi verielri degistirmek lazim
		//isim bittiginde kapatalim
		studentDAO = null;
		System.gc(); // bos bolge cope gitti
	}

}
