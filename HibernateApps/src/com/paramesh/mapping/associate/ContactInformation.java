package com.paramesh.mapping.associate;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class ContactInformation {
	
	int studentId;
	int personlaNumber;
	int homeNumber;
	Student student;
	

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the personlaNumber
	 */
	public int getPersonlaNumber() {
		return personlaNumber;
	}

	/**
	 * @param personlaNumber
	 *            the personlaNumber to set
	 */
	public void setPersonlaNumber(int personlaNumber) {
		this.personlaNumber = personlaNumber;
	}

	/**
	 * @return the homeNumber
	 */
	public int getHomeNumber() {
		return homeNumber;
	}

	/**
	 * @param homeNumber
	 *            the homeNumber to set
	 */
	public void setHomeNumber(int homeNumber) {
		this.homeNumber = homeNumber;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
}
