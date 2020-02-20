package com.fedex.breco.insurance.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class InsuranceResponseInfo implements Serializable {

   	/**
	 * serialVersionUID
	*/
	private static final long serialVersionUID = 1L;
	private long isqnId;
	private String protoNbr;
	private String docNbr;
	private String docSersTxt;
	private String docIsBranchTxt;
	private String custTaxId;
	private String docTypId;
	private String addlInfoTxt;
	private Date docRecTmstp;
	private String regisNbr;
	private String insTaxId;
	private String insNm;
	private String plcyNbr;
	private String movmtTypAnotnTxt;
	private String waivrTypDesc;
	private String recValTxt;
	private String regisBranchDesc;
	private String errCmplmInfoCd;
	private String errCmplmInfoDesc;
	private String dsplExptdValNbr;
	private String dsplEntrdValNbr;
	private String cmplmInfoCd;
	private String cmplmInfoDesc;
	private String insRespTypTxt;
	private Date createDt;
	private Date modfyDt;
	
	/**
	 * @return the isqnId
	 */
	public long getIsqnId() {
		return isqnId;
	}
	/**
	 * @param isqnId the isqnId to set
	 */
	public void setIsqnId(long isqnId) {
		this.isqnId = isqnId;
	}
	/**
	 * @return the protoNbr
	 */
	public String getProtoNbr() {
		return protoNbr;
	}
	/**
	 * @param protoNbr the protoNbr to set
	 */
	public void setProtoNbr(String protoNbr) {
		this.protoNbr = protoNbr;
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
	 * @return the docSersTxt
	 */
	public String getDocSersTxt() {
		return docSersTxt;
	}
	/**
	 * @param docSersTxt the docSersTxt to set
	 */
	public void setDocSersTxt(String docSersTxt) {
		this.docSersTxt = docSersTxt;
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
	 * @return the docTypId
	 */
	public String getDocTypId() {
		return docTypId;
	}
	/**
	 * @param docTypId the docTypId to set
	 */
	public void setDocTypId(String docTypId) {
		this.docTypId = docTypId;
	}
	/**
	 * @return the addlInfoTxt
	 */
	public String getAddlInfoTxt() {
		return addlInfoTxt;
	}
	/**
	 * @param addlInfoTxt the addlInfoTxt to set
	 */
	public void setAddlInfoTxt(String addlInfoTxt) {
		this.addlInfoTxt = addlInfoTxt;
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
	 * @return the regisNbr
	 */
	public String getRegisNbr() {
		return regisNbr;
	}
	/**
	 * @param regisNbr the regisNbr to set
	 */
	public void setRegisNbr(String regisNbr) {
		this.regisNbr = regisNbr;
	}
	/**
	 * @return the insTaxId
	 */
	public String getInsTaxId() {
		return insTaxId;
	}
	/**
	 * @param insTaxId the insTaxId to set
	 */
	public void setInsTaxId(String insTaxId) {
		this.insTaxId = insTaxId;
	}
	/**
	 * @return the insNm
	 */
	public String getInsNm() {
		return insNm;
	}
	/**
	 * @param insNm the insNm to set
	 */
	public void setInsNm(String insNm) {
		this.insNm = insNm;
	}
	/**
	 * @return the plcyNbr
	 */
	public String getPlcyNbr() {
		return plcyNbr;
	}
	/**
	 * @param plcyNbr the plcyNbr to set
	 */
	public void setPlcyNbr(String plcyNbr) {
		this.plcyNbr = plcyNbr;
	}
	/**
	 * @return the movmtTypAnotnTxt
	 */
	public String getMovmtTypAnotnTxt() {
		return movmtTypAnotnTxt;
	}
	/**
	 * @param movmtTypAnotnTxt the movmtTypAnotnTxt to set
	 */
	public void setMovmtTypAnotnTxt(String movmtTypAnotnTxt) {
		this.movmtTypAnotnTxt = movmtTypAnotnTxt;
	}
	/**
	 * @return the waivrTypDesc
	 */
	public String getWaivrTypDesc() {
		return waivrTypDesc;
	}
	/**
	 * @param waivrTypDesc the waivrTypDesc to set
	 */
	public void setWaivrTypDesc(String waivrTypDesc) {
		this.waivrTypDesc = waivrTypDesc;
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
	 * @return the createDt
	 */
	public Date getCreateDt() {
		return createDt;
	}
	/**
	 * @param createDt the createDt to set
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	/**
	 * @return the modfyDt
	 */
	public Date getModfyDt() {
		return modfyDt;
	}
	/**
	 * @param modfyDt the modfyDt to set
	 */
	public void setModfyDt(Date modfyDt) {
		this.modfyDt = modfyDt;
	}
	
	
}
