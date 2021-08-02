package za.ac.unisa.models;

import java.time.LocalDate;

public class Employee extends Person {
	public Employee() {

	}

	public Employee(String surname, String lastName, String emailAddress, String telePhoneNumber, String sex,
			String maritalStatus, LocalDate dateOfBirth, long idNumber, User user) {
		super(surname, lastName, emailAddress, telePhoneNumber, sex, maritalStatus, dateOfBirth, idNumber, user);
	}

	@Override
	public String toString() {
		return "Employee [getSurname()=" + getSurname() + ", getLastName()=" + getLastName() + ", getEmailAddress()="
				+ getEmailAddress() + ", getTelePhoneNumber()=" + getTelePhoneNumber() + ", getSex()=" + getSex()
				+ ", getMaritalStatus()=" + getMaritalStatus() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getIdNumber()=" + getIdNumber() + ", getUser()=" + getUser() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

}
