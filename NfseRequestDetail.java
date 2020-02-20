package com.fedex.breco.insurance.dto;

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

// TODO: Auto-generated Javadoc
/**
 * The Class NfseRequestDetail.
 */
@Entity
@Table(name = "NFSE_REQUEST_DETAIL")
public class NfseRequestDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nfse master id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NFSE_REQ_SEQ")
	@SequenceGenerator(name = "NFSE_REQ_SEQ", sequenceName = "NFSE_REQ_SEQ", allocationSize = 1)
	@Column(name = "ISQN_MSTR_CD", columnDefinition = "SEQUENCE GENERATED VALUE")
	private Long nfseMasterId;

	/** The nfse response detail. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "nfseRequestDetail")
	private NfseResponseDetail nfseResponseDetail;

	/** The match reference master. */
	@JoinColumn(name = "ISQN_REF_CD")
	@OneToOne(cascade = CascadeType.ALL)
	private MatchReference matchReferenceMaster;

	/** The versao number. */
	@Column(name = "VERS_NBR", columnDefinition = "VERSAO")
	private String versaoNumber;

	/** The environment type. */
	@Column(name = "ENV_TYP_TXT", columnDefinition = "TIPOAMBIENTESISTEMA")
	private String environmentType;

	/** The nfse_cd. */
	@Column(name = "NF_SE_CD", columnDefinition = "NF_SE_CD")
	private String nfseCode;

	/** The service provider code. */
	@Column(name = "SVC_PRVDR_CD", columnDefinition = "CODCIDADE")
	private String serviceProviderCode;

	/** The fedex tax id. */
	@Column(name = "FED_TAX_ID", columnDefinition = "CNPJPRESTADOR")
	private String fedexTaxId;

	/** The city tax id. */
	@Column(name = "CTY_TAX_ID", columnDefinition = "INSCRICAOPRESTADOR")
	private String cityTaxId;

	/** The rps id. */
	@Column(name = "RP_S_ID", columnDefinition = "NUMERORPS")
	private String rpsId;

	/** The rps series id. */
	@Column(name = "RP_S_SERS_ID", columnDefinition = "SERIERPS")
	private String rpsSeriesId;

	/** The rps date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "RP_S_DT", columnDefinition = "DATAEMISSAORPS")
	private Date rpsDate;

	/** The competition date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "CMPET_DT", columnDefinition = "DATACOMPETENCIA")
	private Date competitionDate;

	/** The rps type. */
	@Column(name = "RP_S_TYP_DESC", columnDefinition = "TIPORPS")
	private String rpsType;

	/** The rps situation. */
	@Column(name = "RP_S_SI_DESC", columnDefinition = "SITUACAORPS")
	private String rpsSituation;

	/** The operation nature. */
	@Column(name = "OPER_NATRE_DESC", columnDefinition = "NATUREZADAOPERACAO")
	private String operationNature;

	/** The service provider city name. */
	@Column(name = "SVC_PRVDR_CTY_NM", columnDefinition = "MUNICIPIOPRESTACAO")
	private String serviceProviderCityName;

	/** The destination city name. */
	@Column(name = "DEST_CTY_NM", columnDefinition = "MUNICIPIOINCIDENCIA")
	private String destinationCityName;

	/** The service provision city name. */
	@Column(name = "SVC_PRVSN_CNTRY_CD", columnDefinition = "PAISSERVICO")
	private String serviceProvisionCityName;

	/** The rps description. */
	@Column(name = "RP_S_DESC", columnDefinition = "DESCRICAORPS")
	private String rpsDescription;

	/** The internal service code. */
	@Column(name = "INTR_SVC_CD", columnDefinition = "CODIGOSERVICOINTERNO")

	private String internalServiceCode;

	/** The cnae code. */
	@Column(name = "CN_AE_CD", columnDefinition = "CODIGOCNAE")
	private String cnaeCode;

	/** The item service list. */
	@Column(name = "ITM_SVC_LIST_DESC", columnDefinition = "ITEMLISTASERVICO")
	private String itemServiceList;

	/** The mastersaf city tax id. */
	@Column(name = "CITY_TAX_CD", columnDefinition = "CODIGOTRIBUTACAOMUNICIPIO")
	private String mastersafCityTaxId;

	/** The service sample. */
	@Column(name = "SVC_SAMP_DESC", columnDefinition = "")
	private String serviceSample;

	/** The calculation basis. */
	@Column(name = "CALC_BAS_DESC", columnDefinition = "")
	private String calculationBasis;

	/** The iss value number. */
	@Column(name = "ISS_VAL_NBR", columnDefinition = "")
	private String issValueNumber;

	/** The gathering type. */
	@Column(name = "GATHR_TYP_DESC", columnDefinition = "")
	private String gatheringType;

	/** The iss value continual number. */
	@Column(name = "ISS_VAL_CONTI_NBR", columnDefinition = "")
	private String issValueContinualNumber;

	/** The retention responsible desc. */
	@Column(name = "RETN_RSPBL_DESC", columnDefinition = "")
	private String retentionResponsibleDesc;

	/** The service value. */
	@Column(name = "SVC_VAL_DESC", columnDefinition = "")
	private String serviceValue;

	/** The pis value number. */
	@Column(name = "PI_S_VAL_NBR", columnDefinition = "")
	private String pisValueNumber;

	/** The contribution value number. */
	@Column(name = "CTRBN_VAL_NBR", columnDefinition = "")
	private String contributionValueNumber;

	/** The inss value number. */
	@Column(name = "IN_SS_VAL_NBR", columnDefinition = "")
	private String inssValueNumber;

	/** The tax amount gos value number. */
	@Column(name = "TAX_AMT_GO_VAL_NBR", columnDefinition = "")
	private String taxAmountGosValueNumber;

	/** The tax amount csll value number. */
	@Column(name = "TAX_AMT_CSL_VAL_NBR", columnDefinition = "")
	private String taxAmountCsllValueNumber;

	/** The service provider legal name. */
	@Column(name = "SVC_PRVDR_LGL_NM", columnDefinition = "")
	private String serviceProviderLegalName;

	/** The service provider legal address. */
	@Column(name = "SVC_PRVDR_LGL_ADDR_TXT", columnDefinition = "")
	private String serviceProviderLegalAddress;

	/** The service provider legal address number. */
	@Column(name = "SVC_PRVDR_LGL_ADDR_NBR", columnDefinition = "")
	private String serviceProviderLegalAddressNumber;

	/** The service provider legal neighbourhood address number. */
	@Column(name = "SVC_PRVDR_LGL_NBRHD_ADDR_NBR", columnDefinition = "")
	private String serviceProviderLegalNeighbourhoodAddressNumber;

	/** The service provider legal address zip code. */
	@Column(name = "SVC_PRVDR_LGL_ADDR_ZIP_CD", columnDefinition = "")
	private String serviceProviderLegalAddressZipCode;

	/** The service provider legal address state name. */
	@Column(name = "SVC_PRVDR_LGL_ADDR_ST_NM", columnDefinition = "")
	private String serviceProviderLegalAddressStateName;

	/** The service provider country code. */
	@Column(name = "SVC_PRVDR_CNTRY_CD", columnDefinition = "")
	private String serviceProviderCountryCode;

	/** The service provider phone number. */
	@Column(name = "SVC_PRVDR_TELE_NBR", columnDefinition = "")
	private String serviceProviderPhoneNumber;

	/** The service provider email address. */
	@Column(name = "SVC_PRVDR_EMAL_ADDR_TXT", columnDefinition = "")
	private String serviceProviderEmailAddress;

	/** The special taxation scheme. */
	@Column(name = "TAX_SCHME_SPCL_DESC", columnDefinition = "")
	private String specialTaxationScheme;

	/** The national samples opting. */
	@Column(name = "NATL_SP_OPT_DESC", columnDefinition = "")
	private String nationalSamplesOpting;

	/** The cultural incentive. */
	@Column(name = "CU_INCEN_DESC", columnDefinition = "")
	private String culturalIncentive;

	/** The recipient tax id. */
	@Column(name = "RECP_TAX_ID", columnDefinition = "")
	private String recipientTaxId;

	/** The recipient city registration code. */
	@Column(name = "RECP_CTY_REGIS_CD", columnDefinition = "")
	private String recipientCityRegistrationCode;

	/** The service indication tax id. */
	@Column(name = "TAX_ID_SVC_IND_DESC", columnDefinition = "")
	private String serviceIndicationTaxId;

	/** The recipient registration code. */
	@Column(name = "RECP_REGIS_CD", columnDefinition = "")
	private String recipientRegistrationCode;

	/** The recipient legal name. */
	@Column(name = "RECP_LGL_NM", columnDefinition = "")
	private String recipientLegalName;

	/** The recipient address street name. */
	@Column(name = "RECP_ADDR_STR_NM", columnDefinition = "")
	private String recipientAddressStreetName;

	/** The recipient address. */
	@Column(name = "RECP_ADDR_NBR", columnDefinition = "")
	private String recipientAddress;

	/** The recipient additional info. */
	@Column(name = "RECP_ADDL_INFO_TXT", columnDefinition = "")
	private String recipientAdditionalInfo;

	/** The recipient neighbourhood address. */
	@Column(name = "RECP_NBRHD_ADDR_TXT", columnDefinition = "")
	private String recipientNeighbourhoodAddress;

	/** The recipient city name. */
	@Column(name = "RECP_CTY_NM", columnDefinition = "")
	private String recipientCityName;

	/** The recipient state name. */
	@Column(name = "RECP_ST_NM", columnDefinition = "")
	private String recipientStateName;

	/** The recipient country code. */
	@Column(name = "RECP_CNTRY_CD", columnDefinition = "")
	private String recipientCountryCode;

	/** The recipient address zip code. */
	@Column(name = "RECP_ADDR_ZIP_CD", columnDefinition = "")
	private String recipientAddressZipCode;

	/** The recipient email address. */
	@Column(name = "RECP_EMAL_ADDR_TXT", columnDefinition = "")
	private String recipientEmailAddress;

	/** The service descrimination by string. */
	@Column(name = "SVC_DISCN_BY_ITM_DESC", columnDefinition = "")
	private String serviceDescriminationByString;

	/** The item quantity. */
	@Column(name = "ITM_QTY_DESC", columnDefinition = "")
	private String itemQuantity;

	/** The unit value. */
	@Column(name = "UNIT_VAL_DESC", columnDefinition = "")
	private String unitValue;

	/** The total amount. */
	@Column(name = "TOT_AMT_DESC", columnDefinition = "")
	private String totalAmount;

	/** The unit of measurement. */
	@Column(name = "MEAS_UNIT_DESC", columnDefinition = "")
	private String unitOfMeasurement;

	/** The deduct item value number. */
	@Column(name = "ITM_DEDUC_VAL_NBR", columnDefinition = "")
	private String deductItemValueNumber;

	/** The deduction amount. */
	@Column(name = "DEDUC_AMT_DESC", columnDefinition = "")
	private String deductionAmount;

	/** The nota fiscal number. */
	@Column(name = "NT_FSCL_LT_NBR", columnDefinition = "")
	private String notaFiscalNumber;

	/** The verification code. */
	@Column(name = "VERIF_CD", columnDefinition = "")
	private String verificationCode;

	/** The cancellation reason. */
	@Column(name = "CNCL_RESN_DESC", columnDefinition = "")
	private String cancellationReason;

	/** The cancellation reason code. */
	@Column(name = "CNCL_RESN_CD", columnDefinition = "")
	private String cancellationReasonCode;

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

	/** The service total value number. */
	@Column(name = "SVC_TOT_VAL_NBR", columnDefinition = "VPREST_VTPREST")
	private String serviceTotalValueNumber;

	/**
	 * Gets the nfse master id.
	 *
	 * @return the nfse master id
	 */
	public Long getNfseMasterId() {
		return nfseMasterId;
	}

	/**
	 * Sets the nfse master id.
	 *
	 * @param nfseMasterId the new nfse master id
	 */
	public void setNfseMasterId(Long nfseMasterId) {
		this.nfseMasterId = nfseMasterId;
	}

	/**
	 * Gets the service total value number.
	 *
	 * @return the service total value number
	 */
	public String getServiceTotalValueNumber() {
		return serviceTotalValueNumber;
	}

	/**
	 * Sets the service total value number.
	 *
	 * @param serviceTotalValueNumber the new service total value number
	 */
	public void setServiceTotalValueNumber(String serviceTotalValueNumber) {
		this.serviceTotalValueNumber = serviceTotalValueNumber;
	}

	/**
	 * Gets the nfse response detail.
	 *
	 * @return the nfse response detail
	 */
	public NfseResponseDetail getNfseResponseDetail() {
		return nfseResponseDetail;
	}

	/**
	 * Sets the nfse response detail.
	 *
	 * @param nfseResponseDetail the new nfse response detail
	 */
	public void setNfseResponseDetail(NfseResponseDetail nfseResponseDetail) {
		this.nfseResponseDetail = nfseResponseDetail;
	}

	/**
	 * Gets the versao number.
	 *
	 * @return the versao number
	 */
	public String getVersaoNumber() {
		return versaoNumber;
	}

	/**
	 * Sets the versao number.
	 *
	 * @param versaoNumber the new versao number
	 */
	public void setVersaoNumber(String versaoNumber) {
		this.versaoNumber = versaoNumber;
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
	 * Gets the fedex tax id.
	 *
	 * @return the fedex tax id
	 */
	public String getFedexTaxId() {
		return fedexTaxId;
	}

	/**
	 * Sets the fedex tax id.
	 *
	 * @param fedexTaxId the new fedex tax id
	 */
	public void setFedexTaxId(String fedexTaxId) {
		this.fedexTaxId = fedexTaxId;
	}

	/**
	 * Gets the city tax id.
	 *
	 * @return the city tax id
	 */
	public String getCityTaxId() {
		return cityTaxId;
	}

	/**
	 * Sets the city tax id.
	 *
	 * @param cityTaxId the new city tax id
	 */
	public void setCityTaxId(String cityTaxId) {
		this.cityTaxId = cityTaxId;
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
	 * Gets the rps series id.
	 *
	 * @return the rps series id
	 */
	public String getRpsSeriesId() {
		return rpsSeriesId;
	}

	/**
	 * Sets the rps series id.
	 *
	 * @param rpsSeriesId the new rps series id
	 */
	public void setRpsSeriesId(String rpsSeriesId) {
		this.rpsSeriesId = rpsSeriesId;
	}

	/**
	 * Gets the rps date.
	 *
	 * @return the rps date
	 */
	public Date getRpsDate() {
		return rpsDate;
	}

	/**
	 * Sets the rps date.
	 *
	 * @param rpsDate the new rps date
	 */
	public void setRpsDate(Date rpsDate) {
		this.rpsDate = rpsDate;
	}

	/**
	 * Gets the competition date.
	 *
	 * @return the competition date
	 */
	public Date getCompetitionDate() {
		return competitionDate;
	}

	/**
	 * Sets the competition date.
	 *
	 * @param competitionDate the new competition date
	 */
	public void setCompetitionDate(Date competitionDate) {
		this.competitionDate = competitionDate;
	}

	/**
	 * Gets the rps type.
	 *
	 * @return the rps type
	 */
	public String getRpsType() {
		return rpsType;
	}

	/**
	 * Sets the rps type.
	 *
	 * @param rpsType the new rps type
	 */
	public void setRpsType(String rpsType) {
		this.rpsType = rpsType;
	}

	/**
	 * Gets the rps situation.
	 *
	 * @return the rps situation
	 */
	public String getRpsSituation() {
		return rpsSituation;
	}

	/**
	 * Sets the rps situation.
	 *
	 * @param rpsSituation the new rps situation
	 */
	public void setRpsSituation(String rpsSituation) {
		this.rpsSituation = rpsSituation;
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
	 * Gets the service provider city name.
	 *
	 * @return the service provider city name
	 */
	public String getServiceProviderCityName() {
		return serviceProviderCityName;
	}

	/**
	 * Sets the service provider city name.
	 *
	 * @param serviceProviderCityName the new service provider city name
	 */
	public void setServiceProviderCityName(String serviceProviderCityName) {
		this.serviceProviderCityName = serviceProviderCityName;
	}

	/**
	 * Gets the destination city name.
	 *
	 * @return the destination city name
	 */
	public String getDestinationCityName() {
		return destinationCityName;
	}

	/**
	 * Sets the destination city name.
	 *
	 * @param destinationCityName the new destination city name
	 */
	public void setDestinationCityName(String destinationCityName) {
		this.destinationCityName = destinationCityName;
	}

	/**
	 * Gets the service provision city name.
	 *
	 * @return the service provision city name
	 */
	public String getServiceProvisionCityName() {
		return serviceProvisionCityName;
	}

	/**
	 * Sets the service provision city name.
	 *
	 * @param serviceProvisionCityName the new service provision city name
	 */
	public void setServiceProvisionCityName(String serviceProvisionCityName) {
		this.serviceProvisionCityName = serviceProvisionCityName;
	}

	/**
	 * Gets the rps description.
	 *
	 * @return the rps description
	 */
	public String getRpsDescription() {
		return rpsDescription;
	}

	/**
	 * Sets the rps description.
	 *
	 * @param rpsDescription the new rps description
	 */
	public void setRpsDescription(String rpsDescription) {
		this.rpsDescription = rpsDescription;
	}

	/**
	 * Gets the internal service code.
	 *
	 * @return the internal service code
	 */
	public String getInternalServiceCode() {
		return internalServiceCode;
	}

	/**
	 * Sets the internal service code.
	 *
	 * @param internalServiceCode the new internal service code
	 */
	public void setInternalServiceCode(String internalServiceCode) {
		this.internalServiceCode = internalServiceCode;
	}

	/**
	 * Gets the cnae code.
	 *
	 * @return the cnae code
	 */
	public String getCnaeCode() {
		return cnaeCode;
	}

	/**
	 * Sets the cnae code.
	 *
	 * @param cnaeCode the new cnae code
	 */
	public void setCnaeCode(String cnaeCode) {
		this.cnaeCode = cnaeCode;
	}

	/**
	 * Gets the item service list.
	 *
	 * @return the item service list
	 */
	public String getItemServiceList() {
		return itemServiceList;
	}

	/**
	 * Sets the item service list.
	 *
	 * @param itemServiceList the new item service list
	 */
	public void setItemServiceList(String itemServiceList) {
		this.itemServiceList = itemServiceList;
	}

	/**
	 * Gets the mastersaf city tax id.
	 *
	 * @return the mastersaf city tax id
	 */
	public String getMastersafCityTaxId() {
		return mastersafCityTaxId;
	}

	/**
	 * Sets the mastersaf city tax id.
	 *
	 * @param mastersafCityTaxId the new mastersaf city tax id
	 */
	public void setMastersafCityTaxId(String mastersafCityTaxId) {
		this.mastersafCityTaxId = mastersafCityTaxId;
	}

	/**
	 * Gets the service sample.
	 *
	 * @return the service sample
	 */
	public String getServiceSample() {
		return serviceSample;
	}

	/**
	 * Sets the service sample.
	 *
	 * @param serviceSample the new service sample
	 */
	public void setServiceSample(String serviceSample) {
		this.serviceSample = serviceSample;
	}

	/**
	 * Gets the calculation basis.
	 *
	 * @return the calculation basis
	 */
	public String getCalculationBasis() {
		return calculationBasis;
	}

	/**
	 * Sets the calculation basis.
	 *
	 * @param calculationBasis the new calculation basis
	 */
	public void setCalculationBasis(String calculationBasis) {
		this.calculationBasis = calculationBasis;
	}

	/**
	 * Gets the iss value number.
	 *
	 * @return the iss value number
	 */
	public String getIssValueNumber() {
		return issValueNumber;
	}

	/**
	 * Sets the iss value number.
	 *
	 * @param issValueNumber the new iss value number
	 */
	public void setIssValueNumber(String issValueNumber) {
		this.issValueNumber = issValueNumber;
	}

	/**
	 * Gets the gathering type.
	 *
	 * @return the gathering type
	 */
	public String getGatheringType() {
		return gatheringType;
	}

	/**
	 * Sets the gathering type.
	 *
	 * @param gatheringType the new gathering type
	 */
	public void setGatheringType(String gatheringType) {
		this.gatheringType = gatheringType;
	}

	/**
	 * Gets the iss value continual number.
	 *
	 * @return the iss value continual number
	 */
	public String getIssValueContinualNumber() {
		return issValueContinualNumber;
	}

	/**
	 * Sets the iss value continual number.
	 *
	 * @param issValueContinualNumber the new iss value continual number
	 */
	public void setIssValueContinualNumber(String issValueContinualNumber) {
		this.issValueContinualNumber = issValueContinualNumber;
	}

	/**
	 * Gets the retention responsible desc.
	 *
	 * @return the retention responsible desc
	 */
	public String getRetentionResponsibleDesc() {
		return retentionResponsibleDesc;
	}

	/**
	 * Sets the retention responsible desc.
	 *
	 * @param retentionResponsibleDesc the new retention responsible desc
	 */
	public void setRetentionResponsibleDesc(String retentionResponsibleDesc) {
		this.retentionResponsibleDesc = retentionResponsibleDesc;
	}

	/**
	 * Gets the service value.
	 *
	 * @return the service value
	 */
	public String getServiceValue() {
		return serviceValue;
	}

	/**
	 * Sets the service value.
	 *
	 * @param serviceValue the new service value
	 */
	public void setServiceValue(String serviceValue) {
		this.serviceValue = serviceValue;
	}

	/**
	 * Gets the pis value number.
	 *
	 * @return the pis value number
	 */
	public String getPisValueNumber() {
		return pisValueNumber;
	}

	/**
	 * Sets the pis value number.
	 *
	 * @param pisValueNumber the new pis value number
	 */
	public void setPisValueNumber(String pisValueNumber) {
		this.pisValueNumber = pisValueNumber;
	}

	/**
	 * Gets the contribution value number.
	 *
	 * @return the contribution value number
	 */
	public String getContributionValueNumber() {
		return contributionValueNumber;
	}

	/**
	 * Sets the contribution value number.
	 *
	 * @param contributionValueNumber the new contribution value number
	 */
	public void setContributionValueNumber(String contributionValueNumber) {
		this.contributionValueNumber = contributionValueNumber;
	}

	/**
	 * Gets the inss value number.
	 *
	 * @return the inss value number
	 */
	public String getInssValueNumber() {
		return inssValueNumber;
	}

	/**
	 * Sets the inss value number.
	 *
	 * @param inssValueNumber the new inss value number
	 */
	public void setInssValueNumber(String inssValueNumber) {
		this.inssValueNumber = inssValueNumber;
	}

	/**
	 * Gets the tax amount gos value number.
	 *
	 * @return the tax amount gos value number
	 */
	public String getTaxAmountGosValueNumber() {
		return taxAmountGosValueNumber;
	}

	/**
	 * Sets the tax amount gos value number.
	 *
	 * @param taxAmountGosValueNumber the new tax amount gos value number
	 */
	public void setTaxAmountGosValueNumber(String taxAmountGosValueNumber) {
		this.taxAmountGosValueNumber = taxAmountGosValueNumber;
	}

	/**
	 * Gets the tax amount csll value number.
	 *
	 * @return the tax amount csll value number
	 */
	public String getTaxAmountCsllValueNumber() {
		return taxAmountCsllValueNumber;
	}

	/**
	 * Sets the tax amount csll value number.
	 *
	 * @param taxAmountCsllValueNumber the new tax amount csll value number
	 */
	public void setTaxAmountCsllValueNumber(String taxAmountCsllValueNumber) {
		this.taxAmountCsllValueNumber = taxAmountCsllValueNumber;
	}

	/**
	 * Gets the service provider legal name.
	 *
	 * @return the service provider legal name
	 */
	public String getServiceProviderLegalName() {
		return serviceProviderLegalName;
	}

	/**
	 * Sets the service provider legal name.
	 *
	 * @param serviceProviderLegalName the new service provider legal name
	 */
	public void setServiceProviderLegalName(String serviceProviderLegalName) {
		this.serviceProviderLegalName = serviceProviderLegalName;
	}

	/**
	 * Gets the service provider legal address.
	 *
	 * @return the service provider legal address
	 */
	public String getServiceProviderLegalAddress() {
		return serviceProviderLegalAddress;
	}

	/**
	 * Sets the service provider legal address.
	 *
	 * @param serviceProviderLegalAddress the new service provider legal address
	 */
	public void setServiceProviderLegalAddress(String serviceProviderLegalAddress) {
		this.serviceProviderLegalAddress = serviceProviderLegalAddress;
	}

	/**
	 * Gets the service provider legal address number.
	 *
	 * @return the service provider legal address number
	 */
	public String getServiceProviderLegalAddressNumber() {
		return serviceProviderLegalAddressNumber;
	}

	/**
	 * Sets the service provider legal address number.
	 *
	 * @param serviceProviderLegalAddressNumber the new service provider legal
	 *                                          address number
	 */
	public void setServiceProviderLegalAddressNumber(String serviceProviderLegalAddressNumber) {
		this.serviceProviderLegalAddressNumber = serviceProviderLegalAddressNumber;
	}

	/**
	 * Gets the service provider legal neighbourhood address number.
	 *
	 * @return the service provider legal neighbourhood address number
	 */
	public String getServiceProviderLegalNeighbourhoodAddressNumber() {
		return serviceProviderLegalNeighbourhoodAddressNumber;
	}

	/**
	 * Sets the service provider legal neighbourhood address number.
	 *
	 * @param serviceProviderLegalNeighbourhoodAddressNumber the new service
	 *                                                       provider legal
	 *                                                       neighbourhood address
	 *                                                       number
	 */
	public void setServiceProviderLegalNeighbourhoodAddressNumber(
			String serviceProviderLegalNeighbourhoodAddressNumber) {
		this.serviceProviderLegalNeighbourhoodAddressNumber = serviceProviderLegalNeighbourhoodAddressNumber;
	}

	/**
	 * Gets the service provider legal address zip code.
	 *
	 * @return the service provider legal address zip code
	 */
	public String getServiceProviderLegalAddressZipCode() {
		return serviceProviderLegalAddressZipCode;
	}

	/**
	 * Sets the service provider legal address zip code.
	 *
	 * @param serviceProviderLegalAddressZipCode the new service provider legal
	 *                                           address zip code
	 */
	public void setServiceProviderLegalAddressZipCode(String serviceProviderLegalAddressZipCode) {
		this.serviceProviderLegalAddressZipCode = serviceProviderLegalAddressZipCode;
	}

	/**
	 * Gets the service provider legal address state name.
	 *
	 * @return the service provider legal address state name
	 */
	public String getServiceProviderLegalAddressStateName() {
		return serviceProviderLegalAddressStateName;
	}

	/**
	 * Sets the service provider legal address state name.
	 *
	 * @param serviceProviderLegalAddressStateName the new service provider legal
	 *                                             address state name
	 */
	public void setServiceProviderLegalAddressStateName(String serviceProviderLegalAddressStateName) {
		this.serviceProviderLegalAddressStateName = serviceProviderLegalAddressStateName;
	}

	/**
	 * Gets the service provider country code.
	 *
	 * @return the service provider country code
	 */
	public String getServiceProviderCountryCode() {
		return serviceProviderCountryCode;
	}

	/**
	 * Sets the service provider country code.
	 *
	 * @param serviceProviderCountryCode the new service provider country code
	 */
	public void setServiceProviderCountryCode(String serviceProviderCountryCode) {
		this.serviceProviderCountryCode = serviceProviderCountryCode;
	}

	/**
	 * Gets the service provider phone number.
	 *
	 * @return the service provider phone number
	 */
	public String getServiceProviderPhoneNumber() {
		return serviceProviderPhoneNumber;
	}

	/**
	 * Sets the service provider phone number.
	 *
	 * @param serviceProviderPhoneNumber the new service provider phone number
	 */
	public void setServiceProviderPhoneNumber(String serviceProviderPhoneNumber) {
		this.serviceProviderPhoneNumber = serviceProviderPhoneNumber;
	}

	/**
	 * Gets the service provider email address.
	 *
	 * @return the service provider email address
	 */
	public String getServiceProviderEmailAddress() {
		return serviceProviderEmailAddress;
	}

	/**
	 * Sets the service provider email address.
	 *
	 * @param serviceProviderEmailAddress the new service provider email address
	 */
	public void setServiceProviderEmailAddress(String serviceProviderEmailAddress) {
		this.serviceProviderEmailAddress = serviceProviderEmailAddress;
	}

	/**
	 * Gets the special taxation scheme.
	 *
	 * @return the special taxation scheme
	 */
	public String getSpecialTaxationScheme() {
		return specialTaxationScheme;
	}

	/**
	 * Sets the special taxation scheme.
	 *
	 * @param specialTaxationScheme the new special taxation scheme
	 */
	public void setSpecialTaxationScheme(String specialTaxationScheme) {
		this.specialTaxationScheme = specialTaxationScheme;
	}

	/**
	 * Gets the national samples opting.
	 *
	 * @return the national samples opting
	 */
	public String getNationalSamplesOpting() {
		return nationalSamplesOpting;
	}

	/**
	 * Sets the national samples opting.
	 *
	 * @param nationalSamplesOpting the new national samples opting
	 */
	public void setNationalSamplesOpting(String nationalSamplesOpting) {
		this.nationalSamplesOpting = nationalSamplesOpting;
	}

	/**
	 * Gets the cultural incentive.
	 *
	 * @return the cultural incentive
	 */
	public String getCulturalIncentive() {
		return culturalIncentive;
	}

	/**
	 * Sets the cultural incentive.
	 *
	 * @param culturalIncentive the new cultural incentive
	 */
	public void setCulturalIncentive(String culturalIncentive) {
		this.culturalIncentive = culturalIncentive;
	}

	/**
	 * Gets the recipient tax id.
	 *
	 * @return the recipient tax id
	 */
	public String getRecipientTaxId() {
		return recipientTaxId;
	}

	/**
	 * Sets the recipient tax id.
	 *
	 * @param recipientTaxId the new recipient tax id
	 */
	public void setRecipientTaxId(String recipientTaxId) {
		this.recipientTaxId = recipientTaxId;
	}

	/**
	 * Gets the recipient city registration code.
	 *
	 * @return the recipient city registration code
	 */
	public String getRecipientCityRegistrationCode() {
		return recipientCityRegistrationCode;
	}

	/**
	 * Sets the recipient city registration code.
	 *
	 * @param recipientCityRegistrationCode the new recipient city registration code
	 */
	public void setRecipientCityRegistrationCode(String recipientCityRegistrationCode) {
		this.recipientCityRegistrationCode = recipientCityRegistrationCode;
	}

	/**
	 * Gets the service indication tax id.
	 *
	 * @return the service indication tax id
	 */
	public String getServiceIndicationTaxId() {
		return serviceIndicationTaxId;
	}

	/**
	 * Sets the service indication tax id.
	 *
	 * @param serviceIndicationTaxId the new service indication tax id
	 */
	public void setServiceIndicationTaxId(String serviceIndicationTaxId) {
		this.serviceIndicationTaxId = serviceIndicationTaxId;
	}

	/**
	 * Gets the recipient registration code.
	 *
	 * @return the recipient registration code
	 */
	public String getRecipientRegistrationCode() {
		return recipientRegistrationCode;
	}

	/**
	 * Sets the recipient registration code.
	 *
	 * @param recipientRegistrationCode the new recipient registration code
	 */
	public void setRecipientRegistrationCode(String recipientRegistrationCode) {
		this.recipientRegistrationCode = recipientRegistrationCode;
	}

	/**
	 * Gets the recipient legal name.
	 *
	 * @return the recipient legal name
	 */
	public String getRecipientLegalName() {
		return recipientLegalName;
	}

	/**
	 * Sets the recipient legal name.
	 *
	 * @param recipientLegalName the new recipient legal name
	 */
	public void setRecipientLegalName(String recipientLegalName) {
		this.recipientLegalName = recipientLegalName;
	}

	/**
	 * Gets the recipient address street name.
	 *
	 * @return the recipient address street name
	 */
	public String getRecipientAddressStreetName() {
		return recipientAddressStreetName;
	}

	/**
	 * Sets the recipient address street name.
	 *
	 * @param recipientAddressStreetName the new recipient address street name
	 */
	public void setRecipientAddressStreetName(String recipientAddressStreetName) {
		this.recipientAddressStreetName = recipientAddressStreetName;
	}

	/**
	 * Gets the recipient address.
	 *
	 * @return the recipient address
	 */
	public String getRecipientAddress() {
		return recipientAddress;
	}

	/**
	 * Sets the recipient address.
	 *
	 * @param recipientAddress the new recipient address
	 */
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	/**
	 * Gets the recipient additional info.
	 *
	 * @return the recipient additional info
	 */
	public String getRecipientAdditionalInfo() {
		return recipientAdditionalInfo;
	}

	/**
	 * Sets the recipient additional info.
	 *
	 * @param recipientAdditionalInfo the new recipient additional info
	 */
	public void setRecipientAdditionalInfo(String recipientAdditionalInfo) {
		this.recipientAdditionalInfo = recipientAdditionalInfo;
	}

	/**
	 * Gets the recipient neighbourhood address.
	 *
	 * @return the recipient neighbourhood address
	 */
	public String getRecipientNeighbourhoodAddress() {
		return recipientNeighbourhoodAddress;
	}

	/**
	 * Sets the recipient neighbourhood address.
	 *
	 * @param recipientNeighbourhoodAddress the new recipient neighbourhood address
	 */
	public void setRecipientNeighbourhoodAddress(String recipientNeighbourhoodAddress) {
		this.recipientNeighbourhoodAddress = recipientNeighbourhoodAddress;
	}

	/**
	 * Gets the recipient city name.
	 *
	 * @return the recipient city name
	 */
	public String getRecipientCityName() {
		return recipientCityName;
	}

	/**
	 * Sets the recipient city name.
	 *
	 * @param recipientCityName the new recipient city name
	 */
	public void setRecipientCityName(String recipientCityName) {
		this.recipientCityName = recipientCityName;
	}

	/**
	 * Gets the recipient state name.
	 *
	 * @return the recipient state name
	 */
	public String getRecipientStateName() {
		return recipientStateName;
	}

	/**
	 * Sets the recipient state name.
	 *
	 * @param recipientStateName the new recipient state name
	 */
	public void setRecipientStateName(String recipientStateName) {
		this.recipientStateName = recipientStateName;
	}

	/**
	 * Gets the recipient country code.
	 *
	 * @return the recipient country code
	 */
	public String getRecipientCountryCode() {
		return recipientCountryCode;
	}

	/**
	 * Sets the recipient country code.
	 *
	 * @param recipientCountryCode the new recipient country code
	 */
	public void setRecipientCountryCode(String recipientCountryCode) {
		this.recipientCountryCode = recipientCountryCode;
	}

	/**
	 * Gets the recipient address zip code.
	 *
	 * @return the recipient address zip code
	 */
	public String getRecipientAddressZipCode() {
		return recipientAddressZipCode;
	}

	/**
	 * Sets the recipient address zip code.
	 *
	 * @param recipientAddressZipCode the new recipient address zip code
	 */
	public void setRecipientAddressZipCode(String recipientAddressZipCode) {
		this.recipientAddressZipCode = recipientAddressZipCode;
	}

	/**
	 * Gets the recipient email address.
	 *
	 * @return the recipient email address
	 */
	public String getRecipientEmailAddress() {
		return recipientEmailAddress;
	}

	/**
	 * Sets the recipient email address.
	 *
	 * @param recipientEmailAddress the new recipient email address
	 */
	public void setRecipientEmailAddress(String recipientEmailAddress) {
		this.recipientEmailAddress = recipientEmailAddress;
	}

	/**
	 * Gets the service descrimination by string.
	 *
	 * @return the service descrimination by string
	 */
	public String getServiceDescriminationByString() {
		return serviceDescriminationByString;
	}

	/**
	 * Sets the service descrimination by string.
	 *
	 * @param serviceDescriminationByString the new service descrimination by string
	 */
	public void setServiceDescriminationByString(String serviceDescriminationByString) {
		this.serviceDescriminationByString = serviceDescriminationByString;
	}

	/**
	 * Gets the item quantity.
	 *
	 * @return the item quantity
	 */
	public String getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * Sets the item quantity.
	 *
	 * @param itemQuantity the new item quantity
	 */
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * Gets the unit value.
	 *
	 * @return the unit value
	 */
	public String getUnitValue() {
		return unitValue;
	}

	/**
	 * Sets the unit value.
	 *
	 * @param unitValue the new unit value
	 */
	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
	}

	/**
	 * Gets the total amount.
	 *
	 * @return the total amount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Sets the total amount.
	 *
	 * @param totalAmount the new total amount
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Gets the unit of measurement.
	 *
	 * @return the unit of measurement
	 */
	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	/**
	 * Sets the unit of measurement.
	 *
	 * @param unitOfMeasurement the new unit of measurement
	 */
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	/**
	 * Gets the deduct item value number.
	 *
	 * @return the deduct item value number
	 */
	public String getDeductItemValueNumber() {
		return deductItemValueNumber;
	}

	/**
	 * Sets the deduct item value number.
	 *
	 * @param deductItemValueNumber the new deduct item value number
	 */
	public void setDeductItemValueNumber(String deductItemValueNumber) {
		this.deductItemValueNumber = deductItemValueNumber;
	}

	/**
	 * Gets the deduction amount.
	 *
	 * @return the deduction amount
	 */
	public String getDeductionAmount() {
		return deductionAmount;
	}

	/**
	 * Sets the deduction amount.
	 *
	 * @param deductionAmount the new deduction amount
	 */
	public void setDeductionAmount(String deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	/**
	 * Gets the nota fiscal number.
	 *
	 * @return the nota fiscal number
	 */
	public String getNotaFiscalNumber() {
		return notaFiscalNumber;
	}

	/**
	 * Sets the nota fiscal number.
	 *
	 * @param notaFiscalNumber the new nota fiscal number
	 */
	public void setNotaFiscalNumber(String notaFiscalNumber) {
		this.notaFiscalNumber = notaFiscalNumber;
	}

	/**
	 * Gets the verification code.
	 *
	 * @return the verification code
	 */
	public String getVerificationCode() {
		return verificationCode;
	}

	/**
	 * Sets the verification code.
	 *
	 * @param verificationCode the new verification code
	 */
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
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
	 * Gets the cancellation reason code.
	 *
	 * @return the cancellation reason code
	 */
	public String getCancellationReasonCode() {
		return cancellationReasonCode;
	}

	/**
	 * Sets the cancellation reason code.
	 *
	 * @param cancellationReasonCode the new cancellation reason code
	 */
	public void setCancellationReasonCode(String cancellationReasonCode) {
		this.cancellationReasonCode = cancellationReasonCode;
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
	 * Gets the match reference master.
	 *
	 * @return the match reference master
	 */
	public MatchReference getMatchReferenceMaster() {
		return matchReferenceMaster;
	}

	/**
	 * Sets the match reference master.
	 *
	 * @param matchReferenceMaster the new match reference master
	 */
	public void setMatchReferenceMaster(MatchReference matchReferenceMaster) {
		this.matchReferenceMaster = matchReferenceMaster;
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

	public String getNfseCode() {
		return nfseCode;
	}

	public void setNfseCode(String nfseCode) {
		this.nfseCode = nfseCode;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NfseRequestDetail [nfseMasterId=" + nfseMasterId + ", nfseResponseDetail=" + nfseResponseDetail
				+ ", matchReferenceMaster=" + matchReferenceMaster + ", versaoNumber=" + versaoNumber
				+ ", environmentType=" + environmentType + ", nfseCode=" + nfseCode + ", serviceProviderCode="
				+ serviceProviderCode + ", fedexTaxId=" + fedexTaxId + ", cityTaxId=" + cityTaxId + ", rpsId=" + rpsId
				+ ", rpsSeriesId=" + rpsSeriesId + ", rpsDate=" + rpsDate + ", competitionDate=" + competitionDate
				+ ", rpsType=" + rpsType + ", rpsSituation=" + rpsSituation + ", operationNature=" + operationNature
				+ ", serviceProviderCityName=" + serviceProviderCityName + ", destinationCityName="
				+ destinationCityName + ", serviceProvisionCityName=" + serviceProvisionCityName + ", rpsDescription="
				+ rpsDescription + ", internalServiceCode=" + internalServiceCode + ", cnaeCode=" + cnaeCode
				+ ", itemServiceList=" + itemServiceList + ", mastersafCityTaxId=" + mastersafCityTaxId
				+ ", serviceSample=" + serviceSample + ", calculationBasis=" + calculationBasis + ", issValueNumber="
				+ issValueNumber + ", gatheringType=" + gatheringType + ", issValueContinualNumber="
				+ issValueContinualNumber + ", retentionResponsibleDesc=" + retentionResponsibleDesc + ", serviceValue="
				+ serviceValue + ", pisValueNumber=" + pisValueNumber + ", contributionValueNumber="
				+ contributionValueNumber + ", inssValueNumber=" + inssValueNumber + ", taxAmountGosValueNumber="
				+ taxAmountGosValueNumber + ", taxAmountCsllValueNumber=" + taxAmountCsllValueNumber
				+ ", serviceProviderLegalName=" + serviceProviderLegalName + ", serviceProviderLegalAddress="
				+ serviceProviderLegalAddress + ", serviceProviderLegalAddressNumber="
				+ serviceProviderLegalAddressNumber + ", serviceProviderLegalNeighbourhoodAddressNumber="
				+ serviceProviderLegalNeighbourhoodAddressNumber + ", serviceProviderLegalAddressZipCode="
				+ serviceProviderLegalAddressZipCode + ", serviceProviderLegalAddressStateName="
				+ serviceProviderLegalAddressStateName + ", serviceProviderCountryCode=" + serviceProviderCountryCode
				+ ", serviceProviderPhoneNumber=" + serviceProviderPhoneNumber + ", serviceProviderEmailAddress="
				+ serviceProviderEmailAddress + ", specialTaxationScheme=" + specialTaxationScheme
				+ ", nationalSamplesOpting=" + nationalSamplesOpting + ", culturalIncentive=" + culturalIncentive
				+ ", recipientTaxId=" + recipientTaxId + ", recipientCityRegistrationCode="
				+ recipientCityRegistrationCode + ", serviceIndicationTaxId=" + serviceIndicationTaxId
				+ ", recipientRegistrationCode=" + recipientRegistrationCode + ", recipientLegalName="
				+ recipientLegalName + ", recipientAddressStreetName=" + recipientAddressStreetName
				+ ", recipientAddress=" + recipientAddress + ", recipientAdditionalInfo=" + recipientAdditionalInfo
				+ ", recipientNeighbourhoodAddress=" + recipientNeighbourhoodAddress + ", recipientCityName="
				+ recipientCityName + ", recipientStateName=" + recipientStateName + ", recipientCountryCode="
				+ recipientCountryCode + ", recipientAddressZipCode=" + recipientAddressZipCode
				+ ", recipientEmailAddress=" + recipientEmailAddress + ", serviceDescriminationByString="
				+ serviceDescriminationByString + ", itemQuantity=" + itemQuantity + ", unitValue=" + unitValue
				+ ", totalAmount=" + totalAmount + ", unitOfMeasurement=" + unitOfMeasurement
				+ ", deductItemValueNumber=" + deductItemValueNumber + ", deductionAmount=" + deductionAmount
				+ ", notaFiscalNumber=" + notaFiscalNumber + ", verificationCode=" + verificationCode
				+ ", cancellationReason=" + cancellationReason + ", cancellationReasonCode=" + cancellationReasonCode
				+ ", creationDate=" + creationDate + ", lastModificationDate=" + lastModificationDate
				+ ", insuranceEndorseStatus=" + insuranceEndorseStatus + ", tmsFileStatus=" + tmsFileStatus
				+ ", cancellationStatus=" + cancellationStatus + ", cancellationDate=" + cancellationDate + "]";
	}

}
