package com.fedex.breco.insurance.dto;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
	
	
		private long isqnCD;
		private String ftNmTxt = new String();
		private String CoNmTxt = new String();
		private String taxID = new String();
		private String VldDt = new String();
		private String caLyRdFgtFrwdrDesc = new String();
		private String caLyCgThftDispDesc = new String();
		private String ArCrgoCarrLyInsDesc = new String();
		private String InsuranceCompName = new String();
	    
		/**
		 * @return the isqnCD
		 */
		public long getIsqnCD() {
			return isqnCD;
		}
		/**
		 * @param isqnCD the isqnCD to set
		 */
		public void setIsqnCD(long isqnCD) {
			this.isqnCD = isqnCD;
		}
		/**
		 * @return the ftNmTxt
		 */
		public String getFtNmTxt() {
			return ftNmTxt;
		}
		/**
		 * @return the coNmTxt
		 */
		public String getCoNmTxt() {
			return CoNmTxt;
		}
		/**
		 * @return the taxID
		 */
		public String getTaxID() {
			return taxID;
		}
		/**
		 * @return the vldDt
		 */
		public String getVldDt() {
			return VldDt;
		}
		/**
		 * @return the caLyRdFgtFrwdrDesc
		 */
		public String getCaLyRdFgtFrwdrDesc() {
			return caLyRdFgtFrwdrDesc;
		}
		/**
		 * @return the caLyCgThftDispDesc
		 */
		public String getCaLyCgThftDispDesc() {
			return caLyCgThftDispDesc;
		}
		/**
		 * @return the arCrgoCarrLyInsDesc
		 */
		public String getArCrgoCarrLyInsDesc() {
			return ArCrgoCarrLyInsDesc;
		}
		/**
		 * @return the insuranceCompName
		 */
		public String getInsuranceCompName() {
			return InsuranceCompName;
		}
		/**
		 * @param ftNmTxt the ftNmTxt to set
		 */
		public void setFtNmTxt(String ftNmTxt) {
			this.ftNmTxt = ftNmTxt;
		}
		/**
		 * @param coNmTxt the coNmTxt to set
		 */
		public void setCoNmTxt(String coNmTxt) {
			CoNmTxt = coNmTxt;
		}
		/**
		 * @param taxID the taxID to set
		 */
		public void setTaxID(String taxID) {
			this.taxID = taxID;
		}
		/**
		 * @param vldDt the vldDt to set
		 */
		public void setVldDt(String vldDt) {
			VldDt = vldDt;
		}
		/**
		 * @param caLyRdFgtFrwdrDesc the caLyRdFgtFrwdrDesc to set
		 */
		public void setCaLyRdFgtFrwdrDesc(String caLyRdFgtFrwdrDesc) {
			this.caLyRdFgtFrwdrDesc = caLyRdFgtFrwdrDesc;
		}
		/**
		 * @param caLyCgThftDispDesc the caLyCgThftDispDesc to set
		 */
		public void setCaLyCgThftDispDesc(String caLyCgThftDispDesc) {
			this.caLyCgThftDispDesc = caLyCgThftDispDesc;
		}
		/**
		 * @param arCrgoCarrLyInsDesc the arCrgoCarrLyInsDesc to set
		 */
		public void setArCrgoCarrLyInsDesc(String arCrgoCarrLyInsDesc) {
			ArCrgoCarrLyInsDesc = arCrgoCarrLyInsDesc;
		}
		/**
		 * @param insuranceCompName the insuranceCompName to set
		 */
		public void setInsuranceCompName(String insuranceCompName) {
			InsuranceCompName = insuranceCompName;
		}
		
}
