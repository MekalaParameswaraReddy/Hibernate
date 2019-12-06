package com.paramesh.mapping.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Member {
	
	int memberId;
	String name;
	List<String> benifitPlan;
	Set<String> uniqueBenifitPlan;
	Map<String, String> planNameAndExplanation;
	
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the benifitPlan
	 */
	public List<String> getBenifitPlan() {
		return benifitPlan;
	}
	/**
	 * @param benifitPlan the benifitPlan to set
	 */
	public void setBenifitPlan(List<String> benifitPlan) {
		this.benifitPlan = benifitPlan;
	}
	/**
	 * @return the uniqueBenifitPlan
	 */
	public Set<String> getUniqueBenifitPlan() {
		return uniqueBenifitPlan;
	}
	/**
	 * @param uniqueBenifitPlan the uniqueBenifitPlan to set
	 */
	public void setUniqueBenifitPlan(Set<String> uniqueBenifitPlan) {
		this.uniqueBenifitPlan = uniqueBenifitPlan;
	}
	/**
	 * @return the planNameAndExplanation
	 */
	public Map<String, String> getPlanNameAndExplanation() {
		return planNameAndExplanation;
	}
	/**
	 * @param planNameAndExplanation the planNameAndExplanation to set
	 */
	public void setPlanNameAndExplanation(Map<String, String> planNameAndExplanation) {
		this.planNameAndExplanation = planNameAndExplanation;
	}		
}
