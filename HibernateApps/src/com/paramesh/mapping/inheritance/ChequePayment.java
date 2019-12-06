package com.paramesh.mapping.inheritance;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class ChequePayment extends Payments{
	
	private String chequePaymentId;
	private String chequeType;
	private String chequeHolderName;
		
	/**
	 * @return the chequePaymentId
	 */
	public String getChequePaymentId() {
		return chequePaymentId;
	}
	/**
	 * @param chequePaymentId the chequePaymentId to set
	 */
	public void setChequePaymentId(String chequePaymentId) {
		this.chequePaymentId = chequePaymentId;
	}
	/**
	 * @return the chequeType
	 */
	public String getChequeType() {
		return chequeType;
	}
	/**
	 * @param chequeType the chequeType to set
	 */
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	/**
	 * @return the chequeHolderName
	 */
	public String getChequeHolderName() {
		return chequeHolderName;
	}
	/**
	 * @param chequeHolderName the chequeHolderName to set
	 */
	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}
	
}
