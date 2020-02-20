package com.fedex.breco.insurance.cte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="INS_CTE_AUDIT_DETAIL")
public class InsuranceCteAuditDetail implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cte audit id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "INS_CTE_ADT_SEQ")
	@SequenceGenerator(name = "INS_CTE_ADT_SEQ", sequenceName = "INS_CTE_ADT_SEQ", allocationSize=1)
	@Column(name="ISQN_CD", columnDefinition = "SEQUENCE GENERATED VALUE")
	private Long cteAuditId;
	
	/** The cte identity master. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = false)
	private InsuranceCteIdentityMaster cteIdentityMaster;
	
	/** The cte code. */
	@Column(name = "CT_E_CD", columnDefinition = "CONHECIMENTO DE TRANSPORTE ELETRONICO")
	private String cteCode;
	
	/** The tax document active status number. */
	@Column(name = "TAX_DOC_ACT_STAT_NBR", columnDefinition = "INFPROT_VERAPLIC")
	private String taxDocumentActiveStatusNumber;
	
	/** The tax document digital value. */
	@Column(name = "TAX_DOC_DG_VAL_DESC", columnDefinition = "INFPROT_DIGVAL")
	private String taxDocumentDigitalValue;
	
	/** The tax document entry date. */
	@Column(name = "TAX_DOC_ENTR_DT", columnDefinition = "INFPROT_DHRECBTO")
	@Temporal(TemporalType.DATE)
	private Date taxDocumentEntryDate;
		
	/** The tax document environment id. */
	@Column(name = "TAX_DOC_ENV_ID", columnDefinition = "INFPROT_TPAMB")
	private String taxDocumentEnvironmentId;
	
	/** The tax document issuer state code. */
	@Column(name = "TAX_DOC_IAD_ST_CD", columnDefinition = "INFPROT_CSTAT")
	private String taxDocumentIssuerStateCode;
	
	/** The tax document number. */
	@Column(name = "TAX_DOC_NBR", columnDefinition = "INFPROT_NPROT")
	private String taxDocumentNumber;
	
	/** The tax document validation reason. */
	@Column(name = "TAX_DOC_VLDTN_RESN_TXT", columnDefinition = "INFPROT_XMOTIVO")
	private String taxDocumentValidationReason;
	
	 /** The creation date. */
    @Column(name="CREATE_DT", columnDefinition = "CREATE_DT")
    private Date creationDate;
  
    /** The last modification date. */
    @Column(name="MODFY_DT", columnDefinition = "MODFY_DT")
    private Date lastModificationDate;

	/**
	 * Gets the cte audit id.
	 *
	 * @return the cte audit id
	 */
	public Long getCteAuditId() {
		return cteAuditId;
	}

	/**
	 * Sets the cte audit id.
	 *
	 * @param cteAuditId the new cte audit id
	 */
	public void setCteAuditId(Long cteAuditId) {
		this.cteAuditId = cteAuditId;
	}

	/**
	 * Gets the cte identity master.
	 *
	 * @return the cte identity master
	 */
	public InsuranceCteIdentityMaster getCteIdentityMaster() {
		return cteIdentityMaster;
	}

	/**
	 * Sets the cte identity master.
	 *
	 * @param cteIdentityMaster the new cte identity master
	 */
	public void setCteIdentityMaster(InsuranceCteIdentityMaster cteIdentityMaster) {
		this.cteIdentityMaster = cteIdentityMaster;
	}

	/**
	 * Gets the cte code.
	 *
	 * @return the cte code
	 */
	public String getCteCode() {
		return cteCode;
	}

	/**
	 * Sets the cte code.
	 *
	 * @param cteCode the new cte code
	 */
	public void setCteCode(String cteCode) {
		this.cteCode = cteCode;
	}

	/**
	 * Gets the tax document active status number.
	 *
	 * @return the tax document active status number
	 */
	public String getTaxDocumentActiveStatusNumber() {
		return taxDocumentActiveStatusNumber;
	}

	/**
	 * Sets the tax document active status number.
	 *
	 * @param taxDocumentActiveStatusNumber the new tax document active status number
	 */
	public void setTaxDocumentActiveStatusNumber(String taxDocumentActiveStatusNumber) {
		this.taxDocumentActiveStatusNumber = taxDocumentActiveStatusNumber;
	}

	/**
	 * Gets the tax document digital value.
	 *
	 * @return the tax document digital value
	 */
	public String getTaxDocumentDigitalValue() {
		return taxDocumentDigitalValue;
	}

	/**
	 * Sets the tax document digital value.
	 *
	 * @param taxDocumentDigitalValue the new tax document digital value
	 */
	public void setTaxDocumentDigitalValue(String taxDocumentDigitalValue) {
		this.taxDocumentDigitalValue = taxDocumentDigitalValue;
	}

	/**
	 * Gets the tax document entry date.
	 *
	 * @return the tax document entry date
	 */
	public Date getTaxDocumentEntryDate() {
		return taxDocumentEntryDate;
	}

	/**
	 * Sets the tax document entry date.
	 *
	 * @param taxDocumentEntryDate the new tax document entry date
	 */
	public void setTaxDocumentEntryDate(Date taxDocumentEntryDate) {
		this.taxDocumentEntryDate = taxDocumentEntryDate;
	}

	/**
	 * Gets the tax document environment id.
	 *
	 * @return the tax document environment id
	 */
	public String getTaxDocumentEnvironmentId() {
		return taxDocumentEnvironmentId;
	}

	/**
	 * Sets the tax document environment id.
	 *
	 * @param taxDocumentEnvironmentId the new tax document environment id
	 */
	public void setTaxDocumentEnvironmentId(String taxDocumentEnvironmentId) {
		this.taxDocumentEnvironmentId = taxDocumentEnvironmentId;
	}

	/**
	 * Gets the tax document issuer state code.
	 *
	 * @return the tax document issuer state code
	 */
	public String getTaxDocumentIssuerStateCode() {
		return taxDocumentIssuerStateCode;
	}

	/**
	 * Sets the tax document issuer state code.
	 *
	 * @param taxDocumentIssuerStateCode the new tax document issuer state code
	 */
	public void setTaxDocumentIssuerStateCode(String taxDocumentIssuerStateCode) {
		this.taxDocumentIssuerStateCode = taxDocumentIssuerStateCode;
	}

	/**
	 * Gets the tax document number.
	 *
	 * @return the tax document number
	 */
	public String getTaxDocumentNumber() {
		return taxDocumentNumber;
	}

	/**
	 * Sets the tax document number.
	 *
	 * @param taxDocumentNumber the new tax document number
	 */
	public void setTaxDocumentNumber(String taxDocumentNumber) {
		this.taxDocumentNumber = taxDocumentNumber;
	}

	/**
	 * Gets the tax document validation reason.
	 *
	 * @return the tax document validation reason
	 */
	public String getTaxDocumentValidationReason() {
		return taxDocumentValidationReason;
	}

	/**
	 * Sets the tax document validation reason.
	 *
	 * @param taxDocumentValidationReason the new tax document validation reason
	 */
	public void setTaxDocumentValidationReason(String taxDocumentValidationReason) {
		this.taxDocumentValidationReason = taxDocumentValidationReason;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the last modification date.
	 *
	 * @return the last modification date
	 */
	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * Sets the last modification date.
	 *
	 * @param lastModificationDate the new last modification date
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CteAuditDetail [cteAuditId=" + cteAuditId + ", cteIdentityMaster=" + cteIdentityMaster + ", cteCode="
				+ cteCode + ", taxDocumentActiveStatusNumber=" + taxDocumentActiveStatusNumber
				+ ", taxDocumentDigitalValue=" + taxDocumentDigitalValue + ", taxDocumentEntryDate="
				+ taxDocumentEntryDate + ", taxDocumentEnvironmentId=" + taxDocumentEnvironmentId
				+ ", taxDocumentIssuerStateCode=" + taxDocumentIssuerStateCode + ", taxDocumentNumber="
				+ taxDocumentNumber + ", taxDocumentValidationReason=" + taxDocumentValidationReason + ", creationDate="
				+ creationDate + ", lastModificationDate=" + lastModificationDate + "]";
	}
	
    
}
