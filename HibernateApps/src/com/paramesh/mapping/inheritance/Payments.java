package com.paramesh.mapping.inheritance;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Payments {
	
	private int paymentId;
	private String customerName;
	private int paymentAmount;
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	/**
	 * @return the paymentAmount
	 */
	public int getPaymentAmount() {
		return paymentAmount;
	}
	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
}

