package com.fedex.breco.insurance.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class CteAuditDetail.
 */
@Entity
@Table(name = "INSURANCE_RESPONSE_INFO")
public class InsuranceResponseMaster implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "INS_RESP_SEQ")
	@SequenceGenerator(name = "INS_RESP_SEQ", sequenceName = "INS_RESP_SEQ", allocationSize=1)
	@Column(name = "ISQN_CD", columnDefinition = "")
	private Long isqnCd;

	/*		*//** The Customer Master details. *//*
													 * @OneToOne(mappedBy = "insCustDetails", cascade = CascadeType.ALL,
													 * fetch = FetchType.LAZY) private CustomerInfoMaster
													 * customerTaxDetailsMaster;
													 */

	/** PRODUCT NUMBER. */
	@Column(name = "PROTO_NBR", columnDefinition = "PRODUCT NUMBER")
	private String protocolNbr;

	/** DOCUMENT NUMBER. */
	@Column(name = "DOC_NBR", columnDefinition = "DOCUMENT NUMBER")
	private String docNbr;

	/** DOCUMENT SERIEL TEXT. */
	@Column(name = "DOC_SERS_TXT", columnDefinition = "DOCUMENT SERIEL TEXT")
	private String docSresTxt;

	/** Document is branch text. */
	@Column(name = " DOC_IS_BRNCH_TXT", columnDefinition = "DOCUMENT IS BRANCH TEXT")
	private String docIsBranchTxt;

	/** Customer Tax Id. */
	@Column(name = "CUST_TAX_ID", columnDefinition = "CUSTOMER TAX ID")
	private String custTaxId;

	/** Document type id. */
	@Column(name = "DOC_TYP_ID", columnDefinition = "DOCUMENT TYPE ID ")
	private String docTypeId;

	/** Document type id. */
	@Column(name = "ADDL_INFO_TXT", columnDefinition = "Additional Info Text ")
	private String additinalText;
	
	/** Document record timestamp. */
	@Column(name = "DOC_REC_TMSTP", columnDefinition = "DOCUMENT RECORD TIMESTAMP")
	private Date docRecTmstp;

	/** Registration number. */
	@Column(name = "REGIS_NBR", columnDefinition = "REGISTERATION NUMBER")
	private String regNbr;

	/** The creation date. */
	@Column(name = "INS_TAX_ID", columnDefinition = "INSURANCE TAX ID")
	private String insuranceTaxId;

	/** LOSS_RESN_TXT. */
	@Column(name = "INS_NM", columnDefinition = "INSURANCE NUMBER")
	private String insuranceNbr;

	/** ROOF FOR BREAKDOWNS. */
	@Column(name = "PLCY_NBR", columnDefinition = "POLICY NUMBER")
	private String policyNbr;
	
	/** Movement type text. */
	@Column(name = "MOVMT_TYP_ANOTN_TXT", columnDefinition = "MOVEMENT TYPE TEXT")
	private String contractPenalties;	
	
	/** Insurance tax id. */
	@Column(name = "WAIVR_TYP_DESC", columnDefinition = "Waiver type desctiption")
	private String waiverTypDesc;

	/** Rec value text. */
	@Column(name = "REC_VAL_TXT", columnDefinition = "REC VALUE TEXT")
	private String recValTxt;

	/** Registration branch description. */
	@Column(name = "REGIS_BRNCH_DESC", columnDefinition = "REGISTRATION BRANCH DESCRIPTION")
	private String regisBranchDesc;
	
	/** Error cmplm information code. */
	@Column(name = "ERR_CMPLM_INFO_CD", columnDefinition = "ERROR CMPLM INFO CODE")
	private String errCmplmInfoCd;	
	
	/** ERROR CMPLM INFORMATION DESCRIPTION. */
	@Column(name = "ERR_CMPLM_INFO_DESC", columnDefinition = "ERROR CMPLM INFORMATION DESCRIPTION")
	private String errCmplmInfoDesc;
	
	/** Dspl exptd value number */
	@Column(name = "DSPL_EXPTD_VAL_NBR", columnDefinition = "DSPL EXPTD VALUE NUMBER")
	private String dsplExptdValNbr;

	/** Dspl entered value number. */
	@Column(name = "DSPL_ENTRD_VAL_NBR", columnDefinition = "DSPL ENTRD VALUE NUMBER")
	private String dsplEntrdValNbr;

	/** cmpl information code */
	@Column(name = "CMPLM_INFO_CD", columnDefinition = "CMPLM INFO CD")
	private String cmplmInfoCd;
	
	/** CONTRACT PENALTIES. */
	@Column(name = "CMPLM_INFO_DESC", columnDefinition = "CMPLM INFO DESC")
	private String cmplmInfoDesc;
	
	/** Insurance resp type text. */
	@Column(name = "INS_RESP_TYP_TXT", columnDefinition = "INSURANCE RESPONSE TYPE TEXT")
	private String insRespTypTxt;

	/** Policy number. */
	@Column(name = "CREATE_DT", columnDefinition = "CREATE DATE")
	private Date createDate;
	
	/** Modify date. */
	@Column(name = "MODFY_DT", columnDefinition = "MODIFY DATE")
	private Date modifyDate;

	/** NFSE Key. */
	@Column(name = "NF_SE_CD", columnDefinition = "NFSE Key")
	private String nfseKey;
	
	/** CTe Key. */
	@Column(name = "CT_E_CD", columnDefinition = "CTe Key")
	private String cteKey;
	
	/** INSURANCE RESPONSE Status Code. */
	@Column(name = "INS_RESP_STAT_CD", columnDefinition = "INSURANCE RESPONSE Status Code")
	private String statusCd;
	
	/** INSURANCE RESPONSE Status Code. */
	@Column(name = "PAYR_TAX_ID", columnDefinition = "Payor Tax ID")
	private String payerTaxId;
	
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
	 * @return the protocolNbr
	 */
	public String getProtocolNbr() {
		return protocolNbr;
	}

	/**
	 * @param protocolNbr the protocolNbr to set
	 */
	public void setProtocolNbr(String protocolNbr) {
		this.protocolNbr = protocolNbr;
	}

	/**
	 * @return the docNbr
	 */
	public String getDocNbr() {
		return docNbr;
	}

	/**
	 * @param docNbr the docNbr to set
	 */
	public void setDocNbr(String docNbr) {
		this.docNbr = docNbr;
	}

	/**
	 * @return the docSresTxt
	 */
	public String getDocSresTxt() {
		return docSresTxt;
	}

	/**
	 * @param docSresTxt the docSresTxt to set
	 */
	public void setDocSresTxt(String docSresTxt) {
		this.docSresTxt = docSresTxt;
	}

	/**
	 * @return the docIsBranchTxt
	 */
	public String getDocIsBranchTxt() {
		return docIsBranchTxt;
	}

	/**
	 * @param docIsBranchTxt the docIsBranchTxt to set
	 */
	public void setDocIsBranchTxt(String docIsBranchTxt) {
		this.docIsBranchTxt = docIsBranchTxt;
	}

	/**
	 * @return the custTaxId
	 */
	public String getCustTaxId() {
		return custTaxId;
	}

	/**
	 * @param custTaxId the custTaxId to set
	 */
	public void setCustTaxId(String custTaxId) {
		this.custTaxId = custTaxId;
	}

	/**
	 * @return the docTypeId
	 */
	public String getDocTypeId() {
		return docTypeId;
	}

	/**
	 * @param docTypeId the docTypeId to set
	 */
	public void setDocTypeId(String docTypeId) {
		this.docTypeId = docTypeId;
	}

	/**
	 * @return the additinalText
	 */
	public String getAdditinalText() {
		return additinalText;
	}

	/**
	 * @param additinalText the additinalText to set
	 */
	public void setAdditinalText(String additinalText) {
		this.additinalText = additinalText;
	}

	/**
	 * @return the docRecTmstp
	 */
	public Date getDocRecTmstp() {
		return docRecTmstp;
	}

	/**
	 * @param docRecTmstp the docRecTmstp to set
	 */
	public void setDocRecTmstp(Date docRecTmstp) {
		this.docRecTmstp = docRecTmstp;
	}

	/**
	 * @return the regNbr
	 */
	public String getRegNbr() {
		return regNbr;
	}

	/**
	 * @param regNbr the regNbr to set
	 */
	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	/**
	 * @return the insuranceTaxId
	 */
	public String getInsuranceTaxId() {
		return insuranceTaxId;
	}

	/**
	 * @param insuranceTaxId the insuranceTaxId to set
	 */
	public void setInsuranceTaxId(String insuranceTaxId) {
		this.insuranceTaxId = insuranceTaxId;
	}

	/**
	 * @return the insuranceNbr
	 */
	public String getInsuranceNbr() {
		return insuranceNbr;
	}

	/**
	 * @param insuranceNbr the insuranceNbr to set
	 */
	public void setInsuranceNbr(String insuranceNbr) {
		this.insuranceNbr = insuranceNbr;
	}

	/**
	 * @return the policyNbr
	 */
	public String getPolicyNbr() {
		return policyNbr;
	}

	/**
	 * @param policyNbr the policyNbr to set
	 */
	public void setPolicyNbr(String policyNbr) {
		this.policyNbr = policyNbr;
	}

	/**
	 * @return the contractPenalties
	 */
	public String getContractPenalties() {
		return contractPenalties;
	}

	/**
	 * @param contractPenalties the contractPenalties to set
	 */
	public void setContractPenalties(String contractPenalties) {
		this.contractPenalties = contractPenalties;
	}

	/**
	 * @return the waiverTypDesc
	 */
	public String getWaiverTypDesc() {
		return waiverTypDesc;
	}

	/**
	 * @param waiverTypDesc the waiverTypDesc to set
	 */
	public void setWaiverTypDesc(String waiverTypDesc) {
		this.waiverTypDesc = waiverTypDesc;
	}

	/**
	 * @return the recValTxt
	 */
	public String getRecValTxt() {
		return recValTxt;
	}

	/**
	 * @param recValTxt the recValTxt to set
	 */
	public void setRecValTxt(String recValTxt) {
		this.recValTxt = recValTxt;
	}

	/**
	 * @return the regisBranchDesc
	 */
	public String getRegisBranchDesc() {
		return regisBranchDesc;
	}

	/**
	 * @param regisBranchDesc the regisBranchDesc to set
	 */
	public void setRegisBranchDesc(String regisBranchDesc) {
		this.regisBranchDesc = regisBranchDesc;
	}

	/**
	 * @return the errCmplmInfoCd
	 */
	public String getErrCmplmInfoCd() {
		return errCmplmInfoCd;
	}

	/**
	 * @param errCmplmInfoCd the errCmplmInfoCd to set
	 */
	public void setErrCmplmInfoCd(String errCmplmInfoCd) {
		this.errCmplmInfoCd = errCmplmInfoCd;
	}

	/**
	 * @return the errCmplmInfoDesc
	 */
	public String getErrCmplmInfoDesc() {
		return errCmplmInfoDesc;
	}

	/**
	 * @param errCmplmInfoDesc the errCmplmInfoDesc to set
	 */
	public void setErrCmplmInfoDesc(String errCmplmInfoDesc) {
		this.errCmplmInfoDesc = errCmplmInfoDesc;
	}

	/**
	 * @return the dsplExptdValNbr
	 */
	public String getDsplExptdValNbr() {
		return dsplExptdValNbr;
	}

	/**
	 * @param dsplExptdValNbr the dsplExptdValNbr to set
	 */
	public void setDsplExptdValNbr(String dsplExptdValNbr) {
		this.dsplExptdValNbr = dsplExptdValNbr;
	}

	/**
	 * @return the dsplEntrdValNbr
	 */
	public String getDsplEntrdValNbr() {
		return dsplEntrdValNbr;
	}

	/**
	 * @param dsplEntrdValNbr the dsplEntrdValNbr to set
	 */
	public void setDsplEntrdValNbr(String dsplEntrdValNbr) {
		this.dsplEntrdValNbr = dsplEntrdValNbr;
	}

	/**
	 * @return the cmplmInfoCd
	 */
	public String getCmplmInfoCd() {
		return cmplmInfoCd;
	}

	/**
	 * @param cmplmInfoCd the cmplmInfoCd to set
	 */
	public void setCmplmInfoCd(String cmplmInfoCd) {
		this.cmplmInfoCd = cmplmInfoCd;
	}

	/**
	 * @return the cmplmInfoDesc
	 */
	public String getCmplmInfoDesc() {
		return cmplmInfoDesc;
	}

	/**
	 * @param cmplmInfoDesc the cmplmInfoDesc to set
	 */
	public void setCmplmInfoDesc(String cmplmInfoDesc) {
		this.cmplmInfoDesc = cmplmInfoDesc;
	}

	/**
	 * @return the insRespTypTxt
	 */
	public String getInsRespTypTxt() {
		return insRespTypTxt;
	}

	/**
	 * @param insRespTypTxt the insRespTypTxt to set
	 */
	public void setInsRespTypTxt(String insRespTypTxt) {
		this.insRespTypTxt = insRespTypTxt;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	/**
	 * @return the nFSEKey
	 */
	public String getnFSEKey() {
		return nfseKey;
	}

	/**
	 * @param nFSEKey the nFSEKey to set
	 */
	public void setnFSEKey(String nfseKey) {
		this.nfseKey = nfseKey;
	}

	/**
	 * @return the cTeKey
	 */
	public String getcteKey() {
		return cteKey;
	}

	/**
	 * @param cTeKey the cTeKey to set
	 */
	public void setcTeKey(String cteKey) {
		this.cteKey = cteKey;
	}

	/**
	 * @return the statusCd
	 */
	public String getStatusCd() {
		return statusCd;
	}

	/**
	 * @param statusCd the statusCd to set
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	/**
	 * @return the payerTaxId
	 */
	public String getPayerTaxId() {
		return payerTaxId;
	}

	/**
	 * @param payerTaxId the payerTaxId to set
	 */
	public void setPayerTaxId(String payerTaxId) {
		this.payerTaxId = payerTaxId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InsuranceResponseMaster [isqnCd=" + isqnCd + ", protocolNbr=" + protocolNbr + ", docNbr=" + docNbr
				+ ", docSresTxt=" + docSresTxt + ", docIsBranchTxt=" + docIsBranchTxt + ", custTaxId=" + custTaxId
				+ ", docTypeId=" + docTypeId + ", additinalText=" + additinalText + ", docRecTmstp=" + docRecTmstp
				+ ", regNbr=" + regNbr + ", insuranceTaxId=" + insuranceTaxId + ", insuranceNbr=" + insuranceNbr
				+ ", policyNbr=" + policyNbr + ", contractPenalties=" + contractPenalties + ", waiverTypDesc="
				+ waiverTypDesc + ", recValTxt=" + recValTxt + ", regisBranchDesc=" + regisBranchDesc
				+ ", errCmplmInfoCd=" + errCmplmInfoCd + ", errCmplmInfoDesc=" + errCmplmInfoDesc + ", dsplExptdValNbr="
				+ dsplExptdValNbr + ", dsplEntrdValNbr=" + dsplEntrdValNbr + ", cmplmInfoCd=" + cmplmInfoCd
				+ ", cmplmInfoDesc=" + cmplmInfoDesc + ", insRespTypTxt=" + insRespTypTxt + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", nFSEKey=" + nfseKey + ", cTeKey=" + cteKey + ", statusCd="
				+ statusCd + "]";
	}

	
}
