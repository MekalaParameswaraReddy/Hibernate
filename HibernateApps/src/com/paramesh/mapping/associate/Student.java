package com.paramesh.mapping.associate;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Student {

	private int id;
	private String name;
	ContactInformation contactInformation;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contactInformation
	 */
	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	/**
	 * @param contactInformation the contactInformation to set
	 */
	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}	
}
