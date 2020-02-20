package com.fedex.breco.insurance.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.fedex.breco.insurance.model.InsuranceExportModel;
import com.fedex.breco.insurance.model.InsuranceIssuanceModel;

import lombok.Getter;
import lombok.Setter;


// TODO: Auto-generated Javadoc
/**
 * The Class MatchReference.
 */
@Entity
@Table(name = "MATCH_REF_MASTER")

@SqlResultSetMappings({@SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt")),
	@SqlResultSetMapping(name="allInsuranceDetailsMapping", classes = { @ConstructorResult(targetClass = InsuranceIssuanceModel.class,
	columns = { @ColumnResult(name="destnationLocId") , @ColumnResult(name="cteNfseNumber") ,@ColumnResult(name="protocolNbr"),
				@ColumnResult(name="createdDate", type = java.util.Date.class), @ColumnResult(name="status"), @ColumnResult(name="docType"),  @ColumnResult(name="cteNfseCd"),  @ColumnResult(name="msterMatchRefernceId")})})})

@NamedNativeQueries({@NamedNativeQuery(name="MatchReference.getAllInsuranceDetails",resultSetMapping="allInsuranceDetailsMapping", 
	query="select  C.CT_E_CD as cteNfseCd , A.DEST_LOC_CD as destnationLocId, CRD.CT_E_NBR as cteNfseNumber, I.PROTO_NBR as protocolNbr," + 
			" I.CREATE_DT as createdDate, I.INS_RESP_STAT_CD as status, mr.DOC_TYP_ID as docType, mr.isqn_mstr_cd as msterMatchRefernceId " + 
			"  from match_ref_master mr" + 
			"  inner join match_ref_awb mawb on mr.isqn_mstr_cd = mawb.isqn_mstr_cd" + 
			"  inner join awb_cust_master awb ON (mawb.awb_nbr = awb.awb_nbr) " + 
			"  inner join awb_shipment_detail A ON (awb.isqn_mstr_cd = A.isqn_mstr_cd)" + 
			"  inner join match_ref_nfe mnfe on mr.isqn_mstr_cd = mnfe.isqn_mstr_cd " + 
			" INNER JOIN NFE_IDENTITY_MASTER NIM ON mnfe.NT_FSCL_CD = NIM.NT_FSCL_CD  " + 
			" INNER JOIN NFE_PROD_TOTAL_INFO NPT ON NIM.ISQN_MSTR_CD = NPT.ISQN_MSTR_CD " + 
			" INNER JOIN CTE_IDENTITY_MASTER C ON mr.ISQN_MSTR_CD=C.ISQN_REF_CD  " + 
			"INNER JOIN CTE_RESPONSE_DETAIL CRD ON C.ISQN_MSTR_CD = CRD.ISQN_MSTR_CD  " + 
			"INNER JOIN CTE_PARTICIPANT_DETAIL P  ON C.ISQN_MSTR_CD = P.ISQN_MSTR_CD  " + 
			"LEFT JOIN INSURANCE_RESPONSE_INFO I ON C.CT_E_CD =I.CT_E_CD " + 
			" WHERE (CRD.STAT_DESC = 'Approved' or CRD.STAT_DESC = 'Cancelled')  " + 
			" and (:AWB_NBR is null or A.AWB_NBR like '%'||(:AWB_NBR)||'%')  " + 
			" and (:ORIGIN_LOCATION_CD is null or lower(SUBSTR(A.ORIGIN_LOCATION_CD, 1, 3)) = lower(substr(:ORIGIN_LOCATION_CD,1,3)) ) " + 
			" and (:CREATE_START_DT is null or :CREATE_END_DT is null or to_char(I.CREATE_DT, 'MM/DD/YYYY') between :CREATE_START_DT and :CREATE_END_DT) " + 
			" and (:DEST_LOC_CD is null or upper(A.DEST_LOC_CD) like '%'||upper(:DEST_LOC_CD)||'%')  " + 
			" and (:CTE_NFSE_CD is null or CRD.CT_E_NBR like '%'||(:CTE_NFSE_CD) ||'%') " + 
			" and (:PROTO_NBR is null or upper(I.PROTO_NBR) like '%'||upper(:PROTO_NBR)||'%') " + 
			" and (:DOC_TYP_ID is null or Mr.DOC_TYP_ID like '%'||(:DOC_TYP_ID)||'%') " + 
			" and (:INS_RESP_STAT_CD is null or upper(I.INS_RESP_STAT_CD) like '%'|| upper(:INS_RESP_STAT_CD)||'%') " + 
			" group by mr.isqn_mstr_cd,C.CT_E_CD, CRD.CT_E_NBR, I.PROTO_NBR,  I.CREATE_DT,  I.INS_RESP_STAT_CD, mr.DOC_TYP_ID, A.DEST_LOC_CD" + 
			" union " +
			" SELECT NRD.RP_S_ID as cteNfseCd , A.DEST_LOC_CD as destnationLocId, NRD.RP_S_ID as cteNfseNumber,I.PROTO_NBR as protocolNbr,I.CREATE_DT as createdDate," +
			" I.INS_RESP_STAT_CD as status,Mr.DOC_TYP_ID as docType, mr.isqn_mstr_cd as msterMatchRefernceId  " + 
			" from match_ref_master mr" + 
			"  inner join match_ref_awb mawb on mr.isqn_mstr_cd = mawb.isqn_mstr_cd " + 
			"  inner join awb_cust_master awb ON (mawb.awb_nbr = awb.awb_nbr) " + 
			"  inner join awb_shipment_detail A ON (awb.isqn_mstr_cd = A.isqn_mstr_cd) " + 
			"  inner join match_ref_nfe mnfe on mr.isqn_mstr_cd = mnfe.isqn_mstr_cd " + 
			" INNER JOIN NFE_IDENTITY_MASTER NIM ON mnfe.NT_FSCL_CD = NIM.NT_FSCL_CD  " + 
			" INNER JOIN NFE_PARTICIPANT_DETAIL NPE  ON NIM.ISQN_MSTR_CD = NPE.ISQN_MSTR_CD " + 
			" INNER JOIN NFE_PROD_TOTAL_INFO NPT ON NIM.ISQN_MSTR_CD = NPT.ISQN_MSTR_CD " + 
			" INNER JOIN NFSE_REQUEST_DETAIL N ON Mr.ISQN_MSTR_CD=N.ISQN_REF_CD    " + 
			" INNER JOIN NFSE_RESPONSE_DETAIL NRD ON N.ISQN_MSTR_CD = NRD.ISQN_MSTR_CD  " + 
			" LEFT JOIN INSURANCE_RESPONSE_INFO I ON NRD.RP_S_ID=I.NF_SE_CD " + 
			" WHERE (NRD.STAT_DESC = 'Approved' or NRD.STAT_DESC = 'Cancelled')  " + 
			"  and (:AWB_NBR is null or A.AWB_NBR like '%'||(:AWB_NBR)||'%')  " + 
			"  and (:ORIGIN_LOCATION_CD is null or lower(SUBSTR(A.ORIGIN_LOCATION_CD, 1, 3)) = lower(substr(:ORIGIN_LOCATION_CD,1,3)) ) " + 
			"  and (:CREATE_START_DT is null or :CREATE_END_DT is null or to_char(I.CREATE_DT, 'MM/DD/YYYY') between :CREATE_START_DT and :CREATE_END_DT) " + 
			"  and (:DEST_LOC_CD is null or upper(A.DEST_LOC_CD) like '%'||upper(:DEST_LOC_CD)||'%')  " + 
			"  and (:CTE_NFSE_CD is null or NRD.RP_S_ID like '%'||(:CTE_NFSE_CD)||'%') " + 
			"  and (:PROTO_NBR is null or upper(I.PROTO_NBR) like '%'||upper(:PROTO_NBR)||'%') " + 
			"  and (:DOC_TYP_ID is null or Mr.DOC_TYP_ID like '%'||(:DOC_TYP_ID)||'%') " + 
			"  and (:INS_RESP_STAT_CD is null or upper(I.INS_RESP_STAT_CD) like '%'|| upper(:INS_RESP_STAT_CD)||'%') " + 
			"group by mr.isqn_mstr_cd,NRD.RP_S_ID, I.PROTO_NBR,  I.CREATE_DT,  I.INS_RESP_STAT_CD, mr.DOC_TYP_ID, A.DEST_LOC_CD"),
	@NamedNativeQuery(name="MatchReference.getAllInsuranceDetails.count",resultSetMapping = "SqlResultSetMapping.count",
			query="select count(*) as cnt from (select  C.CT_E_CD as cteNfseCd , A.DEST_LOC_CD as destnationLocId, CRD.CT_E_NBR as cteNfseNumber, I.PROTO_NBR as protocolNbr," + 
					" I.CREATE_DT as createdDate, I.INS_RESP_STAT_CD as status, mr.DOC_TYP_ID as docType, mr.isqn_mstr_cd as msterMatchRefernceId " + 
					"  from match_ref_master mr" + 
					"  inner join match_ref_awb mawb on mr.isqn_mstr_cd = mawb.isqn_mstr_cd" + 
					"  inner join awb_cust_master awb ON (mawb.awb_nbr = awb.awb_nbr) " + 
					"  inner join awb_shipment_detail A ON (awb.isqn_mstr_cd = A.isqn_mstr_cd)" + 
					"  inner join match_ref_nfe mnfe on mr.isqn_mstr_cd = mnfe.isqn_mstr_cd " + 
					" INNER JOIN NFE_IDENTITY_MASTER NIM ON mnfe.NT_FSCL_CD = NIM.NT_FSCL_CD  " + 
					" INNER JOIN NFE_PROD_TOTAL_INFO NPT ON NIM.ISQN_MSTR_CD = NPT.ISQN_MSTR_CD " + 
					" INNER JOIN CTE_IDENTITY_MASTER C ON mr.ISQN_MSTR_CD=C.ISQN_REF_CD  " + 
					"INNER JOIN CTE_RESPONSE_DETAIL CRD ON C.ISQN_MSTR_CD = CRD.ISQN_MSTR_CD  " + 
					"INNER JOIN CTE_PARTICIPANT_DETAIL P  ON C.ISQN_MSTR_CD = P.ISQN_MSTR_CD  " + 
					"LEFT JOIN INSURANCE_RESPONSE_INFO I ON C.CT_E_CD =I.CT_E_CD " + 
					" WHERE (CRD.STAT_DESC = 'Approved' or CRD.STAT_DESC = 'Cancelled')  " + 
					" and (:AWB_NBR is null or A.AWB_NBR like '%'||(:AWB_NBR)||'%')  " + 
					" and (:ORIGIN_LOCATION_CD is null or lower(SUBSTR(A.ORIGIN_LOCATION_CD, 1, 3)) = lower(substr(:ORIGIN_LOCATION_CD,1,3)) ) " + 
					" and (:CREATE_START_DT is null or :CREATE_END_DT is null or to_char(I.CREATE_DT, 'MM/DD/YYYY') between :CREATE_START_DT and :CREATE_END_DT) " + 
					" and (:DEST_LOC_CD is null or upper(A.DEST_LOC_CD) like '%'||upper(:DEST_LOC_CD)||'%')  " + 
					" and (:CTE_NFSE_CD is null or CRD.CT_E_NBR like '%'||(:CTE_NFSE_CD) ||'%') " + 
					" and (:PROTO_NBR is null or upper(I.PROTO_NBR) like '%'||upper(:PROTO_NBR)||'%') " + 
					" and (:DOC_TYP_ID is null or Mr.DOC_TYP_ID like '%'||(:DOC_TYP_ID)||'%') " + 
					" and (:INS_RESP_STAT_CD is null or upper(I.INS_RESP_STAT_CD) like '%'||upper(:INS_RESP_STAT_CD)||'%') " + 
					" group by mr.isqn_mstr_cd,C.CT_E_CD, CRD.CT_E_NBR, I.PROTO_NBR,  I.CREATE_DT,  I.INS_RESP_STAT_CD, mr.DOC_TYP_ID,A.DEST_LOC_CD " +
					" union " +
					" SELECT NRD.RP_S_ID as cteNfseCd , A.DEST_LOC_CD as destnationLocId, NRD.RP_S_ID as cteNfseNumber,I.PROTO_NBR as protocolNbr,I.CREATE_DT as createdDate,I.INS_RESP_STAT_CD as status,Mr.DOC_TYP_ID as docType, mr.isqn_mstr_cd as msterMatchRefernceId  " + 
					"from match_ref_master mr " + 
					"  inner join match_ref_awb mawb on mr.isqn_mstr_cd = mawb.isqn_mstr_cd " + 
					"  inner join awb_cust_master awb ON (mawb.awb_nbr = awb.awb_nbr) " + 
					"  inner join awb_shipment_detail A ON (awb.isqn_mstr_cd = A.isqn_mstr_cd) " + 
					"  inner join match_ref_nfe mnfe on mr.isqn_mstr_cd = mnfe.isqn_mstr_cd " + 
					" INNER JOIN NFE_IDENTITY_MASTER NIM ON mnfe.NT_FSCL_CD = NIM.NT_FSCL_CD  " + 
					" INNER JOIN NFE_PARTICIPANT_DETAIL NPE  ON NIM.ISQN_MSTR_CD = NPE.ISQN_MSTR_CD " + 
					" INNER JOIN NFE_PROD_TOTAL_INFO NPT ON NIM.ISQN_MSTR_CD = NPT.ISQN_MSTR_CD " + 
					" INNER JOIN NFSE_REQUEST_DETAIL N ON Mr.ISQN_MSTR_CD=N.ISQN_REF_CD    " + 
					" INNER JOIN NFSE_RESPONSE_DETAIL NRD ON N.ISQN_MSTR_CD = NRD.ISQN_MSTR_CD  " + 
					" LEFT JOIN INSURANCE_RESPONSE_INFO I ON NRD.RP_S_ID=I.NF_SE_CD " + 
					" WHERE (NRD.STAT_DESC = 'Approved' or NRD.STAT_DESC = 'Cancelled')  " + 
					"  and (:AWB_NBR is null or A.AWB_NBR like '%'||(:AWB_NBR)||'%')  " + 
					"  and (:ORIGIN_LOCATION_CD is null or lower(SUBSTR(A.ORIGIN_LOCATION_CD, 1, 3)) = lower(substr(:ORIGIN_LOCATION_CD,1,3)) ) " + 
					"  and (:CREATE_START_DT is null or :CREATE_END_DT is null or to_char(I.CREATE_DT, 'MM/DD/YYYY') between :CREATE_START_DT and :CREATE_END_DT) " + 
					"  and (:DEST_LOC_CD is null or upper(A.DEST_LOC_CD) like '%'||upper(:DEST_LOC_CD)||'%')  " + 
					"  and (:CTE_NFSE_CD is null or NRD.RP_S_ID like '%'||(:CTE_NFSE_CD)||'%') " + 
					"  and (:PROTO_NBR is null or upper(I.PROTO_NBR) like '%'||upper(:PROTO_NBR)||'%') " + 
					"  and (:DOC_TYP_ID is null or Mr.DOC_TYP_ID like '%'||(:DOC_TYP_ID)||'%') " + 
					"  and (:INS_RESP_STAT_CD is null or upper(I.INS_RESP_STAT_CD) like '%'||upper(:INS_RESP_STAT_CD)||'%') " + 
					" group by mr.isqn_mstr_cd,NRD.RP_S_ID, I.PROTO_NBR,  I.CREATE_DT,  I.INS_RESP_STAT_CD, mr.DOC_TYP_ID,A.DEST_LOC_CD)" )
	})


@SqlResultSetMapping(name="exportCTeInsurance", classes = { @ConstructorResult(targetClass = InsuranceExportModel.class,
columns = {@ColumnResult(name="cteNfseNumber"), @ColumnResult(name="commodityValue") ,@ColumnResult(name="transportType"), @ColumnResult(name="issueDate") ,@ColumnResult(name="cnpj"),
			@ColumnResult(name="company"), @ColumnResult(name="document"), @ColumnResult(name="sourceFU"), @ColumnResult(name="destinationState") ,@ColumnResult(name="sefazProtocol"),
			@ColumnResult(name="sefazStatus"), @ColumnResult(name="atnProtocol"),  @ColumnResult(name="errorMsg"), @ColumnResult(name="atnMPublicProtocol"),
			 @ColumnResult(name="civilResponsibility"), @ColumnResult(name="packageLost"), @ColumnResult(name="atnMPublicProtocolCreatedDate"), @ColumnResult(name="atnProtocolCreatedDate")})})
@NamedNativeQuery(name="MatchReference.exportCTeInsurance", resultSetMapping="exportCTeInsurance", 
	query="SELECT CRD.CT_E_NBR as cteNfseNumber, 'CTe' as document,  A.ORIGIN_LOCATION_CD as sourceFU, A.DEST_LOC_CD as destinationState, " + 
					" C.CT_E_ISSUE_DT as issueDate,  to_char(CPD2.CRGO_TOT_VAL_NBR) as commodityValue, 'Ground' as transportType,   I.PAYR_TAX_ID as cnpj, " +
					" case when C.SVC_PAY_RSPBL_PRSN_CD = '0' then P.SNDR_CORP_NM when C.SVC_PAY_RSPBL_PRSN_CD = '1' then P.RECP_CORP_NM ELSE 'others' END as company , " + 
					" C.CT_E_CD as sefazProtocol, CRD.STAT_DESC as sefazStatus, " +
					" CRD.PROTO_NBR as atnProtocol, I.ERR_CMPLM_INFO_DESC as errorMsg, I.PROTO_NBR as atnMPublicProtocol, I.CREATE_DT as atnMPublicProtocolCreatedDate, " + 
					" ICI.CA_LY_RD_FGT_FRWDR_DESC as civilResponsibility, ICI.CA_LY_CG_THFT_DISP_DESC as packageLost, CRD.CT_E_CRTN_DT as atnProtocolCreatedDate " + 
		 " from match_ref_master mr" + 
		 " inner join match_ref_awb mawb on mr.isqn_mstr_cd = mawb.isqn_mstr_cd  " + 
		 " inner join awb_cust_master awb ON (mawb.awb_nbr = awb.awb_nbr)   " + 
		 " inner join awb_shipment_detail A ON (awb.isqn_mstr_cd = A.isqn_mstr_cd)  " + 
		 " inner join match_ref_nfe mnfe on mr.isqn_mstr_cd = mnfe.isqn_mstr_cd  " +
		  " INNER JOIN NFE_IDENTITY_MASTER NIM ON mnfe.NT_FSCL_CD = NIM.NT_FSCL_CD " + 
		  " INNER JOIN NFE_PROD_TOTAL_INFO NPT ON NIM.ISQN_MSTR_CD = NPT.ISQN_MSTR_CD " +
		  " INNER JOIN CTE_IDENTITY_MASTER C ON mr.ISQN_MSTR_CD=C.ISQN_REF_CD " + 
		  " INNER JOIN CTE_RESPONSE_DETAIL CRD ON C.ISQN_MSTR_CD = CRD.ISQN_MSTR_CD " + 
		  " INNER JOIN CTE_PARTICIPANT_DETAIL P  ON C.ISQN_MSTR_CD = P.ISQN_MSTR_CD " + 
		  " INNER JOIN CTE_PRODUCT_DETAIL CPD2  ON C.ISQN_MSTR_CD = CPD2.ISQN_MSTR_CD " +
		  "  LEFT JOIN INSURANCE_RESPONSE_INFO I ON (C.CT_E_CD =I.CT_E_CD) " + 
		  "  LEFT JOIN INSURANCE_CUST_INFO ICI ON I.PAYR_TAX_ID = ICI.TAX_ID" + 
		  " WHERE (:AWB_NBR is null or A.AWB_NBR like '%'||(:AWB_NBR)||'%') " + 
		  "   and (CRD.STAT_DESC = 'Approved' or CRD.STAT_DESC = 'Cancelled') " + 
//		  "   and I.INS_RESP_STAT_CD = 'ENDORSED' " +
		  "   and (:ORIGIN_LOCATION_CD is null or lower(SUBSTR(A.ORIGIN_LOCATION_CD, 1, 3)) = lower(substr(:ORIGIN_LOCATION_CD,1,3)) ) " + 
	      "and (:CREATE_START_DT is null or :CREATE_END_DT is null or to_char(I.CREATE_DT, 'MM/DD/YYYY') between :CREATE_START_DT and :CREATE_END_DT) " +
		  "   and (:DEST_LOC_CD is null or upper(A.DEST_LOC_CD) like '%'||upper(:DEST_LOC_CD)||'%') " + 
		  "   and (:CTE_NFSE_CD is null or C.CT_E_CD like '%'||(:CTE_NFSE_CD) ||'%') " + 
		  "   and (:PROTO_NBR is null or upper(I.PROTO_NBR) like '%'||upper((:PROTO_NBR)||'%')) " + 
		  "   and (:DOC_TYP_ID is null or MR.DOC_TYP_ID like '%'||(:DOC_TYP_ID)||'%') " + 
		  "   and (:INS_RESP_STAT_CD is null or upper(I.INS_RESP_STAT_CD) like '%'||upper(:INS_RESP_STAT_CD)||'%')" +
		  " group by CRD.CT_E_NBR, A.ORIGIN_LOCATION_CD, A.DEST_LOC_CD, C.CT_E_ISSUE_DT,  CPD2.CRGO_TOT_VAL_NBR, I.PAYR_TAX_ID, C.SVC_PAY_RSPBL_PRSN_CD, P.SNDR_CORP_NM, C.SVC_PAY_RSPBL_PRSN_CD,P.RECP_CORP_NM, " + 
		  "C.CT_E_CD, CRD.STAT_DESC, CRD.PROTO_NBR, I.ERR_CMPLM_INFO_DESC, I.PROTO_NBR,I.CREATE_DT, ICI.CA_LY_RD_FGT_FRWDR_DESC,ICI.CA_LY_CG_THFT_DISP_DESC,CRD.CT_E_CRTN_DT " +
		  " union " +
		  "SELECT NRD.RP_S_ID as cteNfseNumber,  'NFSe' as document, A.ORIGIN_LOCATION_CD as sourceFU, A.DEST_LOC_CD as destinationState, " + 
		  "NRD.RP_S_DT as issueDate, to_char(sum(distinct NPT.PROD_SVC_TOT_NBR)) as commodityValue, 'Ground' as transportType,  I.PAYR_TAX_ID as cnpj, " + 
		  "case when NTI.FGT_MODUL_NBR = '0' then NPE.ISS_CORP_NM when NTI.FGT_MODUL_NBR = '1' then NPE.DEST_CORP_NM ELSE 'others' END as company ,   " + 
		  "N.NF_SE_CD as sefazProtocol, NRD.STAT_DESC as sefazStatus, NRD.PROTO_NBR as atnProtocol, I.ERR_CMPLM_INFO_DESC as errorMsg, " + 
		  "I.PROTO_NBR as atnMPublicProtocol, I.CREATE_DT as atnMPublicProtocolCreatedDate, ICI.CA_LY_RD_FGT_FRWDR_DESC as civilResponsibility, ICI.CA_LY_CG_THFT_DISP_DESC as packageLost, NRD.RP_S_DT as atnProtocolCreatedDate " + 
		  " from match_ref_master mr " + 
		  " inner join match_ref_awb mawb on mr.isqn_mstr_cd = mawb.isqn_mstr_cd  " + 
		  " inner join awb_cust_master awb ON (mawb.awb_nbr = awb.awb_nbr)   " + 
		  " inner join awb_shipment_detail A ON (awb.isqn_mstr_cd = A.isqn_mstr_cd)  " + 
		  " inner join match_ref_nfe mnfe on mr.isqn_mstr_cd = mnfe.isqn_mstr_cd  " + 
		  " INNER JOIN NFE_IDENTITY_MASTER NIM ON mnfe.NT_FSCL_CD = NIM.NT_FSCL_CD  " + 
		  " INNER JOIN NFE_PARTICIPANT_DETAIL NPE  ON NIM.ISQN_MSTR_CD = NPE.ISQN_MSTR_CD " + 
		  " INNER JOIN NFE_PROD_TOTAL_INFO NPT ON NIM.ISQN_MSTR_CD = NPT.ISQN_MSTR_CD " + 
		  " INNER JOIN NFE_TRANSPORT_INFO NTI ON NIM.ISQN_MSTR_CD = NTI.ISQN_MSTR_CD " + 
		  " INNER JOIN NFSE_REQUEST_DETAIL N ON Mr.ISQN_MSTR_CD=N.ISQN_REF_CD   " + 
		  " INNER JOIN NFSE_RESPONSE_DETAIL NRD ON N.ISQN_MSTR_CD = NRD.ISQN_MSTR_CD  " + 
		  " LEFT JOIN INSURANCE_RESPONSE_INFO I ON (NRD.RP_S_ID=I.NF_SE_CD)  " + 
		  " LEFT JOIN INSURANCE_CUST_INFO ICI ON I.PAYR_TAX_ID = ICI.TAX_ID " + 
		  " WHERE (:AWB_NBR is null or A.AWB_NBR like '%'||(:AWB_NBR)||'%')   " + 
		  " and (NRD.STAT_DESC = 'Approved' or NRD.STAT_DESC = 'Cancelled')  " + 
		  " and (:ORIGIN_LOCATION_CD is null or lower(SUBSTR(A.ORIGIN_LOCATION_CD, 1, 3)) = lower(substr(:ORIGIN_LOCATION_CD,1,3)) )  " + 
		  " and (:CREATE_START_DT is null or :CREATE_END_DT is null or to_char(I.CREATE_DT, 'MM/DD/YYYY') between :CREATE_START_DT and :CREATE_END_DT) " + 
		  " and (:DEST_LOC_CD is null or upper(A.DEST_LOC_CD) like '%'||upper(:DEST_LOC_CD)||'%')  " + 
		  " and (:CTE_NFSE_CD is null or N.NF_SE_CD like '%'||(:CTE_NFSE_CD))  " + 
		  " and (:PROTO_NBR is null or upper(I.PROTO_NBR) like '%'||upper((:PROTO_NBR)||'%'))  " + 
		  " and (:DOC_TYP_ID is null or Mr.DOC_TYP_ID like '%'||(:DOC_TYP_ID)||'%')  " + 
		  " and (:INS_RESP_STAT_CD is null or upper(I.INS_RESP_STAT_CD) like '%'||upper(:INS_RESP_STAT_CD)||'%') " + 
		  " group by NRD.RP_S_ID, A.ORIGIN_LOCATION_CD, A.DEST_LOC_CD, NRD.RP_S_DT, I.PAYR_TAX_ID, NTI.FGT_MODUL_NBR,NPE.ISS_CORP_NM,NPE.DEST_CORP_NM," + 
		  "N.NF_SE_CD, NRD.STAT_DESC, NRD.PROTO_NBR, I.ERR_CMPLM_INFO_DESC, I.PROTO_NBR,I.CREATE_DT, ICI.CA_LY_RD_FGT_FRWDR_DESC,ICI.CA_LY_CG_THFT_DISP_DESC,NRD.RP_S_DT " )
			
@Getter
@Setter
public class MatchReference implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISQN_MSTR_CD")
	private Long msterMatchRefernceId;

	@Column(name = "REF_CD")
	private String referenceKey;

	@Column(name = "DOC_TYP_ID")
	private String docType;

	@Column(name = "MTCH_TYP_ID")
	private String matchType;

	@Column(name = "STTN_CD")
	private String originStationId;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "matchReferenceMaster")
	private List<MatchReferenceAWB> matchRefernceAWB;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "matchReferenceMaster")
	private List<MatchReferenceNFE> matchRefernceNfe;

	public Long getMsterMatchRefernceId() {
		return msterMatchRefernceId;
	}

	public void setMsterMatchRefernceId(Long msterMatchRefernceId) {
		this.msterMatchRefernceId = msterMatchRefernceId;
	}

	public String getReferenceKey() {
		return referenceKey;
	}

	public void setReferenceKey(String referenceKey) {
		this.referenceKey = referenceKey;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getOriginStationId() {
		return originStationId;
	}

	public void setOriginStationId(String originStationId) {
		this.originStationId = originStationId;
	}

	public List<MatchReferenceAWB> getMatchRefernceAWB() {
		return matchRefernceAWB;
	}

	public void setMatchRefernceAWB(List<MatchReferenceAWB> matchRefernceAWB) {
		this.matchRefernceAWB = matchRefernceAWB;
	}

	public List<MatchReferenceNFE> getMatchRefernceNfe() {
		return matchRefernceNfe;
	}

	public void setMatchRefernceNfe(List<MatchReferenceNFE> matchRefernceNfe) {
		this.matchRefernceNfe = matchRefernceNfe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
