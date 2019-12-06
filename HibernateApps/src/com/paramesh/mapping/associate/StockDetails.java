package com.paramesh.mapping.associate;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class StockDetails {
	
	private int stockDetailsId;
	private int openPrice;
	private int closePrice;
	private int valuems;
	private String month;
	
	
	/**
	 * @return the stockDetailsId
	 */
	public int getStockDetailsId() {
		return stockDetailsId;
	}

	/**
	 * @param stockDetailsId the stockDetailsId to set
	 */
	public void setStockDetailsId(int stockDetailsId) {
		this.stockDetailsId = stockDetailsId;
	}

	/**
	 * @return the openPrice
	 */
	public int getOpenPrice() {
		return openPrice;
	}

	/**
	 * @param openPrice
	 *            the openPrice to set
	 */
	public void setOpenPrice(int openPrice) {
		this.openPrice = openPrice;
	}

	/**
	 * @return the closePrice
	 */
	public int getClosePrice() {
		return closePrice;
	}

	/**
	 * @param closePrice
	 *            the closePrice to set
	 */
	public void setClosePrice(int closePrice) {
		this.closePrice = closePrice;
	}

	/**
	 * @return the valuems
	 */
	public int getValuems() {
		return valuems;
	}

	/**
	 * @param valuems
	 *            the valuems to set
	 */
	public void setValuems(int valuems) {
		this.valuems = valuems;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
