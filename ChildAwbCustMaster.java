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
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AwbCustMaster.
 */
@Entity
@Table(name = "AWB_CUST_MASTER_C")
public class ChildAwbCustMaster implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The awb master id. */
	@Id
//	@GenericGenerator(name = "AWB_MSTR_SEQ", strategy = "sequence", parameters = {
//	        @org.hibernate.annotations.Parameter(name = "AWB_MSTR_SEQ", value = "AWB_MSTR_SEQ"),
//	})
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AWB_MSTR_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISQN_MSTR_CD", columnDefinition = "")
	private Long isqnMstrCd;

	/** The awb shpmt details. */
	// @OneToMany(mappedBy = "AwbCustMaster", cascade = CascadeType.ALL)
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "childAwbCustMaster")
	private ChildAwbShpmtDetails childAwbShpmtDetails;

	/** The shpr acct nbr. */
	@Column(name = "SHPR_ACCT_NBR", columnDefinition = "")
	private String shipperAccountNbr;

	/** The awb nbr. */
	@Column(name = "AWB_NBR", columnDefinition = "")
	private String awbNbr;

	/** The master awb nbr. */
	@Column(name = "MSTR_AWB_NBR", columnDefinition = "")
	private String masterAwbNbr;

	/** The create dt. */
	@Column(name = "CREATE_DT", columnDefinition = "")
	private Date createDt;

	/** The modfy dt. */
	@Column(name = "MODFY_DT", columnDefinition = "")
	private Date modfyDt;

	/** The cust rqstr nm. */
	@Column(name = "CUST_RQSTR_NM", columnDefinition = "")
	private String custRqstrNm;

	/** The cust type cd. */
	@Column(name = "CUST_TYPE_CD", columnDefinition = "")
	private String custTypeCd;

	/** The cust email id. */
	@Column(name = "CUST_EMAIL_ID", columnDefinition = "")
	private String custEmailId;

	/** The cust lang pref cd. */
	@Column(name = "CUST_LANG_PREF_CD", columnDefinition = "")
	private String custLangPrefCd;

	/** The cust notif type cd. */
	@Column(name = "CUST_NOTIF_TYPE_CD", columnDefinition = "")
	private Integer custNotifTypeCd;

	/** The cust rqstr comp nm. */
	@Column(name = "CUST_RQSTR_COMP_NM", columnDefinition = "")
	private String custRequesterCompNm;

	/** The cust rqstr email id. */
	@Column(name = "CUST_RQSTR_EMAIL_ID", columnDefinition = "")
	private String custRequesterEmailId;

	/** The recp nm. */
	@Column(name = "RECP_NM", columnDefinition = "")
	private String recipientNm;

	/** The recp ph nbr. */
	@Column(name = "RECP_PH_NBR", columnDefinition = "")
	private String recipientPhNbr;

	/** The recp emal addr txt. */
	@Column(name = "RECP_EMAL_ADDR_TXT", columnDefinition = "")
	private String recipientEmalAddrTxt;

	/** The recp comp nm. */
	@Column(name = "RECP_COMP_NM", columnDefinition = "")
	private String recipientCompNm;

	/** The recp city nm txt. */
	@Column(name = "RECP_CITY_NM_TXT", columnDefinition = "")
	private String recipientCityNmTxt;

	/** The recp state cd. */
	@Column(name = "RECP_STATE_CD", columnDefinition = "")
	private String recipientStateCd;

	/** The recp country cd. */
	@Column(name = "RECP_COUNTRY_CD", columnDefinition = "")
	private String recipientCountryCd;

	/** The recipient pstl cd. */
	@Column(name = "RECP_PSTL_CD", columnDefinition = "")
	private String recipientPstlCd;

	/** The recp tax id nbr. */
	@Column(name = "RECP_TAX_ID_NBR", columnDefinition = "")
	private String recipientTaxIdNbr;

	/** The recp addr desc. */
	@Column(name = "RECP_ADDR_DESC", columnDefinition = "")
	private String recipientAddrDesc;

	/** The recp addl addr desc. */
	@Column(name = "RECP_ADDL_ADDR_DESC", columnDefinition = "")
	private String recipientAddlAddrDesc;

	/** The recp addr line 1 desc. */
	@Column(name = "RECP_ADDR_LINE_1_DESC", columnDefinition = "")
	private String recipientAddrLine1Desc;

	/** The recp addr line 2 desc. */
	@Column(name = "RECP_ADDR_LINE_2_DESC", columnDefinition = "")
	private String recipientAddrLine2Desc;

	/** The recp addr line 1 nbr. */
	@Column(name = "RECP_ADDR_LINE_1_NBR", columnDefinition = "")
	private Integer recipientAddrLine1Nbr;

	/** The recp addr line 2 nbr. */
	@Column(name = "RECP_ADDR_LINE_2_NBR", columnDefinition = "")
	private Integer recipientAddrLine2Nbr;

	/** The rqstr acct nbr. */
	@Column(name = "RQSTR_ACCT_NBR", columnDefinition = "")
	private Long requesterAcctNbr;

	/** The shpr addr desc. */
	@Column(name = "SHPR_ADDR_DESC", columnDefinition = "")
	private String shipperAddrDesc;

	/** The shpr addl addr desc. */
	@Column(name = "SHPR_ADDL_ADDR_DESC", columnDefinition = "")
	private String shipperAddlAddrDesc;

	/** The shpr addr line 1 desc. */
	@Column(name = "SHPR_ADDR_LINE_1_DESC", columnDefinition = "")
	private String shipperAddrLine1Desc;

	/** The shpr addr line 2 desc. */
	@Column(name = "SHPR_ADDR_LINE_2_DESC", columnDefinition = "")
	private String shipperAddrLine2Desc;

	/** The shpr addr line 1 nbr. */
	@Column(name = "SHPR_ADDR_LINE_1_NBR", columnDefinition = "")
	private Integer shipperAddrLine1Nbr;

	/** The shpr addr line 2 nbr. */
	@Column(name = "SHPR_ADDR_LINE_2_NBR", columnDefinition = "")
	private Integer shipperAddrLine2Nbr;

	/** The shpr city nm. */
	@Column(name = "SHPR_CITY_NM", columnDefinition = "")
	private String shipperCityNm;

	/** The shpr comp nm. */
	@Column(name = "SHPR_COMP_NM", columnDefinition = "")
	private String shipperCompNm;

	/** The shpr country cd. */
	@Column(name = "SHPR_COUNTRY_CD", columnDefinition = "")
	private String shipperCountryCd;

	/** The shpr emal addr txt. */
	@Column(name = "SHPR_EMAL_ADDR_TXT", columnDefinition = "")
	private String shipperEmailAddrTxt;

	/** The shpr nm. */
	@Column(name = "SHPR_NM", columnDefinition = "")
	private String shipperNm;

	/** The shpr ph nbr. */
	@Column(name = "SHPR_PH_NBR", columnDefinition = "")
	private String shipperPhNbr;

	/** The shpr pstl cd. */
	@Column(name = "SHPR_PSTL_CD", columnDefinition = "")
	private String shipperPstlCd;

	/** The shpr ref note txt. */
	@Column(name = "SHPR_REF_NOTE_TXT", columnDefinition = "")
	private Integer shipperRefNoteTxt;

	/** The shpr state cd. */
	@Column(name = "SHPR_STATE_CD", columnDefinition = "")
	private String shipperStateCd;

	/** The shpr tax id nbr. */
	@Column(name = "SHPR_TAX_ID_NBR", columnDefinition = "")
	private String shipperTaxIdNbr;

	/**
	 * Gets the isqn mstr cd.
	 *
	 * @return the isqn mstr cd
	 */
	public Long getIsqnMstrCd() {
		return isqnMstrCd;
	}

	/**
	 * Sets the isqn mstr cd.
	 *
	 * @param isqnMstrCd the new isqn mstr cd
	 */
	public void setIsqnMstrCd(Long isqnMstrCd) {
		this.isqnMstrCd = isqnMstrCd;
	}

	/**
	 * Gets the shipper account nbr.
	 *
	 * @return the shipper account nbr
	 */
	public String getShipperAccountNbr() {
		return shipperAccountNbr;
	}

	/**
	 * Sets the shipper account nbr.
	 *
	 * @param shipperAccountNbr the new shipper account nbr
	 */
	public void setShipperAccountNbr(String shipperAccountNbr) {
		this.shipperAccountNbr = shipperAccountNbr;
	}

	/**
	 * Gets the awb nbr.
	 *
	 * @return the awb nbr
	 */
	public String getAwbNbr() {
		return awbNbr;
	}

	/**
	 * Sets the awb nbr.
	 *
	 * @param awbNbr the new awb nbr
	 */
	public void setAwbNbr(String awbNbr) {
		this.awbNbr = awbNbr;
	}

	/**
	 * Gets the creates the dt.
	 *
	 * @return the creates the dt
	 */
	public Date getCreateDt() {
		return createDt;
	}

	/**
	 * Sets the creates the dt.
	 *
	 * @param createDt the new creates the dt
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	/**
	 * Gets the modfy dt.
	 *
	 * @return the modfy dt
	 */
	public Date getModfyDt() {
		return modfyDt;
	}

	/**
	 * Sets the modfy dt.
	 *
	 * @param modfyDt the new modfy dt
	 */
	public void setModfyDt(Date modfyDt) {
		this.modfyDt = modfyDt;
	}

	/**
	 * Gets the cust rqstr nm.
	 *
	 * @return the cust rqstr nm
	 */
	public String getCustRqstrNm() {
		return custRqstrNm;
	}

	/**
	 * Sets the cust rqstr nm.
	 *
	 * @param custRqstrNm the new cust rqstr nm
	 */
	public void setCustRqstrNm(String custRqstrNm) {
		this.custRqstrNm = custRqstrNm;
	}

	/**
	 * Gets the cust type cd.
	 *
	 * @return the cust type cd
	 */
	public String getCustTypeCd() {
		return custTypeCd;
	}

	/**
	 * Sets the cust type cd.
	 *
	 * @param custTypeCd the new cust type cd
	 */
	public void setCustTypeCd(String custTypeCd) {
		this.custTypeCd = custTypeCd;
	}

	/**
	 * Gets the cust email id.
	 *
	 * @return the cust email id
	 */
	public String getCustEmailId() {
		return custEmailId;
	}

	/**
	 * Sets the cust email id.
	 *
	 * @param custEmailId the new cust email id
	 */
	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	/**
	 * Gets the cust lang pref cd.
	 *
	 * @return the cust lang pref cd
	 */
	public String getCustLangPrefCd() {
		return custLangPrefCd;
	}

	/**
	 * Sets the cust lang pref cd.
	 *
	 * @param custLangPrefCd the new cust lang pref cd
	 */
	public void setCustLangPrefCd(String custLangPrefCd) {
		this.custLangPrefCd = custLangPrefCd;
	}

	/**
	 * Gets the cust notif type cd.
	 *
	 * @return the cust notif type cd
	 */
	public Integer getCustNotifTypeCd() {
		return custNotifTypeCd;
	}

	/**
	 * Sets the cust notif type cd.
	 *
	 * @param custNotifTypeCd the new cust notif type cd
	 */
	public void setCustNotifTypeCd(Integer custNotifTypeCd) {
		this.custNotifTypeCd = custNotifTypeCd;
	}

	/**
	 * Gets the cust requester comp nm.
	 *
	 * @return the cust requester comp nm
	 */
	public String getCustRequesterCompNm() {
		return custRequesterCompNm;
	}

	/**
	 * Sets the cust requester comp nm.
	 *
	 * @param custRequesterCompNm the new cust requester comp nm
	 */
	public void setCustRequesterCompNm(String custRequesterCompNm) {
		this.custRequesterCompNm = custRequesterCompNm;
	}

	/**
	 * Gets the cust requester email id.
	 *
	 * @return the cust requester email id
	 */
	public String getCustRequesterEmailId() {
		return custRequesterEmailId;
	}

	/**
	 * Sets the cust requester email id.
	 *
	 * @param custRequesterEmailId the new cust requester email id
	 */
	public void setCustRequesterEmailId(String custRequesterEmailId) {
		this.custRequesterEmailId = custRequesterEmailId;
	}

	/**
	 * Gets the recipient nm.
	 *
	 * @return the recipient nm
	 */
	public String getRecipientNm() {
		return recipientNm;
	}

	/**
	 * Sets the recipient nm.
	 *
	 * @param recipientNm the new recipient nm
	 */
	public void setRecipientNm(String recipientNm) {
		this.recipientNm = recipientNm;
	}

	/**
	 * Gets the recipient ph nbr.
	 *
	 * @return the recipient ph nbr
	 */
	public String getRecipientPhNbr() {
		return recipientPhNbr;
	}

	/**
	 * Sets the recipient ph nbr.
	 *
	 * @param recipientPhNbr the new recipient ph nbr
	 */
	public void setRecipientPhNbr(String recipientPhNbr) {
		this.recipientPhNbr = recipientPhNbr;
	}

	/**
	 * Gets the recipient emal addr txt.
	 *
	 * @return the recipient emal addr txt
	 */
	public String getRecipientEmalAddrTxt() {
		return recipientEmalAddrTxt;
	}

	/**
	 * Sets the recipient emal addr txt.
	 *
	 * @param recipientEmalAddrTxt the new recipient emal addr txt
	 */
	public void setRecipientEmalAddrTxt(String recipientEmalAddrTxt) {
		this.recipientEmalAddrTxt = recipientEmalAddrTxt;
	}

	/**
	 * Gets the recipient comp nm.
	 *
	 * @return the recipient comp nm
	 */
	public String getRecipientCompNm() {
		return recipientCompNm;
	}

	/**
	 * Sets the recipient comp nm.
	 *
	 * @param recipientCompNm the new recipient comp nm
	 */
	public void setRecipientCompNm(String recipientCompNm) {
		this.recipientCompNm = recipientCompNm;
	}

	/**
	 * Gets the recipient city nm txt.
	 *
	 * @return the recipient city nm txt
	 */
	public String getRecipientCityNmTxt() {
		return recipientCityNmTxt;
	}

	/**
	 * Sets the recipient city nm txt.
	 *
	 * @param recipientCityNmTxt the new recipient city nm txt
	 */
	public void setRecipientCityNmTxt(String recipientCityNmTxt) {
		this.recipientCityNmTxt = recipientCityNmTxt;
	}

	/**
	 * Gets the recipient state cd.
	 *
	 * @return the recipient state cd
	 */
	public String getRecipientStateCd() {
		return recipientStateCd;
	}

	/**
	 * Sets the recipient state cd.
	 *
	 * @param recipientStateCd the new recipient state cd
	 */
	public void setRecipientStateCd(String recipientStateCd) {
		this.recipientStateCd = recipientStateCd;
	}

	/**
	 * Gets the recipient country cd.
	 *
	 * @return the recipient country cd
	 */
	public String getRecipientCountryCd() {
		return recipientCountryCd;
	}

	/**
	 * Sets the recipient country cd.
	 *
	 * @param recipientCountryCd the new recipient country cd
	 */
	public void setRecipientCountryCd(String recipientCountryCd) {
		this.recipientCountryCd = recipientCountryCd;
	}

	/**
	 * Gets the recipient tax id nbr.
	 *
	 * @return the recipient tax id nbr
	 */
	public String getRecipientTaxIdNbr() {
		return recipientTaxIdNbr;
	}

	/**
	 * Sets the recipient tax id nbr.
	 *
	 * @param recipientTaxIdNbr the new recipient tax id nbr
	 */
	public void setRecipientTaxIdNbr(String recipientTaxIdNbr) {
		this.recipientTaxIdNbr = recipientTaxIdNbr;
	}

	/**
	 * Gets the recipient addr desc.
	 *
	 * @return the recipient addr desc
	 */
	public String getRecipientAddrDesc() {
		return recipientAddrDesc;
	}

	/**
	 * Sets the recipient addr desc.
	 *
	 * @param recipientAddrDesc the new recipient addr desc
	 */
	public void setRecipientAddrDesc(String recipientAddrDesc) {
		this.recipientAddrDesc = recipientAddrDesc;
	}

	/**
	 * Gets the recipient addl addr desc.
	 *
	 * @return the recipient addl addr desc
	 */
	public String getRecipientAddlAddrDesc() {
		return recipientAddlAddrDesc;
	}

	/**
	 * Sets the recipient addl addr desc.
	 *
	 * @param recipientAddlAddrDesc the new recipient addl addr desc
	 */
	public void setRecipientAddlAddrDesc(String recipientAddlAddrDesc) {
		this.recipientAddlAddrDesc = recipientAddlAddrDesc;
	}

	/**
	 * Gets the recipient addr line 1 desc.
	 *
	 * @return the recipient addr line 1 desc
	 */
	public String getRecipientAddrLine1Desc() {
		return recipientAddrLine1Desc;
	}

	/**
	 * Sets the recipient addr line 1 desc.
	 *
	 * @param recipientAddrLine1Desc the new recipient addr line 1 desc
	 */
	public void setRecipientAddrLine1Desc(String recipientAddrLine1Desc) {
		this.recipientAddrLine1Desc = recipientAddrLine1Desc;
	}

	/**
	 * Gets the recipient addr line 2 desc.
	 *
	 * @return the recipient addr line 2 desc
	 */
	public String getRecipientAddrLine2Desc() {
		return recipientAddrLine2Desc;
	}

	/**
	 * Sets the recipient addr line 2 desc.
	 *
	 * @param recipientAddrLine2Desc the new recipient addr line 2 desc
	 */
	public void setRecipientAddrLine2Desc(String recipientAddrLine2Desc) {
		this.recipientAddrLine2Desc = recipientAddrLine2Desc;
	}

	/**
	 * Gets the recipient addr line 1 nbr.
	 *
	 * @return the recipient addr line 1 nbr
	 */
	public Integer getRecipientAddrLine1Nbr() {
		return recipientAddrLine1Nbr;
	}

	/**
	 * Sets the recipient addr line 1 nbr.
	 *
	 * @param recipientAddrLine1Nbr the new recipient addr line 1 nbr
	 */
	public void setRecipientAddrLine1Nbr(Integer recipientAddrLine1Nbr) {
		this.recipientAddrLine1Nbr = recipientAddrLine1Nbr;
	}

	/**
	 * Gets the recipient addr line 2 nbr.
	 *
	 * @return the recipient addr line 2 nbr
	 */
	public Integer getRecipientAddrLine2Nbr() {
		return recipientAddrLine2Nbr;
	}

	/**
	 * Sets the recipient addr line 2 nbr.
	 *
	 * @param recipientAddrLine2Nbr the new recipient addr line 2 nbr
	 */
	public void setRecipientAddrLine2Nbr(Integer recipientAddrLine2Nbr) {
		this.recipientAddrLine2Nbr = recipientAddrLine2Nbr;
	}

	/**
	 * Gets the requester acct nbr.
	 *
	 * @return the requester acct nbr
	 */
	public Long getRequesterAcctNbr() {
		return requesterAcctNbr;
	}

	/**
	 * Sets the requester acct nbr.
	 *
	 * @param requesterAcctNbr the new requester acct nbr
	 */
	public void setRequesterAcctNbr(Long requesterAcctNbr) {
		this.requesterAcctNbr = requesterAcctNbr;
	}

	/**
	 * Gets the shipper addr desc.
	 *
	 * @return the shipper addr desc
	 */
	public String getShipperAddrDesc() {
		return shipperAddrDesc;
	}

	/**
	 * Sets the shipper addr desc.
	 *
	 * @param shipperAddrDesc the new shipper addr desc
	 */
	public void setShipperAddrDesc(String shipperAddrDesc) {
		this.shipperAddrDesc = shipperAddrDesc;
	}

	/**
	 * Gets the shipper addl addr desc.
	 *
	 * @return the shipper addl addr desc
	 */
	public String getShipperAddlAddrDesc() {
		return shipperAddlAddrDesc;
	}

	/**
	 * Sets the shipper addl addr desc.
	 *
	 * @param shipperAddlAddrDesc the new shipper addl addr desc
	 */
	public void setShipperAddlAddrDesc(String shipperAddlAddrDesc) {
		this.shipperAddlAddrDesc = shipperAddlAddrDesc;
	}

	/**
	 * Gets the shipper addr line 1 desc.
	 *
	 * @return the shipper addr line 1 desc
	 */
	public String getShipperAddrLine1Desc() {
		return shipperAddrLine1Desc;
	}

	/**
	 * Sets the shipper addr line 1 desc.
	 *
	 * @param shipperAddrLine1Desc the new shipper addr line 1 desc
	 */
	public void setShipperAddrLine1Desc(String shipperAddrLine1Desc) {
		this.shipperAddrLine1Desc = shipperAddrLine1Desc;
	}

	/**
	 * Gets the shipper addr line 2 desc.
	 *
	 * @return the shipper addr line 2 desc
	 */
	public String getShipperAddrLine2Desc() {
		return shipperAddrLine2Desc;
	}

	/**
	 * Sets the shipper addr line 2 desc.
	 *
	 * @param shipperAddrLine2Desc the new shipper addr line 2 desc
	 */
	public void setShipperAddrLine2Desc(String shipperAddrLine2Desc) {
		this.shipperAddrLine2Desc = shipperAddrLine2Desc;
	}

	/**
	 * Gets the shipper addr line 1 nbr.
	 *
	 * @return the shipper addr line 1 nbr
	 */
	public Integer getShipperAddrLine1Nbr() {
		return shipperAddrLine1Nbr;
	}

	/**
	 * Sets the shipper addr line 1 nbr.
	 *
	 * @param shipperAddrLine1Nbr the new shipper addr line 1 nbr
	 */
	public void setShipperAddrLine1Nbr(Integer shipperAddrLine1Nbr) {
		this.shipperAddrLine1Nbr = shipperAddrLine1Nbr;
	}

	/**
	 * Gets the shipper addr line 2 nbr.
	 *
	 * @return the shipper addr line 2 nbr
	 */
	public Integer getShipperAddrLine2Nbr() {
		return shipperAddrLine2Nbr;
	}

	/**
	 * Sets the shipper addr line 2 nbr.
	 *
	 * @param shipperAddrLine2Nbr the new shipper addr line 2 nbr
	 */
	public void setShipperAddrLine2Nbr(Integer shipperAddrLine2Nbr) {
		this.shipperAddrLine2Nbr = shipperAddrLine2Nbr;
	}

	/**
	 * Gets the shipper city nm.
	 *
	 * @return the shipper city nm
	 */
	public String getShipperCityNm() {
		return shipperCityNm;
	}

	/**
	 * Sets the shipper city nm.
	 *
	 * @param shipperCityNm the new shipper city nm
	 */
	public void setShipperCityNm(String shipperCityNm) {
		this.shipperCityNm = shipperCityNm;
	}

	/**
	 * Gets the shipper comp nm.
	 *
	 * @return the shipper comp nm
	 */
	public String getShipperCompNm() {
		return shipperCompNm;
	}

	/**
	 * Sets the shipper comp nm.
	 *
	 * @param shipperCompNm the new shipper comp nm
	 */
	public void setShipperCompNm(String shipperCompNm) {
		this.shipperCompNm = shipperCompNm;
	}

	/**
	 * Gets the shipper country cd.
	 *
	 * @return the shipper country cd
	 */
	public String getShipperCountryCd() {
		return shipperCountryCd;
	}

	/**
	 * Sets the shipper country cd.
	 *
	 * @param shipperCountryCd the new shipper country cd
	 */
	public void setShipperCountryCd(String shipperCountryCd) {
		this.shipperCountryCd = shipperCountryCd;
	}

	/**
	 * Gets the shipper email addr txt.
	 *
	 * @return the shipper email addr txt
	 */
	public String getShipperEmailAddrTxt() {
		return shipperEmailAddrTxt;
	}

	/**
	 * Sets the shipper email addr txt.
	 *
	 * @param shipperEmailAddrTxt the new shipper email addr txt
	 */
	public void setShipperEmailAddrTxt(String shipperEmailAddrTxt) {
		this.shipperEmailAddrTxt = shipperEmailAddrTxt;
	}

	/**
	 * Gets the shipper nm.
	 *
	 * @return the shipper nm
	 */
	public String getShipperNm() {
		return shipperNm;
	}

	/**
	 * Sets the shipper nm.
	 *
	 * @param shipperNm the new shipper nm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
	}

	/**
	 * Gets the shipper ph nbr.
	 *
	 * @return the shipper ph nbr
	 */
	public String getShipperPhNbr() {
		return shipperPhNbr;
	}

	/**
	 * Sets the shipper ph nbr.
	 *
	 * @param shipperPhNbr the new shipper ph nbr
	 */
	public void setShipperPhNbr(String shipperPhNbr) {
		this.shipperPhNbr = shipperPhNbr;
	}

	/**
	 * Gets the shipper pstl cd.
	 *
	 * @return the shipper pstl cd
	 */
	public String getShipperPstlCd() {
		return shipperPstlCd;
	}

	/**
	 * Sets the shipper pstl cd.
	 *
	 * @param shipperPstlCd the new shipper pstl cd
	 */
	public void setShipperPstlCd(String shipperPstlCd) {
		this.shipperPstlCd = shipperPstlCd;
	}

	/**
	 * Gets the shipper ref note txt.
	 *
	 * @return the shipper ref note txt
	 */
	public Integer getShipperRefNoteTxt() {
		return shipperRefNoteTxt;
	}

	/**
	 * Sets the shipper ref note txt.
	 *
	 * @param shipperRefNoteTxt the new shipper ref note txt
	 */
	public void setShipperRefNoteTxt(Integer shipperRefNoteTxt) {
		this.shipperRefNoteTxt = shipperRefNoteTxt;
	}

	/**
	 * Gets the shipper state cd.
	 *
	 * @return the shipper state cd
	 */
	public String getShipperStateCd() {
		return shipperStateCd;
	}

	/**
	 * Sets the shipper state cd.
	 *
	 * @param shipperStateCd the new shipper state cd
	 */
	public void setShipperStateCd(String shipperStateCd) {
		this.shipperStateCd = shipperStateCd;
	}

	/**
	 * Gets the shipper tax id nbr.
	 *
	 * @return the shipper tax id nbr
	 */
	public String getShipperTaxIdNbr() {
		return shipperTaxIdNbr;
	}

	/**
	 * Sets the shipper tax id nbr.
	 *
	 * @param shipperTaxIdNbr the new shipper tax id nbr
	 */
	public void setShipperTaxIdNbr(String shipperTaxIdNbr) {
		this.shipperTaxIdNbr = shipperTaxIdNbr;
	}

	/**
	 * Gets the awb shpmt details.
	 *
	 * @return the awb shpmt details
	 */
	public ChildAwbShpmtDetails getAwbShpmtDetails() {
		return childAwbShpmtDetails;
	}

	/**
	 * Sets the awb shpmt details.
	 *
	 * @param awbShpmtDetails the new awb shpmt details
	 */
	public void setAwbShpmtDetails(ChildAwbShpmtDetails awbShpmtDetails) {
		this.childAwbShpmtDetails = awbShpmtDetails;
	}

	public String getRecipientPstlCd() {
		return recipientPstlCd;
	}

	public void setRecipientPstlCd(String recipientPstlCd) {
		this.recipientPstlCd = recipientPstlCd;
	}

	@Override
	public String toString() {
		return "AwbCustMaster [isqnMstrCd=" + isqnMstrCd + ", awbShpmtDetails=" + childAwbShpmtDetails
				+ ", shipperAccountNbr=" + shipperAccountNbr + ", awbNbr=" + awbNbr + ", createDt=" + createDt
				+ ", modfyDt=" + modfyDt + ", custRqstrNm=" + custRqstrNm + ", custTypeCd=" + custTypeCd
				+ ", custEmailId=" + custEmailId + ", custLangPrefCd=" + custLangPrefCd + ", custNotifTypeCd="
				+ custNotifTypeCd + ", custRequesterCompNm=" + custRequesterCompNm + ", custRequesterEmailId="
				+ custRequesterEmailId + ", recipientNm=" + recipientNm + ", recipientPhNbr=" + recipientPhNbr
				+ ", recipientEmalAddrTxt=" + recipientEmalAddrTxt + ", recipientCompNm=" + recipientCompNm
				+ ", recipientCityNmTxt=" + recipientCityNmTxt + ", recipientStateCd=" + recipientStateCd
				+ ", recipientCountryCd=" + recipientCountryCd + ", recipientPstlCd=" + recipientPstlCd
				+ ", recipientTaxIdNbr=" + recipientTaxIdNbr + ", recipientAddrDesc=" + recipientAddrDesc
				+ ", recipientAddlAddrDesc=" + recipientAddlAddrDesc + ", recipientAddrLine1Desc="
				+ recipientAddrLine1Desc + ", recipientAddrLine2Desc=" + recipientAddrLine2Desc
				+ ", recipientAddrLine1Nbr=" + recipientAddrLine1Nbr + ", recipientAddrLine2Nbr="
				+ recipientAddrLine2Nbr + ", requesterAcctNbr=" + requesterAcctNbr + ", shipperAddrDesc="
				+ shipperAddrDesc + ", shipperAddlAddrDesc=" + shipperAddlAddrDesc + ", shipperAddrLine1Desc="
				+ shipperAddrLine1Desc + ", shipperAddrLine2Desc=" + shipperAddrLine2Desc + ", shipperAddrLine1Nbr="
				+ shipperAddrLine1Nbr + ", shipperAddrLine2Nbr=" + shipperAddrLine2Nbr + ", shipperCityNm="
				+ shipperCityNm + ", shipperCompNm=" + shipperCompNm + ", shipperCountryCd=" + shipperCountryCd
				+ ", shipperEmailAddrTxt=" + shipperEmailAddrTxt + ", shipperNm=" + shipperNm + ", shipperPhNbr="
				+ shipperPhNbr + ", shipperPstlCd=" + shipperPstlCd + ", shipperRefNoteTxt=" + shipperRefNoteTxt
				+ ", shipperStateCd=" + shipperStateCd + ", shipperTaxIdNbr=" + shipperTaxIdNbr + "]";
	}

	public String getMasterAwbNbr() {
		return masterAwbNbr;
	}

	public void setMasterAwbNbr(String masterAwbNbr) {
		this.masterAwbNbr = masterAwbNbr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

}
