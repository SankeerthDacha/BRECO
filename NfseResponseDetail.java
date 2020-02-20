package com.fedex.breco.insurance.dto;

import java.io.Serializable;
import java.sql.Timestamp;
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
 * The Class AwbCustMaster.
 */
@Entity
@Table(name = "NFSE_RESPONSE_DETAIL")
public class NfseResponseDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nfse response id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NFSE_RESP_SEQ")
	@SequenceGenerator(name = "NFSE_RESP_SEQ", sequenceName = "NFSE_RESP_SEQ", allocationSize = 1)
	@Column(name = "ISQN_CD", columnDefinition = "")
	private Long nfseResponseId;

	/** The nfse request detail. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = true)
	private NfseRequestDetail nfseRequestDetail;

	/** The protocol number. */
	@Column(name = "PROTO_NBR", columnDefinition = "")
	private String protocolNumber;

	/** The lot number. */
	@Column(name = "LOT_NBR", columnDefinition = "")
	private String lotNumber;

	/** The response status. */
	@Column(name = "RESP_STAT_CD", columnDefinition = "")
	private String responseStatus;

	/** The status description. */
	@Column(name = "STAT_DESC", columnDefinition = "")
	private String statusDescription;

	/** The service provider code. */
	@Column(name = "SVC_PRVDR_CD", columnDefinition = "")
	private String serviceProviderCode;

	/** The SIAFI provider. */
	@Column(name = "INTG_FIN_ADMN_SYS_PRVDR_DESC", columnDefinition = "")
	private String SIAFIProvider;

	/** The rps id. */
	@Column(name = "RP_S_ID", columnDefinition = "")
	private String rpsId;

	/** The process status code. */
	@Column(name = "PRCS_STAT_CD", columnDefinition = "")
	private Long processStatusCode;

	/** The rps serie id. */
	@Column(name = "RP_S_SERS_ID", columnDefinition = "")
	private String rpsSerieId;

	/** The rps type description. */
	@Column(name = "RP_S_TYP_DESC", columnDefinition = "")
	private String rpsTypeDescription;

	/** The rps situation description. */
	@Column(name = "RP_S_SI_DESC", columnDefinition = "")
	private String rpsSituationDescription;

	/** The rps date. */
	@Column(name = "RP_S_DT", columnDefinition = "")
	private Timestamp rpsDate;

	/** The approval date. */
	@Column(name = "APRVL_DT", columnDefinition = "")
	private Date approvalDate;

	/** The cancellation date. */
	@Column(name = "CNCL_DT", columnDefinition = "")
	private Timestamp cancellationDate;

	/** The document number. */
	@Column(name = "DOC_NBR", columnDefinition = "")
	private String documentNumber;

	/** The nfe number. */
	@Column(name = "NT_FSCL_LT_NBR", columnDefinition = "")
	private String nfeNumber;

	/** The federal tax id. */
	@Column(name = "FED_TAX_ID", columnDefinition = "")
	private String federalTaxId;

	/** The municipal tax id. */
	@Column(name = "CTY_TAX_ID", columnDefinition = "")
	private String municipalTaxId;

	/** The aliquot services. */
	@Column(name = "SVC_SAMP_DESC", columnDefinition = "")
	private String aliquotServices;

	/** The value of services. */
	@Column(name = "SVC_VAL_DESC", columnDefinition = "")
	private String valueOfServices;

	/** The deduct item value. */
	@Column(name = "DEDUC_VAL_NBR", columnDefinition = "")
	private String deductItemValue;

	/** The nfe verification code. */
	@Column(name = "VERIF_CD", columnDefinition = "")
	private String nfeVerificationCode;

	/** The cancellation code. */
	@Column(name = "CNCL_RESN_CD", columnDefinition = "")
	private String cancellationCode;

	/** The environment type. */
	@Column(name = "ENV_TYP_TXT", columnDefinition = "")
	private String environmentType;

	/** The consulting url. */
	@Column(name = "CONSL_URL_TXT", columnDefinition = "")
	private String consultingUrl;

	/** The batch processing id. */
	@Column(name = "BCH_PRCS_ID", columnDefinition = "")
	private String batchProcessingId;

	/** The return type. */
	@Column(name = "RTRN_TYP_TXT", columnDefinition = "")
	private String returnType;

	/** The iss value. */
	@Column(name = "ISS_VAL_NBR", columnDefinition = "")
	private String issValue;

	/** The rps processing id. */
	@Column(name = "RP_S_PRCS_ID", columnDefinition = "")
	private String rpsProcessingId;

	/** The creation date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", columnDefinition = "")
	private Date creationDate;

	/** The laste modification date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "MODFY_DT", columnDefinition = "")
	private Date lasteModificationDate;

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
	 * Gets the lot number.
	 *
	 * @return the lot number
	 */
	public String getLotNumber() {
		return lotNumber;
	}

	/**
	 * Sets the lot number.
	 *
	 * @param lotNumber the new lot number
	 */
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	/**
	 * Gets the response status.
	 *
	 * @return the response status
	 */
	public String getResponseStatus() {
		return responseStatus;
	}

	/**
	 * Sets the response status.
	 *
	 * @param responseStatus the new response status
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
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
	 * Gets the service provider code.
	 *
	 * @return the service provider code
	 */
	public String getServiceProviderCode() {
		return serviceProviderCode;
	}

	/**
	 * Sets the service provider code.
	 *
	 * @param serviceProviderCode the new service provider code
	 */
	public void setServiceProviderCode(String serviceProviderCode) {
		this.serviceProviderCode = serviceProviderCode;
	}

	/**
	 * Gets the SIAFI provider.
	 *
	 * @return the SIAFI provider
	 */
	public String getSIAFIProvider() {
		return SIAFIProvider;
	}

	/**
	 * Sets the SIAFI provider.
	 *
	 * @param sIAFIProvider the new SIAFI provider
	 */
	public void setSIAFIProvider(String sIAFIProvider) {
		SIAFIProvider = sIAFIProvider;
	}

	/**
	 * Gets the rps id.
	 *
	 * @return the rps id
	 */
	public String getRpsId() {
		return rpsId;
	}

	/**
	 * Sets the rps id.
	 *
	 * @param rpsId the new rps id
	 */
	public void setRpsId(String rpsId) {
		this.rpsId = rpsId;
	}

	/**
	 * Gets the rps serie id.
	 *
	 * @return the rps serie id
	 */
	public String getRpsSerieId() {
		return rpsSerieId;
	}

	/**
	 * Sets the rps serie id.
	 *
	 * @param rpsSerieId the new rps serie id
	 */
	public void setRpsSerieId(String rpsSerieId) {
		this.rpsSerieId = rpsSerieId;
	}

	/**
	 * Gets the rps type description.
	 *
	 * @return the rps type description
	 */
	public String getRpsTypeDescription() {
		return rpsTypeDescription;
	}

	/**
	 * Sets the rps type description.
	 *
	 * @param rpsTypeDescription the new rps type description
	 */
	public void setRpsTypeDescription(String rpsTypeDescription) {
		this.rpsTypeDescription = rpsTypeDescription;
	}

	/**
	 * Gets the rps situation description.
	 *
	 * @return the rps situation description
	 */
	public String getRpsSituationDescription() {
		return rpsSituationDescription;
	}

	/**
	 * Sets the rps situation description.
	 *
	 * @param rpsSituationDescription the new rps situation description
	 */
	public void setRpsSituationDescription(String rpsSituationDescription) {
		this.rpsSituationDescription = rpsSituationDescription;
	}

	/**
	 * Gets the rps date.
	 *
	 * @return the rps date
	 */
	public Timestamp getRpsDate() {
		return rpsDate;
	}

	/**
	 * Sets the rps date.
	 *
	 * @param rpsDate the new rps date
	 */
	public void setRpsDate(Timestamp rpsDate) {
		this.rpsDate = rpsDate;
	}

	/**
	 * Gets the approval date.
	 *
	 * @return the approval date
	 */
	public Date getApprovalDate() {
		return approvalDate;
	}

	/**
	 * Sets the approval date.
	 *
	 * @param date the new approval date
	 */
	public void setApprovalDate(Date date) {
		this.approvalDate = date;
	}

	/**
	 * Gets the cancellation date.
	 *
	 * @return the cancellation date
	 */
	public Timestamp getCancellationDate() {
		return cancellationDate;
	}

	/**
	 * Sets the cancellation date.
	 *
	 * @param cancellationDate the new cancellation date
	 */
	public void setCancellationDate(Timestamp cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	/**
	 * Gets the document number.
	 *
	 * @return the document number
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * Sets the document number.
	 *
	 * @param documentNumber the new document number
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * Gets the nfe number.
	 *
	 * @return the nfe number
	 */
	public String getNfeNumber() {
		return nfeNumber;
	}

	/**
	 * Sets the nfe number.
	 *
	 * @param nfeNumber the new nfe number
	 */
	public void setNfeNumber(String nfeNumber) {
		this.nfeNumber = nfeNumber;
	}

	/**
	 * Gets the federal tax id.
	 *
	 * @return the federal tax id
	 */
	public String getFederalTaxId() {
		return federalTaxId;
	}

	/**
	 * Sets the federal tax id.
	 *
	 * @param federalTaxId the new federal tax id
	 */
	public void setFederalTaxId(String federalTaxId) {
		this.federalTaxId = federalTaxId;
	}

	/**
	 * Gets the municipal tax id.
	 *
	 * @return the municipal tax id
	 */
	public String getMunicipalTaxId() {
		return municipalTaxId;
	}

	/**
	 * Sets the municipal tax id.
	 *
	 * @param municipalTaxId the new municipal tax id
	 */
	public void setMunicipalTaxId(String municipalTaxId) {
		this.municipalTaxId = municipalTaxId;
	}

	/**
	 * Gets the aliquot services.
	 *
	 * @return the aliquot services
	 */
	public String getAliquotServices() {
		return aliquotServices;
	}

	/**
	 * Sets the aliquot services.
	 *
	 * @param aliquotServices the new aliquot services
	 */
	public void setAliquotServices(String aliquotServices) {
		this.aliquotServices = aliquotServices;
	}

	/**
	 * Gets the value of services.
	 *
	 * @return the value of services
	 */
	public String getValueOfServices() {
		return valueOfServices;
	}

	/**
	 * Sets the value of services.
	 *
	 * @param valueOfServices the new value of services
	 */
	public void setValueOfServices(String valueOfServices) {
		this.valueOfServices = valueOfServices;
	}

	/**
	 * Gets the deduct item value.
	 *
	 * @return the deduct item value
	 */
	public String getDeductItemValue() {
		return deductItemValue;
	}

	/**
	 * Sets the deduct item value.
	 *
	 * @param deductItemValue the new deduct item value
	 */
	public void setDeductItemValue(String deductItemValue) {
		this.deductItemValue = deductItemValue;
	}

	/**
	 * Gets the nfe verification code.
	 *
	 * @return the nfe verification code
	 */
	public String getNfeVerificationCode() {
		return nfeVerificationCode;
	}

	/**
	 * Sets the nfe verification code.
	 *
	 * @param nfeVerificationCode the new nfe verification code
	 */
	public void setNfeVerificationCode(String nfeVerificationCode) {
		this.nfeVerificationCode = nfeVerificationCode;
	}

	/**
	 * Gets the cancellation code.
	 *
	 * @return the cancellation code
	 */
	public String getCancellationCode() {
		return cancellationCode;
	}

	/**
	 * Sets the cancellation code.
	 *
	 * @param cancellationCode the new cancellation code
	 */
	public void setCancellationCode(String cancellationCode) {
		this.cancellationCode = cancellationCode;
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
	 * Gets the consulting url.
	 *
	 * @return the consulting url
	 */
	public String getConsultingUrl() {
		return consultingUrl;
	}

	/**
	 * Sets the consulting url.
	 *
	 * @param consultingUrl the new consulting url
	 */
	public void setConsultingUrl(String consultingUrl) {
		this.consultingUrl = consultingUrl;
	}

	/**
	 * Gets the batch processing id.
	 *
	 * @return the batch processing id
	 */
	public String getBatchProcessingId() {
		return batchProcessingId;
	}

	/**
	 * Sets the batch processing id.
	 *
	 * @param batchProcessingId the new batch processing id
	 */
	public void setBatchProcessingId(String batchProcessingId) {
		this.batchProcessingId = batchProcessingId;
	}

	/**
	 * Gets the return type.
	 *
	 * @return the return type
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * Sets the return type.
	 *
	 * @param returnType the new return type
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * Gets the iss value.
	 *
	 * @return the iss value
	 */
	public String getIssValue() {
		return issValue;
	}

	/**
	 * Sets the iss value.
	 *
	 * @param issValue the new iss value
	 */
	public void setIssValue(String issValue) {
		this.issValue = issValue;
	}

	/**
	 * Gets the rps processing id.
	 *
	 * @return the rps processing id
	 */
	public String getRpsProcessingId() {
		return rpsProcessingId;
	}

	/**
	 * Sets the rps processing id.
	 *
	 * @param rpsProcessingId the new rps processing id
	 */
	public void setRpsProcessingId(String rpsProcessingId) {
		this.rpsProcessingId = rpsProcessingId;
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
	 * Gets the laste modification date.
	 *
	 * @return the laste modification date
	 */
	public Date getLasteModificationDate() {
		return lasteModificationDate;
	}

	/**
	 * Sets the laste modification date.
	 *
	 * @param lasteModificationDate the new laste modification date
	 */
	public void setLasteModificationDate(Date lasteModificationDate) {
		this.lasteModificationDate = lasteModificationDate;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the nfse response id.
	 *
	 * @return the nfse response id
	 */
	public Long getNfseResponseId() {
		return nfseResponseId;
	}

	/**
	 * Sets the nfse response id.
	 *
	 * @param nfseResponseId the new nfse response id
	 */
	public void setNfseResponseId(Long nfseResponseId) {
		this.nfseResponseId = nfseResponseId;
	}

	/**
	 * Gets the nfse request detail.
	 *
	 * @return the nfse request detail
	 */
	public NfseRequestDetail getNfseRequestDetail() {
		return nfseRequestDetail;
	}

	/**
	 * Sets the nfse request detail.
	 *
	 * @param nfseRequestDetail the new nfse request detail
	 */
	public void setNfseRequestDetail(NfseRequestDetail nfseRequestDetail) {
		this.nfseRequestDetail = nfseRequestDetail;

	}

	/**
	 * Gets the process status code.
	 *
	 * @return the process status code
	 */
	public Long getProcessStatusCode() {
		return processStatusCode;
	}

}
