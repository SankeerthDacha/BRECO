package com.fedex.breco.insurance.cte.model;

import java.io.Serializable;
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

// TODO: Auto-generated Javadoc
/**
 * The Class CteTransportInfo.
 */
@Entity
@Table(name="CTE_TRANSPORT_INFO")
public class CteTransportInfo implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cte participant id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CTE_TRPRT_SEQ")
	@SequenceGenerator(name = "CTE_TRPRT_SEQ", sequenceName = "CTE_TRPRT_SEQ", allocationSize=1)
	@Column(name="ISQN_CD", columnDefinition = "SEQUENCE GENERATED VALUE")
	private Long cteTransportId;
	
	/** The cte identity master. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = false)
	private CteIdentityMaster cteIdentityMaster;
	
	/** The cte code. */
	@Column(name = "CT_E_CD", columnDefinition = "CONHECIMENTO DE TRANSPORTE ELETRONICO")
	private String cteCode;
	
	/** The cte responsible person description. */
	@Column(name = "CT_E_RESP_PRSN_DESC", columnDefinition = "COMPL_XEMI")
	private String cteResponsiblePersonDescription;
	
	/** The destination city rate calculation info. */
	@Column(name = "DEST_CTY_IF_RTE_CALC_TXT", columnDefinition = "COMPL_DESTCALC")
	private String destinationCityRateCalculationInfo;
	
	/** The destination station internal code. */
	@Column(name = "DEST_STTN_INTR_CD", columnDefinition = "COMPL_FLUXO_XDEST")
	private String destinationStationInternalCode;
	
	/** The field content. */
	@Column(name = "FLD_CNTNT_DESC", columnDefinition = "COMPL_OBSCONT_XTEXTO")
	private String fieldContent;
	
	/** The field id. */
	@Column(name = "FLD_ID", columnDefinition = "COMPL_OBSCONT_XCAMPO")
	private String fieldId;
	
	/** The general comment. */
	@Column(name = "GENL_COM_TXT", columnDefinition = "COMPL_XOBS")
	private String generalComment;
	
	/** The hour type number. */
	@Column(name = "HR_TYP_NBR", columnDefinition = "COMPL_ENTREGA_SEMHORA_TPHOR")
	private String hourTypeNumber;
	
	/** The origin city rate calculation info. */
	@Column(name = "ORIG_CTY_IF_RTE_CALC_TXT", columnDefinition = "COMPL_ORIGCALC")
	private String originCityRateCalculationInfo;
	
	/** The origin station internal code. */
	@Column(name = "ORIG_STTN_INTR_CD", columnDefinition = "COMPL_FLUXO_XORIG")
	private String originStationInternalCode;
	
	/** The period type number. */
	@Column(name = "PERD_TYP_NBR", columnDefinition = "COMPL_ENTREGA_COMDATA_TPPER")
	private String periodTypeNumber;
	
	/** The pud route code. */
	@Column(name = "PUD_RTE_CD", columnDefinition = "COMPL_FLUXO_XROTA")
	private String pudRouteCode;
	
	/** The scheduled date. */
	@Column(name = "SCHD_DT", columnDefinition = "COMPL_ENTREGA_COMDATA_DPROG")
	private Date scheduledDate;
	
	/** The state tax calculation number. */
	@Column(name = "ST_TAX_CALC_VAL_NBR", columnDefinition = "IMP_ICMS_VBC")
	private String stateTaxCalculationNumber;
	
	/** The state tax code. */
	@Column(name = "ST_TAX_CD", columnDefinition = "IMP_ICMS_CST")
	private String stateTaxCode;
	
	/** The state tax group. */
	@Column(name = "ST_TAX_GRP_TXT", columnDefinition = "IMP_ICMS_GROUP")
	private String stateTaxGroup;
	
	/** The state tax rate. */
	@Column(name = "ST_TAX_RTE", columnDefinition = "IMP_ICMS_PICMS")
	private String stateTaxRate;
	
	/** The state tax value number. */
	@Column(name = "ST_TAX_VAL_NBR", columnDefinition = "IMP_ICMS_VICMS")
	private String stateTaxValueNumber;
	
	/** The service additional characteristic. */
	@Column(name = "SVC_ADDL_CHRST_TXT", columnDefinition = "COMPL_XCARACSER")
	private String serviceAdditionalCharacteristic;
	
	/** The transport additional characteristic. */
	@Column(name = "TRPRT_ADDL_CHRST_TXT", columnDefinition = "COMPL_XCARACAD")
	private String transportAdditionalCharacteristic;
	
	 /** The creation date. */
   @Column(name="CREATE_DT", columnDefinition = "CREATE_DT")
   private Date creationDate;
 
   /** The last modification date. */
   @Column(name="MODFY_DT", columnDefinition = "MODFY_DT")
   private Date lastModificationDate;

/**
 * Gets the cte transport id.
 *
 * @return the cte transport id
 */
public Long getCteTransportId() {
	return cteTransportId;
}

/**
 * Sets the cte transport id.
 *
 * @param cteTransportId the new cte transport id
 */
public void setCteTransportId(Long cteTransportId) {
	this.cteTransportId = cteTransportId;
}

/**
 * Gets the cte identity master.
 *
 * @return the cte identity master
 */
public CteIdentityMaster getCteIdentityMaster() {
	return cteIdentityMaster;
}

/**
 * Sets the cte identity master.
 *
 * @param cteIdentityMaster the new cte identity master
 */
public void setCteIdentityMaster(CteIdentityMaster cteIdentityMaster) {
	this.cteIdentityMaster = cteIdentityMaster;
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
 * Gets the cte responsible person description.
 *
 * @return the cte responsible person description
 */
public String getCteResponsiblePersonDescription() {
	return cteResponsiblePersonDescription;
}

/**
 * Sets the cte responsible person description.
 *
 * @param cteResponsiblePersonDescription the new cte responsible person description
 */
public void setCteResponsiblePersonDescription(String cteResponsiblePersonDescription) {
	this.cteResponsiblePersonDescription = cteResponsiblePersonDescription;
}

/**
 * Gets the destination city rate calculation info.
 *
 * @return the destination city rate calculation info
 */
public String getDestinationCityRateCalculationInfo() {
	return destinationCityRateCalculationInfo;
}

/**
 * Sets the destination city rate calculation info.
 *
 * @param destinationCityRateCalculationInfo the new destination city rate calculation info
 */
public void setDestinationCityRateCalculationInfo(String destinationCityRateCalculationInfo) {
	this.destinationCityRateCalculationInfo = destinationCityRateCalculationInfo;
}

/**
 * Gets the destination station internal code.
 *
 * @return the destination station internal code
 */
public String getDestinationStationInternalCode() {
	return destinationStationInternalCode;
}

/**
 * Sets the destination station internal code.
 *
 * @param destinationStationInternalCode the new destination station internal code
 */
public void setDestinationStationInternalCode(String destinationStationInternalCode) {
	this.destinationStationInternalCode = destinationStationInternalCode;
}

/**
 * Gets the field content.
 *
 * @return the field content
 */
public String getFieldContent() {
	return fieldContent;
}

/**
 * Sets the field content.
 *
 * @param fieldContent the new field content
 */
public void setFieldContent(String fieldContent) {
	this.fieldContent = fieldContent;
}

/**
 * Gets the field id.
 *
 * @return the field id
 */
public String getFieldId() {
	return fieldId;
}

/**
 * Sets the field id.
 *
 * @param fieldId the new field id
 */
public void setFieldId(String fieldId) {
	this.fieldId = fieldId;
}

/**
 * Gets the general comment.
 *
 * @return the general comment
 */
public String getGeneralComment() {
	return generalComment;
}

/**
 * Sets the general comment.
 *
 * @param generalComment the new general comment
 */
public void setGeneralComment(String generalComment) {
	this.generalComment = generalComment;
}

/**
 * Gets the hour type number.
 *
 * @return the hour type number
 */
public String getHourTypeNumber() {
	return hourTypeNumber;
}

/**
 * Sets the hour type number.
 *
 * @param hourTypeNumber the new hour type number
 */
public void setHourTypeNumber(String hourTypeNumber) {
	this.hourTypeNumber = hourTypeNumber;
}

/**
 * Gets the origin city rate calculation info.
 *
 * @return the origin city rate calculation info
 */
public String getOriginCityRateCalculationInfo() {
	return originCityRateCalculationInfo;
}

/**
 * Sets the origin city rate calculation info.
 *
 * @param originCityRateCalculationInfo the new origin city rate calculation info
 */
public void setOriginCityRateCalculationInfo(String originCityRateCalculationInfo) {
	this.originCityRateCalculationInfo = originCityRateCalculationInfo;
}

/**
 * Gets the origin station internal code.
 *
 * @return the origin station internal code
 */
public String getOriginStationInternalCode() {
	return originStationInternalCode;
}

/**
 * Sets the origin station internal code.
 *
 * @param originStationInternalCode the new origin station internal code
 */
public void setOriginStationInternalCode(String originStationInternalCode) {
	this.originStationInternalCode = originStationInternalCode;
}

/**
 * Gets the period type number.
 *
 * @return the period type number
 */
public String getPeriodTypeNumber() {
	return periodTypeNumber;
}

/**
 * Sets the period type number.
 *
 * @param periodTypeNumber the new period type number
 */
public void setPeriodTypeNumber(String periodTypeNumber) {
	this.periodTypeNumber = periodTypeNumber;
}

/**
 * Gets the pud route code.
 *
 * @return the pud route code
 */
public String getPudRouteCode() {
	return pudRouteCode;
}

/**
 * Sets the pud route code.
 *
 * @param pudRouteCode the new pud route code
 */
public void setPudRouteCode(String pudRouteCode) {
	this.pudRouteCode = pudRouteCode;
}

/**
 * Gets the scheduled date.
 *
 * @return the scheduled date
 */
public Date getScheduledDate() {
	return scheduledDate;
}

/**
 * Sets the scheduled date.
 *
 * @param scheduledDate the new scheduled date
 */
public void setScheduledDate(Date scheduledDate) {
	this.scheduledDate = scheduledDate;
}

/**
 * Gets the state tax calculation number.
 *
 * @return the state tax calculation number
 */
public String getStateTaxCalculationNumber() {
	return stateTaxCalculationNumber;
}

/**
 * Sets the state tax calculation number.
 *
 * @param stateTaxCalculationNumber the new state tax calculation number
 */
public void setStateTaxCalculationNumber(String stateTaxCalculationNumber) {
	this.stateTaxCalculationNumber = stateTaxCalculationNumber;
}

/**
 * Gets the state tax code.
 *
 * @return the state tax code
 */
public String getStateTaxCode() {
	return stateTaxCode;
}

/**
 * Sets the state tax code.
 *
 * @param stateTaxCode the new state tax code
 */
public void setStateTaxCode(String stateTaxCode) {
	this.stateTaxCode = stateTaxCode;
}

/**
 * Gets the state tax group.
 *
 * @return the state tax group
 */
public String getStateTaxGroup() {
	return stateTaxGroup;
}

/**
 * Sets the state tax group.
 *
 * @param stateTaxGroup the new state tax group
 */
public void setStateTaxGroup(String stateTaxGroup) {
	this.stateTaxGroup = stateTaxGroup;
}

/**
 * Gets the state tax rate.
 *
 * @return the state tax rate
 */
public String getStateTaxRate() {
	return stateTaxRate;
}

/**
 * Sets the state tax rate.
 *
 * @param stateTaxRate the new state tax rate
 */
public void setStateTaxRate(String stateTaxRate) {
	this.stateTaxRate = stateTaxRate;
}

/**
 * Gets the state tax value number.
 *
 * @return the state tax value number
 */
public String getStateTaxValueNumber() {
	return stateTaxValueNumber;
}

/**
 * Sets the state tax value number.
 *
 * @param stateTaxValueNumber the new state tax value number
 */
public void setStateTaxValueNumber(String stateTaxValueNumber) {
	this.stateTaxValueNumber = stateTaxValueNumber;
}

/**
 * Gets the service additional characteristic.
 *
 * @return the service additional characteristic
 */
public String getServiceAdditionalCharacteristic() {
	return serviceAdditionalCharacteristic;
}

/**
 * Sets the service additional characteristic.
 *
 * @param serviceAdditionalCharacteristic the new service additional characteristic
 */
public void setServiceAdditionalCharacteristic(String serviceAdditionalCharacteristic) {
	this.serviceAdditionalCharacteristic = serviceAdditionalCharacteristic;
}

/**
 * Gets the transport additional characteristic.
 *
 * @return the transport additional characteristic
 */
public String getTransportAdditionalCharacteristic() {
	return transportAdditionalCharacteristic;
}

/**
 * Sets the transport additional characteristic.
 *
 * @param transportAdditionalCharacteristic the new transport additional characteristic
 */
public void setTransportAdditionalCharacteristic(String transportAdditionalCharacteristic) {
	this.transportAdditionalCharacteristic = transportAdditionalCharacteristic;
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
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return "CteTransportInfo [cteTransportId=" + cteTransportId + ", cteIdentityMaster=" + cteIdentityMaster
			+ ", cteCode=" + cteCode + ", cteResponsiblePersonDescription=" + cteResponsiblePersonDescription
			+ ", destinationCityRateCalculationInfo=" + destinationCityRateCalculationInfo
			+ ", destinationStationInternalCode=" + destinationStationInternalCode + ", fieldContent=" + fieldContent
			+ ", fieldId=" + fieldId + ", generalComment=" + generalComment + ", hourTypeNumber=" + hourTypeNumber
			+ ", originCityRateCalculationInfo=" + originCityRateCalculationInfo + ", originStationInternalCode="
			+ originStationInternalCode + ", periodTypeNumber=" + periodTypeNumber + ", pudRouteCode=" + pudRouteCode
			+ ", scheduledDate=" + scheduledDate + ", stateTaxCalculationNumber=" + stateTaxCalculationNumber
			+ ", stateTaxCode=" + stateTaxCode + ", stateTaxGroup=" + stateTaxGroup + ", stateTaxRate=" + stateTaxRate
			+ ", stateTaxValueNumber=" + stateTaxValueNumber + ", serviceAdditionalCharacteristic="
			+ serviceAdditionalCharacteristic + ", transportAdditionalCharacteristic="
			+ transportAdditionalCharacteristic + ", creationDate=" + creationDate + ", lastModificationDate="
			+ lastModificationDate + "]";
}
	
   
}
