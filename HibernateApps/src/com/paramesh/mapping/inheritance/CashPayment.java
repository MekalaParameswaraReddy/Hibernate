package com.paramesh.mapping.inheritance;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class CashPayment extends Payments{
	
	private String cashPaymentId;
	String personName;
	
	
	/**
	 * @return the cashPaymentId
	 */
	public String getCashPaymentId() {
		return cashPaymentId;
	}
	/**
	 * @param cashPaymentId the cashPaymentId to set
	 */
	public void setCashPaymentId(String cashPaymentId) {
		this.cashPaymentId = cashPaymentId;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
}
