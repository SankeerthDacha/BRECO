package com.fedex.breco.insurance.dto;

public class CustomerDetails {

	/*
	 * ISQN_CD NOT NULL NUMBER
	 * ITEM_NBR NOT NULL NUMBER(38)
	 * FT_NM_TXT VARCHAR2(128)
	 * CO_NM_TXT VARCHAR2(256) 
	 * TAX_ID VARCHAR2(128) 
	 * VLD_DT DATE
	 * CA_LY_RD_FGT_FRWDR_DESC VARCHAR2(128) 
	 * CA_LY_CG_THFT_DISP_DESC VARCHAR2(128)
	 * AR_CRGO_CARR_LY_INS_DESC VARCHAR2(128) 
	 * INTL_RD_LY_INS_DESC VARCHAR2(128)
	 * INS_CO_NM VARCHAR2(64) 
	 * LOSS_RESN_TXT VARCHAR2(64) 
	 * BRK_DWN_RESN_TXT VARCHAR2(64) 
	 * CTRC_PNLTY_DESC VARCHAR2(1024)
	 */
	
	
	String isqnCD = new String();
	String ftNmTxt = new String();
	String CoNmTxt = new String();
	String taxID = new String();
	String VldDt = new String();
	String caLyRdFgtFrwdrDesc = new String();
	String caLyCgThftDispDesc = new String();
	String ArCrgoCarrLyInsDesc = new String();
	String IntlRdLyInsDesc = new String();
	String InsuranceCompName = new String();
	String LossResnTxt = new String();
	String BreakdownResnTxt = new String();
	String CtrcPnltyDesc = new String();
	int statusCode;
	String message = new String();
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the isqnCD
	 */
	public String getIsqnCD() {
		return isqnCD;
	}
	/**
	 * @param isqnCD the isqnCD to set
	 */
	public void setIsqnCD(String isqnCD) {
		this.isqnCD = isqnCD;
	}
	/**
	 * @return the ftNmTxt
	 */
	public String getFtNmTxt() {
		return ftNmTxt;
	}
	/**
	 * @param ftNmTxt the ftNmTxt to set
	 */
	public void setFtNmTxt(String ftNmTxt) {
		this.ftNmTxt = ftNmTxt;
	}
	/**
	 * @return the coNmTxt
	 */
	public String getCoNmTxt() {
		return CoNmTxt;
	}
	/**
	 * @param coNmTxt the coNmTxt to set
	 */
	public void setCoNmTxt(String coNmTxt) {
		CoNmTxt = coNmTxt;
	}
	/**
	 * @return the taxID
	 */
	public String getTaxID() {
		return taxID;
	}
	/**
	 * @param taxID the taxID to set
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	/**
	 * @return the vldDt
	 */
	public String getVldDt() {
		return VldDt;
	}
	/**
	 * @param vldDt the vldDt to set
	 */
	public void setVldDt(String vldDt) {
		VldDt = vldDt;
	}
	/**
	 * @return the caLyRdFgtFrwdrDesc
	 */
	public String getCaLyRdFgtFrwdrDesc() {
		return caLyRdFgtFrwdrDesc;
	}
	/**
	 * @param caLyRdFgtFrwdrDesc the caLyRdFgtFrwdrDesc to set
	 */
	public void setCaLyRdFgtFrwdrDesc(String caLyRdFgtFrwdrDesc) {
		this.caLyRdFgtFrwdrDesc = caLyRdFgtFrwdrDesc;
	}
	/**
	 * @return the caLyCgThftDispDesc
	 */
	public String getCaLyCgThftDispDesc() {
		return caLyCgThftDispDesc;
	}
	/**
	 * @param caLyCgThftDispDesc the caLyCgThftDispDesc to set
	 */
	public void setCaLyCgThftDispDesc(String caLyCgThftDispDesc) {
		this.caLyCgThftDispDesc = caLyCgThftDispDesc;
	}
	/**
	 * @return the arCrgoCarrLyInsDesc
	 */
	public String getArCrgoCarrLyInsDesc() {
		return ArCrgoCarrLyInsDesc;
	}
	/**
	 * @param arCrgoCarrLyInsDesc the arCrgoCarrLyInsDesc to set
	 */
	public void setArCrgoCarrLyInsDesc(String arCrgoCarrLyInsDesc) {
		ArCrgoCarrLyInsDesc = arCrgoCarrLyInsDesc;
	}
	/**
	 * @return the intlRdLyInsDesc
	 */
	public String getIntlRdLyInsDesc() {
		return IntlRdLyInsDesc;
	}
	/**
	 * @param intlRdLyInsDesc the intlRdLyInsDesc to set
	 */
	public void setIntlRdLyInsDesc(String intlRdLyInsDesc) {
		IntlRdLyInsDesc = intlRdLyInsDesc;
	}
	/**
	 * @return the insuranceCompName
	 */
	public String getInsuranceCompName() {
		return InsuranceCompName;
	}
	/**
	 * @param insuranceCompName the insuranceCompName to set
	 */
	public void setInsuranceCompName(String insuranceCompName) {
		InsuranceCompName = insuranceCompName;
	}
	/**
	 * @return the lossResnTxt
	 */
	public String getLossResnTxt() {
		return LossResnTxt;
	}
	/**
	 * @param lossResnTxt the lossResnTxt to set
	 */
	public void setLossResnTxt(String lossResnTxt) {
		LossResnTxt = lossResnTxt;
	}
	/**
	 * @return the breakdownResnTxt
	 */
	public String getBreakdownResnTxt() {
		return BreakdownResnTxt;
	}
	/**
	 * @param breakdownResnTxt the breakdownResnTxt to set
	 */
	public void setBreakdownResnTxt(String breakdownResnTxt) {
		BreakdownResnTxt = breakdownResnTxt;
	}
	/**
	 * @return the ctrcPnltyDesc
	 */
	public String getCtrcPnltyDesc() {
		return CtrcPnltyDesc;
	}
	/**
	 * @param ctrcPnltyDesc the ctrcPnltyDesc to set
	 */
	public void setCtrcPnltyDesc(String ctrcPnltyDesc) {
		CtrcPnltyDesc = ctrcPnltyDesc;
	}
	
	
	
}
