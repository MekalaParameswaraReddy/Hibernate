package com.paramesh.mapping.associate;

import java.util.List;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Stock {

	private int stockId;
	private String stockName;
	private List<StockDetails> stockDetails;

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	/**
	 * @param stockName
	 *            the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * @return the stockDetails
	 */
	public List<StockDetails> getStockDetails() {
		return stockDetails;
	}

	/**
	 * @param stockDetails the stockDetails to set
	 */
	public void setStockDetails(List<StockDetails> stockDetails) {
		this.stockDetails = stockDetails;
	}

}
