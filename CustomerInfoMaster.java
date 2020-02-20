package com.fedex.breco.insurance.dto;

//TABLE_TO_BE_CREATED**************************************************

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class CteAuditDetail.
 */
@Entity
@Table(name = "INSURANCE_CUST_INFO")
public class CustomerInfoMaster implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSURANCE_CUST_INFO_SEQ")
	@SequenceGenerator(name = "INS_INFO_SEQ", sequenceName = "INSURANCE_CUST_INFO_SEQ", allocationSize=1 )
	@Column(name = "ISQN_CD", columnDefinition = "")
	private Long isqnCd;

	/** FANTASY NAME. */
	@Column(name = "FT_NM_TXT", columnDefinition = "FANTASY NAME")
	private String fantacyName;

	/** COMPANY NAME. */
	@Column(name = "CO_NM_TXT", columnDefinition = "COMPANY NAME ")
	private String companyName;

	/** The tax id number. */
	@Column(name = " TAX_ID", columnDefinition = " TAX_ID")
	private String taxId;

	/** VALIDITY. */
	@Column(name = "VLD_DT", columnDefinition = "VALIDITY")
	private Date validDate;

	/** CIVIL LIABILITY OF ROAD FREIGHT FORWARDER. */
	@Column(name = "CA_LY_RD_FGT_FRWDR_DESC", columnDefinition = "CIVIL LIABILITY OF ROAD FREIGHT FORWARDER ")
	private String civilLiabilityOfRoad;

	/** CIVIL LIABILITY - CARGO / THEFT DISAPPEARANCE. */
	@Column(name = "CA_LY_CG_THFT_DISP_DESC", columnDefinition = "CIVIL LIABILITY - CARGO / THEFT DISAPPEARANCE")
	private String civilLiabilityCargo;

	/** The tax document validation reason. */
	@Column(name = "AR_CRGO_CARR_LY_INS_DESC", columnDefinition = "INTERNATIONAL ROAD HAULIER LIABILITY INSURANCE RCTR-VI")
	private String arCrgoCarr;

	/** The creation date. */
	@Column(name = "INS_CO_NM", columnDefinition = "INSURANCE COMPANY")
	private String insuranceCompany;

	/*	*//**
			 * @return the customerDetailsMaster
			 */
	/*
	 * public CustomerDetailsMaster getCustomerDetailsMaster() { return
	 * customerDetailsMaster; }
	 * 
	 *//**
		 * @param customerDetailsMaster the customerDetailsMaster to set
		 *//*
			 * public void setCustomerDetailsMaster(CustomerDetailsMaster
			 * customerDetailsMaster) { this.customerDetailsMaster = customerDetailsMaster;
			 * }
			 */

	/**
	 * @return the isqnCd
	 */
	public Long getIsqnCd() {
		return isqnCd;
	}

	/**
	 * @param isqnCd the isqnCd to set
	 */
	public void setIsqnCd(Long isqnCd) {
		this.isqnCd = isqnCd;
	}

	/**
	 * @return the fantacyName
	 */
	public String getFantacyName() {
		return fantacyName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @return the taxId
	 */
	public String getTaxId() {
		return taxId;
	}

	/**
	 * @return the validDate
	 */
	public Date getValidDate() {
		return validDate;
	}

	/**
	 * @return the civilLiabilityOfRoad
	 */
	public String getCivilLiabilityOfRoad() {
		return civilLiabilityOfRoad;
	}

	/**
	 * @return the civilLiabilityCargo
	 */
	public String getCivilLiabilityCargo() {
		return civilLiabilityCargo;
	}

	/**
	 * @return the arCrgoCarr
	 */
	public String getArCrgoCarr() {
		return arCrgoCarr;
	}

	/**
	 * @return the insuranceCompany
	 */
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	/**
	 * @param fantacyName the fantacyName to set
	 */
	public void setFantacyName(String fantacyName) {
		this.fantacyName = fantacyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @param taxId the taxId to set
	 */
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	/**
	 * @param validDate the validDate to set
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	/**
	 * @param civilLiabilityOfRoad the civilLiabilityOfRoad to set
	 */
	public void setCivilLiabilityOfRoad(String civilLiabilityOfRoad) {
		this.civilLiabilityOfRoad = civilLiabilityOfRoad;
	}

	/**
	 * @param civilLiabilityCargo the civilLiabilityCargo to set
	 */
	public void setCivilLiabilityCargo(String civilLiabilityCargo) {
		this.civilLiabilityCargo = civilLiabilityCargo;
	}

	/**
	 * @param arCrgoCarr the arCrgoCarr to set
	 */
	public void setArCrgoCarr(String arCrgoCarr) {
		this.arCrgoCarr = arCrgoCarr;
	}

	/**
	 * @param insuranceCompany the insuranceCompany to set
	 */
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

}
