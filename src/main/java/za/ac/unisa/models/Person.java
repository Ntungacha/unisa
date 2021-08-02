package za.ac.unisa.models;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
	private String surname;
	private String lastName;
	private String emailAddress;
	private String telePhoneNumber;
	private String sex;
	private String maritalStatus;
	private LocalDate dateOfBirth;
	private Long idNumber;
	private User user;

	public Person() {

	}

	public Person(String surname, String lastName, String emailAddress, String telePhoneNumber, String sex,
			String maritalStatus, LocalDate dateOfBirth, Long idNumber) {
		super();
		this.surname = surname;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.telePhoneNumber = telePhoneNumber;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.dateOfBirth = dateOfBirth;
		this.idNumber = idNumber;
	}

	public Person(String surname, String lastName, String emailAddress, String telePhoneNumber, String sex,
			String maritalStatus, LocalDate dateOfBirth, long idNumber, User user) {
		super();
		this.surname = surname;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.telePhoneNumber = telePhoneNumber;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.dateOfBirth = dateOfBirth;
		this.idNumber = idNumber;
		this.user = user;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTelePhoneNumber() {
		return telePhoneNumber;
	}

	public void setTelePhoneNumber(String telePhoneNumber) {
		this.telePhoneNumber = telePhoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {
		return "Person [surname=" + surname + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", telePhoneNumber=" + telePhoneNumber + ", sex=" + sex + ", maritalStatus=" + maritalStatus
				+ ", dateOfBirth=" + dateOfBirth + ", idNumber=" + idNumber + ", user=" + user + "]";
	}

	public int hashCode() {
		return Objects.hash(dateOfBirth, emailAddress, idNumber, lastName, maritalStatus, sex, surname, telePhoneNumber,
				user);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(idNumber, other.idNumber) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(maritalStatus, other.maritalStatus) && Objects.equals(sex, other.sex)
				&& Objects.equals(surname, other.surname) && Objects.equals(telePhoneNumber, other.telePhoneNumber)
				&& Objects.equals(user, other.user);
	}

}
