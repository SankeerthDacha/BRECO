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
 * The Class CteResponseDetails.
 */
@Entity
@Table(name = "CTE_RESPONSE_DETAIL")
public class CteResponseDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cte response id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CTE_RESP_SEQ")
	@SequenceGenerator(name = "CTE_RESP_SEQ", sequenceName = "CTE_RESP_SEQ", allocationSize=1)
	@Column(name = "ISQN_CD", columnDefinition = "")
	private Long cteResponseId;

	/** The cte identity master. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = true)
	private CteIdentityMaster cteIdentityMaster;

	/** The protocol number. */
	@Column(name = "PROTO_NBR", columnDefinition = "")
	private String protocolNumber;

	/** The response status code. */
	@Column(name = "RESP_STAT_CD", columnDefinition = "")
	private String responseStatusCode;

	/** The cte code. */
	@Column(name = "CT_E_CD", columnDefinition = "")
	private String cteCode;

	/** The task event number. */
	@Column(name = "TP_EVENT_NBR", columnDefinition = "")
	private String taskEventNumber;

	/** The tax id. */
	@Column(name = "TAX_ID", columnDefinition = "")
	private String taxId;

	/** The cte number. */
	@Column(name = "CT_E_NBR", columnDefinition = "")
	private String cteNumber;

	/** The document description. */
	@Column(name = "DOC_SERS_TXT", columnDefinition = "")
	private String documentDescription;

	/** The status description. */
	@Column(name = "STAT_DESC", columnDefinition = "")
	private String statusDescription;

	/** The service code. */
	@Column(name = "SVC_CD", columnDefinition = "")
	private String serviceCode;

	/** The return code description. */
	@Column(name = "RTRN_CD_DESC", columnDefinition = "")
	private String returnCodeDescription;

	/** The environment type. */
	@Column(name = "ENV_TYPE_DESC", columnDefinition = "")
	private String environmentType;

	/** The event date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "DH_REG_EVENT_DESC", columnDefinition = "")
	private Date eventDate;

	/** The event sequence. */
	@Column(name = "EVNT_SEQ_CD", columnDefinition = "")
	private String eventSequence;

	/** The data entry contingency. */
	@Column(name = "DA_ENTR_CONTG_DESC", columnDefinition = "")
	private String dataEntryContingency;

	/** The contingency reason. */
	@Column(name = "CONTG_RESN_DESC", columnDefinition = "")
	private String contingencyReason;

	/** The authorization date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "AUTH_DT", columnDefinition = "")
	private Date authorizationDate;

	/** The cte creation date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "CT_E_CRTN_DT", columnDefinition = "")
	private Date cteCreationDate;

	/** The cancellation reason. */
	@Column(name = "CNCL_RESN_DESC", columnDefinition = "")
	private String cancellationReason;

	/** The cte first range. */
	@Column(name = "CT_E_FST_RNG_DESC", columnDefinition = "")
	private String cteFirstRange;

	/** The cte last range. */
	@Column(name = "CT_E_LST_RNG_DESC", columnDefinition = "")
	private String cteLastRange;

	/** The creation date. */
	@Column(name = "CREATE_DT", columnDefinition = "CREATE_DT")
	private Date creationDate;

	/** The last modification date. */
	@Column(name = "MODFY_DT", columnDefinition = "MODFY_DT")
	private Date lastModificationDate;

	/**
	 * Gets the cte response id.
	 *
	 * @return the cte response id
	 */
	public Long getCteResponseId() {
		return cteResponseId;
	}

	/**
	 * Sets the cte response id.
	 *
	 * @param cteResponseId the new cte response id
	 */
	public void setCteResponseId(Long cteResponseId) {
		this.cteResponseId = cteResponseId;
	}

	/**
	 * Gets the cte identity master.
	 *
	 * @return the cte identity master
	 */
	public CteIdentityMaster getCteIdentityMaster() {
		return cteIdentityMaster;
	}

	/**
	 * Sets the cte identity master.
	 *
	 * @param cteIdentityMaster the new cte identity master
	 */
	public void setCteIdentityMaster(CteIdentityMaster cteIdentityMaster) {
		this.cteIdentityMaster = cteIdentityMaster;
	}

	/**
	 * Gets the protocol number.
	 *
	 * @return the protocol number
	 */
	public String getProtocolNumber() {
		return protocolNumber;
	}

	/**
	 * Sets the protocol number.
	 *
	 * @param protocolNumber the new protocol number
	 */
	public void setProtocolNumber(String protocolNumber) {
		this.protocolNumber = protocolNumber;
	}

	/**
	 * Gets the response status code.
	 *
	 * @return the response status code
	 */
	public String getResponseStatusCode() {
		return responseStatusCode;
	}

	/**
	 * Sets the response status code.
	 *
	 * @param responseStatusCode the new response status code
	 */
	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
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
	 * Gets the task event number.
	 *
	 * @return the task event number
	 */
	public String getTaskEventNumber() {
		return taskEventNumber;
	}

	/**
	 * Sets the task event number.
	 *
	 * @param taskEventNumber the new task event number
	 */
	public void setTaskEventNumber(String taskEventNumber) {
		this.taskEventNumber = taskEventNumber;
	}

	/**
	 * Gets the tax id.
	 *
	 * @return the tax id
	 */
	public String getTaxId() {
		return taxId;
	}

	/**
	 * Sets the tax id.
	 *
	 * @param taxId the new tax id
	 */
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	/**
	 * Gets the cte number.
	 *
	 * @return the cte number
	 */
	public String getCteNumber() {
		return cteNumber;
	}

	/**
	 * Sets the cte number.
	 *
	 * @param cteNumber the new cte number
	 */
	public void setCteNumber(String cteNumber) {
		this.cteNumber = cteNumber;
	}

	/**
	 * Gets the document description.
	 *
	 * @return the document description
	 */
	public String getDocumentDescription() {
		return documentDescription;
	}

	/**
	 * Sets the document description.
	 *
	 * @param documentDescription the new document description
	 */
	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}

	/**
	 * Gets the status description.
	 *
	 * @return the status description
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * Sets the status description.
	 *
	 * @param statusDescription the new status description
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * Gets the service code.
	 *
	 * @return the service code
	 */
	public String getServiceCode() {
		return serviceCode;
	}

	/**
	 * Sets the service code.
	 *
	 * @param serviceCode the new service code
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * Gets the return code description.
	 *
	 * @return the return code description
	 */
	public String getReturnCodeDescription() {
		return returnCodeDescription;
	}

	/**
	 * Sets the return code description.
	 *
	 * @param returnCodeDescription the new return code description
	 */
	public void setReturnCodeDescription(String returnCodeDescription) {
		this.returnCodeDescription = returnCodeDescription;
	}

	/**
	 * Gets the environment type.
	 *
	 * @return the environment type
	 */
	public String getEnvironmentType() {
		return environmentType;
	}

	/**
	 * Sets the environment type.
	 *
	 * @param environmentType the new environment type
	 */
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	/**
	 * Gets the event date.
	 *
	 * @return the event date
	 */
	public Date getEventDate() {
		return eventDate;
	}

	/**
	 * Sets the event date.
	 *
	 * @param eventDate the new event date
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Gets the event sequence.
	 *
	 * @return the event sequence
	 */
	public String getEventSequence() {
		return eventSequence;
	}

	/**
	 * Sets the event sequence.
	 *
	 * @param eventSequence the new event sequence
	 */
	public void setEventSequence(String eventSequence) {
		this.eventSequence = eventSequence;
	}

	/**
	 * Gets the data entry contingency.
	 *
	 * @return the data entry contingency
	 */
	public String getDataEntryContingency() {
		return dataEntryContingency;
	}

	/**
	 * Sets the data entry contingency.
	 *
	 * @param dataEntryContingency the new data entry contingency
	 */
	public void setDataEntryContingency(String dataEntryContingency) {
		this.dataEntryContingency = dataEntryContingency;
	}

	/**
	 * Gets the contingency reason.
	 *
	 * @return the contingency reason
	 */
	public String getContingencyReason() {
		return contingencyReason;
	}

	/**
	 * Sets the contingency reason.
	 *
	 * @param contingencyReason the new contingency reason
	 */
	public void setContingencyReason(String contingencyReason) {
		this.contingencyReason = contingencyReason;
	}

	/**
	 * Gets the authorization date.
	 *
	 * @return the authorization date
	 */
	public Date getAuthorizationDate() {
		return authorizationDate;
	}

	/**
	 * Sets the authorization date.
	 *
	 * @param authorizationDate the new authorization date
	 */
	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
	}

	/**
	 * Gets the cte creation date.
	 *
	 * @return the cte creation date
	 */
	public Date getCteCreationDate() {
		return cteCreationDate;
	}

	/**
	 * Sets the cte creation date.
	 *
	 * @param cteCreationDate the new cte creation date
	 */
	public void setCteCreationDate(Date cteCreationDate) {
		this.cteCreationDate = cteCreationDate;
	}

	/**
	 * Gets the cancellation reason.
	 *
	 * @return the cancellation reason
	 */
	public String getCancellationReason() {
		return cancellationReason;
	}

	/**
	 * Sets the cancellation reason.
	 *
	 * @param cancellationReason the new cancellation reason
	 */
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	/**
	 * Gets the cte first range.
	 *
	 * @return the cte first range
	 */
	public String getCteFirstRange() {
		return cteFirstRange;
	}

	/**
	 * Sets the cte first range.
	 *
	 * @param cteFirstRange the new cte first range
	 */
	public void setCteFirstRange(String cteFirstRange) {
		this.cteFirstRange = cteFirstRange;
	}

	/**
	 * Gets the cte last range.
	 *
	 * @return the cte last range
	 */
	public String getCteLastRange() {
		return cteLastRange;
	}

	/**
	 * Sets the cte last range.
	 *
	 * @param cteLastRange the new cte last range
	 */
	public void setCteLastRange(String cteLastRange) {
		this.cteLastRange = cteLastRange;
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
		return "CteResponseDetails [cteResponseId=" + cteResponseId 
				+ ", protocolNumber=" + protocolNumber + ", responseStatusCode=" + responseStatusCode + ", cteCode="
				+ cteCode + ", taskEventNumber=" + taskEventNumber + ", taxId=" + taxId + ", cteNumber=" + cteNumber
				+ ", documentDescription=" + documentDescription + ", statusDescription=" + statusDescription
				+ ", serviceCode=" + serviceCode + ", returnCodeDescription=" + returnCodeDescription
				+ ", environmentType=" + environmentType + ", eventDate=" + eventDate + ", eventSequence="
				+ eventSequence + ", dataEntryContingency=" + dataEntryContingency + ", contingencyReason="
				+ contingencyReason + ", authorizationDate=" + authorizationDate + ", cteCreationDate="
				+ cteCreationDate + ", cancellationReason=" + cancellationReason + ", cteFirstRange=" + cteFirstRange
				+ ", cteLastRange=" + cteLastRange + ", creationDate=" + creationDate + ", lastModificationDate="
				+ lastModificationDate + "]";
	}

}
