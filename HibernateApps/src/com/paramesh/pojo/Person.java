package com.paramesh.pojo;

import java.io.Serializable;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Person implements Serializable {
	
	int id;
	int aadhaar;
	int socialSecurityNumber;
	String firstName;
	String lastName;
	String gender;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the aadhaar
	 */
	public int getAadhaar() {
		return aadhaar;
	}

	/**
	 * @param aadhaar
	 *            the aadhaar to set
	 */
	public void setAadhaar(int aadhaar) {
		this.aadhaar = aadhaar;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the socialSecurityNumber
	 */
	public int getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * @param socialSecurityNumber
	 *            the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(int socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
}
