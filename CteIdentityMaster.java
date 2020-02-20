package com.fedex.breco.insurance.cte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import com.fedex.breco.insurance.dto.MatchReference;


// TODO: Auto-generated Javadoc
/**
 * The Class CteIdentityMaster.
 */
@Entity
@Table(name = "CTE_IDENTITY_MASTER")
public class CteIdentityMaster implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cte master id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CTE_MSTR_SEQ")
	@SequenceGenerator(name = "CTE_MSTR_SEQ", sequenceName = "CTE_MSTR_SEQ", allocationSize=1)
	@Column(name = "ISQN_MSTR_CD", columnDefinition = "INTERNAL SEQUENCE CODE FOR MASTER TABLE")
	private Long cteMasterId;

	/** The cte audit detail. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cteIdentityMaster")
	private CteAuditDetail cteAuditDetail;

	/** The cte cte participant details. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cteIdentityMaster")
	private CteParticipantDetails cteParticipantDetails;

	/** The cte product details. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cteIdentityMaster")
	private CteProductDetails cteProductDetails;

	/** The cte transport info. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cteIdentityMaster")
	private CteTransportInfo cteTransportInfo;

	/** The cte response details. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cteIdentityMaster")
	private CteResponseDetails cteResponseDetails;
	
	/** The match reference master. */
	@JoinColumn(name = "ISQN_REF_CD")
    @OneToOne(cascade = CascadeType.ALL)
	private MatchReference matchReferenceMaster;

	/** The cte code. */
	@Column(name = "CT_E_CD", columnDefinition = "CONHECIMENTO DE TRANSPORTE ELETRONICO")
	private String cteCode;

	/** The access key code. */
	@Column(name = "ACCS_KEY_CD", columnDefinition = "CDV")
	private String accessKeyCode;

	/** The Access key verify number. */
	@Column(name = "ACCS_KEY_VRFY_NBR", columnDefinition = "CCT")
	private String AccessKeyVerifyNumber;

	/** The service ends state code. */
	@Column(name = "CE_E_SVC_END_ST_CD", columnDefinition = "UFFIM")
	private String serviceEndsStateCode;

	/** The service started state code. */
	@Column(name = "CE_E_SVC_STRT_ST_CD", columnDefinition = "UFINI")
	private String serviceStartedStateCode;

	/** The cte destination city code. */
	@Column(name = "CT_E_DEST_CTY_CD", columnDefinition = "XMUNENV")
	private String cteDestinationCityCode;

	/** The cte form description. */
	@Column(name = "CT_E_FRM_DESC", columnDefinition = "TPEMIS")
	private String cteFormDescription;

	/** The cte issuing indicator code. */
	@Column(name = "CT_E_IS_PRCS_IND_CD", columnDefinition = "PROCEMI")
	private String cteIssuingIndicatorCode;

	/** The cte issue date. */
	@Column(name = "CT_E_ISSUE_DT", columnDefinition = "DHEMI")
	@Temporal(TemporalType.DATE)
	private Date cteIssueDate;

	/** The cte number. */
	@Column(name = "CT_E_NBR", columnDefinition = "NCT")
	private String cteNumber;

	/** The cte origin state code. */
	@Column(name = "CT_E_ORIG_ST_CD", columnDefinition = "UFENV")
	private String cteOriginStateCode;

	/** The cte series number. */
	@Column(name = "CT_E_SERS_NBR", columnDefinition = "SERIE")
	private String cteSeriesNumber;

	/** The cte type. */
	@Column(name = "CT_E_TYPE_DESC", columnDefinition = "TPCTE")
	private String cteType;

	/** The environment type. */
	@Column(name = "ENV_TYPE_DESC", columnDefinition = "TPAMB")
	private String environmentType;

	/** The fiscal document state code. */
	@Column(name = "FSCL_DOC_ST_CD", columnDefinition = "CUF")
	private String fiscalDocumentStateCode;

	/** The operation nature. */
	@Column(name = "OPER_NATRE_DESC", columnDefinition = "NATOP")
	private String operationNature;

	/** The operation service tax code. */
	@Column(name = "OPS_SVC_FSCL_CD", columnDefinition = "CFOP")
	private String operationServiceTaxCode;

	/** The origin city code. */
	@Column(name = "ORIG_CTY_CD", columnDefinition = "CMUNENV")
	private String originCityCode;

	/** The process version number. */
	@Column(name = "PRCS_VERS_NBR", columnDefinition = "VERPROC")
	private String processVersionNumber;

	/** The printed format code. */
	@Column(name = "PRT_FORMT_CD", columnDefinition = "TPIMP")
	private String printedFormatCode;

	/** The recipient cargo location indicator number. */
	@Column(name = "RECP_CRGO_LOC_IND_NBR", columnDefinition = "RETIRA")
	private String recipientCargoLocationIndicatorNumber;

	/** The service ends city code. */
	@Column(name = "SVC_END_CTY_CD", columnDefinition = "CMUNINI")
	private String serviceEndsCityCode;

	/** The service ends city name. */
	@Column(name = "SVC_END_CTY_NM", columnDefinition = "XMUNFIM")
	private String serviceEndsCityName;

	/** The service paying responsible person code. */
	@Column(name = "SVC_PAY_RSPBL_PRSN_CD", columnDefinition = "TOMA")
	private String servicePayingResponsiblePersonCode;

	/** The service started city code. */
	@Column(name = "SVC_STRT_CTY_CD", columnDefinition = "CMUNFIM")
	private String serviceStartedCityCode;

	/** The service started city name. */
	@Column(name = "SVC_STRT_CTY_NM", columnDefinition = "XMUNINI")
	private String serviceStartedCityName;

	/** The servicetype code. */
	@Column(name = "SVC_TYPE_CD", columnDefinition = "TPSERV")
	private String servicetypeCode;

	/** The tax document modal code. */
	@Column(name = "TAX_DOC_MDL_CD", columnDefinition = "IDE_MOD")
	private String taxDocumentModalCode;

	/** The transport modal. */
	@Column(name = "TRPRT_MDL_DESC", columnDefinition = "MODAL")
	private String transportModal;

	/** The tax payer type. */
	@Column(name = "TXPYR_TYPE_DESC", columnDefinition = "INDIETOMA")
	private String taxPayerType;

	/** The creation date. */
	@Column(name = "CREATE_DT", columnDefinition = "CREATE_DT")
	private Date creationDate;

	/** The last modification date. */
	@Column(name = "MODFY_DT", columnDefinition = "MODFY_DT")
	private Date lastModificationDate;

	/** The INSURANCE ENDORSEMET STATUS */
	@Column(name = "INS_APRVL_STAT_CD", columnDefinition = "INSURANCE ENDORSEMENT STATUS")
	private String insuranceEndorseStatus;
	
	/** The TMS STATUS */
	@Column(name = "FILE_STAT_TM_S_DESC", columnDefinition = "TMS FILE STATUS")
	private String tmsFileStatus;
	
	/** The CTE CANCELLATION STATUS */
	@Column(name = "CNCL_STAT_DESC", columnDefinition = "CTE CANCELLATION STATUS")
	private String cancellationStatus;
	
	/** The CTE CANCELLATION TIME */
	@Column(name = "CNCL_DT", columnDefinition = "CTE CANCELLATION TIME")
	private Date cancellationDate;
	
	/**
	 * Gets the cte master id.
	 *
	 * @return the cte master id
	 */
	public Long getCteMasterId() {
		return cteMasterId;
	}

	/**
	 * Sets the cte master id.
	 *
	 * @param cteMasterId the new cte master id
	 */
	public void setCteMasterId(Long cteMasterId) {
		this.cteMasterId = cteMasterId;
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
	 * Gets the access key code.
	 *
	 * @return the access key code
	 */
	public String getAccessKeyCode() {
		return accessKeyCode;
	}

	/**
	 * Sets the access key code.
	 *
	 * @param accessKeyCode the new access key code
	 */
	public void setAccessKeyCode(String accessKeyCode) {
		this.accessKeyCode = accessKeyCode;
	}

	/**
	 * Gets the access key verify number.
	 *
	 * @return the access key verify number
	 */
	public String getAccessKeyVerifyNumber() {
		return AccessKeyVerifyNumber;
	}

	/**
	 * Sets the access key verify number.
	 *
	 * @param accessKeyVerifyNumber the new access key verify number
	 */
	public void setAccessKeyVerifyNumber(String accessKeyVerifyNumber) {
		AccessKeyVerifyNumber = accessKeyVerifyNumber;
	}

	/**
	 * Gets the service ends state code.
	 *
	 * @return the service ends state code
	 */
	public String getServiceEndsStateCode() {
		return serviceEndsStateCode;
	}

	/**
	 * Sets the service ends state code.
	 *
	 * @param serviceEndsStateCode the new service ends state code
	 */
	public void setServiceEndsStateCode(String serviceEndsStateCode) {
		this.serviceEndsStateCode = serviceEndsStateCode;
	}

	/**
	 * Gets the service started state code.
	 *
	 * @return the service started state code
	 */
	public String getServiceStartedStateCode() {
		return serviceStartedStateCode;
	}

	/**
	 * Sets the service started state code.
	 *
	 * @param serviceStartedStateCode the new service started state code
	 */
	public void setServiceStartedStateCode(String serviceStartedStateCode) {
		this.serviceStartedStateCode = serviceStartedStateCode;
	}

	/**
	 * Gets the cte destination city code.
	 *
	 * @return the cte destination city code
	 */
	public String getCteDestinationCityCode() {
		return cteDestinationCityCode;
	}

	/**
	 * Sets the cte destination city code.
	 *
	 * @param cteDestinationCityCode the new cte destination city code
	 */
	public void setCteDestinationCityCode(String cteDestinationCityCode) {
		this.cteDestinationCityCode = cteDestinationCityCode;
	}

	/**
	 * Gets the cte form description.
	 *
	 * @return the cte form description
	 */
	public String getCteFormDescription() {
		return cteFormDescription;
	}

	/**
	 * Sets the cte form description.
	 *
	 * @param cteFormDescription the new cte form description
	 */
	public void setCteFormDescription(String cteFormDescription) {
		this.cteFormDescription = cteFormDescription;
	}

	/**
	 * Gets the cte issuing indicator code.
	 *
	 * @return the cte issuing indicator code
	 */
	public String getCteIssuingIndicatorCode() {
		return cteIssuingIndicatorCode;
	}

	/**
	 * Sets the cte issuing indicator code.
	 *
	 * @param cteIssuingIndicatorCode the new cte issuing indicator code
	 */
	public void setCteIssuingIndicatorCode(String cteIssuingIndicatorCode) {
		this.cteIssuingIndicatorCode = cteIssuingIndicatorCode;
	}

	/**
	 * Gets the cte issue date.
	 *
	 * @return the cte issue date
	 */
	public Date getCteIssueDate() {
		return cteIssueDate;
	}

	/**
	 * Sets the cte issue date.
	 *
	 * @param cteIssueDate the new cte issue date
	 */
	public void setCteIssueDate(Date cteIssueDate) {
		this.cteIssueDate = cteIssueDate;
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
	 * Gets the cte origin state code.
	 *
	 * @return the cte origin state code
	 */
	public String getCteOriginStateCode() {
		return cteOriginStateCode;
	}

	/**
	 * Sets the cte origin state code.
	 *
	 * @param cteOriginStateCode the new cte origin state code
	 */
	public void setCteOriginStateCode(String cteOriginStateCode) {
		this.cteOriginStateCode = cteOriginStateCode;
	}

	/**
	 * Gets the cte series number.
	 *
	 * @return the cte series number
	 */
	public String getCteSeriesNumber() {
		return cteSeriesNumber;
	}

	/**
	 * Sets the cte series number.
	 *
	 * @param cteSeriesNumber the new cte series number
	 */
	public void setCteSeriesNumber(String cteSeriesNumber) {
		this.cteSeriesNumber = cteSeriesNumber;
	}

	/**
	 * Gets the cte type.
	 *
	 * @return the cte type
	 */
	public String getCteType() {
		return cteType;
	}

	/**
	 * Sets the cte type.
	 *
	 * @param cteType the new cte type
	 */
	public void setCteType(String cteType) {
		this.cteType = cteType;
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
	 * Gets the fiscal document state code.
	 *
	 * @return the fiscal document state code
	 */
	public String getFiscalDocumentStateCode() {
		return fiscalDocumentStateCode;
	}

	/**
	 * Sets the fiscal document state code.
	 *
	 * @param fiscalDocumentStateCode the new fiscal document state code
	 */
	public void setFiscalDocumentStateCode(String fiscalDocumentStateCode) {
		this.fiscalDocumentStateCode = fiscalDocumentStateCode;
	}

	/**
	 * Gets the operation nature.
	 *
	 * @return the operation nature
	 */
	public String getOperationNature() {
		return operationNature;
	}

	/**
	 * Sets the operation nature.
	 *
	 * @param operationNature the new operation nature
	 */
	public void setOperationNature(String operationNature) {
		this.operationNature = operationNature;
	}

	/**
	 * Gets the operation service tax code.
	 *
	 * @return the operation service tax code
	 */
	public String getOperationServiceTaxCode() {
		return operationServiceTaxCode;
	}

	/**
	 * Sets the operation service tax code.
	 *
	 * @param operationServiceTaxCode the new operation service tax code
	 */
	public void setOperationServiceTaxCode(String operationServiceTaxCode) {
		this.operationServiceTaxCode = operationServiceTaxCode;
	}

	/**
	 * Gets the origin city code.
	 *
	 * @return the origin city code
	 */
	public String getOriginCityCode() {
		return originCityCode;
	}

	/**
	 * Sets the origin city code.
	 *
	 * @param originCityCode the new origin city code
	 */
	public void setOriginCityCode(String originCityCode) {
		this.originCityCode = originCityCode;
	}

	/**
	 * Gets the process version number.
	 *
	 * @return the process version number
	 */
	public String getProcessVersionNumber() {
		return processVersionNumber;
	}

	/**
	 * Sets the process version number.
	 *
	 * @param processVersionNumber the new process version number
	 */
	public void setProcessVersionNumber(String processVersionNumber) {
		this.processVersionNumber = processVersionNumber;
	}

	/**
	 * Gets the printed format code.
	 *
	 * @return the printed format code
	 */
	public String getPrintedFormatCode() {
		return printedFormatCode;
	}

	/**
	 * Sets the printed format code.
	 *
	 * @param printedFormatCode the new printed format code
	 */
	public void setPrintedFormatCode(String printedFormatCode) {
		this.printedFormatCode = printedFormatCode;
	}

	/**
	 * Gets the recipient cargo location indicator number.
	 *
	 * @return the recipient cargo location indicator number
	 */
	public String getRecipientCargoLocationIndicatorNumber() {
		return recipientCargoLocationIndicatorNumber;
	}

	/**
	 * Sets the recipient cargo location indicator number.
	 *
	 * @param recipientCargoLocationIndicatorNumber the new recipient cargo location
	 *                                              indicator number
	 */
	public void setRecipientCargoLocationIndicatorNumber(String recipientCargoLocationIndicatorNumber) {
		this.recipientCargoLocationIndicatorNumber = recipientCargoLocationIndicatorNumber;
	}

	/**
	 * Gets the service ends city code.
	 *
	 * @return the service ends city code
	 */
	public String getServiceEndsCityCode() {
		return serviceEndsCityCode;
	}

	/**
	 * Sets the service ends city code.
	 *
	 * @param serviceEndsCityCode the new service ends city code
	 */
	public void setServiceEndsCityCode(String serviceEndsCityCode) {
		this.serviceEndsCityCode = serviceEndsCityCode;
	}

	/**
	 * Gets the service ends city name.
	 *
	 * @return the service ends city name
	 */
	public String getServiceEndsCityName() {
		return serviceEndsCityName;
	}

	/**
	 * Sets the service ends city name.
	 *
	 * @param serviceEndsCityName the new service ends city name
	 */
	public void setServiceEndsCityName(String serviceEndsCityName) {
		this.serviceEndsCityName = serviceEndsCityName;
	}

	/**
	 * Gets the service paying responsible person code.
	 *
	 * @return the service paying responsible person code
	 */
	public String getServicePayingResponsiblePersonCode() {
		return servicePayingResponsiblePersonCode;
	}

	/**
	 * Sets the service paying responsible person code.
	 *
	 * @param servicePayingResponsiblePersonCode the new service paying responsible
	 *                                           person code
	 */
	public void setServicePayingResponsiblePersonCode(String servicePayingResponsiblePersonCode) {
		this.servicePayingResponsiblePersonCode = servicePayingResponsiblePersonCode;
	}

	/**
	 * Gets the service started city code.
	 *
	 * @return the service started city code
	 */
	public String getServiceStartedCityCode() {
		return serviceStartedCityCode;
	}

	/**
	 * Sets the service started city code.
	 *
	 * @param serviceStartedCityCode the new service started city code
	 */
	public void setServiceStartedCityCode(String serviceStartedCityCode) {
		this.serviceStartedCityCode = serviceStartedCityCode;
	}

	/**
	 * Gets the service started city name.
	 *
	 * @return the service started city name
	 */
	public String getServiceStartedCityName() {
		return serviceStartedCityName;
	}

	/**
	 * Sets the service started city name.
	 *
	 * @param serviceStartedCityName the new service started city name
	 */
	public void setServiceStartedCityName(String serviceStartedCityName) {
		this.serviceStartedCityName = serviceStartedCityName;
	}

	/**
	 * Gets the servicetype code.
	 *
	 * @return the servicetype code
	 */
	public String getServicetypeCode() {
		return servicetypeCode;
	}

	/**
	 * Sets the servicetype code.
	 *
	 * @param servicetypeCode the new servicetype code
	 */
	public void setServicetypeCode(String servicetypeCode) {
		this.servicetypeCode = servicetypeCode;
	}

	/**
	 * Gets the tax document modal code.
	 *
	 * @return the tax document modal code
	 */
	public String getTaxDocumentModalCode() {
		return taxDocumentModalCode;
	}

	/**
	 * Sets the tax document modal code.
	 *
	 * @param taxDocumentModalCode the new tax document modal code
	 */
	public void setTaxDocumentModalCode(String taxDocumentModalCode) {
		this.taxDocumentModalCode = taxDocumentModalCode;
	}

	/**
	 * Gets the transport modal.
	 *
	 * @return the transport modal
	 */
	public String getTransportModal() {
		return transportModal;
	}

	/**
	 * Sets the transport modal.
	 *
	 * @param transportModal the new transport modal
	 */
	public void setTransportModal(String transportModal) {
		this.transportModal = transportModal;
	}

	/**
	 * Gets the tax payer type.
	 *
	 * @return the tax payer type
	 */
	public String getTaxPayerType() {
		return taxPayerType;
	}

	/**
	 * Sets the tax payer type.
	 *
	 * @param taxPayerType the new tax payer type
	 */
	public void setTaxPayerType(String taxPayerType) {
		this.taxPayerType = taxPayerType;
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
	 * Gets the cte audit detail.
	 *
	 * @return the cte audit detail
	 */
	public CteAuditDetail getCteAuditDetail() {
		return cteAuditDetail;
	}

	/**
	 * Sets the cte audit detail.
	 *
	 * @param cteAuditDetail the new cte audit detail
	 */
	public void setCteAuditDetail(CteAuditDetail cteAuditDetail) {
		this.cteAuditDetail = cteAuditDetail;
	}

	/**
	 * Gets the cte participant details.
	 *
	 * @return the cte participant details
	 */
	public CteParticipantDetails getCteParticipantDetails() {
		return cteParticipantDetails;
	}

	/**
	 * Sets the cte participant details.
	 *
	 * @param cteParticipantDetails the new cte participant details
	 */
	public void setCteParticipantDetails(CteParticipantDetails cteParticipantDetails) {
		this.cteParticipantDetails = cteParticipantDetails;
	}

	/**
	 * Gets the cte product details.
	 *
	 * @return the cte product details
	 */
	public CteProductDetails getCteProductDetails() {
		return cteProductDetails;
	}

	/**
	 * Sets the cte product details.
	 *
	 * @param cteProductDetails the new cte product details
	 */
	public void setCteProductDetails(CteProductDetails cteProductDetails) {
		this.cteProductDetails = cteProductDetails;
	}

	/**
	 * Gets the cte transport info.
	 *
	 * @return the cte transport info
	 */
	public CteTransportInfo getCteTransportInfo() {
		return cteTransportInfo;
	}

	/**
	 * Sets the cte transport info.
	 *
	 * @param cteTransportInfo the new cte transport info
	 */
	public void setCteTransportInfo(CteTransportInfo cteTransportInfo) {
		this.cteTransportInfo = cteTransportInfo;
	}

	/**
	 * Gets the cte response details.
	 *
	 * @return the cte response details
	 */
	public CteResponseDetails getCteResponseDetails() {
		return cteResponseDetails;
	}

	/**
	 * Sets the cte response details.
	 *
	 * @param cteResponseDetails the new cte response details
	 */
	public void setCteResponseDetails(CteResponseDetails cteResponseDetails) {
		this.cteResponseDetails = cteResponseDetails;
	}

	/**
	 * @return the insuranceEndorseStatus
	 */
	public String getInsuranceEndorseStatus() {
		return insuranceEndorseStatus;
	}

	/**
	 * @param insuranceEndorseStatus the insuranceEndorseStatus to set
	 */
	public void setInsuranceEndorseStatus(String insuranceEndorseStatus) {
		this.insuranceEndorseStatus = insuranceEndorseStatus;
	}

	@Override
	public String toString() {
		return "CteIdentityMaster [cteMasterId=" + cteMasterId + ", cteCode=" + cteCode + ", accessKeyCode="
				+ accessKeyCode + ", AccessKeyVerifyNumber=" + AccessKeyVerifyNumber + ", serviceEndsStateCode="
				+ serviceEndsStateCode + ", serviceStartedStateCode=" + serviceStartedStateCode
				+ ", cteDestinationCityCode=" + cteDestinationCityCode + ", cteFormDescription=" + cteFormDescription
				+ ", cteIssuingIndicatorCode=" + cteIssuingIndicatorCode + ", cteIssueDate=" + cteIssueDate
				+ ", cteNumber=" + cteNumber + ", cteOriginStateCode=" + cteOriginStateCode + ", cteSeriesNumber="
				+ cteSeriesNumber + ", cteType=" + cteType + ", environmentType=" + environmentType
				+ ", fiscalDocumentStateCode=" + fiscalDocumentStateCode + ", operationNature=" + operationNature
				+ ", operationServiceTaxCode=" + operationServiceTaxCode + ", originCityCode=" + originCityCode
				+ ", processVersionNumber=" + processVersionNumber + ", printedFormatCode=" + printedFormatCode
				+ ", recipientCargoLocationIndicatorNumber=" + recipientCargoLocationIndicatorNumber
				+ ", serviceEndsCityCode=" + serviceEndsCityCode + ", serviceEndsCityName=" + serviceEndsCityName
				+ ", servicePayingResponsiblePersonCode=" + servicePayingResponsiblePersonCode
				+ ", serviceStartedCityCode=" + serviceStartedCityCode + ", serviceStartedCityName="
				+ serviceStartedCityName + ", servicetypeCode=" + servicetypeCode + ", taxDocumentModalCode="
				+ taxDocumentModalCode + ", transportModal=" + transportModal + ", taxPayerType=" + taxPayerType
				+ ", creationDate=" + creationDate + ", lastModificationDate=" + lastModificationDate
				+ ", insuranceEndorseStatus=" + insuranceEndorseStatus + ", tmsFileStatus=" + tmsFileStatus
				+ ", cancellationStatus=" + cancellationStatus + ", cancellationDate=" + cancellationDate + "]";
	}

	public MatchReference getMatchReferenceMaster() {
		return matchReferenceMaster;
	}

	public void setMatchReferenceMaster(MatchReference matchReferenceMaster) {
		this.matchReferenceMaster = matchReferenceMaster;
	}

	public String getTmsFileStatus() {
		return tmsFileStatus;
	}

	public void setTmsFileStatus(String tmsFileStatus) {
		this.tmsFileStatus = tmsFileStatus;
	}
	
	public String getCancellationStatus() {
		return cancellationStatus;
	}

	public void setCancellationStatus(String cancellationStatus) {
		this.cancellationStatus = cancellationStatus;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

}
