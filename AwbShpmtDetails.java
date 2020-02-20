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
 * The Class AwbShpmtDetails.
 */
@Entity
@Table(name = "AWB_SHIPMENT_DETAIL")
public class AwbShpmtDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The awb shpmt id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AWB_SHPMT_DETAILS_AWB_SHPMT_SEQ")
	@SequenceGenerator(name = "AWB_SHPMT_SEQ", sequenceName = "AWB_SHPMT_DETAILS_AWB_SHPMT_SEQ", allocationSize=1)
	@Column(name = "ISQN_CD", columnDefinition = "")
	private Long isqnCd;

	/** The awb cust master. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = false, insertable = false, updatable = false)
	private AwbCustMaster awbCustMaster;

	/** The shpr acct nbr. */
	@Column(name = "SHPR_ACCT_NBR", columnDefinition = "")
	private String shipperAcctNbr;

	/** The awb nbr. */
	@Column(name = "AWB_NBR", columnDefinition = "")
	private String awbNbr;

	/** The barcd desc. */
	@Column(name = "BARCD_DESC", columnDefinition = "")
	private String barcdDesc;

	/** The barcd state cd. */
	@Column(name = "BARCD_STATE_CD", columnDefinition = "")
	private String barcdStateCd;

	/** The barcd symbology cd. */
	@Column(name = "BARCD_SYM_CD", columnDefinition = "")
	private String barcdSymbologyCd;

	/** The base service cd. */
	@Column(name = "BASE_SERVICE_CD", columnDefinition = "")
	private Integer baseServiceCd;

	/** The base service offering id. */
	@Column(name = "BASE_SERVICE_OFFERING_ID", columnDefinition = "")
	private String baseServiceOfferingId;

	/** The bill to acct nbr. */
	@Column(name = "BILL_TO_ACCT_NBR", columnDefinition = "")
	private Long billToAcctNbr;

	/** The carrier comp cd. */
	@Column(name = "CARRIER_COMP_CD", columnDefinition = "")
	private String carrierCompCd;

	/** The cod payable desc. */
	@Column(name = "COD_PAYABLE_DESC", columnDefinition = "")
	private String codPayableDesc;

	/** The contract delete flg. */
	@Column(name = "CONTRACT_DELETE_FLG", columnDefinition = "")
	private String contractDeleteFlg;

	/** The create dt. */
	@Column(name = "CREATE_DT", columnDefinition = "")
	private Date createDt;

	/** The modfy dt. */
	@Column(name = "MODFY_DT", columnDefinition = "")
	private Date modfyDt;

	/** The dest loc cd. */
	@Column(name = "DEST_LOC_CD", columnDefinition = "")
	private String destLocCd;

	/** The doc 1 reqrd type cd. */
	@Column(name = "DOC_1_REQRD_TYPE_CD", columnDefinition = "")
	private String doc1ReqrdTypeCd;

	/** The doc 2 reqrd type cd. */
	@Column(name = "DOC_2_REQRD_TYPE_CD", columnDefinition = "")
	private String doc2ReqrdTypeCd;

	/** The dv curr cd. */
	@Column(name = "DV_CURR_CD", columnDefinition = "")
	private String dvCurrCd;

	/** The dvc id. */
	@Column(name = "DVC_ID", columnDefinition = "")
	private Integer dvcId;

	/** The dvc type txt. */
	@Column(name = "DVC_TYPE_TXT", columnDefinition = "")
	private String dvcTypeTxt;

	/** The evnt crtn tmstp. */
	@Column(name = "EVNT_CRTN_TMSTP", columnDefinition = "")
	@Temporal(TemporalType.DATE)
	private Date evntCrtnTmstp;

	/** The evnt sqnc nbr. */
	@Column(name = "EVNT_SQNC_NBR", columnDefinition = "")
	private Long evntSqncNbr;

	/** The evnt sys nm. */
	@Column(name = "EVNT_SYS_NM", columnDefinition = "")
	private String evntSysNm;

	/** The expt contr type cd. */
	@Column(name = "EXPT_CONTR_TYPE_CD", columnDefinition = "")
	private Integer exptContrTypeCd;

	/** The expt file stat cd. */
	@Column(name = "EXPT_FILE_STAT_CD", columnDefinition = "")
	private String exptFileStatCd;

	/** The key desc. */
	@Column(name = "KEY_DESC", columnDefinition = "")
	private String keyDesc;

	/** The msg tc adt grp msg hash desc. */
	@Column(name = "MSG_TC_ADT_GRP_MSG_HASH_DESC", columnDefinition = "")
	private String msgTcAdtGrpMsgHashDesc;

	/** The msg tc adt grp msg pos desc. */
	@Column(name = "MSG_TC_ADT_GRP_MSG_POS_DESC", columnDefinition = "")
	private Integer msgTcAdtGrpMsgPosDesc;

	/** The msg 1 tc adt grp evnt ce tmstp. */
	@Column(name = "MSG_1_TC_ADT_GRP_EVNT_CE_TMSTP", columnDefinition = "")
	@Temporal(TemporalType.DATE)
	private Date msg1TcAdtGrpEvntCeTmstp;

	/** The msg 2 tc adt grp evnt ce tmstp. */
	@Column(name = "MSG_2_TC_ADT_GRP_EVNT_CE_TMSTP", columnDefinition = "")
	@Temporal(TemporalType.DATE)
	private Date msg2TcAdtGrpEvntCeTmstp;

	/** The msg 1 tc adt grp trce sys nm. */
	@Column(name = "MSG_1_TC_ADT_GRP_TRCE_SYS_NM", columnDefinition = "")
	private String msg1TcAdtGrpTrceSysNm;

	/** The msg 2 tc adt grp trce sys nm. */
	@Column(name = "MSG_2_TC_ADT_GRP_TRCE_SYS_NM", columnDefinition = "")
	private String msg2TcAdtGrpTrceSysNm;

	/** The msg 3 tc adt grp trce sys nm. */
	@Column(name = "MSG_3_TC_ADT_GRP_TRCE_SYS_NM", columnDefinition = "")
	private String msg3TcAdtGrpTrceSysNm;

	/** The msg ver nbr. */
	@Column(name = "MSG_VER_NBR", columnDefinition = "")
	private String msgVerNbr;

	/** The notes grp line nbr. */
	@Column(name = "NOTES_GRP_LINE_NBR", columnDefinition = "")
	private Integer notesGrpLineNbr;

	/** The notes grp ref type cd. */
	@Column(name = "NOTES_GRP_REF_TYPE_CD", columnDefinition = "")
	private String notesGrpRefTypeCd;

	/** The notes ref shpr grp. */
	@Column(name = "NOTES_REF_SHPR_GRP", columnDefinition = "")
	private Integer notesRefShprGrp;

	/** The notif format cd. */
	@Column(name = "NOTIF_FORMAT_CD", columnDefinition = "")
	private String notifFormatCd;

	/** The origin location cd. */
	@Column(name = "ORIGIN_LOCATION_CD", columnDefinition = "")
	private String originLocationCd;

	/** The pack offrg id. */
	@Column(name = "PACK_OFFRG_ID", columnDefinition = "")
	private String packOffrgId;

	/** The pack type id. */
	@Column(name = "PACK_TYPE_ID", columnDefinition = "")
	private String packTypeId;

	/** The pckup stop type txt. */
	@Column(name = "PCKUP_STOP_TYPE_TXT", columnDefinition = "")
	private String pckupStopTypeTxt;

	/** The pkg dv number. */
	@Column(name = "PKG_DV_NBR", columnDefinition = "")
	private String pkgDvNbr;

	/** The pkg wgt. */
	@Column(name = "PKG_WGT", columnDefinition = "")
	private double pkgWgt;

	/** The uom pkg wgt. */
	@Column(name = "UOM_PKG_WGT", columnDefinition = "")
	private String uomPkgWgt;

	/** The pty reltd flg. */
	@Column(name = "PTY_RELTD_FLG", columnDefinition = "")
	private String ptyReltdFlg;

	/** The pymt mthd cd. */
	@Column(name = "PYMT_MTHD_CD", columnDefinition = "")
	private String pymtMthdCd;

	/** The pymt payor cd. */
	@Column(name = "PYMT_PAYOR_CD", columnDefinition = "")
	private Integer pymtPayorCd;

	/** The route loc cd. */
	@Column(name = "ROUTE_LOC_CD", columnDefinition = "")
	private String routeLocCd;

	/** The shpmt dv id. */
	@Column(name = "SHPMT_DV_DESC", columnDefinition = "")
	private String shpmtDvId;

	/** The sftwr ver id. */
	@Column(name = "SFTWR_VER_ID", columnDefinition = "")
	private String sftwrVerId;

	/** The ship dt. */
	@Column(name = "SHIP_DT", columnDefinition = "")
	private Date shipmentDate;

	/** The shpmt decval curr cd. */
	@Column(name = "SHPMT_DECVAL_CURR_CD", columnDefinition = "")
	private String shpmtDecvalCurrCd;

	/** The shpmt lbl co txt. */
	@Column(name = "SHPMT_LBL_CO_TXT", columnDefinition = "")
	private String shpmtLblCoTxt;

	/** The shpmt pkg cnt nbr. */
	@Column(name = "SHPMT_PKG_CNT_NBR", columnDefinition = "")
	private Integer shpmtPkgCntNbr;

	/** The shpmt pkg nbr. */
	@Column(name = "SHPMT_PKG_NBR", columnDefinition = "")
	private Integer shpmtPkgNbr;

	/** The shpmt prps txt. */
	@Column(name = "SHPMT_PRPS_TXT", columnDefinition = "")
	private String shpmtPrpsTxt;

	/** The shpmt wgt. */
	@Column(name = "SHPMT_WGT", columnDefinition = "")
	private double shpmtWgt;

	/** The shpmt wt uom id. */
	@Column(name = "SHPMT_WT_UOM_ID", columnDefinition = "")
	private String shpmtWtUomId;

	/** The tot shpmt value nbr. */
	@Column(name = "TOT_SHPMT_VALUE_NBR", columnDefinition = "")
	private Integer totShpmtValueNbr;

	/** The trak gmt post tm. */
	@Column(name = "TRAK_GMT_POST_TM", columnDefinition = "")
	@Temporal(TemporalType.DATE)
	private Date trakGmtPostTm;

	/** The trak scn tm. */
	@Column(name = "TRAK_SCN_TM", columnDefinition = "")
	private Date trakScnTm;

	/** The trak typ id. */
	@Column(name = "TRAK_TYP_ID", columnDefinition = "")
	private String trakTypId;

	/** The trak dt. */
	@Column(name = "TRAK_DT", columnDefinition = "")
	private Date trakDt;

	/** The trak gmt post dt. */
	@Column(name = "TRAK_GMT_POST_DT", columnDefinition = "")
	private Date trakGmtPostDt;

	/** The trkng itm form cd. */
	@Column(name = "TRKNG_ITM_FORM_CD", columnDefinition = "")
	private String trkngItmFormCd;

	/** The ursa cd. */
	@Column(name = "URSA_CD", columnDefinition = "")
	private String ursaCd;

	/** The val desc. */
	@Column(name = "VAL_DESC", columnDefinition = "")
	private String valDesc;

	/** The sep gmt post tmstp. */
	@Column(name = "SEP_GMT_POST_TMSTP", columnDefinition = "")
	@Temporal(TemporalType.DATE)
	private Date sepGmtPostTmstp;

	/** The sep it fld set flg. */
	@Column(name = "SEP_IT_FLD_SET_FLG", columnDefinition = "")
	private String sepItFldSetFlg;

	/** The sep it gmt offst min desc. */
	@Column(name = "SEP_IT_GMT_OFFST_MIN_DESC", columnDefinition = "")
	private Integer sepItGmtOffstMinDesc;

	/** The sep it ea match score desc. */
	@Column(name = "SEP_IT_EA_MATCH_SCORE_DESC", columnDefinition = "")
	private String sepItEaMatchScoreDesc;

	/** The sep it scan hash val desc. */
	@Column(name = "SEP_IT_SCAN_HASH_VAL_DESC", columnDefinition = "")
	private String sepItScanHashValDesc;

	/** The sep it svc area cd desc. */
	@Column(name = "SEP_IT_SVC_AREA_CD_DESC", columnDefinition = "")
	private String sepItSvcAreaCdDesc;

	/** The sep it recp admin loc cd desc. */
	@Column(name = "SEP_IT_RECP_ADMIN_LOC_CD_DESC", columnDefinition = "")
	private String sepItRecpAdminLocCdDesc;

	/** The sep it recp iata cd desc. */
	@Column(name = "SEP_IT_RECP_IATA_CD_DESC", columnDefinition = "")
	private String sepItRecpIataCdDesc;

	/** The sep it recp loc type cd desc. */
	@Column(name = "SEP_IT_RECP_LOC_TYPE_CD_DESC", columnDefinition = "")
	private String sepItRecpLocTypeCdDesc;

	/** The sep it recp loc cd desc. */
	@Column(name = "SEP_IT_RECP_LOC_CD_DESC", columnDefinition = "")
	private String sepItRecpLocCdDesc;

	/** The sep it dom recp svc ar cd desc. */
	@Column(name = "SEP_IT_DOM_RECP_SVC_AR_CD_DESC", columnDefinition = "")
	private String sepItDomRecpSvcArCdDesc;

	/** The sep it recp svc ar cd desc. */
	@Column(name = "SEP_IT_RECP_SVC_AR_CD_DESC", columnDefinition = "")
	private String sepItRecpSvcArCdDesc;

	/** The sep it recp city nm desc. */
	@Column(name = "SEP_IT_RECP_CITY_NM_DESC", columnDefinition = "")
	private String sepItRecpCityNmDesc;

	/** The sep it recp pstl cd desc. */
	@Column(name = "SEP_IT_RECP_PSTL_CD_DESC", columnDefinition = "")
	private Integer sepItRecpPstlCdDesc;

	/** The sep it recp st prov cd desc. */
	@Column(name = "SEP_IT_RECP_ST_PROV_CD_DESC", columnDefinition = "")
	private String sepItRecpStProvCdDesc;

	/** The sep it recp country cd desc. */
	@Column(name = "SEP_IT_RECP_COUNTRY_CD_DESC", columnDefinition = "")
	private String sepItRecpCountryCdDesc;

	/** The sep it orig gmt offst min desc. */
	@Column(name = "SEP_IT_ORIG_GMT_OFFST_MIN_DESC", columnDefinition = "")
	private Integer sepItOrigGmtOffstMinDesc;

	/** The sep it orig mkt id cd desc. */
	@Column(name = "SEP_IT_ORIG_MKT_ID_CD_DESC", columnDefinition = "")
	private String sepItOrigMktIdCdDesc;

	/** The sep it orig radar mstr loc desc. */
	@Column(name = "SEP_IT_ORIG_RADAR_MSTR_LOC_DESC", columnDefinition = "")
	private String sepItOrigRadarMstrLocDesc;

	/** The sep it orig admin loc cd desc. */
	@Column(name = "SEP_IT_ORIG_ADMIN_LOC_CD_DESC", columnDefinition = "")
	private String sepItOrigAdminLocCdDesc;

	/** The sep it orig addr desc desc. */
	@Column(name = "SEP_IT_ORIG_ADDR_DESC_DESC", columnDefinition = "")
	private String sepItOrigAddrDescDesc;

	/** The sep it orig loc iata cd desc. */
	@Column(name = "SEP_IT_ORIG_LOC_IATA_CD_DESC", columnDefinition = "")
	private String sepItOrigLocIataCdDesc;

	/** The sep it orig loc type desc. */
	@Column(name = "SEP_IT_ORIG_LOC_TYPE_DESC", columnDefinition = "")
	private String sepItOrigLocTypeDesc;

	/** The sep it orig loc cd desc. */
	@Column(name = "SEP_IT_ORIG_LOC_CD_DESC", columnDefinition = "")
	private String sepItOrigLocCdDesc;

	/** The sep it orig svc area cd desc. */
	@Column(name = "SEP_IT_ORIG_SVC_AREA_CD_DESC", columnDefinition = "")
	private String sepItOrigSvcAreaCdDesc;

	/** The sep it orig loc city nm desc. */
	@Column(name = "SEP_IT_ORIG_LOC_CITY_NM_DESC", columnDefinition = "")
	private String sepItOrigLocCityNmDesc;

	/** The sep it orig pstl cd desc. */
	@Column(name = "SEP_IT_ORIG_PSTL_CD_DESC", columnDefinition = "")
	private Integer sepItOrigPstlCdDesc;

	/** The sep it orig st prov cd desc. */
	@Column(name = "SEP_IT_ORIG_ST_PROV_CD_DESC", columnDefinition = "")
	private String sepItOrigStProvCdDesc;

	/** The sep it orig cntry cd desc. */
	@Column(name = "SEP_IT_ORIG_CNTRY_CD_DESC", columnDefinition = "")
	private String sepItOrigCntryCdDesc;

	/** The sep it dest gmt offst min desc. */
	@Column(name = "SEP_IT_DEST_GMT_OFFST_MIN_DESC", columnDefinition = "")
	private Integer sepItDestGmtOffstMinDesc;

	/** The sep it dest mkt id cd desc. */
	@Column(name = "SEP_IT_DEST_MKT_ID_CD_DESC", columnDefinition = "")
	private String sepItDestMktIdCdDesc;

	/** The sep it dest radar mstr loc desc. */
	@Column(name = "SEP_IT_DEST_RADAR_MSTR_LOC_DESC", columnDefinition = "")
	private String sepItDestRadarMstrLocDesc;

	/** The sep it dest admin loc cd desc. */
	@Column(name = "SEP_IT_DEST_ADMIN_LOC_CD_DESC", columnDefinition = "")
	private String sepItDestAdminLocCdDesc;

	/** The sep it dest addr desc desc. */
	@Column(name = "SEP_IT_DEST_ADDR_DESC_DESC", columnDefinition = "")
	private String sepItDestAddrDescDesc;

	/** The sep it dest loc iata cd desc. */
	@Column(name = "SEP_IT_DEST_LOC_IATA_CD_DESC", columnDefinition = "")
	private String sepItDestLocIataCdDesc;

	/** The sep it dest loc type desc. */
	@Column(name = "SEP_IT_DEST_LOC_TYPE_DESC", columnDefinition = "")
	private String sepItDestLocTypeDesc;

	/** The sep it dest loc cd desc. */
	@Column(name = "SEP_IT_DEST_LOC_CD_DESC", columnDefinition = "")
	private String sepItDestLocCdDesc;

	/** The sep it dom dest svc area cd desc. */
	@Column(name = "SEP_IT_DOM_DEST_SVC_AREA_CD_DESC", columnDefinition = "")
	private String sepItDomDestSvcAreaCdDesc;

	/** The sep it dest loc city nm desc. */
	@Column(name = "SEP_IT_DEST_LOC_CITY_NM_DESC", columnDefinition = "")
	private String sepItDestLocCityNmDesc;

	/** The sep it dest pstl cd desc. */
	@Column(name = "SEP_IT_DEST_PSTL_CD_DESC", columnDefinition = "")
	private Integer sepItDestPstlCdDesc;

	/** The sep it dest st prov cd desc. */
	@Column(name = "SEP_IT_DEST_ST_PROV_CD_DESC", columnDefinition = "")
	private String sepItDestStProvCdDesc;

	/** The sep it dest cntry cd desc. */
	@Column(name = "SEP_IT_DEST_CNTRY_CD_DESC", columnDefinition = "")
	private String sepItDestCntryCdDesc;

	/** The dim wgt. */
	@Column(name = "DIM_WGT", columnDefinition = "")
	private String dimWgt;

	/** The unit dim wgt. */
	@Column(name = "UNIT_DIM_WGT", columnDefinition = "")
	private String unitDimWgt;

	/** The final itm rate. */
	@Column(name = "FNL_ITM_RTE", columnDefinition = "")
	private String finalItmRate;

	/** The commitment date. */
	@Column(name = "SVC_COMIT_DT", columnDefinition = "")
	private Timestamp commitmentDate;

	/**
	 * Gets the isqn cd.
	 *
	 * @return the isqn cd
	 */
	public Long getIsqnCd() {
		return isqnCd;
	}

	/**
	 * Sets the isqn cd.
	 *
	 * @param isqnCd the new isqn cd
	 */
	public void setIsqnCd(Long isqnCd) {
		this.isqnCd = isqnCd;
	}

	/**
	 * Gets the awb cust master.
	 *
	 * @return the awb cust master
	 */
	public AwbCustMaster getAwbCustMaster() {
		return awbCustMaster;
	}

	/**
	 * Sets the awb cust master.
	 *
	 * @param awbCustMaster the new awb cust master
	 */
	public void setAwbCustMaster(AwbCustMaster awbCustMaster) {
		this.awbCustMaster = awbCustMaster;
	}

	/**
	 * Gets the shipper acct nbr.
	 *
	 * @return the shipper acct nbr
	 */
	public String getShipperAcctNbr() {
		return shipperAcctNbr;
	}

	/**
	 * Sets the shipper acct nbr.
	 *
	 * @param shipperAcctNbr the new shipper acct nbr
	 */
	public void setShipperAcctNbr(String shipperAcctNbr) {
		this.shipperAcctNbr = shipperAcctNbr;
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
	 * Gets the barcd desc.
	 *
	 * @return the barcd desc
	 */
	public String getBarcdDesc() {
		return barcdDesc;
	}

	/**
	 * Sets the barcd desc.
	 *
	 * @param barcdDesc the new barcd desc
	 */
	public void setBarcdDesc(String barcdDesc) {
		this.barcdDesc = barcdDesc;
	}

	/**
	 * Gets the barcd state cd.
	 *
	 * @return the barcd state cd
	 */
	public String getBarcdStateCd() {
		return barcdStateCd;
	}

	/**
	 * Sets the barcd state cd.
	 *
	 * @param barcdStateCd the new barcd state cd
	 */
	public void setBarcdStateCd(String barcdStateCd) {
		this.barcdStateCd = barcdStateCd;
	}

	/**
	 * Gets the barcd symbology cd.
	 *
	 * @return the barcd symbology cd
	 */
	public String getBarcdSymbologyCd() {
		return barcdSymbologyCd;
	}

	/**
	 * Sets the barcd symbology cd.
	 *
	 * @param barcdSymbologyCd the new barcd symbology cd
	 */
	public void setBarcdSymbologyCd(String barcdSymbologyCd) {
		this.barcdSymbologyCd = barcdSymbologyCd;
	}

	/**
	 * Gets the base service cd.
	 *
	 * @return the base service cd
	 */
	public Integer getBaseServiceCd() {
		return baseServiceCd;
	}

	/**
	 * Sets the base service cd.
	 *
	 * @param baseServiceCd the new base service cd
	 */
	public void setBaseServiceCd(Integer baseServiceCd) {
		this.baseServiceCd = baseServiceCd;
	}

	/**
	 * Gets the base service offering id.
	 *
	 * @return the base service offering id
	 */
	public String getBaseServiceOfferingId() {
		return baseServiceOfferingId;
	}

	/**
	 * Sets the base service offering id.
	 *
	 * @param baseServiceOfferingId the new base service offering id
	 */
	public void setBaseServiceOfferingId(String baseServiceOfferingId) {
		this.baseServiceOfferingId = baseServiceOfferingId;
	}

	/**
	 * Gets the bill to acct nbr.
	 *
	 * @return the bill to acct nbr
	 */
	public Long getBillToAcctNbr() {
		return billToAcctNbr;
	}

	/**
	 * Sets the bill to acct nbr.
	 *
	 * @param billToAcctNbr the new bill to acct nbr
	 */
	public void setBillToAcctNbr(Long billToAcctNbr) {
		this.billToAcctNbr = billToAcctNbr;
	}

	/**
	 * Gets the carrier comp cd.
	 *
	 * @return the carrier comp cd
	 */
	public String getCarrierCompCd() {
		return carrierCompCd;
	}

	/**
	 * Sets the carrier comp cd.
	 *
	 * @param carrierCompCd the new carrier comp cd
	 */
	public void setCarrierCompCd(String carrierCompCd) {
		this.carrierCompCd = carrierCompCd;
	}

	/**
	 * Gets the cod payable desc.
	 *
	 * @return the cod payable desc
	 */
	public String getCodPayableDesc() {
		return codPayableDesc;
	}

	/**
	 * Sets the cod payable desc.
	 *
	 * @param codPayableDesc the new cod payable desc
	 */
	public void setCodPayableDesc(String codPayableDesc) {
		this.codPayableDesc = codPayableDesc;
	}

	/**
	 * Gets the contract delete flg.
	 *
	 * @return the contract delete flg
	 */
	public String getContractDeleteFlg() {
		return contractDeleteFlg;
	}

	/**
	 * Sets the contract delete flg.
	 *
	 * @param contractDeleteFlg the new contract delete flg
	 */
	public void setContractDeleteFlg(String contractDeleteFlg) {
		this.contractDeleteFlg = contractDeleteFlg;
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
	 * Gets the dest loc cd.
	 *
	 * @return the dest loc cd
	 */
	public String getDestLocCd() {
		return destLocCd;
	}

	/**
	 * Sets the dest loc cd.
	 *
	 * @param destLocCd the new dest loc cd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}

	/**
	 * Gets the doc 1 reqrd type cd.
	 *
	 * @return the doc 1 reqrd type cd
	 */
	public String getDoc1ReqrdTypeCd() {
		return doc1ReqrdTypeCd;
	}

	/**
	 * Sets the doc 1 reqrd type cd.
	 *
	 * @param doc1ReqrdTypeCd the new doc 1 reqrd type cd
	 */
	public void setDoc1ReqrdTypeCd(String doc1ReqrdTypeCd) {
		this.doc1ReqrdTypeCd = doc1ReqrdTypeCd;
	}

	/**
	 * Gets the doc 2 reqrd type cd.
	 *
	 * @return the doc 2 reqrd type cd
	 */
	public String getDoc2ReqrdTypeCd() {
		return doc2ReqrdTypeCd;
	}

	/**
	 * Sets the doc 2 reqrd type cd.
	 *
	 * @param doc2ReqrdTypeCd the new doc 2 reqrd type cd
	 */
	public void setDoc2ReqrdTypeCd(String doc2ReqrdTypeCd) {
		this.doc2ReqrdTypeCd = doc2ReqrdTypeCd;
	}

	/**
	 * Gets the dv curr cd.
	 *
	 * @return the dv curr cd
	 */
	public String getDvCurrCd() {
		return dvCurrCd;
	}

	/**
	 * Sets the dv curr cd.
	 *
	 * @param dvCurrCd the new dv curr cd
	 */
	public void setDvCurrCd(String dvCurrCd) {
		this.dvCurrCd = dvCurrCd;
	}

	/**
	 * Gets the dvc id.
	 *
	 * @return the dvc id
	 */
	public Integer getDvcId() {
		return dvcId;
	}

	/**
	 * Sets the dvc id.
	 *
	 * @param dvcId the new dvc id
	 */
	public void setDvcId(Integer dvcId) {
		this.dvcId = dvcId;
	}

	/**
	 * Gets the dvc type txt.
	 *
	 * @return the dvc type txt
	 */
	public String getDvcTypeTxt() {
		return dvcTypeTxt;
	}

	/**
	 * Sets the dvc type txt.
	 *
	 * @param dvcTypeTxt the new dvc type txt
	 */
	public void setDvcTypeTxt(String dvcTypeTxt) {
		this.dvcTypeTxt = dvcTypeTxt;
	}

	/**
	 * Gets the evnt crtn tmstp.
	 *
	 * @return the evnt crtn tmstp
	 */
	public Date getEvntCrtnTmstp() {
		return evntCrtnTmstp;
	}

	/**
	 * Sets the evnt crtn tmstp.
	 *
	 * @param evntCrtnTmstp the new evnt crtn tmstp
	 */
	public void setEvntCrtnTmstp(Date evntCrtnTmstp) {
		this.evntCrtnTmstp = evntCrtnTmstp;
	}

	/**
	 * Gets the evnt sqnc nbr.
	 *
	 * @return the evnt sqnc nbr
	 */
	public Long getEvntSqncNbr() {
		return evntSqncNbr;
	}

	/**
	 * Sets the evnt sqnc nbr.
	 *
	 * @param evntSqncNbr the new evnt sqnc nbr
	 */
	public void setEvntSqncNbr(Long evntSqncNbr) {
		this.evntSqncNbr = evntSqncNbr;
	}

	/**
	 * Gets the evnt sys nm.
	 *
	 * @return the evnt sys nm
	 */
	public String getEvntSysNm() {
		return evntSysNm;
	}

	/**
	 * Sets the evnt sys nm.
	 *
	 * @param evntSysNm the new evnt sys nm
	 */
	public void setEvntSysNm(String evntSysNm) {
		this.evntSysNm = evntSysNm;
	}

	/**
	 * Gets the expt contr type cd.
	 *
	 * @return the expt contr type cd
	 */
	public Integer getExptContrTypeCd() {
		return exptContrTypeCd;
	}

	/**
	 * Sets the expt contr type cd.
	 *
	 * @param exptContrTypeCd the new expt contr type cd
	 */
	public void setExptContrTypeCd(Integer exptContrTypeCd) {
		this.exptContrTypeCd = exptContrTypeCd;
	}

	/**
	 * Gets the expt file stat cd.
	 *
	 * @return the expt file stat cd
	 */
	public String getExptFileStatCd() {
		return exptFileStatCd;
	}

	/**
	 * Sets the expt file stat cd.
	 *
	 * @param exptFileStatCd the new expt file stat cd
	 */
	public void setExptFileStatCd(String exptFileStatCd) {
		this.exptFileStatCd = exptFileStatCd;
	}

	/**
	 * Gets the key desc.
	 *
	 * @return the key desc
	 */
	public String getKeyDesc() {
		return keyDesc;
	}

	/**
	 * Sets the key desc.
	 *
	 * @param keyDesc the new key desc
	 */
	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}

	/**
	 * Gets the msg tc adt grp msg hash desc.
	 *
	 * @return the msg tc adt grp msg hash desc
	 */
	public String getMsgTcAdtGrpMsgHashDesc() {
		return msgTcAdtGrpMsgHashDesc;
	}

	/**
	 * Sets the msg tc adt grp msg hash desc.
	 *
	 * @param msgTcAdtGrpMsgHashDesc the new msg tc adt grp msg hash desc
	 */
	public void setMsgTcAdtGrpMsgHashDesc(String msgTcAdtGrpMsgHashDesc) {
		this.msgTcAdtGrpMsgHashDesc = msgTcAdtGrpMsgHashDesc;
	}

	/**
	 * Gets the msg tc adt grp msg pos desc.
	 *
	 * @return the msg tc adt grp msg pos desc
	 */
	public Integer getMsgTcAdtGrpMsgPosDesc() {
		return msgTcAdtGrpMsgPosDesc;
	}

	/**
	 * Sets the msg tc adt grp msg pos desc.
	 *
	 * @param msgTcAdtGrpMsgPosDesc the new msg tc adt grp msg pos desc
	 */
	public void setMsgTcAdtGrpMsgPosDesc(Integer msgTcAdtGrpMsgPosDesc) {
		this.msgTcAdtGrpMsgPosDesc = msgTcAdtGrpMsgPosDesc;
	}

	/**
	 * Gets the msg 1 tc adt grp evnt ce tmstp.
	 *
	 * @return the msg 1 tc adt grp evnt ce tmstp
	 */
	public Date getMsg1TcAdtGrpEvntCeTmstp() {
		return msg1TcAdtGrpEvntCeTmstp;
	}

	/**
	 * Sets the msg 1 tc adt grp evnt ce tmstp.
	 *
	 * @param msg1TcAdtGrpEvntCeTmstp the new msg 1 tc adt grp evnt ce tmstp
	 */
	public void setMsg1TcAdtGrpEvntCeTmstp(Date msg1TcAdtGrpEvntCeTmstp) {
		this.msg1TcAdtGrpEvntCeTmstp = msg1TcAdtGrpEvntCeTmstp;
	}

	/**
	 * Gets the msg 2 tc adt grp evnt ce tmstp.
	 *
	 * @return the msg 2 tc adt grp evnt ce tmstp
	 */
	public Date getMsg2TcAdtGrpEvntCeTmstp() {
		return msg2TcAdtGrpEvntCeTmstp;
	}

	/**
	 * Sets the msg 2 tc adt grp evnt ce tmstp.
	 *
	 * @param msg2TcAdtGrpEvntCeTmstp the new msg 2 tc adt grp evnt ce tmstp
	 */
	public void setMsg2TcAdtGrpEvntCeTmstp(Date msg2TcAdtGrpEvntCeTmstp) {
		this.msg2TcAdtGrpEvntCeTmstp = msg2TcAdtGrpEvntCeTmstp;
	}

	/**
	 * Gets the msg 1 tc adt grp trce sys nm.
	 *
	 * @return the msg 1 tc adt grp trce sys nm
	 */
	public String getMsg1TcAdtGrpTrceSysNm() {
		return msg1TcAdtGrpTrceSysNm;
	}

	/**
	 * Sets the msg 1 tc adt grp trce sys nm.
	 *
	 * @param msg1TcAdtGrpTrceSysNm the new msg 1 tc adt grp trce sys nm
	 */
	public void setMsg1TcAdtGrpTrceSysNm(String msg1TcAdtGrpTrceSysNm) {
		this.msg1TcAdtGrpTrceSysNm = msg1TcAdtGrpTrceSysNm;
	}

	/**
	 * Gets the msg 2 tc adt grp trce sys nm.
	 *
	 * @return the msg 2 tc adt grp trce sys nm
	 */
	public String getMsg2TcAdtGrpTrceSysNm() {
		return msg2TcAdtGrpTrceSysNm;
	}

	/**
	 * Sets the msg 2 tc adt grp trce sys nm.
	 *
	 * @param msg2TcAdtGrpTrceSysNm the new msg 2 tc adt grp trce sys nm
	 */
	public void setMsg2TcAdtGrpTrceSysNm(String msg2TcAdtGrpTrceSysNm) {
		this.msg2TcAdtGrpTrceSysNm = msg2TcAdtGrpTrceSysNm;
	}

	/**
	 * Gets the msg 3 tc adt grp trce sys nm.
	 *
	 * @return the msg 3 tc adt grp trce sys nm
	 */
	public String getMsg3TcAdtGrpTrceSysNm() {
		return msg3TcAdtGrpTrceSysNm;
	}

	/**
	 * Sets the msg 3 tc adt grp trce sys nm.
	 *
	 * @param msg3TcAdtGrpTrceSysNm the new msg 3 tc adt grp trce sys nm
	 */
	public void setMsg3TcAdtGrpTrceSysNm(String msg3TcAdtGrpTrceSysNm) {
		this.msg3TcAdtGrpTrceSysNm = msg3TcAdtGrpTrceSysNm;
	}

	/**
	 * Gets the msg ver nbr.
	 *
	 * @return the msg ver nbr
	 */
	public String getMsgVerNbr() {
		return msgVerNbr;
	}

	/**
	 * Sets the msg ver nbr.
	 *
	 * @param msgVerNbr the new msg ver nbr
	 */
	public void setMsgVerNbr(String msgVerNbr) {
		this.msgVerNbr = msgVerNbr;
	}

	/**
	 * Gets the notes grp line nbr.
	 *
	 * @return the notes grp line nbr
	 */
	public Integer getNotesGrpLineNbr() {
		return notesGrpLineNbr;
	}

	/**
	 * Sets the notes grp line nbr.
	 *
	 * @param notesGrpLineNbr the new notes grp line nbr
	 */
	public void setNotesGrpLineNbr(Integer notesGrpLineNbr) {
		this.notesGrpLineNbr = notesGrpLineNbr;
	}

	/**
	 * Gets the notes grp ref type cd.
	 *
	 * @return the notes grp ref type cd
	 */
	public String getNotesGrpRefTypeCd() {
		return notesGrpRefTypeCd;
	}

	/**
	 * Sets the notes grp ref type cd.
	 *
	 * @param notesGrpRefTypeCd the new notes grp ref type cd
	 */
	public void setNotesGrpRefTypeCd(String notesGrpRefTypeCd) {
		this.notesGrpRefTypeCd = notesGrpRefTypeCd;
	}

	/**
	 * Gets the notes ref shpr grp.
	 *
	 * @return the notes ref shpr grp
	 */
	public Integer getNotesRefShprGrp() {
		return notesRefShprGrp;
	}

	/**
	 * Sets the notes ref shpr grp.
	 *
	 * @param notesRefShprGrp the new notes ref shpr grp
	 */
	public void setNotesRefShprGrp(Integer notesRefShprGrp) {
		this.notesRefShprGrp = notesRefShprGrp;
	}

	/**
	 * Gets the notif format cd.
	 *
	 * @return the notif format cd
	 */
	public String getNotifFormatCd() {
		return notifFormatCd;
	}

	/**
	 * Sets the notif format cd.
	 *
	 * @param notifFormatCd the new notif format cd
	 */
	public void setNotifFormatCd(String notifFormatCd) {
		this.notifFormatCd = notifFormatCd;
	}

	/**
	 * Gets the origin location cd.
	 *
	 * @return the origin location cd
	 */
	public String getOriginLocationCd() {
		return originLocationCd;
	}

	/**
	 * Sets the origin location cd.
	 *
	 * @param originLocationCd the new origin location cd
	 */
	public void setOriginLocationCd(String originLocationCd) {
		this.originLocationCd = originLocationCd;
	}

	/**
	 * Gets the pack offrg id.
	 *
	 * @return the pack offrg id
	 */
	public String getPackOffrgId() {
		return packOffrgId;
	}

	/**
	 * Sets the pack offrg id.
	 *
	 * @param packOffrgId the new pack offrg id
	 */
	public void setPackOffrgId(String packOffrgId) {
		this.packOffrgId = packOffrgId;
	}

	/**
	 * Gets the pack type id.
	 *
	 * @return the pack type id
	 */
	public String getPackTypeId() {
		return packTypeId;
	}

	/**
	 * Sets the pack type id.
	 *
	 * @param packTypeId the new pack type id
	 */
	public void setPackTypeId(String packTypeId) {
		this.packTypeId = packTypeId;
	}

	/**
	 * Gets the pckup stop type txt.
	 *
	 * @return the pckup stop type txt
	 */
	public String getPckupStopTypeTxt() {
		return pckupStopTypeTxt;
	}

	/**
	 * Sets the pckup stop type txt.
	 *
	 * @param pckupStopTypeTxt the new pckup stop type txt
	 */
	public void setPckupStopTypeTxt(String pckupStopTypeTxt) {
		this.pckupStopTypeTxt = pckupStopTypeTxt;
	}

	/**
	 * Gets the pkg dv nbr.
	 *
	 * @return the pkg dv nbr
	 */
	public String getPkgDvNbr() {
		return pkgDvNbr;
	}

	/**
	 * Sets the pkg dv nbr.
	 *
	 * @param pkgDvNbr the new pkg dv nbr
	 */
	public void setPkgDvNbr(String pkgDvNbr) {
		this.pkgDvNbr = pkgDvNbr;
	}

	/**
	 * Gets the pkg wgt.
	 *
	 * @return the pkg wgt
	 */
	public double getPkgWgt() {
		return pkgWgt;
	}

	/**
	 * Sets the pkg wgt.
	 *
	 * @param pkgWgt the new pkg wgt
	 */
	public void setPkgWgt(double pkgWgt) {
		this.pkgWgt = pkgWgt;
	}

	/**
	 * Gets the uom pkg wgt.
	 *
	 * @return the uom pkg wgt
	 */
	public String getUomPkgWgt() {
		return uomPkgWgt;
	}

	/**
	 * Sets the uom pkg wgt.
	 *
	 * @param uomPkgWgt the new uom pkg wgt
	 */
	public void setUomPkgWgt(String uomPkgWgt) {
		this.uomPkgWgt = uomPkgWgt;
	}

	/**
	 * Gets the pty reltd flg.
	 *
	 * @return the pty reltd flg
	 */
	public String getPtyReltdFlg() {
		return ptyReltdFlg;
	}

	/**
	 * Sets the pty reltd flg.
	 *
	 * @param ptyReltdFlg the new pty reltd flg
	 */
	public void setPtyReltdFlg(String ptyReltdFlg) {
		this.ptyReltdFlg = ptyReltdFlg;
	}

	/**
	 * Gets the pymt mthd cd.
	 *
	 * @return the pymt mthd cd
	 */
	public String getPymtMthdCd() {
		return pymtMthdCd;
	}

	/**
	 * Sets the pymt mthd cd.
	 *
	 * @param pymtMthdCd the new pymt mthd cd
	 */
	public void setPymtMthdCd(String pymtMthdCd) {
		this.pymtMthdCd = pymtMthdCd;
	}

	/**
	 * Gets the pymt payor cd.
	 *
	 * @return the pymt payor cd
	 */
	public Integer getPymtPayorCd() {
		return pymtPayorCd;
	}

	/**
	 * Sets the pymt payor cd.
	 *
	 * @param pymtPayorCd the new pymt payor cd
	 */
	public void setPymtPayorCd(Integer pymtPayorCd) {
		this.pymtPayorCd = pymtPayorCd;
	}

	/**
	 * Gets the route loc cd.
	 *
	 * @return the route loc cd
	 */
	public String getRouteLocCd() {
		return routeLocCd;
	}

	/**
	 * Sets the route loc cd.
	 *
	 * @param routeLocCd the new route loc cd
	 */
	public void setRouteLocCd(String routeLocCd) {
		this.routeLocCd = routeLocCd;
	}

	/**
	 * Gets the shpmt dv id.
	 *
	 * @return the shpmt dv id
	 */
	public String getShpmtDvId() {
		return shpmtDvId;
	}

	/**
	 * Sets the shpmt dv id.
	 *
	 * @param shpmtDvId the new shpmt dv id
	 */
	public void setShpmtDvId(String shpmtDvId) {
		this.shpmtDvId = shpmtDvId;
	}

	/**
	 * Gets the sftwr ver id.
	 *
	 * @return the sftwr ver id
	 */
	public String getSftwrVerId() {
		return sftwrVerId;
	}

	/**
	 * Sets the sftwr ver id.
	 *
	 * @param sftwrVerId the new sftwr ver id
	 */
	public void setSftwrVerId(String sftwrVerId) {
		this.sftwrVerId = sftwrVerId;
	}

	/**
	 * Gets the shipment date.
	 *
	 * @return the shipment date
	 */
	public Date getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * Sets the shipment date.
	 *
	 * @param shipmentDate the new shipment date
	 */
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * Gets the shpmt decval curr cd.
	 *
	 * @return the shpmt decval curr cd
	 */
	public String getShpmtDecvalCurrCd() {
		return shpmtDecvalCurrCd;
	}

	/**
	 * Sets the shpmt decval curr cd.
	 *
	 * @param shpmtDecvalCurrCd the new shpmt decval curr cd
	 */
	public void setShpmtDecvalCurrCd(String shpmtDecvalCurrCd) {
		this.shpmtDecvalCurrCd = shpmtDecvalCurrCd;
	}

	/**
	 * Gets the shpmt lbl co txt.
	 *
	 * @return the shpmt lbl co txt
	 */
	public String getShpmtLblCoTxt() {
		return shpmtLblCoTxt;
	}

	/**
	 * Sets the shpmt lbl co txt.
	 *
	 * @param shpmtLblCoTxt the new shpmt lbl co txt
	 */
	public void setShpmtLblCoTxt(String shpmtLblCoTxt) {
		this.shpmtLblCoTxt = shpmtLblCoTxt;
	}

	/**
	 * Gets the shpmt pkg cnt nbr.
	 *
	 * @return the shpmt pkg cnt nbr
	 */
	public Integer getShpmtPkgCntNbr() {
		return shpmtPkgCntNbr;
	}

	/**
	 * Sets the shpmt pkg cnt nbr.
	 *
	 * @param shpmtPkgCntNbr the new shpmt pkg cnt nbr
	 */
	public void setShpmtPkgCntNbr(Integer shpmtPkgCntNbr) {
		this.shpmtPkgCntNbr = shpmtPkgCntNbr;
	}

	/**
	 * Gets the shpmt pkg nbr.
	 *
	 * @return the shpmt pkg nbr
	 */
	public Integer getShpmtPkgNbr() {
		return shpmtPkgNbr;
	}

	/**
	 * Sets the shpmt pkg nbr.
	 *
	 * @param shpmtPkgNbr the new shpmt pkg nbr
	 */
	public void setShpmtPkgNbr(Integer shpmtPkgNbr) {
		this.shpmtPkgNbr = shpmtPkgNbr;
	}

	/**
	 * Gets the shpmt prps txt.
	 *
	 * @return the shpmt prps txt
	 */
	public String getShpmtPrpsTxt() {
		return shpmtPrpsTxt;
	}

	/**
	 * Sets the shpmt prps txt.
	 *
	 * @param shpmtPrpsTxt the new shpmt prps txt
	 */
	public void setShpmtPrpsTxt(String shpmtPrpsTxt) {
		this.shpmtPrpsTxt = shpmtPrpsTxt;
	}

	/**
	 * Gets the shpmt wgt.
	 *
	 * @return the shpmt wgt
	 */
	public double getShpmtWgt() {
		return shpmtWgt;
	}

	/**
	 * Sets the shpmt wgt.
	 *
	 * @param shpmtWgt the new shpmt wgt
	 */
	public void setShpmtWgt(double shpmtWgt) {
		this.shpmtWgt = shpmtWgt;
	}

	/**
	 * Gets the shpmt wt uom id.
	 *
	 * @return the shpmt wt uom id
	 */
	public String getShpmtWtUomId() {
		return shpmtWtUomId;
	}

	/**
	 * Sets the shpmt wt uom id.
	 *
	 * @param shpmtWtUomId the new shpmt wt uom id
	 */
	public void setShpmtWtUomId(String shpmtWtUomId) {
		this.shpmtWtUomId = shpmtWtUomId;
	}

	/**
	 * Gets the tot shpmt value nbr.
	 *
	 * @return the tot shpmt value nbr
	 */
	public Integer getTotShpmtValueNbr() {
		return totShpmtValueNbr;
	}

	/**
	 * Sets the tot shpmt value nbr.
	 *
	 * @param totShpmtValueNbr the new tot shpmt value nbr
	 */
	public void setTotShpmtValueNbr(Integer totShpmtValueNbr) {
		this.totShpmtValueNbr = totShpmtValueNbr;
	}

	/**
	 * Gets the trak gmt post tm.
	 *
	 * @return the trak gmt post tm
	 */
	public Date getTrakGmtPostTm() {
		return trakGmtPostTm;
	}

	/**
	 * Sets the trak gmt post tm.
	 *
	 * @param trakGmtPostTm the new trak gmt post tm
	 */
	public void setTrakGmtPostTm(Date trakGmtPostTm) {
		this.trakGmtPostTm = trakGmtPostTm;
	}

	/**
	 * Gets the trak scn tm.
	 *
	 * @return the trak scn tm
	 */
	public Date getTrakScnTm() {
		return trakScnTm;
	}

	/**
	 * Sets the trak scn tm.
	 *
	 * @param trakScnTm the new trak scn tm
	 */
	public void setTrakScnTm(Date trakScnTm) {
		this.trakScnTm = trakScnTm;
	}

	/**
	 * Gets the trak typ id.
	 *
	 * @return the trak typ id
	 */
	public String getTrakTypId() {
		return trakTypId;
	}

	/**
	 * Sets the trak typ id.
	 *
	 * @param trakTypId the new trak typ id
	 */
	public void setTrakTypId(String trakTypId) {
		this.trakTypId = trakTypId;
	}

	/**
	 * Gets the trak dt.
	 *
	 * @return the trak dt
	 */
	public Date getTrakDt() {
		return trakDt;
	}

	/**
	 * Sets the trak dt.
	 *
	 * @param trakDt the new trak dt
	 */
	public void setTrakDt(Date trakDt) {
		this.trakDt = trakDt;
	}

	/**
	 * Gets the trak gmt post dt.
	 *
	 * @return the trak gmt post dt
	 */
	public Date getTrakGmtPostDt() {
		return trakGmtPostDt;
	}

	/**
	 * Sets the trak gmt post dt.
	 *
	 * @param trakGmtPostDt the new trak gmt post dt
	 */
	public void setTrakGmtPostDt(Date trakGmtPostDt) {
		this.trakGmtPostDt = trakGmtPostDt;
	}

	/**
	 * Gets the trkng itm form cd.
	 *
	 * @return the trkng itm form cd
	 */
	public String getTrkngItmFormCd() {
		return trkngItmFormCd;
	}

	/**
	 * Sets the trkng itm form cd.
	 *
	 * @param trkngItmFormCd the new trkng itm form cd
	 */
	public void setTrkngItmFormCd(String trkngItmFormCd) {
		this.trkngItmFormCd = trkngItmFormCd;
	}

	/**
	 * Gets the ursa cd.
	 *
	 * @return the ursa cd
	 */
	public String getUrsaCd() {
		return ursaCd;
	}

	/**
	 * Sets the ursa cd.
	 *
	 * @param ursaCd the new ursa cd
	 */
	public void setUrsaCd(String ursaCd) {
		this.ursaCd = ursaCd;
	}

	/**
	 * Gets the val desc.
	 *
	 * @return the val desc
	 */
	public String getValDesc() {
		return valDesc;
	}

	/**
	 * Sets the val desc.
	 *
	 * @param valDesc the new val desc
	 */
	public void setValDesc(String valDesc) {
		this.valDesc = valDesc;
	}

	/**
	 * Gets the sep gmt post tmstp.
	 *
	 * @return the sep gmt post tmstp
	 */
	public Date getSepGmtPostTmstp() {
		return sepGmtPostTmstp;
	}

	/**
	 * Sets the sep gmt post tmstp.
	 *
	 * @param sepGmtPostTmstp the new sep gmt post tmstp
	 */
	public void setSepGmtPostTmstp(Date sepGmtPostTmstp) {
		this.sepGmtPostTmstp = sepGmtPostTmstp;
	}

	/**
	 * Gets the sep it fld set flg.
	 *
	 * @return the sep it fld set flg
	 */
	public String getSepItFldSetFlg() {
		return sepItFldSetFlg;
	}

	/**
	 * Sets the sep it fld set flg.
	 *
	 * @param sepItFldSetFlg the new sep it fld set flg
	 */
	public void setSepItFldSetFlg(String sepItFldSetFlg) {
		this.sepItFldSetFlg = sepItFldSetFlg;
	}

	/**
	 * Gets the sep it gmt offst min desc.
	 *
	 * @return the sep it gmt offst min desc
	 */
	public Integer getSepItGmtOffstMinDesc() {
		return sepItGmtOffstMinDesc;
	}

	/**
	 * Sets the sep it gmt offst min desc.
	 *
	 * @param sepItGmtOffstMinDesc the new sep it gmt offst min desc
	 */
	public void setSepItGmtOffstMinDesc(Integer sepItGmtOffstMinDesc) {
		this.sepItGmtOffstMinDesc = sepItGmtOffstMinDesc;
	}

	/**
	 * Gets the sep it ea match score desc.
	 *
	 * @return the sep it ea match score desc
	 */
	public String getSepItEaMatchScoreDesc() {
		return sepItEaMatchScoreDesc;
	}

	/**
	 * Sets the sep it ea match score desc.
	 *
	 * @param sepItEaMatchScoreDesc the new sep it ea match score desc
	 */
	public void setSepItEaMatchScoreDesc(String sepItEaMatchScoreDesc) {
		this.sepItEaMatchScoreDesc = sepItEaMatchScoreDesc;
	}

	/**
	 * Gets the sep it scan hash val desc.
	 *
	 * @return the sep it scan hash val desc
	 */
	public String getSepItScanHashValDesc() {
		return sepItScanHashValDesc;
	}

	/**
	 * Sets the sep it scan hash val desc.
	 *
	 * @param sepItScanHashValDesc the new sep it scan hash val desc
	 */
	public void setSepItScanHashValDesc(String sepItScanHashValDesc) {
		this.sepItScanHashValDesc = sepItScanHashValDesc;
	}

	/**
	 * Gets the sep it svc area cd desc.
	 *
	 * @return the sep it svc area cd desc
	 */
	public String getSepItSvcAreaCdDesc() {
		return sepItSvcAreaCdDesc;
	}

	/**
	 * Sets the sep it svc area cd desc.
	 *
	 * @param sepItSvcAreaCdDesc the new sep it svc area cd desc
	 */
	public void setSepItSvcAreaCdDesc(String sepItSvcAreaCdDesc) {
		this.sepItSvcAreaCdDesc = sepItSvcAreaCdDesc;
	}

	/**
	 * Gets the sep it recp admin loc cd desc.
	 *
	 * @return the sep it recp admin loc cd desc
	 */
	public String getSepItRecpAdminLocCdDesc() {
		return sepItRecpAdminLocCdDesc;
	}

	/**
	 * Sets the sep it recp admin loc cd desc.
	 *
	 * @param sepItRecpAdminLocCdDesc the new sep it recp admin loc cd desc
	 */
	public void setSepItRecpAdminLocCdDesc(String sepItRecpAdminLocCdDesc) {
		this.sepItRecpAdminLocCdDesc = sepItRecpAdminLocCdDesc;
	}

	/**
	 * Gets the sep it recp iata cd desc.
	 *
	 * @return the sep it recp iata cd desc
	 */
	public String getSepItRecpIataCdDesc() {
		return sepItRecpIataCdDesc;
	}

	/**
	 * Sets the sep it recp iata cd desc.
	 *
	 * @param sepItRecpIataCdDesc the new sep it recp iata cd desc
	 */
	public void setSepItRecpIataCdDesc(String sepItRecpIataCdDesc) {
		this.sepItRecpIataCdDesc = sepItRecpIataCdDesc;
	}

	/**
	 * Gets the sep it recp loc type cd desc.
	 *
	 * @return the sep it recp loc type cd desc
	 */
	public String getSepItRecpLocTypeCdDesc() {
		return sepItRecpLocTypeCdDesc;
	}

	/**
	 * Sets the sep it recp loc type cd desc.
	 *
	 * @param sepItRecpLocTypeCdDesc the new sep it recp loc type cd desc
	 */
	public void setSepItRecpLocTypeCdDesc(String sepItRecpLocTypeCdDesc) {
		this.sepItRecpLocTypeCdDesc = sepItRecpLocTypeCdDesc;
	}

	/**
	 * Gets the sep it recp loc cd desc.
	 *
	 * @return the sep it recp loc cd desc
	 */
	public String getSepItRecpLocCdDesc() {
		return sepItRecpLocCdDesc;
	}

	/**
	 * Sets the sep it recp loc cd desc.
	 *
	 * @param sepItRecpLocCdDesc the new sep it recp loc cd desc
	 */
	public void setSepItRecpLocCdDesc(String sepItRecpLocCdDesc) {
		this.sepItRecpLocCdDesc = sepItRecpLocCdDesc;
	}

	/**
	 * Gets the sep it dom recp svc ar cd desc.
	 *
	 * @return the sep it dom recp svc ar cd desc
	 */
	public String getSepItDomRecpSvcArCdDesc() {
		return sepItDomRecpSvcArCdDesc;
	}

	/**
	 * Sets the sep it dom recp svc ar cd desc.
	 *
	 * @param sepItDomRecpSvcArCdDesc the new sep it dom recp svc ar cd desc
	 */
	public void setSepItDomRecpSvcArCdDesc(String sepItDomRecpSvcArCdDesc) {
		this.sepItDomRecpSvcArCdDesc = sepItDomRecpSvcArCdDesc;
	}

	/**
	 * Gets the sep it recp svc ar cd desc.
	 *
	 * @return the sep it recp svc ar cd desc
	 */
	public String getSepItRecpSvcArCdDesc() {
		return sepItRecpSvcArCdDesc;
	}

	/**
	 * Sets the sep it recp svc ar cd desc.
	 *
	 * @param sepItRecpSvcArCdDesc the new sep it recp svc ar cd desc
	 */
	public void setSepItRecpSvcArCdDesc(String sepItRecpSvcArCdDesc) {
		this.sepItRecpSvcArCdDesc = sepItRecpSvcArCdDesc;
	}

	/**
	 * Gets the sep it recp city nm desc.
	 *
	 * @return the sep it recp city nm desc
	 */
	public String getSepItRecpCityNmDesc() {
		return sepItRecpCityNmDesc;
	}

	/**
	 * Sets the sep it recp city nm desc.
	 *
	 * @param sepItRecpCityNmDesc the new sep it recp city nm desc
	 */
	public void setSepItRecpCityNmDesc(String sepItRecpCityNmDesc) {
		this.sepItRecpCityNmDesc = sepItRecpCityNmDesc;
	}

	/**
	 * Gets the sep it recp pstl cd desc.
	 *
	 * @return the sep it recp pstl cd desc
	 */
	public Integer getSepItRecpPstlCdDesc() {
		return sepItRecpPstlCdDesc;
	}

	/**
	 * Sets the sep it recp pstl cd desc.
	 *
	 * @param sepItRecpPstlCdDesc the new sep it recp pstl cd desc
	 */
	public void setSepItRecpPstlCdDesc(Integer sepItRecpPstlCdDesc) {
		this.sepItRecpPstlCdDesc = sepItRecpPstlCdDesc;
	}

	/**
	 * Gets the sep it recp st prov cd desc.
	 *
	 * @return the sep it recp st prov cd desc
	 */
	public String getSepItRecpStProvCdDesc() {
		return sepItRecpStProvCdDesc;
	}

	/**
	 * Sets the sep it recp st prov cd desc.
	 *
	 * @param sepItRecpStProvCdDesc the new sep it recp st prov cd desc
	 */
	public void setSepItRecpStProvCdDesc(String sepItRecpStProvCdDesc) {
		this.sepItRecpStProvCdDesc = sepItRecpStProvCdDesc;
	}

	/**
	 * Gets the sep it recp country cd desc.
	 *
	 * @return the sep it recp country cd desc
	 */
	public String getSepItRecpCountryCdDesc() {
		return sepItRecpCountryCdDesc;
	}

	/**
	 * Sets the sep it recp country cd desc.
	 *
	 * @param sepItRecpCountryCdDesc the new sep it recp country cd desc
	 */
	public void setSepItRecpCountryCdDesc(String sepItRecpCountryCdDesc) {
		this.sepItRecpCountryCdDesc = sepItRecpCountryCdDesc;
	}

	/**
	 * Gets the sep it orig gmt offst min desc.
	 *
	 * @return the sep it orig gmt offst min desc
	 */
	public Integer getSepItOrigGmtOffstMinDesc() {
		return sepItOrigGmtOffstMinDesc;
	}

	/**
	 * Sets the sep it orig gmt offst min desc.
	 *
	 * @param sepItOrigGmtOffstMinDesc the new sep it orig gmt offst min desc
	 */
	public void setSepItOrigGmtOffstMinDesc(Integer sepItOrigGmtOffstMinDesc) {
		this.sepItOrigGmtOffstMinDesc = sepItOrigGmtOffstMinDesc;
	}

	/**
	 * Gets the sep it orig mkt id cd desc.
	 *
	 * @return the sep it orig mkt id cd desc
	 */
	public String getSepItOrigMktIdCdDesc() {
		return sepItOrigMktIdCdDesc;
	}

	/**
	 * Sets the sep it orig mkt id cd desc.
	 *
	 * @param sepItOrigMktIdCdDesc the new sep it orig mkt id cd desc
	 */
	public void setSepItOrigMktIdCdDesc(String sepItOrigMktIdCdDesc) {
		this.sepItOrigMktIdCdDesc = sepItOrigMktIdCdDesc;
	}

	/**
	 * Gets the sep it orig radar mstr loc desc.
	 *
	 * @return the sep it orig radar mstr loc desc
	 */
	public String getSepItOrigRadarMstrLocDesc() {
		return sepItOrigRadarMstrLocDesc;
	}

	/**
	 * Sets the sep it orig radar mstr loc desc.
	 *
	 * @param sepItOrigRadarMstrLocDesc the new sep it orig radar mstr loc desc
	 */
	public void setSepItOrigRadarMstrLocDesc(String sepItOrigRadarMstrLocDesc) {
		this.sepItOrigRadarMstrLocDesc = sepItOrigRadarMstrLocDesc;
	}

	/**
	 * Gets the sep it orig admin loc cd desc.
	 *
	 * @return the sep it orig admin loc cd desc
	 */
	public String getSepItOrigAdminLocCdDesc() {
		return sepItOrigAdminLocCdDesc;
	}

	/**
	 * Sets the sep it orig admin loc cd desc.
	 *
	 * @param sepItOrigAdminLocCdDesc the new sep it orig admin loc cd desc
	 */
	public void setSepItOrigAdminLocCdDesc(String sepItOrigAdminLocCdDesc) {
		this.sepItOrigAdminLocCdDesc = sepItOrigAdminLocCdDesc;
	}

	/**
	 * Gets the sep it orig addr desc desc.
	 *
	 * @return the sep it orig addr desc desc
	 */
	public String getSepItOrigAddrDescDesc() {
		return sepItOrigAddrDescDesc;
	}

	/**
	 * Sets the sep it orig addr desc desc.
	 *
	 * @param sepItOrigAddrDescDesc the new sep it orig addr desc desc
	 */
	public void setSepItOrigAddrDescDesc(String sepItOrigAddrDescDesc) {
		this.sepItOrigAddrDescDesc = sepItOrigAddrDescDesc;
	}

	/**
	 * Gets the sep it orig loc iata cd desc.
	 *
	 * @return the sep it orig loc iata cd desc
	 */
	public String getSepItOrigLocIataCdDesc() {
		return sepItOrigLocIataCdDesc;
	}

	/**
	 * Sets the sep it orig loc iata cd desc.
	 *
	 * @param sepItOrigLocIataCdDesc the new sep it orig loc iata cd desc
	 */
	public void setSepItOrigLocIataCdDesc(String sepItOrigLocIataCdDesc) {
		this.sepItOrigLocIataCdDesc = sepItOrigLocIataCdDesc;
	}

	/**
	 * Gets the sep it orig loc type desc.
	 *
	 * @return the sep it orig loc type desc
	 */
	public String getSepItOrigLocTypeDesc() {
		return sepItOrigLocTypeDesc;
	}

	/**
	 * Sets the sep it orig loc type desc.
	 *
	 * @param sepItOrigLocTypeDesc the new sep it orig loc type desc
	 */
	public void setSepItOrigLocTypeDesc(String sepItOrigLocTypeDesc) {
		this.sepItOrigLocTypeDesc = sepItOrigLocTypeDesc;
	}

	/**
	 * Gets the sep it orig loc cd desc.
	 *
	 * @return the sep it orig loc cd desc
	 */
	public String getSepItOrigLocCdDesc() {
		return sepItOrigLocCdDesc;
	}

	/**
	 * Sets the sep it orig loc cd desc.
	 *
	 * @param sepItOrigLocCdDesc the new sep it orig loc cd desc
	 */
	public void setSepItOrigLocCdDesc(String sepItOrigLocCdDesc) {
		this.sepItOrigLocCdDesc = sepItOrigLocCdDesc;
	}

	/**
	 * Gets the sep it orig svc area cd desc.
	 *
	 * @return the sep it orig svc area cd desc
	 */
	public String getSepItOrigSvcAreaCdDesc() {
		return sepItOrigSvcAreaCdDesc;
	}

	/**
	 * Sets the sep it orig svc area cd desc.
	 *
	 * @param sepItOrigSvcAreaCdDesc the new sep it orig svc area cd desc
	 */
	public void setSepItOrigSvcAreaCdDesc(String sepItOrigSvcAreaCdDesc) {
		this.sepItOrigSvcAreaCdDesc = sepItOrigSvcAreaCdDesc;
	}

	/**
	 * Gets the sep it orig loc city nm desc.
	 *
	 * @return the sep it orig loc city nm desc
	 */
	public String getSepItOrigLocCityNmDesc() {
		return sepItOrigLocCityNmDesc;
	}

	/**
	 * Sets the sep it orig loc city nm desc.
	 *
	 * @param sepItOrigLocCityNmDesc the new sep it orig loc city nm desc
	 */
	public void setSepItOrigLocCityNmDesc(String sepItOrigLocCityNmDesc) {
		this.sepItOrigLocCityNmDesc = sepItOrigLocCityNmDesc;
	}

	/**
	 * Gets the sep it orig pstl cd desc.
	 *
	 * @return the sep it orig pstl cd desc
	 */
	public Integer getSepItOrigPstlCdDesc() {
		return sepItOrigPstlCdDesc;
	}

	/**
	 * Sets the sep it orig pstl cd desc.
	 *
	 * @param sepItOrigPstlCdDesc the new sep it orig pstl cd desc
	 */
	public void setSepItOrigPstlCdDesc(Integer sepItOrigPstlCdDesc) {
		this.sepItOrigPstlCdDesc = sepItOrigPstlCdDesc;
	}

	/**
	 * Gets the sep it orig st prov cd desc.
	 *
	 * @return the sep it orig st prov cd desc
	 */
	public String getSepItOrigStProvCdDesc() {
		return sepItOrigStProvCdDesc;
	}

	/**
	 * Sets the sep it orig st prov cd desc.
	 *
	 * @param sepItOrigStProvCdDesc the new sep it orig st prov cd desc
	 */
	public void setSepItOrigStProvCdDesc(String sepItOrigStProvCdDesc) {
		this.sepItOrigStProvCdDesc = sepItOrigStProvCdDesc;
	}

	/**
	 * Gets the sep it orig cntry cd desc.
	 *
	 * @return the sep it orig cntry cd desc
	 */
	public String getSepItOrigCntryCdDesc() {
		return sepItOrigCntryCdDesc;
	}

	/**
	 * Sets the sep it orig cntry cd desc.
	 *
	 * @param sepItOrigCntryCdDesc the new sep it orig cntry cd desc
	 */
	public void setSepItOrigCntryCdDesc(String sepItOrigCntryCdDesc) {
		this.sepItOrigCntryCdDesc = sepItOrigCntryCdDesc;
	}

	/**
	 * Gets the sep it dest gmt offst min desc.
	 *
	 * @return the sep it dest gmt offst min desc
	 */
	public Integer getSepItDestGmtOffstMinDesc() {
		return sepItDestGmtOffstMinDesc;
	}

	/**
	 * Sets the sep it dest gmt offst min desc.
	 *
	 * @param sepItDestGmtOffstMinDesc the new sep it dest gmt offst min desc
	 */
	public void setSepItDestGmtOffstMinDesc(Integer sepItDestGmtOffstMinDesc) {
		this.sepItDestGmtOffstMinDesc = sepItDestGmtOffstMinDesc;
	}

	/**
	 * Gets the sep it dest mkt id cd desc.
	 *
	 * @return the sep it dest mkt id cd desc
	 */
	public String getSepItDestMktIdCdDesc() {
		return sepItDestMktIdCdDesc;
	}

	/**
	 * Sets the sep it dest mkt id cd desc.
	 *
	 * @param sepItDestMktIdCdDesc the new sep it dest mkt id cd desc
	 */
	public void setSepItDestMktIdCdDesc(String sepItDestMktIdCdDesc) {
		this.sepItDestMktIdCdDesc = sepItDestMktIdCdDesc;
	}

	/**
	 * Gets the sep it dest radar mstr loc desc.
	 *
	 * @return the sep it dest radar mstr loc desc
	 */
	public String getSepItDestRadarMstrLocDesc() {
		return sepItDestRadarMstrLocDesc;
	}

	/**
	 * Sets the sep it dest radar mstr loc desc.
	 *
	 * @param sepItDestRadarMstrLocDesc the new sep it dest radar mstr loc desc
	 */
	public void setSepItDestRadarMstrLocDesc(String sepItDestRadarMstrLocDesc) {
		this.sepItDestRadarMstrLocDesc = sepItDestRadarMstrLocDesc;
	}

	/**
	 * Gets the sep it dest admin loc cd desc.
	 *
	 * @return the sep it dest admin loc cd desc
	 */
	public String getSepItDestAdminLocCdDesc() {
		return sepItDestAdminLocCdDesc;
	}

	/**
	 * Sets the sep it dest admin loc cd desc.
	 *
	 * @param sepItDestAdminLocCdDesc the new sep it dest admin loc cd desc
	 */
	public void setSepItDestAdminLocCdDesc(String sepItDestAdminLocCdDesc) {
		this.sepItDestAdminLocCdDesc = sepItDestAdminLocCdDesc;
	}

	/**
	 * Gets the sep it dest addr desc desc.
	 *
	 * @return the sep it dest addr desc desc
	 */
	public String getSepItDestAddrDescDesc() {
		return sepItDestAddrDescDesc;
	}

	/**
	 * Sets the sep it dest addr desc desc.
	 *
	 * @param sepItDestAddrDescDesc the new sep it dest addr desc desc
	 */
	public void setSepItDestAddrDescDesc(String sepItDestAddrDescDesc) {
		this.sepItDestAddrDescDesc = sepItDestAddrDescDesc;
	}

	/**
	 * Gets the sep it dest loc iata cd desc.
	 *
	 * @return the sep it dest loc iata cd desc
	 */
	public String getSepItDestLocIataCdDesc() {
		return sepItDestLocIataCdDesc;
	}

	/**
	 * Sets the sep it dest loc iata cd desc.
	 *
	 * @param sepItDestLocIataCdDesc the new sep it dest loc iata cd desc
	 */
	public void setSepItDestLocIataCdDesc(String sepItDestLocIataCdDesc) {
		this.sepItDestLocIataCdDesc = sepItDestLocIataCdDesc;
	}

	/**
	 * Gets the sep it dest loc type desc.
	 *
	 * @return the sep it dest loc type desc
	 */
	public String getSepItDestLocTypeDesc() {
		return sepItDestLocTypeDesc;
	}

	/**
	 * Sets the sep it dest loc type desc.
	 *
	 * @param sepItDestLocTypeDesc the new sep it dest loc type desc
	 */
	public void setSepItDestLocTypeDesc(String sepItDestLocTypeDesc) {
		this.sepItDestLocTypeDesc = sepItDestLocTypeDesc;
	}

	/**
	 * Gets the sep it dest loc cd desc.
	 *
	 * @return the sep it dest loc cd desc
	 */
	public String getSepItDestLocCdDesc() {
		return sepItDestLocCdDesc;
	}

	/**
	 * Sets the sep it dest loc cd desc.
	 *
	 * @param sepItDestLocCdDesc the new sep it dest loc cd desc
	 */
	public void setSepItDestLocCdDesc(String sepItDestLocCdDesc) {
		this.sepItDestLocCdDesc = sepItDestLocCdDesc;
	}

	/**
	 * Gets the sep it dom dest svc area cd desc.
	 *
	 * @return the sep it dom dest svc area cd desc
	 */
	public String getSepItDomDestSvcAreaCdDesc() {
		return sepItDomDestSvcAreaCdDesc;
	}

	/**
	 * Sets the sep it dom dest svc area cd desc.
	 *
	 * @param sepItDomDestSvcAreaCdDesc the new sep it dom dest svc area cd desc
	 */
	public void setSepItDomDestSvcAreaCdDesc(String sepItDomDestSvcAreaCdDesc) {
		this.sepItDomDestSvcAreaCdDesc = sepItDomDestSvcAreaCdDesc;
	}

	/**
	 * Gets the sep it dest loc city nm desc.
	 *
	 * @return the sep it dest loc city nm desc
	 */
	public String getSepItDestLocCityNmDesc() {
		return sepItDestLocCityNmDesc;
	}

	/**
	 * Sets the sep it dest loc city nm desc.
	 *
	 * @param sepItDestLocCityNmDesc the new sep it dest loc city nm desc
	 */
	public void setSepItDestLocCityNmDesc(String sepItDestLocCityNmDesc) {
		this.sepItDestLocCityNmDesc = sepItDestLocCityNmDesc;
	}

	/**
	 * Gets the sep it dest pstl cd desc.
	 *
	 * @return the sep it dest pstl cd desc
	 */
	public Integer getSepItDestPstlCdDesc() {
		return sepItDestPstlCdDesc;
	}

	/**
	 * Sets the sep it dest pstl cd desc.
	 *
	 * @param sepItDestPstlCdDesc the new sep it dest pstl cd desc
	 */
	public void setSepItDestPstlCdDesc(Integer sepItDestPstlCdDesc) {
		this.sepItDestPstlCdDesc = sepItDestPstlCdDesc;
	}

	/**
	 * Gets the sep it dest st prov cd desc.
	 *
	 * @return the sep it dest st prov cd desc
	 */
	public String getSepItDestStProvCdDesc() {
		return sepItDestStProvCdDesc;
	}

	/**
	 * Sets the sep it dest st prov cd desc.
	 *
	 * @param sepItDestStProvCdDesc the new sep it dest st prov cd desc
	 */
	public void setSepItDestStProvCdDesc(String sepItDestStProvCdDesc) {
		this.sepItDestStProvCdDesc = sepItDestStProvCdDesc;
	}

	/**
	 * Gets the sep it dest cntry cd desc.
	 *
	 * @return the sep it dest cntry cd desc
	 */
	public String getSepItDestCntryCdDesc() {
		return sepItDestCntryCdDesc;
	}

	/**
	 * Sets the sep it dest cntry cd desc.
	 *
	 * @param sepItDestCntryCdDesc the new sep it dest cntry cd desc
	 */
	public void setSepItDestCntryCdDesc(String sepItDestCntryCdDesc) {
		this.sepItDestCntryCdDesc = sepItDestCntryCdDesc;
	}

	/**
	 * Gets the dim wgt.
	 *
	 * @return the dim wgt
	 */
	public String getDimWgt() {
		return dimWgt;
	}

	/**
	 * Sets the dim wgt.
	 *
	 * @param dimWgt the new dim wgt
	 */
	public void setDimWgt(String dimWgt) {
		this.dimWgt = dimWgt;
	}

	/**
	 * Gets the unit dim wgt.
	 *
	 * @return the unit dim wgt
	 */
	public String getUnitDimWgt() {
		return unitDimWgt;
	}

	/**
	 * Sets the unit dim wgt.
	 *
	 * @param unitDimWgt the new unit dim wgt
	 */
	public void setUnitDimWgt(String unitDimWgt) {
		this.unitDimWgt = unitDimWgt;
	}

	/**
	 * Gets the final itm rate.
	 *
	 * @return the final itm rate
	 */
	public String getFinalItmRate() {
		return finalItmRate;
	}

	/**
	 * Sets the final itm rate.
	 *
	 * @param finalItmRate the new final itm rate
	 */
	public void setFinalItmRate(String finalItmRate) {
		this.finalItmRate = finalItmRate;
	}

	/**
	 * Gets the commitment date.
	 *
	 * @return the commitment date
	 */
	public Timestamp getCommitmentDate() {
		return commitmentDate;
	}

	/**
	 * Sets the commitment date.
	 *
	 * @param commitmentDate the new commitment date
	 */
	public void setCommitmentDate(Timestamp commitmentDate) {
		this.commitmentDate = commitmentDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AwbShpmtDetails [isqnCd=" + isqnCd + ", awbCustMaster=" + awbCustMaster + ", shipperAcctNbr="
				+ shipperAcctNbr + ", awbNbr=" + awbNbr + ", barcdDesc=" + barcdDesc + ", barcdStateCd=" + barcdStateCd
				+ ", barcdSymbologyCd=" + barcdSymbologyCd + ", baseServiceCd=" + baseServiceCd
				+ ", baseServiceOfferingId=" + baseServiceOfferingId + ", billToAcctNbr=" + billToAcctNbr
				+ ", carrierCompCd=" + carrierCompCd + ", codPayableDesc=" + codPayableDesc + ", contractDeleteFlg="
				+ contractDeleteFlg + ", createDt=" + createDt + ", modfyDt=" + modfyDt + ", destLocCd=" + destLocCd
				+ ", doc1ReqrdTypeCd=" + doc1ReqrdTypeCd + ", doc2ReqrdTypeCd=" + doc2ReqrdTypeCd + ", dvCurrCd="
				+ dvCurrCd + ", dvcId=" + dvcId + ", dvcTypeTxt=" + dvcTypeTxt + ", evntCrtnTmstp=" + evntCrtnTmstp
				+ ", evntSqncNbr=" + evntSqncNbr + ", evntSysNm=" + evntSysNm + ", exptContrTypeCd=" + exptContrTypeCd
				+ ", exptFileStatCd=" + exptFileStatCd + ", keyDesc=" + keyDesc + ", msgTcAdtGrpMsgHashDesc="
				+ msgTcAdtGrpMsgHashDesc + ", msgTcAdtGrpMsgPosDesc=" + msgTcAdtGrpMsgPosDesc
				+ ", msg1TcAdtGrpEvntCeTmstp=" + msg1TcAdtGrpEvntCeTmstp + ", msg2TcAdtGrpEvntCeTmstp="
				+ msg2TcAdtGrpEvntCeTmstp + ", msg1TcAdtGrpTrceSysNm=" + msg1TcAdtGrpTrceSysNm
				+ ", msg2TcAdtGrpTrceSysNm=" + msg2TcAdtGrpTrceSysNm + ", msg3TcAdtGrpTrceSysNm="
				+ msg3TcAdtGrpTrceSysNm + ", msgVerNbr=" + msgVerNbr + ", notesGrpLineNbr=" + notesGrpLineNbr
				+ ", notesGrpRefTypeCd=" + notesGrpRefTypeCd + ", notesRefShprGrp=" + notesRefShprGrp
				+ ", notifFormatCd=" + notifFormatCd + ", originLocationCd=" + originLocationCd + ", packOffrgId="
				+ packOffrgId + ", packTypeId=" + packTypeId + ", pckupStopTypeTxt=" + pckupStopTypeTxt + ", pkgDvNbr="
				+ pkgDvNbr + ", pkgWgt=" + pkgWgt + ", uomPkgWgt=" + uomPkgWgt + ", ptyReltdFlg=" + ptyReltdFlg
				+ ", pymtMthdCd=" + pymtMthdCd + ", pymtPayorCd=" + pymtPayorCd + ", routeLocCd=" + routeLocCd
				+ ", shpmtDvId=" + shpmtDvId + ", sftwrVerId=" + sftwrVerId + ", shipmentDate=" + shipmentDate
				+ ", shpmtDecvalCurrCd=" + shpmtDecvalCurrCd + ", shpmtLblCoTxt=" + shpmtLblCoTxt + ", shpmtPkgCntNbr="
				+ shpmtPkgCntNbr + ", shpmtPkgNbr=" + shpmtPkgNbr + ", shpmtPrpsTxt=" + shpmtPrpsTxt + ", shpmtWgt="
				+ shpmtWgt + ", shpmtWtUomId=" + shpmtWtUomId + ", totShpmtValueNbr=" + totShpmtValueNbr
				+ ", trakGmtPostTm=" + trakGmtPostTm + ", trakScnTm=" + trakScnTm + ", trakTypId=" + trakTypId
				+ ", trakDt=" + trakDt + ", trakGmtPostDt=" + trakGmtPostDt + ", trkngItmFormCd=" + trkngItmFormCd
				+ ", ursaCd=" + ursaCd + ", valDesc=" + valDesc + ", sepGmtPostTmstp=" + sepGmtPostTmstp
				+ ", sepItFldSetFlg=" + sepItFldSetFlg + ", sepItGmtOffstMinDesc=" + sepItGmtOffstMinDesc
				+ ", sepItEaMatchScoreDesc=" + sepItEaMatchScoreDesc + ", sepItScanHashValDesc=" + sepItScanHashValDesc
				+ ", sepItSvcAreaCdDesc=" + sepItSvcAreaCdDesc + ", sepItRecpAdminLocCdDesc=" + sepItRecpAdminLocCdDesc
				+ ", sepItRecpIataCdDesc=" + sepItRecpIataCdDesc + ", sepItRecpLocTypeCdDesc=" + sepItRecpLocTypeCdDesc
				+ ", sepItRecpLocCdDesc=" + sepItRecpLocCdDesc + ", sepItDomRecpSvcArCdDesc=" + sepItDomRecpSvcArCdDesc
				+ ", sepItRecpSvcArCdDesc=" + sepItRecpSvcArCdDesc + ", sepItRecpCityNmDesc=" + sepItRecpCityNmDesc
				+ ", sepItRecpPstlCdDesc=" + sepItRecpPstlCdDesc + ", sepItRecpStProvCdDesc=" + sepItRecpStProvCdDesc
				+ ", sepItRecpCountryCdDesc=" + sepItRecpCountryCdDesc + ", sepItOrigGmtOffstMinDesc="
				+ sepItOrigGmtOffstMinDesc + ", sepItOrigMktIdCdDesc=" + sepItOrigMktIdCdDesc
				+ ", sepItOrigRadarMstrLocDesc=" + sepItOrigRadarMstrLocDesc + ", sepItOrigAdminLocCdDesc="
				+ sepItOrigAdminLocCdDesc + ", sepItOrigAddrDescDesc=" + sepItOrigAddrDescDesc
				+ ", sepItOrigLocIataCdDesc=" + sepItOrigLocIataCdDesc + ", sepItOrigLocTypeDesc="
				+ sepItOrigLocTypeDesc + ", sepItOrigLocCdDesc=" + sepItOrigLocCdDesc + ", sepItOrigSvcAreaCdDesc="
				+ sepItOrigSvcAreaCdDesc + ", sepItOrigLocCityNmDesc=" + sepItOrigLocCityNmDesc
				+ ", sepItOrigPstlCdDesc=" + sepItOrigPstlCdDesc + ", sepItOrigStProvCdDesc=" + sepItOrigStProvCdDesc
				+ ", sepItOrigCntryCdDesc=" + sepItOrigCntryCdDesc + ", sepItDestGmtOffstMinDesc="
				+ sepItDestGmtOffstMinDesc + ", sepItDestMktIdCdDesc=" + sepItDestMktIdCdDesc
				+ ", sepItDestRadarMstrLocDesc=" + sepItDestRadarMstrLocDesc + ", sepItDestAdminLocCdDesc="
				+ sepItDestAdminLocCdDesc + ", sepItDestAddrDescDesc=" + sepItDestAddrDescDesc
				+ ", sepItDestLocIataCdDesc=" + sepItDestLocIataCdDesc + ", sepItDestLocTypeDesc="
				+ sepItDestLocTypeDesc + ", sepItDestLocCdDesc=" + sepItDestLocCdDesc + ", sepItDomDestSvcAreaCdDesc="
				+ sepItDomDestSvcAreaCdDesc + ", sepItDestLocCityNmDesc=" + sepItDestLocCityNmDesc
				+ ", sepItDestPstlCdDesc=" + sepItDestPstlCdDesc + ", sepItDestStProvCdDesc=" + sepItDestStProvCdDesc
				+ ", sepItDestCntryCdDesc=" + sepItDestCntryCdDesc + ", dimWgt=" + dimWgt + ", unitDimWgt=" + unitDimWgt
				+ ", finalItmRate=" + finalItmRate + "]";
	}

}
