package za.ac.unisa.models;

import java.time.LocalDate;

public class Student extends Person {
	private String course;

	public Student() {
	}
	public Student(String surname, String lastName, String emailAddress, String telePhoneNumber, String sex,
			String maritalStatus, LocalDate dateOfBirth, long idNumber, String course) {
		super(surname, lastName, emailAddress, telePhoneNumber, sex, maritalStatus, dateOfBirth, idNumber);
		this.course = course;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [course=" + course + ", getSurname()=" + getSurname() + ", getLastName()=" + getLastName()
				+ ", getEmailAddress()=" + getEmailAddress() + ", getTelePhoneNumber()=" + getTelePhoneNumber()
				+ ", getSex()=" + getSex() + ", getMaritalStatus()=" + getMaritalStatus() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getIdNumber()=" + getIdNumber()+ "]";
	}
	
	

}
